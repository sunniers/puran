/**
 * IProjectRequirementChangeDao.java
 * Created at 2016-11-09
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.ProjectRequirementChange;
import com.shdatabank.puruan.model.User;

/**
 * 需求变更dao层
 */
public interface IProjectRequirementChangeDao {


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
    public int insertProjectRequirementChange(
            ProjectRequirementChange projectRequirementChange) throws Exception;

    /**
     * 判断登录用户是否为项目的负责人
     * @param projectRequirementChange 变更内容
     * @return 是否为负责人
     */
    public int selectPublishUser(ProjectRequirementChange projectRequirementChange) throws Exception;
    
    /**
     * 查询登录用户为管理员的团员的用户信息
     * @param projectRequirementChange 变更内容
     * @return 用户信息
     */
    public List<User> selectClassMember(ProjectRequirementChange projectRequirementChange) throws Exception;
    
    /**
     * 查询登录用户不为管理员的团员的用户信息
     * @param projectRequirementChange 变更内容
     * @return 用户信息
     */
    public List<User> selectClassManger(ProjectRequirementChange projectRequirementChange) throws Exception;

    /**
     * 查询所有的变更信息
     * @param projectRequirementChange 变更内容
     * @return 变更信息
     */
    public List<ProjectRequirementChange> selectAllChanges(
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
    public int updateProjectRequirementChange(
            ProjectRequirementChange projectRequirementChange) throws Exception;
}
