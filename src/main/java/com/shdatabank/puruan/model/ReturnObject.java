/**
 * ReturnObject.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

/**
 * 返回结果对象
 */
public class ReturnObject {
    /**
     * 返回消息代码
     */
    private String retCode;
    public String getRetCode() {
        return retCode;
    }
    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }
    /**
     * 返回消息
     */
    private String retMessage;
    public String getRetMessage() {
        return retMessage;
    }
    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
    /**
     * 返回对象
     */
    private Object retObject;
    public Object getRetObject() {
        return retObject;
    }
    public void setRetObject(Object retObject) {
        this.retObject = retObject;
    }
}
