/**
 * ProjectRequirement.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 创意需求实体类
 */
public class ProjectRequirement {

	/** 创意需求ID */
	private Long projId;

	/** 父创意需求ID */
	private Long parentProjId;
	/** 父创意需求名称 */
	private String parentProjName;

	/** 创意需求发布人ID */
	private Long publishUserId;
	private String publishUser;

	/** 项目名称 */
	private String projName;

	/** 报名开始日期 */
	private Date projStartDate;

	/** 项目截至日期 */
	private Date projCloseDate;

	/** 项目交付日期 */
	private Date projDevlierDate;

	/** 项目评估周期 */
	private Integer projEstimate;
	
	/** 附件名称 */
	private String projFileName;

	/** 项目附件 */
	private String projAttachFile;
	
	/** 预览地址 */
	private String projSeeFilePath;

	/** 项目酬金 */
	private BigDecimal projServiceFee;

	/** 项目负责人 */
	private Long managerUserId;
	private String managerUser;

	/** 币种 */
	private String projFeeCurrency;

	/** 创意需求分类 */
	private String requirementType;
	private List<ProjectRequirementClass> projectRequirementClasss;
	/** 创意需求描述 */
	private List<ProjRequireDescription> projRequireDescriptions;

	/** 创意需求状态 */
	private Integer projFlowStatus;
	/**创意需求报名状态*/
	private Integer projEnrollStatus;
	private String projEnrollStatusValue;

	/** 删除标准 */
	private Byte active;

	/** 是否为项目 */
	private Byte isProject;

	/** 创建时间 */
	private Timestamp createDatetime;
	/** 供方类型 */
	private String providerType;
	/** 认证要求 */
	private String authenticationRequirement;
	/** 发布方式 */
	private String publishWay;

	/** 身份认证 */
	private Integer authentication;
	
	/** 邮件认证 */
	private String userEmail;
	
	/** 手机认证 */
	private String userMobile;
	
	/** 项目截至日期映射 */
	private String projCloseDateMapping;

	/** 项目交付日期映射 */
	private String projDevlierDateMapping;

	/** 创建时间映射 */
	private String createDatetimeMapping;

	/** 进行中项目 */
	private Integer runningProj;

	/** 发布的项目 */
	private Integer releaseProj;

	/** 参与的项目 */
	private Integer takeProj;

	/** 报名人数 */
	private Integer userCount;
	
	/** 收藏人数 */
	private Integer userHouse;

	/** 排序方法 */
	private String orderBys;
	private String ascs;

	/** 查询类型 */
	private List<Integer> dictionarydatas;

	/** 返回类型 */
	private List<Dictionarydata> dictionarydatass;

	/** 项目描述 */
	private String projRequireDescriptionContent;

	/** 查询条件 */
	private String name;

	/** 需求分类 */
	private String projType1;

	/** 需求类型 */
	private List<Integer> projType2;

	/** 用户id */
	private Long userId;

	/** page */
	private Integer page;

	/** pageSize */
	private Integer pageSize;

	/** 新成员名称 */
	private String member;

	/** 项目计划名称 */
	private String projPlanTaskName;
	/**区别保存于发布的标志：保存为0，发布为1*/
	private String flag;
	
	/** 创意需求分包 */
    private List<ProjectRequirement> projectRequirements;
	
    /**  */
    private Double minFee;
    
    /**  */
    private Double maxFee;
    
    /** 项目结束时间 */
    private Date projectRealEndDate;
    
    /** 是否已评论 */
    private Integer isEvaluate;
    
    /** 发布时间 */
    private Date auditDatetime;
    
    /** 筛选结束时间 */
    private Date finishDate;
    
    /** 成交时间 */
    private Date undertakeDatetime;
    
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<ProjRequireDescription> getProjRequireDescriptions() {
		return projRequireDescriptions;
	}

