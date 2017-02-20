package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shdatabank.puruan.dao.VirtualAboratoryDao;
import com.shdatabank.puruan.model.VirtualAboratory;
import com.shdatabank.puruan.model.VirtualCountResponse;
import com.shdatabank.puruan.service.VirtualAboratoryService;

/**
 * 虚拟实验室service实现层
 * @author swc
 *
 */
@Service
public class VirtualAboratoryServiceImpl implements VirtualAboratoryService{
	
	/**
	 * 虚拟实验室dao层
	 */
	@Autowired
	private VirtualAboratoryDao virtualAboratoryDao;

	/**
	 * 查询虚拟实验室
	 * @return 
	 */
	@Override
	public List<VirtualAboratory> selectVirtualAboratory(VirtualAboratory virtualAboratory) throws Exception {
		return virtualAboratoryDao.selectVirtualAboratoryByParentId(virtualAboratory);
	}

	/**
	 * 查询未来七天使用情况
	 * @return 
	 */
	@Override
	public List<VirtualCountResponse> selectVirtualCount(VirtualAboratory virtualAboratory) throws Exception {
		return virtualAboratoryDao.selectVirtualAboratoryCount(virtualAboratory);
	}

}
