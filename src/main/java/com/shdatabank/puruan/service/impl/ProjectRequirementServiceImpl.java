/**
 * ProjectRequirementServiceImpl.java
 * Created at 2016-11-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shdatabank.puruan.dao.IProjectRequirementDao;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.service.IProjectRequirementService;

/**
 * 项目—需求service层
 */
@Service
public class ProjectRequirementServiceImpl implements IProjectRequirementService{

    /** 项目—需求dao */
    @Autowired
    private IProjectRequirementDao iProjectRequirementDao;
    
    /**
     * 查询需求详细和需求分包
     * @param projId 需求ID
     * @return 需求详细和需求分包
     */
    @Override
    public ProjectRequirement selectProjectRequirement(ProjectRequirement projectRequirement) throws Exception {
        return iProjectRequirementDao.selectProjectRequirement(projectRequirement);
    }

}
