/**
 * myDealService.java
 * Created at 2016-10-26
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.MyDeal;

/**
 * 我的成交
 * @author guoqiankun
 *
 */
public interface MyDealService {

	/**
	 * 我的成交
	 * 
	 * @param myDeal
	 * @return
	 */
	public PageInfo<MyDeal> selectMyBargain(MyDeal myDeal) throws Exception;
	
	/**
	 * 查询我的成交
	 * 
	 * @param myDeal
	 * @return
	 */
	public PageInfo<MyDeal> selectMyCommunity(MyDeal myDeal) throws Exception;
	/**
	 * 查询详情
	 * 
	 * @param myDeal
	 * @return
	 */
	public MyDeal selectMyDeal(MyDeal myDeal) throws Exception;
	/**
	 * 查询出所有需求类型包含子类型
	 * @param projectRequirement
	 * @return
	 */
	public List<Dictionary> selectAllRequirementType() throws Exception;
}
