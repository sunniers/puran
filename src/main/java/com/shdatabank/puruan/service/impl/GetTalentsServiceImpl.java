/**
 * GetTalentsServiceImpl.java
 * Created at 2016-11-22
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.IGetTalentsDao;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.GetTalents;
import com.shdatabank.puruan.service.IGetTalentsService;

/**
 * 创意人才service层
 */
@Service
public class GetTalentsServiceImpl implements IGetTalentsService{

    /** 创意人才dao */
    @Autowired
    private IGetTalentsDao iGetTalentsDao;
    
    /**
     * 查询分类
     * @return 分类
     */
    @Override
    public List<Dictionary> selectDictionary() throws Exception {
        return iGetTalentsDao.selectDictionary();
    }

    /**
     * 查询创意人才
     * @return 需求
     */
    @Override
    public PageInfo<GetTalents> selectGetTalents(GetTalents getTalents) throws Exception {
        PageHelper.startPage(getTalents.getPage(), getTalents.getPageSize());
        return new PageInfo<GetTalents> (iGetTalentsDao.selectGetTalents(getTalents));
    }

}
