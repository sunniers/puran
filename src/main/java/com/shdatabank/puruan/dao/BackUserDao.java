/**
 * BackUserDao.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.BackUserRole;

/**
 * 后台用户的增删改查操作dao层
 * 1.添加后台用户信息
 * 2.添加后台用户权限关系
 * 3.查询后台用户的信息
 * 4.检查后台用户的用户名是否重复
 * 5.更新后台用户信息
 * 6.更新后台用户权限映射
 * 7.删除后台用户信息
 * 8.删除后台用户权限映射
 * 9.查询所有部门信息
 * 10.根据条件查询用户的信息
 * 11.根据userId查询用户权限
 * 12.根据roleId查询权限名称
 */
public interface BackUserDao {

	/**
	 * 添加后台用户信息
	 * @param backUser 用户实体类
	 */
	public int insertBackUser(BackUser backUser);
	
	/**
	 * 添加后台用户权限关系
	 * @param userId 用户id
	 * @param roleId 角色id
	 */
	public int insertBackUserRole(List<BackUserRole> backUserRole);
	
	/**
	 * 查询后台用户的信息
	 * @param userId 用户id
	 * @return 返回查询到的后台用户信息
	 */
	public BackUser selectBackUser(Integer userId,Byte active);
	
	/**
	 * 检查后台用户的用户名是否重复
	 * @param userName 用户名
	 * @return 返回用户
	 */
	public Integer selectBackUserName(String userName);
	/**
	 * 查询所有的后台用户信息
	 * @return 返回查询的所有的后台用户信息
	 */
	//public List<BackUser> selectAllBackUser();
	
	/**
	 * 更新后台用户信息
	 * @param backUser 用户实体类
	 */
	public int updateBackUser(BackUser backUser);
	
	/**
	 * 更新后台用户权限映射
	 * @param userId 用户id
	 */
	public int updateBackUserRole(Integer userId);
	
	/**
	 * 删除后台用户信息
	 * @param backUser 用户实体类
	 */
	public int deleteBackUser(Byte active,Integer userId);
	
	/**
	 * 删除后台用户权限映射
	 * @param userId 用户id
	 */
	public int deleteBackUserRole(Integer userId);
	
	/**
	 * 查询所有部门信息
	 * @return 部门名称
	 */
	public List<String> selectAllBackUserDepartment(Byte active);
	
	/**
	 * 根据条件查询用户的信息
	 * @param userName 用户名称
	 * @param userDepartment 部门名称
	 * @return 部门下的用户
	 */
	public List<BackUser> selectAllBackUser(BackUser backUser);
	
	/**
	 * 根据userId查询用户权限
	 * @param userId 用户id
	 * @return 用户的权限id
	 */
	public List<BackUserRole> selectBackUserRole(Integer userId,Byte active);
	
	/**
	 * 根据roleId查询权限名称
	 * @param roleId
	 * @return 权限名称
	 */
	public String selectBackUserRoleName(Integer roleId,Byte active);
}