/**
 * UserBehavior.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 用户行为
 */
public class UserBehavior {

    /** id */
    private Integer logId;
    
    /** 记录时间 */
    private Timestamp logDatetime;
    
    /** 用户id */
    private Long userId;
    
    /** 日志类型 */
    private String logType;
    
    /** 日志标记 */
    private String logStatus;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Timestamp getLogDatetime() {
        return logDatetime;
    }

    public void setLogDatetime(Timestamp logDatetime) {
        this.logDatetime = logDatetime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }
    
}
