package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserAudit;
import com.shdatabank.puruan.service.UserAuditService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 后台角色管理controller层
 */
@RequestMapping(value = "/user_audit")
@Controller
public class UserAuditController {

	/**
	 * 身份审核service层
	 */
	@Autowired
	private UserAuditService userAuditService;
	@Autowired
	private HttpServletRequest httpServletRequest;

	/**
	 * 审核列表查看
	 * 
	 * @param userAudit
	 * @return
	 */
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectUserAudit(@RequestBody UserAudit userAudit) throws Exception {
		if (100501 == userAudit.getUserType()) {
			// 企业人审核
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
					userAuditService.selectCompanyCreditAudit(userAudit));
		} else if (100502 == userAudit.getUserType()) {
			// 个人审核
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
					userAuditService.selectUserExtensionInfoAudit(userAudit));
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "需要选择企业100501，或个人 100502", "");
		}
	}

	/**
	 * 身份信息查看
	 * 
	 * @param userAudit
	 * @return
	 */
	@RequestMapping(value = "/seek", method = RequestMethod.POST)
	@ResponseBody

	public ReturnObject findUserAuditById(@RequestBody UserAudit userAudit) throws Exception {
		if (100502 == userAudit.getUserType()) {
			// 个人信息
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
					userAuditService.findUserExtensionInfoAuditById(userAudit));
		} else {
			// 企业信息
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
					userAuditService.findCompanyCreditAuditById(userAudit));
		}
	}
	/**
	 * 审核结果插入
	 * 
	 * @param userAudit
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertUserAudit(@RequestBody UserAudit userAudit) throws Exception {
		BackUser user = (BackUser) httpServletRequest.getSession().getAttribute("backUser");
		 if (null == user){
			 return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "需要先登录哦，亲");
		 }
		userAudit.setBackUserId(user.getUserId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				userAuditService.insertUserAudit(userAudit));
	}
}
