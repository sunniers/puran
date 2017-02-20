/**
 * ProjectPlanServiceImpl.java
 * Created at 2016-11-07
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.IProjectPlanDao;
import com.shdatabank.puruan.model.PackageProjectPlan;
import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ProjectPlanTask;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IProjectPlanService;

/**
 * 计划service层
 */
@Service
public class ProjectPlanServiceImpl implements IProjectPlanService {

    private Logger logger =Logger.getLogger(ProjectPlanServiceImpl.class);
    
    /** 计划dao */
    @Autowired
    private IProjectPlanDao iProjectPlanDao;
    
    /**
     * 新增计划
     * @param projectPlan 计划内容
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertProjectPlan(ProjectPlan projectPlan) throws Exception {
        logger.debug("新增计划");
        int count = iProjectPlanDao.insertProjectPlan(projectPlan);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 查询项目的计划
     * @param projectPlan 计划内容
     * @return 计划
     */
    @Override
    public PageInfo<ProjectPlan> selectProjectPlans(ProjectPlan projectPlan) throws Exception {
        if (null == projectPlan.getPage() || null == projectPlan.getPageSize()) {
            return null;
        }
        PageHelper.startPage(projectPlan.getPage(), projectPlan.getPageSize());
        return new PageInfo<ProjectPlan> (iProjectPlanDao.selectProjectPlans(projectPlan));
    }

    /**
     * 查询项目分包的计划
     * @param packageProjectPlan 分包计划
     * @return 分包计划
     */
    @Override
    public List<PackageProjectPlan> selectPackageProjectPlans(PackageProjectPlan packageProjectPlan)
            throws Exception {
        return iProjectPlanDao.selectPackageProjectPlans(packageProjectPlan);
    }

    /**
     * 删除计划
     * @param projectPlan 计划
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean deleteProjectPlan(ProjectPlan projectPlan) throws Exception {
        logger.debug("删除计划");
        int count = iProjectPlanDao.deleteProjectPlan(projectPlan);
        if (0 == count) {
            return false;
        }
        
        count = iProjectPlanDao.updateProjectPlan(projectPlan);
        
        return true;        
    }

    /**
     * 查询所有父计划
     * @param projectPlan 计划
     * @return 父计划
     */
    @Override
    public List<ProjectPlan> selectAllParentPlan(ProjectPlan projectPlan) throws Exception {
        return iProjectPlanDao.selectAllParentPlan(projectPlan);
    }

    /**
     * 查询父计划中的子计划
     * @param projectPlan 计划
     * @return 子计划
     */
    @Override
    public List<ProjectPlan> selectChildPlan(ProjectPlan projectPlan) throws Exception {
        return iProjectPlanDao.selectChildPlan(projectPlan);
    }

    /**
     * 生成任务
     * @param projectPlanTask
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertProjectPlanTask(List<ProjectPlan> projectPlans) throws Exception {
        logger.debug("生成任务");
        List<ProjectPlanTask> projectPlanTasks = new ArrayList<ProjectPlanTask>();
        for (int i = 0;i < projectPlans.size();i++) {
            ProjectPlanTask projectPlanTask = new ProjectPlanTask();
            projectPlanTask.setProjPlanId(projectPlans.get(i).getProjPlanId());
            projectPlanTask.setUndertakeUserId(projectPlans.get(i).getPlanExecutant());
            projectPlanTask.setProjTaskWorkRange(projectPlans.get(i).getPlanWorkRange());
            projectPlanTask.setProjTaskName(projectPlans.get(i).getProjPlanName());
            projectPlanTask.setProjTaskStartDate(projectPlans.get(i).getPlanStartDate());
            projectPlanTask.setProjTaskFinishDate(projectPlans.get(i).getPlanFinishDate());
            projectPlanTask.setProjTaskContent(projectPlans.get(i).getPlanContent());
            projectPlanTasks.add(projectPlanTask);
        }
        int count = iProjectPlanDao.insertProjectPlanTask(projectPlanTasks);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 查询团队成员
     * @param projectPlan 计划
     * @return 团队成员
     */
    @Override
    public List<User> selectClassMember(ProjectPlan projectPlan) throws Exception {
        return iProjectPlanDao.selectClassMember(projectPlan);
    }

    /**
     * 查询项目计划的详细信息
     * @param projectPlan 项目计划
     * @return 项目计划的详细信息
     */
    @Override
    public ProjectPlan selectProjectPlan(ProjectPlan projectPlan) throws Exception {
        return iProjectPlanDao.selectProjectPlan(projectPlan);
    }

    /**
     * 修改项目计划
     * @param projectPlan 项目计划
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean updateProjectPlan2(ProjectPlan projectPlan) throws Exception {
        logger.debug("修改项目计划");
        int count = iProjectPlanDao.updateProjectPlan2(projectPlan);
        if (0 == count) {
            return false;
        }
        return true;
    }

}
