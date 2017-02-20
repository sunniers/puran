package com.shdatabank.puruan.service;

import java.util.List;

import com.shdatabank.puruan.model.VirtualAboratory;
import com.shdatabank.puruan.model.VirtualCountResponse;

/**
 * 虚拟实验室service层
 * @author swc
 */
public interface VirtualAboratoryService {
	
	/**
	 * 查询虚拟实验室
	 * @return 
	 */
	public List<VirtualAboratory> selectVirtualAboratory(VirtualAboratory virtualAboratory) throws Exception;
	
	/**
	 * 查询未来七天使用情况
	 * @return 
	 */
	public List<VirtualCountResponse> selectVirtualCount(VirtualAboratory virtualAboratory) throws Exception;
	

}
