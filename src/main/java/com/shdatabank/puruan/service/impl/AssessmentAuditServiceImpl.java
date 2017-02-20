package com.shdatabank.puruan.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.controller.AssessmentAuditController;
import com.shdatabank.puruan.dao.AssessmentAuditDao;
import com.shdatabank.puruan.model.AssessmentAudit;
import com.shdatabank.puruan.model.ProfessionalEvaluation;
import com.shdatabank.puruan.model.ProfessionalEvaluationBy;
import com.shdatabank.puruan.model.SysMessage;
import com.shdatabank.puruan.service.AssessmentAuditService;
import com.shdatabank.puruan.service.SystemMessageService;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 专业评估审核service层实现类
 */
@Service
public class AssessmentAuditServiceImpl implements AssessmentAuditService {
	
	private Logger logger =Logger.getLogger(AssessmentAuditServiceImpl.class);

	/**
	 * 专业评估审核DAO层
	 */
	@Autowired
	private AssessmentAuditDao assessmentAuditDao;

	/** 系统消息实现类 */
	@Autowired
	private SystemMessageService systemMessageService;

	/**
	 * 查询已审核申请评估
	 * 
	 * @return 申请评估审核列表
	 */
	@Override
	public PageInfo<AssessmentAudit> selectAssessmentAuditsY(AssessmentAudit assessmentAudit) throws Exception {
		PageHelper.startPage(assessmentAudit.getPage(), assessmentAudit.getPageSize());
		List<AssessmentAudit> assessmentAudits = assessmentAuditDao.selectAllAssessmentAuditYes(assessmentAudit);
		return new PageInfo<AssessmentAudit>(assessmentAudits);
	}

	/**
	 * 查询已审核申请评估
	 * 
	 * @return 申请评估审核列表
	 */
	@Override
	public PageInfo<ProfessionalEvaluation> selectAssessmentAuditsN(ProfessionalEvaluation professionalEvaluation)
			throws Exception {
		PageHelper.startPage(professionalEvaluation.getPage(), professionalEvaluation.getPageSize());
		List<ProfessionalEvaluation> professionalEvaluations = assessmentAuditDao
				.selectAllAssessmentAuditNo(professionalEvaluation);
		for (int i = 0; i < professionalEvaluations.size(); i++) {
			professionalEvaluations.get(i).setProjectTypes(spliteUse(professionalEvaluations.get(i).getProjectType()));
		}
		return new PageInfo<ProfessionalEvaluation>(professionalEvaluations);
	}

	/**
	 * 自动选择专家
	 * 
	 * @return 申请评估列表
	 */
	@Override
	public ProfessionalEvaluationBy professionalEvaluationRand(Long projectId) throws Exception {
		return assessmentAuditDao.professionalEvaluationRand(projectId);
	}

	/**
	 * 根据专业领域选专家
	 * 
	 * @return
	 */
	@Override
	public List<ProfessionalEvaluationBy> findProfessionalByFile(int id) throws Exception {
		return assessmentAuditDao.findProfessionalByFile(id);
	}

	/**
	 * 专业评估审核
	 * 
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertAssessmentAudit(AssessmentAudit assessmentAudit) throws Exception {
		int count = assessmentAuditDao.insertAssessmentAudit(assessmentAudit);
		logger.debug("--添加评估审核结果--");
		if (count == 0) {
			return false;
		}
		ProfessionalEvaluation professionalEvaluation = new ProfessionalEvaluation();
		professionalEvaluation.setAssessmentId(assessmentAudit.getAssessmentId());
		professionalEvaluation.setProfessionalId(assessmentAudit.getProfessionalId());
		professionalEvaluation.setAssessmentStatus(assessmentAudit.getAssessmentStatus());
		professionalEvaluation.setEvaluationDate(new Date());
		logger.debug("--添加评估审核信息--");
		return assessmentAuditDao.updateAssessmentAudit(professionalEvaluation);
	}

	/**
	 * 专业评估反馈
	 * 
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertFeedback(Long backUserId, ProfessionalEvaluation professionalEvaluation) throws Exception {
		if (professionalEvaluation.getAssessmentFile() != null) {
			professionalEvaluation
					.setAssessmentFileSeePath(UserUtil.pdfChange(professionalEvaluation.getAssessmentFile()));
		}
		boolean flag = assessmentAuditDao.updateAssessmentAudit(professionalEvaluation);
		logger.debug("--添加评估反馈信息--");
		if (flag == false) {
			return false;
		}
		SysMessage msg = new SysMessage();
		msg.setMessageSubject("消息主题1");
		msg.setMessageTitle("消息标题");
		msg.setMessageContent("消息内容");
		msg.setMessageSender(backUserId);
		// msg.setReceiveMessageType(receiveMessageType);
		msg.setMessageReceiver(professionalEvaluation.getUserId());
		logger.debug("--发送通知消息--");
		return systemMessageService.insertSysMessage(msg);
	}

	/**
	 * 分割字符串
	 * 
	 * @param str
	 * @return String[]
	 */
	public String[] spliteUse(String str) {
		if (str != null) {
			return str.split(",");
		} else {
			return null;
		}
	}
}
