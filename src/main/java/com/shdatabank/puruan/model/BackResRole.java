/**
 * BackResRole.java
 * Created at 2016-10-20
 * Created by fuqinwei
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

/**
 *角色资源目录关系对象
 */
public class BackResRole {
	/** 资源目录ID*/
	private int resId;
	/** 角色ID*/
	private int roleId;
    
    public void setResId(int resId)
    {
    	this.resId = resId;
    }
    public int getResId()
    {
    	return resId;
    } 
    
    public void setRoleId(int roleId)
    {
    	this.roleId = roleId;
    }
    public int getRoleId()
    {
    	return roleId;
    }   
}
