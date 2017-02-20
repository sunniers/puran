package com.shdatabank.puruan.model;

import java.util.Date;
/**
 * 创意资源库存实体
 * @author Administrator
 *
 */
public class CreateResourceWarehouse {
	
	/** 库存id **/	 
	private Long stockId;
	
	/** 资源id **/
	private Long createResourceId;
	
	/** 库存数量 **/
	private Integer stockCount;
	
	/** 资源类型 **/
	private Integer resourceType;
	
	/** 入库时间 **/
	private Date inStockTime;
	
	/** 最近更新时间 **/
	private Date updateTime;
	
	/** 删除标志 **/
	private Byte active;
	
	/** page */
    private int page;
    
    /** pageSize */
    private int pageSize;
    
    /** 创意资源 */
    private CreativeResource creativeResource;
	
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public Long getCreateResourceId() {
		return createResourceId;
	}
	public void setCreateResourceId(Long createResourceId) {
		this.createResourceId = createResourceId;
	}
	public Integer getStockCount() {
		return stockCount;
	}
	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}
	public Integer getResourceType() {
		return resourceType;
	}
	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}
	public Date getInStockTime() {
		return inStockTime;
	}
	public void setInStockTime(Date inStockTime) {
		this.inStockTime = inStockTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Byte getActive() {
		return active;
	}
	public void setActive(Byte active) {
		this.active = active;
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
	public CreativeResource getCreativeResource() {
		return creativeResource;
	}
	public void setCreativeResource(CreativeResource creativeResource) {
		this.creativeResource = creativeResource;
	}
}
