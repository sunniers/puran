/**
 * MyShoppingCardService.java
 * Created at 2016-10-26
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;



import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.ShoppingCart;

/**
 * @author guoqiankun
 *
 */
public interface MyShoppingCardService {
	
	/**
	 * 查询我的购物车
	 * 
	 * @param creativeResource
	 * @return
	 */
	public PageInfo<CreativeResource> selectShCard(CreativeResource creativeResource) throws Exception;
	/**
	 * 新增我的购物车
	 * 
	 * @param shoppingCart
	 * @return
	 */
	public boolean insertShCard(ShoppingCart shoppingCart) throws Exception;
	/**
	 *删除我的购物车
	 * 
	 * @param shoppingCart
	 * @return
	 */
	public boolean deleteShCard(ShoppingCart shoppingCart) throws Exception;
	/**
	 *修改购物车的数量和类型
	 * 
	 * @param shoppingCart
	 * @return
	 */
	public boolean updateShCard(ShoppingCart shoppingCart) throws Exception;
	/**
	 *修改购物车的数量
	 * 
	 * @param shoppingCart
	 * @return
	 */
	//public boolean updateShCardAdd(ShoppingCart shoppingCart) throws Exception;
	
	/**
	 * 查询结算
	 * 
	 * @param creativeResource
	 * @return
	 */
	public PageInfo<CreativeResource> selectAccount(CreativeResource creativeResource) throws Exception;
	/**
	 * 商品的结算
	 * 
	 * @param shoppingCart
	 * @return
	 */
	public boolean insertAccount(CeativeResourceTransaction ceativeResourceTransaction) throws Exception;
}
