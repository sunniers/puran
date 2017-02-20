package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.SupplyAndDemand;
import com.shdatabank.puruan.model.TalentRequirement;

public interface SupplyAndDemandDao {

	/**
     * 根据条件查询所有供需信息
     * @param SupplyAndDemand 供需信息实体类
     * @return 返回结果对象
     */
	public List<SupplyAndDemand> selectAllResoursebyName(SupplyAndDemand supplyAndDemand);
	
	/**
     * 根据条件查询项目供需信息
     * @param SupplyAndDemand 供需信息实体类
     * @return 返回结果对象
     */
	public List<SupplyAndDemand> selectRequirementbyName(SupplyAndDemand supplyAndDemand);
	
	/**
     * 根据条件查询资源供需信息
     * @param SupplyAndDemand 供需信息实体类
     * @return 返回结果对象
     */
	public List<SupplyAndDemand> selectResoursebyName(SupplyAndDemand supplyAndDemand);
	
	/**
     * 根据条件查询人才供需信息
     * @param SupplyAndDemand 供需信息实体类
     * @return 返回结果对象
     */
	public List<SupplyAndDemand> selectTalentbyName(SupplyAndDemand supplyAndDemand);
	
	/**
	 * 根据ID查询人才需求
	 */
	public TalentRequirement selectTalentById(Long id) ;
}
