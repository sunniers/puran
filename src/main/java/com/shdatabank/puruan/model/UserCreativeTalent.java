/**
 * UserCreativeTalent.java
 * Created at 2016-11-01
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * 创意人才
 */
public class UserCreativeTalent {

    /** 创意人才id */
    private Long creativeTalentId;
    
    /** 用户id */
    private Long userId;
    
    /** 人才名称 */
    private String talentName;
    
    /** 工作方式 */
    private String workMode;
    
    /** 工作时间 */
    private String workTime;
    
    /** 所在地 */
    private String nowAddress;
    
    /** 期望薪资 */
    private Double hopeSalary;
    
    /** 技能特长 */
    private String talentDescription;
    
    /** 项目经验 */
    private String talentWorkExperience;
    
    /** 发布时间 */
    private Timestamp publishDatetime;
    
    /** 删除标志 */
    private Byte active;
    
    /** 排序 */
    private String orderBy;
    
    /** 排序方式 */
    private String asc;
    
    /** 技术类型 */
    private String technologyType;
    
    /** 认证信息 */
    private String authentication;
    
    /** 人才技能 */
    private List<TalentTechnology> talentTechnologies;
    
    /** 用户评价 */
    private Double evaluate;
    
    /** 承接次数 */
    private Integer undertakeTimes;
    
    /** 用户信息 */
    private User user;
    
    /** 收藏次数 */
    private Integer houseTimes;
    
    /** 查询条件—热门领域、热门技术 */
    private String conditionTechnology;
    
    /** 查询条件-实名认证 */
    private String conditionIsAuthentication;
    
    /** 查询条件-手机认证 */
    private String conditionMobile;
    
    /** 查询条件-邮箱认证 */
    private String conditionEmail;
    
    /** 查询条件-模糊查询 */
    private String conditionTalentName;
    
    /** 发布方 */
    private String userName;
    
    /** 是否公开 */
    private Integer isOpen;
    
    /** 是否已收藏 */
    private Integer isHouse;
    
    /** page */
    private Integer page;
    
    /** pageSize */
    private Integer pageSize;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getIsHouse() {
		return isHouse;
	}

	public void setIsHouse(Integer isHouse) {
		this.isHouse = isHouse;
	}

	public Long getCreativeTalentId() {
		return creativeTalentId;
	}

	public void setCreativeTalentId(Long creativeTalentId) {
		this.creativeTalentId = creativeTalentId;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTalentDescription() {
        return talentDescription;
    }

    public void setTalentDescription(String talentDescription) {
        this.talentDescription = talentDescription;
    }
    
    public Timestamp getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(Timestamp publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getTechnologyType() {
        return technologyType;
    }

    public void setTechnologyType(String technologyType) {
        this.technologyType = technologyType;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public Integer getUndertakeTimes() {
        return undertakeTimes;
    }

    public void setUndertakeTimes(Integer undertakeTimes) {
        this.undertakeTimes = undertakeTimes;
    }

    public Integer getHouseTimes() {
        return houseTimes;
    }

    public void setHouseTimes(Integer houseTimes) {
        this.houseTimes = houseTimes;
    }

    public String getTalentWorkExperience() {
        return talentWorkExperience;
    }

    public void setTalentWorkExperience(String talentWorkExperience) {
        this.talentWorkExperience = talentWorkExperience;
    }

    public Double getHopeSalary() {
        return hopeSalary;
    }

    public void setHopeSalary(Double hopeSalary) {
        this.hopeSalary = hopeSalary;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getWorkMode() {
        return workMode;
    }

    public void setWorkMode(String workMode) {
        this.workMode = workMode;
    }

    public String getTalentName() {
        return talentName;
    }

    public void setTalentName(String talentName) {
        this.talentName = talentName;
    }

    public String getConditionTechnology() {
        return conditionTechnology;
    }

    public void setConditionTechnology(String conditionTechnology) {
        this.conditionTechnology = conditionTechnology;
    }

    public String getConditionIsAuthentication() {
        return conditionIsAuthentication;
    }

    public void setConditionIsAuthentication(String conditionIsAuthentication) {
        this.conditionIsAuthentication = conditionIsAuthentication;
    }

    public String getConditionMobile() {
        return conditionMobile;
    }

    public void setConditionMobile(String conditionMobile) {
        this.conditionMobile = conditionMobile;
    }

    public String getConditionEmail() {
        return conditionEmail;
    }

    public void setConditionEmail(String conditionEmail) {
        this.conditionEmail = conditionEmail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getConditionTalentName() {
        return conditionTalentName;
    }

    public void setConditionTalentName(String conditionTalentName) {
        this.conditionTalentName = conditionTalentName;
    }

    public String getAsc() {
        return asc;
    }

    public void setAsc(String asc) {
        this.asc = asc;
    }

    public Double getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Double evaluate) {
        this.evaluate = evaluate;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public List<TalentTechnology> getTalentTechnologies() {
        return talentTechnologies;
    }

    public void setTalentTechnologies(List<TalentTechnology> talentTechnologies) {
        this.talentTechnologies = talentTechnologies;
    }
    
}
