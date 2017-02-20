package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.ProfessionalEvaluation;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.ProfessionalEvaluationService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 软件创意评估Controller
 */
@RequestMapping(value = "/evaluation")
@Controller
public class ProfessionalEvaluationController {

	/** 软件创意评估service层 */
	@Autowired
	private ProfessionalEvaluationService professionalEvaluationService;

	@Autowired
	private HttpServletRequest httpServletRequest;

	/**
	 * 查询 申请人 申请项目
	 * @param userId
	 *            用户id
	 * @return 返回查询的申请人信息及申请项目列表
	 */
	@RequestMapping(value = "/perMessage", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findApplyPersonMessage() throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (user == null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, "需要先先登录哦，亲");
		}
		
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				professionalEvaluationService.findApplyPersonMessage(user.getUserId()));
	}

	/**
	 *提交 申请评估 及修改
	 * 
	 * @param userId
	 *            用户id
	 * @return 返回查询的申请人信息及申请项目列表
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertApplyMessage(@RequestBody ProfessionalEvaluation professionalEvaluation)
			throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (user == null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, "需要先先登录哦，亲");
		}
		professionalEvaluation.setUserId(user.getUserId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				professionalEvaluationService.insertApplyMessage(professionalEvaluation));
	}
	
	/**
	 * 项目评估列表
	 * @param userId
	 *            用户id
	 * @return 项目评估列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findEvaluationProjiect(@RequestBody ProfessionalEvaluation professionalEvaluation) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (user == null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, "需要先先登录哦，亲");
		}
		professionalEvaluation.setUserId(user.getUserId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				professionalEvaluationService.findEvaluationProjiect(professionalEvaluation));
	}
	/**
	 * 项目评估详情查看
	 * @return 项目评估详情
	 */
	@RequestMapping(value = "/seek", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject seekEvaluationProjiect(@RequestBody ProfessionalEvaluation professionalEvaluation) throws Exception {
		
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				professionalEvaluationService.seekEvaluationProjiect(professionalEvaluation));
	}
}
