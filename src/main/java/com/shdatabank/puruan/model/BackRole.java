/**
 * BackRole.java
 * Created at 2016-10-20
 * Created by fuqinwei
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * 后台角色实体类
 */
public class BackRole {
	
	/** 角色ID*/
	private int roleId;
	
	/** 角色名称*/
	private String roleName;
	
	/** 角色资源目录关系对象列表*/
	private List<SysResource> sysResource;
	
	/** 角色删除标记*/
	private Byte active;
	
	/** 创建时间*/
	private String createDate;
	
	/** 时间*/
	private Timestamp date;
	
	/** 资源目录名称*/
	private String resName;
	
	/** 页码 */
    private int page;
    
    /** 每页显示数量 */
    private int pageSize;

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public List<SysResource> getSysResource() {
		return sysResource;
	}

	public void setSysResource(List<SysResource> sysResource) {
		this.sysResource = sysResource;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
}
