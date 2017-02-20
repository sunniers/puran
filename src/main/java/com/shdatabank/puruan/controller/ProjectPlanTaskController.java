/**
 * ProjectPlanTaskController.java
 * Created at 2016-10-26
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CreateResourceWarehouse;
import com.shdatabank.puruan.model.ProjectPlan;
import com.shdatabank.puruan.model.ProjectPlanTask;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
import com.shdatabank.puruan.model.ProjectTaskChange;
import com.shdatabank.puruan.model.ProjectTaskDetailplan;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.TaskProduct;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.ProjectPlanTaskService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 
 * 任务管理controller层
 *
 */
@Controller
@RequestMapping(value = "/task")
public class ProjectPlanTaskController {
	/** 任务管理service注入 */
	@Autowired
	private ProjectPlanTaskService projectPlanTaskService;
	@Autowired
	private HttpServletRequest httpServletRequest;

	/**
	 * 查看任务列表
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectPrPlanTask", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectPrPlanTask(@RequestBody ProjectPlanTask projectPlanTask) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		// 如果USER为空时
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
		projectPlanTask.setUndertakeUserId(user.getUserId());
		PageInfo<ProjectPlanTask> selectPrPlanTask = projectPlanTaskService.selectPrPlanTask(projectPlanTask);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectPrPlanTask);
	}

	/**
	 * 查询任务的详情
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectTaskDetails", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectTaskDetails(@RequestBody ProjectPlanTask projectPlanTask) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		// 如果USER为空时
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
		projectPlanTask.setUndertakeUserId(user.getUserId());
		ProjectPlanTask selectTaskDetails = projectPlanTaskService.selectTaskDetails(projectPlanTask);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectTaskDetails);
	}

	/**
	 * 任务计划
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectTaskDetailplan", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectTaskDetailplan(@RequestBody ProjectPlanTask projectPlanTask) throws Exception {
		PageInfo<ProjectPlanTask> selectTaskDetailplan = projectPlanTaskService.selectTaskDetailplan(projectPlanTask);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectTaskDetailplan);
	}

	/**
	 * 计划—查看
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/viewTaskDetailplan", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject viewTaskDetailplan(@RequestBody ProjectTaskDetailplan projectTaskDetailplan) throws Exception {
		ProjectTaskDetailplan viewTaskDetailplan = projectPlanTaskService.viewTaskDetailplan(projectTaskDetailplan);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", viewTaskDetailplan);
	}

	/**
	 * 新增任务计划
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertTaskDetailplan", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertTaskDetailplan(@RequestBody ProjectPlanTask projectPlanTask) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		// 如果USER为空时
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
		projectPlanTask.getProjectTaskDetailplans().get(0).setPlanExecutant(user.getUserId());
		// 将从页面上获取任务。
		if (projectPlanTaskService.insertTaskDetailplan(projectPlanTask)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}

	/**
	 * 计划—修改
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateTaskDetailplan", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateTaskDetailplan(@RequestBody ProjectTaskDetailplan projectTaskDetailplan)
			throws Exception {
		// 将从页面上获取任务。
		if (projectPlanTaskService.updateTaskDetailplan(projectTaskDetailplan)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}

	/**
	 * 删除任务计划
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteTaskDetailplan", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject deleteTaskDetailplan(@RequestBody ProjectTaskDetailplan projectTaskDetailplan)
			throws Exception {
		// 将从页面上获取任务。
		if (projectPlanTaskService.deleteTaskDetailplan(projectTaskDetailplan)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}

	/**
	 * 变更状态—查看
	 * 
	 * @param projectTaskChange
	 * @return
	 */
	@RequestMapping(value = "/selectChange", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectChange(@RequestBody ProjectTaskChange projectTaskChange) throws Exception {
		// 将从页面上获取任务。
		ProjectTaskChange selectChange = projectPlanTaskService.selectChange(projectTaskChange);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectChange);
	}

