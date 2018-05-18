package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，发货人管理bean
 * @author 于鑫
 * @version 2015-5-25 20:41:29
 */
public class DeliverManagement implements Serializable{

	private static final long serialVersionUID = 5704550042853883216L;
	
	private String deliverName;	//发货人姓名
	private String deliverPhone;	//发货人电话
	private String deliverAddress;	//发货地址
	
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