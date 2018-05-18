package com.amistrong.express.beans.request;

import java.io.Serializable;
import java.util.List;

public class ShortMessageBean implements Serializable{

	private static final long serialVersionUID = -5642776051405876828L;
	
	private List<PhoneNoBean> phoneNoBeans;
	
	private String firstPart;
	
	private String secondPartAddress;
	
	private String thirdPart;
	
	private String fourthPartPhone;
	
	private String messageId;
	
	private String phoneOrHelper;
	
	private String courierId;
	
	public List<PhoneNoBean> getPhoneNoBeans() {
		return phoneNoBeans;
	}

	public void setPhoneNoBeans(List<PhoneNoBean> phoneNoBeans) {
		this.phoneNoBeans = phoneNoBeans;
	}

	public String getFirstPart() {
		return firstPart;
	}

	public void setFirstPart(String firstPart) {
		this.firstPart = firstPart;
	}

	public String getSecondPartAddress() {
		return secondPartAddress;
	}

	public void setSecondPartAddress(String secondPartAddress) {
		this.secondPartAddress = secondPartAddress;
	}

	public String getThirdPart() {
		return thirdPart;
	}

	public void setThirdPart(String thirdPart) {
		this.thirdPart = thirdPart;
	}

	public String getFourthPartPhone() {
		return fourthPartPhone;
	}

	public void setFourthPartPhone(String fourthPartPhone) {
		this.fourthPartPhone = fourthPartPhone;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getPhoneOrHelper() {
		return phoneOrHelper;
	}

	public void setPhoneOrHelper(String phoneOrHelper) {
		this.phoneOrHelper = phoneOrHelper;
	}

	public String getCourierId() {
		return courierId;
	}

	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}

}
