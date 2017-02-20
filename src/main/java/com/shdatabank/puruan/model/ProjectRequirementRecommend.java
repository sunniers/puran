/**
 * ProjectRequirementRecommend.java
 * Created at 2016-11-16
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 创意需求推荐
 */
public class ProjectRequirementRecommend {

    /** 推荐ID */
    private Long recommendId;
    
    /** 创意需求ID */
    private Long projId;
    
    /** 用户ID */
    private Long userId;
    
    /** 创建时间 */
    private Timestamp createTime;
    
    /** 公司 */
    private Integer company;
    
    /** 用户 */
    private Integer user;
    
    /** 身份认证 */
    private Integer identity;
    
    /** 手机认证 */
    private Integer phone;
    
    /** 邮箱认证 */
    private Integer email;
    
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
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
