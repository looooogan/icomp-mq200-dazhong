package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2017/09/14
 * 创建者  ：wr
 * 
 */
public class Synthesistoolsmachining implements Serializable {

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

	/*  合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCode;

	/**
	 *  合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 *  合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 合成刀具编号(例如：001、002、003)	*/ 
	private String synthesisParametersNumber;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumber
	 */
	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumber
	 */
	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}

	/* 零部件ID（卸下设备后插入）	*/ 
	private String partsID;

	/**
	 * 零部件ID（卸下设备后插入）取得
	 * @return partsID
	 */
	public String getPartsID() {
		return partsID;
	}

	/**
	 * 零部件ID（卸下设备后插入）设定
	 * @param partsID
	 */
	public void setPartsID(String partsID) {
		this.partsID = partsID;
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

	/* 装入时间	*/ 
	private Date loadTime;

	/**
	 * 装入时间取得
	 * @return loadTime
	 */
	public Date getLoadTime() {
		return loadTime;
	}

	/**
	 * 装入时间设定
	 * @param loadTime
	 */
	public void setLoadTime(Date loadTime) {
		this.loadTime = loadTime;
	}

	/* 操作人	*/ 
	private String loadUser;

	/**
	 * 操作人取得
	 * @return loadUser
	 */
	public String getLoadUser() {
		return loadUser;
	}

	/**
	 * 操作人设定
	 * @param loadUser
	 */
	public void setLoadUser(String loadUser) {
		this.loadUser = loadUser;
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

	/* 卸下人	*/ 
	private String outerUser;

	/**
	 * 卸下人取得
	 * @return outerUser
	 */
	public String getOuterUser() {
		return outerUser;
	}

	/**
	 * 卸下人设定
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

	//合成刀具号码
    private String SynthesisParametersNumber;

	/**
	 * 合成刀具号码
	 * @return SynthesisParametersNumber
	 */
	public String SynthesisParametersNumber() {
		return SynthesisParametersNumber;
	}

	/**
	 * 合成刀具号码
	 * @param SynthesisParametersNumber
	 */
	public void SynthesisParametersNumber(String SynthesisParametersNumber) {
		this.SynthesisParametersNumber = SynthesisParametersNumber;
	}
	private String customerID;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	private String rfidContainerID;

	public String getRfidContainerID() {
		return rfidContainerID;
	}

	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
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
	
	
}

