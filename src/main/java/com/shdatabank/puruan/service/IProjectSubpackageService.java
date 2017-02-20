/**
 * IProjectSubpackageService.java
 * Created at 2016-11-06
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.ProjectRequirement;

/**
 * 项目分包service层
 */
public interface IProjectSubpackageService {

    /**
     * 插入项目分包信息
     * @param projectSubpackage 分包信息
     * @return 是否成功
     */
    public boolean insertProjectSubpackage(ProjectRequirement projectRequirement) throws Exception;

    /**
     * 查询分包信息
     * @param projectRequirement 需求信息
     * @return 需求信息
     */
    public ProjectRequirement selectProjectSubpackage
        (ProjectRequirement projectRequirement) throws Exception;
}
