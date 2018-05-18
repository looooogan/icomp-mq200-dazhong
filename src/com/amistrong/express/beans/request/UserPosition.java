package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，上传用户位置Bean
 * @author 于鑫
 * @version 2015-5-25 11:33:29
 */
public class UserPosition implements Serializable{

	private static final long serialVersionUID = -1325213345892111182L;
	
	private int userId;			//用户ID
	private double longitude;		//经度
	private double latitude;		//纬度
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
