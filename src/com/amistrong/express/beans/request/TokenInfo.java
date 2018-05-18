package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * Token信息Bean
 * @author 于鑫
 * @version 2015-5-26 19:54:42
 */
public class TokenInfo implements Serializable{
	
	private static final long serialVersionUID = 5259170567770671790L;
	
	private String token;		//设备码
	private String deviceType; //设备类型
	
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
}
