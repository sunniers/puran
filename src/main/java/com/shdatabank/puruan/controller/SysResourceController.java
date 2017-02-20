/**
 * SysResourceController.java
 * Created at 2016-10-18
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.SysResource;
import com.shdatabank.puruan.model.SysResourcePage;
import com.shdatabank.puruan.service.SysResourceService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 
 * 项目资源信息controller层
 *
 */
@Controller
@RequestMapping(value = "/sys")
public class SysResourceController {
	/** 项目资源信息Service */
	@Autowired
	private SysResourceService sysResourceService;
	/** 文件上传路径配置 */
	private String filePath;

	@Value("${filePath}")
	public void setfilePath(String val) {
		this.filePath = val;
	}
	
	/**
	 * 插入一级项目资源信息
	 * 
	 * @param SysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/insertSysResource", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertSysResource(@RequestBody SysResource sysResource) throws Exception {
		// 将从页面上获取项目资源信息再进行插入操作。
		if (sysResourceService.insertSysResource(sysResource)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}
	
	/**
	 * 查询所有项目资源信息
	 * 
	 * @param sysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/selectFirstResource", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectFirstResource(@RequestBody SysResource sysResource) throws Exception {

		List<SysResource> selectFirstResource = sysResourceService.selectFirstResource(sysResource);
		if (selectFirstResource == null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectFirstResource);
		}
	}
	
	
	/**
	 * 更新项目资源信息
	 * 
	 * @param SysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/updateSysResource", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateSysResource(@RequestBody SysResource sysResource) throws Exception {
		// 将从页面上获取的密码经过加密后再进行插入操作。
		if (null != sysResourceService.selectSysResource(sysResource.getResourceId(),
				SystemConstant.DELETE_ACTIVE_TRUE)) {
			sysResourceService.updateSysResource(sysResource);
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
//		sysResourceService.updateSysResource(sysResource);
//		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
	}

	/**
	 * 删除项目资源信息
	 * 
	 * @param SysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/deleteSysResource", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject deleteSysResource(@RequestBody SysResource sysResource) throws Exception {
		// 将从页面上获取的密码经过加密后再进行插入操作。
		if (null != sysResourceService.selectSysResource(sysResource.getResourceId(),
				SystemConstant.DELETE_ACTIVE_TRUE)) {
			//sysResource.setActive(SystemConstant.DELETE_ACTIVE_FALSE);
			sysResourceService.deleteSysResource(sysResource);
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR, SystemConstant.DELETE_ERROR_MSG);
		}
	}

	/**
	 * 根据条件查询项目资源信息
	 * 
	 * @param sysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/selectAllSysResource", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllSysResource(@RequestBody SysResourcePage sysResourcePage) throws Exception {

		PageInfo<SysResource> sysResources = sysResourceService.selectAllSysResource(sysResourcePage);
		if (sysResources == null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", sysResources);
		}
	}
	/**
	 * 查询一级还是二级目录
	 * 
	 * @param sysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/selectFirstAndSecondResource", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectFirstAndSecondResource(@RequestBody SysResource sysResource) throws Exception {
		
		 SysResource SecondResource = sysResourceService.selectFirstAndSecondResource(sysResource.getResourceId());
		if (SecondResource == null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", SecondResource);
		}
	}

	/**
	 * 根据条件查询项目资源信息
	 * 
	 * @param sysResource
	 *            项目资源信息实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/selectBackSysResource", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject selectBackSysResource() throws Exception {
		List<SysResource> selectBackSysResource = sysResourceService.selectBackSysResource();
		if (selectBackSysResource == null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectBackSysResource);
		}
	}

	/**
	 * 上传图片
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject upload(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "resourceId", required = false) Integer resourceId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("开始");
		// 扩展名
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		// 图片名称生成策略
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		// 图片名称一部分
		String format = df.format(new Date());
		// 随机三位数
		Random r = new Random();
		// n 1000 0-999 99
		for (int i = 0; i < 3; i++) {
			format += r.nextInt(10);
		}
		// 保存数据库
		String path = "upload/" + format + "." + ext;
		// 保存本机的路径
		String url = filePath + "\\" + path;

		File targetFile = new File(url);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SysResource sysResource = new SysResource();
		sysResource.setResourceId(resourceId);
		//sysResource.setResourcePath(path);
		sysResource.setResourceLink(path);
		sysResourceService.updateUpload(sysResource);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
	}

}
