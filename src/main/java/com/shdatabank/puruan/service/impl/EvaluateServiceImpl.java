/**
 * EvaluateServiceImpl.java
 * Created at 2016-11-02
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.IEvaluateDao;
import com.shdatabank.puruan.model.CreativeResourceEvaluate;
import com.shdatabank.puruan.model.CreativeTalentEvaluate;
import com.shdatabank.puruan.model.ProjectEvaluate;
import com.shdatabank.puruan.service.IEvaluateService;

/**
 * 评价service层
 */
@Service
public class EvaluateServiceImpl implements IEvaluateService {
    
    private Logger logger =Logger.getLogger(EvaluateServiceImpl.class);
    
    /** 评价dao */
    @Autowired
    private IEvaluateDao iEvaluateDao;

    /**
     * 新增项目评价
     * @param projectEvaluate 评论信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertProjectEvaluate(ProjectEvaluate projectEvaluate) throws Exception {
        logger.debug("新增项目评价");
        int count = iEvaluateDao.insertProjectEvaluate(projectEvaluate);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 新增创意人才评论
     * @param creativeTalentEvaluate 评论信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertCreativeTalentEvaluate(CreativeTalentEvaluate creativeTalentEvaluate) throws Exception {
        logger.debug("新增创意人才评论");
        int count = iEvaluateDao.insertCreativeTalentEvaluate(creativeTalentEvaluate);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 新增创意资源的评价
     * @param CreativeResourceEvaluate 评论信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean insertCreativeResourceEvaluate(CreativeResourceEvaluate creativeResourceEvaluate) throws Exception {
        logger.debug("新增创意资源的评价");
        int count = iEvaluateDao.insertCreativeResourceEvaluate(creativeResourceEvaluate);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 更新追评
     * @param CreativeResourceEvaluate 追评信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean updateEvaluateAppend(CreativeResourceEvaluate creativeResourceEvaluate) throws Exception {
        logger.debug("更新追评");
        int count = iEvaluateDao.updateEvaluateAppend(creativeResourceEvaluate);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 更新解释
     * @param CreativeResourceEvaluate 解释信息
     * @return 是否成功
     */
    @Transactional
    @Override
    public boolean updateExplain(CreativeResourceEvaluate creativeResourceEvaluate) throws Exception {
        logger.debug("更新解释");
        int count = iEvaluateDao.updateExplain(creativeResourceEvaluate);
        if (0 == count) {
            return false;
        }
        return true;
    }

    /**
     * 查询项目评论信息
     * @param projectEvaluate 评论信息
     * @return 评论信息
     */
    @Override
    public PageInfo<ProjectEvaluate> selectProjectEvaluate(ProjectEvaluate projectEvaluate) throws Exception {
        PageHelper.startPage(projectEvaluate.getPage(), projectEvaluate.getPageSize());
        List<ProjectEvaluate> projectEvaluates = iEvaluateDao.selectProjectEvaluate(projectEvaluate);
        return new PageInfo<ProjectEvaluate> (projectEvaluates);
    }

    /**
     * 查询创意资源评论信息
     * @param CreativeResourceEvaluate 评论信息
     * @return 评论信息
     */
    @Override
    public PageInfo<CreativeResourceEvaluate> selectCreativeResourceEvaluates(CreativeResourceEvaluate creativeResourceEvaluate)
            throws Exception {
        PageHelper.startPage(creativeResourceEvaluate.getPage(), creativeResourceEvaluate.getPageSize());
        List<CreativeResourceEvaluate> creativeResourceEvaluates = iEvaluateDao.selectCreativeResourceEvaluates(creativeResourceEvaluate);
        return new PageInfo<CreativeResourceEvaluate> (creativeResourceEvaluates);
    }

    /**
     * 查询创意资源评论信息
     * @param CreativeResourceEvaluate 评论信息
     * @return 评论信息
     */
    @Override
    public CreativeResourceEvaluate selectCreativeResourceEvaluate(CreativeResourceEvaluate creativeResourceEvaluate)
            throws Exception {
        return iEvaluateDao.selectCreativeResourceEvaluate(creativeResourceEvaluate);
    }

}
