/**
 * ShowBackIndexServiceImpl.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.stereotype.Service;

import com.shdatabank.puruan.dao.ShowBackIndexDao;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.SysResource;
import com.shdatabank.puruan.service.ShowBackIndexService;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 获取后台菜单信息service层
 * 1.获取后台菜单信息
 * 2.获取后台项目需求信息
 * 3.获取后台创意资源信息
 */
@Service
public class ShowBackIndexServiceImpl implements ShowBackIndexService {

    /** 获取后台菜单信息dao */
    @Autowired
    private ShowBackIndexDao showBackIndexDao;
    EhCacheManagerFactoryBean ss;
    //@Cacheable
    
    /**
     * 获取后台菜单信息
     * @return 返回所有可用菜单
     */
    @Override
    public List<SysResource> selectSysResources(SysResource sysResource) throws Exception {
        return showBackIndexDao.selectSysResources(sysResource);
    }

    /**
     * 获取后台项目需求信息
     * @return 返回所有存在的项目需求
     */
    @Override
    public List<ProjectRequirement> selectProjectRequirements() throws Exception {
        List<ProjectRequirement> projectRequirements = showBackIndexDao.selectProjectRequirements();
        for(int i = 0; i < projectRequirements.size(); i++) {
            projectRequirements.get(i).setProjCloseDateMapping(
                UserUtil.dateConversionString(projectRequirements.get(i).getProjCloseDate()));
            /*projectRequirements.get(i).setProjDevlierDateMapping(
                UserUtil.dateConversionString(projectRequirements.get(i).getProjDevlierDate()));
            projectRequirements.get(i).setCreateDatetimeMapping(
                UserUtil.dateConversionString(projectRequirements.get(i).getCreateDatetime()));*/
        }
        return projectRequirements;
    }

    /**
     * 获取后台创意资源信息
     * @return 返回所有存在的创意资源
     */
    @Override
    public List<CreativeResource> selectCreativeResources() throws Exception {
        return showBackIndexDao.selectCreativeResources();
    }

}
