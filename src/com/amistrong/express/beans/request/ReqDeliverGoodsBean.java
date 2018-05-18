package com.amistrong.express.beans.request;

import java.io.Serializable;

import com.amistrong.express.beans.BaseRequestBean;

public class ReqDeliverGoodsBean extends BaseRequestBean implements Serializable{

	private static final long serialVersionUID = 8493309092191903625L;
	
	private int courierId;//快递员Id
	private String state;//状态
	public int getCourierId() {
		return courierId;
	}

	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


}
