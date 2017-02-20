/**
 * ProjectRequirementController.java
 * Created at 2016-11-19
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
import com.shdatabank.puruan.service.IProjectRequirementService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 项目—需求controller层
 */
@RequestMapping(value="/projectRequirement")
@Controller
public class ProjectRequirementController {

    /** 项目—需求service */
    @Autowired
    private IProjectRequirementService iProjectRequirementService;
    
    /**
     * 查询需求详细和需求分包
     * @param projId 需求ID
     * @return 需求详细和需求分包
     */
    @RequestMapping(value="/selectProjectRequirement",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectRequirement(@RequestBody 
            ProjectRequirement projectRequirement) throws Exception {
        if (null == projectRequirement) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,
                    SystemConstant.SEARCH_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iProjectRequirementService.selectProjectRequirement(projectRequirement));
    }
}
