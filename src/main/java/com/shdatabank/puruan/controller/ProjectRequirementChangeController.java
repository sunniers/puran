/**
 * ProjectRequirementChangeController.java
 * Created at 2016-11-09
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

import com.shdatabank.puruan.model.ProjectRequirementChange;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IProjectRequirementChangeService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 需求变更controller层
 */
@RequestMapping(value="/projectRequirementChange")
@Controller
public class ProjectRequirementChangeController {

    /** 需求变更service */
    @Autowired
    private IProjectRequirementChangeService iProjectRequirementChangeService;
    
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 查询需求变更的基本信息
     * @param projectRequirementChange 查询条件
     * @return 变更的基本信息
     */
    @RequestMapping(value="/selectProjectRequirementChange",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectRequirementChange(
            @RequestBody ProjectRequirementChange projectRequirementChange) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        }
        projectRequirementChange.setPublishUserId(user.getUserId());
        projectRequirementChange = iProjectRequirementChangeService.selectProjectRequirementChange(projectRequirementChange);
        if (null == projectRequirementChange) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",projectRequirementChange);
        }
    }
    
    /**
     * 插入需求变更
     * @param projectRequirementChange 变更内容
     * @return 是否成功
     */
    @RequestMapping(value="/insertProjectRequirementChange",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectRequirementChange(
            @RequestBody ProjectRequirementChange projectRequirementChange) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        }
        if (null == projectRequirementChange) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,
                    SystemConstant.SAVE_ERROR_MSG);
        }
        projectRequirementChange.setPublishUserId(user.getUserId());
        if (iProjectRequirementChangeService.insertProjectRequirementChange(projectRequirementChange)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,
                    SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 查询成员信息
     * @param projectRequirementChange 变更内容
     * @return 成员信息
     */
    @RequestMapping(value="/selectClassMember",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectClassMember(
            @RequestBody ProjectRequirementChange projectRequirementChange) throws Exception {
        if (null == projectRequirementChange) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectRequirementChangeService.selectClassMember(projectRequirementChange));
    }
    
    /**
     * 查询所有的变更信息
     * @param projectRequirementChange 变更内容
     * @return 变更信息
     */
    @RequestMapping(value="/selectAllChanges",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectAllChanges(
            @RequestBody ProjectRequirementChange projectRequirementChange) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        }
        if (null == projectRequirementChange) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        }
        projectRequirementChange.setPublishUserId(user.getUserId());
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectRequirementChangeService.selectAllChanges(projectRequirementChange));
    }
    
    /**
     * 查询详细信息
     * @param projectRequirementChange 变更内容
     * @return 变更信息
     */
    @RequestMapping(value="/selectChange",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectChange(
            @RequestBody ProjectRequirementChange projectRequirementChange) throws Exception {
        if (null == projectRequirementChange) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectRequirementChangeService.selectChange(projectRequirementChange));
    }
    
    /**
     * 修改变更内容
     * @param projectRequirementChange 变更内容
     * @return 是否成功
     */
    @RequestMapping(value="/updateProjectRequirementChange",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateProjectRequirementChange(
            @RequestBody ProjectRequirementChange projectRequirementChange) throws Exception {
        if (null == projectRequirementChange) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,
                    SystemConstant.SAVE_ERROR_MSG);
        }
        if (iProjectRequirementChangeService.updateProjectRequirementChange(projectRequirementChange)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,
                    SystemConstant.SAVE_ERROR_MSG);
        }
    }
}
