/**
 * BackUser.java
 * Created at 2016-10-23
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

/**
 * 后台用户角色映射
 */
public class BackUserRole {

    /** 用户角色id */
    private Integer userRoleId;
    
    /** 用户id */
    private Integer userId;
    
    /** 角色id */
    private Integer roleId;
    
    /** 删除标志 */
    private Byte active;
    
    /** 角色名称 */
    private String roleName;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
}
