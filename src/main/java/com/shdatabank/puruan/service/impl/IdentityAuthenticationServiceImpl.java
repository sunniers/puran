/**
 * IdentityAuthenticationServiceImpl.java
 * Created at 2016-10-18
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shdatabank.puruan.dao.IIdentityAuthenticationDao;
import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserExtensionInfo;
import com.shdatabank.puruan.service.IIdentityAuthenticationService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 身份认证service层
 * 1.个人身份证验证
 * 2.企业验证
 */
@Service
public class IdentityAuthenticationServiceImpl implements IIdentityAuthenticationService {

    private Logger logger =Logger.getLogger(IdentityAuthenticationServiceImpl.class);
    
    /** 身份认证dao */
    @Autowired
    private IIdentityAuthenticationDao iIdentityAuthenticationDao;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 个人身份证验证
     * @param userExtensionInfo 个人身份信息实体类
     */
    @Transactional
    @Override
    public ReturnObject insertUserExtensionInfo(UserExtensionInfo userExtensionInfo) throws Exception {
        logger.debug("个人身份证验证");
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        //存入身份证
        userExtensionInfo.setCreditType("身份证");
        //存入随机名称
        userExtensionInfo.setCreditFileName(UserUtil.getRandName());
        //存入用户id
        userExtensionInfo.setUserId(user.getUserId());
        
        
        int count = iIdentityAuthenticationDao.selectUserInfo(user.getUserId());
        if (0 != count) {
            count = iIdentityAuthenticationDao.updateUserInfo(userExtensionInfo);
            if (0 == count) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        } else {
            count = iIdentityAuthenticationDao.insertUserExtensionInfo(userExtensionInfo);
            if (0 == count) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }            
        }
        
        
        //设置用户类型
        user.setUserType(SystemConstant.USER);
        count = iIdentityAuthenticationDao.updateUserType(user);
        if (0 == count) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }

    /**
     * 企业验证
     * @param company 企业信息实体类
     */
    @Transactional
    @Override
    public ReturnObject insertCompany(Company company) throws Exception {
        logger.debug("企业验证");
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        //将company信息保存到company表中
        int count = iIdentityAuthenticationDao.insertCompany(company);
        if (0 == count) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }

        if (null != company.getCompanyCredits()) {
            for (int i = 0;i < company.getCompanyCredits().size();i++) {
                company.getCompanyCredits().get(i).setCompanyId(company.getCompanyId());
                company.getCompanyCredits().get(i).setCreditFilename(UserUtil.getRandName());
            }
            
            count = iIdentityAuthenticationDao.insertCompanyCredit(company.getCompanyCredits());
            if (0 == count) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        }
        
        //设置用户类型
        user.setUserType(SystemConstant.COMPANY);
        user.setCompanyId(company.getCompanyId());
        count = iIdentityAuthenticationDao.updateUserType(user);
        if (0 == count) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }

}
