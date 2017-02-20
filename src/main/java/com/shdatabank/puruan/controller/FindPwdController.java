/**
 * FindPwdController.java
 * Created at 2016-10-20
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.EmailAuth;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IFindPwdService;
import com.shdatabank.puruan.util.DesUtil;
import com.shdatabank.puruan.util.ParamFileUtil;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 忘记密码controller层
 * 1.发送邮箱验证
 * 2.更新用户密码
 */
@RequestMapping(value="/findPwd")
@Controller
public class FindPwdController {

    /** 忘记密码service */
    @Autowired
    private IFindPwdService iFindPwdService;
    
    /**
     * 发送邮箱验证
     * @param user 用户信息
     * @return 返回结果对象
     */
    @RequestMapping(value="/emailFind",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject emailFind(@RequestBody User user) throws Exception {
        user = iFindPwdService.selectUserCount(user);
        if (null != user) {
            //发送邮箱验证
            UserUtil.sendEmail(user.getUserName(),user.getUserEmail(),SystemConstant.FING_PATH);
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
    }
    
    /**
     * 重新发送
     * @param user
     * @return
     * @throws Exception 
     */
    @RequestMapping(value="/resend", method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject resend(@RequestBody User user) throws Exception {
        user = iFindPwdService.selectUserCount(user);
        if (null != user) {
            //发送邮箱验证
            UserUtil.sendEmail(user.getUserName(),user.getUserEmail(),SystemConstant.FING_PATH);
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
    }
    
    /**
     * 更新用户密码
     * @param user
     * @return 返回结果对象
     */
    @RequestMapping(value="/updateUserPwd",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateUserPwd(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        String sid = DesUtil.decrypt(request.getQueryString().substring(0).substring(4),"wang11111");
        // 以#号分割
        String sids[] = sid.split("#");
        // 判断浦软id
        if (!ParamFileUtil.getConfigProperty("config", "emailPuruanId").equals(sids[0])) {
            return RetObjectBuilder.generateRetObject(SystemConstant.CHECK_ERROR, SystemConstant.CHECK_ERROR_MSG);
        }
        if(new Date().getTime() > Long.parseLong(sids[3])+1000*60*60*24){
            return RetObjectBuilder.generateRetObject(SystemConstant.CHECK_ERROR, SystemConstant.CHECK_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }
}
