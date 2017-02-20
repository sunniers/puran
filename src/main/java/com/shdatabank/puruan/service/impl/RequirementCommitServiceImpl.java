/**
 * RequirementCommitServiceImpl.java
 * Created at 2016-11-3
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.RequirementCommitDao;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementClass;
import com.shdatabank.puruan.model.SysMessage;
import com.shdatabank.puruan.service.RequirementCommitService;

/**
 * 
 * 项目需求Service层
 *
 */
@Service
public class RequirementCommitServiceImpl implements RequirementCommitService {
	private Logger logger = Logger.getLogger(RequirementCommitServiceImpl.class);
	/**项目需求Dao注入 */
	@Autowired
	private RequirementCommitDao requirementCommitDao;
	/**
	 * 查询项目需求
	 * 
	 * @param creativeResource
	 * @return
	 */
	@Override
	public PageInfo<ProjectRequirement> selectPrRequirement(ProjectRequirement projectRequirement) throws Exception {
		PageHelper.startPage(projectRequirement.getPage(), projectRequirement.getPageSize());
		List<ProjectRequirement> selectPrRequirement = requirementCommitDao.selectPrRequirement(projectRequirement);
		return new PageInfo<ProjectRequirement>(selectPrRequirement);
	}
	/**
	 * 插入项目需求
	 * @param projectRequirement
	 * @return
	 * @throws Exception
	 */
//	@Override
//	public boolean insertPrRequirement(ProjectRequirement projectRequirement) throws Exception {
//		int count = requirementCommitDao.insertPrRequirement(projectRequirement);
//		if (0 == count) {
//			return false;
//		}
//		if(null != projectRequirement.getProjectRequirementClasss()){
//			//将创意需求的ID存入创意需求类中需求ID中
//			for (int i = 0; i < projectRequirement.getProjectRequirementClasss().size(); i++) {
//				projectRequirement.getProjectRequirementClasss().get(i).setProjRequireId(projectRequirement.getProjId());
//			}
//			count =requirementCommitDao.insertRequirementType(projectRequirement.getProjectRequirementClasss());
//			 //判断是否插入成功
//			if (0 == count) {
//				return false;
//			}
//		}
//		if(null != projectRequirement.getProjRequireDescriptions()){
//			//将创意需求的ID存入创意需求描述中需求ID中
//			for (int i = 0; i < projectRequirement.getProjRequireDescriptions().size(); i++) {
//				projectRequirement.getProjRequireDescriptions().get(i).setProjRequireId(projectRequirement.getProjId());
//			}
//			count =requirementCommitDao.insertRequirementDescription(projectRequirement.getProjRequireDescriptions());
//			//判断是否插入成功
//			if (0 == count) {
//				return false;
//			}
//		}
//		return true;
//	}
	/**
	 * 查询所有的项目需求
	 */
	@Override
	public ProjectRequirement selectPrRequirementId(ProjectRequirement projectRequirement) throws Exception {
		return requirementCommitDao.selectPrRequirementId(projectRequirement.getProjId());
	}
	
	
	/**
	 * 修改项目需求
	 * 在点击草稿箱中的修改按钮时
	 * @param projectRequirement
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertPrRequirement(ProjectRequirement projectRequirement) throws Exception {
		logger.debug("修改项目需求");
		//通过需求ID查询出创意需求对象是否存在
		ProjectRequirement selectPrRequirementId = requirementCommitDao.selectPrRequirementId(projectRequirement.getProjId());
		//如果对象存在就执行更新操作
		if( null != selectPrRequirementId){
			//修改之前先删除需求类型
			logger.debug("修改之前先删除需求类型");
			requirementCommitDao.deleteRequirementType(projectRequirement.getProjId());
			//修改之前先删除需求描述
			logger.debug("修改之前先删除需求描述");
			requirementCommitDao.deleteRequirementDescription(projectRequirement.getProjId());
			logger.debug("修改项目需求");
			int count = requirementCommitDao.updatePrRequirement(projectRequirement);
			if (0 == count) {
				return false;
			}
			if(null != projectRequirement.getProjectRequirementClasss()){
				//将创意需求的ID存入创意需求类中需求ID中
				for (int i = 0; i < projectRequirement.getProjectRequirementClasss().size(); i++) {
					projectRequirement.getProjectRequirementClasss().get(i).setProjRequireId(projectRequirement.getProjId());
				}
				logger.debug("插入需求的分类");
				count =requirementCommitDao.insertRequirementType(projectRequirement.getProjectRequirementClasss());
				//判断是否插入成功
				if (0 == count) {
					return false;
				}
			}
			if(null != projectRequirement.getProjRequireDescriptions()){
				//将创意需求的ID存入创意需求描述中需求ID中
				for (int i = 0; i < projectRequirement.getProjRequireDescriptions().size(); i++) {
					projectRequirement.getProjRequireDescriptions().get(i).setProjRequireId(projectRequirement.getProjId());
				}
				logger.debug("插入需求概述");
				count =requirementCommitDao.insertRequirementDescription(projectRequirement.getProjRequireDescriptions());
				//判断是否插入成功
				if (0 == count) {
					return false;
				}
			}
		}
		else {	//如果对象不存在就执行新增操作
			logger.debug("如果对象不存在就执行新增操作");
			int count = requirementCommitDao.insertPrRequirement(projectRequirement);
			if (0 == count) {
				return false;
			}
			if(null != projectRequirement.getProjectRequirementClasss()){
				//将创意需求的ID存入创意需求类中需求ID中
				for (int i = 0; i < projectRequirement.getProjectRequirementClasss().size(); i++) {
					projectRequirement.getProjectRequirementClasss().get(i).setProjRequireId(projectRequirement.getProjId());
				}
				logger.debug("插入需求的分类");
				count =requirementCommitDao.insertRequirementType(projectRequirement.getProjectRequirementClasss());
				 //判断是否插入成功
				if (0 == count) {
					return false;
				}
			}
			if(null != projectRequirement.getProjRequireDescriptions()){
				//将创意需求的ID存入创意需求描述中需求ID中
				for (int i = 0; i < projectRequirement.getProjRequireDescriptions().size(); i++) {
					projectRequirement.getProjRequireDescriptions().get(i).setProjRequireId(projectRequirement.getProjId());
				}
				logger.debug("插入需求概述");
				count =requirementCommitDao.insertRequirementDescription(projectRequirement.getProjRequireDescriptions());
				//判断是否插入成功
				if (0 == count) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * 查询出所有需求类型包含子类型
	 * @param projectRequirement
	 * @return
	 */
	@Override
	public List<Dictionary> selectAllRequirementType() throws Exception {
		return requirementCommitDao.selectAllRequirementType();
	}
	/**
	 * 查看消息信息
	 * @param sysMessage
	 * @return
	 */
	@Override
	public PageInfo<SysMessage> selectMessage(SysMessage sysMessage) throws Exception {
		//将查询出来的数量设置到消息中
		PageHelper.startPage(sysMessage.getPage(), sysMessage.getPageSize());
		List<SysMessage> selectMessage = requirementCommitDao.selectMessage(sysMessage);
		return new PageInfo<SysMessage>(selectMessage);
	}
	/**
	 * 测试插入需求的分类
	 * @param projectRequirementClasses （创意需求小类id【Dictionarydata.dataId】、
	 * 	创意需求id【CreativeResource.creativeResourceId】、创意需求大类id【Dictionary.dictId】）
	 * @return 是否插入成功
	 */
	@Transactional
	@Override
	public boolean insertRequirementType(List<ProjectRequirementClass> projectRequirementClasses) throws Exception {
		logger.debug("测试插入需求的分类");
		int count = requirementCommitDao.insertRequirementType(projectRequirementClasses);
		if(count != 0 ){
			return true;
		}
		return false;
	}
	/**
	 * 根据需求id删除需求类型
	 * @param projectRequirementClasses 创意需求id
	 * @return
	 */
//	public boolean deleteRequirementType(Long projRequireId) throws Exception {
//		int count = requirementCommitDao.deleteRequirementType(projRequireId);
//		if(count != 0 ){
//			return true;
//		}
//		return false;
//	}
	/**
	 * 根据项目需求id假删除创意需求
	 * @param projectRequirement
	 * @return
	 */
	@Transactional
	@Override
	public boolean deletePrRequirement(ProjectRequirement projectRequirement) throws Exception {
		logger.debug("根据项目需求id假删除创意需求");
		int count = requirementCommitDao.deletePrRequirement(projectRequirement.getProjId());
		if( 0 == count){
			return false;
		}
		return true;
	}
	
}
