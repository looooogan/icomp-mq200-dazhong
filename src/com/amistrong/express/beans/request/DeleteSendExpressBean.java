package com.amistrong.express.beans.request;

import java.io.Serializable;

public class DeleteSendExpressBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//用户id
	private String userId ;
	//快递id
	private String deliverId ;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeliverId() {
		return deliverId;
	}
	public void setDeliverId(String deliverId) {
		this.deliverId = deliverId;
	}

}
