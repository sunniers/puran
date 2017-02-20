package com.shdatabank.puruan.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;
/**
 * 文件上传路径保存
 * @author zhouyu
 *
 */
public class FileUpload {
	//文件上传  
    public static String uploadFile(MultipartFile file, HttpServletRequest request,String uploadDirectory) throws IOException {  
    	String fileName = file.getOriginalFilename();  
    	Long time = new Date().getTime();
        File tempFile = new File(uploadDirectory, time.toString()+fileName.substring(fileName.indexOf(".")));  
        
        if (!tempFile.exists()) {  
            tempFile.mkdir();  
        } 
        if (!tempFile.getParentFile().exists()) {  
            tempFile.getParentFile().mkdir();  
        }  
        if (!tempFile.exists()) {  
            tempFile.createNewFile();  
        }  
        file.transferTo(tempFile);
        //后缀
        String suffixName = fileName.substring(fileName.indexOf("."));
        File tf = new File(uploadDirectory, time.toString()+suffixName);
        //获取图片文件
        BufferedImage sourceImg =ImageIO.read(tf);
        if(sourceImg != null){  //图片文件压缩
        	int width = sourceImg.getWidth();
        	int height = sourceImg.getHeight();
        	String middlePath = uploadDirectory + "\\" + time.toString() + "_middle" + suffixName;
        	String smallPath = uploadDirectory + "\\" + time.toString() + "_small" + suffixName;
        	zipFile(tempFile,middlePath,width/16,height/16);
        	zipFile(tempFile,smallPath,width/32,height/32);
        }
        return ParamFileUtil.getConfigProperty("config", "returnFilePath")+tempFile.getName();  
    }  
    
    private static void zipFile(File tempFile,String zipPath,int width,int height) throws IOException{
    	Thumbnails.of(tempFile).size(width, height).toFile(zipPath);
    }
    
}
