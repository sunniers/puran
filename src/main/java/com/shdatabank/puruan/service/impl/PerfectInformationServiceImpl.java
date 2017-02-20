/**
 * PerfectInformationServiceImpl.java
 * Created at 2016-10-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shdatabank.puruan.dao.IPerfectInformationDao;
import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.Dictionarydata;
import com.shdatabank.puruan.model.InvestCompany;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IPerfectInformationService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 完善用户和企业的信息service层
 * 1.查询用户信息
 * 2.查询企业信息
 * 3.更新用户信息
 * 4.更新企业信息
 */
@Service
public class PerfectInformationServiceImpl implements IPerfectInformationService {

    private Logger logger =Logger.getLogger(PerfectInformationServiceImpl.class);
    
    /** 完善用户和企业的信息dao */
    @Autowired
    private IPerfectInformationDao iPerfectInformationDao;
    
    /**
     * 查询用户信息
     * @param user 用户信息
     * @return 用户类型
     */
    @Override
    public User selectUserInfo(User user) throws Exception {
        user = iPerfectInformationDao.selectUserInfo(user.getUserId());
        return user;
    }

    /**
     * 查询企业信息
     * @param user 用户信息
     * @return 企业id
     */
    @Override
    public Company selectCompany(User user) throws Exception {
        return iPerfectInformationDao.selectCompanyInfo(user.getUserId());
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     */
    @Transactional
    @Override
    public ReturnObject updateUserInformation(User user) throws Exception {
        logger.debug("更新用户信息");
        int count = iPerfectInformationDao.updateUserInfo(user);
        if (0 == count) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (null != user.getTalentEduExperience()) {
            count = iPerfectInformationDao.deleteTalentEduExperience(user);
            user.getTalentEduExperience().setUserId(user.getUserId());
            count = iPerfectInformationDao.insertTalentEduExperience(user.getTalentEduExperience());
            if (0 == count) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }            
        }
        if (null != user.getTalentWorkExperiences()) {
            count = iPerfectInformationDao.deleteTalentWorkExperience(user);
            for (int i = 0;i < user.getTalentWorkExperiences().size();i++) {
                user.getTalentWorkExperiences().get(i).setUserId(user.getUserId());
            }
            count = iPerfectInformationDao.insertTalentWorkExperience(user.getTalentWorkExperiences());
            if (0 == count) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }            
        }
        if (null != user.getUserCreativeTalent()) {
            count = iPerfectInformationDao.selectUserCreativeTalent(user);
            user.getUserCreativeTalent().setUserId(user.getUserId());
            if (0 == count) {
                count = iPerfectInformationDao.insertUserCreativeTalent(user.getUserCreativeTalent());
                if (0 == count) {
                    return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
                }
                if (0 != user.getUserCreativeTalent().getTalentTechnologies().size()) {
                    for (int i = 0;i < user.getUserCreativeTalent().getTalentTechnologies().size();i++) {
                        user.getUserCreativeTalent().getTalentTechnologies().get(i).
                        setCreativeTalentId(user.getUserCreativeTalent().getCreativeTalentId());
                    }
                    count = iPerfectInformationDao.insertTalentTechnology(
                            user.getUserCreativeTalent().getTalentTechnologies());
                    if (0 == count) {
                        return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
                    }
                }
            } else {
                count = iPerfectInformationDao.updateUserCreativeTalent(user.getUserCreativeTalent());
                if (0 == count) {
                    return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
                }
            }
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }

