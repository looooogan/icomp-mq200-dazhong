package com.amistrong.express.beans.request;

import java.io.Serializable;

public class MessageTemplateBean implements Serializable{

	private static final long serialVersionUID = 3216956186938098621L;
	
	private String firstPart;
	
	private String secondPartAddress;
	
	private String thirdPart;
	
	private String fourthPartPhone;
	
	private String messageId;
	
	private String userId;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
