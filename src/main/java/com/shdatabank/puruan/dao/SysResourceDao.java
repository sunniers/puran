/**
 * SysResourceDao.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.SysResource;
import com.shdatabank.puruan.model.SysResourcePage;

/**
 * 项目资源信息Dao接口
 *
 */
public interface SysResourceDao {
	/**
	 * 插入资源目录的一级目录信息
	 * 
	 * @param sysResource
	 * @return
	 */
	public int insertSysResource(SysResource sysResource) throws Exception;
	/**
	 * 插入资源目录的二级目录信息
	 * 
	 * @param sysResource
	 * @return
	 */
	public int insertChildSysResource(SysResource sysResource) throws Exception;

	/**
	 * 修改一级目录
	 * 
	 * @param sysResource
	 * @return
	 */
	public int updateSysResource(SysResource sysResource) throws Exception;
	/**
	 * 修改二级目录
	 * 
	 * @param sysResource
	 * @return
	 */
	public int updateChildResource(SysResource sysResource) throws Exception;

	/**
	 * 查询项目资源信息
	 * 
	 * @param sysResource
	 */
	public SysResource selectSysResource(Integer resourceId, Byte active) throws Exception;

	/**
	 * 删除项目资源信息
	 * 
	 * @param sysResource
	 * @return
	 */
	public void deleteSysResource(Integer resourceId,Byte active) throws Exception;

	/**
	 * 根据条件查询项目资源信息s
	 * 
	 * @param userName
	 *            用户名称
	 * @param userDepartment
	 *            部门名称
	 * @return 部门下的用户
	 */
	//public List<SysResource> selectAllSysResource(SysResource sysResource) throws Exception;
	/**
	 * 上传图片路径更新
	 * @param sysResource
	 * @return
	 */
	public void updateUpload(SysResource sysResource)  throws Exception;
	
	/**
	 * 查询一级菜单
	 * 
	 * @param sysResource
	 */
	public List<SysResource> selectFirstMenu(SysResource sysResource) throws Exception;
	/**
	 * 查询后 资源目录
	 * 
	 * @param sysResource
	 */
	public List<SysResource> selectBackSysResource() throws Exception;
	/**
	 * 查询分页
	 * 
	 * @param sysResource
	 */
	public List<SysResource> selectPage(SysResourcePage sysResourcePage) throws Exception;
	/**
	 * 查询一级目录
	 * 
	 * @param sysResource
	 */
	public List<SysResource> selectFirstResource(SysResource sysResource) throws Exception;
	/**
	 * 查询一级还是二级目录
	 * 
	 * @param sysResource
	 */
	public SysResource selectFirstAndSecondResource(Integer resourceId) throws Exception;

}