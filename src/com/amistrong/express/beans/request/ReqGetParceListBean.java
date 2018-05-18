package com.amistrong.express.beans.request;

import java.io.Serializable;

import com.amistrong.express.beans.BaseRequestBean;

public class ReqGetParceListBean extends BaseRequestBean implements Serializable{

	private static final long serialVersionUID = -3744739613458882366L;
	
	private int userId;//用户id
	private String state;//状态
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
