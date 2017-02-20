package com.shdatabank.puruan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.CreativeResourceDao;
import com.shdatabank.puruan.model.CreateResourceAndClassifier;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.CreativeResourceClassifier;
import com.shdatabank.puruan.model.CreativeResourceFront;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.CreativeResourceService;
/**
 * 创意资源接口
 * @author Administrator
 *
 */
@Service
@Transactional
public class CreativeResourceServiceImpl implements CreativeResourceService {

	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private CreativeResourceDao creativeResourceDao;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 创意资源信息的保存和提交
	 * @param createResourceAndClassifier 创意资源对象与资源分类对象集合
	 * @return 无
	 * @throws Exception
	 */	
	@Transactional
	@Override
	public boolean insertCreativeResource(CreateResourceAndClassifier createResourceAndClassifier) throws Exception {
		logger.debug("========================创意资源信息的保存和提交========================");
		//从封装的参数对象中提取出来需要的参数对象
		CreativeResource creativeResource = createResourceAndClassifier.getCreativeResource();
		List<CreativeResourceClassifier> creativeResourceClassifierList = createResourceAndClassifier.getCreativeResourceClassifierList();
		//从session中取出用户id
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		creativeResource.setUserId(user.getUserId());
		//如果传进来的flg标志值为0则执行保存操作，否者执行发布操作
		if("401201".equals(createResourceAndClassifier.getFlg())){
			//保存
			creativeResource.setResourceStatus(401201);
		}else{
			//发布
			creativeResource.setResourceStatus(401202);
		}
		//向表里插入资源信息,同时返回该条资源的id
		int count = creativeResourceDao.insertCreativeResource(creativeResource);
		if(0 == count){
			return false;
		}
		Long crId = creativeResource.getCreativeResourceId();
		List<CreativeResourceClassifier> creativeResourceClassifiers=new ArrayList<CreativeResourceClassifier>();
		//将该条资源的id做为插入资源类型表的参数放进资源分类对象list参数中
		for(CreativeResourceClassifier em : creativeResourceClassifierList){
			CreativeResourceClassifier creativeResources=new CreativeResourceClassifier();
			creativeResources.setClassifierValue(em.getClassifierValue());
			creativeResources.setCreativeResourceId(crId);
			creativeResourceClassifiers.add(creativeResources);
		}
		//同时往资源类型表里插入该资源的资源类型
		creativeResourceDao.insertCreativeResourceClassifier(creativeResourceClassifiers);
		return true;
	}
	/**
	 * 创意资源修改并重新发布：草稿状态、未通过审核状态、已删除状态
	 * @param 创意资源对象与资源分类对象集合
	 * @return 是否提交成功
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean updateCreativeResource(CreateResourceAndClassifier createResourceAndClassifier) throws Exception {		
		logger.debug("========================创意资源信息的修改保存和修改提交========================");
		//从封装的参数对象中提取出来需要的参数对象
		CreativeResource creativeResource = createResourceAndClassifier.getCreativeResource();
		List<CreativeResourceClassifier> creativeResourceClassifierList = createResourceAndClassifier.getCreativeResourceClassifierList();		
		Long crId = creativeResource.getCreativeResourceId();
		//修改创意资源之前首先根据创意资源id删除所有创意资源类型
		creativeResourceDao.deleteCreativeResourceClassifier(crId);
		List<CreativeResourceClassifier> creativeResourceClassifiers=new ArrayList<CreativeResourceClassifier>();
		//将该条资源的id做为插入资源类型表的参数放进资源分类对象list参数中
		for(CreativeResourceClassifier em : creativeResourceClassifierList){
			CreativeResourceClassifier creativeResourceClass=new CreativeResourceClassifier();
			creativeResourceClass.setClassifierValue(em.getClassifierValue());
			creativeResourceClass.setCreativeResourceId(crId);
			creativeResourceClassifiers.add(creativeResourceClass);
		}
		//修改资源的同时向资源分类表里插入资源类型
		creativeResourceDao.insertCreativeResourceClassifier(creativeResourceClassifiers);
		int count = creativeResourceDao.updateCreativeResource(creativeResource);
		if("401201".equals(createResourceAndClassifier.getFlg())){
			//创意资源保存草稿
			creativeResourceDao.updateCreativeResourceSave(creativeResource);
		}else{
			//创意资源重新发布
			creativeResourceDao.updateCreativeResourceActive(creativeResource);
		}
		if(0 == count){
			return false;
		}
		return true;
	}
	
	/**
	 * 创意资源的单条信息查询
	 */
	@Override
	public CreativeResource selectCreativeResource(Long creativeResourceId) throws Exception {
		
		return  creativeResourceDao.selectCreativeResource(creativeResourceId);
	}
	
	/**
	 * 查询出所有创意资源类型包含子类型
	 */
	@Override
	public List<Dictionary> selectAllCreativeResourceType() throws Exception {
		return creativeResourceDao.selectAllCreativeResourceType();
	}
	
