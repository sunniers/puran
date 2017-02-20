/**
 * CompanyCredit.java
 * Created at 2016-10-18
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 公司证件
 */
public class CompanyCredit {
	
    /** 证件id */
    private Long creditId;
    /** 公司id */
    private Long companyId;
    /** 证件名称 */
    private String creditName;
    /** 证件类型 */
    private String creditType;
    /** 证件文件名 */
    private String creditFilename;
    /** 证件正面文件路径 */
    private String creditFrontPath;
    /** 证件反面文件路径 */
    private String creditBackPath;
    /** 创建时间 */
    private Timestamp createTime;
    
    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getCreditFilename() {
        return creditFilename;
    }

    public void setCreditFilename(String creditFilename) {
        this.creditFilename = creditFilename;
    }

    public String getCreditFrontPath() {
        return creditFrontPath;
    }

    public void setCreditFrontPath(String creditFrontPath) {
        this.creditFrontPath = creditFrontPath;
    }

    public String getCreditBackPath() {
        return creditBackPath;
    }

    public void setCreditBackPath(String creditBackPath) {
        this.creditBackPath = creditBackPath;
    }

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
