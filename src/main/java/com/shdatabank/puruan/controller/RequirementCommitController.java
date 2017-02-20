/**
 * RequirementCommitController.java
 * Created at 2016-10-24
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
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementClass;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.SysMessage;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.RequirementCommitService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 
 * 需求提交controller层
 *
 */
@Controller
@RequestMapping(value="/requirement")
public class RequirementCommitController {
	/** 需求提交service注入*/
	@Autowired
	private RequirementCommitService requirementCommitService;
	@Autowired
	private HttpServletRequest httpServletRequest;
	/**
	 * 查看草稿箱
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectPrRequirement",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectPrRequirement(@RequestBody ProjectRequirement projectRequirement) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		projectRequirement.setPublishUserId(user.getUserId());
		 PageInfo<ProjectRequirement> selectPrRequirement = requirementCommitService.selectPrRequirement(projectRequirement);
		 return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectPrRequirement);
	}
	/**
	 * 保存和提交项目需求
	 * 通过状态判断：0表示是保存，1表示是提交
	 * @param projectRequirement
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertPrRequirement" ,method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertPrRequirement(@RequestBody ProjectRequirement projectRequirement) throws Exception{
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		projectRequirement.setPublishUserId(user.getUserId());
		if("0".equals(projectRequirement.getFlag())){
			//保存草稿
			projectRequirement.setProjFlowStatus(400105);
		}else {
			//提交成功发布
			projectRequirement.setProjFlowStatus(400102);
			if (null != projectRequirement.getProjAttachFile()) {
			    projectRequirement.setProjSeeFilePath(UserUtil.pdfChange(projectRequirement.getProjAttachFile()));
			}
		}
		if(requirementCommitService.insertPrRequirement(projectRequirement)){
			//  保存成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else {
			//保存失败
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
	}
	/**
	 * 根据ID查询要修改的草稿箱
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectPrRequirementId",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectPrRequirementId(@RequestBody ProjectRequirement projectRequirement) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		projectRequirement.setPublishUserId(user.getUserId());
		  ProjectRequirement selectPrRequirementId = requirementCommitService.selectPrRequirementId(projectRequirement);
		 return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectPrRequirementId);
	}
	/**
	 * 创意需求修改并重新发布：草稿状态、未通过审核状态、已删除状态
	 * @param 创意需求对象与需求分类对象集合
	 * @return 是否提交成功
	 * @throws Exception
	 */
//	@RequestMapping(value="/updatePrRequirement" ,method = RequestMethod.POST)
//	@ResponseBody
//	public ReturnObject updatePrRequirement(@RequestBody ProjectRequirement projectRequirement) throws Exception{
//		ProjectRequirement projectRequirement = projectRequirementeAndClass.getProjectRequirement();
//		List<ProjectRequirementClass> projectRequirementClasses = projectRequirementeAndClass.getProjectRequirementClasses();
//		Long projId = projectRequirement.getProjId();
//		//修改创意需求之前首先根据创意需求id删除所有创意需求类型
//		requirementCommitService.deleteRequirementType(projId);
//		List<ProjectRequirementClass> projectRequirementClasseList = new ArrayList<ProjectRequirementClass>();
//		//将该条需求的id做为插入需求类型表的参数放进需求分类对象list参数中
//		for (ProjectRequirementClass prc : projectRequirementClasses) {
//			ProjectRequirementClass paRequirementClass = new ProjectRequirementClass();
//			paRequirementClass.setProjRequireId(projId);
//			paRequirementClass.setProjRequireClassValues(prc.getProjRequireClassValues());
//			projectRequirementClasseList.add(paRequirementClass);
//		}
//		//修改需求的同时向需求分类表里插入一条数据
//		requirementCommitService.insertRequirementType(projectRequirementClasses);
		//重新发布创意需求
//		projectRequirement.setProjFlowStatus(400102);
//		projectRequirement.setActive((byte) 0);
//		if(requirementCommitService.updatePrRequirement(projectRequirement)){
//			//  保存成功
//			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
//		}else {
//			//保存失败
//			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
//		}
//	}
	/**
	 * 查询出所有需求类型包含子类型
	 * @return 需求类型分类List(创意需求类型List)
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllRequirementType",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllRequirementType()throws Exception{
		List<Dictionary> selectAllRequirementType = requirementCommitService.selectAllRequirementType();
		if(null == selectAllRequirementType){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",selectAllRequirementType);
		}
	}
	/**
	 *根据项目需求id假删除创意需求
	 * @param creativeResourceClassifierList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deletePrRequirement",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject deletePrRequirement(@RequestBody ProjectRequirement projectRequirement)throws Exception{
		boolean retMsg = requirementCommitService.deletePrRequirement(projectRequirement);
		if(retMsg){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
		}
	}
	
	/**
	 *测试创意需求添加类型能否成功
	 * @param creativeResourceClassifierList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertRequirementType",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertRequirementType(@RequestBody List<ProjectRequirementClass> projectRequirementClasses)throws Exception{
		boolean retMsg = requirementCommitService.insertRequirementType(projectRequirementClasses);
		if(retMsg){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
		}
	}
	
	
	/**
	 * 最新反馈
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectMessage",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectMessage(@RequestBody SysMessage sysMessage) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		sysMessage.setMessageReceiver(user.getUserId());
		PageInfo<SysMessage> selectMessage = requirementCommitService.selectMessage(sysMessage);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectMessage);
	}

}
