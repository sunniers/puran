/**
 * ProjectPlanService.java
 * Created at 2016-11-07
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.PackageProjectPlan;
import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.User;

/**
 * 计划service层
 */
public interface IProjectPlanService {

    /**
     * 新增计划
     * @param projectPlan 计划内容
     * @return 是否成功
     */
    public boolean insertProjectPlan(ProjectPlan projectPlan) throws Exception;
    
    /**
     * 查询项目的计划
     * @param projectPlan 计划内容
     * @return 计划
     */
    public PageInfo<ProjectPlan> selectProjectPlans(ProjectPlan projectPlan) throws Exception;
    
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
    public boolean deleteProjectPlan(ProjectPlan projectPlan) throws Exception;
    
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
    public boolean insertProjectPlanTask(List<ProjectPlan> projectPlans) throws Exception;

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
    public boolean updateProjectPlan2(ProjectPlan projectPlan) throws Exception;
}
