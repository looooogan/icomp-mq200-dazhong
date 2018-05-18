package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，密码变更Bean
 * @author 于鑫
 * @version 2015-5-25 10:10:12
 */
public class ChangeUser implements Serializable {

	private static final long serialVersionUID = -7585918613898585491L;
	
	private String phoneNo;		//电话号码
	private int verificationCode;	//验证码(数字)
	private String password;		//新密码(MD5加密)
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
