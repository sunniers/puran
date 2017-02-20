/**
 * TalentRequirement.java
 * Created at 2016-11-5
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author guoqiankun 创意人才需求实体类
 *
 */
public class TalentRequirement {
	/** 创意人才需求ID */
	private Long talentRequirementId;
	/** 用户id */
	private Long userId;
	/** 需求名称 */
	private String talentRequirementName;
	/** 工作形式 */
	private Integer workMode;
	/** 专业技能 */
	private String professionalSkills;
	/** 薪酬 */
	private float talentBuget;
	/** 需求概述 */
	private String requirementDescription;
	/** 工作地点 */
	private String workSpace;
	/** 生效时间 */
	private Timestamp effectiveDatetime;
	/** 需求分类 */
	private String requirementClassifier;
	/** 合作类型 */
	private String cooperateType;
	/** 删除标志 */
	private Byte active;
	/** 需求状态 */
	private Integer requirementStatus;
	/** 工作职责 */
	private String workDuty;
	/** 人员要求 */
	private String talentRequire;
	/** 发布方式 */
	private String publishWay;
	/** 创建时间 */
	private Timestamp createTime;
	/**创意人才技能*/
	private List<TalentTechnology> talentTechnologies;
	/** 报名人数 */
	private Integer talentCount;
	/** 收藏次数 */
	private Integer houseCount;
	/** 用户名称 */
	private String userName;
	/** 是否认证 */
	private Integer isAuthentication;
	/** 手机号 */
	private String userMobile;
	/** 邮箱 */
	private String userEmail;
	/** 技能要求 */
	private String technologyRequirement;

	/** 页码 */
	private int page;
	/** 每页显示数量 */
	private int pageSize;
	/**区别保存于发布的标志：保存为0，发布为1*/
	private String flag;
	
	/** 是否已收藏 */
	private Integer isHouse;
	
	/** 是否已报名 */
	private Integer isEnroll;
	
	/** 人才需求附件名称 */
	private String talentAttachmentName;
	/** 人才附件路径 */
	private String talentAttachment;
	/** 人才需求附件预览路径 */
	private String talentAttachmentSeePath;
	
	/** 人才需求分类实体类 */
	private List<TalentRequirementClass> talentRequirementClasss;


	public String getTalentAttachmentName() {
		return talentAttachmentName;
	}

	public void setTalentAttachmentName(String talentAttachmentName) {
		this.talentAttachmentName = talentAttachmentName;
	}

	public String getTalentAttachmentSeePath() {
		return talentAttachmentSeePath;
	}

	public void setTalentAttachmentSeePath(String talentAttachmentSeePath) {
		this.talentAttachmentSeePath = talentAttachmentSeePath;
	}

	public List<TalentRequirementClass> getTalentRequirementClasss() {
		return talentRequirementClasss;
	}

	public void setTalentRequirementClasss(List<TalentRequirementClass> talentRequirementClasss) {
		this.talentRequirementClasss = talentRequirementClasss;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<TalentTechnology> getTalentTechnologies() {
		return talentTechnologies;
	}

	public void setTalentTechnologies(List<TalentTechnology> talentTechnologies) {
		this.talentTechnologies = talentTechnologies;
	}

	public Long getTalentRequirementId() {
		return talentRequirementId;
	}

	public void setTalentRequirementId(Long talentRequirementId) {
		this.talentRequirementId = talentRequirementId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTalentRequirementName() {
		return talentRequirementName;
	}

	public void setTalentRequirementName(String talentRequirementName) {
		this.talentRequirementName = talentRequirementName;
	}

	public Integer getWorkMode() {
		return workMode;
	}

	public void setWorkMode(Integer workMode) {
		this.workMode = workMode;
	}

	public String getProfessionalSkills() {
		return professionalSkills;
	}

	public void setProfessionalSkills(String professionalSkills) {
		this.professionalSkills = professionalSkills;
	}

	public float getTalentBuget() {
		return talentBuget;
	}

	public void setTalentBuget(float talentBuget) {
		this.talentBuget = talentBuget;
	}

	public String getRequirementDescription() {
		return requirementDescription;
	}

	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}

	public String getWorkSpace() {
		return workSpace;
	}

	public void setWorkSpace(String workSpace) {
		this.workSpace = workSpace;
	}

	public Timestamp getEffectiveDatetime() {
		return effectiveDatetime;
	}

	public void setEffectiveDatetime(Timestamp effectiveDatetime) {
		this.effectiveDatetime = effectiveDatetime;
	}

	public String getRequirementClassifier() {
		return requirementClassifier;
	}

	public void setRequirementClassifier(String requirementClassifier) {
		this.requirementClassifier = requirementClassifier;
	}

	public String getCooperateType() {
		return cooperateType;
	}

	public void setCooperateType(String cooperateType) {
		this.cooperateType = cooperateType;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Integer getRequirementStatus() {
		return requirementStatus;
	}

	public void setRequirementStatus(Integer requirementStatus) {
		this.requirementStatus = requirementStatus;
	}

	public String getTalentAttachment() {
		return talentAttachment;
	}

	public void setTalentAttachment(String talentAttachment) {
		this.talentAttachment = talentAttachment;
	}

	public String getWorkDuty() {
		return workDuty;
	}

	public void setWorkDuty(String workDuty) {
		this.workDuty = workDuty;
	}

	public String getTalentRequire() {
		return talentRequire;
	}

	public void setTalentRequire(String talentRequire) {
		this.talentRequire = talentRequire;
	}

	public String getPublishWay() {
		return publishWay;
	}

	public void setPublishWay(String publishWay) {
		this.publishWay = publishWay;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Integer isAuthentication) {
        this.isAuthentication = isAuthentication;
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

    public Integer getTalentCount() {
        return talentCount;
    }

    public void setTalentCount(Integer talentCount) {
        this.talentCount = talentCount;
    }

    public Integer getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(Integer houseCount) {
        this.houseCount = houseCount;
    }

    public String getTechnologyRequirement() {
        return technologyRequirement;
    }

    public void setTechnologyRequirement(String technologyRequirement) {
        this.technologyRequirement = technologyRequirement;
    }

    public Integer getIsHouse() {
        return isHouse;
    }

    public void setIsHouse(Integer isHouse) {
        this.isHouse = isHouse;
    }

    public Integer getIsEnroll() {
        return isEnroll;
    }

    public void setIsEnroll(Integer isEnroll) {
        this.isEnroll = isEnroll;
    }

}
