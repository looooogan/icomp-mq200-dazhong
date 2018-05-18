package com.amistrong.express.beans.request;

import com.amistrong.express.beans.BaseRequestBean;

public class ReqNewsOrders extends BaseRequestBean{

	private String userId;//用户ID
	private String courierId;//快递员id
	private Double longitude;//经度
	private Double latitude;//纬度
	
	public String getCourierId() {
		return courierId;
	}
	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
