/**
 * ProjectPlanTaskServiceImpl.java
 * Created at 2016-11-5
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.ProjectPlanTaskDao;
import com.shdatabank.puruan.dao.SystemMessageDao;
import com.shdatabank.puruan.model.CreateResourceWarehouse;
import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ProjectPlanTask;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
import com.shdatabank.puruan.model.ProjectTaskChange;
import com.shdatabank.puruan.model.ProjectTaskDetailplan;
import com.shdatabank.puruan.model.SysMessage;
import com.shdatabank.puruan.model.TaskProduct;
import com.shdatabank.puruan.service.ProjectPlanTaskService;

/**
 * 
 * 任务Service层
 *
 */
@Service
public class ProjectPlanTaskServiceImpl implements ProjectPlanTaskService {
	/**打印日志*/
	private Logger logger = Logger.getLogger(ProjectPlanTaskServiceImpl.class);
	/** 任务Dao注入 */
	@Autowired
	private ProjectPlanTaskDao projectPlanTaskDao;
	@Autowired
	private SystemMessageDao dao;

	/**
	 * 查询任务
	 * 
	 * @return talentRequirement
	 */
	@Override
	public PageInfo<ProjectPlanTask> selectPrPlanTask(ProjectPlanTask projectPlanTask) throws Exception {
		PageHelper.startPage(projectPlanTask.getPage(), projectPlanTask.getPageSize());
		List<ProjectPlanTask> selectPrPlanTask = projectPlanTaskDao.selectPrPlanTask(projectPlanTask);
		return new PageInfo<ProjectPlanTask>(selectPrPlanTask);
	}

	/**
	 * 查询任务的详情
	 * 
	 * @return projectRequirement
	 */
	@Override
	public ProjectPlanTask selectTaskDetails(ProjectPlanTask projectPlanTask) throws Exception {
		return projectPlanTaskDao.selectTaskDetails(projectPlanTask);
	}

	/**
	 * 任务计划
	 * 
	 * @param projectTaskDetailplan
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageInfo<ProjectPlanTask> selectTaskDetailplan(ProjectPlanTask projectPlanTask) throws Exception {
		PageHelper.startPage(projectPlanTask.getPage(), projectPlanTask.getPageSize());
		List<ProjectPlanTask> selectTaskDetailplan = projectPlanTaskDao.selectTaskDetailplan(projectPlanTask);
		return new PageInfo<ProjectPlanTask>(selectTaskDetailplan);
	}

	/**
	 * 新增任务计划
	 * 
	 * @param ProjectPlanTask
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean insertTaskDetailplan(ProjectPlanTask projectPlanTask) throws Exception {
		logger.debug("新增任务计划");
		// 获取任务的ID
		Long projTaskId = projectPlanTask.getProjTaskId();
		// 将任务的ID设置到任务计划的ID中
		List<ProjectTaskDetailplan> projectTaskDetailplans = projectPlanTask.getProjectTaskDetailplans();
		for (int i = 0; i < projectTaskDetailplans.size(); i++) {
			projectTaskDetailplans.get(i).setProjectTaskId(projTaskId);
			int count = projectPlanTaskDao.insertTaskDetailplan(projectTaskDetailplans.get(i));
			if (0 == count) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 计划—查看
	 * 
	 * @param projectTaskDetailplan
	 * @return
	 */
	@Transactional
	@Override
	public ProjectTaskDetailplan viewTaskDetailplan(ProjectTaskDetailplan projectTaskDetailplan) throws Exception {
		return projectPlanTaskDao.viewTaskDetailplan(projectTaskDetailplan);
	}

	/**
	 * 计划—修改
	 * 
	 * @param projectTaskDetailplan
	 */
	@Transactional
	@Override
	public boolean updateTaskDetailplan(ProjectTaskDetailplan projectTaskDetailplan) throws Exception {
		logger.debug("计划—修改");
		int count = projectPlanTaskDao.updateTaskDetailplan(projectTaskDetailplan);
		if (0 == count) {
			return false;
		}
		return true;
	}

