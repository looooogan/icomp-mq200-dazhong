package com.amistrong.express.beans.request;

import org.springframework.beans.AmistrongListElement;

public class PhoneNoBean extends AmistrongListElement{
	
	private String phoneNo;
	private String message;
	private String courierId;
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCourierId() {
		return courierId;
	}

	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}

}
