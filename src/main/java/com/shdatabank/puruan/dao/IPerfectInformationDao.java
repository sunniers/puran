/**
 * IPerfectInformationDao.java
 * Created at 2016-10-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.Dictionarydata;
import com.shdatabank.puruan.model.InvestCompany;
import com.shdatabank.puruan.model.InvestDomain;
import com.shdatabank.puruan.model.InvestPreference;
import com.shdatabank.puruan.model.TalentEduExperience;
import com.shdatabank.puruan.model.TalentTechnology;
import com.shdatabank.puruan.model.TalentWorkExperience;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserCreativeTalent;

/**
 * 完善个人信息dao层
 * 1.查询用户类型
 * 2.根据用户id查询企业id
 * 3.更新个人基本信息
 * 4.插入教育经历
 * 5.插入工作经验
 * 6.插入企业信息
 */
public interface IPerfectInformationDao {
    
    /**
     * 查询用户信息
     * @param userId 用户id
     * @return 用户类型
     */
    public User selectUserInfo(Long userId) throws Exception;
    
    /**
     * 根据用户id查询企业信息
     * @param userId 用户id
     * @return 企业id
     */
    public Company selectCompanyInfo(Long userId) throws Exception;

    /**
     * 更新个人基本信息
     * @param user 用户信息
     */
    public int updateUserInfo(User user) throws Exception;
    
    /**
     * 插入教育经历
     * @param talentEduExperience 教育经历
     * @return 是否成功
     */
    public int insertTalentEduExperience(TalentEduExperience talentEduExperience) throws Exception;
    
    /**
     * 删除教育经历
     * @param talentEduExperience 教育经历
     * @return 是否成功
     */
    public int deleteTalentEduExperience(User user) throws Exception;

    /**
     * 插入工作经验
     * @param talentWorkExperience 工作经验
     * @return 是否成功
     */
    public int insertTalentWorkExperience(List<TalentWorkExperience> talentWorkExperience) throws Exception;

    /**
     * 删除工作经验
     * @param talentWorkExperience 工作经验
     * @return 是否成功
     */
    public int deleteTalentWorkExperience(User user) throws Exception;
    
    /**
     * 插入附加信息
     * @param userCreativeTalent 创意人才信息
     * @return 是否成功
     */
    public int insertUserCreativeTalent(UserCreativeTalent userCreativeTalent) throws Exception;
    
    /**
     * 更新附加信息
     * @param userCreativeTalent 创意人才信息
     * @return 是否成功
     */
    public int updateUserCreativeTalent(UserCreativeTalent userCreativeTalent) throws Exception;
    
    /**
     * 查询附加信息
     * @param user 查询条件
     * @return 是否存在
     */
    public Integer selectUserCreativeTalent(User user) throws Exception;
    
    /**
     * 更新企业信息
     * @param company 企业信息
     */
    public int updateCompanyInfo(Company company) throws Exception;
    
    /**
     * 插入教育经历
     * @param talentEduExperience 教育经历
     * @return 是否成功
     */
    public int insertTalentEduExperience2(TalentEduExperience talentEduExperience) throws Exception;
    
    /**
     * 删除教育经历
     * @param talentEduExperience 教育经历
     * @return 是否成功
     */
    public int deleteTalentEduExperience2(User user) throws Exception;

    /**
     * 插入工作经验
     * @param talentWorkExperience 工作经验
     * @return 是否成功
     */
    public int insertTalentWorkExperience2(List<TalentWorkExperience> talentWorkExperience) throws Exception;

    /**
     * 删除工作经验
     * @param talentWorkExperience 工作经验
     * @return 是否成功
     */
    public int deleteTalentWorkExperience2(User user) throws Exception;
    
    /**
     * 插入附加信息
     * @param userCreativeTalent 创意人才信息
     * @return 是否成功
     */
    public int insertUserCreativeTalent2(UserCreativeTalent userCreativeTalent) throws Exception;
    
    /**
     * 更新附加信息
     * @param userCreativeTalent 创意人才信息
     * @return 是否成功
     */
    public int updateUserCreativeTalent2(UserCreativeTalent userCreativeTalent) throws Exception;
    
    /**
     * 插入投资机构
     * @param investCompany 投资机构
     * @return 是否成功
     */
    public int insertInvestCompany(InvestCompany investCompany) throws Exception;
    
    /**
     * 插入投资偏好
     * @param investPreferences 投资偏好
     * @return 是否成功
     */
    public int insertInvestPreference(List<InvestPreference> investPreferences) throws Exception;
    
    /**
     * 删除投资偏好
     * @param investPreferences 投资偏好
     * @return 是否成功
     */
    public int deleteInvestPreference(InvestCompany investCompany) throws Exception;
    
    /**
     * 插入投资领域
     * @param investDomain 投资领域
     * @return 是否成功
     */
    public int insertInvestDomain(List<InvestDomain> investDomain) throws Exception;
    
    /**
     * 删除投资领域
     * @param investDomain 投资领域
     * @return 是否成功
     */
    public int deleteInvestDomain(InvestCompany investCompany) throws Exception;
    
    /**
     * 更新投资机构
     * @param investCompany 投资机构
     * @return 是否成功
     */
    public int updateInvestCompany(InvestCompany investCompany) throws Exception;
    
    /**
     * 判断投资机构是否成功
     * @param investCompany 投资机构
     * @return 投资机构ID
     */
    public int selectInvestCompany(InvestCompany investCompany) throws Exception;

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
     * 插入人才技能
     * @return 是否成功
     */
    public int insertTalentTechnology(List<TalentTechnology> talentTechnology) throws Exception;
    
    /**
     * 删除人才技能
     * @param talentTechnology 人才技能
     * @return 是否成功
     */
    public int deleteTalentTechnology(Long creativeTalentId) throws Exception;
    
    /**
     * 查询投资机构偏好
     * @return 投资偏好
     */
    public List<Dictionarydata> selectInvestPreferences() throws Exception;
}
