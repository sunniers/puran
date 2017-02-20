/**
 * IMyCodeService.java
 * Created at 2016-10-24
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.ReturnObject;

/**
 * 我的账号开发
 */
public interface IMyCodeService {

    /**
     * 查询我的项目
     * @return 返回结果对象
     */
    public ReturnObject selectProj(Long userId) throws Exception;
}
