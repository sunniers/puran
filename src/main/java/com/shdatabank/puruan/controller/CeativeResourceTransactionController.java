package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.ProjectAndPurchase;
import com.shdatabank.puruan.model.ProjectPurchaseTask;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.CeativeResourceTransactionService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
/**
 * 购买的资源/出售的资源接口
 * 1、根据交易id查询单条资源交易详情
 * 2、根据资源交易状态查询资源交易状态集合(购买的资源)
 * 3、根据资源交易状态查询资源交易对象集合(出售的资源)
 * 4、更新资源交易的状态：（待支付），买方支付（待发货），买方取消支付（已关闭），卖方发货（待确认），买方确认收货（待评价），买方评价（已完成），
 * 5、将购买成功的资源添加到采购列表里
 * @author Administrator
 *
 */
@RequestMapping(value="/ceativeResourceTransaction")
@Controller
public class CeativeResourceTransactionController {	
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private CeativeResourceTransactionService ceativeResourceTransactionService;
	
	/**
	 * 根据交易id查询单条资源交易详情
	 * @param ceativeResourceTransaction 资源交易id
	 * @return 单个资源交易对象
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCeativeResourceTransaction",method=RequestMethod.POST)
    @ResponseBody
	public ReturnObject selectCeativeResourceTransaction(@RequestBody CeativeResourceTransaction ceativeResourceTransaction)throws Exception{
		CeativeResourceTransaction crt = ceativeResourceTransactionService.selectCeativeResourceTransaction(ceativeResourceTransaction);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",crt);
	}
	/**
	 * 根据资源交易状态查询资源交易状态集合(购买的资源)
	 * @param ceativeResourceTransaction 资源交易状态id
	 * @return 相应交易资源状态下的资源集合
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllCeativeResourceTransactionGm",method=RequestMethod.POST)
    @ResponseBody
	public ReturnObject selectAllCeativeResourceTransactionGm(@RequestBody CeativeResourceTransaction ceativeResourceTransaction)throws Exception{
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		PageInfo<CeativeResourceTransaction> ceativeResourceTransactionList = ceativeResourceTransactionService.selectAllCeativeResourceTransactionGm(ceativeResourceTransaction);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",ceativeResourceTransactionList);
	}
	/**
	 * 根据资源交易状态查询资源交易对象集合(出售的资源)
	 * @param ceativeResourceTransaction 资源状态transactionStatus
	 * @return 资源交易对象集合
	 */
	@RequestMapping(value="/selectAllCeativeResourceTransactionCs",method=RequestMethod.POST)
    @ResponseBody
	public ReturnObject selectAllCeativeResourceTransactionsCs(@RequestBody CeativeResourceTransaction ceativeResourceTransaction)throws Exception{
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		PageInfo<CeativeResourceTransaction> ceativeResourceTransactionList = ceativeResourceTransactionService.selectAllCeativeResourceTransactionCs(ceativeResourceTransaction);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",ceativeResourceTransactionList);
	}
	
	/**
	 * 更新资源交易的状态：（待支付），买方支付（待发货），买方取消支付（已关闭），卖方发货（待确认），买方确认收货（待评价），买方评价（已完成），
	 * @param ceativeResourceTransaction 资源id、资源状态
	 * @return
	 */
	@RequestMapping(value="/updateCeativeResourceTransaction",method=RequestMethod.POST)
    @ResponseBody
	public ReturnObject updateCeativeResourceTransaction(@RequestBody CeativeResourceTransaction ceativeResourceTransaction)throws Exception{
		if(ceativeResourceTransactionService.updateCeativeResourceTransaction(ceativeResourceTransaction)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 将购买成功的资源添加到采购列表里
	 * @param projectAndPurchase 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertProjectPurchase",method=RequestMethod.POST)
    @ResponseBody
	public ReturnObject insertProjectPurchase(@RequestBody ProjectAndPurchase projectAndPurchase)throws Exception{
		if(ceativeResourceTransactionService.insertProjectPurchase(projectAndPurchase)){
			//保存成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			//保存失败
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
	}
	@RequestMapping(value="/selectProjectPurchaseTask",method=RequestMethod.POST)
    @ResponseBody
	public ReturnObject selectProjectPurchaseTask(ProjectAndPurchase projectAndPurchase) throws Exception {
		ProjectPurchaseTask projectPurchaseTask = ceativeResourceTransactionService.selectProjectPurchaseTask(projectAndPurchase);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",projectPurchaseTask);
	}
}
