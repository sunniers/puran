/**
 * DetailedInformationServiceImpl.java
 * Created at 2016-11-06
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 创意需求详细信息
 */
public class ProjectRequirementDetails {

    /** 创意需求ID */
    private Long projId;
    
    /** 状态 */
    private String statusName;
    
    /** 创意需求名称 */
    private String projName;
    
    /** 创意需求描述 */
    private String projRequireDescriptionContent;
    
    /** 创意需求发布人 */
    private String userAlias;
    
    /** 公司ID */
    private Long companyId;
    
    /** 用户手机 */
    private String userMobile;
    
    /** 是否进行身份认证 */
    private Byte isAuthentication;
    
    /** 公司名称 */
    private String companyName;
    
    /** 报名人数 */
    private Integer enrollCount;
    
    /** 发布时间 */
    private Timestamp auditDatetime;
    
    /** 项目酬金 */
    private Double projServiceFee;
    
    /** 酬金是否已托管 */
    private Byte isFeeTrusteeship;
    
    /** 项目附件 */
    private String projAttachFile;
    
    /** 项目评论 */
    private List<ProjectEvaluate> projectEvaluates;
    
    /** 用户ID */
    private Long userId;
    
    /** 报名结束时间 */
    private Date projColseDate;
    
    /** 筛选截止时间 */
    private Date finishDate;
    
    /** 实施时间 */
    private Timestamp undertakeDatetime;
    
    /** 是否已收藏 */
    private Integer isHouse;
    
    /** 是否已报名 */
    private Integer isEnroll;
    
    /** 是否为本人发布的项目 */
    private Integer isMy;

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjRequireDescriptionContent() {
        return projRequireDescriptionContent;
    }

    public void setProjRequireDescriptionContent(String projRequireDescriptionContent) {
        this.projRequireDescriptionContent = projRequireDescriptionContent;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Byte getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Byte isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEnrollCount() {
        return enrollCount;
    }

    public void setEnrollCount(Integer enrollCount) {
        this.enrollCount = enrollCount;
    }

    public Timestamp getAuditDatetime() {
        return auditDatetime;
    }

    public void setAuditDatetime(Timestamp auditDatetime) {
        this.auditDatetime = auditDatetime;
    }

    public Double getProjServiceFee() {
        return projServiceFee;
    }

    public void setProjServiceFee(Double projServiceFee) {
        this.projServiceFee = projServiceFee;
    }

    public Byte getIsFeeTrusteeship() {
        return isFeeTrusteeship;
    }

    public void setIsFeeTrusteeship(Byte isFeeTrusteeship) {
        this.isFeeTrusteeship = isFeeTrusteeship;
    }

    public String getProjAttachFile() {
        return projAttachFile;
    }

    public void setProjAttachFile(String projAttachFile) {
        this.projAttachFile = projAttachFile;
    }

    public List<ProjectEvaluate> getProjectEvaluates() {
        return projectEvaluates;
    }

    public void setProjectEvaluates(List<ProjectEvaluate> projectEvaluates) {
        this.projectEvaluates = projectEvaluates;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getProjColseDate() {
        return projColseDate;
    }

    public void setProjColseDate(Date projColseDate) {
        this.projColseDate = projColseDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Timestamp getUndertakeDatetime() {
        return undertakeDatetime;
    }

    public void setUndertakeDatetime(Timestamp undertakeDatetime) {
        this.undertakeDatetime = undertakeDatetime;
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

    public Integer getIsMy() {
        return isMy;
    }

    public void setIsMy(Integer isMy) {
        this.isMy = isMy;
    }
    
}
