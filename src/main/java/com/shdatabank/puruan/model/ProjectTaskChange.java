/**
 * ProjectTaskChange.java
 * Created at 2016-11-07
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 任务变更
 * 
 * @author guoqiankun
 *
 */
public class ProjectTaskChange {
	/** 任务变更ID */
	private Long projectTaskChangeId;
	/** 任务ID */
	private Long projTaskId;
	/** 发起人ID */
	private Long publishUserId;
	/** 发起人名称 */
	private String userName;
	/** 发送对象ID */
	private Long targetUserId;
	/** 预算 */
	private float projTaskBudget;
	/** 任务变更内容 */
	private String projChangeContent;
	/** 任务预期开始时间 */
	private Timestamp projTaskExpectStart;
	/** 任务预期结束时间 */
	private Timestamp projTaskExpectFinish;
	/** 变更状态 */
	private Integer changeStatus;
	/** 创建时间 */
	private Timestamp createTime;
	/** 删除标致 */
	private Byte active;
	
	
	/** 项目名称 */
	private String projectName;
	/** 项目编号 */
	private String projectId;
	/** 项目发起人 */
	private String planName;
	/** 发起时间 */
	private String auditDatetime;
	/** 项目预算 */
	private String projServiceFee;
	/** 项目交付日期 */
	private String projDevlierDate;
	/** page */
	private int page;

	/** pageSize */
	private int pageSize;
	/** 任务实体类 */
	private ProjectPlanTask projectPlanTask;
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getAuditDatetime() {
		return auditDatetime;
	}

	public void setAuditDatetime(String auditDatetime) {
		this.auditDatetime = auditDatetime;
	}

	public String getProjServiceFee() {
		return projServiceFee;
	}

	public void setProjServiceFee(String projServiceFee) {
		this.projServiceFee = projServiceFee;
	}

	public String getProjDevlierDate() {
		return projDevlierDate;
	}

	public void setProjDevlierDate(String projDevlierDate) {
		this.projDevlierDate = projDevlierDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ProjectPlanTask getProjectPlanTask() {
		return projectPlanTask;
	}

	public void setProjectPlanTask(ProjectPlanTask projectPlanTask) {
		this.projectPlanTask = projectPlanTask;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPublishUserId() {
		return publishUserId;
	}

	public void setPublishUserId(Long publishUserId) {
		this.publishUserId = publishUserId;
	}

	public Long getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}

	public float getProjTaskBudget() {
		return projTaskBudget;
	}

	public void setProjTaskBudget(float projTaskBudget) {
		this.projTaskBudget = projTaskBudget;
	}

	public Integer getChangeStatus() {
		return changeStatus;
	}

	public void setChangeStatus(Integer changeStatus) {
		this.changeStatus = changeStatus;
	}

	public Long getProjectTaskChangeId() {
		return projectTaskChangeId;
	}

	public void setProjectTaskChangeId(Long projectTaskChangeId) {
		this.projectTaskChangeId = projectTaskChangeId;
	}

	public Long getProjTaskId() {
		return projTaskId;
	}

	public void setProjTaskId(Long projTaskId) {
		this.projTaskId = projTaskId;
	}

	public String getProjChangeContent() {
		return projChangeContent;
	}

	public void setProjChangeContent(String projChangeContent) {
		this.projChangeContent = projChangeContent;
	}

	public Timestamp getProjTaskExpectStart() {
		return projTaskExpectStart;
	}

	public void setProjTaskExpectStart(Timestamp projTaskExpectStart) {
		this.projTaskExpectStart = projTaskExpectStart;
	}

	public Timestamp getProjTaskExpectFinish() {
		return projTaskExpectFinish;
	}

	public void setProjTaskExpectFinish(Timestamp projTaskExpectFinish) {
		this.projTaskExpectFinish = projTaskExpectFinish;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

}
