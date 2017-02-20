package com.shdatabank.puruan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.ProjectAndPurchase;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
/**
 * 购买的资源/出售的资源接口
 * @author Administrator
 *
 */
public interface CeativeResourceTransactionDao {

	/**
	 * 查询单条资源交易信息
	 * @param ceativeResourceTransaction 资源id
	 * @return 单个资源交易对象
	 */
	public CeativeResourceTransaction selectCeativeResourceTransaction(Long resourceTransactionId);
	/**
	 * 条件查询资源交易对象集合(购买的资源)
	 * @param ceativeResourceTransaction 资源状态transactionStatus
	 * @return 资源交易对象集合
	 */
	public List<CeativeResourceTransaction> selectAllCeativeResourceTransactionGm(CeativeResourceTransaction ceativeResourceTransaction);
	/**
	 * 条件查询资源交易对象集合(出售的资源)
	 * @param ceativeResourceTransaction 资源状态transactionStatus
	 * @return 资源交易对象集合
	 */
	public List<CeativeResourceTransaction> selectAllCeativeResourceTransactionCs(CeativeResourceTransaction ceativeResourceTransaction);
	/**
	 * 更新资源交易的状态：支付、确认、评价、追评、关闭交易
	 * @param ceativeResourceTransaction
	 * @return
	 */
	public int updateCeativeResourceTransaction(CeativeResourceTransaction ceativeResourceTransaction);
	/**
	 * 添加到采购列表时，本地资源减去相应数量
	 * @param ceativeResourceTransaction
	 * @return
	 */
	public int updateCeativeResourceTransactionReduce(ProjectAndPurchase projectAndPurchase);
	/**
	 * 根据资源id、项目id、任务id查询是否已存在该资源
	 * @param projectPurchaseTask
	 * @return
	 */
	public ProjectPurchaseTask selectProjectPurchaseTask(ProjectAndPurchase projectAndPurchase);
	/**
	 * 如果已经添加过该资源，就要在采购表里把资源的数量加上相应的数量，只做更新数量操作
	 * @param projectAndPurchase
	 * @return
	 */
	public int updateProjectPurchaseTaskCount(ProjectAndPurchase projectAndPurchase);
}
