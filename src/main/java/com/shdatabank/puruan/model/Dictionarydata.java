/**
 * Dictionarydata.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

/**
 * 字典数据
 */
public class Dictionarydata {

	/** 数据id */
	private Integer dataId;

	/** 字典id */
	private Integer dictId;

	/** 字典值 */
	private String dataValue;
//	/** 创意人才技能应实体类 */
//	private List<TalentTechnology> talentTechnologys;
//	/** 创意人才需求实体类 */
//	private List<TalentRequirement> talentRequirements;


	public Integer getDataId() {
		return dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public Integer getDictId() {
		return dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

}
