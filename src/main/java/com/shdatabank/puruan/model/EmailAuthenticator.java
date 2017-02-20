/**
 * EmailAuthenticator.java
 * Created at 2016-10-17
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮箱用户名密码
 */
public class EmailAuthenticator extends Authenticator{

    /** 用户名 */
    private String username = null;
    
    /** 密码 */
    private String password = null;  
  
    /**
     * 无参构造方法
     */
    public EmailAuthenticator() {  
    
    };
  
    /**
     * 全参构造方法
     * @param username
     * @param password
     */
    public EmailAuthenticator(String username, String password) {  
        this.username = username;  
        this.password = password;  
    }  
  
    /**
     * 获取用户名和密码
     */
    protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(username, password);  
    }  
}
