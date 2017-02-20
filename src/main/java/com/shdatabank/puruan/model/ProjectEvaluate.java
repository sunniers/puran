/**
 * ProjectEvaluate.java
 * Created at 2016-11-02
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 项目评论
 */
public class ProjectEvaluate {

    /** 评论id */
    private Long evaluateId;
    
    /** 项目id */
    private Long projId;
    private String projName;
    
    /** 用户id */
    private Long userId;
    private String userAlias;
    
    /** 评论内容 */
    private String evaluateValue;
    
    /** 评论时间 */
    private Timestamp evaluateTime;
    
    /** page */
    private Integer page;
    
    /** pageSize */
    private Integer pageSize;

    public Long getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEvaluateValue() {
        return evaluateValue;
    }

    public void setEvaluateValue(String evaluateValue) {
        this.evaluateValue = evaluateValue;
    }

    public Timestamp getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Timestamp evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
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
      
}
