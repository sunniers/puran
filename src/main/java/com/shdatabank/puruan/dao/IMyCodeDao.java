/**
 * IMyCodeDao.java
 * Created at 2016-10-24
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

/**
 * 我的账号开发dao层
 */
public interface IMyCodeDao {

    /**
     * 查询正在参与的项目的数量
     * @param userId 用户id
     * @param status 项目状态
     * @param active 删除状态
     * @return 数量
     */
    public int selectRunningProj(Long userId,String status,Byte active) throws Exception;
    
    /**
     * 查询参与的项目的数量
     * @param userId 用户id
     * @param active 删除状态
     * @return 数量
     */
    public int selectTakeProj(Long userId,Byte active) throws Exception;
    
    /**
     * 我发布的项目的数量
     * @param userId 用户id
     * @param active 删除状态
     * @return 数量
     */
    public int selectPublishProj(Long userId,Byte active) throws Exception;

}
