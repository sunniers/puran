package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 投资机构审核实体类
 */
public class InvestCompanyAudit {

	/** 审核ID*/
	private Long auditId;
	/** 投资机构ID*/
	private Long investCompanyId;
	/** 审核的后台用户ID*/
	private Integer backUserId;
	/** 审核时间*/
	private Timestamp auditDatetime;
	/** 审核内容*/
	private String auditContent;
	/** 审核状态*/
	private int auditStatus;
	/** 删除标志*/
	private Byte active;
	
	public Long getAuditId() {
		return auditId;
	}
	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}
	public Long getInvestCompanyId() {
		return investCompanyId;
	}
	
	public void setInvestCompanyId(Long investCompanyId) {
		this.investCompanyId = investCompanyId;
	}
	
	public Integer getBackUserId() {
		return backUserId;
	}
	public void setBackUserId(Integer backUserId) {
		this.backUserId = backUserId;
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
	public Byte getActive() {
		return active;
	}
	public void setActive(Byte active) {
		this.active = active;
	}
	public int getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
	
}
