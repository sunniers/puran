/**
 * IdentityAuthenticationController.java
 * Created at 2016-10-18
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.UserExtensionInfo;
import com.shdatabank.puruan.service.IIdentityAuthenticationService;

/**
 * 身份认证controller层
 * 1.个人身份证验证
 */
@RequestMapping(value="/identityAuthentication")
@Controller
public class IdentityAuthenticationController {
    
    /** 身份认证service */
    @Autowired
    private IIdentityAuthenticationService identityAuthenticationService;
    
    /**
     * 个人身份证验证
     * @param userExtensionInfo
     * @return 返回结果对象
     */
    @RequestMapping(value="/user",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject userIdentityAuthentication(@RequestBody UserExtensionInfo userExtensionInfo) throws Exception {
        return identityAuthenticationService.insertUserExtensionInfo(userExtensionInfo);
    }
    
    /**
     * 企业验证
     * @param userExtensionInfo
     * @return 返回结果对象
     */
    @RequestMapping(value="/company",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject companyIdentityAuthentication(@RequestBody Company company) throws Exception {
        return identityAuthenticationService.insertCompany(company);
    }
}
