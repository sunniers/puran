/**
 * IEmailVerificationDao.java
 * Created at 2016-10-20
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import com.shdatabank.puruan.model.EmailAuth;

/**
 * 验证邮箱dao层
 */
public interface IEmailVerificationDao {

    /**
     * 保存验证信息
     * @param emailAuth 验证信息
     */
    public int insertEmailAuth(EmailAuth emailAuth) throws Exception;
    
    /**
     * 验证信息
     * @param emailAuth 验证信息
     * @return 验证信息
     */
    public EmailAuth selectEmailAuth(EmailAuth emailAuth) throws Exception;
    
    /**
     * 删除信息
     * @param emailAuth
     */
    public int deleteEmailAuth(EmailAuth emailAuth) throws Exception;
}
