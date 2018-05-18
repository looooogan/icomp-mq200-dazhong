package com.amistrong.express.beans.response;

import java.io.Serializable;


/**
 * 刀具全生命周期实体类
 * 创建时间：2017/6/30 15:52
 * 创建者  ：王冉
 * 
 */
public class Toolwholelifecycle implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	public String processAmount;

	public String getProcessAmount() {
		return processAmount;
	}

	public void setProcessAmount(String processAmount) {
		this.processAmount = processAmount;
	}

	/* 刀具全生命周期ID	*/
	private String toolWholeLifecycleID;

	/**
	 * 刀具全生命周期ID取得
	 * @return toolWholeLifecycleID
	 */
	public String getToolWholeLifecycleID() {
		return toolWholeLifecycleID;
	}

	/**
	 * 刀具全生命周期ID设定
	 * @param toolWholeLifecycleID
	 */
	public void setToolWholeLifecycleID(String toolWholeLifecycleID) {
		this.toolWholeLifecycleID = toolWholeLifecycleID;
	}

	/* 业务-流程中间表ID	*/ 
	private String businessFlowLnkID;

	/**
	 * 业务-流程中间表ID取得
	 * @return businessFlowLnkID
	 */
	public String getBusinessFlowLnkID() {
		return businessFlowLnkID;
	}

	/**
	 * 业务-流程中间表ID设定
	 * @param businessFlowLnkID
	 */
	public void setBusinessFlowLnkID(String businessFlowLnkID) {
		this.businessFlowLnkID = businessFlowLnkID;
	}

	/* 操作手持机	*/ 
	private String handSetID;

	/**
	 * 操作手持机取得
	 * @return handSetID
	 */
	public String getHandSetID() {
		return handSetID;
	}

	/**
	 * 操作手持机设定
	 * @param handSetID
	 */
	public void setHandSetID(String handSetID) {
		this.handSetID = handSetID;
	}

	/* 刀具名称	*/ 
	private String toolID;

	/**
	 * 刀具名称取得
	 * @return toolName
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具名称设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	/* 刀具名称	*/
	private String partsID;

	/**
	 * 刀具名称取得
	 * @return
	 */
	public String getPartsID() {
		return partsID;
	}

	/**
	 * 刀具名称设定
	 * @param partsID
	 */
	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}/* 刀具名称	*/
	private String toolName;

	/**
	 * 刀具名称取得
	 * @return toolName
	 */
	public String getToolName() {
		return toolName;
	}

	/**
	 * 刀具名称设定
	 * @param toolName
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
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

