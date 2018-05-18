/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/06/14 11:40:15
 */
package com.amistrong.express.beans.response;
import java.io.Serializable;
import java.math.BigDecimal;
import com.amistrong.express.beans.BaseEntity;

/**
 * 采购表条件Bean
 * 
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class ToolprocuredWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 采购ID	*/ 
	private String toolProcuredIDWhere;

	/**
	 * 采购ID取得
	 * @return toolProcuredIDWhere
	 */
	public String getToolProcuredIDWhere () {
		return toolProcuredIDWhere;
	}

	/**
	 * 采购ID设定
	 * @param toolProcuredIDWhere
	 */
	public void setToolProcuredIDWhere (String toolProcuredIDWhere) {
		this.toolProcuredIDWhere = toolProcuredIDWhere;
	}

	/* 订单号	*/ 
	private String toolsOrdeNOWhere;

	/**
	 * 订单号取得
	 * @return toolsOrdeNOWhere
	 */
	public String getToolsOrdeNOWhere () {
		return toolsOrdeNOWhere;
	}

	/**
	 * 订单号设定
	 * @param toolsOrdeNOWhere
	 */
	public void setToolsOrdeNOWhere (String toolsOrdeNOWhere) {
		this.toolsOrdeNOWhere = toolsOrdeNOWhere;
	}

	/* 材料号	*/ 
	private String toolCodeWhere;

	/**
	 * 材料号取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 材料号设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 采购批次	*/ 
	private String procuredBatchWhere;

	/**
	 * 采购批次取得
	 * @return procuredBatchWhere
	 */
	public String getProcuredBatchWhere () {
		return procuredBatchWhere;
	}

	/**
	 * 采购批次设定
	 * @param procuredBatchWhere
	 */
	public void setProcuredBatchWhere (String procuredBatchWhere) {
		this.procuredBatchWhere = procuredBatchWhere;
	}

	/* 采购日期	*/ 
	private String procuredTimeWhere;

	/**
	 * 采购日期取得
	 * @return procuredTimeWhere
	 */
	public String getProcuredTimeWhere () {
		return procuredTimeWhere;
	}

	/**
	 * 采购日期设定
	 * @param procuredTimeWhere
	 */
	public void setProcuredTimeWhere (String procuredTimeWhere) {
		this.procuredTimeWhere = procuredTimeWhere;
	}

	/* 采购单价	*/ 
	private String unitPriceWhere;

	/**
	 * 采购单价取得
	 * @return unitPriceWhere
	 */
	public String getUnitPriceWhere () {
		return unitPriceWhere;
	}

	/**
	 * 采购单价设定
	 * @param unitPriceWhere
	 */
	public void setUnitPriceWhere (String unitPriceWhere) {
		this.unitPriceWhere = unitPriceWhere;
	}

	/* 采购者(关联用户ID)	*/ 
	private String procuredUserWhere;

	/**
	 * 采购者(关联用户ID)取得
	 * @return procuredUserWhere
	 */
	public String getProcuredUserWhere () {
		return procuredUserWhere;
	}

	/**
	 * 采购者(关联用户ID)设定
	 * @param procuredUserWhere
	 */
	public void setProcuredUserWhere (String procuredUserWhere) {
		this.procuredUserWhere = procuredUserWhere;
	}

	/* 采购数量	*/ 
	private BigDecimal procuredCountWhere;

	/**
	 * 采购数量取得
	 * @return procuredCountWhere
	 */
	public BigDecimal getProcuredCountWhere () {
		return procuredCountWhere;
	}

	/**
	 * 采购数量设定
	 * @param procuredCountWhere
	 */
	public void setProcuredCountWhere (BigDecimal procuredCountWhere) {
		this.procuredCountWhere = procuredCountWhere;
	}

	/* 是否入库(0是1否)	*/ 
	private String procuredIntoWhere;

	/**
	 * 是否入库(0是1否)取得
	 * @return procuredIntoWhere
	 */
	public String getProcuredIntoWhere () {
		return procuredIntoWhere;
	}

	/**
	 * 是否入库(0是1否)设定
	 * @param procuredIntoWhere
	 */
	public void setProcuredIntoWhere (String procuredIntoWhere) {
		this.procuredIntoWhere = procuredIntoWhere;
	}

	/* 是否付费(0是1否9其他)	*/ 
	private String procuredPayingWhere;

	/**
	 * 是否付费(0是1否9其他)取得
	 * @return procuredPayingWhere
	 */
	public String getProcuredPayingWhere () {
		return procuredPayingWhere;
	}

	/**
	 * 是否付费(0是1否9其他)设定
	 * @param procuredPayingWhere
	 */
	public void setProcuredPayingWhere (String procuredPayingWhere) {
		this.procuredPayingWhere = procuredPayingWhere;
	}

	/* 采购类型(0新采购1外委图层2外委复磨9其他)	*/ 
	private String procuredTypeWhere;

	/**
	 * 采购类型(0新采购1外委图层2外委复磨9其他)取得
	 * @return procuredTypeWhere
	 */
	public String getProcuredTypeWhere () {
		return procuredTypeWhere;
	}

	/**
	 * 采购类型(0新采购1外委图层2外委复磨9其他)设定
	 * @param procuredTypeWhere
	 */
	public void setProcuredTypeWhere (String procuredTypeWhere) {
		this.procuredTypeWhere = procuredTypeWhere;
	}

	/* 采购数量	*/ 
	private BigDecimal procuredNumberWhere;

	/**
	 * 采购数量取得
	 * @return procuredNumberWhere
	 */
	public BigDecimal getProcuredNumberWhere () {
		return procuredNumberWhere;
	}

	/**
	 * 采购数量设定
	 * @param procuredNumberWhere
	 */
	public void setProcuredNumberWhere (BigDecimal procuredNumberWhere) {
		this.procuredNumberWhere = procuredNumberWhere;
	}
}

