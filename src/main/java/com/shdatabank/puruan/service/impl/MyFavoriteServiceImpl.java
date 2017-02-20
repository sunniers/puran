/**
 * MyFavoriteServiceImpl.java
 * Created at 2016-10-18
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
import com.shdatabank.puruan.dao.MyFavoriteDao;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.MyFavorite;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.model.UserHouse;
import com.shdatabank.puruan.service.MyFavoriteService;

/**
 * 
 * 我的收藏Service层
 *
 */
@Service
public class MyFavoriteServiceImpl implements MyFavoriteService {
	private Logger logger = Logger.getLogger(MyFavoriteServiceImpl.class);
	/**我的收藏Dao注入 */
	@Autowired
	private MyFavoriteDao myFavoriteDao;
	/**
	 * 查询我的收藏所有
	 * 
	 * @param myFavorite
	 * @return
	 */
	@Override
	public PageInfo<MyFavorite> selectMyFavorite(MyFavorite myFavorite) throws Exception {
		//执行分页查询
		PageHelper.startPage(myFavorite.getPage(), myFavorite.getPageSize());
		 List<MyFavorite> selectMyFavorite = myFavoriteDao.selectMyFavorite(myFavorite);
		return new PageInfo<MyFavorite>(selectMyFavorite);
	}
	/**
	 * 插入我的收藏
	 * 
	 * @param myFavorite
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertMyFavorite(UserHouse userHouse) throws Exception {
		logger.debug("插入我的收藏");
		UserHouse selectUserHouse = myFavoriteDao.selectUserHouse(userHouse);
		if(null == selectUserHouse){
			int count = myFavoriteDao.insertUserHouse(userHouse);
			if (0 == count) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 根据条件查询人才需求信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@Override
	public PageInfo<MyFavorite> selectTalentbyName(MyFavorite myFavorite) throws Exception {
		//执行分页查询
		PageHelper.startPage(myFavorite.getPage(), myFavorite.getPageSize());
		 List<MyFavorite> selectMyFavorite = myFavoriteDao.selectTalentbyName(myFavorite);
		return new PageInfo<MyFavorite>(selectMyFavorite);
	}
	/**
	 * 查看人才需求信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@Override
	public TalentRequirement viewTalentbyName(TalentRequirement talentRequirement) throws Exception {
		return myFavoriteDao.viewTalentbyName(talentRequirement);
	}
	/**
	 * 根据条件查询创意人才信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@Override
	public PageInfo<MyFavorite> selectCreativebyName(MyFavorite myFavorite) throws Exception {
		// 执行分页查询
		PageHelper.startPage(myFavorite.getPage(), myFavorite.getPageSize());
		List<MyFavorite> selectMyFavorite = myFavoriteDao.selectCreativebyName(myFavorite);
		return new PageInfo<MyFavorite>(selectMyFavorite);
	}
	/**
	 * 查看创意人才信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@Override
	public UserCreativeTalent viewCreativebyName(UserCreativeTalent userCreativeTalent) throws Exception {
		return myFavoriteDao.viewCreativebyName(userCreativeTalent);
	}
	/**
	 * 根据条件查询创意资源信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@Override
	public PageInfo<MyFavorite> selectResourcebyName(MyFavorite myFavorite) throws Exception {
		// 执行分页查询
		PageHelper.startPage(myFavorite.getPage(), myFavorite.getPageSize());
		List<MyFavorite> selectMyFavorite = myFavoriteDao.selectResourcebyName(myFavorite);
		return new PageInfo<MyFavorite>(selectMyFavorite);
	}

	/**
	 * 查看创意资源信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	@Override
	public CreativeResource viewResourcebyName(CreativeResource creativeResource) throws Exception {
		return myFavoriteDao.viewResourcebyName(creativeResource);
	}
	
	/**
	 * 查询创意人才收藏
	 * @param userHouse 收藏对象
	 * @return 创意人才分页集合
	 */
	@Override
	public PageInfo<UserCreativeTalent> selectCreativeTalentFavorite(UserHouse userHouse) throws Exception {
		PageHelper.startPage(userHouse.getPage(), userHouse.getPageSize());
		List<UserCreativeTalent> userCreativeTalentList = myFavoriteDao.selectCreativeTalentFavorite(userHouse);
		return new PageInfo<UserCreativeTalent>(userCreativeTalentList);
	}
	
	/**
	 * 查询需求收藏
	 * @param userHouse 收藏对象
	 * @return 需求分页集合
	 */
	@Override
	public PageInfo<MyFavorite> selectRequirement(UserHouse userHouse) throws Exception {
		PageHelper.startPage(userHouse.getPage(), userHouse.getPageSize());
		List<MyFavorite> requirementList = myFavoriteDao.selectRequirement(userHouse);
		return new PageInfo<MyFavorite>(requirementList);
	}
	
	/**
	 * 查询创意资源收藏
	 * @param userHouse 收藏对象
	 * @return 结果对象
	 */
	@Override
	public PageInfo<CreativeResource> selectCreativeResource(UserHouse userHouse) throws Exception {
		PageHelper.startPage(userHouse.getPage(), userHouse.getPageSize());
		List<CreativeResource> creativeResourceList = myFavoriteDao.selectCreativeResource(userHouse);
		return new PageInfo<CreativeResource>(creativeResourceList);
	}
	/**
	 * 删除收藏
	 * 
	 * @param userHouse
	 */
	@Transactional
	@Override
	public boolean deleteUserHouse(UserHouse userHouse) throws Exception {
		logger.debug("删除收藏");
		UserHouse selectUserHouse = myFavoriteDao.selectUserHouse(userHouse);
		if(null != selectUserHouse){
			int count = myFavoriteDao.deleteUserHouse(userHouse);
			if (0 == count) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	
}
