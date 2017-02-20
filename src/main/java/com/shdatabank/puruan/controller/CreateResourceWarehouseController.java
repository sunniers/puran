package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CreateResourceWarehouse;
import com.shdatabank.puruan.model.ProjectAndPurchase;
import com.shdatabank.puruan.model.ProjectAndTask;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.WarehouseAndResource;
import com.shdatabank.puruan.service.CreateResourceWarehouseService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
/**
 * 资源仓库接口
 * 1、资源仓库列表查询
 * 2、资源仓库添加资源
 * 3、库存对象详细信息查询
 * 4、从资源仓库往项目/任务里添加资源
 * 5、查询该用户负责的所有项目
 * 6、查询该用户承接对应项目下的所有任务
 * @author Administrator
 */
@Controller
@RequestMapping(value="/createResourceWarehouse")
public class CreateResourceWarehouseController {

	@Autowired
	private CreateResourceWarehouseService createResourceWarehouseService;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	/**
	 * 资源仓库列表查询
	 * @param createResourceWarehouse
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllCreateResourceWarehouse",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllCreateResourceWarehouse(@RequestBody WarehouseAndResource warehouseAndResource)throws Exception{				
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		PageInfo<WarehouseAndResource> warehouseAndResourceList = createResourceWarehouseService.selectAllCreateResourceWarehouse(warehouseAndResource);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",warehouseAndResourceList);
	}
	
	/**
	 * 资源仓库添加资源
	 * @param createResourceWarehouse
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertCreateResourceWarehouse",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertCreateResourceWarehouse(@RequestBody CreateResourceWarehouse createResourceWarehouse)throws Exception{
		if(createResourceWarehouseService.insertCreateResourceWarehouse(createResourceWarehouse)){
			//保存成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			//保存失败
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
	}
	
	/**
	 * 资源仓库查询单条资源详情 
	 * @param 仓库id
	 * @return
	 */
	@RequestMapping(value="/selectCreateResourceWarehouseDetail",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectCreateResourceWarehouseDetail(@RequestBody CreateResourceWarehouse createResourceWarehouse)throws Exception{
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",createResourceWarehouseService.selectCreateResourceWarehouseDetail(createResourceWarehouse.getStockId()));
	}
	
	/**
	 * 从资源仓库往项目/任务里添加资源
	 * @param projectPurchaseTask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertResourseProjectPurchaseTask",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertResourseProjectPurchaseTask(@RequestBody ProjectAndPurchase projectAndPurchase)throws Exception{
		if(createResourceWarehouseService.insertProjectPurchaseTask(projectAndPurchase)){
			//保存成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			//保存失败
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 查询该用户负责的所有项目
	 * @param projectAndTask
	 * @return 项目对象集合
	 */
	@RequestMapping(value="/selectAllProject",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllProject()throws Exception{
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		ProjectAndTask projectAndTask = new ProjectAndTask();
		projectAndTask.setUserId(user.getUserId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",createResourceWarehouseService.selectAllProject(projectAndTask));
	}
	/**
	 * @param projectAndTask
	 * 查询该用户承接对应项目下的所有任务
	 * @return 任务对象集合
	 */
	@RequestMapping(value="/selectAllTask",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllTask(@RequestBody ProjectAndTask projectAndTask)throws Exception{
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		projectAndTask.setUserId(user.getUserId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",createResourceWarehouseService.selectAllTask(projectAndTask));
	}
	
	/**
	 * 修改库存数量
	 * @param createResourceWarehouse
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCreateResourceWarehouseCount",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateCreateResourceWarehouseCount(@RequestBody CreateResourceWarehouse createResourceWarehouse)throws Exception{
		if(createResourceWarehouseService.updateCreateResourceWarehouseCount(createResourceWarehouse)){
			//插入成功
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			//插入失败
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
	}
}