	/**
	 * 变更状态
	 * 
	 * @param projectTaskChange
	 * @return
	 */
	@RequestMapping(value = "/selectChangeStatus", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectChangeStatus(@RequestBody ProjectTaskChange projectTaskChange) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		// 如果USER为空时
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
		projectTaskChange.setPublishUserId(user.getUserId());
		// 将从页面上获取任务。
		PageInfo<ProjectTaskChange> selectChangeStatus = projectPlanTaskService.selectChangeStatus(projectTaskChange);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectChangeStatus);
	}

	/**
	 * 查询前置计划
	 * @param projectTaskDetailplan
	 * @return
	 */
	@RequestMapping(value = "/selectFrontPlan", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectFrontPlan() throws Exception {
		// 将从页面上获取任务。
		 List<ProjectTaskDetailplan> selectFrontPlan = projectPlanTaskService.selectFrontPlan();
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectFrontPlan);
	}
	/**
	 * 变更状态—确认
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateProjectTaskChange", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateProjectTaskChange(@RequestBody ProjectTaskChange projectTaskChange) throws Exception {
		// 将从页面上获取任务。
		if (projectPlanTaskService.updateProjectTaskChange(projectTaskChange)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}

	/**
	 * 任务的变更
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertTaskChange", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertTaskChange(@RequestBody ProjectTaskChange projectTaskChange) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		// 如果USER为空时
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
		projectTaskChange.setPublishUserId(user.getUserId());
		// 将从页面上获取任务。
		if (projectPlanTaskService.insertTaskChange(projectTaskChange)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 任务-采购
	 * 
	 * @param projectTaskChange
	 * @return
	 */
	@RequestMapping(value = "/selectPurchase", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectPurchase(@RequestBody ProjectPurchaseTask projectPurchaseTask) throws Exception {
		// 将从页面上获取任务。
		PageInfo<ProjectPurchaseTask> selectPurchase = projectPlanTaskService.selectPurchase(projectPurchaseTask);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", selectPurchase);
	}

	/**
	 * 移到库存：数量减
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updatePurchase", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject updatePurchase(@RequestBody ProjectPurchaseTask projectPurchaseTask) throws Exception {
		// 将从页面上获取任务。
		if (projectPlanTaskService.updatePurchase(projectPurchaseTask)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 测试库存数量增加
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertCreateResourceWarehouse", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertCreateResourceWarehouse(@RequestBody CreateResourceWarehouse createResourceWarehouse) throws Exception {
		// 将从页面上获取任务。
		if (projectPlanTaskService.insertCreateResourceWarehouse(createResourceWarehouse)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 任务的采购
	 * 
	 * @param projectPlanTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertTaskPurchase", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertTaskPurchase(@RequestBody ProjectPlan projectPlan) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		// 如果USER为空时
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
		projectPlan.getProjectPlanTask().setUndertakeUserId(user.getUserId());
		// 将从页面上获取任务。
		if (projectPlanTaskService.insertTaskPurchase(projectPlan)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}

	/**
	 * 进度—提交产物
	 * 
	 * @param taskProduct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertTaskProduct", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertTaskProduct(@RequestBody TaskProduct taskProduct) throws Exception {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		// 如果USER为空时
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
		}
		taskProduct.setUserId(user.getUserId());
		// 将从页面上获取任务。
		if (projectPlanTaskService.insertTaskProduct(taskProduct)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}

	/**
	 * 进度—完成
	 * 
	 * @param taskProduct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateFinish", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateFinish(@RequestBody ProjectTaskDetailplan projectTaskDetailplan) throws Exception {
		// 将从页面上获取任务。
		if (projectPlanTaskService.updateFinish(projectTaskDetailplan)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 *  进度—开始
	 * 
	 * @param taskProduct
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStart", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateStart(@RequestBody ProjectTaskDetailplan projectTaskDetailplan) throws Exception {
		// 将从页面上获取任务。
		if (projectPlanTaskService.updateStart(projectTaskDetailplan)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}

}
