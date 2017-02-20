package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.VerficationRequest;

/**
 * 手机验证service层
 */
public interface MobilePhoneVerificationService {
	
	
	/**
     * 生成验证码发送消息
     * @return 返回发送是否成功
     */
    public String  sendMessage(VerficationRequest verficationRequest) throws Exception;
    
    /**
     * 更新验证手机
     * @return 返回发送是否成功
     */
    public boolean  updateMobilePhoneVerification(VerficationRequest verficationRequest,User user) throws Exception;
    
    /**
     * 校验验证码
     * @return 返回发送是否成功
     */
    public boolean  verification(VerficationRequest verficationRequest) throws Exception;

}
