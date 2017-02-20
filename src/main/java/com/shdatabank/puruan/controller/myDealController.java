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
import com.shdatabank.puruan.model.MyDeal;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.MyDealService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 
 * 我的成交controller层
 *
 */
@Controller
@RequestMapping(value="/deal")
public class myDealController {
	/** 我的成交service注入*/
	@Autowired
	private MyDealService myDealService;
	@Autowired
	private HttpServletRequest httpServletRequest;
	/**
	 * 我的成交
	 * @param myDeal
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectMyBargain",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectMyBargain(@RequestBody MyDeal myDeal) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myDeal
		myDeal.setUserId(user.getUserId());
		PageInfo<MyDeal> selectMyBargain = myDealService.selectMyBargain(myDeal);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectMyBargain);
	}
	/**
	 * 查询我的成交
	 * @param myDeal
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectMyCommunity",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectMyCommunity(@RequestBody MyDeal myDeal) throws Exception {
		// 获取用户对象
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
		// 获取用户ID 放到myDeal
		myDeal.setUserId(user.getUserId());
		PageInfo<MyDeal> page = myDealService.selectMyCommunity(myDeal);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", page);
	}
	/**
	 * 查询详情
	 * @param myDeal
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectMyDeal",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectMyDeal(@RequestBody MyDeal myDeal) throws Exception {
		MyDeal selectMyDeal = myDealService.selectMyDeal(myDeal);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",selectMyDeal);
	}
	/**
	 * 查询出所有需求类型包含子类型
	 * @return 需求类型分类List(创意需求类型List)
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllRequirementType",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllRequirementType()throws Exception{
		List<Dictionary> selectAllRequirementType = myDealService.selectAllRequirementType();
		if(null == selectAllRequirementType){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",selectAllRequirementType);
		}
	}
}
