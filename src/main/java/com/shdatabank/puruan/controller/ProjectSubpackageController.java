/**
 * ProjectSubpackageController.java
 * Created at 2016-11-06
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.IProjectSubpackageService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 项目分包controller层
 */
@RequestMapping(value="/projectSubpackage")
@Controller
public class ProjectSubpackageController {

    /** 项目分包service */
    @Autowired
    private IProjectSubpackageService iProjectSubpackageService;
    
    /**
     * 插入项目分包信息
     * @param projectSubpackage 分包信息
     * @return 是否成功
     */
    @RequestMapping(value="/insertProjectSubpackage",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectSubpackage(@RequestBody ProjectRequirement projectRequirement) throws Exception {
        if (null == projectRequirement) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        if (iProjectSubpackageService.insertProjectSubpackage(projectRequirement)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }

    /**
     * 查询分包信息
     * @param projectRequirement 需求信息
     * @return 需求信息
     */
    @RequestMapping(value="/selectProjectSubpackage",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectSubpackage(@RequestBody  ProjectRequirement projectRequirement) throws Exception {
        if (null == projectRequirement) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectSubpackageService.selectProjectSubpackage(projectRequirement));
    }
    
}
