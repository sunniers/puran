/**
 * IFindPwdService.java
 * Created at 2016-10-20
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.VerficationRequest;

/**
 * 忘记密码service层
 * 1.判断用户是否存在
 * 2.更新用户密码
 */
public interface IFindPwdService {

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
    public boolean updateUserPwd(User user) throws Exception;
    
    /**
     * 校验验证码
     * @return 返回发送是否成功
     */
    public boolean  verification(VerficationRequest verficationRequest) throws Exception;
    
 
}
