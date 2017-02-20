package com.shdatabank.puruan.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.FancingDao;
import com.shdatabank.puruan.model.Fancing;
import com.shdatabank.puruan.model.FancingAndClassifierList;
import com.shdatabank.puruan.model.FancingClassifier;
import com.shdatabank.puruan.model.FancingResponse;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.FancingService;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 融资信息service层
 */
@Service
public class FancingServiceImpl implements FancingService{

	@Autowired
	private FancingDao fancingDao;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 融资信息
	 */
	@Override
	public PageInfo<Fancing> findAllFancingBy(Fancing fancing) throws Exception {
		PageHelper.startPage(fancing.getPage(), fancing.getPageSize());
		 List<Fancing> fancings = fancingDao.findAllFancingBy(fancing);		
		 return new PageInfo<Fancing>(fancings);
	}

	/**
	 * 融资信息列表
	 */
	@Override
	public List<Fancing> findAllFancing(Fancing fancing) throws Exception {
		List<Fancing> fancings = fancingDao.findAllFancingBy(fancing);		
		return fancings;
	}

	/**
	 * 融资发布
	 */
	@Transactional
	@Override
	public boolean insertFancing(FancingAndClassifierList fancingAndClassifierList) throws Exception {
		logger.debug("========================融资的保存和提交========================");
		Fancing fancing = fancingAndClassifierList.getFancing();
		List<FancingClassifier> fancingClassifierList = fancingAndClassifierList.getFancingClassifiers();
		//从session中提取当前登录用户
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		fancing.setUserId(user.getUserId());
		//给isOpen字段赋值
		if(null != fancing.getPublishWay()){	
			String[] publishStr = spliteUse(fancing.getPublishWay());
			for(int i=0;i<publishStr.length;i++){
				if("100701".equals(publishStr[i])){
					fancing.setIsOpen((byte)1);
				}
			}
		}
		//将office文件路径转换为PDF预览路径
		if(null != fancing.getFancingAttachment()){
			fancing.setFancingFileSeePath(UserUtil.pdfChange(fancing.getFancingAttachment()));
		}
		int count = fancingDao.insertFancing(fancing);
		if(0 == count){
			return false;
		}
		//如果融资插入成功则返回当前融资id
		Long fancingId = fancing.getFancingId();
		List<FancingClassifier> fancingClassifiers = new ArrayList<FancingClassifier>();
		for(FancingClassifier em : fancingClassifierList){
			FancingClassifier fancingClassifier = new FancingClassifier();
			fancingClassifier.setFancingId(fancingId);
			fancingClassifier.setFancingClassifierValue(em.getFancingClassifierValue());
			fancingClassifiers.add(fancingClassifier);
		}
		//插入组装好的融资分类集合
		fancingDao.insertFancingClassifier(fancingClassifiers);
		return true;		
	}

	/**
	 * 融资修改
	 */
	@Transactional
	@Override
	public boolean updateFancing(FancingAndClassifierList fancingAndClassifierList) throws Exception {
		logger.debug("========================融资的修改保存和修改提交========================");
		Fancing fancing = fancingAndClassifierList.getFancing();
		List<FancingClassifier> fancingClassifierList = fancingAndClassifierList.getFancingClassifiers();
		Long fancingId = fancing.getFancingId();
		List<FancingClassifier> fancingClassifiers = new ArrayList<FancingClassifier>();
		for(FancingClassifier em : fancingClassifierList){
			FancingClassifier fancingClassifier = new FancingClassifier();
			fancingClassifier.setFancingId(fancingId);
			fancingClassifier.setFancingClassifierValue(em.getFancingClassifierValue());
			fancingClassifiers.add(fancingClassifier);
		}
		//将office文件路径转换为PDF预览路径
		if(null != fancing.getPublishWay()){
			String[] publishStr = spliteUse(fancing.getPublishWay());
			for(int i=0;i<publishStr.length;i++){
				if("100701".equals(publishStr[i])){
					fancing.setIsOpen((byte)1);
				}
			} 
		}
		//将office文件路径转换为PDF预览路径
		if(null != fancing.getFancingAttachment()){
			fancing.setFancingFileSeePath(UserUtil.pdfChange(fancing.getFancingAttachment()));
		}
		//更新融资主体
		fancingDao.updateFancing(fancing);
		//删除融资分类
		fancingDao.deleteFancingClassifier(fancingId);
		//插入新的融资分类
		int count = fancingDao.insertFancingClassifier(fancingClassifiers);
		if(0 == count){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 初始化融资发布数据
	 */
	@Override
	public FancingResponse selectFancingResponse() throws Exception {
		FancingResponse fancingResponse = new FancingResponse();
		fancingResponse.setAllFacningClass(fancingDao.findAllFacningClass());
		fancingResponse.setAllFacningWay(fancingDao.findAllFacningWay());
		return fancingResponse;
	}

	/**
	 * 根据融资id查询某个融资实体的详细信息
	 */
	@Override
	public Fancing selectFancingDetail(Long fancingId) throws Exception {
		Fancing fancing = fancingDao.selectFancingDetail(fancingId);
		if(null != fancing.getClassStr()){
			String[] cla = spliteUse(fancing.getClassStr());
			fancing.setClassValue(cla);
		}
		return fancing;
	}
	
	/**
	 * 分割字符串
	 * @param str
	 * @return String[]
	 */
	public String[] spliteUse(String str) {
		if (str != null) {
			return str.split(",");
		} else {
			return null;
		}
	}

	/**
	 * 草稿箱列表
	 */
	@Override
	public PageInfo<Fancing> selectAllFancingDrafts(Fancing fancing) throws Exception {
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		fancing.setUserId(user.getUserId());
		PageHelper.startPage(fancing.getPage(), fancing.getPageSize());
		List<Fancing> fancingDraftsList = fancingDao.selectAllFancingDrafts(fancing);
		return new PageInfo<Fancing>(fancingDraftsList);
	}

	/**
	 * 融资假删除
	 */
	@Transactional
	@Override
	public boolean updateFancingActive(Long fancingId) throws Exception {
		logger.debug("========================融资的假删除========================");
		int count = fancingDao.updateFancingActive(fancingId);
		if(0 == count){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 融资状态修改
	 */
	@Transactional
	@Override
	public boolean updateFancingStatus(Fancing fancing) throws Exception {
		logger.debug("========================融资状态修改========================");
		int count = fancingDao.updateFancingStatus(fancing);
		if(0 == count){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 需求大厅中的融资详情
	 */
	@Override
	public Fancing selectFancingById(Long fancingId) throws Exception {
		Fancing fancing = fancingDao.selectFancingById(fancingId);
		if(null != fancing.getClassStr()){
			String[] cla = spliteUse(fancing.getClassStr());
			fancing.setClassValue(cla);
		}
		return fancing;
	}

}
