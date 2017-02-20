/**
 * ProjectRequirementChange.java
 * Created at 2016-11-09
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * 需求变更
 */
public class ProjectRequirementChange {

    /** 创意需求变更ID */
    private Long projRequirementChangeId;
    
    /** 创意需求ID */
    private Long projRequirementId;
    private String projRequirementName;
    
    /** 发起人ID */
    private Long publishUserId;
    private String userAlias;
    
    /** 对象ID */
    private Long targetUserId;
    private String targetUserAlias;
    
    /** 对象ID数组 */
    private List<Long> userIds;
    
    /** 预算 */
    private Double projBudget;
    
    /** 变更内容 */
    private String changeContent;
    
    /** 预计开始时间 */
    private Timestamp startDatetime;
    
    /** 预计结束世间 */
    private Timestamp endDatetime;
    
    /** 变更状态 */
    private Integer changeStatus;
    
    /** 创建时间 */
    private Timestamp createTime;
    
    /** 删除标志 */
    private Byte active;
    
    /** 标志 */
    private String type;
    
    /** page */
    private Integer page;
    
    /** pageSize */
    private Integer pageSize;

    public Long getProjRequirementChangeId() {
        return projRequirementChangeId;
    }

    public void setProjRequirementChangeId(Long projRequirementChangeId) {
        this.projRequirementChangeId = projRequirementChangeId;
    }

    public Long getProjRequirementId() {
        return projRequirementId;
    }

    public void setProjRequirementId(Long projRequirementId) {
        this.projRequirementId = projRequirementId;
    }

    public String getProjRequirementName() {
        return projRequirementName;
    }

    public void setProjRequirementName(String projRequirementName) {
        this.projRequirementName = projRequirementName;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public Double getProjBudget() {
        return projBudget;
    }

    public void setProjBudget(Double projBudget) {
        this.projBudget = projBudget;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    public Timestamp getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Timestamp startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Timestamp getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Timestamp endDatetime) {
        this.endDatetime = endDatetime;
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(Integer changeStatus) {
        this.changeStatus = changeStatus;
    }

    public Long getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Long targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getTargetUserAlias() {
        return targetUserAlias;
    }

    public void setTargetUserAlias(String targetUserAlias) {
        this.targetUserAlias = targetUserAlias;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
    
}
