/**
 * IProjectRunningService.java
 * Created at 2016-11-21
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ProjectPlanTask;
import com.shdatabank.puruan.model.ProjectRunning;

/**
 * 项目进度service层
 */
public interface IProjectRunningService {

    /**
     * 查询项目进度
     * @param ProjectPlan
     * @return 
     */
    public ProjectRunning selectProjectRunning(ProjectPlan ProjectPlan) throws Exception;
    
    /**
     * 查询计划的任务的信息
     * @param projectPlanTask 任务信息
     * @return 任务信息
     */
    public List<ProjectPlanTask> selectProjectPlanTasks(ProjectPlanTask projectPlanTask) throws Exception;
}
