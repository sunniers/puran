/**
 * SysMessage.java
 * Created at 2016-11-04
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.sql.Timestamp;

/**
 * 系统消息
 */
public class SysMessage {

	/** 消息id */
	private Long sysMessageId;
	/** 消息主题 */
	private String messageSubject;
	/** 消息标题 */
	private String messageTitle;
	/** 消息内容 */
	private String messageContent;
	/** 谁发送的消息 */
	private Long messageSender;
	/** 谁发送消息的姓名 */
	private String messageSenderName;
	/** 接收消息类型 */
	private Integer receiveMessageType;
	/** 接收人 */
	private Long messageReceiver;
	/** 接收人的姓名 */
	private String messageReceiverName;
	/** 产生消息时间 */
	private Timestamp generateDatetime;
	/** 是否接收 */
	private byte isGet;
	/** 消息接收时间 */
	private Timestamp getMessageTime;
	
	/** page */
	private Integer page;

	/** pageSize */
	private Integer pageSize;

	public String getMessageReceiverName() {
		return messageReceiverName;
	}

	public void setMessageReceiverName(String messageReceiverName) {
		this.messageReceiverName = messageReceiverName;
	}

	public byte getIsGet() {
		return isGet;
	}

	public void setIsGet(byte isGet) {
		this.isGet = isGet;
	}

	public Timestamp getGetMessageTime() {
		return getMessageTime;
	}

	public void setGetMessageTime(Timestamp getMessageTime) {
		this.getMessageTime = getMessageTime;
	}

	public Long getSysMessageId() {
		return sysMessageId;
	}

	public void setSysMessageId(Long sysMessageId) {
		this.sysMessageId = sysMessageId;
	}

	public String getMessageSubject() {
		return messageSubject;
	}

	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Long getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(Long messageSender) {
		this.messageSender = messageSender;
	}

	public Integer getReceiveMessageType() {
		return receiveMessageType;
	}

	public void setReceiveMessageType(Integer receiveMessageType) {
		this.receiveMessageType = receiveMessageType;
	}

	public Long getMessageReceiver() {
		return messageReceiver;
	}

	public void setMessageReceiver(Long messageReceiver) {
		this.messageReceiver = messageReceiver;
	}

	public Timestamp getGenerateDatetime() {
		return generateDatetime;
	}

	public void setGenerateDatetime(Timestamp generateDatetime) {
		this.generateDatetime = generateDatetime;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getMessageSenderName() {
		return messageSenderName;
	}

	public void setMessageSenderName(String messageSenderName) {
		this.messageSenderName = messageSenderName;
	}

}
