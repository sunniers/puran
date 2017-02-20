/**
 * GetSessionController.java
 * Created at 2016-10-25
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
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 从session中获取需要的数据
 */
@RequestMapping(value="/getSession")
@Controller
public class GetSessionController {

    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 查询后台用户信息
     * @return 后台用户信息
     */
    @RequestMapping(value="/getBackUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject getBackUserSession() throws Exception {
        BackUser backUser = (BackUser) httpServletRequest.getSession().getAttribute("backUser");
        if (null != backUser) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",backUser);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
    }
    
    /**
     * 后台退出
     * @return 退出信息
     */
    @RequestMapping(value="/outBackUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject outBackUser() throws Exception {
        httpServletRequest.getSession().removeAttribute("backUser");
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }
    
    /**
     * 查询前台用户信息
     * @return 前台用户信息
     */
    @RequestMapping(value="/getUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject getUserSession() throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null != user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",user);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
    }
    
    /**
     * 前台退出
     * @return 退出信息
     */
    @RequestMapping(value="/outUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject outUser() throws Exception {
        httpServletRequest.getSession().removeAttribute("user");
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }
}
