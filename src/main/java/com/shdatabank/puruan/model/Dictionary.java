/**
 * Dictionary.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.util.List;

/**
 * 数据字典
 */
public class Dictionary {

	/** 字典id */
	private Integer dictId;

	/** parent_id */
	private Integer parentId;

	/** 字典名称 */
	private String dictName;

	/** 字典数据 */
	private List<Dictionarydata> dictionarydatas;

	/** 查询条件 */
	private String dictNames;

	public Integer getDictId() {
		return dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public List<Dictionarydata> getDictionarydatas() {
		return dictionarydatas;
	}

	public void setDictionarydatas(List<Dictionarydata> dictionarydatas) {
		this.dictionarydatas = dictionarydatas;
	}

	public String getDictNames() {
		return dictNames;
	}

	public void setDictNames(String dictNames) {
		this.dictNames = dictNames;
	}
}
