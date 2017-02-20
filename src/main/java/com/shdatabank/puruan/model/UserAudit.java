package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 用户审核实体类
 */
public class UserAudit {
	/** 审核ID */
	private Long auditId;
	/** 用户ID */
	private Long userId;
	/** 用户类型 */
	private int userType;
	/** 审核的后台用户ID */
	private Integer backUserId;
	/** 审核时间 */
	private Timestamp auditDatetime;
	/** 审核内容 */
	private String auditContent;
	/** 审核状态 */
	private String auditStatus;
	private int auditStatusId;
	/** 删除标志 */
	private Byte active;

	/** 用户名 */
	private String userName;
	/** 用户实名 */
	private String userRealName;
	/** 企业名称 */
	private String companyName;

	/** page */
	private int page;
	/** pageSize */
	private int pageSize;

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getUserType() {
		return userType;
	}

	public Integer getBackUserId() {
		return backUserId;
	}

	public void setBackUserId(Integer backUserId) {
		this.backUserId = backUserId;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public Timestamp getAuditDatetime() {
		return auditDatetime;
	}

	public void setAuditDatetime(Timestamp auditDatetime) {
		this.auditDatetime = auditDatetime;
	}

	public String getAuditContent() {
		return auditContent;
	}

	public void setAuditContent(String auditContent) {
		this.auditContent = auditContent;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public int getAuditStatusId() {
		return auditStatusId;
	}

	public void setAuditStatusId(int auditStatusId) {
		this.auditStatusId = auditStatusId;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
