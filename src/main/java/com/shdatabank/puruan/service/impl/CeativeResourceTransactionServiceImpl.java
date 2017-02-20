package com.shdatabank.puruan.service.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.CeativeResourceTransactionDao;
import com.shdatabank.puruan.dao.ProjectPlanTaskDao;
import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.ProjectAndPurchase;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.CeativeResourceTransactionService;
@Service
public class CeativeResourceTransactionServiceImpl implements CeativeResourceTransactionService {

	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private CeativeResourceTransactionDao ceativeResourceTransactionDao;
	
	@Autowired
	private ProjectPlanTaskDao projectPlanTaskDao;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 根据id查询单条资源交易信息
	 * @param ceativeResourceTransaction
	 * @return 资源交易信息详情
	 */
	@Override
	public CeativeResourceTransaction selectCeativeResourceTransaction(
			CeativeResourceTransaction ceativeResourceTransaction) throws Exception {
		return ceativeResourceTransactionDao.selectCeativeResourceTransaction(ceativeResourceTransaction.getResourceTransactionId());
	}

	/**
	 * 条件查询资源交易对象集合(购买的资源)
	 * @param ceativeResourceTransaction 
	 * @return 资源交易对象集合
	 */
	@Override
	public PageInfo<CeativeResourceTransaction> selectAllCeativeResourceTransactionGm(
			CeativeResourceTransaction ceativeResourceTransaction) throws Exception {
		//从session取得当前登录的用户id做为购买者id，去资源交易表中查询出的资源为用户购买的资源
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		ceativeResourceTransaction.setBuyUserId(user.getUserId());
		PageHelper.startPage(ceativeResourceTransaction.getPage(), ceativeResourceTransaction.getPageSize());
		List<CeativeResourceTransaction> ceativeResourceTransactionList = ceativeResourceTransactionDao.selectAllCeativeResourceTransactionGm(ceativeResourceTransaction);
		return new PageInfo<CeativeResourceTransaction>(ceativeResourceTransactionList);
	}
	/**
	 * 条件查询资源交易对象集合(出售的资源)
	 * @param ceativeResourceTransaction 资源状态transactionStatus
	 * @return 资源交易对象集合
	 */
	@Override
	public PageInfo<CeativeResourceTransaction> selectAllCeativeResourceTransactionCs(
			CeativeResourceTransaction ceativeResourceTransaction) throws Exception {
		//从session取得当前登录的用户id做为购买者id，去资源交易表中查询出的资源为用户购买的资源
		User user = (User)httpServletRequest.getSession().getAttribute("user");		
		CreativeResource creativeResource=new CreativeResource();
		creativeResource.setUserId(user.getUserId());
		ceativeResourceTransaction.setCreativeResource(creativeResource);
		PageHelper.startPage(ceativeResourceTransaction.getPage(), ceativeResourceTransaction.getPageSize());
		List<CeativeResourceTransaction> ceativeResourceTransactionList = ceativeResourceTransactionDao.selectAllCeativeResourceTransactionCs(ceativeResourceTransaction);
		return new PageInfo<CeativeResourceTransaction>(ceativeResourceTransactionList);
	}

	/**
	 * 更新资源交易的状态：支付、确认、评价、追评、关闭交易
	 * @param ceativeResourceTransaction
	 * @return
	 */
	@Transactional
	@Override
	public boolean updateCeativeResourceTransaction(
			CeativeResourceTransaction ceativeResourceTransaction) throws Exception {
		logger.debug("========================更新资源交易的状态：支付、确认、评价、追评、关闭交易========================");
		int count = ceativeResourceTransactionDao.updateCeativeResourceTransaction(ceativeResourceTransaction);
		if(0 == count){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 将已购买的资源添加到采购列表
	 */
	@Transactional
	@Override
	public boolean insertProjectPurchase(ProjectAndPurchase projectAndPurchase) throws Exception {
		logger.debug("========================将已购买的资源添加到采购列表========================");
		//如果根据项目id,任务id,资源id在采购类表里未查询到该资源，则执行插入操作，否则直接更新采购列表中资源的数量
		CeativeResourceTransaction crt = ceativeResourceTransactionDao.selectCeativeResourceTransaction(projectAndPurchase.getResourceTransactionId());
		projectAndPurchase.setCreativeResourceId(crt.getCreativeResource().getCreativeResourceId());
		ProjectPurchaseTask projectPurchaseTask = ceativeResourceTransactionDao.selectProjectPurchaseTask(projectAndPurchase);
		if(null == projectPurchaseTask){
			ProjectPurchaseTask ppt = new ProjectPurchaseTask();
			//采购的数量只能小于或等于资源库存数量
			if(projectAndPurchase.getNumber() > crt.getTransactionNumber()){
				return false;
			}else{
				ppt.setProjectId(projectAndPurchase.getProjectId());
				ppt.setProjectTaskId(projectAndPurchase.getProjectTaskId());
				ppt.setCreateResourceId(crt.getCreativeResource().getCreativeResourceId());
				ppt.setPurchaseProviderInfo(crt.getBuyUserId());
				ppt.setPurchaseCost(crt.getTransactionPrice());
				ppt.setPurchaseCount(projectAndPurchase.getNumber());
				//如果没有选择任务，说明是把资源添加到项目采购，如果选了任务，说明是把资源添加到任务采购
				if(null == projectAndPurchase.getProjectTaskId()){
					ppt.setPurchaseType(130001);
				}
				ppt.setPurchaseType(130002);
				ceativeResourceTransactionDao.updateCeativeResourceTransactionReduce(projectAndPurchase);
				projectPlanTaskDao.insertTaskPurchase(ppt);
			}	
		}else{
			projectAndPurchase.setProjectPurchaseId(projectPurchaseTask.getProjectPurchaseId());
			ceativeResourceTransactionDao.updateProjectPurchaseTaskCount(projectAndPurchase);
		}
		return true;                     
		
	}

	/**
	 * 根据资源id、项目id、任务id查询是否已存在该资源
	 */
	@Override
	public ProjectPurchaseTask selectProjectPurchaseTask(ProjectAndPurchase projectAndPurchase) throws Exception {
		return ceativeResourceTransactionDao.selectProjectPurchaseTask(projectAndPurchase);
	}	

}
