/**
 * SysResourceController.java
 * Created at 2016-10-24
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author guoqiankun
 * 资源交易实体类
 *
 */
public class CeativeResourceTransaction {
	/** 资源交易id */
	private Long resourceTransactionId;
	/** 创意资源id */
	private Long creativeResourceId;
	/** 买方用户id */
	private Long buyUserId;
	/** 数量 */
	private Integer transactionNumber;
	/** 交易单价 */
	private BigDecimal transactionPrice;
	/** 交易金额 */
	private BigDecimal transactionMoney;
	/** 交易时间 */
	private Timestamp transactionDatetime;
	/** 交易时间映射 */
	private String transactionDatetimeMapping;
	/** 交易状态 */
	private String transactionStatus;
	/** 删除标志 */
	private String active;
	/** 交易状态值 */
	private String dataValue;
	/** 资源名称 */
	private String resourceName;
	/** 发布者 */
	private String publishName;
	/** 买方名称 */
	private String userName;
	/** 评价状态 */
	private Integer flag;
	
	/**数量*/
	private int number;
	/**创意资源实体类*/
	private  CreativeResource creativeResource;
	
	/** page */
    private int page;
    
    /** pageSize */
    private int pageSize;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public CreativeResource getCreativeResource() {
		return creativeResource;
	}
	public void setCreativeResource(CreativeResource creativeResource) {
		this.creativeResource = creativeResource;
	}
	public Long getResourceTransactionId() {
		return resourceTransactionId;
	}
	public void setResourceTransactionId(Long resourceTransactionId) {
		this.resourceTransactionId = resourceTransactionId;
	}
	public Long getCreativeResourceId() {
		return creativeResourceId;
	}
	public void setCreativeResourceId(Long creativeResourceId) {
		this.creativeResourceId = creativeResourceId;
	}
	public Long getBuyUserId() {
		return buyUserId;
	}
	public void setBuyUserId(Long buyUserId) {
		this.buyUserId = buyUserId;
	}
	public Integer getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(Integer transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public BigDecimal getTransactionPrice() {
		return transactionPrice;
	}
	public void setTransactionPrice(BigDecimal transactionPrice) {
		this.transactionPrice = transactionPrice;
	}
	public BigDecimal getTransactionMoney() {
		return transactionMoney;
	}
	public void setTransactionMoney(BigDecimal transactionMoney) {
		this.transactionMoney = transactionMoney;
	}
	public Timestamp getTransactionDatetime() {
		return transactionDatetime;
	}
	public void setTransactionDatetime(Timestamp transactionDatetime) {
		this.transactionDatetime = transactionDatetime;
	}
	public String getTransactionDatetimeMapping() {
		return transactionDatetimeMapping;
	}
	public void setTransactionDatetimeMapping(String transactionDatetimeMapping) {
		this.transactionDatetimeMapping = transactionDatetimeMapping;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getActive() {
		return active;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	public void setActive(String active) {
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
