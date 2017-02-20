/**
 * SystemMessageService.java
 * Created at 2016-11-08
 * Created by zhouyu
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import java.util.List;

import com.shdatabank.puruan.model.SysMessage;

/**
 * 系统消息服务接口
 * @author zhouyu
 *
 */
public interface SystemMessageService {
	/**
	 * 获取系统的消息
	 * @param userId 用户id
	 * @param msgType  消息类型, 0:全部、1:已接收.2:未接收
	 * @return
	 */
	List<SysMessage> getSysMessage(int userId,int msgType);
	/**
	 * 接收消息
	 * @param userId
	 * @param msgId
	 * @return
	 */
	boolean acceptSysMessage(int userId,int msgId);
	/**
	 * 插入消息
	 * @param msg
	 * @return
	 */
	boolean insertSysMessage(SysMessage msg);
}
