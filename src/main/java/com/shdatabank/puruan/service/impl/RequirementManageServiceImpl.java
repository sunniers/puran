/**
 * RequirementManageServiceImpl.java
 * Created at 2016-11-05
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.IRequirementManageDao;
import com.shdatabank.puruan.model.ProjectEnroll;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementRecommend;
import com.shdatabank.puruan.model.ProjectRequirementUndertake;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.RequirementManage;
import com.shdatabank.puruan.model.TalentEnroll;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.TalentRequirementRecommend;
import com.shdatabank.puruan.model.TalentTransaction;
import com.shdatabank.puruan.service.IRequirementManageService;

/**
 * 需求管理service层
 */
@Service
public class RequirementManageServiceImpl implements IRequirementManageService {

    private Logger logger =Logger.getLogger(ProjectTeamServiceImpl.class);
    
    /** 需求管理dao */
    @Autowired
    private IRequirementManageDao iRequirementManageDao;
    
    /**
     * 查询用户的需求
     * @return 
     */
    @Override
    public PageInfo<RequirementManage> selectRequirementManage(RequirementManage requirementManage) throws Exception {
        if (null == requirementManage.getPage()) {
            return null;
        }
        if (null == requirementManage.getPageSize()) {
            return null;
        }
        PageHelper.startPage(requirementManage.getPage(), requirementManage.getPageSize());
        List<RequirementManage> requirementManages = iRequirementManageDao.selectRequirementManage(requirementManage);
        return new PageInfo<RequirementManage> (requirementManages);
    }

    /**
     * 查询交易完成的需求
     * @param requirementManage
     * @return 
     */
    @Override
    public PageInfo<RequirementManage> selectRransactionEnd(RequirementManage requirementManage) throws Exception {
        if (null == requirementManage.getPage()) {
            return null;
        }
        if (null == requirementManage.getPageSize()) {
            return null;
        }
        PageHelper.startPage(requirementManage.getPage(), requirementManage.getPageSize());
        List<RequirementManage> requirementManages = iRequirementManageDao.selectRransactionEnd(requirementManage);
        return new PageInfo<RequirementManage> (requirementManages);
    }

    /**
     * 删除需求
     * @param requirementManage 需求信息
     * @return 
     */
    @Transactional
    @Override
    public boolean deleteRequirement(RequirementManage requirementManage) throws Exception {
        logger.debug("删除需求");
        if (700001 == requirementManage.getRequirementType()) {
            int count = iRequirementManageDao.deleteProjectRequirement(requirementManage.getRequirementId());
            if (0 == count) {
                return false;
            }
        } else if (700002 == requirementManage.getRequirementType()) {
            int count = iRequirementManageDao.deleteTalentRequirement(requirementManage.getRequirementId());
            if (0 == count) {
                return false;
            }
        }
        return true;
    }

    /**
     * 插入创意需求推荐
     * @param projectRequirementRecommend 推荐信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertProjectRequirementRecommend(ProjectRequirementRecommend projectRequirementRecommend)
            throws Exception {
        logger.debug("插入创意需求推荐");
        ProjectRequirement projectRequirement = iRequirementManageDao.selectProjectRequirement(
                projectRequirementRecommend.getProjId());
        if (null == projectRequirement) {
            return false;
        }
        //发布方式
        if (null != projectRequirement.getPublishWay()) {
            String[] s = projectRequirement.getPublishWay().split(",");
            for (int i = 0;i < s.length;i++) {
                if ("1".equals(s[i])) {
                    
                }
                if ("2".equals(s[i])) {
                    
                }
                if ("3".equals(s[i])) {
                    //供方类型
                    if (null != projectRequirement.getProviderType()) {
                        String[] s1 = projectRequirement.getProviderType().split(",");
                        for (int i1 = 0;i1 < s1.length;i1++) {
                            if ("1".equals(s1[i1])) {
                                projectRequirementRecommend.setCompany(1);
                            }
                            if ("2".equals(s1[i1])) {
                                projectRequirementRecommend.setUser(1);
                            }
                        }
                    }
                    //认证要求
                    if (null != projectRequirement.getAuthenticationRequirement()) {
                        String[] s1 = projectRequirement.getAuthenticationRequirement().split(",");
                        for (int i1 = 0;i1 < s1.length;i1++) {
                            if ("1".equals(s1[i1])) {
                                projectRequirementRecommend.setIdentity(1);
                            }
                            if ("2".equals(s1[i1])) {
                                projectRequirementRecommend.setPhone(1);
                            }
                            if ("3".equals(s1[i1])) {
                                projectRequirementRecommend.setEmail(1);
                            }
                        }
                    }
                    //查询推荐人数
                    List<ProjectRequirementRecommend> projectRequirementRecommends = 
                            iRequirementManageDao.selectProjectRequirementRecommend(projectRequirementRecommend);
                    
                    if (null != projectRequirementRecommends) {
                        for (int i2 = 0;i2 < projectRequirementRecommends.size(); i2++) {
                            projectRequirementRecommends.get(i2).setProjId(projectRequirement.getProjId());
                        }
                        
                        int count = iRequirementManageDao.insertProjectRequirementRecommend(projectRequirementRecommends);
                        if (0 == count) {
                            return false;
                        }            
                    }
                }
            }
        }
        
        return true;
    }

    /**
     * 插入人才需求推荐
     * @param talentRequirementRecommends 推荐信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertTalentRequirementRecommend(TalentRequirementRecommend talentRequirementRecommend)
            throws Exception {
        logger.debug("插入人才需求推荐");
        TalentRequirement talentRequirement = iRequirementManageDao.selectTalentRequirement(
                talentRequirementRecommend.getTalentId());
        if (null == talentRequirement) {
            return false;
        }
        if (null != talentRequirement.getPublishWay()) {
            String[] s = talentRequirement.getPublishWay().split(",");
            for (int i = 0;i < s.length;i++) {
                if ("1".equals(s[i])) {
                    
                }
                if ("2".equals(s[i])) {
                                    
                                }
                if ("3".equals(s[i])) {
                    List<TalentRequirementRecommend> talentRequirementRecommends = 
                            iRequirementManageDao.selectTalentRequirementRecommend(talentRequirementRecommend);
                    if (null == talentRequirementRecommends) {
                        return false;
                    }
                    for (int i2 = 0;i2 < talentRequirementRecommends.size();i2++) {
                        talentRequirementRecommends.get(i2).setTalentId(talentRequirement.getTalentRequirementId());
                    }
                    int count = iRequirementManageDao.insertTalentRequirementRecommend(talentRequirementRecommends);
                    if (0 == count) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 查询需求推荐的企业用户
     * @param projId 需求ID
     * @return 用户信息
     */
    @Override
    public List<ProjectRequirementRecommend> selectProjectCompany(Long projId) throws Exception {
        return iRequirementManageDao.selectProjectCompany(projId);
    }

