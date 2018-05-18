package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，更新积分、交易Bean
 * @author 于鑫
 * @version 2015-5-25 14:34:15
 */
public class ReqDepositTemp implements Serializable{

	private static final long serialVersionUID = 1732025317085388613L;
	
	private String orderNo;				//订单号											
	private String userId;				//用户ID											
	private double money;				//发生金额											
	private String insertTime;				//插入时间											
	private String stateFlag;				//状态	
	
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

	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	public String getStateFlag() {
		return stateFlag;
	}
	public void setStateFlag(String stateFlag) {
		this.stateFlag = stateFlag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}