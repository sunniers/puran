package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.VirtualAboratory;
import com.shdatabank.puruan.model.VirtualCountResponse;

/**
 * 虚拟实验室dao层
 * 
 * @author swc
 *
 */
public interface VirtualAboratoryDao {

	/**
	 * 查询虚拟实验室
	 * @return 
	 */
	public List<VirtualAboratory> selectVirtualAboratoryByParentId(VirtualAboratory virtualAboratory);
	/**
	 * 查询未来七天使用情况
	 * @return 
	 */
	public List<VirtualCountResponse> selectVirtualAboratoryCount(VirtualAboratory virtualAboratory);
}
