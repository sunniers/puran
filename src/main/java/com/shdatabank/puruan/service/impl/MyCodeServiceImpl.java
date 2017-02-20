/**
 * MyCodeServiceImpl.java
 * Created at 2016-10-24
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shdatabank.puruan.dao.IMyCodeDao;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.IMyCodeService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 我的账号开发service层
 */
@Service
public class MyCodeServiceImpl implements IMyCodeService{

    /** 我的账号dao */
    @Autowired
    private IMyCodeDao iMyCodeDao;
    
    /**
     * 查询我的项目
     * @return 返回结果对象
     */
    @Override
    public ReturnObject selectProj(Long userId) throws Exception {
        ProjectRequirement projectRequirement = new ProjectRequirement();
        //查询进行中的项目
        int count = iMyCodeDao.selectRunningProj(userId, SystemConstant.RUNNING_PROJ,SystemConstant.DELETE_ACTIVE_TRUE);
        projectRequirement.setRunningProj(count);
        //查询参与的发布的项目
        count = iMyCodeDao.selectPublishProj(userId,SystemConstant.DELETE_ACTIVE_TRUE);
        projectRequirement.setReleaseProj(count);
        //查询参与的项目
        count = iMyCodeDao.selectTakeProj(userId, SystemConstant.DELETE_ACTIVE_TRUE);
        projectRequirement.setTakeProj(count);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",projectRequirement);
    }

}
