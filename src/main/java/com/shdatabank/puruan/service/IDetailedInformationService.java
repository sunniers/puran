/**
 * IDetailedInformationService.java
 * Created at 2016-10-29
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.GetTalents;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementDetails;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.model.UserInformation;

/**
 * 各种详细信息service层
 */
public interface IDetailedInformationService {

    /**
     * 查询用户的信息
     * @param userInformation 用户信息
     * @return 用户信息
     */
    public UserInformation selectUserInformation(UserInformation userInformation) throws Exception;
    
    /**
     * 查看创意需求信息和进度
     * @param projectRequirement 创意需求信息
     * @return 创意需求信息
     */
    public ProjectRequirementDetails selectProjectRequirementDetails(ProjectRequirementDetails projectRequirementDetails) throws Exception;

    /**
     * 查看创意人才信息
     * @param talentRequirement 创意人才
     * @return 创意人才信息
     */
    public TalentRequirement selectTalentRequirement(TalentRequirement talentRequirement) throws Exception;
    
    /**
     * 查看创意人才信息
     * @param talentRequirement 创意人才
     * @return 创意人才信息
     */
    public TalentRequirement selectTalentRequirement2(TalentRequirement talentRequirement) throws Exception;
    
    /**
     * 查询需要修改的创意需求的信息
     * @param ProjectRequirement 创意需求信息
     * @return 创意需求信息
     */
    public ProjectRequirement selectModifyProjectRequirement(ProjectRequirement ProjectRequirement) throws Exception;
    
    /**
     * 查创意需求的详细信息
     * @param projectRequirement 创意需求信息
     * @return 创意需求信息
     */
    public ProjectRequirement selectProjectRequirement(ProjectRequirement projectRequirement) throws Exception;
    /**
     * 查创意人才的详细信息
     * @param userCreativeTalent
     * @return
     * @throws Exception
     */
    public UserCreativeTalent selectUserCreativeTalent(UserCreativeTalent userCreativeTalent) throws Exception;
    /**
     * 查询项目名
     * @param projectUserReleation
     * @return
     * @throws Exception
     */
    public ProjectUserReleation selectProjectUserReleation(ProjectUserReleation projectUserReleation) throws Exception;
    /**
     * 点击招募按钮时添加到项目用户关系表中
     * @param projectUserReleation
     * @return
     * @throws Exception
     */
    public boolean insertProjectUserReleation (ProjectUserReleation projectUserReleation) throws Exception;
    
    /**
     * 查询创意人才的详细信息
     * @param getTalents 创意人才
     * @return 创意人才的详细信息
     */
    public GetTalents selectGetTalents(GetTalents getTalents) throws Exception;
    
    /**
     * 后台查看创意需求信息和进度
     * @param projectRequirement 创意需求信息
     * @return 创意需求信息
     */
    public ProjectRequirementDetails selectProjectRequirementDetails2(ProjectRequirementDetails projectRequirementDetails) throws Exception;
    
}
