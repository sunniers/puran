/**
 * ProjectAdminstrationController.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IProjectAdministrationService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 项目管理controller层
 */
@RequestMapping(value="/projectAdminstration")
@Controller
public class ProjectAdminstrationController {

    /** 项目管理service */
    @Autowired
    private IProjectAdministrationService iProjectAdministrationService;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 查询已报名的项目
     * @param projectRequirement 项目信息
     * @return 项目信息
     */
    @RequestMapping(value="/selectEnrollTrue",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectEnrollTrue(@RequestBody ProjectRequirement projectRequirement) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null != user) {
            projectRequirement.setUserId(user.getUserId());
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                    SystemConstant.SESSION_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectAdministrationService.selectEnrollTrue(projectRequirement));
    }
    
    /**
     * 取消报名
     * @param projectRequirement 报名者信息
     * @return 是否成功
     */
    @RequestMapping(value="/deleteEnroll",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject deleteEnroll(@RequestBody ProjectRequirement projectRequirement) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null != user) {
            projectRequirement.setUserId(user.getUserId());
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                    SystemConstant.SESSION_ERROR_MSG);
        }
        if (iProjectAdministrationService.deleteEnroll(projectRequirement)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,
                    SystemConstant.DELETE_ERROR_MSG);
        }
    }
    
    /**
     * 查询未接纳的项目
     * @param projectRequirement 项目信息
     * @return 项目信息
     */
    @RequestMapping(value="/selectEnrollFalse",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectEnrollFalse(@RequestBody ProjectRequirement projectRequirement) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null != user) {
            projectRequirement.setUserId(user.getUserId());
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                    SystemConstant.SESSION_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectAdministrationService.selectEnrollFalse(projectRequirement));
    }
    
    /**
     * 查询进行中的项目
     * @param projectRequirement 项目信息
     * @return 项目信息
     */
    @RequestMapping(value="/selectRunningObj",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectRunningObj(@RequestBody ProjectRequirement projectRequirement) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null != user) {
            projectRequirement.setUserId(user.getUserId());
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectAdministrationService.selectRunningObj(projectRequirement));
    }
    
    /**
     * 查询已完成的项目
     * @param projectRequirement 项目信息
     * @return 项目信息
     */
    @RequestMapping(value="/selectEndObj",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectEndObj(@RequestBody ProjectRequirement projectRequirement) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null != user) {
            projectRequirement.setUserId(user.getUserId());
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectAdministrationService.selectEndObj(projectRequirement));
    }
}
