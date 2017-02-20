package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.User;

/**
 * 用户服务
 * @author 周宇
 *
 */
public interface FrontUserService {
	/**
	 * 获取用户权限
	 * @param username
	 * @return
	 */
	User getUserByName(String username);

}
