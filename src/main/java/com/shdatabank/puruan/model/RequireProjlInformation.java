package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 *	创意需求详细信息实体类
 */
public class RequireProjlInformation {
	
	/** 需求id */
    private Long id;
    /** 需求名称 */
    private String projName;
    /** 发布方 */
    private String publishName;
    /** 需求类型 */
    private String requirementTypeValue;
    private String requirementType;	//创意需求
    /** 需求预算 */
    private String ServiceFee;
    /** 报名开始时间 */
    private Timestamp projStartDate;
    /** 报名结束时间 */
    private Timestamp projCloseDate;
    /** 需求评估周期*/
    private int projEstimate;
    /** 提交时间*/
    private Timestamp createDatetime;
    /** 需求分类*/
    private String requirementClass;
    private String[] require;
    /** 需求描述*/
    private String requirementDescription;
    /**附件名称*/
    private String fileName;
    /**项目附件*/
    private String attachFile;
    /** 附件预览*/
    private String seeFile;
    
    /** 审核时间*/
    private Timestamp requirementDatetime;
    /** 审核结果 */
    private String auditStatus;
    private int auditStatusId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRequirementType() {
		return requirementType;
	}

	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}

	public String getServiceFee() {
		return ServiceFee;
	}

	public void setServiceFee(String serviceFee) {
		ServiceFee = serviceFee;
	}

	public Timestamp getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(Timestamp projStartDate) {
		this.projStartDate = projStartDate;
	}

	public Timestamp getProjCloseDate() {
		return projCloseDate;
	}

	public void setProjCloseDate(Timestamp projCloseDate) {
		this.projCloseDate = projCloseDate;
	}

	public int getProjEstimate() {
		return projEstimate;
	}

	public void setProjEstimate(int projEstimate) {
		this.projEstimate = projEstimate;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getRequirementClass() {
		return requirementClass;
	}

	public String getRequirementTypeValue() {
		return requirementTypeValue;
	}

	public void setRequirementTypeValue(String requirementTypeValue) {
		this.requirementTypeValue = requirementTypeValue;
	}

	public void setRequirementClass(String requirementClass) {
		this.requirementClass = requirementClass;
	}

	public String[] getRequire() {
		return require;
	}

	public void setRequire(String[] require) {
		this.require = require;
	}

	public String getRequirementDescription() {
		return requirementDescription;
	}

	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public int getAuditStatusId() {
		return auditStatusId;
	}

	public void setAuditStatusId(int auditStatusId) {
		this.auditStatusId = auditStatusId;
	}

	public String getSeeFile() {
		return seeFile;
	}

	public void setSeeFile(String seeFile) {
		this.seeFile = seeFile;
	}

	public Timestamp getRequirementDatetime() {
		return requirementDatetime;
	}

	public void setRequirementDatetime(Timestamp requirementDatetime) {
		this.requirementDatetime = requirementDatetime;
	}
}
