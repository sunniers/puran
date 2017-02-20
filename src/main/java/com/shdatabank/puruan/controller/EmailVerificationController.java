/**
 * EmailVerificationController.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.Verification;
import com.shdatabank.puruan.service.IEmailVerificationService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 验证controller层
 * 1.获取验证码图片
 * 2.验证码验证
 * 3.发送邮箱验证
 * 4.验证邮箱
 */
@RequestMapping(value = "/captcha")
@Controller
public class EmailVerificationController {
    
    /** 验证邮箱service */
    @Autowired
    private IEmailVerificationService iEmailVerificationService;
    
    /**
     * 获取验证码图片
     * @param request
     * @param response
     */
    @RequestMapping(value="/getCaptcha", method=RequestMethod.GET)
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取图片
        UserUtil.outputCaptcha(request, response);
    }

    /**
     * 验证码验证
     * @param verification 验证信息
     * @param request
     * @return 返回结果对象
     */
    @RequestMapping(value="/verification", method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject verificationCD(@RequestBody Verification verification, HttpServletRequest request) throws Exception {
        if (UserUtil.checkVerificationCD(verification.getVerification(), request)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.CHECK_ERROR, SystemConstant.CHECK_ERROR_MSG);
        }
    }

}
