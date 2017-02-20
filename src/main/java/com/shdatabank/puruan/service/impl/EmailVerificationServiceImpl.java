/**
 * ShowBackIndexController.java
 * Created at 2016-10-20
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shdatabank.puruan.dao.IEmailVerificationDao;
import com.shdatabank.puruan.model.EmailAuth;
import com.shdatabank.puruan.service.IEmailVerificationService;

/**
 * 验证邮箱service层
 */
@Service
public class EmailVerificationServiceImpl implements IEmailVerificationService {

    /** 验证邮箱dao */
    @Autowired
    private IEmailVerificationDao iEmailVerificationDao;
    
    /**
     * 保存验证信息
     * @param emailAuth 验证信息
     */
    @Override
    public boolean insertEmailAuth(EmailAuth emailAuth) throws Exception {      
        int count = iEmailVerificationDao.insertEmailAuth(emailAuth);
        if (0 == count) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 验证信息
     * @param emailAuth 验证信息
     * @return 验证信息
     */
    @Override
    public EmailAuth selectEmailAuth(EmailAuth emailAuth) throws Exception {
        // TODO Auto-generated method stub
        return iEmailVerificationDao.selectEmailAuth(emailAuth);
    }

    /**
     * 删除信息
     * @param emailAuth
     */
    @Override
    public boolean deleteEmailAuth(EmailAuth emailAuth) throws Exception {
        int count = iEmailVerificationDao.deleteEmailAuth(emailAuth);
        if (0 == count) {
            return false;
        } else {
            return true;
        }
    }

}
