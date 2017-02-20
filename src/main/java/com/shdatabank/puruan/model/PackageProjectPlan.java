/**
 * PackageProjectPlan.java
 * Created at 2016-11-07
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.util.List;

/**
 * 项目分包计划
 */
public class PackageProjectPlan {

    /** 分包ID */
    private Long projId;
    
    /** 分包名次 */
    private String projName;
    
    /** 分包计划 */
    private List<ProjectPlan> ProjectPlans;

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public List<ProjectPlan> getProjectPlans() {
        return ProjectPlans;
    }

    public void setProjectPlans(List<ProjectPlan> projectPlans) {
        ProjectPlans = projectPlans;
    }
}
