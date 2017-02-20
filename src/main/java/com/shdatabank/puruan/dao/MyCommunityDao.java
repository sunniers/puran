/**
 * MyCommunityDao.java
 * Created at 2016-10-24
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.MyCommunity;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.User;

/**
 * 我的圈子Dao接口
 *
 */
public interface MyCommunityDao {
	/**
	 * 查询我的圈子
	 * 
	 * @param myCommunity
	 * @return
	 */
	public List<User> selectMyCommunity(User user);
	/**
	 * 新增我的圈子
	 * 
	 * @param myCommunity
	 * @return
	 */
	public int insertMyCommunity(MyCommunity myCommunity);
	/**
	 * 删除我的圈子
	 * 
	 * @param userId
	 * @return
	 */
	public int deleteMyCommunity(Long userId);
	/**
	 * 我的圈子详情
	 * @param userId
	 * @param active
	 * @return
	 */
	public MyCommunity selectCommunity(Long communityId);
	
	/**
	 * 加入团队
	 * @param projectUserReleation
	 * @return
	 */
	public int insertTeam(ProjectUserReleation projectUserReleation);
	/**
	 * 查询项目名
	 * @param projectRequirement
	 * @return
	 */
	public List<ProjectRequirement> selectProjectName(ProjectRequirement projectRequirement);
	
	
}
