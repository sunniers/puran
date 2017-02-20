/**
 * UserExtensionInfo.java
 * Created at 2016-10-18
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

/**
 * 用户扩展信息
 */
public class UserExtensionInfo {

	/** 个人审核标记 */
	private final  int userType = 100502;

	/** 扩展id */
	private Long extensionId;
	/** 用户id */
	private Long userId;
	/** 用户实名 */
	private String userRealName;
	/** 证件类型 */
	private String creditType;
	/** 证件号码 */
	private String creditNumber;
	/** 证件文件名称 */
	private String creditFileName;
	/** 证件文件正面路径 */
	private String creditFrontPath;
	/** 证件文件反面路径 */
	private String creditBackPath;
	/** 证件文件正面 */
	private MultipartFile fileFront;
	/** 证件文件反面 */
	private MultipartFile fileBack;
	/** 创建时间 */
	private Timestamp createTime;

	/** 用户名 */
	private String userName;

	/** page */
	private int page;
	/** pageSize */
	private int pageSize;

	public Long getExtensionId() {
		return extensionId;
	}

	public void setExtensionId(Long extensionId) {
		this.extensionId = extensionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCreditFileName() {
		return creditFileName;
	}

	public void setCreditFileName(String creditFileName) {
		this.creditFileName = creditFileName;
	}

	public String getCreditFrontPath() {
		return creditFrontPath;
	}

	public void setCreditFrontPath(String creditFrontPath) {
		this.creditFrontPath = creditFrontPath;
	}

	public String getCreditBackPath() {
		return creditBackPath;
	}

	public void setCreditBackPath(String creditBackPath) {
		this.creditBackPath = creditBackPath;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getCreditType() {
		return creditType;
	}

	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}

	public String getCreditNumber() {
		return creditNumber;
	}

	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}

	public MultipartFile getFileFront() {
		return fileFront;
	}

	public void setFileFront(MultipartFile fileFront) {
		this.fileFront = fileFront;
	}

	public MultipartFile getFileBack() {
		return fileBack;
	}

	public void setFileBack(MultipartFile fileBack) {
		this.fileBack = fileBack;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getUserType() {
		return userType;
	}


}
