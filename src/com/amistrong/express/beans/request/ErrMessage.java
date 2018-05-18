package com.amistrong.express.beans.request;

import java.io.Serializable;
 
public class ErrMessage implements Serializable {

	private static final long serialVersionUID = -3647538042993367891L;
	
	private String userId;			//用户id
	private String phoneNo;		//手机号
	private String deviceType;		//设备类型
	private String token;			//设备码
	private String errMessage;		//异常消息
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

}