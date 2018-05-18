package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 61.提现到微信Bean
 */
public class ReqWeiXinWithdrawDeposit implements Serializable {

	private static final long serialVersionUID = -7918631491L;
	
	private String userId;			// 用户ID
	private double amount;			// 提现金额
	private String re_user_name;	// 收款用户姓名
	private String openid;			// 用户OPENID
	private String device_info;	// 设备号
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getRe_user_name() {
		return re_user_name;
	}
	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
}