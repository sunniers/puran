/**
 * ProjectRunningController.java
 * Created at 2016-11-21
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ProjectPlanTask;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.IProjectRunningService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 项目进度controller层
 */
@RequestMapping(value="/projectRunning")
@Controller
public class ProjectRunningController {

    /** 项目进度service */
    @Autowired
    private IProjectRunningService iProjectRunningService;
    
    /**
     * 查询项目进度
     * @param ProjectPlan
     * @return 
     */
    @RequestMapping(value="/selectProjectRunning")
    @ResponseBody
    public ReturnObject selectProjectRunning(
            @RequestBody ProjectPlan ProjectPlan) throws Exception {
        if (null == ProjectPlan) {
            RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectRunningService.selectProjectRunning(ProjectPlan));
    }
    
    /**
     * 查询计划的任务的信息
     * @param projectPlanTask 任务信息
     * @return 任务信息
     */
    @RequestMapping(value="/selectProjectPlanTasks")
    @ResponseBody
    public ReturnObject selectProjectPlanTasks(
            @RequestBody ProjectPlanTask projectPlanTask) throws Exception {
        if (null == projectPlanTask) {
            RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectRunningService.selectProjectPlanTasks(projectPlanTask));
    }
}
