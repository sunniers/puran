package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.CompanyCredit;
import com.shdatabank.puruan.model.UserAudit;
import com.shdatabank.puruan.model.UserExtensionInfo;

/**
 * 身份审核service层
 */
public interface UserAuditService {

	/**
	 * 企业审核列表
	 * @return
	 */
	public  PageInfo<Company> selectCompanyCreditAudit(UserAudit userAudit) throws Exception ;
	/**
	 * 个人审核列表
	 * @return
	 */
	public  PageInfo<UserExtensionInfo> selectUserExtensionInfoAudit(UserAudit userAudit)throws Exception;
	
	/**
	 * 企业审核信息查看
	 */
	public  Company findCompanyCreditAuditById(UserAudit userAudit)throws Exception;
	
	/**
	 * 个人审核信息查看
	 */
	public  UserExtensionInfo findUserExtensionInfoAuditById(UserAudit userAudit)throws Exception;

	/**
	 * 插入用户审核
	 * @return 
	 */
	public boolean insertUserAudit(UserAudit userAudit)throws Exception;
	

}
