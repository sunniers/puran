/**
 * IDetailedInformationDao.java
 * Created at 2016-11-08
 * Created by zhouyu
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.dao;

import java.util.List;
import java.util.Map;
import com.shdatabank.puruan.model.SysMessage;

/**
 * 系统消息dao
 * @author zhouyu
 *
 */
public interface SystemMessageDao {
	/**
	 * 获取系统消息
	 * @param params 0:全部、1:已接收.2:未接收
	 * @return
	 */
	List<SysMessage> getSysMessageByType(Map<String,Object> params);
	/**
	 * 插入接收消息
	 * @param userId
	 * @param msgId
	 * @return
	 */
	int insertAcceptMessage(Map<String,Object> params);
	/**
	 * 插入消息
	 * @param msg
	 * @return
	 */
	int insertSysMessage(SysMessage msg);
}
