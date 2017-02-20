/**
 * ShowBackIndexController.java
 * Created at 2016-10-17
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

import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.SysResource;
import com.shdatabank.puruan.service.ShowBackIndexService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 显示后台首页controller层
 * 1.获取后台菜单信息
 * 2.获取后台项目需求信息
 * 3.获取后台创意资源信息
 */
@RequestMapping(value="/showFrontIndex")
@Controller
public class ShowBackIndexController {

    /** 显示后台首页service */
    @Autowired
    private ShowBackIndexService showBackIndexService;
    
    /**
     * 获取后台菜单信息
     * @return 返回结果对象
     */
    @RequestMapping(value="/selectSysResources",method=RequestMethod.POST)
    @ResponseBody
    private ReturnObject selectSysResources(@RequestBody SysResource sysResource) throws Exception {
        return RetObjectBuilder.generateRetObject(
                SystemConstant.SUCCESS, "", showBackIndexService.selectSysResources(sysResource));
    }
    
    /**
     * 获取后台项目需求信息
     * @return 返回结果对象
     */
    @RequestMapping(value="/selectProjectRequirements",method=RequestMethod.GET)
    @ResponseBody
    private ReturnObject selectProjectRequirements() throws Exception {
        return RetObjectBuilder.generateRetObject(
                SystemConstant.SUCCESS, "",showBackIndexService.selectProjectRequirements());
    }
    
    /**
     * 获取后台创意资源信息
     * @return 返回结果对象
     */
    @RequestMapping(value="/selectCreativeResources",method=RequestMethod.GET)
    @ResponseBody
    private ReturnObject selectCreativeResources() throws Exception {
        return RetObjectBuilder.generateRetObject(
                SystemConstant.SUCCESS, "",showBackIndexService.selectCreativeResources());
    }
}
