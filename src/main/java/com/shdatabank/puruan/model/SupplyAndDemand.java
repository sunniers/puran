package com.shdatabank.puruan.model;

import java.sql.Timestamp;

public class SupplyAndDemand {

	/** 供需id */
	private Long transactionId;
	/** 资源id */
	private Long id;
	/** 标记 */
	private String sign;
	private int signId;
	/** 资源名称 */
	private String name;
	/** 供方 */
	private String supply;
	/** 需方 */
	private String demand;
	/** 成交时间 */
	private Timestamp time;
	/** 成交数量 */
	private Float number;
	/** 交易状态 */
	private String status;
	
	/** 时间范围开始*/
	private String startTime;
	/** 时间范围结束 */
	private String endTime;
	
	
	/** 页码 */
    private int page;
    /** 每页显示数量 */
    private int pageSize;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public int getSignId() {
		return signId;
	}
	public void setSignId(int signId) {
		this.signId = signId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupply() {
		return supply;
	}
	public void setSupply(String supply) {
		this.supply = supply;
	}
	public String getDemand() {
		return demand;
	}
	public void setDemand(String demand) {
		this.demand = demand;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Float getNumber() {
		return number;
	}
	public void setNumber(Float number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
    
	
}
