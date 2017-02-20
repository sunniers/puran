/**
 * ProjectUserReleation.java
 * Created at 2016-10-24
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 项目用户关系
 */
public class ProjectUserReleation {

	/** 关系id */
	private Long releationId;

	/** 项目ID */
	private Long projectRequirementId;
	/** 项目名称 */
	private String projectName;

	/** 用户id */
	private Long userId;
	private String userName;

	/** 担任职务 */
	private String projectDuty;
	/** 备注 */
	private String remark;

	/** 加入时间 */
	private Date joinDate;

	/** 离开时间 */
	private Date leaveDatetime;

	/** 创建时间 */
	private Timestamp createDatetime;

	/** 状态 */
	private String releationStatus;

	/** 删除标志 */
	private Byte active;

	/** 离开时间映射 */
	private String leaveDatetimeMapping;

	/** 创建时间映射 */
	private String createDatetimeMapping;

	/** page */
	private Integer page;

	/** pageSize */
	private Integer pageSize;
	/** 项目需求 */
	private List<ProjectRequirement> projectRequirements;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<ProjectRequirement> getProjectRequirements() {
		return projectRequirements;
	}

	public void setProjectRequirements(List<ProjectRequirement> projectRequirements) {
		this.projectRequirements = projectRequirements;
	}

	public Long getReleationId() {
		return releationId;
	}

	public void setReleationId(Long releationId) {
		this.releationId = releationId;
	}

	public Long getProjectRequirementId() {
		return projectRequirementId;
	}

	public void setProjectRequirementId(Long projectRequirementId) {
		this.projectRequirementId = projectRequirementId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getProjectDuty() {
		return projectDuty;
	}

	public void setProjectDuty(String projectDuty) {
		this.projectDuty = projectDuty;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getReleationStatus() {
		return releationStatus;
	}

	public void setReleationStatus(String releationStatus) {
		this.releationStatus = releationStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLeaveDatetimeMapping() {
		return leaveDatetimeMapping;
	}

	public void setLeaveDatetimeMapping(String leaveDatetimeMapping) {
		this.leaveDatetimeMapping = leaveDatetimeMapping;
	}

	public String getCreateDatetimeMapping() {
		return createDatetimeMapping;
	}

	public void setCreateDatetimeMapping(String createDatetimeMapping) {
		this.createDatetimeMapping = createDatetimeMapping;
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

	public Date getLeaveDatetime() {
		return leaveDatetime;
	}

	public void setLeaveDatetime(Date leaveDatetime) {
		this.leaveDatetime = leaveDatetime;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

}
