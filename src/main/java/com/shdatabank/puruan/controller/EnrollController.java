/**
 * EnrollController.java
 * Created at 2016-11-15
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

import com.shdatabank.puruan.model.ProjectEnroll;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.TalentEnroll;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IEnrollService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 报名controller层
 */
@RequestMapping(value="enroll")
@Controller
public class EnrollController {

    /** 报名service */
    @Autowired
    private IEnrollService iEnrollService;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 插入报名信息
     * @param projectEnroll 报名信息
     * @return 是否成功
     */
    @RequestMapping(value="insertProjectEnroll",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectEnroll(@RequestBody ProjectEnroll projectEnroll) throws Exception {
        if (null == projectEnroll) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
        }
        projectEnroll.setUserId(user.getUserId());
        if (iEnrollService.insertProjectEnroll(projectEnroll)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 删除报名信息
     * @param projectEnroll 报名信息
     * @return 是否成功
     */
    @RequestMapping(value="deleteProjectEnroll",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject deleteProjectEnroll(@RequestBody ProjectEnroll projectEnroll) throws Exception {
        if (null == projectEnroll) {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
        }
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
        }
        projectEnroll.setUserId(user.getUserId());
        if (iEnrollService.deleteProjectEnroll(projectEnroll)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
        }
    }
    
    /**
     * 插入人才需求报名信息
     * @param talentEnroll 报名信息
     * @return 是否成功
     */
    @RequestMapping(value="insertTalentEnroll",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertTalentEnroll(@RequestBody TalentEnroll talentEnroll) throws Exception {
        if (null == talentEnroll) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
        }
        talentEnroll.setUserId(user.getUserId());
        if (iEnrollService.insertTalentEnroll(talentEnroll)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 删除人才需求报名信息
     * @param talentEnroll 报名信息
     * @return 是否成功
     */
    @RequestMapping(value="deleteTalentEnroll",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject deleteTalentEnroll(@RequestBody TalentEnroll talentEnroll) throws Exception {
        if (null == talentEnroll) {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
        }
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
        }
        talentEnroll.setUserId(user.getUserId());
        if (iEnrollService.deleteTalentEnroll(talentEnroll)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
        }
    }
}
