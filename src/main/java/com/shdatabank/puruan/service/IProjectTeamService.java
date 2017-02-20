/**
 * IProjectTeamService.java
 * Created at 2016-10-29
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.ProjectLeave;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.User;

/**
 * 项目小组管理service层
 */
public interface IProjectTeamService {

    /**
     * 查询小组成员
     * @return 返回小组成员信息
     */
    public PageInfo<ProjectUserReleation> selectTeamMember(ProjectUserReleation projectUserReleation) throws Exception;

    /**
     * 查询我的圈子中不在项目中的人
     * @param user 用户信息
     * @return 我的圈子
     */
    public PageInfo<User> selectMyCommunity(ProjectUserReleation projectUserReleation) throws Exception;
    
    /**
     * 删除小组成员
     * @param projectUserReleation 小组成员
     * @return 是否成功
     */
    public boolean deleteTeamMember(ProjectUserReleation projectUserReleation) throws Exception;
    
    /**
     * 请假
     * @param projectLeave 请假信息
     * @return 是否成功
     */
    public boolean insertProjectLeave(ProjectLeave projectLeave) throws Exception;
}
