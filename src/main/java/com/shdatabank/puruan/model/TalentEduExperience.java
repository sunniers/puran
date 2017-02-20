/**
 * TalentEduExperience.java
 * Created at 2016-10-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.util.Date;

/**
 * 人才教育经历
 */
public class TalentEduExperience {
    
    /** 教育经历id */
    private Long experienceId;
    
    /** 人才id */
    private Long userId;
    
    /** 学历 */
    private String talentDegree;
    
    /** 学校 */
    private String talentSchool;
    
    /** 专业 */
    private String talentProfession;
    
    /** 毕业时间 */
    private Date finishDate;
    
    /** 备注 */
    private String memo;
    
    /** 毕业时间映射 */
    private String finishDateMapping;
    
    /** 是否公开 */
    private Byte isOpen;

    public Long getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Long experienceId) {
        this.experienceId = experienceId;
    }

    public String getTalentDegree() {
        return talentDegree;
    }

    public void setTalentDegree(String talentDegree) {
        this.talentDegree = talentDegree;
    }

    public String getTalentSchool() {
        return talentSchool;
    }

    public void setTalentSchool(String talentSchool) {
        this.talentSchool = talentSchool;
    }

    public String getTalentProfession() {
        return talentProfession;
    }

    public void setTalentProfession(String talentProfession) {
        this.talentProfession = talentProfession;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getFinishDateMapping() {
        return finishDateMapping;
    }

    public void setFinishDateMapping(String finishDateMapping) {
        this.finishDateMapping = finishDateMapping;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Byte isOpen) {
        this.isOpen = isOpen;
    }
    
}
