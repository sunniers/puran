package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.InvestCompanyDao;
import com.shdatabank.puruan.model.InvestCompany;
import com.shdatabank.puruan.model.InvestCompanyAudit;
import com.shdatabank.puruan.model.InvestPreference;
import com.shdatabank.puruan.service.InvestCompanyService;

/**
 * 投资机构Service实现类
 */
@Service
public class InvestCompanyServiceImpl implements InvestCompanyService {
	
	private Logger logger=Logger.getLogger(InvestCompanyServiceImpl.class);

	private final static String YES = "已审核";
	private final static int auditStatusY = 400702;//已通过
	private final static int auditStatusN = 400703;//未通过

	/** 投资机构Dao层 */
	@Autowired
	private InvestCompanyDao investCompanyDao;

	/**
	 * 查询投资机构 前台
	 */
	@Override
	public PageInfo<InvestCompany> selectAllResoursebyName(InvestCompany investCompany) throws Exception {
		PageHelper.startPage(investCompany.getPage(), investCompany.getPageSize());
		List<InvestCompany> investCompanys = investCompanyDao.selectAllInvestCompany(investCompany);
		for (int i = 0; i < investCompanys.size(); i++) {
			if (investCompanys.get(i) != null) {
				investCompanys.get(i).setPreference(spliteUse(investCompanys.get(i).getInvestPreference()));
				investCompanys.get(i).setDomain(spliteUse(investCompanys.get(i).getInvestDomain()));
			}
		}
		return new PageInfo<InvestCompany>(investCompanys);
	}

	/**
	 * 查询投资机构 后台
	 */
	@Override
	public PageInfo<InvestCompany> selectAllResourseBack(InvestCompany investCompany) throws Exception {
		PageHelper.startPage(investCompany.getPage(), investCompany.getPageSize());
		List<InvestCompany> investCompanys = null;
		if (YES.equalsIgnoreCase(investCompany.getSign())) {
			investCompanys = investCompanyDao.selectAllResourseYesBack(investCompany);
		} else {
			investCompanys = investCompanyDao.selectAllResourseNoBack(investCompany);
		}
		for (int i = 0; i < investCompanys.size(); i++) {
			investCompanys.get(i).setPreference(spliteUse(investCompanys.get(i).getInvestPreference()));
			investCompanys.get(i).setDomain(spliteUse(investCompanys.get(i).getInvestDomain()));
		}
		return new PageInfo<InvestCompany>(investCompanys);
	}

	/**
	 * 查询投资机构导出列表
	 */
	@Override
	public List<InvestCompany> selectResoursebyName(InvestCompany investCompany) throws Exception {
		List<InvestCompany> investCompanys = investCompanyDao.selectAllInvestCompany(investCompany);
		return investCompanys;
	}

	/**
	 * 投资机构详情查看
	 */
	@Override
	public InvestCompany findResoursebyId(InvestCompany investCompany) throws Exception {
		InvestCompany invest = investCompanyDao.findResoursebyId(investCompany);
		if (invest != null) {
			invest.setPreference(spliteUse(invest.getInvestPreference()));
			invest.setDomain(spliteUse(invest.getInvestDomain()));
		}

		return invest;
	}

	/**
	 * 查询所有投资偏好
	 */
	@Override
	public List<InvestPreference> findAllPreference() throws Exception {
		return investCompanyDao.findAllPreference();
	}

	/**
	 * 插入机构审核
	 * 
	 * @return
	 */
	@Transactional
	@Override
	public boolean insertInvestCompanyAudit(InvestCompanyAudit investCompanyAudit) throws Exception {
		logger.debug("添加投资机构审核信息");
		return investCompanyDao.insertInvestCompanyAudit(investCompanyAudit);
	}

	/**
	 * 分割字符串
	 * 
	 * @param str
	 * @return String[]
	 */
	public String[] spliteUse(String str) {
		if (str != null) {
			return str.split(",");
		} else {
			return null;
		}
	}

}
