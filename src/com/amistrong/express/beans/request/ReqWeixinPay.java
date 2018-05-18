package com.amistrong.express.beans.request;

/**
 * 生成订单时APP参数传用到的BEAN
 * @author pan.bo
 *
 */
public class ReqWeixinPay {
		
	private String orderNo;	//订单号											
	private String userId;	//用户ID											
	private String money;	//发生金额											
	private String insertTime;	//插入时间	
	private String ipAddress;	//手机IP地址
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	
}
