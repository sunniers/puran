/**
 * User.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * 前台用户
 */
public class User {

    /** 用户id */
    private Long userId;
    
    /** 公司id */
    private Long companyId;
    /** 公司名称 */
    private String companyName;
    
    /** 用户昵称 */
    private String userAlias;
    
    /** 用户名称 */
    private String userName;
    
    /** 用户类型 */
    private String userType;
    
    /** 用户头像 */
    private String userHeaderImg;
    
    /** 用户密码 */
    private String userPwd;
    
    /**  */
    private String userMobile;
    
    /**  */
    private String userEmail;
    
    /**  */
    private Timestamp createDatetime;
    
    /**  */
    private Byte active;
    
    /** 是否已经进行身份认证 */
    private Byte isAuthentication;
    
    /** 是否激活 */
    private Byte isActivation;
    
    /** 登录是否成功 */
    private boolean success;
    
	/**  */
    private String createDatetimeMapping;
    
    /** 新密码 */
    private String newUserPwd;
    
    /** 教育经历 */
    private TalentEduExperience talentEduExperience;
    
    /** 工作经验 */
    private List<TalentWorkExperience> talentWorkExperiences;
    
    /** 验证信息 */
    private String sid;
    
    /** 目前所属项目名称 */
    private String projectName;
    
    /** 完成度 */
    private String completion;
    
    /** 创意人才 */
    private UserCreativeTalent userCreativeTalent;
    
    /** 真实姓名 */
    private String realName;
    
    /** 身份证号码 */
    private String code;
    /**我的圈子ID*/
    private Long communityId;
    
    /** page */
    private Integer page;
    
    /** pageSize */
    private Integer pageSize;

    public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeaderImg() {
        return userHeaderImg;
    }

    public void setUserHeaderImg(String userHeaderImg) {
        this.userHeaderImg = userHeaderImg;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getNewUserPwd() {
        return newUserPwd;
    }

    public void setNewUserPwd(String newUserPwd) {
        this.newUserPwd = newUserPwd;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public TalentEduExperience getTalentEduExperience() {
        return talentEduExperience;
    }

    public void setTalentEduExperience(TalentEduExperience talentEduExperience) {
        this.talentEduExperience = talentEduExperience;
    }

    public List<TalentWorkExperience> getTalentWorkExperiences() {
        return talentWorkExperiences;
    }

    public void setTalentWorkExperiences(List<TalentWorkExperience> talentWorkExperiences) {
        this.talentWorkExperiences = talentWorkExperiences;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Byte getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Byte isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }

    public UserCreativeTalent getUserCreativeTalent() {
        return userCreativeTalent;
    }

    public void setUserCreativeTalent(UserCreativeTalent userCreativeTalent) {
        this.userCreativeTalent = userCreativeTalent;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Byte getIsActivation() {
        return isActivation;
    }

    public void setIsActivation(Byte isActivation) {
        this.isActivation = isActivation;
    }

    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getCreateDatetimeMapping() {
        return createDatetimeMapping;
    }

    public void setCreateDatetimeMapping(String createDatetimeMapping) {
        this.createDatetimeMapping = createDatetimeMapping;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
