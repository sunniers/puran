package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.AssessmentAudit;
import com.shdatabank.puruan.model.ProfessionalEvaluation;
import com.shdatabank.puruan.model.ProfessionalEvaluationBy;

/**
 * 专业评估审核service层
 */
public interface AssessmentAuditService {
	
	/**
	 * 查询已审核申请评估
	 * @return 申请评估审核列表
	 */
	public PageInfo<AssessmentAudit> selectAssessmentAuditsY(AssessmentAudit assessmentAudit) throws Exception;
	/**
	 * 查询未审核申请评估
	 * @return 申请评估列表
	 */
	public PageInfo<ProfessionalEvaluation> selectAssessmentAuditsN(ProfessionalEvaluation professionalEvaluation) throws Exception;
	/**
	 * 自动选择专家
	 * @return 专家
	 */
	public ProfessionalEvaluationBy professionalEvaluationRand(Long projectId) throws Exception;
	
	/**
	 * 根据专业领域选专家
	 * @return 专家
	 */
	public List<ProfessionalEvaluationBy> findProfessionalByFile(int id) throws Exception;
	
	/**
	 * 专业评估审核
	 * @return 
	 */
	public boolean insertAssessmentAudit(AssessmentAudit assessmentAudit)throws Exception;
	
	/**
	 * 专业评估反馈
	 * @return 
	 */
	public boolean insertFeedback(Long backUserId,ProfessionalEvaluation professionalEvaluation)throws Exception;
	
}
