/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/09/04 16:21:29
 */
package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 报废Bean
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class Scrap implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 报废ID	*/ 
	private String scrapID;

	/**
	 * 报废ID取得
	 * @return scrapID
	 */
	public String getScrapID() {
		return scrapID;
	}

	/**
	 * 报废ID设定
	 * @param scrapID
	 */
	public void setScrapID(String scrapID) {
		this.scrapID = scrapID;
	}

	/* 刀具类型（0:可刃磨钻头1可刃磨刀片2一次性刀片9其他）	*/ 
	private String toolType;

	/**
	 * 刀具类型（0:可刃磨钻头1可刃磨刀片2一次性刀片9其他）取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 刀具类型（0:可刃磨钻头1可刃磨刀片2一次性刀片9其他）设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	/* 流程ID	*/ 
	private String businessID;

	/**
	 * 流程ID取得
	 * @return businessID
	 */
	public String getBusinessID() {
		return businessID;
	}

	/**
	 * 流程ID设定
	 * @param businessID
	 */
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

	/* 材料号	*/ 
	private String material;

	/**
	 * 材料号取得
	 * @return material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * 材料号设定
	 * @param material
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/* 单品ID	*/ 
	private String knifeInventoryCode;

	/**
	 * 单品ID取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 单品ID设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
	}

	/* 已刃磨次数	*/ 
	private BigDecimal usageCounter;

	/**
	 * 已刃磨次数取得
	 * @return usageCounter
	 */
	public BigDecimal getUsageCounter() {
		return usageCounter;
	}

	/**
	 * 已刃磨次数设定
	 * @param usageCounter
	 */
	public void setUsageCounter(BigDecimal usageCounter) {
		this.usageCounter = usageCounter;
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

	/* 报废原因	*/ 
	private String scrapCause;

	/**
	 * 报废原因取得
	 * @return scrapCause
	 */
	public String getScrapCause() {
		return scrapCause;
	}

	/**
	 * 报废原因设定
	 * @param scrapCause
	 */
	public void setScrapCause(String scrapCause) {
		this.scrapCause = scrapCause;
	}

	/* 报废数量	*/ 
	private BigDecimal scrapNumber;

	/**
	 * 报废数量取得
	 * @return scrapNumber
	 */
	public BigDecimal getScrapNumber() {
		return scrapNumber;
	}

	/**
	 * 报废数量设定
	 * @param scrapNumber
	 */
	public void setScrapNumber(BigDecimal scrapNumber) {
		this.scrapNumber = scrapNumber;
	}

	/* 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）	*/ 
	private String scrapState;

	/**
	 * 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）取得
	 * @return scrapState
	 */
	public String getScrapState() {
		return scrapState;
	}

	/**
	 * 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）设定
	 * @param scrapState
	 */
	public void setScrapState(String scrapState) {
		this.scrapState = scrapState;
	}

	/* 报废时间	*/ 
	private Date scrapTime;

	/**
	 * 报废时间取得
	 * @return scrapTime
	 */
	public Date getScrapTime() {
		return scrapTime;
	}

	/**
	 * 报废时间设定
	 * @param scrapTime
	 */
	public void setScrapTime(Date scrapTime) {
		this.scrapTime = scrapTime;
	}

	/* 授权人	*/ 
	private String authorizationID;

	/**
	 * 授权人取得
	 * @return authorizationID
	 */
	public String getAuthorizationID() {
		return authorizationID;
	}

	/**
	 * 授权人设定
	 * @param authorizationID
	 */
	public void setAuthorizationID(String authorizationID) {
		this.authorizationID = authorizationID;
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

