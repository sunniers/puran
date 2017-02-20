package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.RequireFancingInformation;
import com.shdatabank.puruan.model.RequireProjlInformation;
import com.shdatabank.puruan.model.RequireTalentInformation;
import com.shdatabank.puruan.model.RequirementAudit;

/**
 * 需求发布审核dao层接口
 * 1.查询所有已审核需求发布
 * 2.查询所有未审核需求发布
 * 3.插入需求审核
 * 4.更新创意需求状态
 * 5.更新创意融资状态
 * 6.更新创意人才状态
 * 7.创意需求查看
 * 8.人才需求查看
 * 9.融资需求查看
 */
public interface RequirementAuditDao {

	/**
	 * 查询所有已审核需求发布
	 * @return 需求审核列表
	 */
	public List<RequirementAudit> selectAllRequirementYes(RequirementAudit requirementAudit);
	/**
	 * 查询所有未审核需求发布
	 * @return 需求审核列表
	 */
	public List<RequirementAudit> selectAllRequirementNo(RequirementAudit requirementAudit);
	/**
     * 插入需求审核
     * @param RequirementAudit 需求审核实体类
     * @return 返回插入用户信息是否成功（成功-true;失败-false）
     */
	public boolean insertRequirementAudit(RequirementAudit requirementAudit);
	/**
     *更新创意需求状态
     * @return 返回插入用户信息是否成功（成功-true;失败-false）
     */
	public boolean updateRequirementProj(RequirementAudit requirementAudit);
	/**
     *更新创意融资状态
     * @return 返回插入用户信息是否成功（成功-true;失败-false）
     */
	public boolean updateRequirementFancing(RequirementAudit requirementAudit);
	/**
     *更新创意人才状态
     * @return 返回插入用户信息是否成功（成功-true;失败-false）
     */
	public boolean updateRequirementTalent(RequirementAudit requirementAudit);
	/**
	 * 创意需求查看
	 * @return 项目要求 
	 */
	public RequireProjlInformation selectRequirementProj(Long id);
	/**
	 * 人才需求查看
	 * @return 项目要求 
	 */
	public RequireTalentInformation selectRequirementTalent(Long id);
	/**
	 * 融资需求查看
	 * @return 项目要求 
	 */
	public RequireFancingInformation selectRequirementFancing(Long id);
	
	
}
