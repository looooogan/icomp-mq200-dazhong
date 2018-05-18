package com.amistrong.express.beans.request;

import java.io.Serializable;

import com.amistrong.express.beans.BaseRequestBean;

/**
 * 54 兑换记录 请求Bean
 */
public class ExchangeBean extends BaseRequestBean implements Serializable{

	private static final long serialVersionUID = 5501246649101485844L;
	
	private String userId;		//用户id

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
