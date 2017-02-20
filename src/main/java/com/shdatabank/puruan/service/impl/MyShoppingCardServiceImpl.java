/**
 * MyCommunityServiceImpl.java
 * Created at 2016-10-24
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.MyShoppingCardDao;
import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.ShoppingCart;
import com.shdatabank.puruan.service.MyShoppingCardService;

/**
 * 
 * 我的购物车Service层
 *
 */
@Service
public class MyShoppingCardServiceImpl implements MyShoppingCardService {
	private Logger logger = Logger.getLogger(MyShoppingCardServiceImpl.class);
	/**我的购物车Dao注入 */
	@Autowired
	private MyShoppingCardDao myShoppingCardDao;
	/**
	 * 查询我的购物车
	 * 
	 * @param creativeResource
	 * @return
	 */
	@Override
	public PageInfo<CreativeResource> selectShCard(CreativeResource creativeResource) throws Exception {
		PageHelper.startPage(creativeResource.getPage(), creativeResource.getPageSize());
		List<CreativeResource> selectShCard = myShoppingCardDao.selectShCard(creativeResource);
		return new PageInfo<CreativeResource>(selectShCard);
	}
	/**
	 * 新增我的购物车
	 * 从详情页面跳转到购物车时分两种情况：
	 * 1.购物车中的ID已经存在则直接更新数量
	 * 2.购物车中的ID不存
	 * 3.如果购物车中的数量超过库存数量时设置为库存数量
	 * @param shoppingCart
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertShCard(ShoppingCart shoppingCart) throws Exception {
		logger.debug("新增我的购物车");
		//获取库存数量
		Integer number = myShoppingCardDao.selectCrResource(shoppingCart.getGoodsId(),shoppingCart.getUserId());
		if(null != number){
			//如果购物车的数量小于库存数量
			if (shoppingCart.getGoodsNumber() < number) {
				// 通过用户ID查询属于该用户的购物车
				Integer countCart = myShoppingCardDao.selectCardId(shoppingCart);
				// 如果购物车中该商品已经存在就增加该商品数量
				if (countCart != 0) {
					myShoppingCardDao.updateShCardAdd(shoppingCart);
				} else {
					// 如果该商品不存在就新增一个
					int count = myShoppingCardDao.insertShCard(shoppingCart);
					if (count == 0) {
						return false;
					}
				}
			}else {
				//如果购买的资源数量超过库存数量就设为库存数
				shoppingCart.setGoodsNumber(number);
				logger.debug("如果购买的资源数量超过库存数量就设为库存数");
				myShoppingCardDao.updateShCard(shoppingCart);
			}
			return true;
		}
		return false;
	}
	/**
	 *删除我的购物车
	 * 
	 * @param shoppingCart
	 * @return
	 */
	@Transactional
	@Override
	public boolean deleteShCard(ShoppingCart shoppingCart) throws Exception {
		logger.debug("删除我的购物车");
		int count = myShoppingCardDao.deleteShCard(shoppingCart.getShoppingCartId());
		if(count != 0){
			return true;
		}
		return false;
	}
	/**
	 *修改购物车的数量和类型
	 * 
	 * @param shoppingCart
	 * @return
	 */
	@Transactional
	@Override
	public boolean updateShCard(ShoppingCart shoppingCart) throws Exception {
		logger.debug("updateShCard");
		int count = myShoppingCardDao.updateShCard(shoppingCart);
		if(count != 0){
			return true;
		}
		return false;
	}
	/**
	 * 查询结算
	 * 
	 * @param creativeResource
	 * @return
	 */
	@Override
	public PageInfo<CreativeResource> selectAccount(CreativeResource creativeResource) throws Exception {
		PageHelper.startPage(creativeResource.getPage(), creativeResource.getPageSize());
		List<CreativeResource> selectAccount = myShoppingCardDao.selectAccount(creativeResource);
		return new PageInfo<CreativeResource>(selectAccount);
	}
	/**
	 * 商品的结算插入一条假数据
	 * 
	 * @param shoppingCart
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertAccount(CeativeResourceTransaction ceativeResourceTransaction) throws Exception {
		logger.debug("商品的结算插入一条假数据");
		int count = myShoppingCardDao.insertAccount(ceativeResourceTransaction);
		if(count != 0){
			return true;
		}
		return false;
	}
	/**
	 *修改购物车的数量
	 * 
	 * @param shoppingCart
	 * @return
	 */
//	@Override
//	public boolean updateShCardAdd(ShoppingCart shoppingCart) throws Exception {
//		int count = myShoppingCardDao.updateShCardAdd(shoppingCart);
//		if(count != 0){
//			return true;
//		}
//		return false;
//	}


	
}
