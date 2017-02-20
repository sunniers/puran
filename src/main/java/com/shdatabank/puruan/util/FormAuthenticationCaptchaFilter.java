package com.shdatabank.puruan.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class FormAuthenticationCaptchaFilter extends FormAuthenticationFilter{
	private Logger logger = Logger.getLogger(FormAuthenticationCaptchaFilter.class);
	
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, DEFAULT_CAPTCHA_PARAM);
	}

	protected AuthenticationToken createToken(ServletRequest request,ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);
		return new UsernamePasswordToken(username, password, rememberMe, host);
	}
	/**
	 * 重写登录地址
	 */
	@Override
	protected void redirectToLogin(ServletRequest request,ServletResponse response) throws IOException {
		String loginUrl = getLoginUrl();
		loginUrl += "&loginType=json";
		logger.trace("loginUrl" + loginUrl);
		WebUtils.issueRedirect(request, response, loginUrl);
	}
	
	/*
	 * 主要是针对登入成功的处理方法。对于请求头是AJAX的之间返回JSON字符串。
	 */
	@Override
	public boolean onLoginSuccess(AuthenticationToken token, Subject subject,ServletRequest request, ServletResponse response) throws Exception {
		if (!isAjax(request)) {// 不是ajax请求
			issueSuccessRedirect(request, response);
		} else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("{\"success\":true,\"message\":\"登入成功\"}");
			out.flush();
			out.close();
		}
		return false;
	}

	/**
	 * 主要是处理登入失败的方法
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,AuthenticationException e, ServletRequest request,ServletResponse response) {
		if (!isAjax(request)) {// 不是ajax请求
			setFailureAttribute(request, e);
			return true;
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			String message = e.getClass().getSimpleName();
			if ("IncorrectCredentialsException".equals(message)) {
				out.println("{\"success\":false,\"message\":\"密码错误\"}");
			} else if ("UnknownAccountException".equals(message)) {
				out.println("{\"success\":false,\"message\":\"账号不存在\"}");
			} else if ("LockedAccountException".equals(message)) {
				out.println("{\"success\":false,\"message\":\"账号被锁定\"}");
			} else {
				out.println("{\"success\":false,message:\"未知错误\"}");
			}
			out.flush();
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	/**
	 * 所有请求都会经过的方法。
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,ServletResponse response) throws Exception {
		if (!isAjax(request)) {// 不是ajax请求
			if (isLoginRequest(request, response)) {
				if (isLoginSubmission(request, response)) {
					return executeLogin(request, response);
				} else {
					return true;
				}
			} else {
				saveRequestAndRedirectToLogin(request, response);
			}
		} else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain;charset=utf-8");
			HttpServletResponse rep = (HttpServletResponse) response;
			rep.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
			rep.getWriter().write("{\"noaccess\":true,\"success\":false,\"message\":\"请求超时，请重新登录\"}");
		}
		return false;
	}

	private boolean isAjax(ServletRequest request) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		return "XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"));
	}

	
}