/**
 * SysResourceService.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.SysResource;
import com.shdatabank.puruan.model.SysResourcePage;

/**
 * 
 * 项目资源信息Service接口
 *
 */
public interface SysResourceService {
	/**
	 * 插入资源目录的一级目录信息
	 * 
	 * @param sysResource
	 * @return
	 */
	public boolean insertSysResource(SysResource sysResource) throws Exception;

	/**
	 * 更新项目资源信息
	 * 
	 * @param sysResource
	 * @return 返回结果对象
	 */
	public boolean updateSysResource(SysResource sysResource) throws Exception;

	/**
	 * 查询项目资源信息
	 * 
	 * @param resourceId
	 * @param active
	 * @return 返回结果对象
	 */
	public SysResource selectSysResource(Integer resourceId, Byte active) throws Exception;

	/**
	 * 删除项目资源信息
	 * 
	 * @param sysResource
	 * @return 返回结果对象
	 */
	public void deleteSysResource(SysResource sysResource) throws Exception;

	/**
	 * 根据条件查询项目资源信息
	 * 
	 * @param sysResource
	 * @return 返回结果对象
	 */
	public PageInfo<SysResource> selectAllSysResource(SysResourcePage sysResourcePage) throws Exception;

	/**
	 * 上传图片路径更新
	 * 
	 * @param sysResource
	 * @return
	 */
	public void updateUpload(SysResource sysResource) throws Exception;

	/**
	 * 查询后台资源目录
	 * 
	 * @param sysResource
	 * @throws Exception
	 */
	public List<SysResource> selectBackSysResource() throws Exception;
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SysResource> selectFirstResource(SysResource sysResource) throws Exception;
	/**
	 * 查询一级还是二级目录
	 * 
	 * @param sysResource
	 */
	public SysResource selectFirstAndSecondResource(Integer resourceId) throws Exception;

}