	/**
	 * 给创意资源添加类型
	 */
	@Transactional
	@Override
	public boolean insertCreativeResourceClassifier(List<CreativeResourceClassifier> creativeResourceClassifierList)
			throws Exception {
		logger.debug("========================给创意资源添加类型========================");
		int count = creativeResourceDao.insertCreativeResourceClassifier(creativeResourceClassifierList);			
		if(0 == count){
			return false;
		}
		return true;
		
	}
	/**
	 * 分页条件查询资源仓库中的资源集合
	 */
	@Override
	public PageInfo<CreativeResource> selectAllCreativeResource(CreativeResource creativeResource) throws Exception {		
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		creativeResource.setUserId(user.getUserId());
		PageHelper.startPage(creativeResource.getPage(), creativeResource.getPageSize());
		List<CreativeResource> creativeResourceDaoList = creativeResourceDao.selectAllCreativeResource(creativeResource);
		return new PageInfo<CreativeResource>(creativeResourceDaoList);
	}
	/**
	 * 分页条件查询资源仓库中已删除的资源集合
	 */
	@Override
	public PageInfo<CreativeResource> selectAllCreativeResourceActive(CreativeResource creativeResource)throws Exception {
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		creativeResource.setUserId(user.getUserId());
		PageHelper.startPage(creativeResource.getPage(), creativeResource.getPageSize());
		List<CreativeResource> creativeResourceDaoList = creativeResourceDao.selectAllCreativeResourceActive(creativeResource);
		return new PageInfo<CreativeResource>(creativeResourceDaoList);
	}
	/**
	 * 资源仓库默认页面
	 */
	@Override
	public PageInfo<CreativeResource> selectAllCreativeResourceDefault(CreativeResource creativeResource)throws Exception {
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		creativeResource.setUserId(user.getUserId());
		PageHelper.startPage(creativeResource.getPage(), creativeResource.getPageSize());
		List<CreativeResource> creativeResourceDaoList = creativeResourceDao.selectAllCreativeResourceDefault(creativeResource);
		return new PageInfo<CreativeResource>(creativeResourceDaoList);
	}
	/**
	 * 根据资源分类id查询当前资源类型集合
	 */
	@Override
	public List<CreativeResourceClassifier> selectAllCreativeResourceClassifier(Long creativeResourceId) throws Exception {
		
		return creativeResourceDao.selectAllCreativeResourceClassifier(creativeResourceId);
	}
	/**
	 * 根据id批量删除某个资源的资源类型
	 */
	@Transactional
	@Override
	public boolean deleteCreativeResourceClassifier(Long creativeResourceId)
			throws Exception {
		logger.debug("========================删除创意资源类型========================");
		int count = creativeResourceDao.deleteCreativeResourceClassifier(creativeResourceId);
		if(0 == count){
			return false;
		}
		return true;
	}
	/**
	 * 分页条件查询资源对象集合
	 */
	@Override
	public PageInfo<CreativeResourceFront> selectAllCreativeResourceFront(CreativeResourceFront creativeResourceFront)
			throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String name = creativeResourceFront.getResourceName();
		Long[] classArray = creativeResourceFront.getClassifierValueArray();
		param.put("name", name);
		param.put("classArray", classArray);
		PageHelper.startPage(creativeResourceFront.getPage(), creativeResourceFront.getPageSize());
		List<CreativeResourceFront> creativeResourceFrontList = creativeResourceDao.selectAllCreativeResourceFront(param);
		return new PageInfo<CreativeResourceFront>(creativeResourceFrontList);
	}
	/**
	 * 资源下架
	 */
	@Transactional
	@Override
	public boolean updateCreativeResourceOffShelf(CreativeResource creativeResource) throws Exception {
		logger.debug("========================资源下架========================");
		creativeResource.setResourceStatus(401205);
		int success = creativeResourceDao.updateCreativeResource(creativeResource);
		if(0 == success){
			return false;
		}
		return true;
	}
	/**
	 * 资源上架
	 */
	@Transactional
	@Override
	public boolean updateCreativeResourceOnShelf(CreativeResource creativeResource) throws Exception {
		logger.debug("========================资源上架========================");
		CreativeResource creativeResources = creativeResourceDao.selectCreativeResource(creativeResource.getCreativeResourceId());
		//如果资源为下架状态才允许资源上架，否者不允许执行资源上架操作
		if(401205 != creativeResources.getResourceStatus()){
			return false;
		}else{
			creativeResources.setResourceStatus(401203);
			int success = creativeResourceDao.updateCreativeResource(creativeResources);
			if(0 == success){
				return false;
			}else{
				return true;
			}
		}
	}
	/**
	 * 创意资源假删除
	 */
	@Transactional
	@Override
	public boolean updateCreativeResourceFalseDel(CreativeResource creativeResource) throws Exception {
		logger.debug("========================创意资源假删除========================");
		creativeResource.setResourceStatus(401206);
		creativeResource.setActive((byte)1);
		int success = creativeResourceDao.updateCreativeResource(creativeResource);
		if(0 == success){
			return false;
		}
		return true;
	}
	/**
	 * 首页正在出售的创意资源详情
	 */
	@Override
	public CreativeResourceFront selectCreativeResourceFront(Long creativeResourceId)throws Exception{
		CreativeResourceFront creativeResourceFront = creativeResourceDao.selectCreativeResourceFront(creativeResourceId);
		//查询登录的用户id
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		Long loginUserId = user.getUserId();
		//如果当前登录的用户id和创意资源的发布用户id相同，说明该资源为用户出售的id，否则为用户购买的id
		if(loginUserId == creativeResourceDao.selectCreativeResource(creativeResourceId).getUserId()){
			creativeResourceFront.setIsMy(2);
		}else{
			creativeResourceFront.setIsMy(1);
		}
		
		return creativeResourceFront;
	}
		
}
