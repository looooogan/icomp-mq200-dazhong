package com.amistrong.express.beans.request;

import java.io.Serializable;

import com.amistrong.express.beans.BaseRequestBean;
/**
 * 25 用户发件、送件列表 请求 beans
 * **/
public class ReqDeliverGoodInfoBean extends BaseRequestBean implements Serializable{

	private static final long serialVersionUID = -6778460379891771089L;
	
	private String userId;		//用户id
	private String courierId;	//快递员ID
	private String state;		//状态(发货,送货,签收)

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCourierId() {
		return courierId;
	}
	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}

}
