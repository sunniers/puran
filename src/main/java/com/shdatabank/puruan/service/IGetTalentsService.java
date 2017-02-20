/**
 * IGetTalentsService.java
 * Created at 2016-11-22
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.GetTalents;

/**
 * 创意人才service层
 */
public interface IGetTalentsService {

    /**
     * 查询分类
     * @return 分类
     */
    public List<Dictionary> selectDictionary() throws Exception;
    
    /**
     * 查询创意人才
     * @return 需求
     */
    public PageInfo<GetTalents> selectGetTalents(GetTalents getTalents) throws Exception;
}