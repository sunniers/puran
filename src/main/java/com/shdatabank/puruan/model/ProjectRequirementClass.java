/**
 * ProjectRequirementClass.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

public class ProjectRequirementClass {

    /** 项目类型id */
    private Long projRequirementClassId;
    
    /** 项目id */
    private Long projRequireId;
    
    /** 项目类型 */
    private Integer projRequireClassValue;
    /** 项目类型名称 */
    private String projRequireClassName;
    
    /** 项目类型值 */
    private String projRequireClassValues;

    public String getProjRequireClassName() {
		return projRequireClassName;
	}

	public void setProjRequireClassName(String projRequireClassName) {
		this.projRequireClassName = projRequireClassName;
	}

	public Long getProjRequirementClassId() {
        return projRequirementClassId;
    }

    public void setProjRequirementClassId(Long projRequirementClassId) {
        this.projRequirementClassId = projRequirementClassId;
    }

    public Long getProjRequireId() {
        return projRequireId;
    }

    public void setProjRequireId(Long projRequireId) {
        this.projRequireId = projRequireId;
    }

    public String getProjRequireClassValues() {
        return projRequireClassValues;
    }

    public void setProjRequireClassValues(String projRequireClassValues) {
        this.projRequireClassValues = projRequireClassValues;
    }

    public Integer getProjRequireClassValue() {
        return projRequireClassValue;
    }

    public void setProjRequireClassValue(Integer projRequireClassValue) {
        this.projRequireClassValue = projRequireClassValue;
    }
    
}
