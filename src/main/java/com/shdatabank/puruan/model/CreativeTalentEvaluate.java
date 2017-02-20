/**
 * CreativeTalentEvaluate.java
 * Created at 2016-11-02
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 创意人才评价
 */
public class CreativeTalentEvaluate {

    /** 评价ID */
    private Long evaluateId;
    
    /** 项目id */
    private Long projId;
    
    /** 买方用户id */
    private Long userId;
    
    /** 买方评价星级 */
    private Integer evaluateStar;
    
    /** 评价时间 */
    private Timestamp evaluateTime;

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

    public Integer getEvaluateStar() {
        return evaluateStar;
    }

    public void setEvaluateStar(Integer evaluateStar) {
        this.evaluateStar = evaluateStar;
    }

    public Timestamp getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Timestamp evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }
    
}
