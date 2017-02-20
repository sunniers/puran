/**
 * ProjectRequirementRecommend.java
 * Created at 2016-11-16
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 创意人才推荐
 */
public class TalentRequirementRecommend {

    /** 推荐ID */
    private Long recommendId;
    
    /** 创意人才ID */
    private Long talentId;
    
    /** 用户ID */
    private Long userId;
    
    /** 创建时间 */
    private Timestamp createTime;
    
    private String userAlias;
    
    private String emails;
    
    private String mobile;
    
    private Double stars;
    
    private String type;
    
    /** 承接状态 */
    private String undertakeStatus;
    
    /** 是否可以再次选择 */
    private Integer isChoose;

    public Long getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Long recommendId) {
        this.recommendId = recommendId;
    }

    public Long getTalentId() {
        return talentId;
    }

    public void setTalentId(Long talentId) {
        this.talentId = talentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUndertakeStatus() {
        return undertakeStatus;
    }

    public void setUndertakeStatus(String undertakeStatus) {
        this.undertakeStatus = undertakeStatus;
    }

    public Integer getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(Integer isChoose) {
        this.isChoose = isChoose;
    }
    
}
