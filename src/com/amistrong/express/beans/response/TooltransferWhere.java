package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.amistrong.express.beans.BaseEntity;

/**
 * 刀具流转表条件Bean
 * 
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class TooltransferWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID载体ID */
	private String rfidContainerIDWhere;

	/**
	 * RFID载体ID取得
	 * 
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere() {
		return rfidContainerIDWhere;
	}

	/**
	 * RFID载体ID设定
	 * 
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere(String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}

	/* 刀具入库编码 */
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * 
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere() {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * 
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere(String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}

	/* 刀具ID */
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * 
	 * @return toolIDWhere
	 */
	public String getToolIDWhere() {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * 
	 * @param toolIDWhere
	 */
	public void setToolIDWhere(String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 采购批次 */
	private String procuredBatchWhere;

	/**
	 * 采购批次取得
	 * 
	 * @return procuredBatchWhere
	 */
	public String getProcuredBatchWhere() {
		return procuredBatchWhere;
	}

	/**
	 * 采购批次设定
	 * 
	 * @param procuredBatchWhere
	 */
	public void setProcuredBatchWhere(String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	/* 最后执行业务流程 */
	private String businessFlowLnkIDWhere;

	/**
	 * 最后执行业务流程取得
	 * 
	 * @return businessFlowLnkIDWhere
	 */
	public String getBusinessFlowLnkIDWhere() {
		return businessFlowLnkIDWhere;
	}

	/**
	 * 最后执行业务流程设定
	 * 
	 * @param businessFlowLnkIDWhere
	 */
	public void setBusinessFlowLnkIDWhere(String businessFlowLnkIDWhere) {
		this.businessFlowLnkIDWhere = businessFlowLnkIDWhere;
	}

	/* 加工数量 */
	private BigDecimal processAmountWhere;

	/**
	 * 加工数量取得
	 * 
	 * @return processAmountWhere
	 */
	public BigDecimal getProcessAmountWhere() {
		return processAmountWhere;
	}

	/**
	 * 加工数量设定
	 * 
	 * @param processAmountWhere
	 */
	public void setProcessAmountWhere(BigDecimal processAmountWhere) {
		this.processAmountWhere = processAmountWhere;
	}

	/* 当前数量 */
	private BigDecimal toolDurableWhere;

	/**
	 * 当前数量取得
	 * 
	 * @return toolDurableWhere
	 */
	public BigDecimal getToolDurableWhere() {
		return toolDurableWhere;
	}

	/**
	 * 当前数量设定
	 * 
	 * @param toolDurableWhere
	 */
	public void setToolDurableWhere(BigDecimal toolDurableWhere) {
		this.toolDurableWhere = toolDurableWhere;
	}

	/* 可使用(刃磨)次数 */
	private BigDecimal toolSharpennumWhere;

	/**
	 * 可使用(刃磨)次数取得
	 * 
	 * @return toolSharpennumWhere
	 */
	public BigDecimal getToolSharpennumWhere() {
		return toolSharpennumWhere;
	}

	/**
	 * 可使用(刃磨)次数设定
	 * 
	 * @param toolSharpennumWhere
	 */
	public void setToolSharpennumWhere(BigDecimal toolSharpennumWhere) {
		this.toolSharpennumWhere = toolSharpennumWhere;
	}

	/* 复磨标准 */
	private BigDecimal toolSharpenCriterionWhere;

	/**
	 * 复磨标准取得
	 * 
	 * @return toolSharpenCriterionWhere
	 */
	public BigDecimal getToolSharpenCriterionWhere() {
		return toolSharpenCriterionWhere;
	}

	/**
	 * 复磨标准设定
	 * 
	 * @param toolSharpenCriterionWhere
	 */
	public void setToolSharpenCriterionWhere(
			BigDecimal toolSharpenCriterionWhere) {
		this.toolSharpenCriterionWhere = toolSharpenCriterionWhere;
	}

	/* 刀具长度 */
	private BigDecimal toolLengthWhere;

	/**
	 * 刀具长度取得
	 * 
	 * @return toolLengthWhere
	 */
	public BigDecimal getToolLengthWhere() {
		return toolLengthWhere;
	}

	/**
	 * 刀具长度设定
	 * 
	 * @param toolLengthWhere
	 */
	public void setToolLengthWhere(BigDecimal toolLengthWhere) {
		this.toolLengthWhere = toolLengthWhere;
	}

	/* 可刃磨长度 */
	private BigDecimal toolSharpenLengthWhere;

	/**
	 * 可刃磨长度取得
	 * 
	 * @return toolSharpenLengthWhere
	 */
	public BigDecimal getToolSharpenLengthWhere() {
		return toolSharpenLengthWhere;
	}

	/**
	 * 可刃磨长度设定
	 * 
	 * @param toolSharpenLengthWhere
	 */
	public void setToolSharpenLengthWhere(BigDecimal toolSharpenLengthWhere) {
		this.toolSharpenLengthWhere = toolSharpenLengthWhere;
	}

	/* 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废] */
	private BigDecimal usageCounterWhere;

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]取得
	 * 
	 * @return usageCounterWhere
	 */
	public BigDecimal getUsageCounterWhere() {
		return usageCounterWhere;
	}

	/**
	 * 已使用(刃磨)次数[当使用次数等于可复用次数时刀具报废]设定
	 * 
	 * @param usageCounterWhere
	 */
	public void setUsageCounterWhere(BigDecimal usageCounterWhere) {
		this.usageCounterWhere = usageCounterWhere;
	}

	/* 刀具已刃磨长度 */
	private BigDecimal toolGrindingLengthWhere;

	/**
	 * 刀具已刃磨长度取得
	 * 
	 * @return toolGrindingLengthWhere
	 */
	public BigDecimal getToolGrindingLengthWhere() {
		return toolGrindingLengthWhere;
	}

	/**
	 * 刀具已刃磨长度设定
	 * 
	 * @param toolGrindingLengthWhere
	 */
	public void setToolGrindingLengthWhere(BigDecimal toolGrindingLengthWhere) {
		this.toolGrindingLengthWhere = toolGrindingLengthWhere;
	}

	/* 刀具安装合成刀状态(0未安装1已安装2卸下9其他) */
	private String installationStateWhere;

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)取得
	 * 
	 * @return installationStateWhere
	 */
	public String getInstallationStateWhere() {
		return installationStateWhere;
	}

	/**
	 * 刀具安装合成刀状态(0未安装1已安装2卸下9其他)设定
	 * 
	 * @param installationStateWhere
	 */
	public void setInstallationStateWhere(String installationStateWhere) {
		this.installationStateWhere = installationStateWhere;
	}

	/* 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他) */
	private String toolStateWhere;

	/**
	 * 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)取得
	 * 
	 * @return toolStateWhere
	 */
	public String getToolStateWhere() {
		return toolStateWhere;
	}

	/**
	 * 刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)设定
	 * 
	 * @param toolStateWhere
	 */
	public void setToolStateWhere(String toolStateWhere) {
		this.toolStateWhere = toolStateWhere;
	}

	/* 申领区分(0扩能1外借2工艺试验3补充周转量) */
	private String replacementFlagWhere;

	/**
	 * 申领区分(0扩能1外借2工艺试验3补充周转量)取得
	 * 
	 * @return replacementFlagWhere
	 */
	public String getReplacementFlagWhere() {
		return replacementFlagWhere;
	}

	/**
	 * 申领区分(0扩能1外借2工艺试验3补充周转量)设定
	 * 
	 * @param replacementFlagWhere
	 */
	public void setReplacementFlagWhere(String replacementFlagWhere) {
		this.replacementFlagWhere = replacementFlagWhere;
	}

	/* 确认人(断刀、丢失、不合格的状态选择时需要上级确认) */
	private String confirmedUserWhere;

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)取得
	 * 
	 * @return confirmedUserWhere
	 */
	public String getConfirmedUserWhere() {
		return confirmedUserWhere;
	}

	/**
	 * 确认人(断刀、丢失、不合格的状态选择时需要上级确认)设定
	 * 
	 * @param confirmedUserWhere
	 */
	public void setConfirmedUserWhere(String confirmedUserWhere) {
		this.confirmedUserWhere = confirmedUserWhere;
	}

	/* 刀具部门(0库存,1对刀室,2刃磨室,3,车间) */
	private String toolThisStateWhere;

	/**
	 * 刀具部门(0库存,1对刀室,2刃磨室,3,车间)取得
	 * 
	 * @return toolThisStateWhere
	 */
	public String getToolThisStateWhere() {
		return toolThisStateWhere;
	}

	/**
	 * 刀具部门(0库存,1对刀室,2刃磨室,3,车间)设定
	 * 
	 * @param toolThisStateWhere
	 */
	public void setToolThisStateWhere(String toolThisStateWhere) {
		this.toolThisStateWhere = toolThisStateWhere;
	}

	/* 库存状态(0正常1报废2返厂3封存4.流转9其他) */
	private String stockStateWhere;

	/**
	 * 库存状态(0正常1报废2返厂3封存4.流转9其他)取得
	 * 
	 * @return stockStateWhere
	 */
	public String getStockStateWhere() {
		return stockStateWhere;
	}

	/**
	 * 库存状态(0正常1报废2返厂3封存4.流转9其他)设定
	 * 
	 * @param stockStateWhere
	 */
	public void setStockStateWhere(String stockStateWhere) {
		this.stockStateWhere = stockStateWhere;
	}

	/* 报废确认区分(0未确认1已确认) */
	private String discardeFlagWhere;

	/**
	 * 报废确认区分(0未确认1已确认)取得
	 * 
	 * @return discardeFlagWhere
	 */
	public String getDiscardeFlagWhere() {
		return discardeFlagWhere;
	}

	/**
	 * 报废确认区分(0未确认1已确认)设定
	 * 
	 * @param discardeFlagWhere
	 */
	public void setDiscardeFlagWhere(String discardeFlagWhere) {
		this.discardeFlagWhere = discardeFlagWhere;
	}

}
