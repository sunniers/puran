/**
 * IRequirementStatusDao.java
 * Created at 2016-11-05
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.ProjectEnroll;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementRecommend;
import com.shdatabank.puruan.model.ProjectRequirementUndertake;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.RequirementManage;
import com.shdatabank.puruan.model.TalentEnroll;
import com.shdatabank.puruan.model.TalentRequirementRecommend;
import com.shdatabank.puruan.model.TalentTransaction;

/**
 * 需求管理service层
 */
public interface IRequirementManageService {

    /**
     * 查询用户的需求
     * @return 
     */
    public PageInfo<RequirementManage> selectRequirementManage(RequirementManage requirementManage) throws Exception;

    /**
     * 查询交易完成的需求
     * @param requirementManage
     * @return 
     */
    public PageInfo<RequirementManage> selectRransactionEnd(RequirementManage requirementManage) throws Exception;

    /**
     * 删除需求
     * @param requirementManage 需求信息
     * @return 
     */
    public boolean deleteRequirement(RequirementManage requirementManage) throws Exception;
    
    /**
     * 插入创意需求推荐
     * @param projectRequirementRecommend 推荐信息
     * @return 是否成功
     */
    public boolean insertProjectRequirementRecommend(
            ProjectRequirementRecommend projectRequirementRecommend) throws Exception;
    
    /**
     * 插入人才需求推荐
     * @param talentRequirementRecommends 推荐信息
     * @return 是否成功
     */
    public boolean insertTalentRequirementRecommend(
            TalentRequirementRecommend talentRequirementRecommend) throws Exception;
    
    /**
     * 查询需求推荐的企业用户
     * @param projId 需求ID
     * @return 用户信息
     */
    public List<ProjectRequirementRecommend> selectProjectCompany(Long projId) throws Exception;
    
    /**
     * 查询人才推荐的企业用户
     * @param talentRequirementId 人才ID
     * @return 用户信息
     */
    public List<TalentRequirementRecommend> selectTalentCompany(Long talentRequirementId) throws Exception;
    
    /**
     * 查询需求推荐的个人用户
     * @param projId 需求ID
     * @return 用户信息
     */
    public List<ProjectRequirementRecommend> selectProjectUser(Long projId) throws Exception;
    
    /**
     * 查询人才推荐的个人用户
     * @param talentRequirementId 人才ID
     * @return 用户信息
     */
    public List<TalentRequirementRecommend> selectTalentUser(Long talentRequirementId) throws Exception;
    
    /**
     * 查询创意需求报名信息
     * @param projId 需求ID
     * @return 报名人信息
     */
    public PageInfo<ProjectEnroll> selectProjectEnroll(ProjectEnroll projectEnroll) throws Exception;
    
    /**
     * 查询人才需求报名信息
     * @param projId 需求ID
     * @return 报名人信息
     */
    public PageInfo<TalentEnroll> selectTalentEnroll(TalentEnroll talentEnroll) throws Exception;

    /**
     * 插入创意需求承接
     * @param projectRequirementUndertake 创意需求承接
     * @return 是否成功
     */
    public boolean insertProjectRequirementUndertake(
            ProjectRequirementUndertake projectRequirementUndertake) throws Exception;
    
    /**
     * 插入人才需求交易
     * @param talentTransaction 人才交易信息
     * @return 是否成功
     */
    public boolean insertTalentTransaction(TalentTransaction talentTransaction) throws Exception;
    
    /**
     * 查询评价内容
     * @param projectUserReleation 评价内容
     * @return 评价内容
     */
    public ProjectUserReleation selectProjectUserReleation(
            ProjectUserReleation projectUserReleation) throws Exception;
    
    /**
     * 酬金托管
     * @param projectRequirement 托管项目
     * @return 托管信息
     */
    public ProjectRequirement selectProjectRequirement2(ProjectRequirement projectRequirement) throws Exception;
    
    /**
     * 更新酬金托管状态
     * @param projectRequirement 酬金托管状态
     * @return 是否成功
     */
    public boolean updateProjectRequirement(ProjectRequirement projectRequirement) throws Exception;
}
