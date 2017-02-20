package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * 投资机构实体类
 */
public class InvestCompany {

	/** 投资机构ID */
	private long investCompanyId;
	/** 公司ID */
	private long companyId;
	/** 投资机构名称 */
	private String investCompanyName;
	/** 成立日期 */
	private Timestamp buildDate;
	/** 投资机构简介 */
	private String investCase;
	/** 发布时间 */
	private Timestamp createTime;
	/** 投资机构状态 */
	private Integer investStatus;
	/** 删除标志 */
	private Byte active;
	
	/** 审核结果 */
	private String auditStatus; 
	/** 企业名称 */
	private String companyName;
	/** 投资偏好 */
	private String investPreference;
	/** 投资偏好数组 */
	private String[] preference;
	/** 投资领域 */
	private String investDomain;
	/** 投资领域数组 */
	private String[] domain;
	
	/** 投资偏好 */
	private List<InvestPreference> investPreferences;
	/** 投资领域 */
	private List<InvestDomain> investDomains;
	
	
	/** 数据字典id */
	private int investPreferenceValue;
	/** page */
    private int page;
    /** pageSize */
    private int pageSize;
    /** 标记 */
    private String sign;


	public long getInvestCompanyId() {
		return investCompanyId;
	}

	public void setInvestCompanyId(long investCompanyId) {
		this.investCompanyId = investCompanyId;
	}

	public String getInvestCompanyName() {
		return investCompanyName;
	}

	public void setInvestCompanyName(String investCompanyName) {
		this.investCompanyName = investCompanyName;
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

	public int getInvestPreferenceValue() {
		return investPreferenceValue;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public void setInvestPreferenceValue(int investPreferenceValue) {
		this.investPreferenceValue = investPreferenceValue;
	}

	public String[] getPreference() {
		return preference;
	}

	public void setPreference(String[] preference) {
		this.preference = preference;
	}

	public String[] getDomain() {
		return domain;
	}

	public void setDomain(String[] domain) {
		this.domain = domain;
	}

	public Timestamp getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Timestamp buildDate) {
		this.buildDate = buildDate;
	}


	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

    public List<InvestPreference> getInvestPreferences() {
        return investPreferences;
    }

    public void setInvestPreferences(List<InvestPreference> investPreferences) {
        this.investPreferences = investPreferences;
    }

    public List<InvestDomain> getInvestDomains() {
        return investDomains;
    }

    public void setInvestDomains(List<InvestDomain> investDomains) {
        this.investDomains = investDomains;
    }

    public Integer getInvestStatus() {
        return investStatus;
    }

    public void setInvestStatus(Integer investStatus) {
        this.investStatus = investStatus;
    }

}
