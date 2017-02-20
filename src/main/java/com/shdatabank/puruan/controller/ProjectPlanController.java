/**
 * ProjectPlanController.java
 * Created at 2016-11-07
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.PackageProjectPlan;
import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.IProjectPlanService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 计划controller层
 */
@RequestMapping(value="/projectPlan")
@Controller
public class ProjectPlanController {

    /** 计划service */
    @Autowired
    private IProjectPlanService iProjectPlanService;
    
    /**
     * 新增计划
     * @param projectPlan 计划内容
     * @return 是否成功
     */
    @RequestMapping(value="/insertProjectPlan",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectPlan(@RequestBody ProjectPlan projectPlan) throws Exception {
        if (null == projectPlan) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (iProjectPlanService.insertProjectPlan(projectPlan)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 查询项目的计划
     * @param projectPlan 计划内容
     * @return 计划
     */
    @RequestMapping(value="/selectProjectPlans",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectPlans(@RequestBody ProjectPlan projectPlan) throws Exception {
        if (null == projectPlan) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectPlanService.selectProjectPlans(projectPlan));
    }
    
    /**
     * 查询项目分包的计划
     * @param projectPlan 计划内容
     * @return 计划
     */
    @RequestMapping(value="/selectPackageProjectPlans",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectPackageProjectPlans(@RequestBody PackageProjectPlan packageProjectPlan) throws Exception {
        if (null == packageProjectPlan) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectPlanService.selectPackageProjectPlans(packageProjectPlan));
    }
    
    /**
     * 删除计划
     * @param projectPlan 计划
     * @return 是否成功
     */
    @RequestMapping(value="/deleteProjectPlan",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject deleteProjectPlan(@RequestBody ProjectPlan projectPlan) throws Exception {
        if (null == projectPlan) {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
        }
        
        if (iProjectPlanService.deleteProjectPlan(projectPlan)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
        }
    }
    
    /**
     * 查询所有父计划
     * @param projectPlan 计划
     * @return 父计划
     */
    @RequestMapping(value="/selectAllParentPlan",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectAllParentPlan(@RequestBody ProjectPlan projectPlan) throws Exception {
        if (null == projectPlan) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectPlanService.selectAllParentPlan(projectPlan));
    }
    
    /**
     * 查询父计划中的子计划
     * @param projectPlan 计划
     * @return 子计划
     */
    @RequestMapping(value="/selectChildPlan",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectChildPlan(@RequestBody ProjectPlan projectPlan) throws Exception {
        if (null == projectPlan) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectPlanService.selectChildPlan(projectPlan));
    }
    
    /**
     * 生成任务
     * @param projectPlanTask
     * @return 是否成功
     */
    @RequestMapping(value="/insertProjectPlanTask",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectPlanTask(@RequestBody List<ProjectPlan> projectPlans) throws Exception {
        if (iProjectPlanService.insertProjectPlanTask(projectPlans)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
    }
    
    /**
     * 查询团队成员
     * @param projectPlan 计划
     * @return 团队成员
     */
    @RequestMapping(value="/selectClassMember",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectClassMember(@RequestBody ProjectPlan projectPlan) throws Exception {
        if (null == projectPlan) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectPlanService.selectClassMember(projectPlan));
    }
    
    /**
     * 查询项目计划的详细信息
     * @param projectPlan 项目计划
     * @return 项目计划的详细信息
     */
    @RequestMapping(value="/selectProjectPlan",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectPlan(@RequestBody ProjectPlan projectPlan) throws Exception {
        if (null == projectPlan) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectPlanService.selectProjectPlan(projectPlan));
    }
    
    /**
     * 修改项目计划
     * @param projectPlan 项目计划
     * @return 是否成功
     */
    @RequestMapping(value="/updateProjectPlan2",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateProjectPlan2(@RequestBody ProjectPlan projectPlan) throws Exception {
        if (null == projectPlan) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (iProjectPlanService.updateProjectPlan2(projectPlan)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
}
