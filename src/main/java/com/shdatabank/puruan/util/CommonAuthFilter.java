package com.shdatabank.puruan.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * Created by lt on 2016/8/3.
 * 权限过虑
 */
public class CommonAuthFilter extends AuthorizationFilter {
	
    public CommonAuthFilter(){

    }

    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse,
    		Object mappedValue) throws Exception {
        String requestURI = WebUtils.getPathWithinApplication(WebUtils.toHttp(servletRequest));
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
		if(requestURI.contains("/s/login/userLogin")){
			return true;
		}
		Subject subject = this.getSubject(servletRequest, servletResponse);
		if(subject != null && subject.isAuthenticated()){
			httpResponse.setHeader("urlType", "123");
			return true;
		}
        if(requestURI.contains("front")){
        	httpResponse.setHeader("urlType", "front");
        }
        else{
        	httpResponse.setHeader("urlType", "back");
        }       
        
		System.out.println("success");		
       
        String[] rolesArray = (String[]) mappedValue;
        if (rolesArray == null || rolesArray.length == 0) {
			// no roles specified, so nothing to check - allow access.
			return true;
		}
        
        List<String> roles = Arrays.asList(rolesArray);
		for (String role : roles) {
			if (subject.hasRole(role)) {
				return true;
			}
		}	
		
        return false;
        //return subject.isPermitted(requestURI);
    }
    
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		System.out.println("测试.....");
		Subject subject = getSubject(request, response);
		
		if (subject.getPrincipal() == null) {
			saveRequestAndRedirectToLogin(request, response);
		} else {
			saveRequestAndRedirectToLogin(request, response);
			/*
			if (com.silvery.utils.WebUtils.isAjax(httpRequest)) {
				com.silvery.utils.WebUtils.sendJson(httpResponse, JsonUtils.toJSONString(new ViewResult(false,
						"您没有足够的权限执行该操作!")));
			} else {
				String unauthorizedUrl = getUnauthorizedUrl();
				if (StringUtils.hasText(unauthorizedUrl)) {
					WebUtils.issueRedirect(request, response, unauthorizedUrl);
				} else {
					WebUtils.toHttp(response).sendError(401);
				}
			}*/
		}
		return false;
	}
    
}