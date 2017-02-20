/**
 * ProjectAdministrationServiceImpl.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.IProjectAdministrationDao;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.service.IProjectAdministrationService;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 项目管理service层
 */
@Service
public class ProjectAdministrationServiceImpl implements IProjectAdministrationService {

    private Logger logger =Logger.getLogger(ProjectAdministrationServiceImpl.class);
    
    /** 项目管理dao */
    @Autowired
    private IProjectAdministrationDao iProjectAdministrationDao;
    
    /**
     * 查询已报名的项目
     * @param user 用户id
     * @return 项目信息
     */
    @Override
    public PageInfo<ProjectRequirement> selectEnrollTrue(ProjectRequirement projectRequirement) throws Exception {
        PageHelper.startPage(projectRequirement.getPage(), projectRequirement.getPageSize());
        List<ProjectRequirement> projectRequirements = iProjectAdministrationDao.selectEnrollTrue(projectRequirement);
        return new PageInfo<ProjectRequirement>(projectRequirements);
    }

    /**
     * 查询未接纳的项目
     * @param user 用户id
     * @return 项目信息
     */
    @Override
    public PageInfo<ProjectRequirement> selectEnrollFalse(ProjectRequirement projectRequirement) throws Exception {
        PageHelper.startPage(projectRequirement.getPage(), projectRequirement.getPageSize());
        List<ProjectRequirement> projectRequirements = iProjectAdministrationDao.selectEnrollFalse(projectRequirement);
        return new PageInfo<ProjectRequirement>(projectRequirements);
    }

    /**
     * 查询进行中的项目
     * @param user 用户id
     * @return 项目信息
     */
    @Override
    public PageInfo<ProjectRequirement> selectRunningObj(ProjectRequirement projectRequirement) throws Exception {
        PageHelper.startPage(projectRequirement.getPage(), projectRequirement.getPageSize());
        List<ProjectRequirement> projectRequirements = iProjectAdministrationDao.selectRunningObj(projectRequirement);
        if (null != projectRequirements) {
            for (int i = 0;i<projectRequirements.size();i++) {
                if (null != projectRequirements.get(i).getProjDevlierDate()) {
                    projectRequirements.get(i).setProjDevlierDateMapping(UserUtil.dateConversionString(
                            projectRequirements.get(i).getProjDevlierDate()));
                }
            }
        }
        return new PageInfo<ProjectRequirement>(projectRequirements);
    }

    /**
     * 查询已完成的项目
     * @param user 用户id
     * @return 项目信息
     */
    @Override
    public PageInfo<ProjectRequirement> selectEndObj(ProjectRequirement projectRequirement) throws Exception {
        PageHelper.startPage(projectRequirement.getPage(), projectRequirement.getPageSize());
        List<ProjectRequirement> projectRequirements = iProjectAdministrationDao.selectEndObj(projectRequirement);
        if (null != projectRequirements) {
            for (int i = 0;i<projectRequirements.size();i++) {
                if (null != projectRequirements.get(i).getProjDevlierDate()) {
                    projectRequirements.get(i).setProjDevlierDateMapping(UserUtil.dateConversionString(
                            projectRequirements.get(i).getProjDevlierDate()));
                }
            }
        }
        return new PageInfo<ProjectRequirement>(projectRequirements);
    }

    /**
     * 取消报名
     * @param projectRequirement 报名者信息
     * @return 是否成功
     */
    @Override
    public boolean deleteEnroll(ProjectRequirement projectRequirement) throws Exception {
        logger.debug("取消报名");
        int flag = iProjectAdministrationDao.deleteEnroll(projectRequirement);
        if (0 == flag) {
            return false;
        }
        return true;
    }

}
