package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.CreateResourceWarehouse;
import com.shdatabank.puruan.model.ProjectAndPurchase;
import com.shdatabank.puruan.model.ProjectAndTask;
import com.shdatabank.puruan.model.WarehouseAndResource;

/**
 * 资源仓库接口
 * @author Administrator
 *
 */
public interface CreateResourceWarehouseDao {

	/**
	 * 资源仓库添加
	 * @param createResourceWarehouse
	 * @return
	 */
	public int insertCreateResourceWarehouse(CreateResourceWarehouse createResourceWarehouse);
	/**
	 * 资源仓库查询单条资源详情
	 * @param uerId
	 * @return
	 */
	public WarehouseAndResource selectCreateResourceWarehouse(Long stockId);
	/**
	 * 资源仓库查询资源集合
	 * @param createResourceWarehouse
	 * @return
	 */
	public List<WarehouseAndResource> selectAllCreateResourceWarehouse(WarehouseAndResource warehouseAndResource);
	/**
	 * 查询该用户负责的所有项目
	 * @param projectAndTask
	 * @return 项目对象集合
	 */
	public List<ProjectAndTask> selectAllProject(ProjectAndTask projectAndTask);
	/**
	 * 查询该用户承接的所有任务
	 * @param projectAndTask
	 * @return 任务对象集合
	 */
	public List<ProjectAndTask> selectAllTask(ProjectAndTask projectAndTask);
	/**
	 * 减少库存数量
	 * @param CreateResourceWarehouse
	 * @return
	 */
	public int updateCreateResourceWarehouseReduce(ProjectAndPurchase projectAndPurchase);
	/**
	 * 修改库存数量
	 * @param createResourceWarehouse
	 * @return
	 */
	public int updateCreateResourceWarehouseCount(CreateResourceWarehouse createResourceWarehouse);
	
}
