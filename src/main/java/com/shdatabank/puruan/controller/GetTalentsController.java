/**
 * GetTalentsController.java
 * Created at 2016-11-22
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

import com.shdatabank.puruan.model.GetTalents;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.IGetTalentsService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 创意人才controller层
 */
@RequestMapping(value="/getTalents")
@Controller
public class GetTalentsController {

    /** 创意人才service */
    @Autowired
    private IGetTalentsService iGetTalentsService;
    
    /**
     * 查询分类
     * @return 分类
     */
    @RequestMapping(value="/selectDictionary",method=RequestMethod.GET)
    @ResponseBody
    public ReturnObject selectDictionary() throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",iGetTalentsService.selectDictionary());
    }
    
    /**
     * 查询创意人才
     * @return 需求
     */
    @RequestMapping(value="/selectGetTalents",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectGetTalents(@RequestBody GetTalents getTalents) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iGetTalentsService.selectGetTalents(getTalents));
    }
}
