package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.EvaluationResponse;
import com.shdatabank.puruan.model.ProfessionalEvaluation;
import com.shdatabank.puruan.model.ProjectPlan;

/**
 * 软件创意评估service层
 */
public interface ProfessionalEvaluationService {
	
	/**
     * 查询申请人信息
     * @param userId 用户id
     * @return 返回查询的申请人信息及申请项目列表
     */
    public EvaluationResponse findApplyPersonMessage(Long userId) throws Exception;
    /**
     * 增加项目评估
     * @return true or false
     */
    public boolean insertApplyMessage(ProfessionalEvaluation professionalEvaluation) throws Exception;
    
    /**
     * 项目评估列表
     * @return true or false
     */
    public PageInfo<ProfessionalEvaluation> findEvaluationProjiect(ProfessionalEvaluation professionalEvaluation)throws Exception;
    
    /**
     * 项目评估查看
     * @return true or false
     */
    public ProfessionalEvaluation seekEvaluationProjiect(ProfessionalEvaluation professionalEvaluation)throws Exception;


}
