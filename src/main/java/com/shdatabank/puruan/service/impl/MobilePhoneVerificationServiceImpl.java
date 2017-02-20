package com.shdatabank.puruan.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shdatabank.puruan.dao.IFindPwdDao;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.VerficationRequest;
import com.shdatabank.puruan.service.MobilePhoneVerificationService;

/**
 * 手机验证service实现层
 */
@Service
public class MobilePhoneVerificationServiceImpl implements MobilePhoneVerificationService {

	/** 忘记密码dao层*/
	@Autowired
	private IFindPwdDao iFindPwdDao;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 生成验证码发送消息
	 * 
	 * @return 返回发送是否成功
	 */
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	@Override
	public String sendMessage(VerficationRequest verficationRequest) throws Exception {
		// //短信接口URL提交地址
		// String url = "短信接口URL提交地址";
		// Map params = new HashMap();
		// params.put("zh", "用户账号");
		// params.put("mm", "用户密码");
		// params.put("dxlbid", "短信类别编号");
		// params.put("extno", "扩展编号");
		// //手机号码，多个号码使用英文逗号进行分割
		// params.put("phn", verficationRequest.getPhoneNumber);
		// //将短信内容进行URLEncoder编码
		String randomNmber = createRandomVcode();
		// params.put("url", URLEncoder.encode(randomNmber));
		// String result=HttpRequestUtil.getRequest(url, params);
		// if(result!=null){}
		request.getSession(true).setAttribute("randomNmber", randomNmber);
		// return result;
		return randomNmber;
	}

	/**
	 * 验证手机号
	 */
	@Override
	public boolean updateMobilePhoneVerification(VerficationRequest verficationRequest, User user) throws Exception {
		if (!verification(verficationRequest)) {
			//校验失败
			return false;
		}
		user.setUserMobile(verficationRequest.getPhoneNumber());
		iFindPwdDao.updateVerificationUserphone(user);
		return true;
	}

	/**
	 * 校验验证码是否正确
	 */
	@Override
	public boolean verification(VerficationRequest verficationRequest) throws Exception {
		String randomNmber = (String) request.getSession().getAttribute("randomNmber");
		if (verficationRequest.getVcode().equalsIgnoreCase(randomNmber)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 随机生成6位随机验证码
	 */
	public static String createRandomVcode() {
		//获取随机 验证码
		String vcode = "";
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int) (Math.random() * 9);
		}
		return vcode;
	}
}
