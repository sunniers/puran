/**
 * ShowBackIndexService.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.SysResource;

/**
 * 获取后台菜单信息service层
 * 1.获取后台菜单信息
 * 2.获取后台项目需求信息
 * 3.获取后台创意资源信息
 */
public interface ShowBackIndexService {

    /**
     * 获取后台菜单信息
     * @return 返回所有可用菜单
     */
    public List<SysResource> selectSysResources(SysResource sysResource) throws Exception;
    
    /**
     * 获取后台项目需求信息
     * @return 返回所有存在的项目需求
     */
    public List<ProjectRequirement> selectProjectRequirements() throws Exception;
    
    /**
     * 获取后台创意资源信息
     * @return 返回所有存在的创意资源
     */
    public List<CreativeResource> selectCreativeResources() throws Exception;
}
