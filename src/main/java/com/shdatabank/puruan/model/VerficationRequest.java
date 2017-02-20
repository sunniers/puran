package com.shdatabank.puruan.model;
/**
 * 验证信息
 */
public class VerficationRequest {
	
	
	/**用户名 */
	private String userName;
	/**认证手机号 */
	private String phoneNumber;
	/**验证码 */
	private String vcode;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getVcode() {
		return vcode;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
}
