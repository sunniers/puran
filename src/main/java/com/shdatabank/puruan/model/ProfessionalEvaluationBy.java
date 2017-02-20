package com.shdatabank.puruan.model;

/**
 * 专家评估选择
 */
public class ProfessionalEvaluationBy {

	/** 专家ID */
	private Long userId;
	/** 专家姓名 */
	private String userAlias;
	/** 专业领域ID */
	private Long professionalFieldValue;
	/** 专业领域值 */
	private String dataValue;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserAlias() {
		return userAlias;
	}
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	public Long getProfessionalFieldValue() {
		return professionalFieldValue;
	}
	public void setProfessionalFieldValue(Long professionalFieldValue) {
		this.professionalFieldValue = professionalFieldValue;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
}
