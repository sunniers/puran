/**
 * ProjectTeamController.java
 * Created at 2016-10-29
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

import com.shdatabank.puruan.model.ProjectLeave;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IProjectTeamService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 项目小组管理controller层
 */
@RequestMapping(value="/projectTeam")
@Controller
public class ProjectTeamController {
    
    /** 项目小组管理service */
    @Autowired
    private IProjectTeamService iProjectTeamService;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 查询小组成员
     * @return 返回小组成员信息
     */
    @RequestMapping(value="/selectTeamMember",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectTeamMember(@RequestBody ProjectUserReleation projectUserReleation) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                    SystemConstant.SESSION_ERROR_MSG);
        }
        projectUserReleation.setUserId(user.getUserId());
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectTeamService.selectTeamMember(projectUserReleation));
    }
    
    /**
     * 删除小组成员
     * @param projectUserReleation 小组成员
     * @return 是否成功
     */
    @RequestMapping(value="/deleteTeamMember",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject deleteTeamMember(@RequestBody ProjectUserReleation projectUserReleation) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                    SystemConstant.SESSION_ERROR_MSG);
        }
        projectUserReleation.setUserId(user.getUserId());
        if (iProjectTeamService.deleteTeamMember(projectUserReleation)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
        }
    }
    
    /**
     * 查询小组成员
     * @return 返回小组成员信息
     */
    @RequestMapping(value="/selectMyCommunity",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectMyCommunity(@RequestBody ProjectUserReleation projectUserReleation) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null != user) {
            projectUserReleation.setUserId(user.getUserId());
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                    SystemConstant.SESSION_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectTeamService.selectMyCommunity(projectUserReleation));
    }
    
    /**
     * 请假
     * @param projectLeave 请假信息
     * @return 是否成功
     */
    @RequestMapping(value="/insertProjectLeave",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectLeave(@RequestBody ProjectLeave projectLeave) throws Exception {
        if (null == projectLeave) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,
                    SystemConstant.SAVE_ERROR_MSG);
        }
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                    SystemConstant.SESSION_ERROR_MSG);
        }
        projectLeave.setUserId(user.getUserId());
        if (iProjectTeamService.insertProjectLeave(projectLeave)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,
                    SystemConstant.SAVE_ERROR_MSG);
        }
    }
}
