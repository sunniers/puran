/**
 * LoginService.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.EmailAuth;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserBehavior;


/**
 * 前后台用户登录service层
 * 1.后台用户登录验证并返回用户信息
 * 2.获取用户当天登录的次数
 * 3.判断用户名是否正确
 * 4.插入用户日志信息
 * 5.判断前台用户名是否正确
 * 6.前台用户登录验证并返回用户信息
 */
public interface LoginService {

    /**
     * 后台用户登录验证并返回用户信息
     * @param backUser 后台用户名和密码
     * @return 后台用户信息
     */
    public BackUser selectBackUser(BackUser backUser) throws Exception;
    
    /**
     * 获取用户当天登录的次数
     * @param userId 用户id
     * @return 返回当天用户登录的次数
     */
    public Integer selectUserBehaviorCount(Long userId,String logStatus,String logType) throws Exception;
    
    /**
     * 判断用户名是否正确
     * @param userName 用户名
     * @return 用户id
     */
    public Integer selectBackUserName(String userName) throws Exception;
    
    /**
     * 插入用户日志信息
     * @param userBehavior 用户日志
     */
    public void insertUserBehavior(UserBehavior userBehavior) throws Exception;
    
    /**
     * 判断前台用户名是否正确
     * @param userName 前台用户名
     * @return 前台用户id
     */
    public Long selectUserName(String userName) throws Exception;
    
    /**
     * 前台用户登录验证并返回用户信息
     * @param user 前台用户的用户名和密码
     * @return 前台用户的信息
     */
    public User selectUser(User user) throws Exception;
    
    public User selectUserRealm(User user) throws Exception;
    /**
     * 用户注册
     * @param user
     * @return 
     */
    public boolean register(User user) throws Exception;

    /**
     * 保存验证信息
     * @param emailAuth 验证信息
     * @return 
     */
    public void insertEmailAuth(EmailAuth emailAuth) throws Exception;
    
    /**
     * 验证信息
     * @param emailAuth 验证信息
     * @return 验证信息
     */
    public EmailAuth selectEmailAuth(EmailAuth emailAuth) throws Exception;
    
	/**
	 * 通过用户名查找用户对象
	 * 
	 * @param userName
	 * @return
	 */
	public User user(String userName) throws Exception;
    
    /**
     * 删除信息
     * @param emailAuth
     */
    public void deleteEmailAuth(EmailAuth emailAuth) throws Exception;
    /**
	 * 通过用户ID查找用户
	 * 
	 * @param userId
	 */
	public String UserName(long userId) throws Exception;
	/**
	 * 通过用户名修改验证状态
	 * 
	 * @param emailAuth
	 * @return 
	 */
	public void updateUser(String userName) throws Exception;
}
