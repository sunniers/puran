package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.InvestCompany;
import com.shdatabank.puruan.model.InvestCompanyAudit;
import com.shdatabank.puruan.model.InvestPreference;

/** 
 * 投资机构Service层
 */
public interface InvestCompanyService {

	/**
	 * 查询投资机构 前台
	 */
	public PageInfo<InvestCompany> selectAllResoursebyName(InvestCompany investCompany) throws Exception;
	
	/**
	 * 查询投资机构 后台
	 */
	public PageInfo<InvestCompany> selectAllResourseBack(InvestCompany investCompany) throws Exception;
	
	/**
	 * 查询投资机构导出列表
	 */
	public List<InvestCompany> selectResoursebyName(InvestCompany investCompany) throws Exception;
	
	/**
	 * 投资机构详情查看
	 */
	public  InvestCompany findResoursebyId(InvestCompany investCompany) throws Exception;
	/**
	 * 插入机构审核
	 * @return 
	 */
	public boolean insertInvestCompanyAudit(InvestCompanyAudit investCompanyAudit)throws Exception;
	
	/**
	 * 所有投资偏好
	 */
	public List<InvestPreference> findAllPreference() throws Exception;
}
