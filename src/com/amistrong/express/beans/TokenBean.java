package com.amistrong.express.beans;

/**
 * 特殊 发送消息BEAN
 * **/
public class TokenBean{
	
	private String token;				//设备码
	private String deviceType;			//设备类型
	private String phoneNo;				//电话号码
	
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}