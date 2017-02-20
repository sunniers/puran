/**
 * UserUtil.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shdatabank.puruan.model.EmailAuthenticator;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 通用类
 */
public class UserUtil {
	
	/**
	 * 可逆加密：执行一次加密，执行两次解密
	 * @param inStr
	 * @return
	 */
	public static String convertMD5(String inStr){  
		  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }
	
	/**
	 * 1.获取MD5转换器
	 * 2.将传过来的字符串参数转换成字符数组
	 * 3.进行字符串的转换
	 * 
	 * @author 高狄升
	 * @param pw 密码
	 * @return 返回一个进过MD5转换的字符串，长度为32个字符
	 */
	public static String stringMD5(String pw) {
		try {
			// 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// 输入的字符串转换成字节数组
			byte[] inputByteArray = pw.getBytes();
			// inputByteArray是输入字符串转换得到的字节数组
			messageDigest.update(inputByteArray);
			// 转换并返回结果，也是字节数组，包含16个元素
			byte[] resultByteArray = messageDigest.digest();
			// 字符数组转换成字符串返回
			return byteArrayToHex(resultByteArray);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	/**
	 * 进行MD5的转换
	 * 
	 * @author 高狄升
	 * @param byteArray 传过来的字符数组
	 * @return 将转换完成的字符串返回
	 */
	public static String byteArrayToHex(byte[] byteArray) {
		// 首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray = new char[byteArray.length * 2];
		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		// 字符数组组合成字符串返回
		return new String(resultCharArray);
	}
	
	/**
	 * 将日期类型的数据转换成字符串类型
	 * 
	 * @author 高狄升
	 * @param date 需要转换的日期
	 * @return 转换完成的日期
	 */
	public static String dateConversionString(Date date){
		//定义转换的格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//返回转换完成的值
		return sdf.format(date);
	}
	
	/**
	 * 将时间类型的数据转换成字符串类型
	 * 
	 * @author 高狄升
	 * @param timestamp 需要转换的时间
	 * @return 转换完成的时间
	 */
	public static String dateConversionString(Timestamp timestamp){
		//定义转换的格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//返回转换完成的值
		return sdf.format(timestamp);
	}
	
	/**
	 * 将字符串类型的数据转换成日期类型
	 * 
	 * @author 高狄升
	 * @param stringDate 字符串类型的日期
	 * @return 日期类型的日期
	 * @throws ParseException 抛出异常
	 */
	public static Date StringConversionDate(String stringDate) throws ParseException{
		//定义转换的格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//转换格式
		Date date = sdf.parse(stringDate);
		//返回转换完成的值
		return date;
	}
	
	/**
	 * 将字符串类型的数据转换成日期类型
	 * 
	 * @author 高狄升
	 * @param stringDate 字符串类型的日期
	 * @return 日期类型的日期
	 * @throws ParseException 抛出异常
	 */
	public static Timestamp StringConversionTimestamp(String stringDate) throws ParseException{
		//定义转换的格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//转换格式
		Date date = sdf.parse(stringDate);
		//返回转换完成的值
		return new Timestamp(date.getTime());
	}
	
	/**
	 * 验证码校验
	 * @param verificationCD 用户输入的验证码
	 * @param request 系统生成的验证码
	 * @return 是否成功
	 */
	public static boolean checkVerificationCD(String verificationCD,HttpServletRequest request){
		if(verificationCD.toUpperCase().equals(request.getSession().getAttribute("randomString"))){
			return true;
		}else{
			return false;
		}
	}

    /**
     * 随机字符字典
     */
    private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8',
        '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
        'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    
    /**
     * 随机数
     */
    private static Random random = new Random();
    
    /**
     * 获取6位随机数
     */
    private static String getRandomString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 4; i++)
        {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }
    
    /**
     * 获取随机数颜色
     */
    private static Color getRandomColor()
    {
        return new Color(random.nextInt(255),random.nextInt(255),
                random.nextInt(255));
    }
    
    /**
     * 返回某颜色的反色
     */
    private static Color getReverseColor(Color c)
    {
        return new Color(255 - c.getRed(), 255 - c.getGreen(),
                255 - c.getBlue());
    }
    
    /**
     * 生成图片
     * @param request
     * @param response
     * @throws Exception
     */
    public static void outputCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception{

    	//设置数据类型
        response.setContentType("image/jpeg");

        //随机把随机生成的数据保存到session中，session名为：randomString
        String randomString = getRandomString();
        request.getSession(true).setAttribute("randomString", randomString);

        //设置图片长宽
        int width = 130;
        int height = 55;

        Color color = getRandomColor();
        Color reverse = getReverseColor(color);

        //生成图片
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 15, 42);
        for (int i = 0, n = random.nextInt(100); i < n; i++) 
        {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }

        // 转成JPEG格式
        ServletOutputStream out = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(bi);
        out.flush();
    }
    
