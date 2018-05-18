package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * 30 增加收件人beans
 * **/
public class ReqInsConsigneeManagementBean implements Serializable{

	private static final long serialVersionUID = -2118123388766787866L;
	
	private String consigneeId;		//id										
	private String userId;				//用户id									
	private String consigneeName;		//姓名											
	private String consigneePhone;		//电话											
	private String consigneeAddress;	//地址
	
	public String getConsigneeId() {
		return consigneeId;
	}
	public void setConsigneeId(String consigneeId) {
		this.consigneeId = consigneeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}											

}
