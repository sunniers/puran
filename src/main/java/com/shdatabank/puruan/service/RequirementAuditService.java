package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.RequireFancingInformation;
import com.shdatabank.puruan.model.RequireProjlInformation;
import com.shdatabank.puruan.model.RequireTalentInformation;
import com.shdatabank.puruan.model.RequirementAudit;

/**
 * 需求发布审核service层
 * 1.查询需求发布
 * 2.需求审核
 * 3.需求查看
 */
public interface RequirementAuditService {

	/**
	 * 查询需求发布
	 * @return 需求审核列表
	 */
	public PageInfo<RequirementAudit> findRequirements(RequirementAudit requirementAudit) throws Exception;
	/**
	 * 插入需求审核
	 * @param backUser 需求审核实体类
	 * @return 返回插入用户信息是否成功（成功-true;失败-false）
	 */
	public boolean insertRequirementAudit(RequirementAudit requirementAudit) throws Exception;
	/**
	 * 创意需求查看
	 * @return 项目要求 
	 */
	public RequireProjlInformation selectRequirementProj(RequirementAudit requirementAudit) throws Exception;
	/**
	 * 人才需求查看
	 * @return 项目要求 
	 */
	public RequireTalentInformation selectRequirementTalent(RequirementAudit requirementAudit) throws Exception;
	/**
	 * 融资需求查看
	 * @return 项目要求 
	 */
	public RequireFancingInformation selectRequirementFancing(RequirementAudit requirementAudit) throws Exception;
	
}
