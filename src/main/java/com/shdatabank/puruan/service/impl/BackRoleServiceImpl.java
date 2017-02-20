/**
 * BackRoleServiceImpl.java
 * Created at 2016-10-20
 * Created by fuqinwei
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.BackRoleDao;
import com.shdatabank.puruan.model.BackResRole;
import com.shdatabank.puruan.model.BackRole;
import com.shdatabank.puruan.model.SysResource;
import com.shdatabank.puruan.service.BackRoleService;
import com.shdatabank.puruan.util.SystemConstant;

/**
 *后台角色管理service实现类
 */
@Service
public class BackRoleServiceImpl implements BackRoleService {
	/** 后台角色dao对象*/
	@Autowired
	private BackRoleDao backRoleDao;
	
	/**
	 * 新增角色
	 * @param BackRole： 角色
	 * @return 新增是否成功
	 */
	@Override
    public boolean insertBackRole(BackRole backRole) {
		if(null == backRole.getRoleName()){
			return false;
		}
		backRole.setActive(SystemConstant.DELETE_ACTIVE_TRUE);
		int count = backRoleDao.insertBackRole(backRole);
		if(1 <= count && null != backRole.getSysResource()){
			int roleId = backRole.getRoleId();
			List<BackResRole> list = new ArrayList<BackResRole>();
			for(SysResource sysResource : backRole.getSysResource()){
				BackResRole newBackResRole = new BackResRole();
				newBackResRole.setRoleId(roleId);
				newBackResRole.setResId(sysResource.getResourceId());
				list.add(newBackResRole);
			}
			int backRoleCount = backRoleDao.insertBackRoleRes(list);
			if(1 > backRoleCount){
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 查询角色
	 * @param BackRole： 角色对象
	 * @return 分页结果对象
	 */
	@Override
	public PageInfo<BackRole> selectBackRole(BackRole backRole) {
		PageHelper.startPage(backRole.getPage(), backRole.getPageSize());
		backRole.setActive(SystemConstant.DELETE_ACTIVE_TRUE);
        List<BackRole> backRoles = backRoleDao.selectBackRole(backRole);
        return new PageInfo<BackRole>(backRoles);
	}

	/**
	 * 修改角色
	 * @param BackRole： 角色对象
	 * @return 是否更新成功
	 */
	@Override
	public boolean updateBackRole(BackRole backRole) {
		//更新角色名称
		backRoleDao.updateBackRole(backRole);
		//删除角色资源目录关系
		backRoleDao.deleteBackResRole(backRole.getRoleId());
		int roleId = backRole.getRoleId();
		List<BackResRole> list = new ArrayList<BackResRole>();
		for(SysResource sysResource : backRole.getSysResource()){
			BackResRole newBackResRole = new BackResRole();
			newBackResRole.setRoleId(roleId);
			newBackResRole.setResId(sysResource.getResourceId());
			list.add(newBackResRole);
		}
		//插入角色资源目录关系
		int backRoleCount = backRoleDao.insertBackRoleRes(list);
		if(1 > backRoleCount){
			return false;
		}
		return true;
	}

	/**
	 * 删除角色
	 * @param BackRole： 角色对象
	 * @return 是否删除成功
	 */
	@Override
	public boolean deleteBackRole(BackRole backRole) {
		backRoleDao.deleteBackResRole(backRole.getRoleId());
		backRole.setActive(SystemConstant.DELETE_ACTIVE_FALSE);
		int delBackRoleNum = backRoleDao.deleteBackRole(backRole);
		if(0 > delBackRoleNum){
			return false;
		}
		return true;
	}
	
	/**
	 * 根据角色ID查询角色及资源目录关系
	 * @param BackRole： 角色对象
	 * @return 角色对象
	 */
	@Override
	public BackRole selectBackRoleById(BackRole backRole) {
		return backRoleDao.selectBackRoleById(backRole.getRoleId());
	}

}
