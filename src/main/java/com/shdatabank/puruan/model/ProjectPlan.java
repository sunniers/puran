/**
 * ProjectPlan.java
 * Created at 2016-11-07
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.util.Date;
import java.util.List;

/**
 * 计划
 */
public class ProjectPlan {

    /** 计划ID */
    private Long projPlanId;
    
    /** 项目ID */
    private Long projId;
    
    /** 计划父ID */
    private Long parentId;
    
    /** 计划名称 */
    private String projPlanName;
    
    /** 计划实施者 */
    private Long planExecutant;
    private String planExecutantName;
    
    /** 父计划序号 */
    private Integer parentPlanId;
    private String parentProjPlanName;
    
    /** 项目工作周期 */
    private Integer planWorkRange;
    
    /** 计划开始时间 */
    private Date planStartDate;
    
    /** 计划结束时间 */
    private Date planFinishDate;
    
    /** 计划实际开始时间 */
    private Date planRealStartDate;
    
    /** 计划实际结束时间 */
    private Date planRealFinishDate;
    
    /** 计划状态 */
    private Integer planStatus;
    private String planStatusValue;
    
    /** 计划内容 */
    private String planContent;
    
    /** 删除标志 */
    private Byte active;
    
    /** page */
    private Integer page;
    
    /** pageSize */
    private Integer pageSize;
    
    /** 子计划 */
    private List<ProjectPlan> projectPlans;
    
    /** 任务对象*/
    private ProjectPlanTask projectPlanTask;
    
    /** 是否可以修改 */
    private Integer isChange;
    
    public ProjectPlanTask getProjectPlanTask() {
		return projectPlanTask;
	}

	public void setProjectPlanTask(ProjectPlanTask projectPlanTask) {
		this.projectPlanTask = projectPlanTask;
	}

	public Long getProjPlanId() {
        return projPlanId;
    }

    public void setProjPlanId(Long projPlanId) {
        this.projPlanId = projPlanId;
    }

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getProjPlanName() {
        return projPlanName;
    }

    public void setProjPlanName(String projPlanName) {
        this.projPlanName = projPlanName;
    }

    public Integer getPlanWorkRange() {
        return planWorkRange;
    }

    public void setPlanWorkRange(Integer planWorkRange) {
        this.planWorkRange = planWorkRange;
    }

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getPlanFinishDate() {
        return planFinishDate;
    }

    public void setPlanFinishDate(Date planFinishDate) {
        this.planFinishDate = planFinishDate;
    }

    public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
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

    public List<ProjectPlan> getProjectPlans() {
        return projectPlans;
    }

    public void setProjectPlans(List<ProjectPlan> projectPlans) {
        this.projectPlans = projectPlans;
    }

    public Long getPlanExecutant() {
        return planExecutant;
    }

    public void setPlanExecutant(Long planExecutant) {
        this.planExecutant = planExecutant;
    }

    public Date getPlanRealStartDate() {
        return planRealStartDate;
    }

    public void setPlanRealStartDate(Date planRealStartDate) {
        this.planRealStartDate = planRealStartDate;
    }

    public Date getPlanRealFinishDate() {
        return planRealFinishDate;
    }

    public void setPlanRealFinishDate(Date planRealFinishDate) {
        this.planRealFinishDate = planRealFinishDate;
    }

    public Integer getParentPlanId() {
        return parentPlanId;
    }

    public void setParentPlanId(Integer parentPlanId) {
        this.parentPlanId = parentPlanId;
    }

    public String getParentProjPlanName() {
        return parentProjPlanName;
    }

    public void setParentProjPlanName(String parentProjPlanName) {
        this.parentProjPlanName = parentProjPlanName;
    }

    public String getPlanStatusValue() {
        return planStatusValue;
    }

    public void setPlanStatusValue(String planStatusValue) {
        this.planStatusValue = planStatusValue;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    public Integer getIsChange() {
        return isChange;
    }

    public void setIsChange(Integer isChange) {
        this.isChange = isChange;
    }

    public String getPlanExecutantName() {
        return planExecutantName;
    }

    public void setPlanExecutantName(String planExecutantName) {
        this.planExecutantName = planExecutantName;
    }

}
