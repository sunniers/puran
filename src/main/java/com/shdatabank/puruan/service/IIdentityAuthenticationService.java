/**
 * IIdentityAuthenticationService.java
 * Created at 2016-10-18
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.UserExtensionInfo;

/**
 * 身份认证service层
 * 1.将个人身份认证信息保存到数据库
 * 2.设置用户类型
 */
public interface IIdentityAuthenticationService {

    /**
     * 个人身份证验证
     * @param userExtensionInfo 个人身份信息实体类
     */
    public ReturnObject insertUserExtensionInfo(UserExtensionInfo userExtensionInfo) throws Exception;
    
    /**
     * 将企业认证信息保存到数据库
     * @param company 企业实体类
     */
    public ReturnObject insertCompany(Company company) throws Exception;

}
