package com.shdatabank.puruan.model;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 资源仓库与资源结果封装对象
 * @author Administrator
 *
 */
public class WarehouseAndResource {

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
    
    /** 用户id */
    private Long userId;
    
    /** 资源发布人名称 */
    private String publishName;
    
    /** 资源名称 */
    private String resourceName;
    
    /** 资源图片 */
    private String resourceImage;
    
    /** 资源图片名称 */
    private String resourceImageName;

	/** 资源数量 */
    private Integer resourceNumber;
    
    /** 资源描述 */
    private String resourceDescription;
    
    /** 资源演示地址 */
    private String showAddress;
    
    /** 资源附件 */
    private String resourceAttach;
    
    /** 资源附件名称 */
    private String resourceAttachName;
    
    /** 资源币种 */
    private Integer resourceCurrency;
    
    /** 资源价格 */
    private BigDecimal resourcePrice;
    
    /** 资源状态码 */
    private Integer resourceStatus;
    
    /** 资源状态值 */
    private String resourceStatusValue;
   
    /** 删除标志 */
    private Byte active;
    
    /** 发布时间 */
    private Date publishDatetime;
    
    /** page */
    private int page;
    
    /** pageSize */
    private int pageSize;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPublishName() {
		return publishName;
	}

	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceImage() {
		return resourceImage;
	}

	public void setResourceImage(String resourceImage) {
		this.resourceImage = resourceImage;
	}

	public String getResourceImageName() {
		return resourceImageName;
	}

	public void setResourceImageName(String resourceImageName) {
		this.resourceImageName = resourceImageName;
	}

	public Integer getResourceNumber() {
		return resourceNumber;
	}

	public void setResourceNumber(Integer resourceNumber) {
		this.resourceNumber = resourceNumber;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public String getShowAddress() {
		return showAddress;
	}

	public void setShowAddress(String showAddress) {
		this.showAddress = showAddress;
	}

	public String getResourceAttach() {
		return resourceAttach;
	}

	public void setResourceAttach(String resourceAttach) {
		this.resourceAttach = resourceAttach;
	}

	public String getResourceAttachName() {
		return resourceAttachName;
	}

	public void setResourceAttachName(String resourceAttachName) {
		this.resourceAttachName = resourceAttachName;
	}

	public Integer getResourceCurrency() {
		return resourceCurrency;
	}

	public void setResourceCurrency(Integer resourceCurrency) {
		this.resourceCurrency = resourceCurrency;
	}

	public BigDecimal getResourcePrice() {
		return resourcePrice;
	}

	public void setResourcePrice(BigDecimal resourcePrice) {
		this.resourcePrice = resourcePrice;
	}

	public Integer getResourceStatus() {
		return resourceStatus;
	}

	public void setResourceStatus(Integer resourceStatus) {
		this.resourceStatus = resourceStatus;
	}

	public String getResourceStatusValue() {
		return resourceStatusValue;
	}

	public void setResourceStatusValue(String resourceStatusValue) {
		this.resourceStatusValue = resourceStatusValue;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Date getPublishDatetime() {
		return publishDatetime;
	}

	public void setPublishDatetime(Date publishDatetime) {
		this.publishDatetime = publishDatetime;
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
    
    
}
