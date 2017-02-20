package com.shdatabank.puruan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.UserAuditDao;
import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.UserAudit;
import com.shdatabank.puruan.model.UserExtensionInfo;
import com.shdatabank.puruan.service.UserAuditService;

/**
 * 身份审核service实现层
 */
@Service
public class UserAuditServiceImpl implements UserAuditService{

	private Logger logger =Logger.getLogger(UserAuditServiceImpl.class);

	/** 身份审核dao层*/
	@Autowired
	private UserAuditDao userAuditDao;

	/**
	 * 企业审核列表
	 * @return 企业待审核信息
	 */
	@Override
	public PageInfo<Company> selectCompanyCreditAudit(UserAudit userAudit) throws Exception{
		PageHelper.startPage(userAudit.getPage(), userAudit.getPageSize());
		List<Company> companys = userAuditDao.selectCompanyCreditAudit(userAudit);
		 return new PageInfo<Company>(companys);
	}

	/**
	 * 个人审核列表
	 * @return 个人待审核信息
	 */
	@Override
	public PageInfo<UserExtensionInfo> selectUserExtensionInfoAudit(UserAudit userAudit) throws Exception{
		PageHelper.startPage(userAudit.getPage(), userAudit.getPageSize());
		List<UserExtensionInfo> userExtensionInfos = userAuditDao.selectUserExtensionInfoAudit(userAudit);
		return new PageInfo<UserExtensionInfo>(userExtensionInfos);
	}

	/**
	 * 企业审核信息查看
	 * @return 企业待审核信息
	 */
	@Override
	public Company findCompanyCreditAuditById(UserAudit userAudit) throws Exception {
		return userAuditDao.findCompanyCreditAuditById(userAudit);
	}

	/**
	 * 个人审核信息查看
	 * @return 个人待审核信息
	 */
	@Override
	public UserExtensionInfo findUserExtensionInfoAuditById(UserAudit userAudit) throws Exception {
		return userAuditDao.findUserExtensionInfoAuditById(userAudit);
	}
	/**
	 * 插入用户审核
	 * @return 
	 */
	@Transactional
	@Override
	public boolean insertUserAudit(UserAudit userAudit) throws Exception{
		int count=userAuditDao.insertUserAudit(userAudit);
		logger.debug("--添加用户审核信息--");
		if(count>0){
			boolean flag=userAuditDao.updateUserIsAudit(userAudit);
			if(flag==false){
				return false;
			}
		}
		return true;
	}
}
