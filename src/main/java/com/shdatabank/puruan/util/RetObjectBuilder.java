/**
 * RetObjectBuilder.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.util;

import com.shdatabank.puruan.model.ReturnObject;

/**
 * 返回对象生成器
 * @author Gds
 *
 */
public class RetObjectBuilder {
	/**
	 * 根据消息生成controller返回对象
	 * @param retCode
	 * @param retMessage
	 * @param content
	 * @return
	 */
	public static ReturnObject generateRetObject(String retCode,String retMessage,Object content){
		ReturnObject result = new ReturnObject();
		result.setRetCode(retCode);
		result.setRetMessage(retMessage);
		result.setRetObject(content);
		return result;
	}
	
	/**
	 * 根据消息生成controller返回对象
	 * @param retCode
	 * @param retMessage
	 * @param content
	 * @return
	 */
	public static ReturnObject generateRetObject(String retCode){
		ReturnObject result = new ReturnObject();
		result.setRetCode(retCode);		
		return result;
	}
	
	/**
	 * 根据消息生成controller返回对象
	 * @param retCode
	 * @param retMessage
	 * @param content
	 * @return
	 */
	public static ReturnObject generateRetObject(String retCode,String retMessage){
		ReturnObject result = new ReturnObject();
		result.setRetCode(retCode);
		result.setRetMessage(retMessage);	
		return result;
	}
}
