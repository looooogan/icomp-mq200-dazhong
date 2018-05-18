package com.amistrong.express.beans.request;

import java.io.Serializable;

public class ReqGrabOrder implements Serializable{

	private static final long serialVersionUID = 8199345580700520948L;
	
	private String deliverId;//发货ID
	private String courierId;//快递员ID
	private String offer;//快递员报价
	public String getDeliverId() {
		return deliverId;
	}
	public void setDeliverId(String deliverId) {
		this.deliverId = deliverId;
	}
	public String getCourierId() {
		return courierId;
	}
	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}

}
