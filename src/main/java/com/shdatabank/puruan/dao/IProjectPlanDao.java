/**
 * IProjectPlanDao.java
 * Created at 2016-11-07
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.PackageProjectPlan;
import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ProjectPlanTask;
import com.shdatabank.puruan.model.User;

/**
 * 项目计划dao层
 */
public interface IProjectPlanDao {

    /**
     * 新增计划
     * @param projectPlan 计划内容
     * @return 是否成功
     */
    public int insertProjectPlan(ProjectPlan projectPlan) throws Exception;
    
    /**
     * 查询项目的计划
     * @param projectPlan 计划内容
     * @return 计划
     */
    public List<ProjectPlan> selectProjectPlans(ProjectPlan projectPlan) throws Exception;
    
    /**
     * 查询项目分包的计划
     * @param packageProjectPlan 分包计划
     * @return 分包计划
     */
    public List<PackageProjectPlan> selectPackageProjectPlans(PackageProjectPlan packageProjectPlan) throws Exception;

    /**
     * 删除计划
     * @param projectPlan 计划
     * @return 是否成功
     */
    public int deleteProjectPlan(ProjectPlan projectPlan) throws Exception;
    
    /**
     * 更新前置计划为删除计划的计划
     * @param projectPlan 计划
     * @return 是否成功
     */
    public int updateProjectPlan(ProjectPlan projectPlan) throws Exception;
    
    /**
     * 查询所有父计划
     * @param projectPlan 计划
     * @return 父计划
     */
    public List<ProjectPlan> selectAllParentPlan(ProjectPlan projectPlan) throws Exception;

    /**
     * 查询父计划中的子计划
     * @param projectPlan 计划
     * @return 子计划
     */
    public List<ProjectPlan> selectChildPlan(ProjectPlan projectPlan) throws Exception;
    
    /**
     * 查询团队成员
     * @param projectPlan 计划
     * @return 团队成员
     */
    public List<User> selectClassMember(ProjectPlan projectPlan) throws Exception;
    
    /**
     * 生成任务
     * @param projectPlanTask
     * @return 是否成功
     */
    public int insertProjectPlanTask(List<ProjectPlanTask> projectPlanTasks) throws Exception;
    
    /**
     * 查询项目计划的详细信息
     * @param projectPlan 项目计划
     * @return 项目计划的详细信息
     */
    public ProjectPlan selectProjectPlan(ProjectPlan projectPlan) throws Exception;
    
    /**
     * 修改项目计划
     * @param projectPlan 项目计划
     * @return 是否成功
     */
    public int updateProjectPlan2(ProjectPlan projectPlan) throws Exception;
}
