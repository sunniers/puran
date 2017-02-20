package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.InvestCompany;
import com.shdatabank.puruan.model.InvestCompanyAudit;
import com.shdatabank.puruan.model.InvestPreference;

/**
 * 投资机构Dao层
 *
 */
public interface InvestCompanyDao {

	/**
	 * 查询投资机构 前台
	 */
	public List<InvestCompany> selectAllInvestCompany(InvestCompany investCompany);
	/**
	 * 查询投资机构已审核 后台
	 */
	public List<InvestCompany> selectAllResourseYesBack(InvestCompany investCompany);
	/**
	 * 查询投资机构未审核 后台
	 */
	public List<InvestCompany> selectAllResourseNoBack(InvestCompany investCompany);

	/**
	 * 投资机构详情查看
	 */
	public InvestCompany findResoursebyId(InvestCompany investCompany);
	
	/**
	 * 所有投资爱好
	 */
	public List<InvestPreference> findAllPreference();
	/**
	 * 投资机构审核
	 * @return 
	 */
	public boolean insertInvestCompanyAudit(InvestCompanyAudit investCompanyAudit);
	
	
	
}
