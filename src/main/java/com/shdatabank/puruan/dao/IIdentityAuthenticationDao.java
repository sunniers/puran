/**
 * IIdentityAuthenticationDao.java
 * Created at 2016-10-18
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.CompanyCredit;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserExtensionInfo;

/**
 * 身份认证dao层
 * 1.将个人身份认证信息保存到数据库
 * 2.设置用户类型
 */
public interface IIdentityAuthenticationDao {

    /**
     * 将个人身份认证信息保存到数据库
     * @param userExtensionInfo 个人身份信息实体类
     */
	public int insertUserExtensionInfo(UserExtensionInfo userExtensionInfo) throws Exception;
	
	/**
	 * 查询用户信息是否已经存在
	 * @param userId 用户ID
	 * @return 是否存在
	 */
	public int selectUserInfo(Long userId) throws Exception;
	
	/**
	 * 更新用户信息
	 * @param userExtensionInfo 用户信息
	 * @return 是否成功
	 */
	public int updateUserInfo(UserExtensionInfo userExtensionInfo) throws Exception;

	/**
	 * 设置用户类型
	 * @param userType 用户类型
	 */
	public int updateUserType(User user) throws Exception;
	
	/**
	 * 将企业认证信息保存到数据库
	 * @param company 企业实体类
	 */
	public int insertCompany(Company company) throws Exception;
    
    /**
     * 将公司证件信息保存到数据库
     * @param companyCredit 公司证件实体类
     */
    public int insertCompanyCredit(List<CompanyCredit> companyCredits) throws Exception;
}
