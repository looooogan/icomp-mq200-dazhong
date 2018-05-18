package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 抢红包Bean
 * 
 * @author 王冉
 * @version 2016-5-16
 */
public class RrabEnvelopeBean implements Serializable {

	private static final long serialVersionUID = -5441693344168119653L;

	private Integer redId;// 红包ID
	private Integer userId;// 会员ID
	private Integer redTotal;// 总额
	private String qrCodeImg;// 红包二维码地址
	private Integer state;// 状态
	private String userUpdateId;// 更新者
	private String startTm;// 红包开始日期
	private String endTm;// 红包开始日期
	private Integer redBalance;// 红包余额
	private Integer redNumber;// 红包个数
	private String qrCode;//红包码
	private String pageNo;//当前页数
	private int    pageSize1;//每页条数
	private Integer startNo;//开始的数
	private Integer endNo;//结束的数

	public Integer getRedId() {
		return redId;
	}

	public void setRedId(Integer redId) {
		this.redId = redId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRedTotal() {
		return redTotal;
	}

	public void setRedTotal(Integer redTotal) {
		this.redTotal = redTotal;
	}
	

	public String getQrCodeImg() {
		return qrCodeImg;
	}

	public void setQrCodeImg(String qrCodeImg) {
		this.qrCodeImg = qrCodeImg;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getUserUpdateId() {
		return userUpdateId;
	}

	public void setUserUpdateId(String userUpdateId) {
		this.userUpdateId = userUpdateId;
	}

	public String getStartTm() {
		return startTm;
	}

	public void setStartTm(String startTm) {
		this.startTm = startTm;
	}

	public String getEndTm() {
		return endTm;
	}

	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}

	public Integer getRedBalance() {
		return redBalance;
	}

	public void setRedBalance(Integer redBalance) {
		this.redBalance = redBalance;
	}

	public Integer getRedNumber() {
		return redNumber;
	}

	public void setRedNumber(Integer redNumber) {
		this.redNumber = redNumber;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize1() {
		return pageSize1;
	}

	public void setPageSize1(int pageSize1) {
		this.pageSize1 = pageSize1;
	}

	public Integer getStartNo() {
		return startNo;
	}

	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}

	public Integer getEndNo() {
		return endNo;
	}

	public void setEndNo(Integer endNo) {
		this.endNo = endNo;
	}
	
	

}