	/**
	 * 删除任务计划
	 * 
	 * @param projectTaskDetailplan
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean deleteTaskDetailplan(ProjectTaskDetailplan projectTaskDetailplan) throws Exception {
		logger.debug("删除任务计划");
		int count = projectPlanTaskDao.deleteTaskDetailplan(projectTaskDetailplan.getSubTaskId());
		if (0 == count) {
			return false;
		}
		return true;
	}

	/**
	 * 变更状态—查看
	 */
	@Override
	public ProjectTaskChange selectChange(ProjectTaskChange projectTaskChange) throws Exception {
		return projectPlanTaskDao.selectChange(projectTaskChange);
	}

	/**
	 * 查看变更状态
	 * 
	 * @param projectTaskChange
	 * @return
	 */
	@Override
	public PageInfo<ProjectTaskChange> selectChangeStatus(ProjectTaskChange projectTaskChange) throws Exception {
		PageHelper.startPage(projectTaskChange.getPage(), projectTaskChange.getPageSize());
		List<ProjectTaskChange> selectChangeStatus = projectPlanTaskDao.selectChangeStatus(projectTaskChange);
		return new PageInfo<ProjectTaskChange>(selectChangeStatus);
	}

	/**
	 * 变更状态—确认
	 */
	@Transactional
	@Override
	public boolean updateProjectTaskChange(ProjectTaskChange projectTaskChange) throws Exception {
		logger.debug("变更状态—确认");
		// 通过变更ID查看变更对象
		ProjectTaskChange selectChange = projectPlanTaskDao.selectChange(projectTaskChange);
		// 将消息中的信息填充到消息对象中
		SysMessage msg = new SysMessage();
		msg.setGenerateDatetime(new Timestamp(System.currentTimeMillis()));
		msg.setMessageContent(selectChange.getProjChangeContent());
		msg.setMessageSender(selectChange.getPublishUserId());
		msg.setMessageReceiver(selectChange.getTargetUserId());
		dao.insertSysMessage(msg);
		selectChange.setChangeStatus(400902);
		int count = projectPlanTaskDao.updateProjectTaskChange(selectChange);
		if (0 == count) {
			return false;
		}
		return true;
	}

	/**
	 * 查询前置计划
	 * 
	 * @param projectTaskDetailplan
	 * @return
	 */
	@Override
	public List<ProjectTaskDetailplan> selectFrontPlan() throws Exception {
		return projectPlanTaskDao.selectFrontPlan();
	}

	/**
	 * 任务的变更
	 * 
	 * @param projectTaskChange
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean insertTaskChange(ProjectTaskChange projectTaskChange) throws Exception {
		logger.debug("任务的变更");
		// 将任务的ID设置为任务变更的关联ID
		// projectPlanTask.getProjectTaskChange().setProjTaskId(projectPlanTask.getProjTaskId());
		projectTaskChange.setProjTaskId(projectTaskChange.getProjectPlanTask().getProjTaskId());
		int count = projectPlanTaskDao.insertTaskChange(projectTaskChange);
		if (0 == count) {
			return false;
		}
		return true;
	}

	/**
	 * 任务-采购
	 * 
	 * @param projectPurchaseTask
	 * @return
	 */
	@Override
	public PageInfo<ProjectPurchaseTask> selectPurchase(ProjectPurchaseTask projectPurchaseTask) throws Exception {
		PageHelper.startPage(projectPurchaseTask.getPage(), projectPurchaseTask.getPageSize());
		List<ProjectPurchaseTask> selectPurchase = projectPlanTaskDao.selectPurchase(projectPurchaseTask);
		return new PageInfo<ProjectPurchaseTask>(selectPurchase);
	}

