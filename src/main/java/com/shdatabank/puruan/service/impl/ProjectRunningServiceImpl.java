/**
 * ProjectRunningServiceImpl.java
 * Created at 2016-11-21
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shdatabank.puruan.dao.IProjectRunningDao;
import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ProjectPlanTask;
import com.shdatabank.puruan.model.ProjectRunning;
import com.shdatabank.puruan.service.IProjectRunningService;

/**
 * 项目进度service层
 */
@Service
public class ProjectRunningServiceImpl implements IProjectRunningService {

    /** 项目进度dao */
    @Autowired
    private IProjectRunningDao iProjectRunningDao;
    
    /**
     * 查询项目进度
     * @param ProjectPlan
     * @return 
     */
    @Transactional
    @Override
    public ProjectRunning selectProjectRunning(ProjectPlan ProjectPlan) throws Exception {
        ProjectRunning projectRunning = new ProjectRunning();
        projectRunning.setProjectPlans(iProjectRunningDao.selectProjectRunning(ProjectPlan));
        projectRunning.setProjectPlans2(iProjectRunningDao.selectProjectRunning2(ProjectPlan));
        List<Long> projIds = iProjectRunningDao.selectPackageProjectId(ProjectPlan);
        List<ProjectRunning> projectRunnings = new ArrayList<ProjectRunning>();
        for (int i = 0;i < projIds.size();i++) {
            ProjectRunning projectRunning2 = new ProjectRunning();
            projectRunning2.setProjectPlans(iProjectRunningDao.selectProjectRunning(ProjectPlan));
            projectRunning2.setProjectPlans2(iProjectRunningDao.selectProjectRunning2(ProjectPlan));
            projectRunnings.add(projectRunning2);
        }
        projectRunning.setProjectRunnings(projectRunnings);
        return projectRunning;
    }
    
    /**
     * 查询计划的任务的信息
     * @param projectPlanTask 任务信息
     * @return 任务信息
     */
    @Override
    public List<ProjectPlanTask> selectProjectPlanTasks(ProjectPlanTask projectPlanTask) throws Exception {
        return iProjectRunningDao.selectProjectPlanTasks(projectPlanTask);
    }

}
