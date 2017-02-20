/**
 * GetRequirementController.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.IGetRequirementService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 需求大厅controller层
 */
@RequestMapping(value="/getRequirement")
@Controller
public class GetRequirementController {

    /** 需求大厅service */
    @Autowired
    private IGetRequirementService iGetRequirementService;
    
    /**
     * 查询分类信息
     * @param dictionary 查询条件
     * @return 返回结果对象
     */
    @RequestMapping(value="/selectDictionary",method=RequestMethod.GET)
    @ResponseBody
    public ReturnObject selectDictionary() throws Exception {
        List<Dictionary> ditionarys = new ArrayList<Dictionary>();
        ditionarys = iGetRequirementService.selectDictionary();
        if (null != ditionarys) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",ditionarys);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
    }
    
    /**
     * 查询需求
     * @return 需求
     */
    @RequestMapping(value="/selectRequirement",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectRequirement(@RequestBody ProjectRequirement projectRequirement) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",iGetRequirementService.selectRequirement(projectRequirement));
    }
}