    /**
     * 查询人才推荐的企业用户
     * @param talentRequirementId 人才ID
     * @return 用户信息
     */
    @Override
    public List<TalentRequirementRecommend> selectTalentCompany(Long talentRequirementId) throws Exception {
        return iRequirementManageDao.selectTalentCompany(talentRequirementId);
    }

    /**
     * 查询需求推荐的个人用户
     * @param projId 需求ID
     * @return 用户信息
     */
    @Override
    public List<ProjectRequirementRecommend> selectProjectUser(Long projId) throws Exception {
        return iRequirementManageDao.selectProjectUser(projId);
    }

    /**
     * 查询人才推荐的个人用户
     * @param talentRequirementId 人才ID
     * @return 用户信息
     */
    @Override
    public List<TalentRequirementRecommend> selectTalentUser(Long talentRequirementId) throws Exception {
        return iRequirementManageDao.selectTalentUser(talentRequirementId);
    }

    /**
     * 查询创意需求报名信息
     * @param projId 需求ID
     * @return 报名人信息
     */
    @Override
    public PageInfo<ProjectEnroll> selectProjectEnroll(ProjectEnroll projectEnroll) throws Exception {
        PageHelper.startPage(projectEnroll.getPage(),projectEnroll.getPageSize());
        return new PageInfo<ProjectEnroll>(iRequirementManageDao.selectProjectEnroll(projectEnroll));
    }

    /**
     * 查询人才需求报名信息
     * @param projId 需求ID
     * @return 报名人信息
     */
    @Override
    public PageInfo<TalentEnroll> selectTalentEnroll(TalentEnroll talentEnroll) throws Exception {
        PageHelper.startPage(talentEnroll.getPage(),talentEnroll.getPageSize());
        return new PageInfo<TalentEnroll>(iRequirementManageDao.selectTalentEnroll(talentEnroll));
    }

    /**
     * 插入创意需求承接
     * @param projectRequirementUndertake 创意需求承接
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertProjectRequirementUndertake(ProjectRequirementUndertake projectRequirementUndertake)
            throws Exception {
        logger.debug("插入创意需求承接");
        int count = iRequirementManageDao.insertProjectRequirementUndertake(projectRequirementUndertake);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 插入人才需求交易
     * @param talentTransaction 人才交易信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertTalentTransaction(TalentTransaction talentTransaction) throws Exception {
        logger.debug("插入人才需求交易");
        int count = iRequirementManageDao.insertTalentTransaction(talentTransaction);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 查询评价内容
     * @param projectUserReleation 评价内容
     * @return 评价内容
     */
    @Override
    public ProjectUserReleation selectProjectUserReleation(ProjectUserReleation projectUserReleation) throws Exception {
        return iRequirementManageDao.selectProjectUserReleation(projectUserReleation);
    }

    /**
     * 酬金托管
     * @param projectRequirement 托管项目
     * @return 托管信息
     */
    @Override
    public ProjectRequirement selectProjectRequirement2(ProjectRequirement projectRequirement) throws Exception {
        return iRequirementManageDao.selectProjectRequirement2(projectRequirement);
    }

    /**
     * 更新酬金托管状态
     * @param projectRequirement 酬金托管状态
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean updateProjectRequirement(ProjectRequirement projectRequirement) throws Exception {
        logger.debug("更新酬金托管状态");
        int count = iRequirementManageDao.updateProjectRequirement(projectRequirement);
        if (0 == count) {
            return false;
        }
        return true;
    }

}
