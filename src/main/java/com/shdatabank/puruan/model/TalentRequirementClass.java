/**
 * TalentRequirementClass.java
 * Created at 2016-11-22
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;
/**
 * 人才需求分类
 * @author Administrator
 *
 */
public class TalentRequirementClass {

	/** 人才需求分类ID */
	private Long talentRequirementClassId;

	/** 人才需求ID */
	private Long talentRequirementId;

	/** 人才需求分类值 */
	private Integer talentRequirementClassValue;
	/** 人才需求分类名称 */
	private String talentRequirementClassName;

	public Long getTalentRequirementClassId() {
		return talentRequirementClassId;
	}

	public void setTalentRequirementClassId(Long talentRequirementClassId) {
		this.talentRequirementClassId = talentRequirementClassId;
	}

	public Long getTalentRequirementId() {
		return talentRequirementId;
	}

	public void setTalentRequirementId(Long talentRequirementId) {
		this.talentRequirementId = talentRequirementId;
	}

	public Integer getTalentRequirementClassValue() {
		return talentRequirementClassValue;
	}

	public void setTalentRequirementClassValue(Integer talentRequirementClassValue) {
		this.talentRequirementClassValue = talentRequirementClassValue;
	}

	public String getTalentRequirementClassName() {
		return talentRequirementClassName;
	}

	public void setTalentRequirementClassName(String talentRequirementClassName) {
		this.talentRequirementClassName = talentRequirementClassName;
	}

}
