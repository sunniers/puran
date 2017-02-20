/**
 * IProjectAdministration.java
 * Created at 2016-10-24
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.ProjectRequirement;

/**
 * 项目管理dao层
 */
public interface IProjectAdministrationDao {

    /**
     * 查询已报名的项目
     * @param user 用户id
     * @return 项目信息
     */
    public List<ProjectRequirement> selectEnrollTrue(ProjectRequirement projectRequirement) throws Exception;
  
    /**
     * 取消报名
     * @param projectRequirement 报名者信息
     * @return 是否成功
     */
    public int deleteEnroll(ProjectRequirement projectRequirement) throws Exception;
    
    /**
     * 查询未接纳的项目
     * @param user 用户id
     * @return 项目信息
     */
    public List<ProjectRequirement> selectEnrollFalse(ProjectRequirement projectRequirement) throws Exception;

    /**
     * 查询进行中的项目
     * @param user 用户id
     * @return 项目信息
     */
    public List<ProjectRequirement> selectRunningObj(ProjectRequirement projectRequirement) throws Exception;

    /**
     * 查询已完成的项目
     * @param user 用户id
     * @return 项目信息
     */
    public List<ProjectRequirement> selectEndObj(ProjectRequirement projectRequirement) throws Exception;
}
