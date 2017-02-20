package com.shdatabank.puruan.model;

import java.util.List;

/**
 * 创意资源类型实体
 *
 */
public class CreativeResourceClassifier {

	/** 分类id **/
	private Long classifierId;
	
	/** 创意资源id **/
	private Long creativeResourceId;
	
	/** 分类值 **/
	private Integer classifierValue;
	
	/** 资源类型字典值List **/
	private List<Dictionarydata> dictionarydataList;

	public Long getClassifierId() {
		return classifierId;
	}

	public void setClassifierId(Long classifierId) {
		this.classifierId = classifierId;
	}

	public Long getCreativeResourceId() {
		return creativeResourceId;
	}

	public void setCreativeResourceId(Long creativeResourceId) {		 
		this.creativeResourceId = creativeResourceId;
	}

	public Integer getClassifierValue() {
		return classifierValue;
	}

	public void setClassifierValue(Integer classifierValue) {
		this.classifierValue = classifierValue;
	}

	public List<Dictionarydata> getDictionarydataList() {
		return dictionarydataList;
	}

	public void setDictionarydataList(List<Dictionarydata> dictionarydataList) {
		this.dictionarydataList = dictionarydataList;
	}
	
}
