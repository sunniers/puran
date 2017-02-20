/**
 * UserHouse.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

/**
 * 用户收藏
 */
public class UserHouse {

	/** 收藏id */
	private Long houseId;

	/** 用户id */
	private Long userId;

	/** 收藏类型 */
	private String houseType;
	
	/** 人才需求收藏类型 */
	private String houseTypeOfTalent;
	
	/** 融资需求收藏类型 */
	private String houseTypeOfFancing;

	/** 收藏资源id */
	private Long houseResourceId;
	
	/** 收藏资源名称 */
	private String houseResourceName;
	/**删除标志*/
	private Byte active;
	
	 /** page */
    private Integer page;
    
    /** pageSize */
    private Integer pageSize;

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public Long getHouseResourceId() {
		return houseResourceId;
	}

	public void setHouseResourceId(Long houseResourceId) {
		this.houseResourceId = houseResourceId;
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

	public String getHouseTypeOfTalent() {
		return houseTypeOfTalent;
	}

	public void setHouseTypeOfTalent(String houseTypeOfTalent) {
		this.houseTypeOfTalent = houseTypeOfTalent;
	}

	public String getHouseTypeOfFancing() {
		return houseTypeOfFancing;
	}

	public void setHouseTypeOfFancing(String houseTypeOfFancing) {
		this.houseTypeOfFancing = houseTypeOfFancing;
	}

	public String getHouseResourceName() {
		return houseResourceName;
	}

	public void setHouseResourceName(String houseResourceName) {
		this.houseResourceName = houseResourceName;
	}

}
