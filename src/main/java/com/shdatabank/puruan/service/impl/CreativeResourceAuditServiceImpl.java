package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.CeativeResourceAuditDao;
import com.shdatabank.puruan.dao.CreateResourceWarehouseDao;
import com.shdatabank.puruan.model.CreateResourceWarehouse;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.CreativeResourceAudit;
import com.shdatabank.puruan.service.CreativeResourceAuditService;

/**
 * 资源发布审核Service层 
 * 1.查询审核资源发布 
 * 2.资源详情查看
 */
@Service
public class CreativeResourceAuditServiceImpl implements CreativeResourceAuditService {
	
	private Logger logger =Logger.getLogger(CreativeResourceAuditServiceImpl.class);

	private final static String YES = "已审核";

	private final static int yesStatus = 401203; // 创意资源已通过状态
	private final static int noStatus = 401204; // 创意资源未通过状态

	/** 资源发布审核dao层 */
	@Autowired
	private CeativeResourceAuditDao creativeResourceAuditDao;
	/** 资源仓库接口 */
	@Autowired
	private CreateResourceWarehouseDao createResourceWarehouseDao;


	/**
	 * 查询审核资源发布
	 * 
	 * @return 资源审核列表
	 */
	@Override
	public PageInfo<CreativeResourceAudit> findQesources(CreativeResourceAudit creativeResourceAudit) {
		PageHelper.startPage(creativeResourceAudit.getPage(), creativeResourceAudit.getPageSize());
		List<CreativeResourceAudit> creativeResourceAudits = null;
		if ((CreativeResourceAuditServiceImpl.YES).equalsIgnoreCase(creativeResourceAudit.getSign())) {
			// 已审核资源发布
			creativeResourceAudits = creativeResourceAuditDao.selectAllRequirementYes(creativeResourceAudit);
			for (int i = 0; i < creativeResourceAudits.size(); i++) {
				creativeResourceAudits.get(i).setResource(spliteUse(creativeResourceAudits.get(i).getResourceType()));
			}
		} else {
			// 未审核资源发布
			creativeResourceAudits = creativeResourceAuditDao.selectAllRequirementNo(creativeResourceAudit);
			for (int i = 0; i < creativeResourceAudits.size(); i++) {
				creativeResourceAudits.get(i).setResource(spliteUse(creativeResourceAudits.get(i).getResourceType()));
			}
		}
		return new PageInfo<CreativeResourceAudit>(creativeResourceAudits);
	}

	/**
	 * 资源详情查看
	 * 
	 * @return 资源审核列表
	 */
	@Override
	public CreativeResource findQesource(Long id) throws Exception {
		CreativeResource creativeResource = creativeResourceAuditDao.findRequirementById(id);
		if (creativeResource != null) {
			creativeResource.setResource(spliteUse(creativeResource.getResourceType()));
		}
		return creativeResource;
	}

	/**
	 * 插入资源审核
	 * 
	 * @param RequirementAudit:
	 *            需求审核实体类
	 * @return 返回插入是否成功
	 */
	@Transactional
	@Override
	public boolean insertQesourceAudit(CreativeResourceAudit creativeResourceAudit) {
		if (creativeResourceAudit.getAuditStatusId() == 400702) {
			// 插入资源仓库
			CreateResourceWarehouse createResourceWarehouse=new CreateResourceWarehouse();
			createResourceWarehouse.setCreateResourceId(creativeResourceAudit.getResourceId());
			createResourceWarehouse.setResourceType(700005);
			createResourceWarehouseDao.insertCreateResourceWarehouse(createResourceWarehouse);
			logger.debug("--资源仓库添加数据--");
			creativeResourceAudit.setResStatusId(CreativeResourceAuditServiceImpl.yesStatus);
		}
		if (creativeResourceAudit.getAuditStatusId() == 400703) {
			creativeResourceAudit.setResStatusId(CreativeResourceAuditServiceImpl.noStatus);
		}
		int flag = creativeResourceAuditDao.insertResourceAudit(creativeResourceAudit);
		logger.debug("--添加审核结果--");
		if (flag > 0) {
			creativeResourceAuditDao.updateResourceAudit(creativeResourceAudit);
			logger.debug("--更新资源状态--");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 分割字符串
	 * 
	 * @param str
	 * @return String[]
	 */
	public String[] spliteUse(String str) {
		if (str != null) {
			return str.split(",");
		} else {
			return null;
		}
	}

}
