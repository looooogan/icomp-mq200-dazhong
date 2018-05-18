package com.amistrong.express.beans.request;

import java.io.Serializable;

public class ReqInsDeliverManagement implements Serializable{

	private static final long serialVersionUID = 3502689525383853975L;
	
	private String senderId; //发货人管理ID										
	private String userId;	 //用户ID									
	private String deliverName;	 //	发货人姓名									
	private String deliverPhone; //	发货人电话										
	private String deliverAddress;//发货地址	
	
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeliverName() {
		return deliverName;
	}
	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}
	public String getDeliverPhone() {
		return deliverPhone;
	}
	public void setDeliverPhone(String deliverPhone) {
		this.deliverPhone = deliverPhone;
	}
	public String getDeliverAddress() {
		return deliverAddress;
	}
	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}

}
