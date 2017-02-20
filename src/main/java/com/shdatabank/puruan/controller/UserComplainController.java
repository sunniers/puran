/**
 * UserComplainController.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.UserComplain;
import com.shdatabank.puruan.service.UserComplainService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 
 * 投诉举报controller层
 *
 */
@Controller
@RequestMapping(value="/complain")
public class UserComplainController {
	/** 投诉举报service注入*/
	@Autowired
	private UserComplainService userComplainService;
	
	
	@RequestMapping(value="/insertUserComplain",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertUserComplain(@RequestBody UserComplain userComplain) throws Exception{
		// 将从页面上获取投诉举报再进行插入操作。
		if (userComplainService.insertUserComplain(userComplain)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 查询投诉举报列表（待处理）
	 * @param userComplain 模糊查询字段
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllUserComplain",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllUserComplain(@RequestBody UserComplain userComplain)throws Exception{
		PageInfo<UserComplain> userComplainList = userComplainService.selectAllUserComplain(userComplain);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",userComplainList);
	}
	/**
	 * 查询投诉举报列表（已处理）
	 * @param userComplain 模糊查询字段
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllUserComplainSuc",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllUserComplainSuc(@RequestBody UserComplain userComplain)throws Exception{
		PageInfo<UserComplain> userComplainSucList = userComplainService.selectAllUserComplainSuc(userComplain);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",userComplainSucList);
	}
	/**
	 * 查询投诉举报详情
	 * @param complainId 举报id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectUserComplainDetail",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectUserComplainDetail(@RequestBody UserComplain userComplain)throws Exception{
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",userComplainService.selectUserComplainDetail(userComplain.getComplainId()));
	}
	/**
	 * 修改投诉举报状态
	 * @param userComplain 投诉实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateUserComplain",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateUserComplain(@RequestBody UserComplain userComplain)throws Exception{
		if(userComplainService.updatecomplainId(userComplain)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}
		return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
	}

}