	/**
	 * 移到库存
	 * 
	 * @param projectPurchaseTask
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean updatePurchase(ProjectPurchaseTask projectPurchaseTask) throws Exception {
		logger.debug("移到库存");
		// 从数据库中查询出数量
		Integer number = projectPlanTaskDao.selectPurchaseCount(projectPurchaseTask.getProjectPurchaseId());
		// 如果数据库中的数量不为0 就执行移除
			// 如果移除数量小于数据库中的数量
			if (projectPurchaseTask.getPurchaseCount() <= number) {
				logger.debug("如果移除数量小于数据库中的数量");
				int count = projectPlanTaskDao.updatePurchase(projectPurchaseTask);
				if (0 == count) {
					return false;
				}
				if (projectPurchaseTask.getPurchaseCount() == number) {
					logger.debug("当采购表中数量为0时删除该条记录");
					//当采购表中数量为0时删除该条记录
					int count1 = projectPlanTaskDao.deletePurchase(projectPurchaseTask);
					if (0 == count1) {
						return false;
					}
				}
				//查询仓库中是否已经有该资源
				CreateResourceWarehouse crwd = projectPlanTaskDao
						.selectCreateResourceWarehouseDetail(projectPurchaseTask.getProjectPurchaseId());
				if (null != crwd) {//查询仓库中是已经有该资源修改该资源的数量
					logger.debug("查询仓库中是已经有该资源修改该资源的数量");
					crwd.setStockCount(projectPurchaseTask.getPurchaseCount());
					int count1 = projectPlanTaskDao.updateCreateResourceWarehouseReduce(crwd);
					if (0 == count1) {
						return false;
					}
				} else {//查询仓库中没有该资源就添加该资源
					logger.debug("查询仓库中没有该资源就添加该资源");
					CreateResourceWarehouse crw = new CreateResourceWarehouse();
					crw.setStockCount(projectPurchaseTask.getPurchaseCount());
					crw.setCreateResourceId(projectPurchaseTask.getProjectPurchaseId());
					crw.setResourceType(projectPurchaseTask.getPurchaseType());
					int count2 = projectPlanTaskDao.insertCreateResourceWarehouse(crw);
					if (0 == count2) {
						return false;
					}
				}
			}
		return true;
	}

	/**
	 * 移到库存：资源仓库数据插入
	 * 
	 * @param projectPurchaseTask
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertCreateResourceWarehouse(CreateResourceWarehouse createResourceWarehouse) throws Exception {
		logger.debug("移到库存：资源仓库数据插入");
		CreateResourceWarehouse crwd = projectPlanTaskDao
				.selectCreateResourceWarehouseDetail(createResourceWarehouse.getStockId());
		if (null != crwd) {
			logger.debug("修改库存数量");
			int count = projectPlanTaskDao.updateCreateResourceWarehouseReduce(createResourceWarehouse);
			if (0 == count) {
				return false;
			}
		} else {
			logger.debug("插入库存中");
			int count = projectPlanTaskDao.insertCreateResourceWarehouse(createResourceWarehouse);
			if (0 == count) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 任务的采购
	 * 
	 * @param ProjectPlanTask
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean insertTaskPurchase(ProjectPlan projectPlan) throws Exception {
		logger.debug("任务的采购");
		// 获取任务对象
		ProjectPlanTask projectPlanTask = projectPlan.getProjectPlanTask();
		// 获取项目ID
		Long selectProjId = projectPlanTaskDao.selectProjId(projectPlanTask.getUndertakeUserId());
		ProjectPlanTask selectTaskDetails = projectPlanTaskDao.selectTaskDetails(projectPlanTask);
		if (null != selectTaskDetails) {
			// 获取计划中的计划ID设置到任务中去
			// projectPlanTask.setProjPlanId(projectPlan.getProjPlanId());
			// 获取计划中的项目ID设置到任务采购中的项目ID中
			projectPlanTask.getProjectPurchaseTask().setProjectId(selectProjId);
			// 将任务的ID设置为项目采购的关联任务ID中
			projectPlanTask.getProjectPurchaseTask().setProjectTaskId(projectPlanTask.getProjTaskId());
			logger.debug("采购的新增");
			int count = projectPlanTaskDao.insertTaskPurchase(projectPlanTask.getProjectPurchaseTask());
			if (0 == count) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 进度—提交产物
	 * 
	 * @param taskProduct
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean insertTaskProduct(TaskProduct taskProduct) throws Exception {
		logger.debug("进度—提交产物");
		// 这里是获取任务ID放到产物里的关联任务ID中
		taskProduct.setProjTaskId(taskProduct.getProjTaskId());
		int count = projectPlanTaskDao.insertTaskProduct(taskProduct);
		if (0 == count) {
			return false;
		}
		return true;

	}

	/**
	 * 进度—完成
	 * 
	 * @param taskProduct
	 * @return
	 */
	@Transactional
	@Override
	public boolean updateFinish(ProjectTaskDetailplan projectTaskDetailplan) throws Exception {
		logger.debug("进度—完成");
		int count = projectPlanTaskDao.updateFinish(projectTaskDetailplan);
		if (0 == count) {
			return false;
		}
		//判断是否所有任务计划都已完成 等于0
		Integer number = projectPlanTaskDao.selectAllTaskPlan(projectTaskDetailplan);
		if(0 == number){
			//更新任务状态 
			logger.debug("更新任务状态 ");
			int updateTaskStatus = projectPlanTaskDao.updateTaskStatus(projectTaskDetailplan);
			if(0 == updateTaskStatus){
				return false;
			}
			//更新计划状态
			logger.debug("更新计划状态");
			int updateStarts = projectPlanTaskDao.updatePlanStatus(projectTaskDetailplan);
			if(0 == updateStarts){
				return false;
			}
			//判断是否父计划的子计划全部完成 等于0
			Integer selectAllChildren = projectPlanTaskDao.selectAllChildren(projectTaskDetailplan);
			if(0 == selectAllChildren){
				//查询父计划的ID
				Long parentId = projectPlanTaskDao.selectParentId(projectTaskDetailplan);
				//更新父计划状态
				logger.debug("更新父计划状态");
				projectPlanTaskDao.updateParentStatus(parentId);
			}
		}
		return true;
	}

