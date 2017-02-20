/**
 * IProjectAdministrationService.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.ProjectRequirement;

/**
 * 项目管理service层
 */
public interface IProjectAdministrationService {

    /**
     * 查询已报名的项目
     * @param user 用户id
     * @return 项目信息
     */
    public PageInfo<ProjectRequirement> selectEnrollTrue(ProjectRequirement projectRequirement) throws Exception;

    /**
     * 取消报名
     * @param projectRequirement 报名者信息
     * @return 是否成功
     */
    public boolean deleteEnroll(ProjectRequirement projectRequirement) throws Exception;
    
    /**
     * 查询未接纳的项目
     * @param user 用户id
     * @return 项目信息
     */
    public PageInfo<ProjectRequirement> selectEnrollFalse(ProjectRequirement projectRequirement) throws Exception;

    /**
     * 查询进行中的项目
     * @param user 用户id
     * @return 项目信息
     */
    public PageInfo<ProjectRequirement> selectRunningObj(ProjectRequirement projectRequirement) throws Exception;

    /**
     * 查询已完成的项目
     * @param user 用户id
     * @return 项目信息
     */
    public PageInfo<ProjectRequirement> selectEndObj(ProjectRequirement projectRequirement) throws Exception;
}
