package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *  库存Bean
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class Knifeinventory implements Serializable{
	
	private static final long serialVersionUID = -6353153389651280124L;
	
	/* RFID载体ID	*/ 
	private String rfidContainerID;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
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

	/* 采购批次	*/ 
	private String procuredBatch;

	/**
	 * 采购批次取得
	 * @return procuredBatch
	 */
	public String getProcuredBatch() {
		return procuredBatch;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatch
	 */
	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
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

	/* 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)	*/ 
	private String knifeInventoryType;

	/**
	 * 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)取得
	 * @return knifeInventoryType
	 */
	public String getKnifeInventoryType() {
		return knifeInventoryType;
	}

	/**
	 * 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)设定
	 * @param knifeInventoryType
	 */
	public void setKnifeInventoryType(String knifeInventoryType) {
		this.knifeInventoryType = knifeInventoryType;
	}

	/* 	*/ 
	private BigDecimal toolDurable2;

	/**
	 * 取得
	 * @return toolDurable2
	 */
	public BigDecimal getToolDurable2() {
		return toolDurable2;
	}

	/**
	 * 设定
	 * @param toolDurable2
	 */
	public void setToolDurable2(BigDecimal toolDurable2) {
		this.toolDurable2 = toolDurable2;
	}

	/* 库存数量(钻头数量为1，刀片为当前数量)	*/ 
	private String knifelnventoryNumber;

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)取得
	 * @return knifelnventoryNumber
	 */
	public String getKnifelnventoryNumber() {
		return knifelnventoryNumber;
	}

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)设定
	 * @param knifelnventoryNumber
	 */
	public void setKnifelnventoryNumber(String knifelnventoryNumber) {
		this.knifelnventoryNumber = knifelnventoryNumber;
	}

	/* 耐用度	*/ 
	private BigDecimal toolDurable;

	/**
	 * 耐用度取得
	 * @return toolDurable
	 */
	public BigDecimal getToolDurable() {
		return toolDurable;
	}

	/**
	 * 耐用度设定
	 * @param toolDurable
	 */
	public void setToolDurable(BigDecimal toolDurable) {
		this.toolDurable = toolDurable;
	}

	/* 复磨次数	*/ 
	private BigDecimal toolSharpennum;

	/**
	 * 复磨次数取得
	 * @return toolSharpennum
	 */
	public BigDecimal getToolSharpennum() {
		return toolSharpennum;
	}

	/**
	 * 复磨次数设定
	 * @param toolSharpennum
	 */
	public void setToolSharpennum(BigDecimal toolSharpennum) {
		this.toolSharpennum = toolSharpennum;
	}

	/* 复磨标准	*/ 
	private BigDecimal toolSharpenCriterion;

	/**
	 * 复磨标准取得
	 * @return toolSharpenCriterion
	 */
	public BigDecimal getToolSharpenCriterion() {
		return toolSharpenCriterion;
	}

	/**
	 * 复磨标准设定
	 * @param toolSharpenCriterion
	 */
	public void setToolSharpenCriterion(BigDecimal toolSharpenCriterion) {
		this.toolSharpenCriterion = toolSharpenCriterion;
	}

	/* 刀具长度	*/ 
	private BigDecimal toolLength;

	/**
	 * 刀具长度取得
	 * @return toolLength
	 */
	public BigDecimal getToolLength() {
		return toolLength;
	}

	/**
	 * 刀具长度设定
	 * @param toolLength
	 */
	public void setToolLength(BigDecimal toolLength) {
		this.toolLength = toolLength;
	}

	/* 可刃磨长度	*/ 
	private BigDecimal toolSharpenLength;

	/**
	 * 可刃磨长度取得
	 * @return toolSharpenLength
	 */
	public BigDecimal getToolSharpenLength() {
		return toolSharpenLength;
	}

	/**
	 * 可刃磨长度设定
	 * @param toolSharpenLength
	 */
	public void setToolSharpenLength(BigDecimal toolSharpenLength) {
		this.toolSharpenLength = toolSharpenLength;
	}
	
	private String updateUser;//更新者

	public String getUpdateUser() {
		return updateUser;
	}
	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
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