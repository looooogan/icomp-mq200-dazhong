package com.amistrong.express.beans.request;

import org.springframework.beans.AmistrongListElement;

public class CourierNo extends AmistrongListElement {

	private String parcelId; //包裹ID
	private String courierNumber; //快递单号
	
	public String getParcelId() {
		return parcelId;
	}
	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
	}
	public String getCourierNumber() {
		return courierNumber;
	}
	public void setCourierNumber(String courierNumber) {
		this.courierNumber = courierNumber;
	}
}
