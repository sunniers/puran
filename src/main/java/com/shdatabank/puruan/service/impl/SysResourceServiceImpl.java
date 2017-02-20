/**
 * SysResourceServiceImpl.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.SysResourceDao;
import com.shdatabank.puruan.model.SysResource;
import com.shdatabank.puruan.model.SysResourcePage;
import com.shdatabank.puruan.service.SysResourceService;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 
 * 项目资源信息Service层
 *
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {
	private Logger logger = Logger.getLogger(SysResourceServiceImpl.class);
	/** 项目资源信息Dao */
	@Autowired
	private SysResourceDao sysResourceDao;

	/**
	 * 插入一级项目资源信息
	 * 
	 * @param SysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@Transactional
	@Override
	public boolean insertSysResource(SysResource sysResource) throws Exception {
		logger.debug("插入一级项目资源信息");
		//获取一级菜单的id
		if(sysResource.getResourceId() == null){
			//插入一级目录
			int count = sysResourceDao.insertSysResource(sysResource);
			if(count == 0){
				return false;
			}
			if (null != sysResource.getSysResources()) {
				List<SysResource> sysResources = sysResource.getSysResources();
				Integer resourceId = sysResource.getResourceId();
				//将一级菜单的ID 放入二级菜单中 然后在新增二级菜单
				for (int i = 0;i < sysResources.size();i++){
					sysResources.get(i).setParentResourceId(resourceId);
					logger.debug("将一级菜单的ID 放入二级菜单中 然后在新增二级菜单");
					int count1 = sysResourceDao.insertChildSysResource(sysResources.get(i));
					if(count1 == 0){
						return false;
					}
				}			
			}
		}else {
			//如果ResourceId不为空时只新增二级目录
			SysResource sysResource2 = sysResourceDao.selectSysResource(sysResource.getResourceId(), SystemConstant.DELETE_ACTIVE_TRUE);
			if(sysResource2 != null){
				sysResource.getSysResources().get(0).setParentResourceId(sysResource.getResourceId());
				logger.debug("将一级菜单的ID 放入二级菜单中 然后在新增二级菜单");
				int count1 = sysResourceDao.insertChildSysResource(sysResource.getSysResources().get((0)));
				if(count1 == 0){
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 查询项目资源信息
	 * 
	 * @param SysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@Override
	public SysResource selectSysResource(Integer resourceId, Byte active) throws Exception {
		SysResource sysResource = sysResourceDao.selectSysResource(resourceId, SystemConstant.DELETE_ACTIVE_TRUE);
		return sysResource;
	}

	/**
	 * 插入项目资源信息
	 * 
	 * @param SysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@Transactional
	@Override
	public boolean updateSysResource(SysResource sysResource) throws Exception {
		logger.debug("插入项目资源信息");
			if(sysResource.getResourceId() != null){
				int count  = sysResourceDao.updateSysResource(sysResource);
				if(count == 0){
					return false;
				}
			}
		//更新一级菜单的id
		if (null != sysResource.getSysResources()) {
			List<SysResource> sysResources = sysResource.getSysResources();
			//Integer resourceId = sysResource.getParentResourceId();
			//将一级菜单的ID 放入二级菜单中 然后在更新二级菜单
			for (int i = 0;i < sysResources.size();i++){
				sysResources.get(i).setParentResourceId(sysResources.get(i).getParentResourceId());
				logger.debug("将一级菜单的ID 放入二级菜单中 然后在更新二级菜单");
				int count1 = sysResourceDao.updateChildResource(sysResources.get(i));
				if(count1 == 0){
					return false;
				}
			}			
		}
		return true;
	}

	/**
	 * 删除目资源信息
	 * 
	 * @param SysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@Transactional
	@Override
	public void deleteSysResource(SysResource sysResource) throws Exception {
		logger.debug("删除目资源信息");
		sysResourceDao.deleteSysResource(sysResource.getResourceId(),SystemConstant.DELETE_ACTIVE_FALSE);
	}

	/**
	 * 根据条件查询项目资源信息
	 * 
	 * @param SysResource
	 *            项目资源信息实体类
	 * @return 返回分页对象
	 */
	@Override
	public PageInfo<SysResource> selectAllSysResource(SysResourcePage sysResourcePage) throws Exception {
		PageHelper.startPage(sysResourcePage.getPage(), sysResourcePage.getPageSize());
		// 获取菜单分页
		List<SysResource> selectPage = sysResourceDao.selectPage(sysResourcePage);
		PageInfo<SysResource> page = new PageInfo<SysResource>(selectPage);
		return page;
	}

	/**
	 * 上传图片路径更新
	 * 
	 * @param sysResource
	 * @return
	 */
	@Transactional
	@Override
	public void updateUpload(SysResource sysResource) throws Exception {
		logger.debug("上传图片路径更新");
		sysResourceDao.updateUpload(sysResource);
	}

	/**
	 * 查询后台资源目录
	 * 
	 * @param sysResource
	 * @throws Exception
	 */
	@Override
	public List<SysResource> selectBackSysResource() throws Exception {
		List<SysResource> sysResources = new ArrayList<SysResource>();
		//获取菜单的目录
		sysResources = sysResourceDao.selectBackSysResource();
		// 默认为存在
		return sysResources;
	}
	/**
	 * 查询一级目录
	 * 
	 * @param sysResource
	 */
	@Override
	public List<SysResource> selectFirstResource(SysResource sysResource) throws Exception {
		return sysResourceDao.selectFirstResource(sysResource);
	}
	
	/**
	 * 查询一级还是二级目录
	 * 
	 * @param sysResource
	 */
	@SuppressWarnings("unused")
	@Override
	public SysResource selectFirstAndSecondResource(Integer resourceId) throws Exception {
		List<SysResource> secondResource = new ArrayList<SysResource>();
		//将查询出来的一级目录放到集合中
		secondResource.add(sysResourceDao.selectFirstAndSecondResource(resourceId));
		if(secondResource != null){
			//只有一级目录
			if(secondResource.get(0).getParentResourceId() == null){
				return secondResource.get(0);
			}else{
				//有二级目录
				SysResource firRes=	sysResourceDao.selectFirstAndSecondResource(secondResource.get(0).getParentResourceId());//得到相应的一级目录对象
				//将二级目录放到一级目录中
				firRes.setSysResources(secondResource);
				return firRes;
			}
		}
		return null;
	}

}
