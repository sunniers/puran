package com.shdatabank.puruan.model;

import java.sql.Timestamp;

public class MyDeal {

	/** 资源id */
	private Long id;
	/** 类型 */
	private Integer sign;
	/** 资源名称 */
	private String name;
	/** 资源描述 */
	private String description;
	/** 成交时间 */
	private String startTime;
	/** 成交时间 */
	private Timestamp time;
	/** 成交时间 */
	private String endTime;
	/** 成交时间映射 */
	private String timeMaping;
	/** 成交数量 */
	private Float number;
	/** 成交状态 */
	private String transactionStatus;
	/** 用户ID */
	private Long userId;
	/** 创意需求实体类 */
	private ProjectRequirement projectRequirement;
	/** 创意人才需求实体类 */
	private TalentRequirement talentRequirement;
	/** 创意资源实体类 */
	private CreativeResourceFront creativeResourceFront;
	/** 人才交易实体类 */
	private TalentTransaction talentTransaction;
	/** 项目承接实体类 */
	private ProjectRequirementUndertake projectRequirementUndertake;
	/** 资源交易实体类 */
	private CeativeResourceTransaction ceativeResourceTransaction;
	/** 创意人才实体类 */
	private UserCreativeTalent userCreativeTalent;
	/** 页码 */
	private int page;
	/** 每页显示数量 */
	private int pageSize;
	
	public UserCreativeTalent getUserCreativeTalent() {
		return userCreativeTalent;
	}

	public void setUserCreativeTalent(UserCreativeTalent userCreativeTalent) {
		this.userCreativeTalent = userCreativeTalent;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public ProjectRequirement getProjectRequirement() {
		return projectRequirement;
	}

	public void setProjectRequirement(ProjectRequirement projectRequirement) {
		this.projectRequirement = projectRequirement;
	}

	public TalentRequirement getTalentRequirement() {
		return talentRequirement;
	}

	public void setTalentRequirement(TalentRequirement talentRequirement) {
		this.talentRequirement = talentRequirement;
	}

	public CreativeResourceFront getCreativeResourceFront() {
		return creativeResourceFront;
	}

	public void setCreativeResourceFront(CreativeResourceFront creativeResourceFront) {
		this.creativeResourceFront = creativeResourceFront;
	}

	public TalentTransaction getTalentTransaction() {
		return talentTransaction;
	}

	public void setTalentTransaction(TalentTransaction talentTransaction) {
		this.talentTransaction = talentTransaction;
	}

	public ProjectRequirementUndertake getProjectRequirementUndertake() {
		return projectRequirementUndertake;
	}

	public void setProjectRequirementUndertake(ProjectRequirementUndertake projectRequirementUndertake) {
		this.projectRequirementUndertake = projectRequirementUndertake;
	}

	public CeativeResourceTransaction getCeativeResourceTransaction() {
		return ceativeResourceTransaction;
	}

	public void setCeativeResourceTransaction(CeativeResourceTransaction ceativeResourceTransaction) {
		this.ceativeResourceTransaction = ceativeResourceTransaction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSign() {
		return sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTimeMaping() {
		return timeMaping;
	}

	public void setTimeMaping(String timeMaping) {
		this.timeMaping = timeMaping;
	}

	public Float getNumber() {
		return number;
	}

	public void setNumber(Float number) {
		this.number = number;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
