package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.VerficationRequest;
import com.shdatabank.puruan.service.IFindPwdService;
import com.shdatabank.puruan.service.MobilePhoneVerificationService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 通过手机找回密码Controller层
 * @author SWC
 */
@Controller
@RequestMapping(value = "/find_byPhone")
public class FindPwdByPhoneController {
	
	/** 忘记密码service层 */
	@Autowired
	private IFindPwdService iFindPwdService;
	/**手机验证service层 */
	@Autowired
	private MobilePhoneVerificationService mobilePhoneVerificationService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * 验证用户名是否存在
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject checkUser(@RequestBody User user) throws Exception {
		user = iFindPwdService.selectUserCount(user);
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, "用户名不存在!");
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}
	}

	/**
	 * 验证用户名,手机号是否匹配，发送验证信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject sendMessage(@RequestBody VerficationRequest verficationRequest) throws Exception {
		User user = new User();
		user.setUserName(verficationRequest.getUserName());
		user.setUserMobile(verficationRequest.getPhoneNumber());
		user = iFindPwdService.selectUserCount(user);
		if (null == user) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, "用户名或手机号错误！");
		}
		//发送验证码
		mobilePhoneVerificationService.sendMessage(verficationRequest);
		//保存用户信息到session
		request.getSession(true).setAttribute("user", user);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
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
        if ( iFindPwdService.verification(verficationRequest)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.CHECK_ERROR, SystemConstant.CHECK_ERROR_MSG);
        }
    }
	
	/**
     * 更新用户密码
     * @param user
     * @return 返回结果对象
     */
    @RequestMapping(value="/updatePwd",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateUserPwd(@RequestBody User userr) throws Exception {
    	User user = (User) request.getSession().getAttribute("user");
		 if (null == user){
			 return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "时间过长，请重新验证！");
		 }
    	//转换md5
    	user.setNewUserPwd(DigestUtils.md5DigestAsHex(userr.getUserPwd().getBytes()));
    	iFindPwdService.updateUserPwd(user);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    }
}
