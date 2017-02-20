/**
 * MyFavoriteController.java
 * Created at 2016-10-26
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

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.MyFavorite;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.model.UserHouse;
import com.shdatabank.puruan.service.MyFavoriteService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 
 * 我的收藏controller层
 *
 */
@Controller
@RequestMapping(value = "/favorite")
public class MyFavoriteController {
	/** 我的收藏service注入 */
	@Autowired
	private MyFavoriteService myFavoriteService;
	@Autowired
	private HttpServletRequest httpServletRequest;

	/**
	 * 查询我的收藏所有
	 * 
	 * @param myFavorite
	 * @return
	 */
	@RequestMapping(value = "/selectMyFavorite", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectMyFavorite(@RequestBody MyFavorite myFavorite) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myFavorite
		myFavorite.setUserId(user.getUserId());
		PageInfo<MyFavorite> page = myFavoriteService.selectMyFavorite(myFavorite);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", page);

	}

	/**
	 * 查询需求收藏
	 * @param userHouse 收藏对象
	 * @return 结果对象
	 */
	@RequestMapping(value = "/selectRequirementFavorite", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectRequirementFavorite(@RequestBody UserHouse userHouse)throws Exception{
		User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
        } else {
        	userHouse.setUserId(user.getUserId());
        }
        userHouse.setHouseType(SystemConstant.DICT_CREATIVE_REQUIREMENT_TYPE);
        userHouse.setHouseTypeOfFancing(SystemConstant.DICT_FANCING_REQUIREMENT_TYPE);
        userHouse.setHouseTypeOfTalent(SystemConstant.DICT_TALENT_REQUIREMENT_TYPE);
		PageInfo<MyFavorite> requirementFavoritePage = myFavoriteService.selectRequirement(userHouse);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", requirementFavoritePage);
	}
	
	/**
	 * 查询创意人才收藏
	 * @param userHouse 收藏对象
	 * @return 结果对象
	 */
	@RequestMapping(value = "/selectTalentFavorite", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectTalentFavorite(@RequestBody UserHouse userHouse)throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
        } else {
        	userHouse.setUserId(user.getUserId());
        }
        userHouse.setHouseType(SystemConstant.DICT_CREATIVE_TALENT_TYPE);
		PageInfo<UserCreativeTalent> userCreativeTalentPage = myFavoriteService.selectCreativeTalentFavorite(userHouse);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", userCreativeTalentPage);
	}
	
	/**
	 * 查询创意资源收藏
	 * @param userHouse 收藏对象
	 * @return 结果对象
	 */
	@RequestMapping(value = "/selectResourceFavorite", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectResourceFavorite(@RequestBody UserHouse userHouse) throws Exception{
		User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
        } else {
        	userHouse.setUserId(user.getUserId());
        }
        userHouse.setHouseType(SystemConstant.DICT_CREATIVE_RESOURCE_TYPE);
		PageInfo<CreativeResource> projectRequirementPage = myFavoriteService.selectCreativeResource(userHouse);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", projectRequirementPage);
	}
	
	/**
	 * 根据条件查询人才需求信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@RequestMapping(value = "/selectTalentbyName", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectTalentbyName(@RequestBody MyFavorite myFavorite) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myFavorite
		myFavorite.setUserId(user.getUserId());
		PageInfo<MyFavorite> page = myFavoriteService.selectTalentbyName(myFavorite);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", page);
	}
	/**
	 * 查看人才需求信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@RequestMapping(value = "/viewTalentbyName", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject viewTalentbyName(@RequestBody TalentRequirement talentRequirement) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myFavorite
		talentRequirement.setUserId(user.getUserId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", myFavoriteService.viewTalentbyName(talentRequirement));
	}

	/**
	 * 根据条件查询创意人才信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@RequestMapping(value = "/selectCreativebyName", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectCreativebyName(@RequestBody MyFavorite myFavorite) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myFavorite
		myFavorite.setUserId(user.getUserId());
		PageInfo<MyFavorite> page = myFavoriteService.selectCreativebyName(myFavorite);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", page);
	}
	/**
	 * 查看人才需求信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@RequestMapping(value = "/viewCreativebyName", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject viewCreativebyName(@RequestBody UserCreativeTalent userCreativeTalent) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myFavorite
		userCreativeTalent.setUserId(user.getUserId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", myFavoriteService.viewCreativebyName(userCreativeTalent));
	}

	/**
	 * 根据条件查询创意资源信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@RequestMapping(value = "/selectResourcebyName", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectResourcebyName(@RequestBody MyFavorite myFavorite) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myFavorite
		myFavorite.setUserId(user.getUserId());
		PageInfo<MyFavorite> page = myFavoriteService.selectResourcebyName(myFavorite);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", page);
	}
	/**
	 * 查看人才需求信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@RequestMapping(value = "/viewResourcebyName", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject viewResourcebyName(@RequestBody CreativeResource creativeResource) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myFavorite
		creativeResource.setUserId(user.getUserId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", myFavoriteService.viewResourcebyName(creativeResource));
	}

	/**
	 * 插入我的收藏
	 * 
	 * @param myFavorite
	 * @return
	 */
	@RequestMapping(value = "/insertMyFavorite", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertMyFavorite(@RequestBody UserHouse userHouse) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myFavorite
		userHouse.setUserId(user.getUserId());
		if (myFavoriteService.insertMyFavorite(userHouse)) {
			// 插入成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			// 插入失败
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 删除收藏
	 * 
	 * @param myFavorite
	 * @return
	 */
	@RequestMapping(value = "/deleteUserHouse", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject deleteUserHouse(@RequestBody UserHouse userHouse) throws Exception {
		if (myFavoriteService.deleteUserHouse(userHouse)) {
			// 删除成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			// 删除失败
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR, SystemConstant.DELETE_ERROR_MSG);
		}
	}

}
