package com.shdatabank.puruan.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 融资实体类
 */
public class Fancing {

	/** 融资id */
	private long fancingId;
	/** 项目名称 */
	private String projectName;
	/** 用户id */
	private long userId;
	/** 融资金额 */
	private BigDecimal fancingMoney;
	/** 融资描述 */
	private String fancingDescription;
	/** 融资用途 */
	private String fancingUse;
	/** 发布方式 */
	private String publishWay;
	/** 附件名称 */
	private String fancingFileName;
	/** 融资主体 */
	private String fancingBody;
	/** 融资附件路径 */
	private String fancingAttachment;
	/** 融资附件预览路径 */
	private String fancingFileSeePath;
	/** 附件名称 */
	private String fancingAttachFile;
	/** 融资方式*/
	private Integer fancingWay;
	/** 融资状态 */
	private Integer fancingStatus;
	/** 角色删除标记*/
	private byte active;
	/** 创建时间 */
	private Timestamp createDatetime;
	/** 是否公开 */
	private byte isOpen;
	/** 发布方 */
	private String publishName;
	/** 页码 */
	private int page;
	/** 每页显示数量 */
	private int pageSize;	
	/** 时间范围开始*/
	private String startTime;
	/** 时间范围结束 */
	private String endTime;
	/** 融资类型数组 */
	private String[] classValue;
	/** 融资类型字符串 */
	private String classStr;
		
	/** 发布人公司名称 */
	private String companyName;
	/** 发布人是否已认证： 0：已认证，1：未认证 */
	private Integer isAudit;
	/** 发布人手机号是否已认证： 0：已认证，1：未认证 */
	private Integer isAuditMobile;
	/** 发布人邮箱是否已认证： 0：已认证，1：未认证 */
	private Integer isAuditEmail;
	/** 发布方式的值 */
	private String fancingWayValue;
	/** 审核通过时间 */
	private Timestamp auditDatetime;

	public long getFancingId() {
		return fancingId;
	}

	public void setFancingId(long fancingId) {
		this.fancingId = fancingId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFancingUse() {
		return fancingUse;
	}

	public void setFancingUse(String fancingUse) {
		this.fancingUse = fancingUse;
	}

	public BigDecimal getFancingMoney() {
		return fancingMoney;
	}

	public void setFancingMoney(BigDecimal fancingMoney) {
		this.fancingMoney = fancingMoney;
	}

	public String getFancingDescription() {
		return fancingDescription;
	}

	public void setFancingDescription(String fancingDescription) {
		this.fancingDescription = fancingDescription;
	}

	public String getFancingAttachFile() {
		return fancingAttachFile;
	}

	public void setFancingAttachFile(String fancingAttachFile) {
		this.fancingAttachFile = fancingAttachFile;
	}

	public Integer getFancingStatus() {
		return fancingStatus;
	}

	public void setFancingStatus(Integer fancingStatus) {
		this.fancingStatus = fancingStatus;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getPublishName() {
		return publishName;
	}

	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getClassStr() {
		return classStr;
	}

	public void setClassStr(String classStr) {
		this.classStr = classStr;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPublishWay() {
		return publishWay;
	}

	public void setPublishWay(String publishWay) {
		this.publishWay = publishWay;
	}

	public String getFancingFileName() {
		return fancingFileName;
	}

	public void setFancingFileName(String fancingFileName) {
		this.fancingFileName = fancingFileName;
	}

	public String getFancingBody() {
		return fancingBody;
	}

	public void setFancingBody(String fancingBody) {
		this.fancingBody = fancingBody;
	}

	public String getFancingAttachment() {
		return fancingAttachment;
	}

	public void setFancingAttachment(String fancingAttachment) {
		this.fancingAttachment = fancingAttachment;
	}

	public String getFancingFileSeePath() {
		return fancingFileSeePath;
	}

	public void setFancingFileSeePath(String fancingFileSeePath) {
		this.fancingFileSeePath = fancingFileSeePath;
	}

	public Integer getFancingWay() {
		return fancingWay;
	}

	public void setFancingWay(Integer fancingWay) {
		this.fancingWay = fancingWay;
	}

	public byte getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(byte isOpen) {
		this.isOpen = isOpen;
	}

	public String[] getClassValue() {
		return classValue;
	}

	public void setClassValue(String[] classValue) {
		this.classValue = classValue;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(Integer isAudit) {
		this.isAudit = isAudit;
	}

	public Integer getIsAuditMobile() {
		return isAuditMobile;
	}

	public void setIsAuditMobile(Integer isAuditMobile) {
		this.isAuditMobile = isAuditMobile;
	}

	public Integer getIsAuditEmail() {
		return isAuditEmail;
	}

	public void setIsAuditEmail(Integer isAuditEmail) {
		this.isAuditEmail = isAuditEmail;
	}

	public String getFancingWayValue() {
		return fancingWayValue;
	}

	public void setFancingWayValue(String fancingWayValue) {
		this.fancingWayValue = fancingWayValue;
	}

	public Timestamp getAuditDatetime() {
		return auditDatetime;
	}

	public void setAuditDatetime(Timestamp auditDatetime) {
		this.auditDatetime = auditDatetime;
	}
}
