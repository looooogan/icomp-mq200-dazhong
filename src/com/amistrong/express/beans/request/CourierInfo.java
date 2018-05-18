package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 快递员信息Bean
 * @author 于鑫
 * @version 2015-10-16 14:10:53
 */
public class CourierInfo implements Serializable {

	private static final long serialVersionUID = -7585914658585491L;
	
	private String courierId;		// 快递员ID
	private String courierName;	// 快递员姓名
	
	public String getCourierId() {
		return courierId;
	}
	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
}