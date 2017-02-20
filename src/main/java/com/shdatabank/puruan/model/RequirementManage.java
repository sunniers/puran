/**
 * RequirementManage.java
 * Created at 2016-11-05
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 需求管理
 */
public class RequirementManage {
    
    /** 用户ID */
    private Long userId;
    
    /** 用户昵称 */
    private String userAlias;
    
    /** 需求ID */
    private Long requirementId;
    
    /** 需求名称 */
    private String requirementName;
    
    /** 创建时间 */
    private Timestamp createDatetime;
    
    /** 需求描述 */
    private String requirementDescribe;
    
    /** 需求状态 */
    private String requirementStatus;
    private Integer status;
    
    /** 收藏人数 */
    private Integer requirementHouse;
    
    /** 报名人数 */
    private Integer requirementEnroll;
    
    /** 推荐人数 */
    private Integer requirementRecommend;
    
    /** 需求类型 */
    private Integer requirementType;
    
    /** page */
    private Integer page;
    
    /** pageSize */
    private Integer pageSize;
    
    /** 排序 */
    private String orderBy;
    
    /** 排序方式 */
    private String asc;
    
    /** 模糊查询 */
    private String search;
    
    /** 酬金是否托管 */
    private Integer isFeeTrusteeship;
    
    /** 是否能评价 */
    private Integer isEvaluate;

    public Long getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Long requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getRequirementDescribe() {
        return requirementDescribe;
    }

    public void setRequirementDescribe(String requirementDescribe) {
        this.requirementDescribe = requirementDescribe;
    }

    public String getRequirementStatus() {
        return requirementStatus;
    }

    public void setRequirementStatus(String requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    public Integer getRequirementHouse() {
        return requirementHouse;
    }

    public void setRequirementHouse(Integer requirementHouse) {
        this.requirementHouse = requirementHouse;
    }

    public Integer getRequirementEnroll() {
        return requirementEnroll;
    }

    public void setRequirementEnroll(Integer requirementEnroll) {
        this.requirementEnroll = requirementEnroll;
    }

    public Integer getRequirementRecommend() {
        return requirementRecommend;
    }

    public void setRequirementRecommend(Integer requirementRecommend) {
        this.requirementRecommend = requirementRecommend;
    }

    public Integer getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(Integer requirementType) {
        this.requirementType = requirementType;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getAsc() {
        return asc;
    }

    public void setAsc(String asc) {
        this.asc = asc;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getIsFeeTrusteeship() {
        return isFeeTrusteeship;
    }

    public void setIsFeeTrusteeship(Integer isFeeTrusteeship) {
        this.isFeeTrusteeship = isFeeTrusteeship;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(Integer isEvaluate) {
        this.isEvaluate = isEvaluate;
    }
    
}
