package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.SupplyAndDemandDao;
import com.shdatabank.puruan.model.SupplyAndDemand;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.service.SupplyAndDemandService;

/**
 * 供需信息后台service层
 */
@Service
public class SupplyAndDemandServiceImpl implements SupplyAndDemandService {

	public final static String proj = "proj";		// 需求资源
	public final static String res = "res";			// 创意资源
	public final static String talent = "talent";	// 人才资源

	/**
	 * 供需信息后台dao层
	 */
	@Autowired
	private SupplyAndDemandDao supplyAndDemandDao;

	/**
	 * 根据条件查询供需信息
	 * @param SupplyAndDemand
	 *            供需信息实体类
	 * @return 返回结果对象
	 */
	@Override
	public PageInfo<SupplyAndDemand> selectResourseBy(SupplyAndDemand supplyAndDemand) throws Exception {
		PageHelper.startPage(supplyAndDemand.getPage(), supplyAndDemand.getPageSize());
		List<SupplyAndDemand> supplyAndDemans = null;
		if ((SupplyAndDemandServiceImpl.proj).equalsIgnoreCase(supplyAndDemand.getSign())) {
			// 项目资源供需信息
			supplyAndDemans = supplyAndDemandDao.selectRequirementbyName(supplyAndDemand);
		} else if ((SupplyAndDemandServiceImpl.res).equalsIgnoreCase(supplyAndDemand.getSign())) {
			// 创意资源供需信息
			supplyAndDemans = supplyAndDemandDao.selectResoursebyName(supplyAndDemand);
		} else if ((SupplyAndDemandServiceImpl.talent).equalsIgnoreCase(supplyAndDemand.getSign())) {
			// 人才资源供需信息
			supplyAndDemans = supplyAndDemandDao.selectTalentbyName(supplyAndDemand);
		} else {
			//所有供需信息
			supplyAndDemans = supplyAndDemandDao.selectAllResoursebyName(supplyAndDemand);
		}
		return new PageInfo<SupplyAndDemand>(supplyAndDemans);
	}

	@Override
	public TalentRequirement selectTalentById(Long id) throws Exception {
		return supplyAndDemandDao.selectTalentById(id);
	}
}
