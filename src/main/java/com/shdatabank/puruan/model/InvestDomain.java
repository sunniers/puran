/**
 * InvestDomain.java
 * Created at 2016-11-14
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

/**
 * 投资领域
 */
public class InvestDomain {

    /** 投资领域ID */
    private Integer investDomainId;
    
    /** 投资机构ID */
    private Long investCompanyId;
    
    /** 投资领域值 */
    private Integer investDomainValue;
    
    /** 投资领域值 */
    private String domainValue;

    public Integer getInvestDomainId() {
        return investDomainId;
    }

    public void setInvestDomainId(Integer investDomainId) {
        this.investDomainId = investDomainId;
    }

    public Long getInvestCompanyId() {
        return investCompanyId;
    }

    public void setInvestCompanyId(Long investCompanyId) {
        this.investCompanyId = investCompanyId;
    }

    public Integer getInvestDomainValue() {
        return investDomainValue;
    }

    public void setInvestDomainValue(Integer investDomainValue) {
        this.investDomainValue = investDomainValue;
    }

    public String getDomainValue() {
        return domainValue;
    }

    public void setDomainValue(String domainValue) {
        this.domainValue = domainValue;
    }
}
