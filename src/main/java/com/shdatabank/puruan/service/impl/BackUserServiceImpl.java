/**
 * BackUserServiceImpl.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.BackUserDao;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.service.BackUserService;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 后台用户增删改查service层
 * 1.插入后台用户信息
 * 2.查询后台用户信息
 * 3.更新后台用户的信息
 * 4.删除后台用户的信息
 * 5.查询所有部门信息
 * 6.根据条件查询用户的信息
 */
@Service
public class BackUserServiceImpl implements BackUserService {

    private Logger logger =Logger.getLogger(BackUserServiceImpl.class);
    
    /** 后台用户增删改查dao */
    @Autowired
    private BackUserDao backUserDao;
    
    /**
     * 插入后台用户信息
     * @param backUser 用户实体类
     * @return 返回插入用户信息是否成功（成功-true;失败-false）
     */
    @Transactional
    @Override
    public boolean insertBackUser(BackUser backUser) throws Exception {
        logger.debug("插入后台用户信息");
        //先判断是否已经存在该用户名
        if (0 != backUserDao.selectBackUserName(backUser.getUserName())) {
            return false;
        }
        
        //加密密码
        backUser.setUserPwd(UserUtil.stringMD5(backUser.getUserPwd()));
        //backUser.setUserPwd(UserUtil.convertMD5(backUser.getUserPwd()));
        //将后台用户信息放到数据库
        int count = backUserDao.insertBackUser(backUser);
        //判断是否插入成功
        if (0 == count) {
            return false;
        }
        if (null != backUser.getBackUserRoles()) {
            //将用户id和权限id存入数据库用户权限映射表中
            for (int i = 0; i < backUser.getBackUserRoles().size(); i++) {
                backUser.getBackUserRoles().get(i).setUserId(backUser.getUserId());
            }
            count = backUserDao.insertBackUserRole(backUser.getBackUserRoles());
            //判断是否插入成功
            if (0 == count) {
                return false;
            }
        }
        return true;
    }

    /**
     * 查询后台用户信息
     * @param backUser 用户实体类
     * @return 返回查询的后台用户的信息
     */
    @Override
    public BackUser selectBackUser(Integer userId) throws Exception {
        BackUser backUser = backUserDao.selectBackUser(userId,SystemConstant.DELETE_ACTIVE_TRUE);
        //根据用户id查询权限信息
        backUser.setBackUserRoles(backUserDao.selectBackUserRole(backUser.getUserId(),SystemConstant.DELETE_ACTIVE_TRUE));
        return backUser;
    }

    /**
     * 更新后台用户的信息
     * @param backUser 用户实体类
     */
    @Transactional
    @Override
    public boolean updateBackUser(BackUser backUser) throws Exception {
        logger.debug("更新后台用户的信息");
        //删除用户权限映射表中的用户权限
        int count = backUserDao.updateBackUserRole(backUser.getUserId());
        
        //加密密码
        //backUser.setUserPwd(UserUtil.stringMD5(backUser.getUserPwd()));
        count = backUserDao.updateBackUser(backUser);
        
        if (0 == count) {
            return false;
        }
        //将用户id和权限id存入数据库用户权限映射表中
        if (null != backUser.getBackUserRoles()) {
            //将用户id和权限id存入数据库用户权限映射表中
            for (int i = 0; i < backUser.getBackUserRoles().size(); i++) {
                backUser.getBackUserRoles().get(i).setUserId(backUser.getUserId());
            }
            count = backUserDao.insertBackUserRole(backUser.getBackUserRoles());
            //判断是否插入成功
            if (0 == count) {
                return false;
            }
        }
        return true;
    }

    /**
     * 删除后台用户的信息
     * @param backUser 用户实体类
     * @return 返回删除用户信息是否成功（成功-true;失败-false）
     */
    @Transactional
    @Override
    public boolean deleteBackUser(BackUser backUser) throws Exception {
        logger.debug("删除后台用户的信息");
        //删除用户
        int count = backUserDao.deleteBackUser(SystemConstant.DELETE_ACTIVE_FALSE,backUser.getUserId());
        if (0 == count) {
            return false;
        }
        //删除用户权限映射
        count = backUserDao.deleteBackUserRole(backUser.getUserId());
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 查询所有后台用户的信息
     * @return 返回查询的所有的后台用户信息
     */
/*    @Override
    public List<BackUser> selectAllBackUser(){
        List<BackUser> backUsers = backUserDao.selectAllBackUser();
        for(int i = 0;i < backUsers.size();i++){
            //将日期类型转换成字符串类型后再保存到字符串映射中
            if(backUsers.get(i).getRegisterDatetime()!=null){
                backUsers.get(i).setRegisterDatetimeMapping(new UserUtil().dateConversionString(
                        backUsers.get(i).getRegisterDatetime()));                
            }
            //根据用户id查询权限id
            backUsers.get(i).setRoles(backUserDao.selectBackUserRole(backUsers.get(i).getUserId()));
            //根据权限id查询权限名称
            List<String> roleNames = new ArrayList<String>();
            for(int j = 0;j < backUsers.get(i).getRoles().size();j++ ){
                roleNames.add(backUserDao.selectBackUserRoleName(backUsers.get(i).getRoles().get(j)));
            }
            backUsers.get(i).setRoleNames(roleNames);
        }
        return backUsers; 
    }*/

    /**
     * 查询所有部门信息
     * @return 部门名称
     */
    @Override
    public List<String> selectAllBackUserDepartment() throws Exception {
        return backUserDao.selectAllBackUserDepartment(SystemConstant.DELETE_ACTIVE_TRUE);
    }

    /**
     * 根据条件查询用户的信息
     * @param userName 用户名称
     * @param userDepartment 部门名称
     * @return 用户
     */
    @Override
    public PageInfo<BackUser> selectAllBackUser(BackUser backUser) throws Exception {
        PageHelper.startPage(backUser.getPage(), backUser.getPageSize());
        if ("null".equals(backUser.getUserAlias())) {
            backUser.setUserAlias(null);
        }
        backUser.setActive(SystemConstant.DELETE_ACTIVE_TRUE);
        List<BackUser> backUsers = backUserDao.selectAllBackUser(backUser);
        System.out.println();
        return new PageInfo<BackUser>(backUsers);
    }
    
}
