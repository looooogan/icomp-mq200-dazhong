package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 刀具流转履历实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Tooltransferhistory implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 	*/ 
	private String toolTransferHistoryID;

	/**
	 * 取得
	 * @return toolTransferHistoryID
	 */
	public String getToolTransferHistoryID() {
		return toolTransferHistoryID;
	}

	/**
	 * 设定
	 * @param toolTransferHistoryID
	 */
	public void setToolTransferHistoryID(String toolTransferHistoryID) {
		this.toolTransferHistoryID = toolTransferHistoryID;
	}

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

	/* 采购ID	*/ 
	private String toolProcuredID;

	/**
	 * 采购ID取得
	 * @return toolProcuredID
	 */
	public String getToolProcuredID() {
		return toolProcuredID;
	}

	/**
	 * 采购ID设定
	 * @param toolProcuredID
	 */
	public void setToolProcuredID(String toolProcuredID) {
		this.toolProcuredID = toolProcuredID;
	}

	/* 最后执行业务流程	*/ 
	private String businessFlowLnkID;

	/**
	 * 最后执行业务流程取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 最后执行业务流程设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

	/* 耐用度	*/ 
	private Integer toolDurable;

	/**
	 * 耐用度取得
	 * @return toolDurable
	 */
	public Integer getToolDurable() {
		return toolDurable;
	}

	/**
	 * 耐用度设定
	 * @param toolDurable
	 */
	public void setToolDurable(Integer toolDurable) {
		this.toolDurable = toolDurable;
	}

	/* 可使用(刃磨)次数	*/ 
	private BigDecimal toolSharpennum;

	/**
	 * 可使用(刃磨)次数取得
	 * @return toolSharpennum
	 */
	public BigDecimal getToolSharpennum() {
		return toolSharpennum;
	}

	/**
	 * 可使用(刃磨)次数设定
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

	/* 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]	*/ 
	private Integer usageCounter;

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]取得
	 * @return usageCounter
	 */
	public Integer getUsageCounter() {
		return usageCounter;
	}

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]设定
	 * @param usageCounter
	 */
	public void setUsageCounter(Integer usageCounter) {
		this.usageCounter = usageCounter;
	}

	/* 刀具已刃磨长度	*/ 
	private BigDecimal toolGrindingLength;

	/**
	 * 刀具已刃磨长度取得
	 * @return toolGrindingLength
	 */
	public BigDecimal getToolGrindingLength() {
		return toolGrindingLength;
	}

	/**
	 * 刀具已刃磨长度设定
	 * @param toolGrindingLength
	 */
	public void setToolGrindingLength(BigDecimal toolGrindingLength) {
		this.toolGrindingLength = toolGrindingLength;
	}

	/* 刀具安装合成刀状态(0未安装1已安装2卸下9其他)	*/ 
	private String installationState;

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)取得
	 * @return installationState
	 */
	public String getInstallationState() {
		return installationState;
	}

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)设定
	 * @param installationState
	 */
	public void setInstallationState(String installationState) {
		this.installationState = installationState;
	}

	/* 刀具状态(0断刀1丢失2不合格3借入4申领9其他)	*/ 
	private String toolState;

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)取得
	 * @return toolState
	 */
	public String getToolState() {
		return toolState;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3借入4申领9其他)设定
	 * @param toolState
	 */
	public void setToolState(String toolState) {
		this.toolState = toolState;
	}

	/* 申领区分(0扩能1外借2工艺试验)	*/ 
	private String replacementFlag;

	/**
	 * 申领区分(0扩能1外借2工艺试验)取得
	 * @return replacementFlag
	 */
	public String getReplacementFlag() {
		return replacementFlag;
	}

	/**
	 * 申领区分(0扩能1外借2工艺试验)设定
	 * @param replacementFlag
	 */
	public void setReplacementFlag(String replacementFlag) {
		this.replacementFlag = replacementFlag;
	}

	/* 转出人	*/ 
	private String outUser;

	/**
	 * 转出人取得
	 * @return outUser
	 */
	public String getoutUser() {
		return outUser;
	}

	/**
	 * 转出人设定
	 * @param outUser
	 */
	public void setoutUser(String outUser) {
		this.outUser = outUser;
	}

	/* 接收人	*/ 
	private String inUser;

	/**
	 * 接收人取得
	 * @return inUser
	 */
	public String getinUser() {
		return inUser;
	}

	/**
	 * 接收人设定
	 * @param inUser
	 */
	public void setinUser(String inUser) {
		this.inUser = inUser;
	}

	/* 确认人(断刀、丢失、不合格的状态选择时需要上级确认)	*/ 
	private String confirmedUser;

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)取得
	 * @return confirmedUser
	 */
	public String getConfirmedUser() {
		return confirmedUser;
	}

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)设定
	 * @param confirmedUser
	 */
	public void setConfirmedUser(String confirmedUser) {
		this.confirmedUser = confirmedUser;
	}

	/* 库存状态(0正常1报废2返厂3封存9其他)	*/ 
	private String stockState;

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)取得
	 * @return stockState
	 */
	public String getStockState() {
		return stockState;
	}

	/**
	 * 库存状态(0正常1报废2返厂3封存9其他)设定
	 * @param stockState
	 */
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}
	
	private String updateUser;
	
	private String createUser;


	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
}

