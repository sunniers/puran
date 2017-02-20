/**
 * myDealServiceImpl.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.CreativeResourceDao;
import com.shdatabank.puruan.dao.IDetailedInformationDao;
import com.shdatabank.puruan.dao.MyDealDao;
import com.shdatabank.puruan.model.CreativeResourceFront;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.MyDeal;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.service.MyDealService;

/**
 * 
 * 我的成交Service层
 *
 */
@Service
public class MyDealServiceImpl implements MyDealService {
	private Logger logger = Logger.getLogger(MyDealServiceImpl.class);
	/**我的成交Dao注入 */
	@Autowired
	private MyDealDao myDealDao;
	/**各种详细信息dao层*/
	@Autowired
	private IDetailedInformationDao iDetailedInformationDao;
	/**创意资源发布Dao接口*/
	@Autowired
	private CreativeResourceDao creativeResourceDao;
	/**
	 * 我的成交
	 * 
	 * @param projectRequirementUndertake
	 * @return
	 */
	@Override
	public PageInfo<MyDeal> selectMyBargain(MyDeal myDeal) throws Exception {
		//执行分页查询
		PageHelper.startPage(myDeal.getPage(), myDeal.getPageSize());
		 List<MyDeal> selectMyBargain = myDealDao.selectMyBargain(myDeal);
		return new PageInfo<MyDeal>(selectMyBargain);
	}
	/**
	 * 查询我的成交
	 * 
	 * @param projectRequirementUndertake
	 * @return
	 */
	@Override
	public PageInfo<MyDeal> selectMyCommunity(MyDeal myDeal) throws Exception {
		//执行分页查询
		PageHelper.startPage(myDeal.getPage(), myDeal.getPageSize());
		List<MyDeal> selectMyCommunity = myDealDao.selectMyCommunity(myDeal);
		return new PageInfo<MyDeal>(selectMyCommunity);
	}
	/**
	 * 查询详情
	 * 
	 * @param myDeal
	 * @return
	 */
	@Override
	public MyDeal selectMyDeal(MyDeal myDeal) throws Exception {
		Integer sign = myDeal.getSign();
		switch(sign){
		case 800001:
			ProjectRequirement projectRequirement1 = myDealDao.selectDemand(myDeal);
			if(null != projectRequirement1){
				projectRequirement1.setProjId(myDeal.getId());
				ProjectRequirement projectRequirement =iDetailedInformationDao.selectProjectRequirement(projectRequirement1);
				myDeal.setProjectRequirement(projectRequirement);
			}
			break;
		case 800002:
			TalentRequirement selectRecruit = myDealDao.selectRecruit(myDeal);
			if(null != selectRecruit){
				selectRecruit.setTalentRequirementId(myDeal.getId());
				TalentRequirement selectTalentRequirement = iDetailedInformationDao.selectTalentRequirement(selectRecruit);
				myDeal.setTalentRequirement(selectTalentRequirement);
			}
			break;
		case 800003:
//			CreativeResource selectSell = myDealDao.selectSell(myDeal);
//			if(null != selectSell){
				//selectSell.setCreativeResourceId(myDeal.getId());
				CreativeResourceFront selectCreativeResourceFront = creativeResourceDao.selectCreativeResourceFront(myDeal.getId());
				myDeal.setCreativeResourceFront(selectCreativeResourceFront);
//			}
			break;
		case 800004:
//			TalentTransaction selectTalents = myDealDao.selectTalents(myDeal);
//			if(null != selectTalents){
//				selectTalents.setTransactionId(myDeal.getId());
				UserCreativeTalent selectUserCreativeTalent = iDetailedInformationDao.selectUserCreativeTalent(myDeal.getId());
				myDeal.setUserCreativeTalent(selectUserCreativeTalent);
//			}
			break;
		case 800005:
//			CeativeResourceTransaction selectBuy = myDealDao.selectBuy(myDeal);
//			if(null != selectBuy){
				CreativeResourceFront selectCreativeResourceFront1 = creativeResourceDao.selectCreativeResourceFront(myDeal.getId());
				myDeal.setCreativeResourceFront(selectCreativeResourceFront1);
//			}
			break;
/*		case 800006:
			 ProjectRequirementUndertake selectPrTalents = myDealDao.selectPrTalents(myDeal);
			 if(null != selectPrTalents){
					selectTalents.setTransactionId(myDeal.getId());
					UserCreativeTalent selectUserCreativeTalent1 = iDetailedInformationDao.selectUserCreativeTalent(myDeal.getId());
					myDeal.setUserCreativeTalent(selectUserCreativeTalent1);
				}
			break;*/
		default:
			break;
		}
		return myDeal;
	}
	/**
	 * 查询出所有需求类型包含子类型
	 * @param projectRequirement
	 * @return
	 */
	@Override
	public List<Dictionary> selectAllRequirementType() throws Exception {
		return myDealDao.selectAllRequirementType();
	}
	
}
