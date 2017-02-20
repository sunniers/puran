/**
 * UserTalentService.java
 * Created at 2016-11-01
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.UserCreativeTalent;

/**
 * 创意人才service层
 */
public interface IUserTalentService {

    /**
     * 查询创意人才
     * @param userCreativeTalent 查询条件
     * @return 创意人才
     */
    public PageInfo<UserCreativeTalent> selectUserCreativeTalent(UserCreativeTalent userCreativeTalent) throws Exception;
}