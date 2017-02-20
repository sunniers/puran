/**
 * EvaluateDao.java
 * Created at 2016-11-02
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.CreativeResourceEvaluate;
import com.shdatabank.puruan.model.CreativeTalentEvaluate;
import com.shdatabank.puruan.model.ProjectEvaluate;

/**
 * 评价dao层
 */
public interface IEvaluateDao {

    /**
     * 新增项目评价
     * @param projectEvaluate 评论信息
     * @return 是否成功
     */
    public int insertProjectEvaluate(ProjectEvaluate projectEvaluate) throws Exception;
    
    /**
     * 新增创意人才评论
     * @param creativeTalentEvaluate 评论信息
     * @return 是否成功
     */
    public int insertCreativeTalentEvaluate(CreativeTalentEvaluate creativeTalentEvaluate) throws Exception;

    /**
     * 新增创意资源的评价
     * @param CreativeResourceEvaluate 评论信息
     * @return 是否成功
     */
    public int insertCreativeResourceEvaluate(CreativeResourceEvaluate creativeResourceEvaluate) throws Exception;
    
    /**
     * 更新追评
     * @param CreativeResourceEvaluate 追评信息
     * @return 是否成功
     */
    public int updateEvaluateAppend(CreativeResourceEvaluate creativeResourceEvaluate) throws Exception;

    /**
     * 更新解释
     * @param CreativeResourceEvaluate 解释信息
     * @return 是否成功
     */
    public int updateExplain(CreativeResourceEvaluate creativeResourceEvaluate) throws Exception;
    
    /**
     * 查询项目评论信息
     * @param projectEvaluate 评论信息
     * @return 评论信息
     */
    public List<ProjectEvaluate> selectProjectEvaluate(ProjectEvaluate projectEvaluate) throws Exception;
    
    /**
     * 查询创意资源评论信息(全部)
     * @param CreativeResourceEvaluate 评论信息
     * @return 评论信息
     */
    public List<CreativeResourceEvaluate> selectCreativeResourceEvaluates
    (CreativeResourceEvaluate creativeResourceEvaluate) throws Exception;
    
    /**
     * 查询创意资源评论信息(单个)
     * @param CreativeResourceEvaluate 评论信息
     * @return 评论信息
     */
    public CreativeResourceEvaluate selectCreativeResourceEvaluate 
    (CreativeResourceEvaluate creativeResourceEvaluate) throws Exception;
}
