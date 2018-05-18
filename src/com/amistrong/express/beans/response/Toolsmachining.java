package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 刀具加工实体类
 * 创建时间：2017/09/14
 * 创建者  ：wr
 * 
 */
public class Toolsmachining implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 加工编号(年月日时分秒 14位字符串)	*/ 
	private String synthesisNumber;

	/**
	 * 加工编号(年月日时分秒 14位字符串)取得
	 * @return synthesisNumber
	 */
	public String getSynthesisNumber() {
		return synthesisNumber;
	}

	/**
	 * 加工编号(年月日时分秒 14位字符串)设定
	 * @param synthesisNumber
	 */
	public void setSynthesisNumber(String synthesisNumber) {
		this.synthesisNumber = synthesisNumber;
	}

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

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 流水线ID	*/ 
	private String assemblyLineID;

	/**
	 * 流水线ID取得
	 * @return assemblyLineID
	 */
	public String getAssemblyLineID() {
		return assemblyLineID;
	}

	/**
	 * 流水线ID设定
	 * @param assemblyLineID
	 */
	public void setAssemblyLineID(String assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}

	/* 设备ID	*/ 
	private String equipmentID;

	/**
	 * 设备ID取得
	 * @return equipmentID
	 */
	public String getEquipmentID() {
		return equipmentID;
	}

	/**
	 * 设备ID设定
	 * @param equipmentID
	 */
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	/* 工序ID	*/ 
	private String processID;

	/**
	 * 工序ID取得
	 * @return processID
	 */
	public String getProcessID() {
		return processID;
	}

	/**
	 * 工序ID设定
	 * @param processID
	 */
	public void setProcessID(String processID) {
		this.processID = processID;
	}

	/* 轴ID	*/ 
	private String axleID;

	/**
	 * 轴ID取得
	 * @return axleID
	 */
	public String getAxleID() {
		return axleID;
	}

	/**
	 * 轴ID设定
	 * @param axleID
	 */
	public void setAxleID(String axleID) {
		this.axleID = axleID;
	}

	/* 零部件	*/ 
	private String partsID;

	/**
	 * 零部件取得
	 * @return partsID
	 */
	public String getPartsID() {
		return partsID;
	}

	/**
	 * 零部件设定
	 * @param partsID
	 */
	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}

	/* 卸下时间	*/ 
	private String outerTime;

	/**
	 * 卸下时间取得
	 * @return outerTime
	 */
	public String getOuterTime() {
		return outerTime;
	}

	/**
	 * 卸下时间设定
	 * @param outerTime
	 */
	public void setOuterTime(String outerTime) {
		this.outerTime = outerTime;
	}

	/* 操作人	*/ 
	private String outerUser;

	/**
	 * 操作人取得
	 * @return outerUser
	 */
	public String getOuterUser() {
		return outerUser;
	}

	/**
	 * 操作人设定
	 * @param outerUser
	 */
	public void setOuterUser(String outerUser) {
		this.outerUser = outerUser;
	}

	/* 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)	*/ 
	private String removeReason;

	/**
	 * 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)取得
	 * @return removeReason
	 */
	public String getRemoveReason() {
		return removeReason;
	}

	/**
	 * 卸下原因(0正常卸下1打刀2不合格9其他)(可维护)设定
	 * @param removeReason
	 */
	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}

	/* 加工数量	*/ 
	private BigDecimal processAmount;

	/**
	 * 加工数量取得
	 * @return processAmount
	 */
	public BigDecimal getProcessAmount() {
		return processAmount;
	}

	/**
	 * 加工数量设定
	 * @param processAmount
	 */
	public void setProcessAmount(BigDecimal processAmount) {
		this.processAmount = processAmount;
	}

	/* 卸下确认人(不合格卸下时需要进行确认)	*/ 
	private String removeUser;

	/**
	 * 卸下确认人(不合格卸下时需要进行确认)取得
	 * @return removeUser
	 */
	public String getRemoveUser() {
		return removeUser;
	}

	/**
	 * 卸下确认人(不合格卸下时需要进行确认)设定
	 * @param removeUser
	 */
	public void setRemoveUser(String removeUser) {
		this.removeUser = removeUser;
	}
	
	public String rfidContainerID;

	public String getRfidContainerID() {
		return rfidContainerID;
	}

	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}
	
	
}

