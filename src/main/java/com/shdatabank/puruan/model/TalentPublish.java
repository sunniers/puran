/**
 * SysResource.java
 * Created at 2016-10-20
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 人才需求发布表对应实体类
 * 
 * @author guoqiankun
 *
 */
public class TalentPublish {
	/** 发布id */
	private Integer publishId;
	/** 人才需求id */
	private Integer talentId;
	/** 岗位类型 */
	private String stationType;
	/** 需求名称 */
	private String requirementName;
	/** 需求概述 */
	private String requirementDescription;
	/** 工作职责 */
	private String jongResponse;
	/** 人员要求 */
	private String talentRequire;
	/** 附件名称 */
	private String attachName;
	/** 附件地址 */
	private String attachAddress;
	/** 发布时间 */
	private Timestamp publishDatetime;
	/** 创建时间映射 */
	private String publishDatetimeMapping;
	/** 发布状态 */
	private String publishStatus;
	/** 删除标志 */
	private String active;

	public Integer getPublishId() {
		return publishId;
	}

	public void setPublishId(Integer publishId) {
		this.publishId = publishId;
	}

	public Integer getTalentId() {
		return talentId;
	}

	public void setTalentId(Integer talentId) {
		this.talentId = talentId;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getRequirementName() {
		return requirementName;
	}

	public void setRequirementName(String requirementName) {
		this.requirementName = requirementName;
	}

	public String getRequirementDescription() {
		return requirementDescription;
	}

	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}

	public String getJongResponse() {
		return jongResponse;
	}

	public void setJongResponse(String jongResponse) {
		this.jongResponse = jongResponse;
	}

	public String getTalentRequire() {
		return talentRequire;
	}

	public void setTalentRequire(String talentRequire) {
		this.talentRequire = talentRequire;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public String getAttachAddress() {
		return attachAddress;
	}

	public void setAttachAddress(String attachAddress) {
		this.attachAddress = attachAddress;
	}

	public Timestamp getPublishDatetime() {
		return publishDatetime;
	}

	public void setPublishDatetime(Timestamp publishDatetime) {
		this.publishDatetime = publishDatetime;
	}

	public String getPublishDatetimeMapping() {
		return publishDatetimeMapping;
	}

	public void setPublishDatetimeMapping(String publishDatetimeMapping) {
		this.publishDatetimeMapping = publishDatetimeMapping;
	}

	public String getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