	/**
	 * 进度—开始
	 * 
	 * @param taskProduct
	 * @return
	 */
	@Transactional
	@Override
	public boolean updateStart(ProjectTaskDetailplan projectTaskDetailplan) throws Exception {
		logger.debug("进度—开始");
		int count = projectPlanTaskDao.updateStart(projectTaskDetailplan);
		if (0 == count) {
			return false;
		}
		// 判断该任务计划对应的任务的实际开始时间有没有值
		Date selectStartTimer = projectPlanTaskDao.selectStartTimer(projectTaskDetailplan.getSubTaskId());
		if (selectStartTimer == null) {
			// 设置任务的开始时间
			logger.debug("设置任务的开始时间");
			int updateStartTimer = projectPlanTaskDao.updateStartTimer(projectTaskDetailplan);
			if (0 == updateStartTimer) {
				return false;
			}
			// 设置计划的开始时间
			logger.debug("设置计划的开始时间");
			int updatePlanTimer = projectPlanTaskDao.updatePlanTimer(projectTaskDetailplan);
			if (0 == updatePlanTimer) {
				return false;
			}
			// 判断该任务计划对应的任务的计划的父计划的实际开始时间有没有值
			Date selectPlanTimer = projectPlanTaskDao.selectPlanTimer(projectTaskDetailplan);
			if (selectPlanTimer == null) {
				// 查询父计划ID
				Long subTaskId = projectPlanTaskDao.selectParentId(projectTaskDetailplan);
				// 设置计划的开始时间
				logger.debug("设置计划的开始时间");
				int updateParentPlanTimer = projectPlanTaskDao.updateParentPlanTimer(subTaskId);
				if (0 == updateParentPlanTimer) {
					return false;
				}
			}
		}

		return true;
	}

}
