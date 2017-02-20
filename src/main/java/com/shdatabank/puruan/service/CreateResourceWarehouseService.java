package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CreateResourceWarehouse;
import com.shdatabank.puruan.model.ProjectAndPurchase;
import com.shdatabank.puruan.model.ProjectAndTask;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
import com.shdatabank.puruan.model.WarehouseAndResource;
public interface CreateResourceWarehouseService {
	
	/**
	 * 资源仓库查询资源集合
	 * @param createResourceWarehouse
	 * @return
	 */
	public PageInfo<WarehouseAndResource> selectAllCreateResourceWarehouse(WarehouseAndResource warehouseAndResource)throws Exception;
	
	/**
	 * 仓库新增资源仓库新增资源(供审核通过调用)
	 * @param createResourceWarehouse
	 * @return
	 */
	public boolean insertCreateResourceWarehouse(CreateResourceWarehouse createResourceWarehouse)throws Exception;
	
	/**
	 * 资源仓库查询单条资源详情
	 * @param uerId
	 * @return
	 */
	public WarehouseAndResource selectCreateResourceWarehouseDetail(Long stockId)throws Exception;
	
	/**
	 * 向采购列表添加资源
	 * @param ProjectTaskChange
	 * @return
	 * @throws Exception
	 */
	public boolean insertProjectPurchaseTask(ProjectAndPurchase projectAndPurchase)throws Exception;
	
	/**
	 * 查询该用户负责的所有项目
	 * @param projectAndTask
	 * @return 项目对象集合
	 */
	public List<ProjectAndTask> selectAllProject(ProjectAndTask projectAndTask)throws Exception;
	
	/**
	 * 查询该用户承接的所有任务
	 * @param projectAndTask
	 * @return 任务对象集合
	 */
	public List<ProjectAndTask> selectAllTask(ProjectAndTask projectAndTask)throws Exception;
	
	/**
	 * 修改库存数量
	 * @param warehouseAndResource
	 * @return
	 */
	public boolean updateCreateResourceWarehouseCount(CreateResourceWarehouse createResourceWarehouse)throws Exception;
	
}
