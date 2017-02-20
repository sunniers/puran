/**
 * BackUserService.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.BackUser;

/**
 * 后台用户增删改查service层
 * 1.插入后台用户信息
 * 2.查询后台用户信息
 * 3.更新后台用户的信息
 * 4.删除后台用户的信息
 * 5.查询所有部门信息
 * 6.根据条件查询用户的信息
 */
public interface BackUserService {


    /**
     * 插入后台用户信息
     * @param backUser 用户实体类
     * @return 返回插入用户信息是否成功（成功-true;失败-false）
     */
    public boolean insertBackUser(BackUser backUser) throws Exception;
    
    /**
     * 查询后台用户信息
     * @param userId 用户id
     * @return 返回查询的后台用户的信息
     */
    public BackUser selectBackUser(Integer userId) throws Exception;
    
    /**
     * 查询所有后台用户的信息
     * @return 返回查询的所有的后台用户信息
     */
    //public List<BackUser> selectAllBackUser();
    
    /**
     * 更新后台用户的信息
     * @param backUser 用户实体类
     */
    public boolean updateBackUser(BackUser backUser) throws Exception;
    
    /**
     * 删除后台用户的信息
     * @param backUser 用户实体类
     */
    public boolean deleteBackUser(BackUser backUser) throws Exception;
    
    /**
     * 查询所有部门信息
     * @return 部门名称
     */
    public List<String> selectAllBackUserDepartment() throws Exception;
    
    /**
     * 根据条件查询用户的信息
     * @param userName 用户名称
     * @param userDepartment 部门名称
     * @return 部门下的用户
     */
    public PageInfo<BackUser> selectAllBackUser(BackUser backUser) throws Exception;
}
