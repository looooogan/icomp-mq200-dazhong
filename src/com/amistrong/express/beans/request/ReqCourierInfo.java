package com.amistrong.express.beans.request;

public class ReqCourierInfo {
	
	public String courierNumber; //快递单号,
	public String courierCompany; //快递公司ID
	
	public String getCourierNumber() {
		return courierNumber;
	}
	public void setCourierNumber(String courierNumber) {
		this.courierNumber = courierNumber;
	}
	public String getCourierCompany() {
		return courierCompany;
	}
	public void setCourierCompany(String courierCompany) {
		this.courierCompany = courierCompany;
	}
}
