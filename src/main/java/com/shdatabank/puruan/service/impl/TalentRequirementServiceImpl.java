/**
 * TalentRequirementServiceImpl.java
 * Created at 2016-11-5
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
import com.shdatabank.puruan.dao.TalentRequirementDao;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.service.TalentRequirementService;

/**
 * 
 * 人才需求Service层
 *
 */
@Service
public class TalentRequirementServiceImpl implements TalentRequirementService  {
	private Logger logger = Logger.getLogger(TalentRequirementServiceImpl.class);
	/**人才需求Dao注入 */
	@Autowired
	private TalentRequirementDao talentRequirementDao;
	/**
	 * 查询人才需求
	 * @return talentRequirement
	 */
	@Override
	public PageInfo<TalentRequirement> selectTaTechnology(TalentRequirement talentRequirement) throws Exception {
		PageHelper.startPage(talentRequirement.getPage(), talentRequirement.getPageSize());
		List<TalentRequirement> selectTaTechnology = talentRequirementDao.selectTaTechnology(talentRequirement);
		return new PageInfo<TalentRequirement>(selectTaTechnology);
	}
	/**
	 * 查询出所有技术类型包含子类型
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Dictionary> selectAllTechnologyType() throws Exception {
		return talentRequirementDao.selectAllTechnologyType();
	}
	/**
	 * 查询出所有工作形式
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Dictionary> selectAllWorkModeType() throws Exception {
		return talentRequirementDao.selectAllWorkModeType();
	}
	/**
	 * 根据创意人才id来修改创意人才
	 * @param talentRequirement
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean updateTaTechnology(TalentRequirement talentRequirement) throws Exception {
		logger.debug(" 根据创意人才id来修改创意人才");
		// 通过创意人才的ID来查询得到一个对象
		TalentRequirement selectTaTechnologyId = talentRequirementDao
				.selectTaTechnologyId(talentRequirement.getTalentRequirementId());
		//如果对象不为空时执行更新操作
		if (null != selectTaTechnologyId) {
			// 修改创意人才之前先删除人才需求分类id的所有类型
			logger.debug("修改创意人才之前先删除人才需求分类id的所有类型");
			talentRequirementDao.deleteRequirementType(talentRequirement.getTalentRequirementId());
			// 修改创意人才之前先删除创意技术类型
			logger.debug("修改创意人才之前先删除创意技术类型");
			talentRequirementDao.deleteTalentTechnology(talentRequirement.getTalentRequirementId());
			logger.debug("根据创意人才id来修改创意人才");
			int count = talentRequirementDao.updateTaTechnology(talentRequirement);
			if (0 == count) {
				return false;
			}
			if(null != talentRequirement.getTalentRequirementClasss()){
				//将创意人才需求的ID存入创意需求类中需求ID中
				for (int i = 0; i < talentRequirement.getTalentRequirementClasss().size(); i++) {
					talentRequirement.getTalentRequirementClasss().get(i).setTalentRequirementId(talentRequirement.getTalentRequirementId());
				}
				logger.debug("插入需求的分类");
				count =talentRequirementDao.insertRequirementType(talentRequirement.getTalentRequirementClasss());
				//判断是否插入成功
				if (0 == count) {
					return false;
				}
			}
			if (null != talentRequirement.getTalentTechnologies()) {
				// 把创意人才中的ID设置到创意技术类中的关联ID中
				for (int i = 0; i < talentRequirement.getTalentTechnologies().size(); i++) {
					talentRequirement.getTalentTechnologies().get(i)
							.setCreativeTalentId(talentRequirement.getTalentRequirementId());
				}
				// 修改后再次插入创意技术类型的
				logger.debug("插入创意人才技能");
				count = talentRequirementDao.insertTalentTechnology(talentRequirement.getTalentTechnologies());
				if (0 == count) {
					return false;
				}
			}
		} else {//如果对象为空时执行新增操作
			logger.debug("插入人才需求");
			int count = talentRequirementDao.insertTaRequirement(talentRequirement);
			if (count == 0) {
				return false;
			}
			if(null != talentRequirement.getTalentRequirementClasss()){
				//将创意人才需求的ID存入创意需求类中需求ID中
				for (int i = 0; i < talentRequirement.getTalentRequirementClasss().size(); i++) {
					talentRequirement.getTalentRequirementClasss().get(i).setTalentRequirementId(talentRequirement.getTalentRequirementId());
				}
				logger.debug("插入需求的分类");
				count =talentRequirementDao.insertRequirementType(talentRequirement.getTalentRequirementClasss());
				//判断是否插入成功
				if (0 == count) {
					return false;
				}
			}
			if (null != talentRequirement.getTalentTechnologies()) {
				// 将创意人才的ID存入创意人才技术中创意人才ID中
				for (int i = 0; i < talentRequirement.getTalentTechnologies().size(); i++) {
					talentRequirement.getTalentTechnologies().get(i)
							.setCreativeTalentId(talentRequirement.getTalentRequirementId());
				}
				logger.debug("插入创意人才技能");
				count = talentRequirementDao.insertTalentTechnology(talentRequirement.getTalentTechnologies());
				if (count == 0) {
					return false;
				}
			}
			
		}
		return true;
	}
	/**
	 *  根据创意人才id假删除一条创意人才
	 * @param talentRequirementId
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean deleteTaTechnology(TalentRequirement talentRequirement) throws Exception {
		logger.debug("根据创意人才id假删除一条创意人才");
		int count = talentRequirementDao.deleteTaTechnology(talentRequirement.getTalentRequirementId());
		if( 0 == count){
			return false;
		}
		return true;
	}
	/**
	 * 在点击修改操作是先通过ID查询创意人才是否存在
	 * @return talentRequirementId
	 */
	@Override
	public TalentRequirement selectTaRequirementId(TalentRequirement talentRequirement) throws Exception {
		return talentRequirementDao.selectTaRequirementId(talentRequirement.getTalentRequirementId());
	}

	
}
