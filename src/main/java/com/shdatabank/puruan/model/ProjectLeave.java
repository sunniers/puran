/**
 * ProjectTeamDao.java
 * Created at 2016-11-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 项目请假
 */
public class ProjectLeave {

    /** 请假ID */
    private Long leaveId;
    
    /** 项目ID */
    private Long projectId;
    
    /** 用户ID */
    private Long userId;
    
    /** 开始时间 */
    private Date startDate;
    
    /** 结束时间 */
    private Date endDate;
    
    /** 创建时间 */
    private Timestamp createTime;
    
    /** 删除标志 */
    private Byte active;

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }
    
}
