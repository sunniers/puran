/**
 * SysResourceController.java
 * Created at 2016-10-20
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.util.List;

/**
 * 我的圈子
 * @author guoqiankun
 *
 */
public class MyCommunity {
	/** 圈子id */
	private Long communityId;

	/** 圈子用户id */
	private Long userId;

	/** 我的圈子 */
	private Long communityUserId;
	/**删除标致*/
	private Byte active;
	
	
	/** 添加用户对象 */
	private List<User> users;

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCommunityUserId() {
		return communityUserId;
	}

	public void setCommunityUserId(Long communityUserId) {
		this.communityUserId = communityUserId;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



}
