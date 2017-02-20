/**
 * UserTalentServiceImpl.java
 * Created at 2016-11-01
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.IUserTalentDao;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.service.IUserTalentService;

/**
 * 创意人才service层
 */
@Service
public class UserTalentServiceImpl implements IUserTalentService{

    /** 创意人才dao */
    @Autowired
    private IUserTalentDao iUserTalentDao;
    
    /**
     * 查询创意人才
     * @param userCreativeTalent 查询条件
     * @return 创意人才
     */
    @Override
    public PageInfo<UserCreativeTalent> selectUserCreativeTalent(UserCreativeTalent userCreativeTalent) throws Exception {
        PageHelper.startPage(userCreativeTalent.getPage(), userCreativeTalent.getPageSize());
        List<UserCreativeTalent> userCreativeTalents = iUserTalentDao.selectUserCreativeTalent(userCreativeTalent);
        return new PageInfo<UserCreativeTalent> (userCreativeTalents);
    }

    
}
