/**
 * myDealController.java
 * Created at 2016-10-26
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.TalentRequirementService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;


/**
 * 
 * 人才需求controller层
 *
 */
@Controller
@RequestMapping(value="/talent")
public class TalentRequirementController {
	/** 人才需求service注入*/
	@Autowired
	private TalentRequirementService talentRequirementService;
	@Autowired
	private HttpServletRequest httpServletRequest;
	/**
	 * 查看创意人才列表
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectTaTechnology",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectTaTechnology(@RequestBody TalentRequirement talentRequirement) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		talentRequirement.setUserId(user.getUserId());
		PageInfo<TalentRequirement> selectTaTechnology = talentRequirementService.selectTaTechnology(talentRequirement);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectTaTechnology);
	}
	/**
	 * 根据ID查询要修改的草稿箱
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectTaRequirementId",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectTaRequirementId(@RequestBody TalentRequirement talentRequirement) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		talentRequirement.setUserId(user.getUserId());
		  TalentRequirement selectTaRequirementId = talentRequirementService.selectTaRequirementId(talentRequirement);
		 return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectTaRequirementId);
	}
	/**
	 * 插入人才需求
	 * @param projectRequirement
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateTaTechnology",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateTaTechnology(@RequestBody TalentRequirement talentRequirement) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		talentRequirement.setUserId(user.getUserId());
		if("0".equals(talentRequirement.getFlag())){
			//保存草稿
			talentRequirement.setRequirementStatus(400105);   
		}else {
			//提交成功发布
			talentRequirement.setRequirementStatus(400102);
			//设置预览路径
			if (null != talentRequirement.getTalentAttachment()) {
				talentRequirement.setTalentAttachmentSeePath(UserUtil.pdfChange(talentRequirement.getTalentAttachment()));
			}
		}
		  if (talentRequirementService.updateTaTechnology(talentRequirement)) {
	            //插入成功
	            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
	        } else {
	            //插入失败
	            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
	        }

	}
	/**
	 * 根据创意人才id假删除一条创意人才
	 * @param projectRequirement
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteTaTechnology",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject deleteTaTechnology(@RequestBody TalentRequirement talentRequirement) throws Exception {
		if (talentRequirementService.deleteTaTechnology(talentRequirement)) {
			//删除成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			//删除失败
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
		}
		
	}
	/**
	 * 查询出所有技术类型包含子类型
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllTechnologyType",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllTechnologyType() throws Exception {
		List<Dictionary> selectAllTechnologyType = talentRequirementService.selectAllTechnologyType();
		if (null == selectAllTechnologyType) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectAllTechnologyType);
		}

	}
	/**
	 * 查询出所有工作形式
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllWorkModeType",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllWorkModeType() throws Exception {
	 List<Dictionary> selectAllWorkModeType = talentRequirementService.selectAllWorkModeType();
		if (null == selectAllWorkModeType) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectAllWorkModeType);
		}
		
	}

}
