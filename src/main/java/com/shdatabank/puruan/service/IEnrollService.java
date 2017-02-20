/**
 * IEnrollService.java
 * Created at 2016-11-15
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.ProjectEnroll;
import com.shdatabank.puruan.model.TalentEnroll;

/**
 * 报名service层
 */
public interface IEnrollService {
    
    /**
     * 插入报名信息
     * @param projectEnroll 报名信息
     * @return 是否成功
     */
    public boolean insertProjectEnroll(ProjectEnroll projectEnroll) throws Exception;
    
    /**
     * 删除报名信息
     * @param projectEnroll 报名信息
     * @return 是否成功
     */
    public boolean deleteProjectEnroll(ProjectEnroll projectEnroll) throws Exception;
    
    /**
     * 插入人才需求报名信息
     * @param talentEnroll 报名信息
     * @return 是否成功
     */
    public boolean insertTalentEnroll(TalentEnroll talentEnroll) throws Exception;
    
    /**
     * 删除人才需求报名信息
     * @param talentEnroll 报名信息
     * @return 是否成功
     */
    public boolean deleteTalentEnroll(TalentEnroll talentEnroll) throws Exception;
}
