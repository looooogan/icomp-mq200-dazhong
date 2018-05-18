package com.amistrong.express.beans.request;

import java.io.Serializable;

import com.amistrong.express.beans.BaseRequestBean;

public class ReqConsumptionStatisticsBean extends BaseRequestBean implements Serializable{

	private static final long serialVersionUID = 2203153707444350642L;
	
	private String userId;//用户id

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
