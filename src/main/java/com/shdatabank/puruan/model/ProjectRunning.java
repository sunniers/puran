/**
 * IIdentityAuthenticationDao.java
 * Created at 2016-11-20
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.util.List;

/**
 * 项目进度
 */
public class ProjectRunning {

    /** 项目计划进度 */
    private List<ProjectPlan> projectPlans;
    
    /** 项目调整进度 */
    private List<ProjectPlan> projectPlans2;
    
    /** 项目分包进度 */
    private List<ProjectRunning> projectRunnings;

    public List<ProjectPlan> getProjectPlans() {
        return projectPlans;
    }

    public void setProjectPlans(List<ProjectPlan> projectPlans) {
        this.projectPlans = projectPlans;
    }

    public List<ProjectPlan> getProjectPlans2() {
        return projectPlans2;
    }

    public void setProjectPlans2(List<ProjectPlan> projectPlans2) {
        this.projectPlans2 = projectPlans2;
    }

    public List<ProjectRunning> getProjectRunnings() {
        return projectRunnings;
    }

    public void setProjectRunnings(List<ProjectRunning> projectRunnings) {
        this.projectRunnings = projectRunnings;
    }
}
