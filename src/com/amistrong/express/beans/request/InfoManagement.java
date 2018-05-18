package com.amistrong.express.beans.request;

import java.io.Serializable;
import java.util.List;
/**
 * 请求，收、发人信息管理bean
 * @author 于鑫
 * @version 2015-5-25 20:56:44
 */
public class InfoManagement implements Serializable{

	private static final long serialVersionUID = -5441693344168950653L;
	
	private List<DeliverManagement> deliverManagement; 	//发货人列表
	private List<ConsigneeManagement> consigneeManagement; //收货人列表
	
	public List<DeliverManagement> getDeliverManagement() {
		return deliverManagement;
	}
	public void setDeliverManagement(List<DeliverManagement> deliverManagement) {
		this.deliverManagement = deliverManagement;
	}
	public List<ConsigneeManagement> getConsigneeManagement() {
		return consigneeManagement;
	}
	public void setConsigneeManagement(List<ConsigneeManagement> consigneeManagement) {
		this.consigneeManagement = consigneeManagement;
	}
}