    /**
     * 发送邮箱验证
     * @param request
     * @param response
     */
    public static void sendEmail(String userName,String email,String path){
    	try {
    		Properties properties = new Properties();
			String to = email;
			String subject = "puruan邮箱验证";
			StringBuffer demo = new StringBuffer();
			StringBuffer sid = new StringBuffer();
			String code = getRandName();
			Long ts = new Date().getTime();
			//添加id信息
			
			sid.append(ParamFileUtil.getConfigProperty("config", "emailPuruanId"));
			sid.append("#");
			sid.append(userName);
			sid.append("#");
			sid.append(code);
			sid.append("#");
			sid.append(ts);
			
	        demo.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")
	        .append("<html>")
	        .append("<head>")
	        .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
	        .append("<title>邮箱认证</title>")
	        .append("<style type=\"text/css\">")
	        .append(".test{font-family:\"Microsoft Yahei\";font-size: 18px;color: red;}")
	        .append("</style>")
	        .append("</head>")
	        .append("<body>")   
	        .append("<lable>puruan邮箱验证：")
	        .append("<a href='"+ParamFileUtil.getConfigProperty("config", "emailUrl")+path+"?sid="+DesUtil.encrypt(sid.toString(), "wang11111")
	        +"' class=\"test\">点击此处认证</a>")
	        .append("</lable>")
	        .append("</body>")
	        .append("</html>");
	        System.out.println(sid.toString());
	        System.out.println(DesUtil.decrypt(DesUtil.encrypt(sid.toString(), "wang11111"),"wang11111"));
			String content = demo.toString();
			
			properties.put("mail.store.protocol", ParamFileUtil.getConfigProperty("config", "mail.store.protocol"));
			properties.put("mail.imap.socketFactory.class", ParamFileUtil.getConfigProperty("config", "socketFactory"));
			properties.put("mail.imap.socketFactory.fallback", "false");
			properties.put("mail.imaps.host", ParamFileUtil.getConfigProperty("config", "mail.imaps.host"));
			properties.put("mail.imaps.port", ParamFileUtil.getConfigProperty("config", "mail.imaps.port"));
			properties.put("mail.imap.auth.plain.disable", "true");
			properties.put("mail.imap.auth.login.disable", "true");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.debug", "true");
			properties.put("mail.smtp.host", ParamFileUtil.getConfigProperty("config", "mail.smtp.host"));
			properties.put("mail.smtp.port", ParamFileUtil.getConfigProperty("config", "mail.smtp.port"));
			properties.put("mail.smtp.socketFactory.class", ParamFileUtil.getConfigProperty("config", "mail.smtp.socketFactory.class"));
			properties.put("mail.smtp.socketFactory.fallback", "false");
			properties.put("mail.smtp.socketFactory.port", ParamFileUtil.getConfigProperty("config", "mail.smtp.port"));
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.user", ParamFileUtil.getConfigProperty("config", "emailUser"));
			Authenticator authenticator = new EmailAuthenticator(ParamFileUtil.getConfigProperty("config", "emailUser"), ParamFileUtil.getConfigProperty("config", "emailPwd"));
			javax.mail.Session sendMailSession = javax.mail.Session.getDefaultInstance(properties, authenticator);
			MimeMessage mailMessage = new MimeMessage(sendMailSession);

			mailMessage.setFrom(new InternetAddress(ParamFileUtil.getConfigProperty("config", "emailUser")));
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mailMessage.setSubject(subject, "UTF-8");
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			html.setContent(content.trim(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    /**
     * 获取随机名称
     * @return 随机名称
     */
    public static String getRandName() {
        //格式化日期
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        //获取5位随机数
        Random random = new Random();
        int rannum = (int)(random.nextDouble()*(99999-10000+1))+10000;
        return rannum + str;
    }
    
    /**
     * 转换pdf预览
     * @param filePath
     * @return
     * @throws Exception
     */
    public static String pdfChange(String filePath) throws Exception {
        try{
            //截取文件后缀名
            String end = filePath.substring(filePath.indexOf("."));
            //截取文件名+后缀名
            String fileEnd = filePath.substring(filePath.lastIndexOf("/")+1);
            //截取文件名
            String file = fileEnd.substring(0,fileEnd.indexOf("."));
            //拼接返回的pdf的路径
            String returnFilePath = ParamFileUtil.getConfigProperty("config", "returnPreviewPdfFilePath") + file +".pdf";
            //拼接生成的pdf路径
            String pdfFile = ParamFileUtil.getConfigProperty("config", "previewPdfFilePath") + "\\" + file + ".pdf";
            //拼接原始文件路径
            String startFile = ParamFileUtil.getConfigProperty("config", "filePath") + "\\" + fileEnd;
            //如果源文件就是pdf的文件的话则copy否则进行转换
            if (".pdf".equals(end.toLowerCase())) {
                UserUtil.fileCopy(new File(startFile), new File(pdfFile));
            } else {
                OfficeToPDF tools = new OfficeToPDF(new File(startFile)
                        , new File(pdfFile));
                tools.start();                  
            }
            //返回预览路径
            return returnFilePath;
        }catch(Exception e) {
            return null;
        }
    }
    
    /**
     * 文件COPY
     * @param f1
     * @param f2
     * @return
     * @throws Exception
     */
    public static long fileCopy(File f1,File f2) throws Exception{
        long time=new Date().getTime();
        int length=2097152;
        FileInputStream in=new FileInputStream(f1);
        FileOutputStream out=new FileOutputStream(f2);
        FileChannel inC=in.getChannel();
        FileChannel outC=out.getChannel();
        ByteBuffer b=null;
        while(true){
            if(inC.position()==inC.size()){
                inC.close();
                outC.close();
                return new Date().getTime()-time;
            }
            if((inC.size()-inC.position())<length){
                length=(int)(inC.size()-inC.position());
            }else
                length=2097152;
            b=ByteBuffer.allocateDirect(length);
            inC.read(b);
            b.flip();
            outC.write(b);
            outC.force(false);
        }
    }
}
