package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 需求审核实体类
 */
public class RequirementAudit {
	
	/** 审核id */
    private Long auditId;
    /** 需求id */
    private Long projId;
    /** 后台用户id */
    private Integer backUserId;
    /** 需求名称 */
    private String projName;
    /** 发布方 */
    private String publishName;
    /** 需求类型 */
    private String requirementTypeValue;
    private int requirementType;
    
    /** 审核时间 */
    private Timestamp auditDateTime;
    /** 审核结果 */
    private String auditStatus;
    private int auditStatusId;
    /** 需求创建时间*/
    private Timestamp createDatetime;
    
    /** 删除标志*/
    private Byte active;
    /** 审核内容*/
    private String auditContent;
    
    /** page */
    private int page;
    /** pageSize */
    private int pageSize;
    /** 标记*/
    private String sign;
    /** 需求状态结果 */
    private int statusId;

	public Long getAuditId() {
		return auditId;
	}
	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}
	public Long getProjId() {
		return projId;
	}
	public void setProjId(Long projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
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
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}
	public String getRequirementTypeValue() {
		return requirementTypeValue;
	}
	public void setRequirementTypeValue(String requirementTypeValue) {
		this.requirementTypeValue = requirementTypeValue;
	}
	public int getRequirementType() {
		return requirementType;
	}
	public int getAuditStatusId() {
		return auditStatusId;
	}
	public void setAuditStatusId(int auditStatusId) {
		this.auditStatusId = auditStatusId;
	}
	public void setRequirementType(int requirementType) {
		this.requirementType = requirementType;
	}
	public String getAuditContent() {
		return auditContent;
	}
	public void setAuditContent(String auditContent) {
		this.auditContent = auditContent;
	}
	public Timestamp getAuditDateTime() {
		return auditDateTime;
	}
	public void setAuditDateTime(Timestamp auditDateTime) {
		this.auditDateTime = auditDateTime;
	}
	public Timestamp getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public Integer getBackUserId() {
		return backUserId;
	}
	public void setBackUserId(Integer backUserId) {
		this.backUserId = backUserId;
	}
}
