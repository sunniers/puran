/**
 * SysResourceController.java
 * Created at 2016-10-24
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * @author guoqiankun
 * 人才交易实体类
 *
 */
public class TalentTransaction {
	/** 交易id */
	private Long transactionId;
	/** 人才需求id */
	private Long talentRequirementId;
	/** 人才id */
	private Long userId;
	/** 成交日期 */
	private Timestamp transactionDatetime;
	/** 交易时间映射 */
	private String transactionDatetimeMapping;
	/** 交易金额 */
	private String transactionMoney;
	/** 成交币种 */
	private String transactionCurrency;
	/**项目需求实体类*/
	private TalentRequirement talentRequirement;
	/**交易状态*/
	private  String transactionStatus;
	/**数量*/
	private int number;
	/**删除状态*/
	private Byte active;
	/**过期时间*/
	private Integer passDay;
	/**创建时间*/
	private Timestamp createTime;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public TalentRequirement getTalentRequirement() {
		return talentRequirement;
	}

	public void setTalentRequirement(TalentRequirement talentRequirement) {
		this.talentRequirement = talentRequirement;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getTalentRequirementId() {
		return talentRequirementId;
	}

	public void setTalentRequirementId(Long talentRequirementId) {
		this.talentRequirementId = talentRequirementId;
	}

	public Timestamp getTransactionDatetime() {
		return transactionDatetime;
	}

	public void setTransactionDatetime(Timestamp transactionDatetime) {
		this.transactionDatetime = transactionDatetime;
	}

	public String getTransactionDatetimeMapping() {
		return transactionDatetimeMapping;
	}

	public void setTransactionDatetimeMapping(String transactionDatetimeMapping) {
		this.transactionDatetimeMapping = transactionDatetimeMapping;
	}

	public String getTransactionMoney() {
		return transactionMoney;
	}

	public void setTransactionMoney(String transactionMoney) {
		this.transactionMoney = transactionMoney;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public Integer getPassDay() {
        return passDay;
    }

    public void setPassDay(Integer passDay) {
        this.passDay = passDay;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
