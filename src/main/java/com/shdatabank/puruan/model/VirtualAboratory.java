package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 虚拟实验室实体类
 * 
 */
public class VirtualAboratory {
	/** 虚拟实验室ID */
	private long virtualAboratoryId;
	/** 设备编号 */
	private long equipmentNumber;
	/** 当前版本 */
	private String virtualVersion;
	/** 类型 */
	private int virtualType;
	/** 所有者名称 */
	private String virtualOwnerName;
	/** 数量 */
	private int virtualCount;
	/** 父虚拟实验室ID */
	private long parentVirtualAboratory;
	/** 虚拟实验室名称 */
	private String virtualAboratoryName;
	/** 虚拟实验室介绍 */
	private String virtualAboratoryIntroduce;
	/** 创建时间 */
	private Timestamp createTime;
	/** 删除标志 */
	private Byte active;
	
	 /** page */
    private Integer page;
    /** pageSize */
    private Integer pageSize;
	
	public long getVirtualAboratoryId() {
		return virtualAboratoryId;
	}
	public long getEquipmentNumber() {
		return equipmentNumber;
	}
	public String getVirtualVersion() {
		return virtualVersion;
	}
	public int getVirtualType() {
		return virtualType;
	}
	public String getVirtualOwnerName() {
		return virtualOwnerName;
	}
	public int getVirtualCount() {
		return virtualCount;
	}
	public long getParentVirtualAboratory() {
		return parentVirtualAboratory;
	}
	public String getVirtualAboratoryName() {
		return virtualAboratoryName;
	}
	public String getVirtualAboratoryIntroduce() {
		return virtualAboratoryIntroduce;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public Byte getActive() {
		return active;
	}
	public void setVirtualAboratoryId(long virtualAboratoryId) {
		this.virtualAboratoryId = virtualAboratoryId;
	}
	public void setEquipmentNumber(long equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	public void setVirtualVersion(String virtualVersion) {
		this.virtualVersion = virtualVersion;
	}
	public void setVirtualType(int virtualType) {
		this.virtualType = virtualType;
	}
	public void setVirtualOwnerName(String virtualOwnerName) {
		this.virtualOwnerName = virtualOwnerName;
	}
	public void setVirtualCount(int virtualCount) {
		this.virtualCount = virtualCount;
	}
	public void setParentVirtualAboratory(long parentVirtualAboratory) {
		this.parentVirtualAboratory = parentVirtualAboratory;
	}
	public void setVirtualAboratoryName(String virtualAboratoryName) {
		this.virtualAboratoryName = virtualAboratoryName;
	}
	public void setVirtualAboratoryIntroduce(String virtualAboratoryIntroduce) {
		this.virtualAboratoryIntroduce = virtualAboratoryIntroduce;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public void setActive(Byte active) {
		this.active = active;
	}
	public Integer getPage() {
		return page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
