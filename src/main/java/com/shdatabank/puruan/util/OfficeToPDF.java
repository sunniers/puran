/**
 * OfficeToPDF.java
 * Created at 2016-11-222
 * Created by fuqinwei
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.util;

import java.io.File;
import java.net.ConnectException;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFamily;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

/**
 * 把Office文件变换为PDF文件
 */
public class OfficeToPDF extends java.lang.Thread{

	  private File inputFile; // 需要转换的文件
	  private File outputFile; // 输出的文件

	  public OfficeToPDF(File inputFile, File outputFile) {
	    this.inputFile = inputFile;
	    this.outputFile = outputFile;
	  }

	  public void docToPdf() {
		DefaultDocumentFormatRegistry formatReg = new DefaultDocumentFormatRegistry();  
	    DocumentFormat pdfFormat = formatReg.getFormatByFileExtension("pdf");
	    //设置格式，适应高版本office
	    DocumentFormat df = new DocumentFormat("Microsoft office", DocumentFamily.TEXT, "application/office", "office");
	    // connect to an OpenOffice.org instance running on port 8100
	    OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
	    try {
	      connection.connect();
	      // convert
	      DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
	      converter.convert(this.inputFile, df,this.outputFile,pdfFormat);
	    } catch (ConnectException cex) {
	      cex.printStackTrace();
	    } finally {
	      // close the connection
	      if (connection != null) {
	        connection.disconnect();
	        connection = null;
	      }
	    }
	  }

	  /**
	   * 由于服务是线程不安全的，所以……需要启动线程
	   */
	  @Override
	  public void run() {
	    docToPdf();
	  }

	  public File getInputFile() {
	    return this.inputFile;
	  }

	  public void setInputFile(File inputFile) {
	    this.inputFile = inputFile;
	  }

	  public File getOutputFile() {
	    return this.outputFile;
	  }

	  public void setOutputFile(File outputFile) {
	    this.outputFile = outputFile;
	  }

	  /**
	   * @param args
	   */
	  public static void main(String[] args) {
		 OfficeToPDF tools = new OfficeToPDF(new File("D:/file/files/001.xlsx"), new File("D:/file/pdfFile/001.pdf"));
	    tools.start();
	  }
}
