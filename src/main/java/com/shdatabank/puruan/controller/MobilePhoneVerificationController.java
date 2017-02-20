package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.VerficationRequest;
import com.shdatabank.puruan.service.MobilePhoneVerificationService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 手机认证controller层
 * @author swc
 */
@Controller
@RequestMapping(value="/mobile_certification")
public class MobilePhoneVerificationController {

	@Autowired
	private MobilePhoneVerificationService mobilePhoneVerificationService;
	@Autowired
	private HttpServletRequest request;
	
	/**
     * 生成验证码 发送消息
     * @param request
     * @param response
     */
    @RequestMapping(value="/send", method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject sendMessage(@RequestBody VerficationRequest verficationRequest) throws Exception {
    	User user = (User) request.getSession().getAttribute("user");
		 if (null == user){
			 return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "需要先登录哦，亲");
		 }
    	 String result=mobilePhoneVerificationService.sendMessage(verficationRequest);
    	 if(result=="返回的处理结果是发送失败"){
    		 return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, result);
    	 }
    	 return null;
    }
    
    /**
     * 验证码验证
     * @param verification 验证信息
     * @param request
     * @return 返回结果对象
     */
    @RequestMapping(value="/verfiication", method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject verification(@RequestBody VerficationRequest verficationRequest) throws Exception {
    	User user = (User) request.getSession().getAttribute("user");
		 if (null == user){
			 return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "需要先登录哦，亲");
		 }
        if ( mobilePhoneVerificationService.updateMobilePhoneVerification(verficationRequest, user)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.CHECK_ERROR, SystemConstant.CHECK_ERROR_MSG);
        }
    }
}
