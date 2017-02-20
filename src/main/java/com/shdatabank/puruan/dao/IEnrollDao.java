/**
 * IEnrollDao.java
 * Created at 2016-11-15
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import com.shdatabank.puruan.model.ProjectEnroll;
import com.shdatabank.puruan.model.TalentEnroll;

/**
 * 报名dao层
 */
public interface IEnrollDao {
    
    /**
     * 插入报名信息
     * @param projectEnroll 报名信息
     * @return 是否成功
     */
    public int insertProjectEnroll(ProjectEnroll projectEnroll) throws Exception;
    
    /**
     * 删除报名信息
     * @param projectEnroll 报名信息
     * @return 是否成功
     */
    public int deleteProjectEnroll(ProjectEnroll projectEnroll) throws Exception;
    
    /**
     * 插入人才需求报名信息
     * @param talentEnroll 报名信息
     * @return 是否成功
     */
    public int insertTalentEnroll(TalentEnroll talentEnroll) throws Exception;
    
    /**
     * 删除人才需求报名信息
     * @param talentEnroll 报名信息
     * @return 是否成功
     */
    public int deleteTalentEnroll(TalentEnroll talentEnroll) throws Exception;
    
}
