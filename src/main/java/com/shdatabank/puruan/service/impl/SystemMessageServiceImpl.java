/**
 * SystemMessageServiceImpl.java
 * Created at 2016-11-08
 * Created by zhouyu
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shdatabank.puruan.dao.SystemMessageDao;
import com.shdatabank.puruan.model.SysMessage;
import com.shdatabank.puruan.service.SystemMessageService;

/**
 * 系统消息实现类
 * @author zhouyu
 *
 */
@Service
public class SystemMessageServiceImpl implements SystemMessageService{
	@Autowired
	private SystemMessageDao dao;
	/**
	 * 获取系统消息
	 * 消息类型, 0:全部、1:已接收.2:未接收
	 */
	@Override
	public List<SysMessage> getSysMessage(int userId, int msgType) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		params.put("msgType", msgType);
		List<SysMessage> result = dao.getSysMessageByType(params);
		return result;
	}

	@Override
	public boolean acceptSysMessage(int userId, int msgId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		params.put("msgId", msgId);
		int count = dao.insertAcceptMessage(params);
		return count > 0;
	}

	@Override
	public boolean insertSysMessage(SysMessage msg) {
		return dao.insertSysMessage(msg) > 0;
	}

}
