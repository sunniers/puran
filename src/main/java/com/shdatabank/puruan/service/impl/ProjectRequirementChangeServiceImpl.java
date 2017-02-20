/**
 * ProjectRequirementChangeServiceImpl.java
 * Created at 2016-11-09
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
import com.shdatabank.puruan.dao.IProjectRequirementChangeDao;
import com.shdatabank.puruan.model.ProjectRequirementChange;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IProjectRequirementChangeService;

/**
 * 需求变更service层
 */
@Service
public class ProjectRequirementChangeServiceImpl implements IProjectRequirementChangeService {
    
    private Logger logger =Logger.getLogger(ProjectRequirementChangeServiceImpl.class);

    /** 需求变更dao */
    @Autowired
    private IProjectRequirementChangeDao iProjectRequirementChangeDao;
    
    /**
     * 查询变更的基本信息
     * @param projectRequirementChange 查询条件
     * @return 变更的基本信息
     */
    @Override
    public ProjectRequirementChange selectProjectRequirementChange(ProjectRequirementChange projectRequirementChange)
            throws Exception {
        return iProjectRequirementChangeDao.selectProjectRequirementChange(projectRequirementChange);
    }

    /**
     * 插入需求变更
     * @param projectRequirementChange 变更内容
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertProjectRequirementChange(ProjectRequirementChange projectRequirementChange) throws Exception {
        logger.debug("插入需求变更");
        if (null == projectRequirementChange.getUserIds()) {
            int count = iProjectRequirementChangeDao.insertProjectRequirementChange(projectRequirementChange);
            if (0 == count) {
                return false;
            }            
        } else {
            for (int i = 0;i < projectRequirementChange.getUserIds().size();i++) {
                projectRequirementChange.setTargetUserId(projectRequirementChange.getUserIds().get(i));
                int count = iProjectRequirementChangeDao.insertProjectRequirementChange(projectRequirementChange);
                if (0 == count) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 查询成员信息
     * @param projectRequirementChange 变更内容
     * @return 成员信息
     */
    @Override
    public List<User> selectClassMember(ProjectRequirementChange projectRequirementChange) throws Exception {
        return iProjectRequirementChangeDao.selectClassMember(projectRequirementChange);
    }

    /**
     * 查询所有的变更信息
     * @param projectRequirementChange 变更内容
     * @return 变更信息
     */
    @Override
    public PageInfo<ProjectRequirementChange> selectAllChanges(ProjectRequirementChange projectRequirementChange)
            throws Exception {
        PageHelper.startPage(projectRequirementChange.getPage(), projectRequirementChange.getPageSize());
        List<ProjectRequirementChange> projectRequirementChanges = 
                iProjectRequirementChangeDao.selectAllChanges(projectRequirementChange);
        return new PageInfo<ProjectRequirementChange> (projectRequirementChanges);
    }

    /**
     * 查询详细信息
     * @param projectRequirementChange 变更内容
     * @return 变更信息
     */
    @Override
    public ProjectRequirementChange selectChange(ProjectRequirementChange projectRequirementChange) throws Exception {
        return iProjectRequirementChangeDao.selectChange(projectRequirementChange);
    }

    /**
     * 修改变更内容
     * @param projectRequirementChange 变更内容
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean updateProjectRequirementChange(ProjectRequirementChange projectRequirementChange) throws Exception {
        logger.debug("修改变更内容");
        int count = iProjectRequirementChangeDao.updateProjectRequirementChange(projectRequirementChange);
        if (0 == count) {
            return false;
        }
        return true;
    }

}
