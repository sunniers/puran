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

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.ShoppingCart;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.MyShoppingCardService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 
 * 我的购物车controller层
 *
 */
@Controller
@RequestMapping(value="/card")
public class MyShoppingCardController {
	/** 我的购物车service注入*/
	@Autowired
	private MyShoppingCardService myShoppingCardService;
	@Autowired
	private HttpServletRequest httpServletRequest;
	/**
	 * 查看购物车
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/myShoppingCard",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject myShoppingCard(@RequestBody CreativeResource creativeResource) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		creativeResource.setUserId(user.getUserId());
		PageInfo<CreativeResource> selectShCard = myShoppingCardService.selectShCard(creativeResource);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectShCard);
	}
	/**
	 * 新增购物车
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertShCard",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertShCard(@RequestBody ShoppingCart shoppingCart) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		shoppingCart.setUserId(user.getUserId());
		// 将从页面上获取我的购物车。
		if (myShoppingCardService.insertShCard(shoppingCart)) {
			// 插入成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			// 插入失败
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 删除购物车
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteShCard",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject deleteShCard(@RequestBody ShoppingCart shoppingCart) throws Exception {
		// 将从页面上删除我的购物车。
		if (null != shoppingCart) {
			myShoppingCardService.deleteShCard(shoppingCart);
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR, SystemConstant.DELETE_ERROR_MSG);
		}
	}
	/**
	 * 修改购物车数量
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShCard",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateShCard(@RequestBody ShoppingCart shoppingCart) throws Exception {
		// 将从页面上删除我的购物车。
		if (null != shoppingCart) {
			User user = (User) httpServletRequest.getSession().getAttribute("user");
			//如果USER为空时
			if(null == user){
				return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
			}
			shoppingCart.setUserId(user.getUserId());
			myShoppingCardService.updateShCard(shoppingCart);
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR, SystemConstant.DELETE_ERROR_MSG);
		}
	} 
	
	/**
	 * 查询结算
	 * 
	 * @param creativeResource
	 * @return
	 */
	@RequestMapping(value="/selectAccount",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAccount(@RequestBody CreativeResource creativeResource) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		//如果USER为空时
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}
		creativeResource.setUserId(user.getUserId());
		PageInfo<CreativeResource> selectAccount = myShoppingCardService.selectAccount(creativeResource);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectAccount);
	}
	/**
	 * 商品的结算
	 * @param creativeResource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertAccount",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertAccount(@RequestBody CeativeResourceTransaction ceativeResourceTransaction) throws Exception {
		// 将从页面上删除我的购物车。
		if (null != ceativeResourceTransaction) {
			User user = (User) httpServletRequest.getSession().getAttribute("user");
			//如果USER为空时
			if(null == user){
				return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
			}
			ceativeResourceTransaction.setBuyUserId(user.getUserId());
			myShoppingCardService.insertAccount(ceativeResourceTransaction);
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}   

}
