package com.shdatabank.puruan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.InvestCompany;
import com.shdatabank.puruan.model.InvestCompanyAudit;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.InvestCompanyService;
import com.shdatabank.puruan.service.impl.ExportUtil;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 投资机构Controller层
 * Created by swc
 */
@Controller
@RequestMapping(value = "/invest")
public class InvestCompanyController {

	/**
	 * 投资机构Service层
	 */
	@Autowired
	private InvestCompanyService investCompanyService;
	
	@Autowired
	private HttpServletRequest httpServletRequest;

	/**
	 * 查询投资机构列表 前台
	 */
	@ResponseBody
	@RequestMapping(value = "findALL",method=RequestMethod.POST)
	public ReturnObject selectAllResoursebyName(@RequestBody InvestCompany investCompany) throws Exception {
		PageInfo<InvestCompany> investCompanys = investCompanyService.selectAllResoursebyName(investCompany);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", investCompanys);
	}
	/**
	 * 查询投资机构列表 后台
	 */
	@ResponseBody
	@RequestMapping(value = "findBack",method=RequestMethod.POST)
	public ReturnObject selectAllResourse(@RequestBody InvestCompany investCompany) throws Exception {
		PageInfo<InvestCompany> investCompanys = investCompanyService.selectAllResourseBack(investCompany);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", investCompanys);
	}
	
	/**
	 * 投资机构详情查看
	 */
	@ResponseBody
	@RequestMapping(value = "seek",method=RequestMethod.POST)
	public ReturnObject findResoursebyId(@RequestBody InvestCompany investCompany) throws Exception {
		InvestCompany invest= investCompanyService.findResoursebyId(investCompany);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", invest);
	}
	
	/**
	 * 投资偏好列表
	 */
	@ResponseBody
	@RequestMapping(value = "preference",method=RequestMethod.GET)
	public ReturnObject findAllPreference() throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", investCompanyService.findAllPreference());
	}
	
	/**
	 * 投资机构审核
	 * @param status 投资机构审核实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertRequirementAudit(@RequestBody InvestCompanyAudit investCompanyAudit) throws Exception {
		BackUser user = (BackUser) httpServletRequest.getSession().getAttribute("backUser");
		 if (null == user){
			 return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "需要先登录哦，亲");
		 }
		investCompanyAudit.setBackUserId(user.getUserId());
		//投资机构审核添加
        if (investCompanyService.insertInvestCompanyAudit(investCompanyAudit)) {
            //插入成功
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            //插入失败
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
	}

	/**
	 * 导出投资机构列表
	 */
	//@RequestMapping(value = "/excelDownload", method=RequestMethod.GET)
	public String exportExcel(String investCompanyName ,HttpServletResponse response) throws Exception {
		try {
			String fileName = new String(("投资机构列表").getBytes("gb2312"), "iso8859-1") + ".xlsx";
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.setCharacterEncoding("utf-8");
			/*
			 * response.setHeader("Content-disposition", "attachment; filename="
			 * + "exdddcel" + ".xlsx");// 组装附件名称和格式
			 */
			String[] titles = { "投资机构", "成立时间", "投资案例", "投资偏好", "投资领域" };
			InvestCompany investCompany=new InvestCompany();
			investCompany.setInvestCompanyName(investCompanyName);
			List<InvestCompany> investCompanys = investCompanyService.selectResoursebyName(investCompany);

			ServletOutputStream outputStream = response.getOutputStream();
			ExportUtil.ExportExcel(titles, investCompanys, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
