/**
 * SysResource.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.util.List;

/**
 * 系统资源信息表对应实体类
 * 
 * @author guoqiankun
 *
 */
public class SysResource {

	/** 资源id */
	private Integer resourceId;

	/** 资源父id */
	private Integer parentResourceId;

	/** 资源名称 */
	private String resourceName;

	/** 资源中文名 */
	private String resourceChese;

	/** 资源图片 */
	private String resourceIcon;

	/** 资源类型 */
	private String resourceType;
	/**排序字段*/
	private int  sortedField;
	/**资源链接*/
	private String  resourceLink;

	/** 删除标准 */
	private Byte active;
	/** 0 表示是一级目录  */
	private String  parentMenu;
	/** 1 表示是二级目录*/
	private String  childMenu;

	/** page */
	private int page;

	/** pageSize */
	private int pageSize;
	
	private List<SysResource> sysResources;
	

	public String getResourceLink() {
		return resourceLink;
	}

	public void setResourceLink(String resourceLink) {
		this.resourceLink = resourceLink;
	}

	public int getSortedField() {
		return sortedField;
	}

	public void setSortedField(int sortedField) {
		this.sortedField = sortedField;
	}

	public String getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(String parentMenu) {
		this.parentMenu = parentMenu;
	}

	public String getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(String childMenu) {
		this.childMenu = childMenu;
	}

	public List<SysResource> getSysResources() {
		return sysResources;
	}

	public void setSysResources(List<SysResource> sysResources) {
		this.sysResources = sysResources;
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

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getParentResourceId() {
		return parentResourceId;
	}

	public void setParentResourceId(Integer parentResourceId) {
		this.parentResourceId = parentResourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceChese() {
		return resourceChese;
	}

	public void setResourceChese(String resourceChese) {
		this.resourceChese = resourceChese;
	}

	public String getResourceIcon() {
		return resourceIcon;
	}

	public void setResourceIcon(String resourceIcon) {
		this.resourceIcon = resourceIcon;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

}
