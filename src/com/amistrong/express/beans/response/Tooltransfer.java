package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 刀具流转表Bean
 * 
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class Tooltransfer implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID载体ID */
	private String rfidContainerID;

	/**
	 * RFID载体ID取得
	 * 
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * RFID载体ID设定
	 * 
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}

	/* 刀具入库编码 */
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * 
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * 
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}

	/* 刀具ID */
	private String toolID;

	/**
	 * 刀具ID取得
	 * 
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * 
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 采购批次 */
	private String procuredBatch;

	/**
	 * 采购批次取得
	 * 
	 * @return procuredBatch
	 */
	public String getProcuredBatch() {
		return procuredBatch;
	}

	/**
	 * 采购批次设定
	 * 
	 * @param procuredBatch
	 */
	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
	}

	/* 最后执行业务流程 */
	private String businessFlowLnkID;

	/**
	 * 最后执行业务流程取得
	 * 
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 最后执行业务流程设定
	 * 
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

	/* 加工数量 */
	private BigDecimal processAmount;

	/**
	 * 加工数量取得
	 * 
	 * @return processAmount
	 */
	public BigDecimal getProcessAmount() {
		return processAmount;
	}

	/**
	 * 加工数量设定
	 * 
	 * @param processAmount
	 */
	public void setProcessAmount(BigDecimal processAmount) {
		this.processAmount = processAmount;
	}

	/* 当前数量 */
	private Integer toolDurable;

	/**
	 * 当前数量取得
	 * 
	 * @return toolDurable
	 */
	public Integer getToolDurable() {
		return toolDurable;
	}

	/**
	 * 当前数量设定
	 * 
	 * @param toolDurable
	 */
	public void setToolDurable(Integer toolDurable) {
		this.toolDurable = toolDurable;
	}

	/* 可使用(刃磨)次数 */
	private BigDecimal toolSharpennum;

	/**
	 * 可使用(刃磨)次数取得
	 * 
	 * @return toolSharpennum
	 */
	public BigDecimal getToolSharpennum() {
		return toolSharpennum;
	}

	/**
	 * 可使用(刃磨)次数设定
	 * 
	 * @param toolSharpennum
	 */
	public void setToolSharpennum(BigDecimal toolSharpennum) {
		this.toolSharpennum = toolSharpennum;
	}

	/* 复磨标准 */
	private BigDecimal toolSharpenCriterion;

	/**
	 * 复磨标准取得
	 * 
	 * @return toolSharpenCriterion
	 */
	public BigDecimal getToolSharpenCriterion() {
		return toolSharpenCriterion;
	}

	/**
	 * 复磨标准设定
	 * 
	 * @param toolSharpenCriterion
	 */
	public void setToolSharpenCriterion(BigDecimal toolSharpenCriterion) {
		this.toolSharpenCriterion = toolSharpenCriterion;
	}

	/* 刀具长度 */
	private BigDecimal toolLength;

	/**
	 * 刀具长度取得
	 * 
	 * @return toolLength
	 */
	public BigDecimal getToolLength() {
		return toolLength;
	}

	/**
	 * 刀具长度设定
	 * 
	 * @param toolLength
	 */
	public void setToolLength(BigDecimal toolLength) {
		this.toolLength = toolLength;
	}

	/* 可刃磨长度 */
	private BigDecimal toolSharpenLength;

	/**
	 * 可刃磨长度取得
	 * 
	 * @return toolSharpenLength
	 */
	public BigDecimal getToolSharpenLength() {
		return toolSharpenLength;
	}

	/**
	 * 可刃磨长度设定
	 * 
	 * @param toolSharpenLength
	 */
	public void setToolSharpenLength(BigDecimal toolSharpenLength) {
		this.toolSharpenLength = toolSharpenLength;
	}

	/* 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废] */
	private Integer usageCounter;

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]取得
	 * 
	 * @return usageCounter
	 */
	public Integer getUsageCounter() {
		return usageCounter;
	}

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]设定
	 * 
	 * @param usageCounter
	 */
	public void setUsageCounter(Integer usageCounter) {
		this.usageCounter = usageCounter;
	}

	/* 刀具已刃磨长度 */
	private BigDecimal toolGrindingLength;

	/**
	 * 刀具已刃磨长度取得
	 * 
	 * @return toolGrindingLength
	 */
	public BigDecimal getToolGrindingLength() {
		return toolGrindingLength;
	}

	/**
	 * 刀具已刃磨长度设定
	 * 
	 * @param toolGrindingLength
	 */
	public void setToolGrindingLength(BigDecimal toolGrindingLength) {
		this.toolGrindingLength = toolGrindingLength;
	}

	/* 刀具安装合成刀状态(0未安装1已安装2卸下9其他) */
	private String installationState;

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)取得
	 * 
	 * @return installationState
	 */
	public String getInstallationState() {
		return installationState;
	}

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)设定
	 * 
	 * @param installationState
	 */
	public void setInstallationState(String installationState) {
		this.installationState = installationState;
	}

	/* 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他) */
	private String toolState;

	/**
	 * 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)取得
	 * 
	 * @return toolState
	 */
	public String getToolState() {
		return toolState;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)设定
	 * 
	 * @param toolState
	 */
	public void setToolState(String toolState) {
		this.toolState = toolState;
	}

	/* 申领区分(0扩能1外借2工艺试验3补充周转量) */
	private String replacementFlag;

	/**
	 * 申领区分(0扩能1外借2工艺试验3补充周转量)取得
	 * 
	 * @return replacementFlag
	 */
	public String getReplacementFlag() {
		return replacementFlag;
	}

	/**
	 * 申领区分(0扩能1外借2工艺试验3补充周转量)设定
	 * 
	 * @param replacementFlag
	 */
	public void setReplacementFlag(String replacementFlag) {
		this.replacementFlag = replacementFlag;
	}

	/* 确认人(断刀、丢失、不合格的状态选择时需要上级确认) */
	private String confirmedUser;

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)取得
	 * 
	 * @return confirmedUser
	 */
	public String getConfirmedUser() {
		return confirmedUser;
	}

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)设定
	 * 
	 * @param confirmedUser
	 */
	public void setConfirmedUser(String confirmedUser) {
		this.confirmedUser = confirmedUser;
	}

	/* 刀具部门(0库存,1对刀室,2刃磨室,3,车间) */
	private String toolThisState;

	/**
	 * 刀具部门(0库存,1对刀室,2刃磨室,3,车间)取得
	 * 
	 * @return toolThisState
	 */
	public String getToolThisState() {
		return toolThisState;
	}

	/**
	 * 刀具部门(0库存,1对刀室,2刃磨室,3,车间)设定
	 * 
	 * @param toolThisState
	 */
	public void setToolThisState(String toolThisState) {
		this.toolThisState = toolThisState;
	}

	/* 库存状态(0正常1报废2返厂3封存4.流转9其他) */
	private String stockState;

	/**
	 * 库存状态(0正常1报废2返厂3封存4.流转9其他)取得
	 * 
	 * @return stockState
	 */
	public String getStockState() {
		return stockState;
	}

	/**
	 * 库存状态(0正常1报废2返厂3封存4.流转9其他)设定
	 * 
	 * @param stockState
	 */
	public void setStockState(String stockState) {
		this.stockState = stockState;
	}

	/* 报废确认区分(0未确认1已确认) */
	private String discardeFlag;

	/**
	 * 报废确认区分(0未确认1已确认)取得
	 * 
	 * @return discardeFlag
	 */
	public String getDiscardeFlag() {
		return discardeFlag;
	}

	/**
	 * 报废确认区分(0未确认1已确认)设定
	 * 
	 * @param discardeFlag
	 */
	public void setDiscardeFlag(String discardeFlag) {
		this.discardeFlag = discardeFlag;
	}
	
	// 删除标识
	private String delFlag;

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	// 创建者
	private String createUser;
	// 更新者
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
	
	private String synthesisCutterNumber;

	public String getSynthesisCutterNumber() {
		return synthesisCutterNumber;
	}

	public void setSynthesisCutterNumber(String synthesisCutterNumber) {
		this.synthesisCutterNumber = synthesisCutterNumber;
	}
	
	

}
