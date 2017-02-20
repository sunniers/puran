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
import com.shdatabank.puruan.dao.MyCommunityDao;
import com.shdatabank.puruan.model.MyCommunity;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.MyCommunityService;

/**
 * 
 * 我的圈子Service层
 *
 */
@Service
public class MyCommunityServiceImpl implements MyCommunityService {
	private  Logger  logger = Logger.getLogger(MyCommunityServiceImpl.class);
	/**我的圈子Dao注入 */
	@Autowired
	private MyCommunityDao myCommunityDao;
	/**
	 * 查询我的圈子
	 * 
	 * @param sysResource
	 * @return
	 */
	@Override
	public PageInfo<User> selectMyCommunity(User user) throws Exception{
		PageHelper.startPage(user.getPage(), user.getPageSize());
		List<User> selectMyCommunity = myCommunityDao.selectMyCommunity(user);
		return new PageInfo<User>(selectMyCommunity);
	}
	/**
	 * 新增我的圈子
	 * 
	 * @param sysResource
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertMyCommunity(MyCommunity myCommunity) throws Exception{
		logger.debug("新增我的圈子");
		int count = myCommunityDao.insertMyCommunity(myCommunity);
		if (count != 0) {
			return true;
		}
		return false;
	}
	/**
	 * 删除我的圈子
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional
	@Override
	public boolean deleteMyCommunity(MyCommunity myCommunity) throws Exception{
		logger.debug("删除我的圈子");
		int count = myCommunityDao.deleteMyCommunity(myCommunity.getCommunityId());
		if (count != 0) {
			return true;
		}
		return false;
	}
	/**
	 * 我的圈子详情
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public MyCommunity selectCommunity(MyCommunity myCommunity) throws Exception {
		return myCommunityDao.selectCommunity(myCommunity.getCommunityId());
	}
	/**
	 *加入团队
	 * 
	 * @param projectUserReleation
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertTeam(ProjectUserReleation projectUserReleation) throws Exception {
		logger.debug("加入团队");
		//获取项目需求的ID
		Long projId = projectUserReleation.getProjectRequirements().get(0).getProjId();
		//设置项目需求的ID为项目关系表的项目ID
		projectUserReleation.setProjectRequirementId(projId);
		int count = myCommunityDao.insertTeam(projectUserReleation);
		if (count != 0) {
			return true;
		}
		return false;
	}
	/**
	 * 查询项目名
	 * @param projectRequirement
	 * @return
	 */
	@Override
	public List<ProjectRequirement> selectProjectName(ProjectRequirement projectRequirement) throws Exception {
		int projFlowStatus = projectRequirement.getProjFlowStatus();
		if(projFlowStatus == 400103){
			//将项目需求ID设置为项目项目需求的ID
			List<ProjectRequirement> selectProjectName = myCommunityDao.selectProjectName(projectRequirement);
			return selectProjectName;
		}
		return null;
	}
	
}
