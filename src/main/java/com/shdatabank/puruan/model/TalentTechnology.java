/**
 * talentTechnology.java
 * Created at 2016-11-5
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;


/**
 * 创意人才技能应实体类
 * 
 * @author guoqiankun
 *
 */
public class TalentTechnology {
	/** 创意人才技能ID */
	private Long talentTechnologyId;
	/** 创意人才ID */
	private Long creativeTalentId;
	/** 技能ID */	
	private Integer technologyId;
	public Long getTalentTechnologyId() {
		return talentTechnologyId;
	}
	public void setTalentTechnologyId(Long talentTechnologyId) {
		this.talentTechnologyId = talentTechnologyId;
	}
	public Long getCreativeTalentId() {
		return creativeTalentId;
	}
	public void setCreativeTalentId(Long creativeTalentId) {
		this.creativeTalentId = creativeTalentId;
	}
	public Integer getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

}
