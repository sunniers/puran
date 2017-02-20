package com.shdatabank.puruan.model;

import java.math.BigDecimal;

public class CreativeResourceFront{
	
	/** 创意资源id */
	private Long creativeResourceId;
	
	/** 资源图片 */
    private String resourceImage;
    
	/** 资源名称 */
    private String resourceName;
    
    /** 资源价格 */
    private BigDecimal resourcePrice;
    
    /** 资源类型id */
    private Integer classifierValue;
    
    /** 资源类型id数组 */
    private Long[] classifierValueArray;
    
    /** 资源评价星级 */
    private Integer evaluateStar;
    
    /** 资源状态 */
    private Integer resourceStatus;
    
    /** 成交数量 */
    private Integer count;
    
    /** 查询条件表示 */
    private Integer selectFlg;
    
    /** 资源数量 */
    private Integer resourceNumber;
    
    /** 资源描述 */
    private String resourceDescription;
    
    /** 资源演示地址 */
    private String showAddress;
    
    /** 累计评价数量 */
    private Integer countEvalute;
    
    /** 累计成交数量 */
    private Integer countTransaction;
    
    /** 排序条件 */
    private String orderBys;
    
    /** 升序asc/降序desc  */
    private String ascs;
    
    /** 1:购买的资源，2：出售的资源 */
    private Integer isMy;
    
    /** page */
    private int page;
    
    /** pageSize */
    private int pageSize;

	public Long getCreativeResourceId() {
		return creativeResourceId;
	}

	public void setCreativeResourceId(Long creativeResourceId) {
		this.creativeResourceId = creativeResourceId;
	}

	public String getResourceImage() {
		return resourceImage;
	}

	public void setResourceImage(String resourceImage) {
		this.resourceImage = resourceImage;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public BigDecimal getResourcePrice() {
		return resourcePrice;
	}

	public void setResourcePrice(BigDecimal resourcePrice) {
		this.resourcePrice = resourcePrice;
	}

	public Long[] getClassifierValueArray() {
		return classifierValueArray;
	}

	public void setClassifierValueArray(Long[] classifierValueArray) {
		this.classifierValueArray = classifierValueArray;
	}

	public Integer getEvaluateStar() {
		return evaluateStar;
	}

	public void setEvaluateStar(Integer evaluateStar) {
		this.evaluateStar = evaluateStar;
	}

	public Integer getResourceStatus() {
		return resourceStatus;
	}

	public void setResourceStatus(Integer resourceStatus) {
		this.resourceStatus = resourceStatus;
	}

	public Integer getIsMy() {
		return isMy;
	}

	public void setIsMy(Integer isMy) {
		this.isMy = isMy;
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

	public Integer getClassifierValue() {
		return classifierValue;
	}

	public void setClassifierValue(Integer classifierValue) {
		this.classifierValue = classifierValue;
	}

	public Integer getSelectFlg() {
		return selectFlg;
	}

	public void setSelectFlg(Integer selectFlg) {
		this.selectFlg = selectFlg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
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

	public String getOrderBys() {
		return orderBys;
	}

	public void setOrderBys(String orderBys) {
		this.orderBys = orderBys;
	}

	public String getAscs() {
		return ascs;
	}

	public void setAscs(String ascs) {
		this.ascs = ascs;
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

	public Integer getCountEvalute() {
		return countEvalute;
	}

	public void setCountEvalute(Integer countEvalute) {
		this.countEvalute = countEvalute;
	}

	public Integer getCountTransaction() {
		return countTransaction;
	}

	public void setCountTransaction(Integer countTransaction) {
		this.countTransaction = countTransaction;
	}   

}
