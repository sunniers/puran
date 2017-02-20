package com.shdatabank.puruan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.SupplyAndDemand;
import com.shdatabank.puruan.service.CreativeResourceService;
import com.shdatabank.puruan.service.SupplyAndDemandService;
import com.shdatabank.puruan.service.impl.SupplyAndDemandServiceImpl;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 供需信息后台controller层
 */

@RequestMapping(value = "/deal")
@Controller
public class SupplyAndDemandController {

	/** 供需信息后台service层 */
	@Autowired
	private SupplyAndDemandService supplyAndDemandService;
	/** 创意资源service层 */
	@Autowired
	private CreativeResourceService creativeResourceService;

	/**
	 * 根据条件查询供需信息
	 * 
	 * @param SupplyAndDemand
	 *            供需信息实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/findBy", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllResoursebyName(@RequestBody SupplyAndDemand supplyAndDemand) throws Exception {
		PageInfo<SupplyAndDemand> supplyAndDemands = supplyAndDemandService.selectResourseBy(supplyAndDemand);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", supplyAndDemands);
	}

	/**
	 * 查询资源供需信息
	 * 
	 * @param SupplyAndDemand
	 *            供需信息实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/seek", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findResourseBySign(@RequestBody SupplyAndDemand supplyAndDemand) throws Exception {
		/*if ((SupplyAndDemandServiceImpl.proj).equalsIgnoreCase(supplyAndDemand.getSign())) {
			// 项目资源信息
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
					requirementAuditService.selectRequirement(supplyAndDemand));
		} else*/ if ((SupplyAndDemandServiceImpl.res).equalsIgnoreCase(supplyAndDemand.getSign())) {
			// 创意资源信息
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
					creativeResourceService.selectCreativeResource(supplyAndDemand.getId()));
		} else {
			// 人才资源信息
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
					supplyAndDemandService.selectTalentById(supplyAndDemand.getId()));
		}
	}
}
