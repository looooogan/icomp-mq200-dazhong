package com.amistrong.express.beans.request;

import java.io.Serializable;

import com.amistrong.express.beans.BaseRequestBean;
/**
 * 34 积分明细
 * **/
public class ReqIntegralBean extends BaseRequestBean implements Serializable{
	
	private static final long serialVersionUID = -5838532723843985201L;
	
	private String userId;		//用户id

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
