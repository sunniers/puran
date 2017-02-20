/**
 * UserTalentDao.java
 * Created at 2016-11-01
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.UserCreativeTalent;

/**
 * 创意人才dao层
 */
public interface IUserTalentDao {

    /**
     * 查询创意人才
     * @param userCreativeTalent 查询条件
     * @return 创意人才
     */
    public List<UserCreativeTalent> selectUserCreativeTalent(UserCreativeTalent userCreativeTalent) throws Exception;
}