	public void setProjRequireDescriptions(List<ProjRequireDescription> projRequireDescriptions) {
		this.projRequireDescriptions = projRequireDescriptions;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

	public Long getParentProjId() {
		return parentProjId;
	}

	public void setParentProjId(Long parentProjId) {
		this.parentProjId = parentProjId;
	}

	public Integer getProjEnrollStatus() {
		return projEnrollStatus;
	}

	public void setProjEnrollStatus(Integer projEnrollStatus) {
		this.projEnrollStatus = projEnrollStatus;
	}

	public String getProviderType() {
		return providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}

	public String getAuthenticationRequirement() {
		return authenticationRequirement;
	}

	public void setAuthenticationRequirement(String authenticationRequirement) {
		this.authenticationRequirement = authenticationRequirement;
	}

	public String getPublishWay() {
		return publishWay;
	}

	public void setPublishWay(String publishWay) {
		this.publishWay = publishWay;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Date getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}

	public Date getProjCloseDate() {
		return projCloseDate;
	}

	public void setProjCloseDate(Date projCloseDate) {
		this.projCloseDate = projCloseDate;
	}

	public Date getProjDevlierDate() {
		return projDevlierDate;
	}

	public void setProjDevlierDate(Date projDevlierDate) {
		this.projDevlierDate = projDevlierDate;
	}

	public Integer getProjEstimate() {
		return projEstimate;
	}

	public void setProjEstimate(Integer projEstimate) {
		this.projEstimate = projEstimate;
	}

	public String getProjAttachFile() {
		return projAttachFile;
	}

	public void setProjAttachFile(String projAttachFile) {
		this.projAttachFile = projAttachFile;
	}
	
	public String getProjFeeCurrency() {
		return projFeeCurrency;
	}

	public void setProjFeeCurrency(String projFeeCurrency) {
		this.projFeeCurrency = projFeeCurrency;
	}
	public Integer getProjFlowStatus() {
		return projFlowStatus;
	}

	public void setProjFlowStatus(Integer projFlowStatus) {
		this.projFlowStatus = projFlowStatus;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getProjCloseDateMapping() {
		return projCloseDateMapping;
	}

	public void setProjCloseDateMapping(String projCloseDateMapping) {
		this.projCloseDateMapping = projCloseDateMapping;
	}

	public String getProjDevlierDateMapping() {
		return projDevlierDateMapping;
	}

	public void setProjDevlierDateMapping(String projDevlierDateMapping) {
		this.projDevlierDateMapping = projDevlierDateMapping;
	}

	public String getCreateDatetimeMapping() {
		return createDatetimeMapping;
	}

	public void setCreateDatetimeMapping(String createDatetimeMapping) {
		this.createDatetimeMapping = createDatetimeMapping;
	}

	public Long getPublishUserId() {
		return publishUserId;
	}

	public void setPublishUserId(Long publishUserId) {
		this.publishUserId = publishUserId;
	}

	public Long getManagerUserId() {
		return managerUserId;
	}

	public void setManagerUserId(Long managerUserId) {
		this.managerUserId = managerUserId;
	}

	public Integer getRunningProj() {
		return runningProj;
	}

	public void setRunningProj(Integer runningProj) {
		this.runningProj = runningProj;
	}

	public Integer getReleaseProj() {
		return releaseProj;
	}

	public void setReleaseProj(Integer releaseProj) {
		this.releaseProj = releaseProj;
	}

	public Integer getTakeProj() {
		return takeProj;
	}

	public void setTakeProj(Integer takeProj) {
		this.takeProj = takeProj;
	}

	public Byte getIsProject() {
		return isProject;
	}

	public void setIsProject(Byte isProject) {
		this.isProject = isProject;
	}

	public Byte getActive() {
		return active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public String getProjRequireDescriptionContent() {
		return projRequireDescriptionContent;
	}

	public void setProjRequireDescriptionContent(String projRequireDescriptionContent) {
		this.projRequireDescriptionContent = projRequireDescriptionContent;
	}

	public String getProjType1() {
		return projType1;
	}

	public void setProjType1(String projType1) {
		this.projType1 = projType1;
	}

	public List<Integer> getDictionarydatas() {
		return dictionarydatas;
	}

	public void setDictionarydatas(List<Integer> dictionarydatas) {
		this.dictionarydatas = dictionarydatas;
	}

	public String getOrderBys() {
		return orderBys;
	}

	public void setOrderBys(String orderBys) {
		this.orderBys = orderBys;
	}

	public String getAscs() {
		return ascs;
	}

	public void setAscs(String ascs) {
		this.ascs = ascs;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getPublishUser() {
		return publishUser;
	}

	public void setPublishUser(String publishUser) {
		this.publishUser = publishUser;
	}

	public String getManagerUser() {
		return managerUser;
	}

	public void setManagerUser(String managerUser) {
		this.managerUser = managerUser;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getProjPlanTaskName() {
		return projPlanTaskName;
	}

	public void setProjPlanTaskName(String projPlanTaskName) {
		this.projPlanTaskName = projPlanTaskName;
	}

	public List<Dictionarydata> getDictionarydatass() {
		return dictionarydatass;
	}

	public void setDictionarydatass(List<Dictionarydata> dictionarydatass) {
		this.dictionarydatass = dictionarydatass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public List<ProjectRequirementClass> getProjectRequirementClasss() {
		return projectRequirementClasss;
	}

	public void setProjectRequirementClasss(List<ProjectRequirementClass> projectRequirementClasss) {
		this.projectRequirementClasss = projectRequirementClasss;
	}

	public String getParentProjName() {
        return parentProjName;
    }

    public void setParentProjName(String parentProjName) {
        this.parentProjName = parentProjName;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getProjEnrollStatusValue() {
        return projEnrollStatusValue;
    }

    public void setProjEnrollStatusValue(String projEnrollStatusValue) {
        this.projEnrollStatusValue = projEnrollStatusValue;
    }

    public List<ProjectRequirement> getProjectRequirements() {
        return projectRequirements;
    }

    public void setProjectRequirements(List<ProjectRequirement> projectRequirements) {
        this.projectRequirements = projectRequirements;
    }

    public Integer getUserHouse() {
        return userHouse;
    }

    public void setUserHouse(Integer userHouse) {
        this.userHouse = userHouse;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Double getMinFee() {
        return minFee;
    }

    public void setMinFee(Double minFee) {
        this.minFee = minFee;
    }

    public Double getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(Double maxFee) {
        this.maxFee = maxFee;
    }

    public List<Integer> getProjType2() {
        return projType2;
    }

    public void setProjType2(List<Integer> projType2) {
        this.projType2 = projType2;
    }

    public BigDecimal getProjServiceFee() {
        return projServiceFee;
    }

    public void setProjServiceFee(BigDecimal projServiceFee) {
        this.projServiceFee = projServiceFee;
    }

    public Date getProjectRealEndDate() {
        return projectRealEndDate;
    }

    public void setProjectRealEndDate(Date projectRealEndDate) {
        this.projectRealEndDate = projectRealEndDate;
    }

    public Integer getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(Integer isEvaluate) {
        this.isEvaluate = isEvaluate;
    }

    public String getProjFileName() {
        return projFileName;
    }

    public void setProjFileName(String projFileName) {
        this.projFileName = projFileName;
    }

    public Date getAuditDatetime() {
        return auditDatetime;
    }

    public void setAuditDatetime(Date auditDatetime) {
        this.auditDatetime = auditDatetime;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getUndertakeDatetime() {
        return undertakeDatetime;
    }

    public void setUndertakeDatetime(Date undertakeDatetime) {
        this.undertakeDatetime = undertakeDatetime;
    }

    public String getProjSeeFilePath() {
        return projSeeFilePath;
    }

    public void setProjSeeFilePath(String projSeeFilePath) {
        this.projSeeFilePath = projSeeFilePath;
    }

}
