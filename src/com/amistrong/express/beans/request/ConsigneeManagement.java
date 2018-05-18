package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，收货人管理bean
 * @author 于鑫
 * @version 2015-5-25 20:42:11
 */
public class ConsigneeManagement implements Serializable{

	private static final long serialVersionUID = 8257884111990873932L;
	
	private String consigneeName;		//收件人姓名
	private String consigneePhone;		//收件人电话
	private String consigneeAddress;	//收货地址
	
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