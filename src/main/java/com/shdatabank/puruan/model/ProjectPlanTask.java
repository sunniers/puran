/**
 * ProjectPlanTask.java
 * Created at 2016-11-07
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 任务
 * 
 * @author guoqiankun
 *
 */
public class ProjectPlanTask {
	/** 任务ID */
	private Long projTaskId;
	/** 计划ID */
	private Long projPlanId;
	/** 承接人ID */
	private Long undertakeUserId;
	private String undertakeUserName;
	/** 任务名称 */
	private String projTaskName;
	/** 任务开始时间 */
	private Date projTaskStartDate;
	/** 任务结束时间 */
	private Date projTaskFinishDate;
	/** 任务实际开始时间 */
	private Date projTaskRealStartDate;
	/** 任务实际结束时间 */
	private Date projTaskRealFinishDate;
	/** 任务状态 */
	private Integer projTaskStatus;
	/** 任务内容 */
	private String projTaskContent;
	/** 任务类型 */
	private String projTaskType;
	/** 创建时间 */
	private Timestamp createTime;
	/** 任务周期 */
	private Integer projTaskWorkRange;
	/** 前置任务 */
	private String projPlanName;
	/** 资源名称 */
	private String userName;
	/** 删除标致 */
	private Byte active;
	/** 任务变更实体类 */
//	private ProjectTaskChange projectTaskChange;
	/** 项目采购实体类 */
	private ProjectPurchaseTask projectPurchaseTask;
	/** 任务计划实体类 */
	private List<ProjectTaskDetailplan> projectTaskDetailplans;
	/** 产物 */
	private List<TaskProduct> taskProducts;

	public Integer getProjTaskWorkRange() {
		return projTaskWorkRange;
	}

	public void setProjTaskWorkRange(Integer projTaskWorkRange) {
		this.projTaskWorkRange = projTaskWorkRange;
	}

	public String getProjPlanName() {
		return projPlanName;
	}

	public void setProjPlanName(String projPlanName) {
		this.projPlanName = projPlanName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/** page */
	private Integer page;

	/** pageSize */
	private Integer pageSize;

	public Long getProjTaskId() {
		return projTaskId;
	}

	public void setProjTaskId(Long projTaskId) {
		this.projTaskId = projTaskId;
	}

	public Long getProjPlanId() {
		return projPlanId;
	}

	public void setProjPlanId(Long projPlanId) {
		this.projPlanId = projPlanId;
	}

	public Long getUndertakeUserId() {
		return undertakeUserId;
	}

	public void setUndertakeUserId(Long undertakeUserId) {
		this.undertakeUserId = undertakeUserId;
	}

	public String getProjTaskName() {
		return projTaskName;
	}

	public void setProjTaskName(String projTaskName) {
		this.projTaskName = projTaskName;
	}

	public Date getProjTaskStartDate() {
		return projTaskStartDate;
	}

	public void setProjTaskStartDate(Date projTaskStartDate) {
		this.projTaskStartDate = projTaskStartDate;
	}

	public Date getProjTaskFinishDate() {
		return projTaskFinishDate;
	}

	public void setProjTaskFinishDate(Date projTaskFinishDate) {
		this.projTaskFinishDate = projTaskFinishDate;
	}

	public Date getProjTaskRealStartDate() {
		return projTaskRealStartDate;
	}

	public void setProjTaskRealStartDate(Date projTaskRealStartDate) {
		this.projTaskRealStartDate = projTaskRealStartDate;
	}

	public Date getProjTaskRealFinishDate() {
		return projTaskRealFinishDate;
	}

	public void setProjTaskRealFinishDate(Date projTaskRealFinishDate) {
		this.projTaskRealFinishDate = projTaskRealFinishDate;
	}

	public Integer getProjTaskStatus() {
		return projTaskStatus;
	}

	public void setProjTaskStatus(Integer projTaskStatus) {
		this.projTaskStatus = projTaskStatus;
	}

	public String getProjTaskContent() {
		return projTaskContent;
	}

	public void setProjTaskContent(String projTaskContent) {
		this.projTaskContent = projTaskContent;
	}

	public String getProjTaskType() {
		return projTaskType;
	}

	public void setProjTaskType(String projTaskType) {
		this.projTaskType = projTaskType;
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

//	public ProjectTaskChange getProjectTaskChange() {
//		return projectTaskChange;
//	}
//
//	public void setProjectTaskChange(ProjectTaskChange projectTaskChange) {
//		this.projectTaskChange = projectTaskChange;
//	}

	public ProjectPurchaseTask getProjectPurchaseTask() {
		return projectPurchaseTask;
	}

	public void setProjectPurchaseTask(ProjectPurchaseTask projectPurchaseTask) {
		this.projectPurchaseTask = projectPurchaseTask;
	}

	public List<ProjectTaskDetailplan> getProjectTaskDetailplans() {
		return projectTaskDetailplans;
	}

	public void setProjectTaskDetailplans(List<ProjectTaskDetailplan> projectTaskDetailplans) {
		this.projectTaskDetailplans = projectTaskDetailplans;
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

    public List<TaskProduct> getTaskProducts() {
        return taskProducts;
    }

    public void setTaskProducts(List<TaskProduct> taskProducts) {
        this.taskProducts = taskProducts;
    }

    public String getUndertakeUserName() {
        return undertakeUserName;
    }

    public void setUndertakeUserName(String undertakeUserName) {
        this.undertakeUserName = undertakeUserName;
    }

}
