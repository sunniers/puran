package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 资源审核实体类
 */
public class CreativeResourceAudit {
	
	/** 审核id */
	private Long auditId;
	/** 资源id */
	private Long resourceId;
	/** 后台用户id */
	private Integer backUserId;
	/** 审核时间 */
	private Timestamp auditDatetime;
	/** 审核内容 */
	private String auditContent;
	/** 审核结果 */
	private String auditStatus;
	private int auditStatusId;
	/** 资源状态 */
	private int resStatusId;
	/** 删除标志 */
	private Byte active;
	
	/** 资源名称 */
	private String resourceName;
	/** 资源类型 */
	private String resourceType;
	private String[] resource;
	
	/** 发布方*/
	private String publishName;
	/** 发布时间 */
	private String publishDatetime;
	/** page */
    private int page;
    
    /** pageSize */
    private int pageSize;
    
    /** 标记 */
    private String sign;
    

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
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

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getPublishName() {
		return publishName;
	}

	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}

	public String getPublishDatetime() {
		return publishDatetime;
	}

	public void setPublishDatetime(String publishDatetime) {
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

	public String[] getResource() {
		return resource;
	}

	public void setResource(String[] resource) {
		this.resource = resource;
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

	public int getAuditStatusId() {
		return auditStatusId;
	}

	public void setAuditStatusId(int auditStatusId) {
		this.auditStatusId = auditStatusId;
	}

	public int getResStatusId() {
		return resStatusId;
	}

	public void setResStatusId(int resStatusId) {
		this.resStatusId = resStatusId;
	}
	
	

}
