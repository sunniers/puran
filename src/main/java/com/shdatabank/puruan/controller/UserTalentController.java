/**
 * UserTalentServiceImpl.java
 * Created at 2016-11-01
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.service.IUserTalentService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 创意人才controller层
 */
@RequestMapping(value="/userTalent")
@Controller
public class UserTalentController {

    @Autowired
    private IUserTalentService iUserTalentService;
    
    /**
     * 查询创意人才
     * @param userCreativeTalent 查询条件
     * @return 创意人才
     */
    @RequestMapping(value="/selectUserCreativeTalent",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectUserCreativeTalent(@RequestBody UserCreativeTalent userCreativeTalent) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iUserTalentService.selectUserCreativeTalent(userCreativeTalent));
    }
}
