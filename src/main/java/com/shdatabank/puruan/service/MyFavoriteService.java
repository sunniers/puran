/**
 * MyFavoriteService.java
 * Created at 2016-10-26
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.MyFavorite;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.model.UserHouse;

/**
 * @author guoqiankun
 *
 */
public interface MyFavoriteService {

	/**
	 * 根据条件查询人才需求信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	public PageInfo<MyFavorite> selectTalentbyName(MyFavorite myFavorite) throws Exception;

	/**
	 * 查看人才需求信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	public TalentRequirement viewTalentbyName(TalentRequirement talentRequirement) throws Exception;

	/**
	 * 根据条件查询创意人才信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	public PageInfo<MyFavorite> selectCreativebyName(MyFavorite myFavorite) throws Exception;

	/**
	 * 查看创意人才信息
	 * 
	 * @param userCreativeTalent
	 * @return
	 */
	public UserCreativeTalent viewCreativebyName(UserCreativeTalent userCreativeTalent) throws Exception;

	/**
	 * 根据条件查询创意资源信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	public PageInfo<MyFavorite> selectResourcebyName(MyFavorite myFavorite) throws Exception;

	/**
	 * 查看创意资源信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	public CreativeResource viewResourcebyName(CreativeResource creativeResource) throws Exception;

	/**
	 * 查询我的收藏
	 * 
	 * @param myFavorite
	 * @return
	 */
	public PageInfo<MyFavorite> selectMyFavorite(MyFavorite myFavorite) throws Exception;

	/**
	 * 插入我的收藏
	 * 
	 * @param userHouse
	 * @return
	 */
	public boolean insertMyFavorite(UserHouse userHouse) throws Exception;

	/**
	 * 查询创意人才收藏
	 * @param userHouse 收藏对象
	 * @return 创意人才分页集合
	 */
	public PageInfo<UserCreativeTalent> selectCreativeTalentFavorite(UserHouse userHouse) throws Exception;
	
	/**
	 * 查询需求收藏
	 * @param userHouse 收藏对象
	 * @return 需求分页集合
	 */
	public PageInfo<MyFavorite> selectRequirement(UserHouse userHouse) throws Exception;

	/**
	 * 查询创意资源收藏
	 * @param userHouse 收藏对象
	 * @return 结果对象
	 */
	public PageInfo<CreativeResource> selectCreativeResource(UserHouse userHouse) throws Exception;
	/**
	 * 删除收藏
	 * 
	 * @param userHouse
	 */
	public boolean deleteUserHouse(UserHouse userHouse) throws Exception;
}
