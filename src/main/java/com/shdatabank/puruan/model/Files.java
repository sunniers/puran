/**
 * MyCodeServiceImpl.java
 * Created at 2016-11-11
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

/**
 * 上传文件
 */
public class Files {

    /** 文件真实名称 */
    private String fileRealName;
    
    /** 文件路径 */
    private String filePath;

    public String getFileRealName() {
        return fileRealName;
    }

    public void setFileRealName(String fileRealName) {
        this.fileRealName = fileRealName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
}
