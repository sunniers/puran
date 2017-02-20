/**
 * Company.java
 * Created at 2016-10-18
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * 公司信息
 */
public class Company {

    /** 公司id */
    private Long companyId;
    
    /** 公司名称 */
    private String companyName;
    
    /** 公司法人 */
    private String companyCorporation;
    
    /** 组织机构代码 */
    private String organizationalInstitutionCode;
    
    /** 公司类型 */
    private String companyType;
    
    /** 公司地址 */
    private String companyAddress;
    
    /** 公司电话 */
    private String companyPhone;
    
    /** 公司行业 */
    private String companyTrade;
    
    /** 公司介绍 */
    private String companyIntroduce;
    
    /** 投资案例 */
    private String investCase;
    
    /** 投资偏好 */
    private String investPreference;
    
    /** 投资领域 */
    private String investDomain;
    
    /** 公司证件 */
    private List<CompanyCredit> companyCredits;
    
    /** 用户名 */
    private String userName;
    /** 用户id */
    private String userId;
    /** 创建时间 */
    private Timestamp createTime;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyTrade() {
        return companyTrade;
    }

    public void setCompanyTrade(String companyTrade) {
        this.companyTrade = companyTrade;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getInvestCase() {
        return investCase;
    }

    public void setInvestCase(String investCase) {
        this.investCase = investCase;
    }

    public String getInvestPreference() {
        return investPreference;
    }

    public void setInvestPreference(String investPreference) {
        this.investPreference = investPreference;
    }

    public String getInvestDomain() {
        return investDomain;
    }

    public void setInvestDomain(String investDomain) {
        this.investDomain = investDomain;
    }

    public List<CompanyCredit> getCompanyCredits() {
        return companyCredits;
    }

    public void setCompanyCredits(List<CompanyCredit> companyCredits) {
        this.companyCredits = companyCredits;
    }

    public String getCompanyCorporation() {
        return companyCorporation;
    }

    public void setCompanyCorporation(String companyCorporation) {
        this.companyCorporation = companyCorporation;
    }

    public String getOrganizationalInstitutionCode() {
        return organizationalInstitutionCode;
    }

    public void setOrganizationalInstitutionCode(String organizationalInstitutionCode) {
        this.organizationalInstitutionCode = organizationalInstitutionCode;
    }

    public String getCompanyIntroduce() {
        return companyIntroduce;
    }

    public void setCompanyIntroduce(String companyIntroduce) {
        this.companyIntroduce = companyIntroduce;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
