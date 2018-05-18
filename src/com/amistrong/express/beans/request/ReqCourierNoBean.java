package com.amistrong.express.beans.request;

import java.util.List;

public class ReqCourierNoBean {
	
	private String userId; //用户ID;
	private String courierId; //快递员ID
	private String deliverId; //发货ID
	private List<CourierNo> courierNo;
	
	public String getDeliverId() {
		return deliverId;
	}
	public void setDeliverId(String deliverId) {
		this.deliverId = deliverId;
	}
	public List<CourierNo> getCourierNo() {
		return courierNo;
	}
	public void setCourierNo(List<CourierNo> courierNo) {
		this.courierNo = courierNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCourierId() {
		return courierId;
	}
	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}
}
