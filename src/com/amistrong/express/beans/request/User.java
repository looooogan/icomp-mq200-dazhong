package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，用户Bean
 * 
 * @author 于鑫
 * @version 2015-5-18 09:17:46
 */
public class User implements Serializable {

	private static final long serialVersionUID = -3578872157159122617L;

	private String phoneNo; // 电话号码
	private String nickName;// 昵称
	private int verificationCode; // 注册码(数字)
	private String password; // 密码(MD5加密)
	private String introducer; // 推荐人(电话号码，可为空)
	private String token; // 设备码
	private String deviceType; // 设备类型

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

	public String getIntroducer() {
		return introducer;
	}

	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
