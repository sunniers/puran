/**
 * ProjRequireDescription.java
 * Created at 2016-10-24
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * @author guoqiankun
 * 创意需求描述实体类
 *
 */
public class ProjRequireDescription {
	/** 创意需求描述ID */
	private Long projRequireDescriptionId;
	/** 创意需求ID */
	private Long projRequireId;
	/** 创建时间 */
	private Timestamp createTime;
	/** 创意需求描述值 */
	private String projRequireDescriptionContent;

	public Long getProjRequireDescriptionId() {
		return projRequireDescriptionId;
	}

	public void setProjRequireDescriptionId(Long projRequireDescriptionId) {
		this.projRequireDescriptionId = projRequireDescriptionId;
	}

	public Long getProjRequireId() {
		return projRequireId;
	}

	public void setProjRequireId(Long projRequireId) {
		this.projRequireId = projRequireId;
	}


	public String getProjRequireDescriptionContent() {
		return projRequireDescriptionContent;
	}

	public void setProjRequireDescriptionContent(String projRequireDescriptionContent) {
		this.projRequireDescriptionContent = projRequireDescriptionContent;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
