package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.util.Date;

/**
 * 授权表实体类
 * 
 * 创建时间：2017/07/24 15:07 创建者 ：wangran
 */
public class Authorization implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 授权ID */
	private String authorizationID;

	/**
	 * 授权ID取得
	 * 
	 * @return authorizationID
	 */
	public String getAuthorizationID() {
		return authorizationID;
	}

	/**
	 * 授权ID设定
	 * 
	 * @param authorizationID
	 */
	public void setAuthorizationID(String authorizationID) {
		this.authorizationID = authorizationID;
	}

	/* 授权人ID */
	private String authorizationUserID;

	/**
	 * 授权人ID取得
	 * 
	 * @return authorizationUserID
	 */
	public String getAuthorizationUserID() {
		return authorizationUserID;
	}

	/**
	 * 授权人ID设定
	 * 
	 * @param authorizationUserID
	 */
	public void setAuthorizationUserID(String authorizationUserID) {
		this.authorizationUserID = authorizationUserID;
	}

	/* 授权原因（0.断刀1.丢刀2.补领） */
	private String authorizedReason;

	/**
	 * 授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）取得
	 * 
	 * @return authorizedReason
	 */
	public String getAuthorizedReason() {
		return authorizedReason;
	}

	/**
	 * 授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）设定
	 * 
	 * @param authorizedReason
	 */
	public void setAuthorizedReason(String authorizedReason) {
		this.authorizedReason = authorizedReason;
	}

	/* 授权时间 */
	private Date authorizedTime;

	/**
	 * 授权时间取得
	 * 
	 * @return authorizedTime
	 */
	public Date getAuthorizedTime() {
		return authorizedTime;
	}

	/**
	 * 授权时间设定
	 * 
	 * @param authorizedTime
	 */
	public void setAuthorizedTime(Date authorizedTime) {
		this.authorizedTime = authorizedTime;
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

	/* 刀具类型（0单品，1合成刀具） */
	private String tooltype;

	/**
	 * 刀具类型（0单品，1合成刀具）取得
	 * 
	 * @return tooltype
	 */
	public String getTooltype() {
		return tooltype;
	}

	/**
	 * 刀具类型（0单品，1合成刀具）设定
	 * 
	 * @param tooltype
	 */
	public void setTooltype(String tooltype) {
		this.tooltype = tooltype;
	}

	/* 材料号或合成刀具编码 */
	private String toolCode;

	/**
	 * 材料号或合成刀具编码取得
	 * 
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 材料号或合成刀具编码设定
	 * 
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 业务流程编码 */
	private String businessCode;

	/**
	 * 业务流程编码取得
	 * 
	 * @return businessCode
	 */
	public String getBusinessCode() {
		return businessCode;
	}

	/**
	 * 业务流程编码设定
	 * 
	 * @param businessCode
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	/* 创建人 */
	private String createUserID;

	/**
	 * 创建人取得
	 * 
	 * @return createUserID
	 */
	public String getCreateUserID() {
		return createUserID;
	}

	/**
	 * 创建人设定
	 * 
	 * @param createUserID
	 */
	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}

	/* 备注（情况简述） */
	private String note;

	/**
	 * 备注（情况简述）取得
	 * 
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 备注（情况简述）设定
	 * 
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}
}
