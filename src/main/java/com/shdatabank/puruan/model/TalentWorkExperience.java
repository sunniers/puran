/**
 * TalentEduExperience.java
 * Created at 2016-10-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.util.Date;

/**
 * 人才工作经历
 */
public class TalentWorkExperience {

    /** 工作经历id */
    private Long experienceId;
    
    /** 人才id */
    private Long userId;
    
    /** 开始时间 */
    private Date startDate;
    
    /** 结束日期 */
    private Date endDate;
    
    /** 工作公司 */
    private String workCompany;
    
    /** 职位 */
    private String workJob;
    
    /** 工作描述 */
    private String workDescription;
    
    /** 开始时间映射 */
    private String startDateMapping;
    
    /** 结束日期映射 */
    private String endDateMapping;
    
    /** 是否公开 */
    private Byte isOpen;

    public Long getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Long experienceId) {
        this.experienceId = experienceId;
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

    public String getWorkCompany() {
        return workCompany;
    }

    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
    }

    public String getWorkJob() {
        return workJob;
    }

    public void setWorkJob(String workJob) {
        this.workJob = workJob;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStartDateMapping() {
        return startDateMapping;
    }

    public void setStartDateMapping(String startDateMapping) {
        this.startDateMapping = startDateMapping;
    }

    public String getEndDateMapping() {
        return endDateMapping;
    }

    public void setEndDateMapping(String endDateMapping) {
        this.endDateMapping = endDateMapping;
    }

    public Byte getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Byte isOpen) {
        this.isOpen = isOpen;
    }
    
}
