/**
 * LoginController.java
 * Created at 2016-10-27
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shdatabank.puruan.model.Files;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.util.FileUpload;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 上传文件controller层
 * 
 * 
 *  */
@Controller
@RequestMapping("/upload")
public class UploadController {
	
	public static final String FILE_PATH = "/resources/images/"; 
	public static final String CATEGORY = FILE_PATH;
	public static final String WC_INFO = FILE_PATH;
	@Value("#{freemarkerConfiguration['filePath']}")
	public String filePath;
	/**
	 * 上传文件
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/file", produces = "text/plain;charset=UTF-8")
	@ResponseBody
    public String uploadSheshi(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {  
	    StringBuffer sb = new StringBuffer();
	    sb.append("{");
	    sb.append("\"name\":");
	    sb.append("\"");
	    sb.append(file.getOriginalFilename());
	    sb.append("\"");
		String fp = FileUpload.uploadFile(file, request,filePath);  
		Files files = new Files();
		files.setFilePath(fp);
		files.setFileRealName(file.getName());
		sb.append(",");
		sb.append("\"path\":");
		sb.append("\"");
		sb.append(fp);
		sb.append("\"");
		sb.append("}");
		return sb.toString();
		//return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",files);
    } 
	
	
}
