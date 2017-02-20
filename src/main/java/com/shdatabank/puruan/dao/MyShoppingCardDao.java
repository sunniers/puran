/**
 * MyCommunityDao.java
 * Created at 2016-10-24
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.ShoppingCart;

/**
 * 我的购物车Dao接口
 *
 */
public interface MyShoppingCardDao {
	/**
	 * 查询我的购物车
	 * 
	 * @param creativeResource
	 * @return
	 */
	public List<CreativeResource> selectShCard(CreativeResource creativeResource) throws Exception;
	/**
	 * 根据购物车中ID查询出库存数量
	 * 
	 * @param creativeResource
	 * @return
	 */ 								
	public Integer selectCrResource(@Param(value="goodsId") Long goodsId,@Param(value="userId")Long userId) throws Exception;
	/**
	 *查询购物车中ID是否已经存在
	 * 
	 * @param creativeResourceId
	 * @return
	 */
	public Integer selectCardId(ShoppingCart shoppingCart) throws Exception;
	/**
	 * 新增我的购物车
	 * 
	 * @param shoppingCart
	 * @return
	 */
	public int insertShCard(ShoppingCart shoppingCart) throws Exception;
	/**
	 *删除我的购物车
	 * 
	 * @param shoppingCartId
	 * @return
	 */
	public int deleteShCard(Long shoppingCartId) throws Exception;
	/**
	 *修改购物车的数量和类型
	 * 
	 * @param shoppingCart
	 * @return
	 */
	public int updateShCard(ShoppingCart shoppingCart) throws Exception;
	/**
	 * 增加购物车数量
	 * @param shoppingCart
	 * @return
	 */
	public int updateShCardAdd(ShoppingCart shoppingCart);
	/**
	 * 查询结算
	 * 
	 * @param creativeResource
	 * @return
	 */
	public List<CreativeResource> selectAccount(CreativeResource creativeResource) throws Exception;
	/**
	 * 商品的结算
	 * 
	 * @param shoppingCart
	 * @return
	 */
	public int insertAccount(CeativeResourceTransaction ceativeResourceTransaction) throws Exception;
}
