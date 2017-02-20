/**
 * myDealDao.java
 * Created at 2016-10-26
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;


import java.util.List;

import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.MyDeal;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementUndertake;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.TalentTransaction;

/**
 * 我的成交Dao接口
 *
 */
public interface MyDealDao {
	/**
	 * 我的成交
	 * 
	 * @param myDeal
	 * @return
	 */
	public List<MyDeal> selectMyBargain (MyDeal myDeal) throws Exception;
	/**
	 * 查询我的成交
	 * 
	 * @param myDeal
	 * @return
	 */
	public List<MyDeal> selectMyCommunity (MyDeal myDeal) throws Exception;
	/**
	 * 项目需求
	 * @param projectRequirement
	 * @return
	 * @throws Exception
	 */
	public ProjectRequirement selectDemand (MyDeal myDeal) throws Exception;
	/**
	 * 招募
	 * @param talentRequirement
	 * @return
	 * @throws Exception
	 */
	public TalentRequirement selectRecruit (MyDeal myDeal) throws Exception;
	/**
	 * 出售
	 * @param creativeResource
	 * @return
	 * @throws Exception
	 */
	public CreativeResource selectSell (MyDeal myDeal) throws Exception;
	/**
	 * 人才
	 * @param projectRequirement
	 * @return
	 * @throws Exception
	 */
	public TalentTransaction selectTalents (MyDeal myDeal) throws Exception;
	/**
	 * 承接人才
	 * @param projectRequirement
	 * @return
	 * @throws Exception
	 */
	//public ProjectRequirementUndertake selectPrTalents (MyDeal myDeal) throws Exception;
	/**
	 * 购买
	 * @param ceativeResourceTransaction
	 * @return
	 * @throws Exception
	 */
	public CeativeResourceTransaction selectBuy (MyDeal myDeal) throws Exception;
	/**
	 * 查询出所有需求类型包含子类型
	 * @param projectRequirement
	 * @return
	 */
	public List<Dictionary> selectAllRequirementType();
	

}