    /**
     * 更新企业信息
     * @param company 企业信息
     */
    @Transactional
    @Override
    public ReturnObject updateCompanyInfo(Company company) throws Exception {
        logger.debug("更新企业信息");
        int count = iPerfectInformationDao.updateCompanyInfo(company);
        if (0 == count) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     */
    @Transactional
    @Override
    public ReturnObject putUserInformation(User user) throws Exception {
        logger.debug("更新用户信息");
        int count = iPerfectInformationDao.updateUserInfo(user);
        if (0 == count) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (null != user.getTalentEduExperience()) {
            count = iPerfectInformationDao.deleteTalentEduExperience2(user);
            user.getTalentEduExperience().setUserId(user.getUserId());
            count = iPerfectInformationDao.insertTalentEduExperience2(user.getTalentEduExperience());
            if (0 == count) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }            
        }
        if (null != user.getTalentWorkExperiences()) {
            count = iPerfectInformationDao.deleteTalentWorkExperience2(user);
            for (int i = 0;i < user.getTalentWorkExperiences().size();i++) {
                user.getTalentWorkExperiences().get(i).setUserId(user.getUserId());
            }
            count = iPerfectInformationDao.insertTalentWorkExperience2(user.getTalentWorkExperiences());
            if (0 == count) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }            
        }
        if (null != user.getUserCreativeTalent()) {
            count = iPerfectInformationDao.selectUserCreativeTalent(user);
            user.getUserCreativeTalent().setUserId(user.getUserId());
            if (0 == count) {
                count = iPerfectInformationDao.insertUserCreativeTalent2(user.getUserCreativeTalent());
                if (0 == count) {
                    return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
                }
                iPerfectInformationDao.deleteTalentTechnology(user.getUserCreativeTalent().getCreativeTalentId());
                if (0 != user.getUserCreativeTalent().getTalentTechnologies().size()) {
                    for (int i = 0;i < user.getUserCreativeTalent().getTalentTechnologies().size();i++) {
                        user.getUserCreativeTalent().getTalentTechnologies().get(i).
                        setCreativeTalentId(user.getUserCreativeTalent().getCreativeTalentId());
                    }
                    count = iPerfectInformationDao.insertTalentTechnology(
                            user.getUserCreativeTalent().getTalentTechnologies());
                    if (0 == count) {
                        return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
                    }
                }
            } else {
                count = iPerfectInformationDao.updateUserCreativeTalent2(user.getUserCreativeTalent());
                if (0 == count) {
                    return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
                }
            }
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }

    /**
     * 插入投资机构
     * @param investCompany 投资机构
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertInvestCompany(InvestCompany investCompany) throws Exception {
        logger.debug("插入投资机构");
        //判断投资机构是否成功
        int count = iPerfectInformationDao.selectInvestCompany(investCompany);
        if (0 == count) {
            //插入投资机构
            count = iPerfectInformationDao.insertInvestCompany(investCompany);
            if (0 == count) {
                return false;
            }
            if (0 != investCompany.getInvestPreferences().size()) {
                for (int i = 0;i < investCompany.getInvestPreferences().size();i++) {
                    investCompany.getInvestPreferences().get(i).setInvestCompanyId(investCompany.getInvestCompanyId());
                }
                //插入投资偏好
                count = iPerfectInformationDao.insertInvestPreference(investCompany.getInvestPreferences());
                if (0 == count) {
                    return false;
                }            
            }
            if (0 != investCompany.getInvestDomains().size()) {
                for (int i = 0;i < investCompany.getInvestDomains().size();i++) {
                    investCompany.getInvestDomains().get(i).setInvestCompanyId(investCompany.getInvestCompanyId());
                }
                //插入投资领域
                count = iPerfectInformationDao.insertInvestDomain(investCompany.getInvestDomains());
                if (0 == count) {
                    return false;
                }            
            }
        } else {
            //更新投资机构
            count = iPerfectInformationDao.updateInvestCompany(investCompany);
            if (0 == count) {
                return false;
            }
            //删除投资偏好
            iPerfectInformationDao.deleteInvestPreference(investCompany);
            if (0 != investCompany.getInvestPreferences().size()) {
                for (int i = 0;i < investCompany.getInvestPreferences().size();i++) {
                    investCompany.getInvestPreferences().get(i).setInvestCompanyId(investCompany.getInvestCompanyId());
                }
                //插入投资偏好
                count = iPerfectInformationDao.insertInvestPreference(investCompany.getInvestPreferences());
                if (0 == count) {
                    return false;
                }            
            }
            //删除投资领域
            iPerfectInformationDao.deleteInvestDomain(investCompany);
            if (0 != investCompany.getInvestDomains().size()) {
                for (int i = 0;i < investCompany.getInvestDomains().size();i++) {
                    investCompany.getInvestDomains().get(i).setInvestCompanyId(investCompany.getInvestCompanyId());
                }
                //插入投资领域
                count = iPerfectInformationDao.insertInvestDomain(investCompany.getInvestDomains());
                if (0 == count) {
                    return false;
                }            
            }
        }
        return true;
    }

    /**
     * 查询投资机构信息
     * @param investCompany 投资机构
     * @return 投资机构
     */
    @Override
    public InvestCompany selectInvestCompanys(InvestCompany investCompany) throws Exception {
        return iPerfectInformationDao.selectInvestCompanys(investCompany);
    }

    /**
     * 查询人才技能
     * @return 人才技能
     */
    @Override
    public List<Dictionarydata> selectTalentTechnology() throws Exception {
        return iPerfectInformationDao.selectTalentTechnology();
    }

    /**
     * 查询投资机构偏好
     * @return 投资偏好
     */
    @Override
    public List<Dictionarydata> selectInvestPreferences() throws Exception {
        return iPerfectInformationDao.selectInvestPreferences();
    }
}
