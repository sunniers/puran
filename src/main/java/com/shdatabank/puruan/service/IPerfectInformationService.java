/**
 * IPerfectInformationService.java
 * Created at 2016-10-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.Dictionarydata;
import com.shdatabank.puruan.model.InvestCompany;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;

/**
 * 完善用户和企业的信息service层
 * 1.查询用户信息
 * 2.查询企业信息
 * 3.更新用户信息
 * 4.更新企业信息
 */
public interface IPerfectInformationService {
    
    /**
     * 查询用户信息
     * @param user 用户信息
     * @return 用户类型
     */
    public User selectUserInfo(User user) throws Exception;
    
    /**
     * 查询企业信息
     * @param user 用户信息
     * @return 企业id
     */
    public Company selectCompany(User user) throws Exception;
    
    /**
     * 更新用户信息
     * @param user 用户信息
     */
    public ReturnObject updateUserInformation(User user) throws Exception;
    
    /**
     * 更新用户信息
     * @param user 用户信息
     */
    public ReturnObject putUserInformation(User user) throws Exception;
    
    /**
     * 更新企业信息
     * @param company 企业信息
     */
    public ReturnObject updateCompanyInfo(Company company) throws Exception;
    
    /**
     * 插入投资机构
     * @param investCompany 投资机构
     * @return 是否成功
     */
    public boolean insertInvestCompany(InvestCompany investCompany) throws Exception;
    
    /**
     * 查询投资机构信息
     * @param investCompany 投资机构
     * @return 投资机构
     */
    public InvestCompany selectInvestCompanys(InvestCompany investCompany) throws Exception;
    
    /**
     * 查询人才技能
     * @return 人才技能
     */
    public List<Dictionarydata> selectTalentTechnology() throws Exception;
    
    /**
     * 查询投资机构偏好
     * @return 投资偏好
     */
    public List<Dictionarydata> selectInvestPreferences() throws Exception;
}
