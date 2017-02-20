/**
 * ShowBackIndexDao.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.SysResource;

/**
 * 后台首页显示dao层
 * 1.获取后台菜单信息
 * 2.获取后台项目需求信息
 * 3.获取后台创意资源信息
 */
public interface ShowBackIndexDao {

    /**
     * 获取后台菜单信息
     * @return 返回所有可用菜单
     */
    public List<SysResource> selectSysResources(SysResource sysResource);
    
    /**
     * 获取后台项目需求信息
     * @return 返回所有存在的项目需求
     */
    public List<ProjectRequirement> selectProjectRequirements();
    
    /**
     * 获取后台创意资源信息
     * @return 返回所有存在的创意资源
     */
    public List<CreativeResource> selectCreativeResources();
}
