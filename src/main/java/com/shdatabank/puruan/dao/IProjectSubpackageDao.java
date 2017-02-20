/**
 * ProjectSubpackageServiceImpl.java
 * Created at 2016-11-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import com.shdatabank.puruan.model.ProjectRequirement;

/**
 * 项目分包dao层
 */
public interface IProjectSubpackageDao {

    /**
     * 查询分包信息
     * @param projectRequirement 需求信息
     * @return 需求信息
     */
    public ProjectRequirement selectProjectSubpackage
        (ProjectRequirement projectRequirement) throws Exception;
}
