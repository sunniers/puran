/**
 * MyCommunityController.java
 * Created at 2016-10-24
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.MyCommunity;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.MyCommunityService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 
 * 我的圈子controller层
 *
 */
@Controller
@RequestMapping(value="/my")
public class MyCommunityController {
	/** 我的圈子service注入*/
	@Autowired
	private MyCommunityService myCommunityService;
	@Autowired
	private HttpServletRequest httpServletRequest;
	/**
	 * 我的圈子
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectMyCommunity",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectMyCommunity(@RequestBody User user) throws Exception {
		//获取用户对象
		User user2 = (User) httpServletRequest.getSession().getAttribute("user");
		if (null == user2) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		user.setUserId(user2.getUserId());
		// 将从页面上获取我的圈子。
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", myCommunityService.selectMyCommunity(user));
	}
	/**
	 * 我的圈子信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCommunity",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectCommunity(@RequestBody MyCommunity myCommunity) throws Exception {
		//获取用户对象
		User user2 = (User) httpServletRequest.getSession().getAttribute("user");
		if (null == user2) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		myCommunity.setUserId(user2.getUserId());
		// 将从页面上获取我的圈子。
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", myCommunityService.selectCommunity(myCommunity));
	}
	/**
	 * 新增我的圈子信息
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/insertMyCommunity",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertMyCommunity(@RequestBody MyCommunity myCommunity) throws Exception {
		//获取用户对象
		User user2 = (User) httpServletRequest.getSession().getAttribute("user");
		if (null == user2) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		myCommunity.setUserId(user2.getUserId());
		  if (myCommunityService.insertMyCommunity(myCommunity)) {
	            //插入成功
	            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
	        } else {
	            //插入失败
	            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
	        }
	}
	/**
	 * 删除我的圈子信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/deleteMyCommunity",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject deleteMyCommunity(@RequestBody  MyCommunity myCommunity) throws Exception{
		//判断我的圈子是不是存在
//		if(null != myCommunityService.selectCommunity(myCommunity.getCommunityId())){
			//删除我的圈子
			if(null != myCommunity){
				myCommunityService.deleteMyCommunity(myCommunity);
			    return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
            }
//		 } else {
//	            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
//	        }
	}
	/**
	 * 加入团队的确定
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/insertTeam",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertTeam(@RequestBody  ProjectUserReleation projectUserReleation) throws Exception{
		if(null != projectUserReleation){
			User user = (User) httpServletRequest.getSession().getAttribute("user");
			projectUserReleation.setUserId(user.getUserId());
			myCommunityService.insertTeam(projectUserReleation);
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
		}
	}
	/**
	 * 查询项目名
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/selectProjectName",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectProjectName(@RequestBody  ProjectRequirement projectRequirement) throws Exception{
		//如果项目需求不为空
			User user = (User) httpServletRequest.getSession().getAttribute("user");
			if(null == user){
				return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
			}
			projectRequirement.setUserId(user.getUserId());
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",myCommunityService.selectProjectName(projectRequirement));
	}

}
