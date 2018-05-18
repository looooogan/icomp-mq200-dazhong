package com.amistrong.express.beans.request;

import java.io.Serializable;

import com.amistrong.express.beans.BaseRequestBean;
/**
 * 35 选择快递员 请求
 * **/
public class ReqSelectCourier extends BaseRequestBean implements Serializable{

	private static final long serialVersionUID = 2203153704744350642L;
	
	private String deliverId;	//快递员id

	public String getDeliverId() {
		return deliverId;
	}
	public void setDeliverId(String deliverId) {
		this.deliverId = deliverId;
	}
	
}
