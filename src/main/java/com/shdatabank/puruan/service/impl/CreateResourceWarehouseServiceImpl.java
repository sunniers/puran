package com.shdatabank.puruan.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.CreateResourceWarehouseDao;
import com.shdatabank.puruan.dao.CreativeResourceDao;
import com.shdatabank.puruan.dao.ProjectPlanTaskDao;
import com.shdatabank.puruan.model.CreateResourceWarehouse;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.ProjectAndPurchase;
import com.shdatabank.puruan.model.ProjectAndTask;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.WarehouseAndResource;
import com.shdatabank.puruan.service.CreateResourceWarehouseService;

/**
 * 资源库存接口
 * @author Administrator
 *
 */
@Service
public class CreateResourceWarehouseServiceImpl implements CreateResourceWarehouseService {

	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private CreateResourceWarehouseDao createResourceWarehouseDao;
	
	@Autowired
	private CreativeResourceDao creativeResourceDao;
	
	@Autowired
	private ProjectPlanTaskDao projectPlanTaskDao;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 资源仓库查询资源集合
	 * @param createResourceWarehouse
	 * @return
	 */
	@Override
	public PageInfo<WarehouseAndResource> selectAllCreateResourceWarehouse(
			WarehouseAndResource warehouseAndResource) throws Exception {
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		warehouseAndResource.setUserId(user.getUserId());
		PageHelper.startPage(warehouseAndResource.getPage(), warehouseAndResource.getPageSize());
		List<WarehouseAndResource> warehouseAndResourceList = createResourceWarehouseDao.selectAllCreateResourceWarehouse(warehouseAndResource);
		return new PageInfo<WarehouseAndResource>(warehouseAndResourceList);
	}

	/**
	 * 仓库新增资源(供审核通过调用)
	 * @param createResourceWarehouse
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertCreateResourceWarehouse(CreateResourceWarehouse createResourceWarehouse) throws Exception {
		logger.debug("========================审核成功后往资源仓库中插入一条数据========================");
		CreativeResource cr = creativeResourceDao.selectCreativeResource(createResourceWarehouse.getCreateResourceId());
		createResourceWarehouse.setStockCount(cr.getResourceNumber());
		int success = createResourceWarehouseDao.insertCreateResourceWarehouse(createResourceWarehouse);
		if(0 == success){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 资源仓库查询单条资源详情
	 * @param stockId
	 * @return
	 */
	@Override
	public WarehouseAndResource selectCreateResourceWarehouseDetail(Long stockId) throws Exception {		
		return createResourceWarehouseDao.selectCreateResourceWarehouse(stockId);
	}

	/**
	 * 将仓库中的资源添加到采购列表里
	 */
	@Transactional
	@Override
	public boolean insertProjectPurchaseTask(ProjectAndPurchase projectAndPurchase) throws Exception {
		logger.debug("========================将仓库中的资源添加到采购列表里========================");
		WarehouseAndResource crw = createResourceWarehouseDao.selectCreateResourceWarehouse(projectAndPurchase.getStockId());
		//选择添加的数量不能大于资源的库存量
		if(projectAndPurchase.getNumber() > crw.getStockCount()){
			return false;
		}else{
			ProjectPurchaseTask ppt = new ProjectPurchaseTask();
			ppt.setProjectId(projectAndPurchase.getProjectId());
			ppt.setProjectTaskId(projectAndPurchase.getProjectTaskId());
			ppt.setCreateResourceId(crw.getCreateResourceId());
			ppt.setPurchaseProviderInfo(crw.getUserId());
			//如果没有选择任务，说明添加资源到项目采购列表/否则是添加到任务采购列表
			if(null == projectAndPurchase.getProjectTaskId()){
				ppt.setPurchaseType(130001);
			}
			ppt.setPurchaseType(130002);
			ppt.setPurchaseCost(crw.getResourcePrice());
			ppt.setPurchaseCount(projectAndPurchase.getNumber());
			int success = projectPlanTaskDao.insertTaskPurchase(ppt);
			//如果添加数据成功，就将仓库里资源的库存数量做削减
			createResourceWarehouseDao.updateCreateResourceWarehouseReduce(projectAndPurchase);
			if(0 == success){
				return false;
			}else{
				return true;
			}			
		}
	}

	/**
	 * 根据用户id查询负责的项目列表
	 */
	@Override
	public List<ProjectAndTask> selectAllProject(ProjectAndTask projectAndTask) throws Exception {
		return createResourceWarehouseDao.selectAllProject(projectAndTask);
	}

	/**
	 * 根据用户id查询承接的任务列表
	 */
	@Override
	public List<ProjectAndTask> selectAllTask(ProjectAndTask projectAndTask) throws Exception {
		return createResourceWarehouseDao.selectAllTask(projectAndTask);
	}

	/**
	 * 更新仓库库存
	 */
	@Transactional
	@Override
	public boolean updateCreateResourceWarehouseCount(CreateResourceWarehouse createResourceWarehouse) throws Exception {
		logger.debug("========================更新仓库库存========================");
		int success = createResourceWarehouseDao.updateCreateResourceWarehouseCount(createResourceWarehouse);
		if(0 == success){
			return false;
		}else{
			return true;
		}
		
	}

}
