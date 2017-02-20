package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 专业评估审核实体类
 */
public class AssessmentAudit {
	
	/** 审核id */
    private Long auditId;
    /** 评估ID */
    private Long assessmentId;
    /** 审核的后台用户ID */
    private Long backUserId;
    /** 审核时间 */
    private Timestamp auditDateTime;
    /** 审核内容*/
    private String auditContent;
    /** 审核结果 */
    private String auditStatus;
    private int auditStatusId;
    /** 删除标志*/
    private Byte active;
    
    /** 专家ID */
	private Long professionalId;
    /** 专家姓名 */
	private String professionalName;
    /** 专业评估实体类 */
    private ProfessionalEvaluation professionalEvaluation;
    /** 评估状态 */
	private int assessmentStatus;
    
    /** page */
    private int page;
    /** pageSize */
    private int pageSize;
    /** 标记 */
    private String sign;
    
	public Long getAuditId() {
		return auditId;
	}
	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}
	public Long getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}
	public Long getBackUserId() {
		return backUserId;
	}
	public void setBackUserId(Long backUserId) {
		this.backUserId = backUserId;
	}
	public Timestamp getAuditDateTime() {
		return auditDateTime;
	}
	public void setAuditDateTime(Timestamp auditDateTime) {
		this.auditDateTime = auditDateTime;
	}
	public String getAuditContent() {
		return auditContent;
	}
	public void setAuditContent(String auditContent) {
		this.auditContent = auditContent;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	public int getAuditStatusId() {
		return auditStatusId;
	}
	public void setAuditStatusId(int auditStatusId) {
		this.auditStatusId = auditStatusId;
	}
	public Byte getActive() {
		return active;
	}
	public void setActive(Byte active) {
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
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public ProfessionalEvaluation getProfessionalEvaluation() {
		return professionalEvaluation;
	}
	public void setProfessionalEvaluation(ProfessionalEvaluation professionalEvaluation) {
		this.professionalEvaluation = professionalEvaluation;
	}
	public Long getProfessionalId() {
		return professionalId;
	}
	public void setProfessionalId(Long professionalId) {
		this.professionalId = professionalId;
	}
	public String getProfessionalName() {
		return professionalName;
	}
	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}
	public int getAssessmentStatus() {
		return assessmentStatus;
	}
	public void setAssessmentStatus(int assessmentStatus) {
		this.assessmentStatus = assessmentStatus;
	}

}
