package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.CreativeResourceAudit;

public interface CreativeResourceAuditService {

	/**
	 * 查询审核资源发布
	 * @return 资源审核列表
	 */
	public PageInfo<CreativeResourceAudit> findQesources(CreativeResourceAudit creativeResourceAudit) throws Exception;
	
	/**
	 * 资源发布查看
	 * @return 资源审核列表
	 */
	public CreativeResource findQesource(Long id) throws Exception;
	/**
	 * 插入资源审核
	 * @return 
	 */
	public boolean insertQesourceAudit(CreativeResourceAudit creativeResourceAudit)throws Exception;
	
}
