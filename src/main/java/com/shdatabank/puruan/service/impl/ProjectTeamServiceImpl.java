/**
 * ProjectTeamServiceImpl.java
 * Created at 2016-10-29
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.IProjectTeamDao;
import com.shdatabank.puruan.model.ProjectLeave;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IProjectTeamService;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 项目小组管理service层
 */
@Service
public class ProjectTeamServiceImpl implements IProjectTeamService {

    private Logger logger =Logger.getLogger(ProjectTeamServiceImpl.class);
    
    /** 项目小组管理dao */
    @Autowired
    private IProjectTeamDao iProjectTeamDao;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 查询小组成员
     * @return 返回小组成员信息
     */
    @Override
    public PageInfo<ProjectUserReleation> selectTeamMember(ProjectUserReleation projectUserReleation) throws Exception {
        //将项目id存入session中
        httpServletRequest.getSession().setAttribute("projectId", projectUserReleation.getProjectRequirementId());
        //查询小组成员
        PageHelper.startPage(projectUserReleation.getPage(), projectUserReleation.getPageSize());
        List<ProjectUserReleation> projectUserReleations = iProjectTeamDao.selectTeamMember(projectUserReleation);
        if (null != projectUserReleations) {
            for (int i = 0;i < projectUserReleations.size();i++) {
                if (null != projectUserReleations.get(i).getCreateDatetime()) {
                    projectUserReleations.get(i).setCreateDatetimeMapping(
                            UserUtil.dateConversionString(projectUserReleations.get(i).getCreateDatetime()));
                }
                if (null != projectUserReleations.get(i).getLeaveDatetime()) {
                    projectUserReleations.get(i).setLeaveDatetimeMapping(
                            UserUtil.dateConversionString(projectUserReleations.get(i).getLeaveDatetime()));
                }
            }
        }
        return new PageInfo<ProjectUserReleation> (projectUserReleations);
    }

    /**
     * 删除小组成员
     * @param projectUserReleation 小组成员
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean deleteTeamMember(ProjectUserReleation projectUserReleation) throws Exception {
        logger.debug("删除小组成员");
        int flag = iProjectTeamDao.deleteTeamMember(projectUserReleation);
        if (0 == flag) {
            return false;
        }
        return true;
    }

    /**
     * 查询我的圈子中不在项目中的人
     * @param user 用户信息
     * @return 我的圈子
     */
    @Override
    public PageInfo<User> selectMyCommunity(ProjectUserReleation projectUserReleation) throws Exception {
        PageHelper.startPage(projectUserReleation.getPage(), projectUserReleation.getPageSize());
        List<User> users = iProjectTeamDao.selectMyCommunity(projectUserReleation);
        return new PageInfo<User> (users);
    }

    /**
     * 请假
     * @param projectLeave 请假信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertProjectLeave(ProjectLeave projectLeave) throws Exception {
        logger.debug("请假");
        int count = iProjectTeamDao.insertProjectLeave(projectLeave);
        if (0 == count) {
            return false;
        }
        count = iProjectTeamDao.updateProjectLeave(projectLeave);
        if (0 == count) {
            return false;
        }
        return true;
    }

}
