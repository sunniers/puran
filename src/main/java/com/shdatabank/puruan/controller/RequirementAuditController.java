package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.RequirementAudit;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.RequirementAuditService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 需求发布审核controller层
 */
@RequestMapping(value = "/req_audit")
@Controller
public class RequirementAuditController {

	/** 需求发布审核service */
	@Autowired
	private RequirementAuditService requirementAuditService;

	@Autowired
	private HttpServletRequest httpServletRequest;

	/**
	 * 
	 * 查询需求发布 已审核,未审核
	 * 
	 * @param RequirementAudit
	 *            :需求发布审核实体
	 * @return 需求发布审核列表
	 */
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findRequirement(@RequestBody RequirementAudit requirementAudit) throws Exception {
		PageInfo<RequirementAudit> requirementAudits = requirementAuditService.findRequirements(requirementAudit);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", requirementAudits);
	}

	/**
	 * 需求审核
	 * 
	 * @param status
	 *            需求审核实体类
	 *            
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertRequirementAudit(@RequestBody RequirementAudit requirementAudit) throws Exception {
		BackUser user = (BackUser) httpServletRequest.getSession().getAttribute("backUser");
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "需要先登录哦，亲");
		}
		requirementAudit.setBackUserId(user.getUserId());
		// 需求审核添加
		if (requirementAuditService.insertRequirementAudit(requirementAudit)) {
			// 插入成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			// 插入失败
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 创意需求查看
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findProj", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectRequirementProj(@RequestBody RequirementAudit requirementAudit) throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				requirementAuditService.selectRequirementProj(requirementAudit));
	}
	/**
	 * 人才需求查看
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findTalent", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectRequirementTalent(@RequestBody RequirementAudit requirementAudit) throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				requirementAuditService.selectRequirementTalent(requirementAudit));
	}
	/**
	 * 融资需求查看
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findFancing", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectRequirementFancing(@RequestBody RequirementAudit requirementAudit) throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				requirementAuditService.selectRequirementFancing(requirementAudit));
	}
}
