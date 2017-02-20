/**
 * UserComplainService.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.UserComplain;

/**
 * 
 * 投诉举报Service接口
 *
 */
public interface UserComplainService {
	/**
	 * 保存投诉举报
	 * @param sysResource
	 * @return
	 */
	public boolean insertUserComplain(UserComplain userComplain) throws Exception;
	/**
	 * 查询投诉举报列表（待处理）
	 * @param userComplain 模糊查询字段
	 * @return
	 * @throws Exception
	 */
	public PageInfo<UserComplain> selectAllUserComplain(UserComplain userComplain)throws Exception;
	/**
	 * 查询投诉举报列表（已处理）
	 * @param userComplain 模糊查询字段
	 * @return
	 * @throws Exception
	 */
	public PageInfo<UserComplain> selectAllUserComplainSuc(UserComplain userComplain)throws Exception;
	/**
	 * 查询投诉举报详情
	 * @param complainId 举报id
	 * @return
	 * @throws Exception
	 */
	public UserComplain selectUserComplainDetail(Long complainId)throws Exception;
	/**
	 * 修改投诉举报状态
	 * @param userComplain 举报实体
	 * @return
	 * @throws Exception
	 */
	public boolean updatecomplainId(UserComplain userComplain)throws Exception;
}
