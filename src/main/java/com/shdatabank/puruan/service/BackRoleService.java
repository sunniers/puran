/**
 * BackRoleService.java
 * Created at 2016-10-20
 * Created by fuqinwei
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.BackRole;

/**
 * 后台角色service层
 */
public interface BackRoleService {
	/**
	 * 查询角色
	 * @param BackRole 角色
	 * @return 分页结果
	 */
	public PageInfo<BackRole> selectBackRole(BackRole backRole);
	/**
	 * 根据角色ID查询角色
	 * @param BackRole 角色
	 * @return 角色对象
	 */
	public BackRole selectBackRoleById(BackRole backRole);
	
	/**
	 * 修改角色
	 * @param BackRole 角色
	 * @return 是否修改成功
	 */
	public boolean updateBackRole(BackRole backRole);
	
	/**
	 * 删除角色
	 * @param role 角色
	 * @return 结果对象
	 */
	public boolean deleteBackRole(BackRole backRole);
	
	/**
	 * 新增角色
	 * @param BackRole 角色
	 * @return 是否新增成功
	 */
	boolean insertBackRole(BackRole newRole);
}
