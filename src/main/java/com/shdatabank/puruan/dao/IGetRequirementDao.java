/**
 * GetRequirementDao.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.ProjectRequirement;

/**
 * 需求大厅dao层
 */
public interface IGetRequirementDao {
    
    /**
     * 查询分类
     * @return 分类
     */
    public List<Dictionary> selectDictionary() throws Exception;

    /**
     * 查询需求
     * @return 需求
     */
    public List<ProjectRequirement> selectRequirement(ProjectRequirement projectRequirement) throws Exception;
}
