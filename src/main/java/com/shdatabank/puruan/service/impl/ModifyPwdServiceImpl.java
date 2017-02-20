/**
 * ModifyPwdServiceImpl.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shdatabank.puruan.dao.ModifyPwdDao;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.ModifyPwdService;

/**
 * 前后台用户修改密码service层
 * 1.验证后台用户旧密码是否正确
 * 2.更新后台用户新密码
 * 3.验证前台用户旧密码是否正确
 * 4.更新前台用户新密码
 */
@Service
public class ModifyPwdServiceImpl implements ModifyPwdService {

    private Logger logger =Logger.getLogger(ModifyPwdServiceImpl.class);
    
    /** 前后台用户修改密码dao */
    @Autowired
    private ModifyPwdDao modifyPwdDao;
    
    /**
     * 验证旧密码是否正确
     * @param backUser 用户名和密码
     * @return 用户count
     */
    @Override
    public Integer selectBackUserOldPwd(BackUser backUser) throws Exception {
        return modifyPwdDao.selectBackUserOldPwd(backUser);
    }

    /**
     * 更新新密码
     * @param backUser 用户名和密码
     */
    @Transactional
    @Override
    public boolean updateBackUserNewPwd(BackUser backUser) throws Exception {
        logger.debug("更新新密码");
        int count = modifyPwdDao.updateBackUserNewPwd(backUser);
        if (0 == count) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * 验证旧密码是否正确
     * @param backUser 用户名和密码
     * @return 用户count
     */
    @Override
    public Integer selectUserOldPwd(User user) throws Exception {
        // TODO Auto-generated method stub
        return modifyPwdDao.selectUserOldPwd(user);
    }

    /**
     * 更新新密码
     * @param backUser 用户名和密码
     */
    @Transactional
    @Override
    public boolean updateUserNewPwd(User user) throws Exception {
        logger.debug("更新新密码");
        int count = modifyPwdDao.updateUserNewPwd(user);
        if (0 == count) {
            return false;
        } else {
            return true;
        }
    }
}
