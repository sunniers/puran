/**
 * ProjectTaskDetailplan.java
 * Created at 2016-11-07
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 任务计划
 * 
 * @author guoqiankun
 *
 */
public class ProjectTaskDetailplan {
	/** 任务计划ID */
	private Long subTaskId;
	/** 任务ID */
	private Long projectTaskId;
	/** 任务计划名称 */
	private String subPlanName;
	/** 前置计划ID */
	private Long parentTaskId;
	/** 计划实施者 */
	private Long planExecutant;
	/** 开始时间 */
	private Date startDate;
	/** 结束时间 */
	private Date finishDate;
	/** 实际开始时间 */
	private Date realStartDate;
	/** 实际结束时间 */
	private Date realFinishDate;
	/** 完成状态 */
	private Integer completeStatus;
	/** 任务描述 */
	private String taskDescription;
	/** 创建时间 */
	private Timestamp createTime;
	/** 删除标致 */
	private Byte active;
	/** 工期 */
	private Integer duration;
	/** 前置名称 */
	private String parentTaskName;
	/**资源名称*/
	private String resourceName;
	/** page */
	private Integer page;

	/** pageSize */
	private Integer pageSize;
	
	public String getParentTaskName() {
		return parentTaskName;
	}

	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
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

	public Long getSubTaskId() {
		return subTaskId;
	}

	public void setSubTaskId(Long subTaskId) {
		this.subTaskId = subTaskId;
	}

	public Long getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(Long projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	public String getSubPlanName() {
		return subPlanName;
	}

	public void setSubPlanName(String subPlanName) {
		this.subPlanName = subPlanName;
	}

	public Long getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public Long getPlanExecutant() {
		return planExecutant;
	}

	public void setPlanExecutant(Long planExecutant) {
		this.planExecutant = planExecutant;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Date getRealStartDate() {
		return realStartDate;
	}

	public void setRealStartDate(Date realStartDate) {
		this.realStartDate = realStartDate;
	}

	public Date getRealFinishDate() {
		return realFinishDate;
	}

	public void setRealFinishDate(Date realFinishDate) {
		this.realFinishDate = realFinishDate;
	}

	public Integer getCompleteStatus() {
		return completeStatus;
	}

	public void setCompleteStatus(Integer completeStatus) {
		this.completeStatus = completeStatus;
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
