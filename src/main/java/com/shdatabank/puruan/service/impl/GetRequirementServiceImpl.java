/**
 * GetRequirementServiceImpl.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.IGetRequirementDao;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.service.IGetRequirementService;

/**
 * 需求大厅service层
 */
@Service
public class GetRequirementServiceImpl implements IGetRequirementService {

    /** 需求大厅dao */
    @Autowired
    private IGetRequirementDao iGetRequirementDao;
    
    /**
     * 查询字典数据
     * @param dictionary 数据字典
     * @return 返回字典数据结果集
     */
    @Override
    public List<Dictionary> selectDictionary() throws Exception {
        return iGetRequirementDao.selectDictionary();
    }

    /**
     * 查询需求
     * @param projectRequirement 查询条件
     * @return 需求
     */
    @Override
    public PageInfo<ProjectRequirement> selectRequirement(ProjectRequirement projectRequirement) throws Exception {
        PageHelper.startPage(projectRequirement.getPage(), projectRequirement.getPageSize());
        return new PageInfo<ProjectRequirement> (iGetRequirementDao.selectRequirement(projectRequirement));
    }

}
