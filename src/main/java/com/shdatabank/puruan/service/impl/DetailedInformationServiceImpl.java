/**
 * DetailedInformationServiceImpl.java
 * Created at 2016-10-29
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shdatabank.puruan.dao.IDetailedInformationDao;
import com.shdatabank.puruan.model.GetTalents;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementDetails;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.model.UserInformation;
import com.shdatabank.puruan.service.IDetailedInformationService;

/**
 * 各种详细信息service层
 */
@Service
public class DetailedInformationServiceImpl implements IDetailedInformationService {

    private Logger logger =Logger.getLogger(DetailedInformationServiceImpl.class);
    
    /** 各种详细信息dao */
    @Autowired
    private IDetailedInformationDao iDetailedInformationDao;
    
    /**
     * 查询用户的信息
     * @param userInformation 用户信息
     * @return 用户信息
     */
    @Override
    public UserInformation selectUserInformation(UserInformation userInformation) throws Exception {
        UserInformation userInformation2 = iDetailedInformationDao.selectUserInformation(userInformation);
        return userInformation2;
    }

    /**
     * 查看创意需求信息和进度
     * @param projectRequirement 创意需求信息
     * @return 创意需求信息
     */
    @Override
    public ProjectRequirementDetails selectProjectRequirementDetails(
            ProjectRequirementDetails projectRequirementDetails) throws Exception {
        return iDetailedInformationDao.selectProjectRequirementDetails(projectRequirementDetails);
    }

    /**
     * 查询需要修改的创意需求的信息
     * @param ProjectRequirement 创意需求信息
     * @return 创意需求信息
     */
    @Override
    public ProjectRequirement selectModifyProjectRequirement(ProjectRequirement ProjectRequirement) throws Exception {
        return iDetailedInformationDao.selectModifyProjectRequirement(ProjectRequirement);
    }

    /**
     * 查创意需求的详细信息
     * @param projectRequirement 创意需求信息
     * @return 创意需求信息
     */
    @Override
    public ProjectRequirement selectProjectRequirement(ProjectRequirement projectRequirement) throws Exception {
        return iDetailedInformationDao.selectProjectRequirement(projectRequirement);
    }

    /**
     * 查看创意人才信息
     * @param talentRequirement 创意人才
     * @return 创意人才信息
     */
    @Override
    public TalentRequirement selectTalentRequirement(TalentRequirement talentRequirement) throws Exception {
        return iDetailedInformationDao.selectTalentRequirement(talentRequirement);
    }
    
    /**
     * 查看创意人才信息
     * @param talentRequirement 创意人才
     * @return 创意人才信息
     */
    @Override
    public TalentRequirement selectTalentRequirement2(TalentRequirement talentRequirement) throws Exception {
        return iDetailedInformationDao.selectTalentRequirement2(talentRequirement);
    }

    /**
     * 查创意人才的详细信息
     * @param userCreativeTalent
     * @return
     * @throws Exception
     */
	@Override
	public UserCreativeTalent selectUserCreativeTalent(UserCreativeTalent userCreativeTalent) throws Exception {
		return iDetailedInformationDao.selectUserCreativeTalent(userCreativeTalent.getCreativeTalentId());
	}
	 /**
     * 查询项目名
     * @param projectUserReleation
     * @return
     * @throws Exception
     */
	@Override
	public ProjectUserReleation selectProjectUserReleation(ProjectUserReleation projectUserReleation) throws Exception {
		return iDetailedInformationDao.selectProjectUserReleation(projectUserReleation);
	}

	 /**
     * 点击招募按钮时添加到项目用户关系表中
     * @param projectUserReleation
     * @return
     * @throws Exception
     */
	@Transactional
	@Override
	public boolean insertProjectUserReleation(ProjectUserReleation projectUserReleation) throws Exception {
	    logger.debug("点击招募按钮时添加到项目用户关系表中");
	    int count = iDetailedInformationDao.insertProjectUserReleation(projectUserReleation);
		if (0 == count) {
			return false;
		}
		return true;
	}

	/**
     * 查询创意人才的详细信息
     * @param getTalents 创意人才
     * @return 创意人才的详细信息
     */
    @Override
    public GetTalents selectGetTalents(GetTalents getTalents) throws Exception {
        return iDetailedInformationDao.selectGetTalents(getTalents);
    }

    /**
     * 查看创意需求信息和进度
     * @param projectRequirement 创意需求信息
     * @return 创意需求信息
     */
    @Override
    public ProjectRequirementDetails selectProjectRequirementDetails2(
            ProjectRequirementDetails projectRequirementDetails) throws Exception {
        return iDetailedInformationDao.selectProjectRequirementDetails2(projectRequirementDetails);
    }

}
