/**
 * LoginServiceImpl.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.shdatabank.puruan.dao.LoginDao;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.EmailAuth;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserBehavior;
import com.shdatabank.puruan.service.LoginService;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 前后台用户登录service层
 * 1.后台用户登录验证并返回用户信息
 * 2.获取用户当天登录的次数
 * 3.判断用户名是否正确
 * 4.插入用户日志信息
 * 5.判断前台用户名是否正确
 * 6.前台用户登录验证并返回用户信息
 */
@Service
public class LoginServiceImpl implements LoginService{

    /** 前后台用户登录dao */
    @Autowired
    private LoginDao loginDao;
    /**
     * 后台用户登录操作
     * @backUser 后台用户
     */
    @Override
    public BackUser selectBackUser(BackUser backUser) throws Exception {
        // TODO Auto-generated method stub
        //将密码加密
        backUser.setUserPwd(UserUtil.stringMD5(backUser.getUserPwd()));
        backUser.setActive(SystemConstant.DELETE_ACTIVE_TRUE);
        //根据用户名和用户密码判断用户登录是否正确
        backUser = loginDao.selectBackUser(backUser);
        if (null != backUser) {
            //根据用户id取得用户的权限id
            backUser.setBackUserRoles(loginDao.selectBackUserRole(backUser.getUserId(),SystemConstant.DELETE_ACTIVE_TRUE));
        }
        
        return backUser;
    }
    
    

    /**
     * 获取用户当天登录的次数
     * @userId 用户id
     * @logStatus 用户状态
     * @logType 用户类型
     * @return 用户count
     */
    @Override
    public Integer selectUserBehaviorCount(Long userId,String logStatus,String logType) throws Exception {
        // TODO Auto-generated method stub
        return loginDao.selectUserBehaviorCount(userId,logStatus,logType);
    }

    /**
     * 判断用户名是否正确
     * @param userName 用户名
     * @return 后台用户id
     */
    @Override
    public Integer selectBackUserName(String userName) throws Exception {
        // TODO Auto-generated method stub
        return loginDao.selectBackUserName(userName);
    }

    /**
     * 插入用户日志信息
     * @param userBehavior 用户日志
     */
    @Override
    public void insertUserBehavior(UserBehavior userBehavior) throws Exception {
        // TODO Auto-generated method stub
        loginDao.insertUserBehavior(userBehavior);        
    }

    /**
     * 判断前台用户名是否正确
     * @param userName 前台用户名
     * @return 前台用户id
     */
    @Override
    public Long selectUserName(String userName) throws Exception {
        // TODO Auto-generated method stub
        return loginDao.selectUserName(userName);
    }

    /**
     * 前台用户登录验证并返回用户信息
     * @param user 前台用户的用户名和密码
     * @return 前台用户的信息
     */
    @Override
    public User selectUser(User user) throws Exception {
        // TODO Auto-generated method stub
        //将密码加密
        user.setUserPwd(UserUtil.stringMD5(user.getUserPwd()));
        user.setActive(SystemConstant.DELETE_ACTIVE_TRUE);
        //根据用户名和用户密码判断用户登录是否正确
        user = loginDao.selectUser(user);
        return user;
    }
    /**
     * 前台用户登录验证并返回用户信息
     * @param user 前台用户的用户名和密码
     * @return 前台用户的信息
     */
    public User selectUserRealm(User user) throws Exception {
        //将密码加密       
        user.setActive(SystemConstant.DELETE_ACTIVE_TRUE);
        //根据用户名和用户密码判断用户登录是否正确
        user = loginDao.selectUser(user);
        return user;
    }

    /**
     * 用户注册
     * @param user
     * @return 前台用户的信息
     */
	@Override
	public boolean register(User user) throws Exception {
		
		//从数据库中查询用户名
		String userName = loginDao.compareUserName(user.getUserName());
		if(userName != null){
			return false;
		}
		//从数据库中查询邮箱
		String userEmail = loginDao.compareUserEmail(user.getUserEmail());
		if(userEmail != null){
			return false;
		}
		//转换md5
		user.setUserPwd(DigestUtils.md5DigestAsHex(user.getUserPwd().getBytes()));

		//添加到数据库
		int count = loginDao.register(user);
		// 注册成功
		if (0 == count) {
			return false;
		}
		return true;
	}

	 /**
     * 保存验证信息
     * @param emailAuth 验证信息
     */
    @Override
    public void insertEmailAuth(EmailAuth emailAuth) throws Exception {
    	 loginDao.insertEmailAuth(emailAuth);
    }

    /**
     * 验证信息
     * @param emailAuth 验证信息
     * @return 验证信息
     */
    @Override
    public EmailAuth selectEmailAuth(EmailAuth emailAuth) throws Exception {
        return loginDao.selectEmailAuth(emailAuth);
    }

    /**
     * 删除信息
     * @param emailAuth
     */
    @Override
    public void deleteEmailAuth(EmailAuth emailAuth) throws Exception {
    	loginDao.deleteEmailAuth(emailAuth);
    }

    /**
  	 * 通过用户ID查找用户
  	 * 
  	 * @param userId
  	 */
	@Override
	public String UserName(long userId) throws Exception {
		return loginDao.UserName(userId);
	}

	/**
	 * 通过用户名查找用户对象
	 * 
	 * @param userName
	 * @return
	 */
	@Override
	public User user(String userName) throws Exception {
		return loginDao.user(userName);
	}

	/**
	 * 通过用户名修改验证状态
	 * 
	 * @param emailAuth
	 * @return 
	 */
	@Override
	public void updateUser(String userName) throws Exception {
		loginDao.updateUser(userName);
	}


}
