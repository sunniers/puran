/**
 * BackRoleDao.java
 * Created at 2016-10-20
 * Created by fuqinwei
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.BackResRole;
import com.shdatabank.puruan.model.BackRole;

/**
 * 后台角色管理dao层
 */
public interface BackRoleDao {
	
	/**
	 * 新增角色
	 * @param BackRole： 角色
	 * @return 新增记录数
	 */
	public int insertBackRole(BackRole newRole);
	
	/**
	 * 新增角色资源目录
	 * @param BackRole： 角色
	 * @return 新增记录数
	 */
	public int insertBackRoleRes(List<BackResRole> resRole);
	
	/**
	 * 修改角色
	 * @param BackRole： 角色对象
	 * @return 更新记录数
	 */	
	public int updateBackRole(BackRole backRole);
	
	/**
	 * 查询角色
	 * @param BackRole： 角色对象
	 * @return 结果对象集合
	 */
	public List<BackRole> selectBackRole(BackRole backRole);
	
	/**
	 * 根据ID查询角色
	 * @param BackRole： 角色对象
	 * @return 后台角色对象
	 */
	public BackRole selectBackRoleById(int roleId);
	
	/**
	 * 删除角色
	 * @param BackRole： 角色对象
	 * @return 删除记录数
	 */
	public int deleteBackRole(BackRole backRole);
	
	/**
	 * 删除角色资源目录关系
	 * @param BackRole： 角色ID
	 */
	public void deleteBackResRole(int roleId);
}
