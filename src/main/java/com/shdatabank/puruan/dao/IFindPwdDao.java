/**
 * IFindPwdDao.java
 * Created at 2016-10-20
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import com.shdatabank.puruan.model.User;

/**
 * 忘记密码dao层
 * 1.判断用户是否存在
 * 2.更新用户密码
 */
public interface IFindPwdDao {

    /**
     * 判断用户是否存在
     * @param user 用户信息
     * @return 用户信息
     */
    public User selectUserCount(User user) throws Exception;
    
    /**
     * 更新用户密码
     * @param user 用户信息
     */
    public int updateUserPwd(User user) throws Exception;
    
    /**
	 * 根据用户名修改认证手机号
	 * @return 结果对象集合
	 */
	public boolean updateVerificationUserphone(User user);
    
    
}
