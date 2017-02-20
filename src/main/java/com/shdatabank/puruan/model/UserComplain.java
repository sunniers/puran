/**
 * UserComplain.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 投诉举报表对应实体类
 * 
 * @author guoqiankun
 *
 */
public class UserComplain {

	/** 举报id */
	private Long complainId;
	/** 用户id */
	private Long userId;
	/** 用户昵称 */
	private String userAlias;
	/** 举报对象 */
	private String complainObject;
	/** 举报内容 */
	private String complainContent;
	/** 举报时间 */
	private Timestamp complainDatetime;
	/** 举报时间映射 */
	private String complainDatetimeMapping;
	/** 投诉处理时间 */
	private Timestamp complainUpdateTime;
	/** 投诉处理意见 */
	private String complainAdvice;
	/** 删除标准 */
	private Byte active;
	/** 投诉举报状态 */
	private Integer complainStatus;	
	/** page */
    private int page;    
    /** pageSize */
    private int pageSize;

	public Long getComplainId() {
		return complainId;
	}

	public void setComplainId(Long complainId) {
		this.complainId = complainId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getComplainObject() {
		return complainObject;
	}

	public void setComplainObject(String complainObject) {
		this.complainObject = complainObject;
	}

	public String getComplainContent() {
		return complainContent;
	}

	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}

	public Timestamp getComplainDatetime() {
		return complainDatetime;
	}

	public void setComplainDatetime(Timestamp complainDatetime) {
		this.complainDatetime = complainDatetime;
	}

	public String getComplainDatetimeMapping() {
		return complainDatetimeMapping;
	}

	public void setComplainDatetimeMapping(String complainDatetimeMapping) {
		this.complainDatetimeMapping = complainDatetimeMapping;
	}

	public Timestamp getComplainUpdateTime() {
		return complainUpdateTime;
	}

	public void setComplainUpdateTime(Timestamp complainUpdateTime) {
		this.complainUpdateTime = complainUpdateTime;
	}

	public String getComplainAdvice() {
		return complainAdvice;
	}

	public void setComplainAdvice(String complainAdvice) {
		this.complainAdvice = complainAdvice;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Integer getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(Integer complainStatus) {
		this.complainStatus = complainStatus;
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
