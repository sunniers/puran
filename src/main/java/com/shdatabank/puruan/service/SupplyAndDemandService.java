package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.SupplyAndDemand;
import com.shdatabank.puruan.model.TalentRequirement;

/**
 * 供需信息后台controller层
 *1.根据条件查询供需信息
 */
public interface SupplyAndDemandService {
	/**
	 * 根据条件查询供需信息
	 * @param SupplyAndDemand
	 *            供需信息实体类
	 * @return 返回结果对象
	 */
	public PageInfo<SupplyAndDemand> selectResourseBy(SupplyAndDemand supplyAndDemand) throws Exception;
	
	/**
	 * 根据ID查询人才需求
	 */
	public TalentRequirement selectTalentById(Long id) throws Exception;
	
	
}
