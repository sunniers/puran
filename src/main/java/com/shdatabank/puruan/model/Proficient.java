package com.shdatabank.puruan.model;

/**
 * 专家库管理实体类
 */
public class Proficient {
	/** 用户id */
	private Long userId;
	/** 用户名 */
	private String userName;
	/** 专家姓名 */
	private String userAlias;
	/** 用户密码 */
	private String userPwd;
	/** 专家手机号 */
	private String userMobile;
	/** 专家邮箱 */
	private String userEmail;

	/** 专业领域ID */
	private int professionalFielId;
	/** 专业领域 */
	private String professionalField;
	/** 专业领域 值 */
	private String[] professionalValue;

	/** 页码 */
	private int page;
	/** 每页显示数量 */
	private int pageSize;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getProfessionalField() {
		return professionalField;
	}

	public void setProfessionalField(String professionalField) {
		this.professionalField = professionalField;
	}

	public String[] getProfessionalValue() {
		return professionalValue;
	}

	public void setProfessionalValue(String[] professionalValue) {
		this.professionalValue = professionalValue;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getProfessionalFielId() {
		return professionalFielId;
	}

	public void setProfessionalFielId(int professionalFielId) {
		this.professionalFielId = professionalFielId;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
