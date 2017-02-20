package com.shdatabank.puruan.model;
/**
 * 资源采购传入参数
 * @author Administrator
 *
 */
public class ProjectAndPurchase {

	/** 项目id**/
	private Long projectId;
	/** 任务id**/
	private Long projectTaskId;
	/** 库存id**/
	private Long stockId;
	/** 资源id**/
	private Long creativeResourceId;	
	/** 资源交易id */
	private Long resourceTransactionId;
	/** 采购数量**/
	private Integer number;
	/** 采购Id**/
	private Long projectPurchaseId;
	
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
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public Long getCreativeResourceId() {
		return creativeResourceId;
	}
	public void setCreativeResourceId(Long creativeResourceId) {
		this.creativeResourceId = creativeResourceId;
	}
	public Long getResourceTransactionId() {
		return resourceTransactionId;
	}
	public void setResourceTransactionId(Long resourceTransactionId) {
		this.resourceTransactionId = resourceTransactionId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Long getProjectPurchaseId() {
		return projectPurchaseId;
	}
	public void setProjectPurchaseId(Long projectPurchaseId) {
		this.projectPurchaseId = projectPurchaseId;
	}
}
