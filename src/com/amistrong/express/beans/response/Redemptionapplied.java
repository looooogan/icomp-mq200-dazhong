package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 换领申请实体类
 * 
 * @author 工具自动生成 创建时间：2017/6/30 15:52 创建者 ：王冉
 * 
 */
public class Redemptionapplied implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 换领申请流水号 */
	private String redemptionAppliedID;

	/**
	 * 换领申请流水号取得
	 * 
	 * @return redemptionAppliedID
	 */
	public String getRedemptionAppliedID() {
		return redemptionAppliedID;
	}

	/**
	 * 换领申请流水号设定
	 * 
	 * @param redemptionAppliedID
	 */
	public void setRedemptionAppliedID(String redemptionAppliedID) {
		this.redemptionAppliedID = redemptionAppliedID;
	}

	/* 刀具编码 */
	private String toolCode;

	/**
	 * 刀具编码取得
	 * 
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * 
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 申请数量 */
	private BigDecimal appliedNumber;

	/**
	 * 申请数量取得
	 * 
	 * @return appliedNumber
	 */
	public BigDecimal getAppliedNumber() {
		return appliedNumber;
	}

	/**
	 * 申请数量设定
	 * 
	 * @param appliedNumber
	 */
	public void setAppliedNumber(BigDecimal appliedNumber) {
		this.appliedNumber = appliedNumber;
	}

	/* 备货数量 */
	private BigDecimal stockNumber;

	/**
	 * 备货数量取得
	 * 
	 * @return stockNumber
	 */
	public BigDecimal getStockNumber() {
		return stockNumber;
	}

	/**
	 * 备货数量设定
	 * 
	 * @param stockNumber
	 */
	public void setStockNumber(BigDecimal stockNumber) {
		this.stockNumber = stockNumber;
	}

	/* 送回数量 */
	private BigDecimal returnNumber;

	/**
	 * 送回数量取得
	 * 
	 * @return returnNumber
	 */
	public BigDecimal getReturnNumber() {
		return returnNumber;
	}

	/**
	 * 送回数量设定
	 * 
	 * @param returnNumber
	 */
	public void setReturnNumber(BigDecimal returnNumber) {
		this.returnNumber = returnNumber;
	}

	/* 断刀数量 */
	private BigDecimal brokenNumber;

	/**
	 * 断刀数量取得
	 * 
	 * @return brokenNumber
	 */
	public BigDecimal getBrokenNumber() {
		return brokenNumber;
	}

	/**
	 * 断刀数量设定
	 * 
	 * @param brokenNumber
	 */
	public void setBrokenNumber(BigDecimal brokenNumber) {
		this.brokenNumber = brokenNumber;
	}

	/* 丢失数量 */
	private BigDecimal lostNumber;

	/**
	 * 丢失数量取得
	 * 
	 * @return lostNumber
	 */
	public BigDecimal getLostNumber() {
		return lostNumber;
	}

	/**
	 * 丢失数量设定
	 * 
	 * @param lostNumber
	 */
	public void setLostNumber(BigDecimal lostNumber) {
		this.lostNumber = lostNumber;
	}

	/* 领取数量 */
	private BigDecimal receiveNumber;

	/**
	 * 领取数量取得
	 * 
	 * @return receiveNumber
	 */
	public BigDecimal getReceiveNumber() {
		return receiveNumber;
	}

	/**
	 * 领取数量设定
	 * 
	 * @param receiveNumber
	 */
	public void setReceiveNumber(BigDecimal receiveNumber) {
		this.receiveNumber = receiveNumber;
	}

	/* 申请人 */
	private String applyUser;

	/**
	 * 申请人取得
	 * 
	 * @return applyUser
	 */
	public String getApplyUser() {
		return applyUser;
	}

	/**
	 * 申请人设定
	 * 
	 * @param applyUser
	 */
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	/* 申请时间 */
	private Date applyTime;

	/**
	 * 申请时间取得
	 * 
	 * @return applyTime
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * 申请时间设定
	 * 
	 * @param applyTime
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/* 领取人 */
	private String receiveUser;

	/**
	 * 领取人取得
	 * 
	 * @return receiveUser
	 */
	public String getReceiveUser() {
		return receiveUser;
	}

	/**
	 * 领取人设定
	 * 
	 * @param receiveUser
	 */
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}

	/* 领取时间 */
	private Date receiveTime;

	/**
	 * 领取时间取得
	 * 
	 * @return receiveTime
	 */
	public Date getReceiveTime() {
		return receiveTime;
	}

	/**
	 * 领取时间设定
	 * 
	 * @param receiveTime
	 */
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	/* 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 ) */
	private String processingStatus;

	/**
	 * 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )取得
	 * 
	 * @return processingStatus
	 */
	public String getProcessingStatus() {
		return processingStatus;
	}

	/**
	 * 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )设定
	 * 
	 * @param processingStatus
	 */
	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}

	/* 备货时用的rfid，以英文，隔开 */
	private String rfidList;

	/**
	 * 备货时用的rfid，以英文，隔开取得
	 * 
	 * @return rfidList
	 */
	public String getRfidList() {
		return rfidList;
	}

	/**
	 * 备货时用的rfid，以英文，隔开设定
	 * 
	 * @param rfidList
	 */
	public void setRfidList(String rfidList) {
		this.rfidList = rfidList;
	}

	// 删除标识
	private String delFlag;

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}
