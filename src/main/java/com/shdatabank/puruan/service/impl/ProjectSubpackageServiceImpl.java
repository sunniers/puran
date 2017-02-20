/**
 * ProjectSubpackageServiceImpl.java
 * Created at 2016-11-06
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shdatabank.puruan.dao.IProjectSubpackageDao;
import com.shdatabank.puruan.dao.RequirementCommitDao;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.service.IProjectSubpackageService;

/**
 * 项目分包service层
 */
@Service
public class ProjectSubpackageServiceImpl implements IProjectSubpackageService {
    
    private Logger logger =Logger.getLogger(ProjectSubpackageServiceImpl.class);
    
    /**项目需求Dao注入 */
    @Autowired
    private RequirementCommitDao requirementCommitDao;
    
    /** 项目分包dao */
    @Autowired
    private IProjectSubpackageDao iProjectSubpackageDao;
    
    /**
     * 插入项目分包信息
     * @param projectSubpackage 分包信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertProjectSubpackage(ProjectRequirement projectRequirement) throws Exception {
        logger.debug("插入项目分包信息");
        if (null == projectRequirement) {
            return false;
        }
        int count = requirementCommitDao.insertPrRequirement(projectRequirement);
        if (0 == count) {
            return false;
        }

        if(null != projectRequirement.getProjectRequirementClasss()){
            //将创意需求的ID存入创意需求类中需求ID中
            for (int i = 0; i < projectRequirement.getProjectRequirementClasss().size(); i++) {
                projectRequirement.getProjectRequirementClasss().get(i).setProjRequireId(projectRequirement.getProjId());
            }
            count =requirementCommitDao.insertRequirementType(projectRequirement.getProjectRequirementClasss());
             //判断是否插入成功
            if (0 == count) {
                return false;
            }
        }
        if(null != projectRequirement.getProjRequireDescriptions()){
            //将创意需求的ID存入创意需求描述中需求ID中
            for (int i = 0; i < projectRequirement.getProjRequireDescriptions().size(); i++) {
                projectRequirement.getProjRequireDescriptions().get(i).setProjRequireId(projectRequirement.getProjId());
            }
            count =requirementCommitDao.insertRequirementDescription(projectRequirement.getProjRequireDescriptions());
            //判断是否插入成功
            if (0 == count) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * 查询分包信息
     * @param projectRequirement 需求信息
     * @return 需求信息
     */
    @Override
    public ProjectRequirement selectProjectSubpackage(ProjectRequirement projectRequirement) throws Exception {
        return iProjectSubpackageDao.selectProjectSubpackage(projectRequirement);
    }

}
