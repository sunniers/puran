/**
 * RequirementCommitService.java
 * Created at 2016-11-3
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CreateResourceWarehouse;
import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ProjectPlanTask;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
import com.shdatabank.puruan.model.ProjectTaskChange;
import com.shdatabank.puruan.model.ProjectTaskDetailplan;
import com.shdatabank.puruan.model.TaskProduct;

/**
 * @author guoqiankun
 *
 */
public interface ProjectPlanTaskService {
	/**
	 * 查询任务
	 * @return projectRequirement
	 */
	public PageInfo<ProjectPlanTask> selectPrPlanTask(ProjectPlanTask projectPlanTask) throws Exception;
	/**
	 * 查询任务的详情
	 * @return projectRequirement
	 */
	public ProjectPlanTask selectTaskDetails(ProjectPlanTask projectPlanTask) throws Exception;
	/**
	 * 任务计划
	 * @param projectTaskDetailplan
	 * @return
	 * @throws Exception
	 */
	public PageInfo<ProjectPlanTask> selectTaskDetailplan(ProjectPlanTask projectPlanTask) throws Exception;
	/**
	 * 新增任务计划
	 * @param projectTaskDetailplan
	 * @return
	 * @throws Exception
	 */
	public boolean insertTaskDetailplan(ProjectPlanTask projectPlanTask) throws Exception;
	/**
	 * 查询前置计划
	 * @param projectTaskChange
	 * @return
	 */
	public List<ProjectTaskDetailplan> selectFrontPlan() throws Exception;
	/**
	 * 计划—查看
	 * @param projectTaskDetailplan
	 * @return
	 */
	public ProjectTaskDetailplan viewTaskDetailplan(ProjectTaskDetailplan projectTaskDetailplan) throws Exception;
	/**
	 * 计划—修改
	 * @param projectTaskDetailplan
	 *
	 */
	public boolean updateTaskDetailplan(ProjectTaskDetailplan projectTaskDetailplan) throws Exception;
	/**
	 * 删除任务计划
	 * @param projectTaskDetailplan
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTaskDetailplan(ProjectTaskDetailplan projectTaskDetailplan) throws Exception;
	/**
	 * 变更状态—查看
	 * @param projectPlanTask
	 * @return
	 */
	public ProjectTaskChange selectChange(ProjectTaskChange projectTaskChange) throws Exception;
	/**
	 * 变更状态
	 * @param projectTaskChange
	 * @return
	 */
	public PageInfo<ProjectTaskChange> selectChangeStatus(ProjectTaskChange projectTaskChange) throws Exception;
	/**
	 * 变更状态—确认
	 * @param projectTaskChange
	 * @return
	 */
	public boolean updateProjectTaskChange(ProjectTaskChange projectTaskChange) throws Exception;
	/**
	 * 任务的变更
	 * @param ProjectPlanTask
	 * @return
	 * @throws Exception
	 */
	public boolean insertTaskChange(ProjectTaskChange projectTaskChange) throws Exception;
	/**
	 * 任务-采购
	 * @param projectPurchaseTask
	 * @return
	 */
	public PageInfo<ProjectPurchaseTask> selectPurchase(ProjectPurchaseTask projectPurchaseTask) throws Exception;
	/**
	 * 移到库存：数量减一
	 * @param projectPurchaseTask
	 * @return
	 * @throws Exception
	 */
	public boolean updatePurchase(ProjectPurchaseTask projectPurchaseTask) throws Exception;
	/**
	 * 移到库存：资源仓库数据插入
	 * @param projectPurchaseTask
	 * @return
	 */
	public boolean insertCreateResourceWarehouse(CreateResourceWarehouse createResourceWarehouse)throws Exception;
	/**
	 * 任务的采购
	 * @param ProjectPlanTask
	 * @return
	 * @throws Exception
	 */
	public boolean insertTaskPurchase(ProjectPlan projectPlan) throws Exception;
	/**
	 * 进度—提交产物  
	 * @param taskProduct
	 * @return
	 * @throws Exception
	 */
	public boolean insertTaskProduct(TaskProduct taskProduct) throws Exception;
	/**
	 * 进度—完成  
	 * @param taskProduct
	 * @return
	 */
	public boolean updateFinish(ProjectTaskDetailplan projectTaskDetailplan) throws Exception;
	/**
	 * 进度—开始
	 * @param taskProduct
	 * @return
	 */
	public boolean updateStart(ProjectTaskDetailplan projectTaskDetailplan) throws Exception;
}
