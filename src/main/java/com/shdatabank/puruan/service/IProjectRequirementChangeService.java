/**
 * IProjectRequirementChangeService.java
 * Created at 2016-11-09
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.ProjectRequirementChange;
import com.shdatabank.puruan.model.User;

/**
 * 需求变更service层
 */
public interface IProjectRequirementChangeService {

    /**
     * 查询变更的基本信息
     * @param projectRequirementChange 查询条件
     * @return 变更的基本信息
     */
    public ProjectRequirementChange selectProjectRequirementChange(
            ProjectRequirementChange projectRequirementChange) throws Exception;
    
    /**
     * 插入需求变更
     * @param projectRequirementChange 变更内容
     * @return 是否成功
     */
    public boolean insertProjectRequirementChange(
            ProjectRequirementChange projectRequirementChange) throws Exception;
    
    /**
     * 查询成员信息
     * @param projectRequirementChange 变更内容
     * @return 成员信息
     */
    public List<User> selectClassMember(
            ProjectRequirementChange projectRequirementChange) throws Exception;
    
    /**
     * 查询所有的变更信息
     * @param projectRequirementChange 变更内容
     * @return 变更信息
     */
    public PageInfo<ProjectRequirementChange> selectAllChanges(
            ProjectRequirementChange projectRequirementChange) throws Exception;
    
    /**
     * 查询详细信息
     * @param projectRequirementChange 变更内容
     * @return 变更信息
     */
    public ProjectRequirementChange selectChange(
            ProjectRequirementChange projectRequirementChange) throws Exception;

    /**
     * 修改变更内容
     * @param projectRequirementChange 变更内容
     * @return 是否成功
     */
    public boolean updateProjectRequirementChange(
            ProjectRequirementChange projectRequirementChange) throws Exception;
}
