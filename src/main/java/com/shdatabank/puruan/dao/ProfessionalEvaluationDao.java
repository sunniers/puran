package com.shdatabank.puruan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shdatabank.puruan.model.ListModel;
import com.shdatabank.puruan.model.ProfessionalEvaluation;
/**
 * 软件创意评估Dao层
 */
public interface ProfessionalEvaluationDao {
	/**
	 * 用户申请项目列表
	 * @return 列表
	 */
	public List<ListModel> findProjectList(@Param(value = "userId") Long userId);
	/**
	 * 查询申请人
	 * @return 列表
	 */
	public String findApplyPerson(@Param(value = "userId") Long userId);
	/**
     * 增加项目评估
     * @return true or false
     */
	public boolean insertApplyMessage(ProfessionalEvaluation professionalEvaluation);
	/**
     * 修改项目评估
     * @return true or false
     */
	public boolean updateApplyMessage(ProfessionalEvaluation professionalEvaluation);
	/**
     * 项目评估列表查询
     */
	public List<ProfessionalEvaluation> findProfessionalEvaluation(ProfessionalEvaluation professionalEvaluation);
	/**
     * 项目评估查看
     */
	public ProfessionalEvaluation findProfessionalEvaluationById(ProfessionalEvaluation professionalEvaluation);

}
