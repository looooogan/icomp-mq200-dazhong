package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 实体类
 * @author 工具自动生成
 * 创建者  ：wr
 * 
 */
public class Toolnoticehistory implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具入库编码	*/ 
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 修磨设备ID	*/ 
	private String noticeEquipmentID;

	/**
	 * 修磨设备ID取得
	 * @return noticeEquipmentID
	 */
	public String getNoticeEquipmentID() {
		return noticeEquipmentID;
	}

	/**
	 * 修磨设备ID设定
	 * @param noticeEquipmentID
	 */
	public void setNoticeEquipmentID(String noticeEquipmentID) {
		this.noticeEquipmentID = noticeEquipmentID;
	}

	/* 修复数量	*/ 
	private Integer noticeCount;

	/**
	 * 修复数量取得
	 * @return noticeCount
	 */
	public Integer getNoticeCount() {
		return noticeCount;
	}

	/**
	 * 修复数量设定
	 * @param noticeCount
	 */
	public void setNoticeCount(Integer noticeCount) {
		this.noticeCount = noticeCount;
	}

	/* 修复时间	*/ 
	private String noticeTime;

	/**
	 * 修复时间取得
	 * @return noticeTime
	 */
	public String getNoticeTime() {
		return noticeTime;
	}

	/**
	 * 修复时间设定
	 * @param noticeTime
	 */
	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	/* 操作人	*/ 
	private String toolRepairNoticeUser;

	/**
	 * 操作人取得
	 * @return toolRepairNoticeUser
	 */
	public String getToolRepairNoticeUser() {
		return toolRepairNoticeUser;
	}

	/**
	 * 操作人设定
	 * @param toolRepairNoticeUser
	 */
	public void setToolRepairNoticeUser(String toolRepairNoticeUser) {
		this.toolRepairNoticeUser = toolRepairNoticeUser;
	}

	/* 领取人	*/ 
	private String receiveUser;

	/**
	 * 领取人取得
	 * @return receiveUser
	 */
	public String getReceiveUser() {
		return receiveUser;
	}

	/**
	 * 领取人设定
	 * @param receiveUser
	 */
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}

	/* 领取时间	*/ 
	private Date receiveTime;

	/**
	 * 领取时间取得
	 * @return receiveTime
	 */
	public Date getReceiveTime() {
		return receiveTime;
	}

	/**
	 * 领取时间设定
	 * @param receiveTime
	 */
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	/* 修复后测量长度	*/ 
	private BigDecimal noticeOldLength;

	/**
	 * 修复后测量长度取得
	 * @return noticeOldLength
	 */
	public BigDecimal getNoticeOldLength() {
		return noticeOldLength;
	}

	/**
	 * 修复后测量长度设定
	 * @param noticeOldLength
	 */
	public void setNoticeOldLength(BigDecimal noticeOldLength) {
		this.noticeOldLength = noticeOldLength;
	}

	/* 修复前测量长度	*/ 
	private BigDecimal noticeLength;

	/**
	 * 修复前测量长度取得
	 * @return noticeLength
	 */
	public BigDecimal getNoticeLength() {
		return noticeLength;
	}

	/**
	 * 修复前测量长度设定
	 * @param noticeLength
	 */
	public void setNoticeLength(BigDecimal noticeLength) {
		this.noticeLength = noticeLength;
	}

	/* 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)	*/ 
	private String repairWay;

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)取得
	 * @return repairWay
	 */
	public String getRepairWay() {
		return repairWay;
	}

	/**
	 * 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)设定
	 * @param repairWay
	 */
	public void setRepairWay(String repairWay) {
		this.repairWay = repairWay;
	}

	/* 修复原因(0断刀1正常刃磨)	*/ 
	private String repairedBecause;

	/**
	 * 修复原因(0断刀1正常刃磨)取得
	 * @return repairedBecause
	 */
	public String getRepairedBecause() {
		return repairedBecause;
	}

	/**
	 * 修复原因(0断刀1正常刃磨)设定
	 * @param repairedBecause
	 */
	public void setRepairedBecause(String repairedBecause) {
		this.repairedBecause = repairedBecause;
	}
	
	private String createUser;
	
	private String updateUser;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	private String rfidContainerID;

	public String getRfidContainerID() {
		return rfidContainerID;
	}

	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}
	
	
	
}

