/**
 * BackRoleController.java
 * Created at 2016-10-20
 * Created by fuqinwei
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.BackRole;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.SysMessage;
import com.shdatabank.puruan.service.BackRoleService;
import com.shdatabank.puruan.service.SystemMessageService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 后台角色管理controller层
 */
@RequestMapping(value="/role")
@Controller
public class BackRoleController {
	/** 后台角色管理service */
	@Autowired
	private BackRoleService backRoleService;
	
	/**
	 * 新增角色
	 * @param BackRole： 角色
	 * @return 结果对象
	 */
	@RequestMapping(value="/insertBackRole",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertBackRole(@RequestBody BackRole role){
		//插入角色信息以及角色资源关系信息是否成功
		if(backRoleService.insertBackRole(role)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
	}
	
	/**
	 * 查询角色
	 * @param BackRole： 角色
	 * @return 结果对象
	 */
	@RequestMapping(value="/selectBackRole",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectBackRole(@RequestBody BackRole backRole){
		PageInfo<BackRole> backRoles = backRoleService.selectBackRole(backRole);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",backRoles);
	}
	
	/**
	 * 根据角色ID查询角色
	 * @param BackRole： 角色
	 * @return 后台角色对象
	 */
	@RequestMapping(value="/selectBackRoleById",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectBackRoleById(@RequestBody BackRole role){
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",backRoleService.selectBackRoleById(role));
	}
	
	/**
	 * 修改角色
	 * @param role 角色
	 * @return 结果对象
	 */
	@RequestMapping(value="/updateBackRole",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateBackRole(@RequestBody BackRole role){
		if(backRoleService.updateBackRole(role)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else{
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
		
	}
	
	/**
	 * 删除角色
	 * @param role 角色
	 * @return 结果对象
	 */
	@RequestMapping(value="/deleteBackRole",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject deleteBackRole(@RequestBody BackRole role){
		if(backRoleService.deleteBackRole(role)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
		}
	}
	
}
