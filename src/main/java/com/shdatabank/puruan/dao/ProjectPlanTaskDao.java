package com.shdatabank.puruan.dao;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shdatabank.puruan.model.CreateResourceWarehouse;
import com.shdatabank.puruan.model.ProjectPlanTask;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
import com.shdatabank.puruan.model.ProjectTaskChange;
import com.shdatabank.puruan.model.ProjectTaskDetailplan;
import com.shdatabank.puruan.model.TaskProduct;

/**
 * 任务dao层接口
 */
public interface ProjectPlanTaskDao {
	/**
	 * 查询任务
	 * @param projectPlanTask
	 * @return
	 */
	public List<ProjectPlanTask> selectPrPlanTask(ProjectPlanTask projectPlanTask);
	/**
	 * 查询任务的详情
	 * @param projectPlanTask
	 * @return
	 */
	public ProjectPlanTask selectTaskDetails(ProjectPlanTask projectPlanTask);
	/**
	 * 查询任务计划
	 * @param projectTaskDetailplan
	 * @return
	 */
	public List<ProjectPlanTask> selectTaskDetailplan(ProjectPlanTask projectPlanTask);
	/**
	 * 查询项目ID通过任务关联到计划
	 * @param projectPlan
	 * @return
	 */
	public Long selectProjId(Long undertakeUserId);
	/**
	 * 新增任务计划 
	 * @param projectTaskChange
	 * @return
	 */
	public int insertTaskDetailplan(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 查询前置计划
	 * @param projectTaskChange
	 * @return
	 */
	public List<ProjectTaskDetailplan> selectFrontPlan();
	/**
	 * 计划—查看
	 * @param projectTaskDetailplan
	 * @return
	 */
	public ProjectTaskDetailplan viewTaskDetailplan(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 计划—修改
	 * @param projectTaskChange
	 * @return
	 */
	public int updateTaskDetailplan(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 删除任务计划
	 * @param subTaskId
	 * @return
	 */
	public int deleteTaskDetailplan(Long subTaskId);
	/**
	 * 变更状态—查看
	 * @param projectPlanTask
	 * @return
	 */
	public ProjectTaskChange selectChange(ProjectTaskChange projectTaskChange);
	/**
	 * 变更状态
	 * @param projectTaskChange
	 * @return
	 */
	public List<ProjectTaskChange> selectChangeStatus(ProjectTaskChange projectTaskChange);
	/**
	 * 变更状态—确认
	 * @param projectTaskChange
	 * @return
	 */
	public int updateProjectTaskChange(ProjectTaskChange projectTaskChange);
	/**
	 * 任务的变更 
	 * @param projectTaskChange
	 * @return
	 */
	public int insertTaskChange(ProjectTaskChange projectTaskChange);
	/**
	 * 任务-采购
	 * @param projectPurchaseTask
	 * @return
	 */
	public List<ProjectPurchaseTask> selectPurchase(ProjectPurchaseTask projectPurchaseTask);
	/**
	 * 移到库存：数量减一
	 * @param projectPurchaseTask
	 * @return
	 */
	public int updatePurchase(ProjectPurchaseTask projectPurchaseTask);
	/**
	 * 移到库存：根据id庫存數量增加
	 * @param projectPurchaseTask
	 * @return
	 */
	public int updateCreateResourceWarehouseReduce(CreateResourceWarehouse createResourceWarehouse);
	/**
	 * 资源仓库查询单条资源详情
	 * @param stockId
	 * @return
	 */
	public CreateResourceWarehouse selectCreateResourceWarehouseDetail(Long createResourceId)throws Exception;
	/**
	 * 移到库存：资源仓库数据插入
	 * @param projectPurchaseTask
	 * @return
	 */
	public int insertCreateResourceWarehouse(CreateResourceWarehouse createResourceWarehouse);
	/**
	 * 查询采购数量
	 * @param projectPurchaseTask
	 * @return
	 */
	public Integer selectPurchaseCount(@Param(value="projectPurchaseId")Long projectPurchaseId);
	/**
	 * 移到库存：数量为0是删除该条记录
	 * @param projectPurchaseTask
	 * @return
	 */
	public int deletePurchase(ProjectPurchaseTask projectPurchaseTask);
	/**
	 * 任务的采购
	 * @param projectPurchaseTask
	 * @return
	 */
	public int insertTaskPurchase(ProjectPurchaseTask projectPurchaseTask);
	/**
	 * 进度—提交产物  
	 * @param taskProduct
	 * @return
	 */
	public int insertTaskProduct(TaskProduct taskProduct);
	/**
	 * 进度—完成  
	 * @param projectTaskDetailplan
	 * @return
	 */
	public int updateFinish(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 进度—开始
	 * @param projectTaskDetailplan
	 * @return
	 */
	public int updateStart(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 判断是否所有任务计划都已完成
	 * @param projectTaskDetailplan
	 * @return
	 */
	public Integer selectAllTaskPlan(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 更新任务状态
	 * @param projectTaskDetailplan
	 * @return
	 */
	public int updateTaskStatus(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 更新计划状态
	 * @param projectTaskDetailplan
	 * @return
	 */
	public int updatePlanStatus(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 判断是否父计划的子计划全部完成
	 * @param projectTaskDetailplan
	 * @return
	 */
	public Integer selectAllChildren(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 查询父计划的ID
	 * @param projectTaskDetailplan
	 * @return
	 */
	public Long selectParentId(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 更新父计划状态
	 * @param projectTaskDetailplan
	 * @return
	 */
	public int updateParentStatus(Long parentId);

	
	/**
	 * 判断该任务计划对应的任务的实际开始时间有没有值
	 * @param projectTaskDetailplan
	 * @return
	 */
	public Date selectStartTimer(@Param(value="subTaskId") Long subTaskId);
	/**
	 * 设置任务的开始时间
	 * @param projectTaskDetailplan
	 * @return
	 */
	public int updateStartTimer(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 设置计划的开始时间
	 * @param projectTaskDetailplan
	 * @return
	 */
	public int updatePlanTimer(ProjectTaskDetailplan projectTaskDetailplan);

	/**
	 * 判断该任务计划对应的任务的计划的父计划的实际开始时间有没有值
	 * @param projectTaskDetailplan
	 * @return
	 */
	public Date selectPlanTimer(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 查询父计划ID
	 * @param projectTaskDetailplan
	 * @return
	 */
	public Long selectPlanId(ProjectTaskDetailplan projectTaskDetailplan);
	/**
	 * 设置计划的开始时间
	 * @param subTaskId
	 * @return
	 */
	public int updateParentPlanTimer(Long subTaskId);
	
	
}
