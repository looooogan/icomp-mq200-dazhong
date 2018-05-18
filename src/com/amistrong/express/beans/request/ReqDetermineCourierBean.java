package com.amistrong.express.beans.request;

public class ReqDetermineCourierBean{
		
	private Integer userId;	//用id
	private Integer deliverId; //发货ID
	private Integer courierId; //快递员ID
	private Integer totalFee; //支付金额
	
	public Integer getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}
	public Integer getDeliverId() {
		return deliverId;
	}
	public void setDeliverId(Integer deliverId) {
		this.deliverId = deliverId;
	}
	public Integer getCourierId() {
		return courierId;
	}
	public void setCourierId(Integer courierId) {
		this.courierId = courierId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
