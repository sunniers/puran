/**
 * LoginDao.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.BackUserRole;
import com.shdatabank.puruan.model.EmailAuth;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserBehavior;

/**
 * 用户登录dao层 1.后台用户登录验证并返回用户信息 2.根据后台用户的id查询后台用户的权限 3.插入用户日志信息 4.获取用户当天登录的次数
 * 5.判断后台用户名是否正确 6.判断前台用户名是否正确 7.前台用户登录验证并返回用户信息
 */
public interface LoginDao {

	/**
	 * 后台用户登录验证并返回用户信息
	 * 
	 * @param backUser
	 *            后台用户名和密码
	 * @return 后台用户信息
	 */
	public BackUser selectBackUser(BackUser backUser) throws Exception;

	/**
	 * 根据userId查询用户权限
	 * 
	 * @param userId
	 *            用户id
	 * @return 用户的权限id
	 */
	public List<BackUserRole> selectBackUserRole(Integer userId, Byte active) throws Exception;

	/**
	 * 插入用户日志信息
	 * 
	 * @param userBehavior
	 *            用户日志
	 */
	public void insertUserBehavior(UserBehavior userBehavior) throws Exception;

	/**
	 * 获取用户当天登录的次数
	 * 
	 * @param userId
	 *            用户id
	 * @return 返回当天用户登录的次数
	 */
	public Integer selectUserBehaviorCount(Long userId, String logStatus, String logType) throws Exception;

	/**
	 * 判断后台用户名是否正确
	 * 
	 * @param userName
	 *            后台用户名
	 * @return 后台用户id
	 */
	public Integer selectBackUserName(String userName) throws Exception;

	/**
	 * 判断前台用户名是否正确
	 * 
	 * @param userName
	 *            前台用户名
	 * @return 前台用户id
	 */
	public Long selectUserName(String userName) throws Exception;

	/**
	 * 前台用户登录验证并返回用户信息
	 * 
	 * @param user
	 *            前台用户的用户名和密码
	 * @return 前台用户的信息
	 */
	public User selectUser(User user) throws Exception;

	/**
	 * 用户注册
	 * 
	 * @param user
	 */
	public Integer register(User user) throws Exception;

	/**
	 * 判断用户名是否已存在
	 * 
	 * @param userName
	 * @return
	 */
	public String compareUserName(String userName) throws Exception;
	/**
	 * 通过用户名查找用户对象
	 * 
	 * @param userName
	 * @return
	 */
	public User user(String userName) throws Exception;

	 /**
	  * 判断邮箱是否已存在
	  *
	  * @param userName
	  * @return
	  */
	 public String compareUserEmail(String userEmail);

	/**
	 * 保存验证信息
	 * 
	 * @param emailAuth
	 *            验证信息
	 */
	public void insertEmailAuth(EmailAuth emailAuth) throws Exception;

	/**
	 * 验证信息
	 * 
	 * @param emailAuth
	 *            验证信息
	 * @return 验证信息
	 */
	public EmailAuth selectEmailAuth(EmailAuth emailAuth) throws Exception;

	/**
	 * 删除信息
	 * 
	 * @param emailAuth
	 */
	public void deleteEmailAuth(EmailAuth emailAuth) throws Exception;

	/**
	 * 通过用户ID查找用户
	 * 
	 * @param emailAuth
	 * @return 
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
