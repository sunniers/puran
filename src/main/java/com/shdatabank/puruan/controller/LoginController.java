/**
 * LoginController.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserBehavior;
import com.shdatabank.puruan.service.LoginService;
import com.shdatabank.puruan.util.DesUtil;
import com.shdatabank.puruan.util.ParamFileUtil;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 前后台用户登录controller层
 * 1.后台用户登录
 * 2.前台用户登录
 */
@RequestMapping(value="/login")
@Controller
public class LoginController {
    
    /** 前后台用户登录service */
    @Autowired
    private LoginService loginService;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /** 用户名错误 */
    private static final String USERNAME_ERROR = "用户名错误，请重新输入！";
    
    /** 登录次数限制错误 */
    private static final String LOGIN_COUNTS_ERROR = "登录次数超过3次，请明天登录！";
    
    /** 密码错误 */
    private static final String PASSWORD_ERROR = "密码错误，请重新输入！";
    /**用户名不能为空*/
    private static final String USERNAME_NOT_EMPTY = "用户名不能为空";
    /**用户密码不能为空*/
    private static final String USERPWD_NOT_EMPTY = "用户密码不能为空";
    /**用户名已存在*/
    private static final String USERNAME_EXISTING = "用户名已存在";
    
    /**
     * 后台用户登录
     * @param backUser 后台用户实体类
     * @return 返回结果对象
     */
    @RequestMapping(value="/backUserLogin",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject backUserLogin(@RequestBody BackUser backUser) throws Exception {
        //根据用户名获取用户id
        Integer userId = loginService.selectBackUserName(backUser.getUserName());
        //判断用户id是否存在，存在则用户存在，不存在则用户不存在
        if (null == userId) {
            return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR,USERNAME_ERROR);
        } else {
            //将ID放到用户信息中
            backUser.setUserId(userId);
            //查询该用户当天的登录失败的次数
            Integer count = loginService.selectUserBehaviorCount(userId.longValue(),SystemConstant.NORMAL_ERROR,
                    SystemConstant.BACK);
            //如果大于3，返回错误信息
            if (count >= 3) {
                return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR,LOGIN_COUNTS_ERROR);
            }
            //进入判断用户是否登录成功
            backUser = loginService.selectBackUser(backUser);
            if (null != backUser) {
                //声明一个用户日志
                UserBehavior userBehavior = new UserBehavior();
                //插入值
                userBehavior.setUserId(userId.longValue());
                userBehavior.setLogDatetime(new Timestamp(new Date().getTime()));
                userBehavior.setLogType(SystemConstant.BACK);
                userBehavior.setLogStatus(SystemConstant.SUCCESS);
                //将用户日志插入到数据库表中
                loginService.insertUserBehavior(userBehavior);
                //将用户信息放到缓存中
                httpServletRequest.getSession().setAttribute("backUser", backUser);
                return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",backUser);
            } else {
                //声明一个用户日志
                UserBehavior userBehavior = new UserBehavior();
                //插入值
                userBehavior.setUserId(userId.longValue());
                userBehavior.setLogDatetime(new Timestamp(new Date().getTime()));
                userBehavior.setLogType(SystemConstant.BACK);
                userBehavior.setLogStatus(SystemConstant.NORMAL_ERROR);
                //将用户日志插入到数据库表中
                loginService.insertUserBehavior(userBehavior);
                return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR,PASSWORD_ERROR);
            }
        }
    }
    
    /**
     * 前台用户登录
     * @param user 前台用户实体类
     * @return 返回结果对象
     */
    @RequestMapping(value="/userLogin",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject userLogin(@RequestBody User user) throws Exception {
        //根据用户名获取用户id
        Long userId = loginService.selectUserName(user.getUserName());
        if (null == userId) {
            return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR,USERNAME_ERROR);
        } else {
            //将ID放到用户信息中
            user.setUserId(userId);
            //查询该用户当天的登录失败的次数
            Integer count = loginService.selectUserBehaviorCount(userId,SystemConstant.NORMAL_ERROR,
                    SystemConstant.PECEPTION);
            //如果大于3，返回错误信息
            if (count >= 3) {
                return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR,LOGIN_COUNTS_ERROR);
            }
            //进入判断用户是否登录成功
            user = loginService.selectUser(user);
            if (null != user) {
                //声明一个用户日志
                UserBehavior userBehavior = new UserBehavior();
                //插入值
                userBehavior.setUserId(userId.longValue());
                userBehavior.setLogDatetime(new Timestamp(new Date().getTime()));
                userBehavior.setLogType(SystemConstant.PECEPTION);
                userBehavior.setLogStatus(SystemConstant.SUCCESS);
                //将用户日志插入到数据库表中
                loginService.insertUserBehavior(userBehavior);
                //将用户信息放到缓存中
                httpServletRequest.getSession().setAttribute("user", user);
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPwd());  
                token.setRememberMe(true);  
                Subject subject = SecurityUtils.getSubject();  
                subject.login(token);
                return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",user);
            } else {
                //声明一个用户日志
                UserBehavior userBehavior = new UserBehavior();
                //插入值
                userBehavior.setUserId(userId.longValue());
                userBehavior.setLogDatetime(new Timestamp(new Date().getTime()));
                userBehavior.setLogType(SystemConstant.PECEPTION);
                userBehavior.setLogStatus(SystemConstant.NORMAL_ERROR);
                //将用户日志插入到数据库表中
                loginService.insertUserBehavior(userBehavior);
                return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR,PASSWORD_ERROR);
            }
        }
    }
    /**
     * 注册用户
     * @param user
     * @return
     * @throws Exception 
     */
    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
	public ReturnObject register(@RequestBody User user) throws Exception {
    	//有效性验证
		if (StringUtils.isBlank(user.getUserName())) {
			return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, USERNAME_NOT_EMPTY);
		}
		if (StringUtils.isBlank(user.getUserPwd())) {
			return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, USERPWD_NOT_EMPTY);
		}
    	boolean falg = loginService.register(user);
    	if (falg == false) {
    		return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
    	} 
    	//生成随机id
