package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，用户登陆Bean
 * @author 于鑫
 * @version 2015-5-18 19:03:15
 */
public class Login implements Serializable{

	private static final long serialVersionUID = -1325213345892633282L;
	
	private String phoneNo;		//电话号码
	private String password;		//密码(MD5加密)
	private String token;			//设备码
	private String deviceType;		//设备类型
	private double longitude;		//经度
	private double latitude;		//纬度
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
}
