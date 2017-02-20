/**
 * ModifyPwdController.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.ModifyPwdService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 更新前后台用户的密码controller层
 * 1.更新前台密码
 * 2.更新后台密码
 */
@RequestMapping(value="/modifyPwd")
@Controller
public class ModifyPwdController {

    /** 更新前后台用户的密码service */
    @Autowired
    private ModifyPwdService modifyPwdService;
    
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 更新后台密码
     * @param backUser 后台用户实体类
     * @return 返回结果对象
     */
    @RequestMapping(value="/updateBackUserNewPwd",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateBackUserNewPwd(@RequestBody BackUser backUser) throws Exception {
        //判断旧密码是否正确
    	backUser.setUserPwd(UserUtil.stringMD5(backUser.getUserPwd()));
    	backUser.setNewBackUserPwd(UserUtil.stringMD5(backUser.getNewBackUserPwd()));
    	BackUser temp = (BackUser) httpServletRequest.getSession().getAttribute("backUser");
    	if (null != temp) {
    	    backUser.setUserName(temp.getUserName());    	    
    	} else {
    	    return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
    	}
        Integer count = modifyPwdService.selectBackUserOldPwd(backUser);
        if (0 == count) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        } else {
            //更新密码
            if (!modifyPwdService.updateBackUserNewPwd(backUser)) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        }
    }
    
    /**
     * 更新前台密码
     * @param user 前台用户实体类
     * @return 返回结果对象
     */
    @RequestMapping(value="/updateUserNewPwd",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateUserNewPwd(@RequestBody User user) throws Exception {
        //判断旧密码是否正确
        Integer count = modifyPwdService.selectUserOldPwd(user);
        if( 0 == count ){
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }else{
            //更新密码
            if (!modifyPwdService.updateUserNewPwd(user)) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        }
    }
}
