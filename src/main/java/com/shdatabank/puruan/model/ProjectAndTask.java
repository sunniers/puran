package com.shdatabank.puruan.model;
/**
 * 项目与计划实体
 * @author Administrator
 *
 */
public class ProjectAndTask {

	/** 用户id*/
	private Long userId;
	
	/** 项目id*/
	private Long projectId;
	
	/** 项目名称*/
	private String projectName;
	
	/** 任务id*/
	private Long projTaskId;
	
	/** 任务名称*/
	private String projTaskName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getProjTaskId() {
		return projTaskId;
	}

	public void setProjTaskId(Long projTaskId) {
		this.projTaskId = projTaskId;
	}

	public String getProjTaskName() {
		return projTaskName;
	}

	public void setProjTaskName(String projTaskName) {
		this.projTaskName = projTaskName;
	}
	
}
