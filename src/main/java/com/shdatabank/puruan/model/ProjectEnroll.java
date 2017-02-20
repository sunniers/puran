/**
 * ProjectEnroll.java
 * Created at 2016-11-04
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 项目报名
 */
public class ProjectEnroll {

	/** 报名ID */
	private Long enrollId;

	/** 创意需求ID */
	private Long projectRequirementId;
	/** 用户ID */
	private Long userId;
	/** 报名时间 */
	private Timestamp enrollDatetime;
	/** 报名状态 */
	private Integer enrollStatus;
	/** 删除标志 */
	private byte active;
	
	/** 附件预览 */
	private String enrollSeeFilePath;
	
	/** 附件名称 */
	private String enrollFileName;
	
	/** 附件路径 */
	private String enrollFilePath;

	/** 报名信息 */
	private String enrollValue;
	/** page */
	private Integer page;

	/** pageSize */
	private Integer pageSize;
	
	/** 手机 */
    private String mobile;
    
    /** 邮箱 */
    private String email;
    
    /** 名称 */
    private String name;
    
    /** 评价 */
    private Double stars;
    
    /** 承接状态 */
    private String undertakeStatus;
    
    /** 是否可以再次选择 */
    private Integer isChoose;

	public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public Long getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(Long enrollId) {
		this.enrollId = enrollId;
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

	public Timestamp getEnrollDatetime() {
		return enrollDatetime;
	}

	public void setEnrollDatetime(Timestamp enrollDatetime) {
		this.enrollDatetime = enrollDatetime;
	}

	public Integer getEnrollStatus() {
		return enrollStatus;
	}

	public void setEnrollStatus(Integer enrollStatus) {
		this.enrollStatus = enrollStatus;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

    public String getEnrollValue() {
        return enrollValue;
    }

    public void setEnrollValue(String enrollValue) {
        this.enrollValue = enrollValue;
    }

    public String getEnrollFileName() {
        return enrollFileName;
    }

    public void setEnrollFileName(String enrollFileName) {
        this.enrollFileName = enrollFileName;
    }

    public String getEnrollFilePath() {
        return enrollFilePath;
    }

    public void setEnrollFilePath(String enrollFilePath) {
        this.enrollFilePath = enrollFilePath;
    }

    public String getUndertakeStatus() {
        return undertakeStatus;
    }

    public void setUndertakeStatus(String undertakeStatus) {
        this.undertakeStatus = undertakeStatus;
    }

    public Integer getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(Integer isChoose) {
        this.isChoose = isChoose;
    }

    public String getEnrollSeeFilePath() {
        return enrollSeeFilePath;
    }

    public void setEnrollSeeFilePath(String enrollSeeFilePath) {
        this.enrollSeeFilePath = enrollSeeFilePath;
    }

}
