package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 *融资需求详细信息实体类
 */
public class RequireFancingInformation {

	/** 需求id */
    private Long fancingId;
    /** 需求名称 */
    private String requireName;
    /** 发布方 */
    private String publishName;
    /** 需求类型 */
    private String requirementTypeValue;
    private String requirementType;	//融资需求
    /** 融资金额 */
	private String fancingMoney;
	/** 融资方式*/
	private String fancingWay;
	/** 融资描述 */
	private String fancingDescription;
	/** 融资用途 */
	private String fancingUse;
	/** 发布方式 */
	private String publishWay;
	/** 融资主体 */
	private String fancingBody;
	/** 融资附件路径 */
	private String fancingAttachment;
	/** 融资附件预览路径 */
	private String seeFile;
	/** 附件名称 */
	private String fancingFileName;
	/** 创建时间 */
	private Timestamp createDatetime;
	 /** 融资分类*/
    private String requirementClass;
    private String[] require;
	 
	/** 审核时间*/
    private Timestamp requirementDatetime;
    /** 审核结果 */
    private String auditStatus;
    private int auditStatusId;
	public Long getFancingId() {
		return fancingId;
	}
	public String getRequireName() {
		return requireName;
	}
	public String getPublishName() {
		return publishName;
	}
	public String getRequirementTypeValue() {
		return requirementTypeValue;
	}
	public String getRequirementType() {
		return requirementType;
	}
	public String getFancingMoney() {
		return fancingMoney;
	}
	public String getFancingWay() {
		return fancingWay;
	}
	public String getFancingDescription() {
		return fancingDescription;
	}
	public String getFancingUse() {
		return fancingUse;
	}
	public String getPublishWay() {
		return publishWay;
	}
	public String getFancingBody() {
		return fancingBody;
	}
	public String getFancingAttachment() {
		return fancingAttachment;
	}
	public String getSeeFile() {
		return seeFile;
	}
	public String getFancingFileName() {
		return fancingFileName;
	}
	public Timestamp getCreateDatetime() {
		return createDatetime;
	}
	public String getRequirementClass() {
		return requirementClass;
	}
	public String[] getRequire() {
		return require;
	}
	public Timestamp getRequirementDatetime() {
		return requirementDatetime;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public int getAuditStatusId() {
		return auditStatusId;
	}
	public void setFancingId(Long fancingId) {
		this.fancingId = fancingId;
	}
	public void setRequireName(String requireName) {
		this.requireName = requireName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	public void setRequirementTypeValue(String requirementTypeValue) {
		this.requirementTypeValue = requirementTypeValue;
	}
	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}
	public void setFancingMoney(String fancingMoney) {
		this.fancingMoney = fancingMoney;
	}
	public void setFancingWay(String fancingWay) {
		this.fancingWay = fancingWay;
	}
	public void setFancingDescription(String fancingDescription) {
		this.fancingDescription = fancingDescription;
	}
	public void setFancingUse(String fancingUse) {
		this.fancingUse = fancingUse;
	}
	public void setPublishWay(String publishWay) {
		this.publishWay = publishWay;
	}
	public void setFancingBody(String fancingBody) {
		this.fancingBody = fancingBody;
	}
	public void setFancingAttachment(String fancingAttachment) {
		this.fancingAttachment = fancingAttachment;
	}
	public void setSeeFile(String seeFile) {
		this.seeFile = seeFile;
	}
	public void setFancingFileName(String fancingFileName) {
		this.fancingFileName = fancingFileName;
	}
	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}
	public void setRequirementClass(String requirementClass) {
		this.requirementClass = requirementClass;
	}
	public void setRequire(String[] require) {
		this.require = require;
	}
	public void setRequirementDatetime(Timestamp requirementDatetime) {
		this.requirementDatetime = requirementDatetime;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	public void setAuditStatusId(int auditStatusId) {
		this.auditStatusId = auditStatusId;
	}
	
}
