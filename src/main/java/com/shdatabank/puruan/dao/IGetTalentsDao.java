/**
 * GetRequirementDao.java
 * Created at 2016-10-25
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.GetTalents;

/**
 * 创意人才dao层
 */
public interface IGetTalentsDao {
    
    /**
     * 查询分类
     * @return 分类
     */
    public List<Dictionary> selectDictionary() throws Exception;

    /**
     * 查询创意人才
     * @return 需求
     */
    public List<GetTalents> selectGetTalents(GetTalents getTalents) throws Exception;
}
