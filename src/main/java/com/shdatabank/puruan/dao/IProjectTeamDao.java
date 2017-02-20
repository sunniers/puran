/**
 * ProjectTeamDao.java
 * Created at 2016-10-29
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.ProjectLeave;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.User;

/**
 * 项目小组管理dao层
 */
public interface IProjectTeamDao {

    /**
     * 查询小组成员
     * @return 返回小组成员信息
     */
    public List<ProjectUserReleation> selectTeamMember(ProjectUserReleation projectUserReleation) throws Exception;
    
    /**
     * 查询我的圈子中不在项目中的人
     * @param user 用户信息
     * @return 我的圈子
     */
    public List<User> selectMyCommunity(ProjectUserReleation projectUserReleation) throws Exception;

    /**
     * 删除小组成员
     * @param projectUserReleation 小组成员
     * @return 是否成功
     */
    public int deleteTeamMember(ProjectUserReleation projectUserReleation) throws Exception;
    
    /**
     * 请假
     * @param projectLeave 请假信息
     * @return 是否成功
     */
    public int insertProjectLeave(ProjectLeave projectLeave) throws Exception;
    
    /**
     * 改变成员状态
     * @return 是否成功
     */
    public int updateProjectLeave(ProjectLeave projectLeave) throws Exception;
    
}
