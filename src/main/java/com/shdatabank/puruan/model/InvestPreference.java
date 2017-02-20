package com.shdatabank.puruan.model;

/**
 * 投资偏好实体类
 */
public class InvestPreference {
	
	/** 投资偏好ID */
	private int investPreferenceId;
	/** 投资公司ID */
	private Long  investCompanyId;
	/** 投资偏好值ID */
	private int investPreferenceValueId;
	/** 投资偏好值 */
	private String  preferenceValue;
	
	public int getInvestPreferenceId() {
		return investPreferenceId;
	}
	public void setInvestPreferenceId(int investPreferenceId) {
		this.investPreferenceId = investPreferenceId;
	}
	public Long getInvestCompanyId() {
		return investCompanyId;
	}
	public void setInvestCompanyId(Long investCompanyId) {
		this.investCompanyId = investCompanyId;
	}
	
	public String getPreferenceValue() {
		return preferenceValue;
	}
	public void setPreferenceValue(String preferenceValue) {
		this.preferenceValue = preferenceValue;
	}
	public int getInvestPreferenceValueId() {
		return investPreferenceValueId;
	}
	public void setInvestPreferenceValueId(int investPreferenceValueId) {
		this.investPreferenceValueId = investPreferenceValueId;
	}
	
}
