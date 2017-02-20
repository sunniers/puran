/**
 * ModifyPwdDao.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.User;

/**
 * 修改前后台用户密码dao层
 * 1.验证后台旧密码是否正确
 * 2.更新后台新密码
 * 3.验证前台旧密码是否正确
 * 4.更新前台新密码
 */
public interface ModifyPwdDao {

    /**
     * 验证后台旧密码是否正确
     * @param backUser 用户名和密码
     * @return 用户count
     */
    public Integer selectBackUserOldPwd(BackUser backUser);
    
    /**
     * 更新后台新密码
     * @param backUser 用户名和新密码
     */
    public int updateBackUserNewPwd(BackUser backUser);
    
    /**
     * 验证前台旧密码是否正确
     * @param user 用户名和密码
     * @return 用户count
     */
    public Integer selectUserOldPwd(User user);
    
    /**
     * 更新前台新密码
     * @param user 用户名和新密码
     */
    public int updateUserNewPwd(User user);
}
