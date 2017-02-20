package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.ProfessionalEvaluationDao;
import com.shdatabank.puruan.model.EvaluationResponse;
import com.shdatabank.puruan.model.ProfessionalEvaluation;
import com.shdatabank.puruan.service.ProfessionalEvaluationService;

/**
 * 软件创意评估service实现层
 */
@Service
public class ProfessionalEvaluationServiceImpl implements ProfessionalEvaluationService {
	
	private Logger logger = Logger.getLogger(ProfessionalEvaluationServiceImpl.class);

	/** 软件创意评估dao层 */
	@Autowired
	private ProfessionalEvaluationDao professionalEvaluationDao;


	/**
	 * 查询申请人信息
	 * @param userId
	 *            用户id
	 * @return 返回查询的申请人信息及申请项目列表
	 */
	@Override
	public EvaluationResponse findApplyPersonMessage(Long userId) throws Exception {
		EvaluationResponse evaluationResponse = new EvaluationResponse();
		//申请人
		evaluationResponse.setApplyPerson(professionalEvaluationDao.findApplyPerson(userId));
		//用户申请项目列表
		evaluationResponse.setProjectList(professionalEvaluationDao.findProjectList(userId));
		return evaluationResponse;
	}
	/**
     * 增加项目评估
     * @return true or false
     */
	@Transactional
	@Override
	public boolean insertApplyMessage(ProfessionalEvaluation professionalEvaluation) throws Exception {
		if(professionalEvaluation.getAssessmentId()!=null){
			//更新项目评估
			logger.debug("--更新项目评估--");
			return  professionalEvaluationDao.updateApplyMessage(professionalEvaluation);
		}
		//添加项目评估
		logger.debug("--添加项目评估--");
		return professionalEvaluationDao.insertApplyMessage(professionalEvaluation);
		
	}
	/**
     * 项目评估列表查询
     * @return 
     */
	@Override
	public PageInfo<ProfessionalEvaluation> findEvaluationProjiect(ProfessionalEvaluation professionalEvaluation) throws Exception {
		PageHelper.startPage(professionalEvaluation.getPage(), professionalEvaluation.getPageSize());
		List<ProfessionalEvaluation> professionalEvaluations = professionalEvaluationDao.findProfessionalEvaluation(professionalEvaluation);
		return new PageInfo<ProfessionalEvaluation>(professionalEvaluations);
	}
	
	/**
     * 项目评估查看
     */
	@Override
	public ProfessionalEvaluation seekEvaluationProjiect(
			ProfessionalEvaluation professionalEvaluation) throws Exception {
		 return professionalEvaluationDao.findProfessionalEvaluationById(professionalEvaluation);
	}

}
