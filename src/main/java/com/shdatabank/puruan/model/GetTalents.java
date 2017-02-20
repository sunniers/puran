/**
 * GetTalents.java
 * Created at 2016-11-22
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 创意人才
 */
public class GetTalents {
    
    /** 创意人才id */
    private Long creativeTalentId;
    
    /** 创意人才名称 */
    private String talentName;
    
    /** 工作模式 */
    private String workMode;
    
    /** 工作时间 */
    private String workTime;
    
    /** 工作经验 */
    private String talentWorkExperienct;

    /** 用户ID */
    private Long userId;
    
    /** 用户昵称 */
    private String userAlias;
    
    /** 用户头像 */
    private String userHeaderImg;
    
    /** 用户头像名称 */
    private String userHeaderName;
    
    /** 是否认证身份 */
    private Integer isAuthentication;
    
    /** 邮箱 */
    private String userEmail;
    
    /** 电话 */
    private String userMobile;
    
    /** 专业技能 */
    private String technologies;
    
    /** 用户评价 */
    private Double stars;
    
    /** 承接次数 */
    private Integer userCount;
    
    /** 被收藏数 */
    private Integer houseCount;
    
    /** 期望薪资 */
    private BigDecimal hopeSalary;
    
    /** 所在地 */
    private String nowAddress;
    
    /** 发布时间 */
    private Timestamp publishDateTime;
    
    /** page */
    private Integer page;
    
    /** pageSize */
    private Integer pageSize;
    
    /** 查询条件 */
    private String search;
    
    /** 排序 */
    private String orderBy;
    
    /** 排序方式 */
    private String asc;
    
    /** 技能 */
    private List<Integer> technologiy;
    
    /** 实名认证 */
    private Integer isName;
    
    /** 手机认证 */
    private Integer isMobile;
    
    /** 邮箱认证 */
    private Integer isEmail;
    
    /** 技能特长 */
    private String talentDescription;
    
    /** 是否已收藏 */
    private Integer isHouse;
    
    /** 是否已添加圈子 */
    private Integer isCommunity;
    
    /** 是否可招募 */
    private Integer isGet;

    public Long getCreativeTalentId() {
        return creativeTalentId;
    }

    public void setCreativeTalentId(Long creativeTalentId) {
        this.creativeTalentId = creativeTalentId;
    }

    public String getTalentName() {
        return talentName;
    }

    public void setTalentName(String talentName) {
        this.talentName = talentName;
    }

    public String getWorkMode() {
        return workMode;
    }

    public void setWorkMode(String workMode) {
        this.workMode = workMode;
    }

    public String getTalentWorkExperienct() {
        return talentWorkExperienct;
    }

    public void setTalentWorkExperienct(String talentWorkExperienct) {
        this.talentWorkExperienct = talentWorkExperienct;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getUserHeaderImg() {
        return userHeaderImg;
    }

    public void setUserHeaderImg(String userHeaderImg) {
        this.userHeaderImg = userHeaderImg;
    }

    public String getUserHeaderName() {
        return userHeaderName;
    }

    public void setUserHeaderName(String userHeaderName) {
        this.userHeaderName = userHeaderName;
    }

    public Integer getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Integer isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(Integer houseCount) {
        this.houseCount = houseCount;
    }

    public BigDecimal getHopeSalary() {
        return hopeSalary;
    }

    public void setHopeSalary(BigDecimal hopeSalary) {
        this.hopeSalary = hopeSalary;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public Timestamp getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishDateTime(Timestamp publishDateTime) {
        this.publishDateTime = publishDateTime;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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

    public List<Integer> getTechnologiy() {
        return technologiy;
    }

    public void setTechnologiy(List<Integer> technologiy) {
        this.technologiy = technologiy;
    }

    public Integer getIsName() {
        return isName;
    }

    public void setIsName(Integer isName) {
        this.isName = isName;
    }

    public Integer getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(Integer isMobile) {
        this.isMobile = isMobile;
    }

    public Integer getIsEmail() {
        return isEmail;
    }

    public void setIsEmail(Integer isEmail) {
        this.isEmail = isEmail;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getTalentDescription() {
        return talentDescription;
    }

    public void setTalentDescription(String talentDescription) {
        this.talentDescription = talentDescription;
    }

    public Integer getIsHouse() {
        return isHouse;
    }

    public void setIsHouse(Integer isHouse) {
        this.isHouse = isHouse;
    }

    public Integer getIsCommunity() {
        return isCommunity;
    }

    public void setIsCommunity(Integer isCommunity) {
        this.isCommunity = isCommunity;
    }

    public Integer getIsGet() {
        return isGet;
    }

    public void setIsGet(Integer isGet) {
        this.isGet = isGet;
    }
    
}
