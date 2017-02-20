package com.shdatabank.puruan.service.impl;

import org.springframework.stereotype.Service;

import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.FrontUserService;

/**
 * 用户服务实现类
 * @author Administrator
 *
 */
@Service
public class FrontUserServiceImpl implements FrontUserService{
	/**
	 * 根据用户名获取用户信息
	 */
	@Override
	public User getUserByName(String username) {
		User user = new User();		
		return user;
	}

}
