/**
 * BackUser.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * 用户的实体类：用来保存用户的查询结果。
 */
public class BackUser{

    /** 用户ID：唯一标识 */
    private Integer userId;
    
    /** 用户昵称 */
    private String userAlias;
    
    /** 用户名 */
    private String userName;
    
    /** 用户密码 */
    private String userPwd;
    
    /** 用户部门 */
    private String userDepartment;
    
    /** 用户手机号 */
    private String userMobile;
    
    /** 用户Email */
    private String userEmail; 
    
    /** 用户注册时间 */
    private Timestamp createDatetime;

    /** 删除标准 */
    private Byte active;
    
    /** 用户权限 */
    private List<BackUserRole> backUserRoles;
    
    private String backAllUserRoles;
    
    /** 用户注册时间映射 */
    private String createDatetimeMapping;
    
    /** 新密码 */
    private String newBackUserPwd;
    
    /** page */
    private int page;
    
    /** pageSize */
    private int pageSize;
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getNewBackUserPwd() {
        return newBackUserPwd;
    }

    public void setNewBackUserPwd(String newBackUserPwd) {
        this.newBackUserPwd = newBackUserPwd;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public List<BackUserRole> getBackUserRoles() {
        return backUserRoles;
    }

    public void setBackUserRoles(List<BackUserRole> backUserRoles) {
        this.backUserRoles = backUserRoles;
    }

    public String getBackAllUserRoles() {
        return backAllUserRoles;
    }

    public void setBackAllUserRoles(String backAllUserRoles) {
        this.backAllUserRoles = backAllUserRoles;
    }

    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getCreateDatetimeMapping() {
        return createDatetimeMapping;
    }

    public void setCreateDatetimeMapping(String createDatetimeMapping) {
        this.createDatetimeMapping = createDatetimeMapping;
    }
 
}
