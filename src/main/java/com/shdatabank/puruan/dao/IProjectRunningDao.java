/**
 * IIdentityAuthenticationDao.java
 * Created at 2016-11-20
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ProjectPlanTask;

/**
 * 项目进度dao层
 */
public interface IProjectRunningDao {

    /**
     * 查询项目计划进度
     * @param ProjectPlan
     * @return 
     */
    public List<ProjectPlan> selectProjectRunning(ProjectPlan ProjectPlan) throws Exception;
    
    /**
     * 查询项目调整进度
     * @param ProjectPlan
     * @return 
     */
    public List<ProjectPlan> selectProjectRunning2(ProjectPlan ProjectPlan) throws Exception;
    
    /**
     * 查询分包的项目ID
     * @param ProjectPlan
     * @return 
     */
    public List<Long> selectPackageProjectId(ProjectPlan ProjectPlan) throws Exception;
    
    /**
     * 查询计划的任务的信息
     * @param projectPlanTask 任务信息
     * @return 任务信息
     */
    public List<ProjectPlanTask> selectProjectPlanTasks(ProjectPlanTask projectPlanTask) throws Exception;
}
