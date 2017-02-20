package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.AssessmentAudit;
import com.shdatabank.puruan.model.ProfessionalEvaluation;
import com.shdatabank.puruan.model.ProfessionalEvaluationBy;

/**
 * 专业评估审核DAO层
 */
public interface AssessmentAuditDao {

	/**
	 * 查询所有已审核专业评估
	 * @return 
	 */
	public List<AssessmentAudit> selectAllAssessmentAuditYes(AssessmentAudit assessmentAudit);
	/**
	 * 查询所有未审核专业评估
	 * @return 专业评估审核列表
	 */
	public List<ProfessionalEvaluation> selectAllAssessmentAuditNo(ProfessionalEvaluation professionalEvaluation);
	/**
	 * 自动选择专家
	 * @return 
	 */
	public ProfessionalEvaluationBy professionalEvaluationRand(Long projectId);
	
	/**
	 * 根据专业领域选专家
	 * @return 
	 */
	public  List<ProfessionalEvaluationBy> findProfessionalByFile(int id);
	
	/**
	 * 专业评估审核
	 * @return 
	 */
	public int insertAssessmentAudit(AssessmentAudit assessmentAudit);
	
	/**
     *	更新专业评估状态  及评估专家信息
     * @return 返回插入用户信息是否成功（成功-true;失败-false）
     */
	public boolean updateAssessmentAudit(ProfessionalEvaluation professionalEvaluation);
}
