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
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.CreativeResourceAudit;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.CreativeResourceAuditService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 资源发布审核controller层
 */
@RequestMapping(value = "/resource_audit")
@Controller
public class CreativeResourceAuditController {
	
	
	/** 资源发布审核service */
	@Autowired
	private CreativeResourceAuditService creativeResourceAuditService;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	/**
	 * 查询资源发布  已审核,未审核
	 * @param CreativeResourceAudit 审核结果
	 * @return 资源发布审核列表
	 */
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findQesources(@RequestBody CreativeResourceAudit creativeResourceAudit ) throws Exception {
		PageInfo<CreativeResourceAudit> requirementAudits = creativeResourceAuditService.findQesources(creativeResourceAudit);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",requirementAudits);
	}
	
	/**
	 *资源发布查看
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findReq", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findQesource(@RequestBody CreativeResourceAudit creativeResourceAudit) throws Exception {
		CreativeResource creativeResource = creativeResourceAuditService.findQesource(creativeResourceAudit.getResourceId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", creativeResource);
	}
	
	/**
	 * 创意资源审核
	 * @param status 需求审核实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertRequirementAudit(@RequestBody CreativeResourceAudit creativeResourceAudit) throws Exception {
		BackUser user = (BackUser) httpServletRequest.getSession().getAttribute("backUser");
		 if (null == user){
			 return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "需要先登录哦，亲");
		 }
		 creativeResourceAudit.setBackUserId(user.getUserId());
		//需求审核添加
        if (creativeResourceAuditService.insertQesourceAudit(creativeResourceAudit)) {
            //插入成功
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            //插入失败
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
	}
	
}
