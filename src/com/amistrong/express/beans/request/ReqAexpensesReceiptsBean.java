package com.amistrong.express.beans.request;

import java.io.Serializable;

import com.amistrong.express.beans.BaseRequestBean;

public class ReqAexpensesReceiptsBean extends BaseRequestBean implements Serializable{

	private static final long serialVersionUID = 5501246649101468844L;
	
	private String userId;//用户id
	private String courierId;//快递员id
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCourierId() {
		return courierId;
	}
	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}

}
