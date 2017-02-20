/**
 * EmailVerificationController.java
 * Created at 2016-10-20
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 邮箱验证
 */
public class EmailAuth {

    /** 验证id */
    private Long authId;
    
    /** 用户id */
    private Long userId;
    
    /** 验证码 */
    private String authCode;
    
    /** 创建时间 */
    private Timestamp createTime;
    
    /** 创建时间映射 */
    private String createTimeMapping;

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeMapping() {
        return createTimeMapping;
    }

    public void setCreateTimeMapping(String createTimeMapping) {
        this.createTimeMapping = createTimeMapping;
    }
    
}
