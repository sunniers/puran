package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.RequirementAuditDao;
import com.shdatabank.puruan.model.RequireFancingInformation;
import com.shdatabank.puruan.model.RequireProjlInformation;
import com.shdatabank.puruan.model.RequireTalentInformation;
import com.shdatabank.puruan.model.RequirementAudit;
import com.shdatabank.puruan.service.RequirementAuditService;

/**
 * 需求发布审核Service层
 */
@Service
public class RequirementAuditServiceImpl implements RequirementAuditService {
	
	private Logger logger = Logger.getLogger(RequirementAuditServiceImpl.class);

	private final static String YES = "已审核";
	/**
	 * 需求发布审核dao层
	 */
	@Autowired
	private RequirementAuditDao requirementAuditDao;
	/**
	 * 查询需求发布 已审核,未审核
	 * 
	 * @return 需求审核列表
	 */
	@Override
	public PageInfo<RequirementAudit> findRequirements(RequirementAudit requirementAudit) {
		PageHelper.startPage(requirementAudit.getPage(), requirementAudit.getPageSize());
		List<RequirementAudit> requirementAudits = null;
		if ((RequirementAuditServiceImpl.YES).equalsIgnoreCase(requirementAudit.getSign())) {
			// 已审核需求发布
			requirementAudits = requirementAuditDao.selectAllRequirementYes(requirementAudit);
		} else {
			// 未审核需求发布
			requirementAudits = requirementAuditDao.selectAllRequirementNo(requirementAudit);
		}
		return new PageInfo<RequirementAudit>(requirementAudits);
	}
	/**
	 * 创意需求查看
	 * 
	 * @return 项目要求
	 */
	@Override
	public RequireProjlInformation selectRequirementProj(RequirementAudit requirementAudit) throws Exception {
		RequireProjlInformation require = requirementAuditDao.selectRequirementProj(requirementAudit.getProjId());
		require.setRequire(spliteUse(require.getRequirementClass()));
		return require;
	}
	/**
	 * 人才需求查看
	 * @return 项目要求
	 */
	@Override
	public RequireTalentInformation selectRequirementTalent(RequirementAudit requirementAudit) throws Exception {
		RequireTalentInformation require=requirementAuditDao.selectRequirementTalent(requirementAudit.getProjId());
		require.setRequire(spliteUse(require.getRequirementClass()));
		return require;
	}
	/**
	 * 融资需求查看
	 * @return 项目要求
	 */
	@Override
	public RequireFancingInformation selectRequirementFancing(RequirementAudit requirementAudit) throws Exception {
		RequireFancingInformation require=requirementAuditDao.selectRequirementFancing(requirementAudit.getProjId());
		require.setRequire(spliteUse(require.getRequirementClass()));
		return require;
	}
	/**
	 * 插入需求审核
	 * 
	 * @param RequirementAudit:
	 *            需求审核实体类
	 * @return 返回插入是否成功
	 */
	@Transactional
	@Override
	public boolean insertRequirementAudit(RequirementAudit requirementAudit) {
		boolean flag = requirementAuditDao.insertRequirementAudit(requirementAudit);
		logger.debug("--添加需求审核内容--");
		if (flag) {
			// 创意需求
			if (requirementAudit.getRequirementType() == 700001) {
				int statusId = 400102;// 已发布
				if (requirementAudit.getAuditStatusId() == 400703) {
					statusId = 400104;// 发布失败
				}
				requirementAudit.setStatusId(statusId);
				requirementAuditDao.updateRequirementProj(requirementAudit);
			}
			// 人才需求
			else if (requirementAudit.getRequirementType() == 700002) {
				int statusId = 400102;// 已发布
				if (requirementAudit.getAuditStatusId() == 400703) {
					statusId = 400104;// 发布失败
				}
				requirementAudit.setStatusId(statusId);
				
				requirementAuditDao.updateRequirementTalent(requirementAudit);
			}
			// 融资需求
			else if (requirementAudit.getRequirementType() == 700003) {
				int statusId = 140403;//审核通过
				if (requirementAudit.getAuditStatusId() == 400703) {
					statusId = 140404;// 审核未通过
				}
				requirementAudit.setStatusId(statusId);
				requirementAuditDao.updateRequirementFancing(requirementAudit);
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 分割字符串
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
