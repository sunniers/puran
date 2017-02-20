/**
 * ProjectPurchaseTask.java
 * Created at 2016-11-07
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 项目采购
 * @author guoqiankun
 *
 */
public class ProjectPurchaseTask {
	/** 项目采购ID */
	private Long projectPurchaseId;
	/** 项目ID */
	private Long projectId;
	/** 任务ID */
	private Long projectTaskId;
	/** 采购时间 */
	private Date purchaseDate;
	/** 采购资源ID */
	private Long createResourceId;
	/** 采购数量 */
	private Integer purchaseCount;
	/** 供方信息 */
	private Long purchaseProviderInfo;
	/** 采购成本 */
	private BigDecimal purchaseCost;
	/** 采购类型 */
	private Integer purchaseType;
	/** 创建时间 */
	private Timestamp createTime;
	/** 删除标致 */
	private Byte active;
	/** 创意资源库存实体 */
	private CreateResourceWarehouse createResourceWarehouse;
	/** 任务ID */
	private Long projTaskId;
	
	/** 任务名称 */
	private String projTaskName;
	/** 采购内容 */
	private String resourceName;
	/** page */
	private Integer page;

	/** pageSize */
	private Integer pageSize;

	public String getProjTaskName() {
		return projTaskName;
	}

	public void setProjTaskName(String projTaskName) {
		this.projTaskName = projTaskName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public CreateResourceWarehouse getCreateResourceWarehouse() {
		return createResourceWarehouse;
	}

	public void setCreateResourceWarehouse(CreateResourceWarehouse createResourceWarehouse) {
		this.createResourceWarehouse = createResourceWarehouse;
	}

	public Long getProjTaskId() {
		return projTaskId;
	}

	public void setProjTaskId(Long projTaskId) {
		this.projTaskId = projTaskId;
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

	public Long getProjectPurchaseId() {
		return projectPurchaseId;
	}

	public void setProjectPurchaseId(Long projectPurchaseId) {
		this.projectPurchaseId = projectPurchaseId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(Long projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getCreateResourceId() {
		return createResourceId;
	}

	public void setCreateResourceId(Long createResourceId) {
		this.createResourceId = createResourceId;
	}

	public Integer getPurchaseCount() {
		return purchaseCount;
	}

	public void setPurchaseCount(Integer purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public Long getPurchaseProviderInfo() {
		return purchaseProviderInfo;
	}

	public void setPurchaseProviderInfo(Long purchaseProviderInfo) {
		this.purchaseProviderInfo = purchaseProviderInfo;
	}

	public BigDecimal getPurchaseCost() {
		return purchaseCost;
	}

	public void setPurchaseCost(BigDecimal purchaseCost) {
		this.purchaseCost = purchaseCost;
	}

	public Integer getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(Integer purchaseType) {
		this.purchaseType = purchaseType;
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
