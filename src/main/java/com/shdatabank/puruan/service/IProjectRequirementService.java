/**
 * IProjectRequirement.java
 * Created at 2016-11-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.ProjectRequirement;

/**
 * 项目—需求service层
 */
public interface IProjectRequirementService {

    /**
     * 查询需求详细和需求分包
     * @param projId 需求ID
     * @return 需求详细和需求分包
     */
    public ProjectRequirement selectProjectRequirement(ProjectRequirement projectRequirement) throws Exception;
}
