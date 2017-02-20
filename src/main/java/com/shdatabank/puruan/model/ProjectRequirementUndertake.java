/**
 * ProjectRequirementUndertake.java
 * Created at 2016-10-24
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * @author guoqiankun
 * 项目承接实体类
 *
 */
public class ProjectRequirementUndertake {
	/** 成交id */
	private Long undertakeId;
	/** 项目id */
	private Long projectRequirementId;
	/** 用户id */
	private Long userId;
	/** 团队id */
	private Long teamId;
	/** 承接时间 */
	private Timestamp undertakeDatetime;
	/** 承接时间映射 */
	private String undertakeDatetimeMapping;
	/** 删除标志 */
	private String active;
	
	/** 承接状态 */
	private Integer undertakeStatus;
	
	/** 创建时间 */
	private Timestamp createTime;
	
	/** 过期时间 */
	private Integer passDay;
	
	/**数量*/
	private int number;
	
	/** page */
	private int page;

	/** pageSize */
	private int pageSize;
	
	/** 项目需求实体类*/
	private ProjectRequirement projectRequirement;
	
	/** 项目需求描述实体类*/
	private ProjRequireDescription projRequireDescription;
	
	/** 资源交易实体类*/
	private CeativeResourceTransaction ceativeResourceTransaction;
	/** 资源交易实体类*/
	private  TalentTransaction talentTransaction;
	
	public ProjRequireDescription getProjRequireDescription() {
		return projRequireDescription;
	}
	public void setProjRequireDescription(ProjRequireDescription projRequireDescription) {
		this.projRequireDescription = projRequireDescription;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public ProjectRequirement getProjectRequirement() {
		return projectRequirement;
	}
	public void setProjectRequirement(ProjectRequirement projectRequirement) {
		this.projectRequirement = projectRequirement;
	}
	public CeativeResourceTransaction getCeativeResourceTransaction() {
		return ceativeResourceTransaction;
	}
	public void setCeativeResourceTransaction(CeativeResourceTransaction ceativeResourceTransaction) {
		this.ceativeResourceTransaction = ceativeResourceTransaction;
	}
	public TalentTransaction getTalentTransaction() {
		return talentTransaction;
	}
	public void setTalentTransaction(TalentTransaction talentTransaction) {
		this.talentTransaction = talentTransaction;
	}
	public Long getUndertakeId() {
		return undertakeId;
	}
	public void setUndertakeId(Long undertakeId) {
		this.undertakeId = undertakeId;
	}
	public Long getProjectRequirementId() {
		return projectRequirementId;
	}
	public void setProjectRequirementId(Long projectRequirementId) {
		this.projectRequirementId = projectRequirementId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public Timestamp getUndertakeDatetime() {
		return undertakeDatetime;
	}
	public void setUndertakeDatetime(Timestamp undertakeDatetime) {
		this.undertakeDatetime = undertakeDatetime;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getUndertakeDatetimeMapping() {
		return undertakeDatetimeMapping;
	}
	public void setUndertakeDatetimeMapping(String undertakeDatetimeMapping) {
		this.undertakeDatetimeMapping = undertakeDatetimeMapping;
	}
    public Integer getUndertakeStatus() {
        return undertakeStatus;
    }
    public void setUndertakeStatus(Integer undertakeStatus) {
        this.undertakeStatus = undertakeStatus;
    }
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    public Integer getPassDay() {
        return passDay;
    }
    public void setPassDay(Integer passDay) {
        this.passDay = passDay;
    }
	
}
