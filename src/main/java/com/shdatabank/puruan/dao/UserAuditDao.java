package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.CompanyCredit;
import com.shdatabank.puruan.model.UserAudit;
import com.shdatabank.puruan.model.UserExtensionInfo;

/**
 * 身份审核dao层
 */
public interface UserAuditDao {
	/**
	 * 企业审核待审核列表
	 */
	public  List<Company> selectCompanyCreditAudit(UserAudit userAudit);
	
	/**
	 * 个人审核待审核列表
	 */
	public  List<UserExtensionInfo> selectUserExtensionInfoAudit(UserAudit userAudit);
	
	/**
	 * 企业审核信息查看
	 */
	public  Company findCompanyCreditAuditById(UserAudit userAudit);
	
	/**
	 * 个人审核信息查看
	 */
	public  UserExtensionInfo findUserExtensionInfoAuditById(UserAudit userAudit);
	/**
	 * 用户审核发布
	 * @return 
	 */
	public int  insertUserAudit(UserAudit userAudit);
	/**
	 * 更新用户是否审核状态
	 * @return 
	 */
	public boolean  updateUserIsAudit(UserAudit userAudit);
}
