/**
 * FindPwdServiceImpl.java
 * Created at 2016-10-20
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shdatabank.puruan.dao.IFindPwdDao;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.VerficationRequest;
import com.shdatabank.puruan.service.IFindPwdService;

/**
 * 忘记密码service层
 * 1.判断用户是否存在
 * 2.更新用户密码
 */
@Service
public class FindPwdServiceImpl implements IFindPwdService {

	private Logger logger=Logger.getLogger(FindPwdServiceImpl.class);
	
    /** 忘记密码dao */
    @Autowired
    private IFindPwdDao iFindPwdDao;
    @Autowired
	private HttpServletRequest request;
    
    /**
     * 判断用户是否存在
     * @param user 用户信息
     * @return 用户信息
     */
    @Override
    public User selectUserCount(User user) throws Exception{
        return iFindPwdDao.selectUserCount(user);
    }

    /**
     * 更新用户密码
     * @param user 用户信息
     */
    @Transactional
    @Override
    public boolean updateUserPwd(User user) throws Exception{
        int count = iFindPwdDao.updateUserPwd(user);
        logger.debug("--更新用户密码--");
        if (0 == count) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 验证码验证
     * @return 返回发送是否成功
     */
	@Override
	public boolean verification(VerficationRequest verficationRequest) throws Exception {
		String randomNmber= (String) request.getSession().getAttribute("randomNmber");
		if(verficationRequest.getVcode().equalsIgnoreCase(randomNmber)){
			return true;
		}else{
			return false;
		}
	}
}
