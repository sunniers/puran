package com.shdatabank.puruan.model;

import java.util.Date;

/**
 * 虚拟实验室返返回使用情况实体
 */
public class VirtualCountResponse {
	/** 时间日期 */
	private Date time;
	/** 剩余个数 */
	private int count;

	public Date getTime() {
		return time;
	}

	public int getCount() {
		return count;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
