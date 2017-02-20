/**
 * CreativeResourceEvaluate.java
 * Created at 2016-11-02
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 创意资源评价
 */
public class CreativeResourceEvaluate {

    /** 评价id */
    private Long evaluateId;
    
    /** 评价用户id */
    private Long userId;
    private String userAlias;
    
    /** 创意资源交易id */
    private Long transactionId;
    
    /** 创意资源id */
    private Long creativeResourceId;
    
    /** 评价星级 */
    private Integer evaluateStar;
    
    /** 评价内容 */
    private String evaluateValue;
    
    /** 追加评论 */
    private String evaluateAppend;
    
    /** 解释 */
    private String explain;
    
    /** 评论时间 */
    private Timestamp evaluateTime;
    
    /** 追加时间 */
    private Timestamp appendTime;
    
    /** 解释时间 */
    private Timestamp explainTime;
    
    /** page */
    private Integer page;
    
    /** pageSize */
    private Integer pageSize;
    
    /**  */
    private String resourceImage;
    
    /**  */
    private String resourceName;
    
    /**  */
    private String resourceDescription;
    
    /**  */
    private Double transactionPrice;
    
    /**  */
    private Timestamp transactionDatetime;

    public Long getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getEvaluateStar() {
        return evaluateStar;
    }

    public void setEvaluateStar(Integer evaluateStar) {
        this.evaluateStar = evaluateStar;
    }

    public String getEvaluateValue() {
        return evaluateValue;
    }

    public void setEvaluateValue(String evaluateValue) {
        this.evaluateValue = evaluateValue;
    }

    public String getEvaluateAppend() {
        return evaluateAppend;
    }

    public void setEvaluateAppend(String evaluateAppend) {
        this.evaluateAppend = evaluateAppend;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Timestamp getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Timestamp evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public Timestamp getAppendTime() {
        return appendTime;
    }

    public void setAppendTime(Timestamp appendTime) {
        this.appendTime = appendTime;
    }

    public Timestamp getExplainTime() {
        return explainTime;
    }

    public void setExplainTime(Timestamp explainTime) {
        this.explainTime = explainTime;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public Long getCreativeResourceId() {
        return creativeResourceId;
    }

    public void setCreativeResourceId(Long creativeResourceId) {
        this.creativeResourceId = creativeResourceId;
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

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public Double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(Double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public Timestamp getTransactionDatetime() {
        return transactionDatetime;
    }

    public void setTransactionDatetime(Timestamp transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }
    
}