//    	User user2 = (User) register.getRetObject();
//    	long id = user2.getUserId();
//    	String randName = UserUtil.getRandName();
//    	long id = Long.parseLong(randName);
    	//发送邮箱验证
    	UserUtil.sendEmail(user.getUserName(),user.getUserEmail(),SystemConstant.LOGIN_PATH);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
	}
    /**
     * 重新发送
     * @param user
     * @return
     * @throws Exception 
     */
    @RequestMapping(value="/resend", method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject resend(@RequestBody User user) throws Exception {
    	User user2 = loginService.user(user.getUserName());
    	//发送邮箱验证
    	UserUtil.sendEmail(user2.getUserName(),user2.getUserEmail(),SystemConstant.LOGIN_PATH);
    	return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }
  
    /**
     * 验证邮箱
     * @param request
     * @param response
     * @return 返回结果对象
     */
    @RequestMapping(value="/emailVerification", method=RequestMethod.GET)
    @ResponseBody
	public ReturnObject emailVerification(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 解密参数
		//String sid = UserUtil.convertMD5(request.getParameter("sid"));
    	//request.getParameter("sid").toString()
    	String sid = DesUtil.decrypt(request.getQueryString().substring(0).substring(4),"wang11111");
		// 以#号分割
		String sids[] = sid.split("#");
		// 判断浦软id
		if (!ParamFileUtil.getConfigProperty("config", "emailPuruanId").equals(sids[0])) {
			return RetObjectBuilder.generateRetObject(SystemConstant.CHECK_ERROR, SystemConstant.CHECK_ERROR_MSG);
		}
		User user = loginService.user(sids[1]);
		if(user == null){
			return RetObjectBuilder.generateRetObject(SystemConstant.CHECK_ERROR, SystemConstant.CHECK_ERROR_MSG);
		}
		if(new Date().getTime() > Long.parseLong(sids[3])+1000*60*60*24){
			return RetObjectBuilder.generateRetObject(SystemConstant.CHECK_ERROR, SystemConstant.CHECK_ERROR_MSG);
		}
		 httpServletRequest.getSession().setAttribute("user", user);
		 String userName =user.getUserName();
		 loginService.updateUser(userName);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
	}
    
}
