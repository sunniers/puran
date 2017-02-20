/**
 * SystemConstant.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.util;

/***
 * 系统常量
 */
public class SystemConstant {
	/**
	 * 基础常量
	 */
	/** 成功编号 */
	public static final String SUCCESS = "10000";

	/** 失败编号 */
	public static final String NORMAL_ERROR = "40000";

	/** 保存失败 */
	public static final String SAVE_ERROR = "40001";
	public static final String SAVE_ERROR_MSG = "保存失败";

	/** 查询失败 */
	public static final String SEARCH_ERROR = "40002";
	public static final String SEARCH_ERROR_MSG = "查询失败";

	/** 删除失败 */
	public static final String DELETE_ERROR = "40003";
	public static final String DELETE_ERROR_MSG = "删除失败";

	/** 验证失败 */
	public static final String CHECK_ERROR = "40004";
	public static final String CHECK_ERROR_MSG = "验证失败";
	
	/** 会话过期 */
	public static final String SESSION_ERROR = "40005";
	public static final String SESSION_ERROR_MSG = "获取会话失败";

	/** 删除状态 */
	public static final Byte DELETE_ACTIVE_FALSE = 1;

	/** 未删除状态 */
	public static final Byte DELETE_ACTIVE_TRUE = 0;
	/** 已确定 */
	public static final Byte IS_CONFIRM_TRUE = 1;

	/** 未确定 */
	public static final Byte IS_CONFIRM_FALSE = 0;

	/** 表示前台 */
	public static final String PECEPTION = "peception";

	/** 表示后台 */
	public static final String BACK = "back";

	/** 表示个人用户 */
	public static final String USER = "100501";

	/** 表示企业用户 */
	public static final String COMPANY = "100502";

	/** 表示进行中的项目 */
	public static final String RUNNING_PROJ = "runningProj";

	/** 表示报名中项目 */
	public static final String ENROLL_PROJ = "enrollProj";

	/** 表示完成的项目 */
	public static final String END_PROJ = "endProj";
	/** 当前登录的用户 */
	public static final String session_account_id = "CURRENT_SESSION_LOGIN_ACCOUNT_ID";
	public static final String session_detail_name = "SESSION_NAME";

	public static final String FILEPASE = "file/";
	
	/** 创意需求分类字典CODE*/
	public static final String DICT_CREATIVE_REQUIREMENT_TYPE = "700001";
	
	/** 人才需求分类字典CODE*/
	public static final String DICT_TALENT_REQUIREMENT_TYPE = "700002";
	
	/** 融资需求分类字典CODE*/
	public static final String DICT_FANCING_REQUIREMENT_TYPE = "700003";
	
	/** 创意人才分类字典CODE*/
	public static final String DICT_CREATIVE_TALENT_TYPE = "700004";
	
	/** 创意资源分类字典CODE*/
	public static final String DICT_CREATIVE_RESOURCE_TYPE = "700005";

	/** 注册时路径 */
	public static final String LOGIN_PATH = "resources/html/front/emailVerification.html";
	
	/** 邮箱找回密码 */
	public static final String FING_PATH = "resources/html/front/forgetPassword1.html";
}
