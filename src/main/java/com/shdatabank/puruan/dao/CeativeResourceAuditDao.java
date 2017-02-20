package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.CreativeResourceAudit;

/**
 * 资源发布审核dao层接口
 * 1.查询所有已审核资源发布
 * 2.查询所有未审核资源发布
 */
public interface CeativeResourceAuditDao {

	/**
	 * 查询所有已审核资源发布
	 * @return 资源审核列表
	 */
	public List<CreativeResourceAudit> selectAllRequirementYes(CreativeResourceAudit ceativeResourceAudit);
	/**
	 * 查询所有未审核资源发布
	 * @return 资源审核列表
	 */
	public List<CreativeResourceAudit> selectAllRequirementNo(CreativeResourceAudit ceativeResourceAudit);
	/**
	 * 资源发布查看
	 * @return 资源审核
	 */
	public CreativeResource findRequirementById(Long id);
	
	/**
	 * 资源审核发布
	 * @return 
	 */
	public int insertResourceAudit(CreativeResourceAudit creativeResourceAudit);
	
	/**
     *更新资源需求状态
     * @return 返回插入用户信息是否成功（成功-true;失败-false）
     */
	public boolean updateResourceAudit(CreativeResourceAudit creativeResourceAudit);
	
	
}
