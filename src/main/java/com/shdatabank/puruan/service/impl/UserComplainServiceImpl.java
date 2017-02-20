/**
 * UserComplainServiceImpl.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.UserComplainDao;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserComplain;
import com.shdatabank.puruan.service.UserComplainService;

/**
 * 
 * 投诉举报Service层
 *
 */
@Service
public class UserComplainServiceImpl implements UserComplainService {
	
	/**投诉举报Dao注入 */
	@Autowired
	private UserComplainDao userComplainDao;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 保存投诉举报
	 * 
	 * @param sysResource
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertUserComplain(UserComplain userComplain) throws Exception {
		logger.debug("========================投诉举报信息插入========================");
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return false;
		}
		userComplain.setUserId(user.getUserId());
		int success = userComplainDao.insertUserComplain(userComplain);
		if(0 == success){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 查询投诉举报列表（待处理）
	 * @param userComplain 模糊查询字段
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageInfo<UserComplain> selectAllUserComplain(UserComplain userComplain) throws Exception {
		PageHelper.startPage(userComplain.getPage(), userComplain.getPageSize());
		List<UserComplain> userComplainDaoList = userComplainDao.selectAllUserComplain(userComplain);
		return new PageInfo<UserComplain>(userComplainDaoList);
	}
	/**
	 * 查询投诉举报列表（已处理）
	 * @param userComplain 模糊查询字段
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageInfo<UserComplain> selectAllUserComplainSuc(UserComplain userComplain) throws Exception {
		PageHelper.startPage(userComplain.getPage(), userComplain.getPageSize());
		List<UserComplain> userComplainDaoList = userComplainDao.selectAllUserComplainSuc(userComplain);
		return new PageInfo<UserComplain>(userComplainDaoList);
	}
	/**
	 * 查询投诉举报详情
	 * @param complainId 举报id
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserComplain selectUserComplainDetail(Long complainId) throws Exception {
		return userComplainDao.selectUserComplainDetail(complainId);
	}
	/**
	 * 修改投诉举报状态
	 * @param userComplain 举报实体
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean updatecomplainId(UserComplain userComplain) throws Exception {
		logger.debug("========================修改投诉举报状态========================");
		int success = userComplainDao.updatecomplainId(userComplain);
		if(0 == success){
			return false;
		}else{
			return true;
		}
	}
	
}
