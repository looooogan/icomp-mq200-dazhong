package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 56 兑换商品
 */
public class ExchangeGiftBean implements Serializable {

	private static final long serialVersionUID = -7918631898585491L;
	
	private String exchangeGoodsId;// 兑换物品ID
	private String userId;			// 用户ID
	private String receiverAddress;// 礼品接收地址
	private String receiverPhone;	// 礼品接收电话
	private String receiverName;	// 礼品接收姓名
	private Integer exchangeNum;	// 兑换数量
	private String openId;			// 微信openId
	
	public String getExchangeGoodsId() {
		return exchangeGoodsId;
	}
	public void setExchangeGoodsId(String exchangeGoodsId) {
		this.exchangeGoodsId = exchangeGoodsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public Integer getExchangeNum() {
		return exchangeNum;
	}
	public void setExchangeNum(Integer exchangeNum) {
		this.exchangeNum = exchangeNum;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
}