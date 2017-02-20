/**
 * EnrollServiceImpl.java
 * Created at 2016-11-15
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shdatabank.puruan.dao.IEnrollDao;
import com.shdatabank.puruan.model.ProjectEnroll;
import com.shdatabank.puruan.model.TalentEnroll;
import com.shdatabank.puruan.service.IEnrollService;

/**
 * 报名service层
 */
@Service
public class EnrollServiceImpl implements IEnrollService{

    /** 报名dao */
    @Autowired
    private IEnrollDao iEnrollDao;

    /**
     * 插入报名信息
     * @param projectEnroll 报名信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertProjectEnroll(ProjectEnroll projectEnroll) throws Exception {
        int count = iEnrollDao.insertProjectEnroll(projectEnroll);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 删除报名信息
     * @param projectEnroll 报名信息
     * @return 是否成功
     */
    @Override
    public boolean deleteProjectEnroll(ProjectEnroll projectEnroll) throws Exception {
        int count = iEnrollDao.deleteProjectEnroll(projectEnroll);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 插入人才需求报名信息
     * @param talentEnroll 报名信息
     * @return 是否成功
     */
    @Override
    public boolean insertTalentEnroll(TalentEnroll talentEnroll) throws Exception {
        int count = iEnrollDao.insertTalentEnroll(talentEnroll);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 删除人才需求报名信息
     * @param talentEnroll 报名信息
     * @return 是否成功
     */
    @Override
    public boolean deleteTalentEnroll(TalentEnroll talentEnroll) throws Exception {
        int count = iEnrollDao.deleteTalentEnroll(talentEnroll);
        if (0 == count) {
            return false;
        }
        return true;
    }

}
