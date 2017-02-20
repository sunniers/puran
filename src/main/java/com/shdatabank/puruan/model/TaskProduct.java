/**
 * ProjectPlan.java
 * Created at 2016-11-18
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * guoqiankun
 * 任务产物
 */
public class TaskProduct {

    /** 任务产物ID */
    private Long taskProductId;
    /** 任务ID*/
    private Long projTaskId;
    /** 用户ID */
    private Long userId;
    /** 产物描述 */
    private String productValue;
    /** 产物名称*/
    private String fileName;
    /** 产物路径 */
    private String filePath;
    /** 预览路径 */
    private String fileSeePath;
	/** 创建时间 */
	private Timestamp createTime;
    /** 删除标志 */
    private Byte active;
    
    /** page */
    private Integer page;
    /** pageSize */
    private Integer pageSize;
	public Long getTaskProductId() {
		return taskProductId;
	}
	public void setTaskProductId(Long taskProductId) {
		this.taskProductId = taskProductId;
	}
	public Long getProjTaskId() {
		return projTaskId;
	}
	public void setProjTaskId(Long projTaskId) {
		this.projTaskId = projTaskId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getProductValue() {
		return productValue;
	}
	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
    public String getFileSeePath() {
        return fileSeePath;
    }
    public void setFileSeePath(String fileSeePath) {
        this.fileSeePath = fileSeePath;
    }
    
}
