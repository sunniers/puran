package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 *人才需求详细信息实体类
 */
public class RequireTalentInformation {
	
	/** 需求id */
    private Long id;
    /** 需求名称 */
    private String requireName;
    /** 发布方 */
    private String publishName;
    /** 需求类型 */
    private String requirementTypeValue;
    private String requirementType;	//人才需求
    /** 工作形式 */
	private Integer workMode;
	/** 专业技能 */
	private String professionalSkills;
	/** 薪酬 */
	private String talentBuget;
	/** 需求概述 */
	private String requirementDescription;
	/** 工作地点 */
	private String workSpace;
	/** 生效时间 */
	private Timestamp effectiveDatetime;
	/** 需求分类 */
    private String requirementClass;
    private String[] require;
    /** 合作类型 */
	private String cooperateType;
    /**附件名称*/
    private String fileName;
    /**项目附件*/
    private String attachFile;
    /** 附件预览*/
    private String seeFile;
    /** 工作职责 */
	private String workDuty;
	/** 人员要求 */
	private String talentRequire;
	/** 提交时间*/
    private Timestamp createDatetime;
    
    
	/** 审核时间*/
    private Timestamp requirementDatetime;
    /** 审核结果 */
    private String auditStatus;
    private int auditStatusId;
    
	public Long getId() {
		return id;
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
	public Integer getWorkMode() {
		return workMode;
	}
	public String getProfessionalSkills() {
		return professionalSkills;
	}
	
	public String getRequirementDescription() {
		return requirementDescription;
	}
	public String getWorkSpace() {
		return workSpace;
	}
	public Timestamp getEffectiveDatetime() {
		return effectiveDatetime;
	}
	public String getRequirementClass() {
		return requirementClass;
	}
	public String[] getRequire() {
		return require;
	}
	public String getCooperateType() {
		return cooperateType;
	}
	public String getFileName() {
		return fileName;
	}
	public String getAttachFile() {
		return attachFile;
	}
	public String getSeeFile() {
		return seeFile;
	}
	public String getWorkDuty() {
		return workDuty;
	}
	public String getTalentRequire() {
		return talentRequire;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public int getAuditStatusId() {
		return auditStatusId;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setWorkMode(Integer workMode) {
		this.workMode = workMode;
	}
	public void setProfessionalSkills(String professionalSkills) {
		this.professionalSkills = professionalSkills;
	}
	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}
	public void setWorkSpace(String workSpace) {
		this.workSpace = workSpace;
	}
	public void setEffectiveDatetime(Timestamp effectiveDatetime) {
		this.effectiveDatetime = effectiveDatetime;
	}
	public void setRequirementClass(String requirementClass) {
		this.requirementClass = requirementClass;
	}
	public void setRequire(String[] require) {
		this.require = require;
	}
	public void setCooperateType(String cooperateType) {
		this.cooperateType = cooperateType;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
	public void setSeeFile(String seeFile) {
		this.seeFile = seeFile;
	}
	public void setWorkDuty(String workDuty) {
		this.workDuty = workDuty;
	}
	public void setTalentRequire(String talentRequire) {
		this.talentRequire = talentRequire;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	public void setAuditStatusId(int auditStatusId) {
		this.auditStatusId = auditStatusId;
	}
	public String getTalentBuget() {
		return talentBuget;
	}
	public void setTalentBuget(String talentBuget) {
		this.talentBuget = talentBuget;
	}
	public Timestamp getCreateDatetime() {
		return createDatetime;
	}
	public Timestamp getRequirementDatetime() {
		return requirementDatetime;
	}
	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}
	public void setRequirementDatetime(Timestamp requirementDatetime) {
		this.requirementDatetime = requirementDatetime;
	}

}
