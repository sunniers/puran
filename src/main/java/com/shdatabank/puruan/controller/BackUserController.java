/**
 * BackUserController.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.BackUserService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 后台用户管理controller层 
 */
@RequestMapping(value="/user")
@Controller
public class BackUserController {
    
    /** 后台用户管理service */
    @Autowired
    private BackUserService backUserService;

    /**
     * 插入后台用户的用户名和用户密码
     * @param backUser 后台用户实体类
     * @return 返回结果对象
     */
    @RequestMapping(value="/insertBackUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertBackUser(@RequestBody BackUser backUser) throws Exception {
        //将从页面上获取的密码经过加密后再进行插入操作。
        if (backUserService.insertBackUser(backUser)) {
            //插入成功
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            //插入失败
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }

    /**
     * 查询后台用户信息
     * @param userId 用户id
     * @return 返回结果对象
     */
    @RequestMapping(value="/selectBackUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectBackUser(@RequestBody BackUser backUser) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",backUserService.selectBackUser(backUser.getUserId()));
    }
    
    /**
     * 更新后台用户的信息
     * @param backUser 后台用户实体类
     * @return 返回结果对象
     */
    @RequestMapping(value="/updateBackUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateBackUser(@RequestBody BackUser backUser) throws Exception{
        if (null != backUserService.selectBackUser(backUser.getUserId())) {
            if (backUserService.updateBackUser(backUser)) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 删除后台用户
     * @param backUser 后台用户实体类
     * @return 返回结果对象
     */
    @RequestMapping(value="/deleteBackUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject deleteBackUser(@RequestBody BackUser backUser) throws Exception {
        if (null != backUserService.selectBackUser(backUser.getUserId())) {
            if (backUserService.deleteBackUser(backUser)) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
            }
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
        }
    }
    
    /**
     * 查询所有后台用户信息
     * @return
     */
    /*@RequestMapping(value="/selectAllBackUser",method=RequestMethod.GET)
    public @ResponseBody ReturnObject selectAllBackUser(){
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"查询成功",backUserService.selectAllBackUser());
    }*/
    
    /**
     * 查询所有部门信息
     * @return 返回结果对象
     */
    @RequestMapping(value="/selectAllBackUserDepartment",method=RequestMethod.GET)
    @ResponseBody
    public ReturnObject selectAllBackUserDepartment() throws Exception {
        List<String> userDepartments = backUserService.selectAllBackUserDepartment();
        if (null == userDepartments) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",userDepartments);
        }
    }
    
    /**
     * 根据条件查询后台用户的信息
     * @param backUser 后台用户实体类
     * @return 返回结果对象
     */
    @RequestMapping(value="/selectAllBackUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectBackUserDepartment(@RequestBody BackUser backUser) throws Exception {
        PageInfo<BackUser> backUsers = backUserService.selectAllBackUser(backUser);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",backUsers);
    }
}
