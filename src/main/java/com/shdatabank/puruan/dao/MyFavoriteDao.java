/**
 * MyFavoriteDao.java
 * Created at 2016-10-26
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;


import java.util.List;

import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.MyFavorite;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.model.UserHouse;

/**
 * 我的成交Dao接口
 *
 */
public interface MyFavoriteDao {
	/**
	 * 根据条件查询人才需求信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	public List<MyFavorite> selectTalentbyName (MyFavorite myFavorite) throws Exception;
	/**
	 * 查看人才需求信息
	 * 
	 * @param talentRequirement
	 * @return
	 */
	public TalentRequirement viewTalentbyName (TalentRequirement talentRequirement) throws Exception;
	/**
	 * 根据条件查询创意人才信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	public List<MyFavorite> selectCreativebyName (MyFavorite myFavorite) throws Exception;
	/**
	 * 查看创意人才信息
	 * 
	 * @param userCreativeTalent
	 * @return
	 */
	public UserCreativeTalent viewCreativebyName (UserCreativeTalent userCreativeTalent) throws Exception;
	/**
	 * 根据条件查询创意资源信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	public List<MyFavorite> selectResourcebyName (MyFavorite myFavorite) throws Exception;
	/**
	 * 查看创意资源信息
	 * 
	 * @param myFavorite
	 * @return
	 */
	public CreativeResource viewResourcebyName (CreativeResource creativeResource) throws Exception;
	
	/**
	 * 我的收藏
	 * 
	 * @param myFavorite
	 * @return
	 */
	public List<MyFavorite> selectMyFavorite (MyFavorite myFavorite) throws Exception;
	/**
	 * 插入我的收藏
	 * 
	 * @param userHouse
	 * @return
	 */
	public int insertUserHouse (UserHouse userHouse) throws Exception;
	
	/**
	 * 查询创意人才收藏
	 * @param userHouse 创意人才收藏对象
	 * @return 创意人才分页集合
	 */
	public List<UserCreativeTalent> selectCreativeTalentFavorite(UserHouse userHouse) throws Exception;
	
	/**
	 * 查询需求收藏
	 * @param userHouse 收藏对象
	 * @return 需求分页集合
	 */
	public List<MyFavorite> selectRequirement(UserHouse userHouse) throws Exception;
	
	/**
	 * 查询创意资源收藏
	 * @param userHouse 收藏对象
	 * @return 结果对象
	 */
	public List<CreativeResource> selectCreativeResource(UserHouse userHouse) throws Exception;
	/**
	 * 查询收藏
	 * 
	 * @param userHouse
	 * @return
	 */
	public UserHouse selectUserHouse (UserHouse userHouse) throws Exception;
	/**
	 * 删除收藏
	 * 
	 * @param userHouse
	 * @return
	 */
	public int deleteUserHouse (UserHouse userHouse) throws Exception;
	/**
	 * 新增后再收藏
	 * 
	 * @param userHouse
	 * @return
	 */
	public int updateUserHouse (UserHouse userHouse) throws Exception;

}