/**
 * MyCodeController.java
 * Created at 2016-10-24
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IMyCodeService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 我的账号开发controller层
 */
@RequestMapping(value="/myCodeController")
@Controller
public class MyCodeController {

    /** 我的账号开发service */
    @Autowired
    private IMyCodeService iMyCodeService;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 查询我的项目
     * @return 返回结果对象
     */
    @RequestMapping(value="/selectProj",method=RequestMethod.GET)
    @ResponseBody
    public ReturnObject selectProj() throws Exception{
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        return iMyCodeService.selectProj(user.getUserId());
    }

}
