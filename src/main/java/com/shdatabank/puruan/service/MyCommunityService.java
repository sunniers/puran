/**
 * MyCommunityService.java
 * Created at 2016-10-24
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.MyCommunity;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.User;

/**
 * 
 * 我的圈子Service接口
 *
 */
public interface MyCommunityService {
	/**
	 * 查询我的圈子
	 * 
	 * @param myCommunity
	 * @return
	 */
	public PageInfo<User> selectMyCommunity(User user) throws Exception;
	/**
	 * 新增我的圈子
	 * 
	 * @param myCommunity
	 * @return
	 */
	public boolean insertMyCommunity(MyCommunity myCommunity) throws Exception; 
	/**
	 * 删除我的圈子
	 * 
	 * @param userId
	 * @return
	 */
	public boolean deleteMyCommunity(MyCommunity myCommunity) throws Exception;
	/**
	 * 查询我的圈子信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public MyCommunity selectCommunity(MyCommunity myCommunity) throws Exception;
	/**
	 *加入团队
	 * 
	 * @param projectUserReleation
	 * @return
	 */
	public boolean insertTeam(ProjectUserReleation projectUserReleation) throws Exception; 
	/**
	 * 查询项目名
	 * @param projectUserReleation
	 * @return
	 */
	public List<ProjectRequirement> selectProjectName(ProjectRequirement projectRequirement) throws Exception; 
}
