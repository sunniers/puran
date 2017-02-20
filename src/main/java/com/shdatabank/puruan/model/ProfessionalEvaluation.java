package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 专业评估实体类
 */
public class ProfessionalEvaluation {

	/** 评估ID */
	private Long assessmentId;
	/** 项目ID */
	private Long projectId;
	/** 专家ID */
	private Long professionalId;
	/** 期望评估时间 */
	private Date assessmentDate;
	/** 申请人ID */
	private Long userId;
	/** 联系电话 */
	private String mobile;
	/** 项目描述 */
	private String projectDescribe;
	/** 专家意见 */
	private String assessmentView;
	/** 评估状态 */
	private int assessmentStatus;
	/** 评估状态value */
	private String dataValue;
	/** 实际评估时间 */
	private Date evaluationDate;
	/** 附件预览路径 */
	private String assessmentFileSeePath;
	/** 附件 名称*/
	private String assessmentFileName;
	/** 附件 */
	private String assessmentFile;
	/** 创建时间 */
	private Timestamp createDatetime;
	/** 删除标志 */
	private Byte active;

	/** 申请人 */
	private String applyPerson;
	/** 专家姓名 */
	private String professionalName;
	/** 项目名称 */
	private String projectName;
	/** 项目类型 */
	private String projectType;
	private String[] projectTypes;
	
	/** page */
	private int page;
	/** pageSize */
	private int pageSize;

	public Long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Date getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProjectDescribe() {
		return projectDescribe;
	}

	public void setProjectDescribe(String projectDescribe) {
		this.projectDescribe = projectDescribe;
	}

	public String getAssessmentView() {
		return assessmentView;
	}

	public void setAssessmentView(String assessmentView) {
		this.assessmentView = assessmentView;
	}

	public int getAssessmentStatus() {
		return assessmentStatus;
	}

	public void setAssessmentStatus(int assessmentStatus) {
		this.assessmentStatus = assessmentStatus;
	}

	public Long getProfessionalId() {
		return professionalId;
	}

	public void setProfessionalId(Long professionalId) {
		this.professionalId = professionalId;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public Date getEvaluationDate() {
		return evaluationDate;
	}

	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public String getApplyPerson() {
		return applyPerson;
	}

	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}

	public String getAssessmentFile() {
		return assessmentFile;
	}

	public void setAssessmentFile(String assessmentFile) {
		this.assessmentFile = assessmentFile;
	}

	public String getProfessionalName() {
		return professionalName;
	}

	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String[] getProjectTypes() {
		return projectTypes;
	}

	public void setProjectTypes(String[] projectTypes) {
		this.projectTypes = projectTypes;
	}

	public String getAssessmentFileSeePath() {
		return assessmentFileSeePath;
	}

	public String getAssessmentFileName() {
		return assessmentFileName;
	}

	public void setAssessmentFileSeePath(String assessmentFileSeePath) {
		this.assessmentFileSeePath = assessmentFileSeePath;
	}

	public void setAssessmentFileName(String assessmentFileName) {
		this.assessmentFileName = assessmentFileName;
	}

}
