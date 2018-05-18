package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.amistrong.express.beans.BaseEntity;

/**
 * 库存条件Bean
 * 
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class KnifeinventoryWhere extends BaseEntity implements Serializable {

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

	/* 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他) */
	private String knifeInventoryTypeWhere;

	/**
	 * 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)取得
	 * 
	 * @return knifeInventoryTypeWhere
	 */
	public String getKnifeInventoryTypeWhere() {
		return knifeInventoryTypeWhere;
	}

	/**
	 * 库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)设定
	 * 
	 * @param knifeInventoryTypeWhere
	 */
	public void setKnifeInventoryTypeWhere(String knifeInventoryTypeWhere) {
		this.knifeInventoryTypeWhere = knifeInventoryTypeWhere;
	}

	/* 	*/
	private BigDecimal toolDurable2Where;

	/**
	 * 取得
	 * 
	 * @return toolDurable2Where
	 */
	public BigDecimal getToolDurable2Where() {
		return toolDurable2Where;
	}

	/**
	 * 设定
	 * 
	 * @param toolDurable2Where
	 */
	public void setToolDurable2Where(BigDecimal toolDurable2Where) {
		this.toolDurable2Where = toolDurable2Where;
	}

	/* 库存数量(钻头数量为1，刀片为当前数量) */
	private BigDecimal knifelnventoryNumberWhere;

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)取得
	 * 
	 * @return knifelnventoryNumberWhere
	 */
	public BigDecimal getKnifelnventoryNumberWhere() {
		return knifelnventoryNumberWhere;
	}

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)设定
	 * 
	 * @param knifelnventoryNumberWhere
	 */
	public void setKnifelnventoryNumberWhere(
			BigDecimal knifelnventoryNumberWhere) {
		this.knifelnventoryNumberWhere = knifelnventoryNumberWhere;
	}

	/* 耐用度 */
	private BigDecimal toolDurableWhere;

	/**
	 * 耐用度取得
	 * 
	 * @return toolDurableWhere
	 */
	public BigDecimal getToolDurableWhere() {
		return toolDurableWhere;
	}

	/**
	 * 耐用度设定
	 * 
	 * @param toolDurableWhere
	 */
	public void setToolDurableWhere(BigDecimal toolDurableWhere) {
		this.toolDurableWhere = toolDurableWhere;
	}

	/* 复磨次数 */
	private BigDecimal toolSharpennumWhere;

	/**
	 * 复磨次数取得
	 * 
	 * @return toolSharpennumWhere
	 */
	public BigDecimal getToolSharpennumWhere() {
		return toolSharpennumWhere;
	}

	/**
	 * 复磨次数设定
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

}
