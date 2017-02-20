package com.shdatabank.puruan.service;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.ProjectAndPurchase;
import com.shdatabank.puruan.model.ProjectPurchaseTask;

public interface CeativeResourceTransactionService {

	/**
	 * 根据id查询单条资源交易信息
	 * @param ceativeResourceTransaction
	 * @return
	 */
	public CeativeResourceTransaction selectCeativeResourceTransaction(CeativeResourceTransaction ceativeResourceTransaction)throws Exception;
	/**
	 * 条件查询资源交易对象集合(购买的资源)
	 * @param ceativeResourceTransaction 
	 * @return 资源交易对象集合
	 */
	public PageInfo<CeativeResourceTransaction> selectAllCeativeResourceTransactionGm(CeativeResourceTransaction ceativeResourceTransaction)throws Exception;
	/**
	 * 条件查询资源交易对象集合(出售的资源)
	 * @param ceativeResourceTransaction 资源状态transactionStatus
	 * @return 资源交易对象集合
	 */
	public PageInfo<CeativeResourceTransaction> selectAllCeativeResourceTransactionCs(CeativeResourceTransaction ceativeResourceTransaction)throws Exception;
	/**
	 * 更新资源交易的状态：支付、确认、评价、追评、关闭交易
	 * @param ceativeResourceTransaction
	 * @return
	 */
	public boolean updateCeativeResourceTransaction(CeativeResourceTransaction ceativeResourceTransaction)throws Exception;
	/**
	 * 从购买成功的资源里添加资源到采购列表
	 * @param projectAndPurchase 项目id,任务id,采购数量
	 * @return
	 * @throws Exception
	 */
	public boolean insertProjectPurchase(ProjectAndPurchase projectAndPurchase)throws Exception;
	/**
	 * 根据资源id、项目id、任务id查询是否已存在该资源
	 * @param projectPurchaseTask
	 * @return
	 */
	public ProjectPurchaseTask selectProjectPurchaseTask(ProjectAndPurchase projectAndPurchase)throws Exception;
}
