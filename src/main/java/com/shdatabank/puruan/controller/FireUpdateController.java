/**
 * FireUpdateController.java
 * Created at 2016-10-27
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.Fire;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 文件上传
 */
@RequestMapping(value="/fileUpdate")
@Controller
public class FireUpdateController {

    /**
     * 上传文件
     * @param fire
     * @return 返回结果对象
     */
    @RequestMapping(value="/updateFile",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateFile(@RequestBody Fire fire) throws Exception{
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",fire);
    }
}
