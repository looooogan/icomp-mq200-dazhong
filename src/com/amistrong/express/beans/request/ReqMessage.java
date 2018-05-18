package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * 请求，消息Bean
 * @author 于鑫
 * @version 2015-6-30 15:32:58
 */
public class ReqMessage implements Serializable{

	private static final long serialVersionUID = 8505018985647295993L;
	
	private String phoneNo;		//电话号码
	private double longitude;		//经度
	private double latitude;		//纬度
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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