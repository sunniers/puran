package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.AssessmentAudit;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.ListModel;
import com.shdatabank.puruan.model.ProfessionalEvaluation;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.AssessmentAuditService;
import com.shdatabank.puruan.service.impl.AssessmentAuditServiceImpl;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 专业评估审核controller
 * 
 */
@Controller
@RequestMapping(value = "/assAudit")
public class AssessmentAuditController {
	
	private Logger logger =Logger.getLogger(AssessmentAuditController.class);

	/** 资源发布审核service */
	@Autowired
	private AssessmentAuditService assessmentAuditService;

	@Autowired
	private HttpServletRequest httpServletRequest;
	/**
	 * 查询已审核专业评估申请
	 * 
	 * @param
	 * @return 专业评估申请
	 */
	@RequestMapping(value = "/findY", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findQesourcesY(@RequestBody AssessmentAudit assessmentAudit) throws Exception {
		logger.debug("又是一个牛逼的操作");
		PageInfo<AssessmentAudit> assessmentAudits = assessmentAuditService.selectAssessmentAuditsY(assessmentAudit);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", assessmentAudits);
	}

	/**
	 * 查询未审核专业评估申请
	 * 
	 * @param
	 * @return 专业评估申请
	 */
	@RequestMapping(value = "/findN", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findQesourcesN(@RequestBody ProfessionalEvaluation professionalEvaluation) throws Exception {
		PageInfo<ProfessionalEvaluation> professionalEvaluations = assessmentAuditService
				.selectAssessmentAuditsN(professionalEvaluation);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", professionalEvaluations);
	}

	/**
	 * 自动选择专家
	 * 
	 * @param
	 * @return 专业评估申请
	 */
	@RequestMapping(value = "/rand", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject professionalEvaluationRand(@RequestBody ProfessionalEvaluation professionalEvaluation)
			throws Exception {

		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				assessmentAuditService.professionalEvaluationRand(professionalEvaluation.getProjectId()));
	}

	/**
	 * 根据专业领域选专家
	 * 
	 * @return 结果对象集合
	 */
	@RequestMapping(value = "/proficient", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findProficientList(@RequestBody ListModel listModel) throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				assessmentAuditService.findProfessionalByFile(listModel.getId()));
	}
	
	/**
	 * 专业评估审核
	 * @param status 需求审核实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertAssessmentAudit(@RequestBody AssessmentAudit assessmentAudit) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (user == null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, "需要先先登录哦，亲");
		}
		assessmentAudit.setBackUserId(user.getUserId());
		//需求审核添加
        if (assessmentAuditService.insertAssessmentAudit(assessmentAudit)) {
            //插入成功
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            //插入失败
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
	}
	/**
	 * 专业评估反馈 
	 * @param status 需求审核实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertFeedback(@RequestBody ProfessionalEvaluation professionalEvaluation) throws Exception {
		BackUser user = (BackUser) httpServletRequest.getSession().getAttribute("backUser");
		if (user == null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, "需要先先登录哦，亲");
		}
		//需求审核添加
        if (assessmentAuditService.insertFeedback(user.getUserId().longValue(),professionalEvaluation)) {
            //插入成功
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            //插入失败
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
	}
}
