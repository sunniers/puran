/**
 * IGetRequirementService.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.ProjectRequirement;

/**
 * 需求大厅service层
 */
public interface IGetRequirementService {

    /**
     * 查询分类
     * @return 分类
     */
    public List<Dictionary> selectDictionary() throws Exception;

    /**
     * 查询需求
     * @return 需求
     */
    public PageInfo<ProjectRequirement> selectRequirement(ProjectRequirement projectRequirement) throws Exception;
}
