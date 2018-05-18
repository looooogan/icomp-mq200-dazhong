package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 申领申请实体类
 * @author 工具自动生成
 * 创建时间：2016/05/24 19:40:49
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Replacement implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 申领申请流水号	*/ 
	private String replacementID;
	
	/* 刀具编码	*/ 
	private String toolCode;
	
	/* 申请数量	*/ 
	private BigDecimal appliedNumber;
	/* 申请人	*/ 
	private String applyUser;
	/* 申请时间	*/ 
	private String applyTime;
	/* 申领原因	*/ 
	private String replacementReason;
	/* 领取人（借用人）	*/ 
	private String receiveUser;
	/* 领取时间（借用时间）	*/ 
	private Date receiveTime;
	/* 处理状态(0申请中1已补领2未到期3.已归还)	*/ 
	private String processingStatus;
	/* 部门ID	*/ 
	private String departmentID;
	/* 申领区分(0补领周转1借用2特殊领用)	*/ 
	private String replacementFlag;
	/* 申请人id	*/ 
	private String applyID;
	/* 申请总数量	*/ 
	private BigDecimal appliedTotalNumber;
	//刀具ID
	private String toolID;
	//库位码
	private String libraryCodeID;
	//刀具类型
	private String toolType;
	//库存数量
	private String knifelnventoryNumber;
	//RFID标签ID
	private String rfidCode;
	//delflg
	private String delFlag;
	private String updateUser;
	

	/**
	 * 申领申请流水号取得
	 * @return replacementID
	 */
	public String getReplacementID() {
		return replacementID;
	}

	/**
	 * 申领申请流水号设定
	 * @param replacementID
	 */
	public void setReplacementID(String replacementID) {
		this.replacementID = replacementID;
	}



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


	/**
	 * 申请数量取得
	 * @return appliedNumber
	 */
	public BigDecimal getAppliedNumber() {
		return appliedNumber;
	}

	/**
	 * 申请数量设定
	 * @param appliedNumber
	 */
	public void setAppliedNumber(BigDecimal appliedNumber) {
		this.appliedNumber = appliedNumber;
	}

	/**
	 * 申请人取得
	 * @return applyUser
	 */
	public String getApplyUser() {
		return applyUser;
	}

	/**
	 * 申请人设定
	 * @param applyUser
	 */
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	/**
	 * 申请时间取得
	 * @return applyTime
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * 申请时间设定
	 * @param applyTime
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}


	/**
	 * 申领原因取得
	 * @return replacementReason
	 */
	public String getReplacementReason() {
		return replacementReason;
	}

	/**
	 * 申领原因设定
	 * @param replacementReason
	 */
	public void setReplacementReason(String replacementReason) {
		this.replacementReason = replacementReason;
	}


	/**
	 * 领取人（借用人）取得
	 * @return receiveUser
	 */
	public String getReceiveUser() {
		return receiveUser;
	}

	/**
	 * 领取人（借用人）设定
	 * @param receiveUser
	 */
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}


	/**
	 * 领取时间（借用时间）取得
	 * @return receiveTime
	 */
	public Date getReceiveTime() {
		return receiveTime;
	}

	/**
	 * 领取时间（借用时间）设定
	 * @param receiveTime
	 */
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}


	/**
	 * 处理状态(0申请中1已补领2未到期3.已归还)取得
	 * @return processingStatus
	 */
	public String getProcessingStatus() {
		return processingStatus;
	}

	/**
	 * 处理状态(0申请中1已补领2未到期3.已归还)设定
	 * @param processingStatus
	 */
	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}


	/**
	 * 部门ID取得
	 * @return departmentID
	 */
	public String getDepartmentID() {
		return departmentID;
	}

	/**
	 * 部门ID设定
	 * @param departmentID
	 */
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}


	/**
	 * 申领区分(0补领周转1借用2特殊领用)取得
	 * @return replacementFlag
	 */
	public String getReplacementFlag() {
		return replacementFlag;
	}

	/**
	 * 申领区分(0补领周转1借用2特殊领用)设定
	 * @param replacementFlag
	 */
	public void setReplacementFlag(String replacementFlag) {
		this.replacementFlag = replacementFlag;
	}


	/**
	 * 申请人id取得
	 * @return applyID
	 */
	public String getApplyID() {
		return applyID;
	}

	/**
	 * 申请人id设定
	 * @param applyID
	 */
	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}


	/**
	 * 申请总数量取得
	 * @return appliedTotalNumber
	 */
	public BigDecimal getAppliedTotalNumber() {
		return appliedTotalNumber;
	}

	/**
	 * 申请总数量设定
	 * @param appliedTotalNumber
	 */
	public void setAppliedTotalNumber(BigDecimal appliedTotalNumber) {
		this.appliedTotalNumber = appliedTotalNumber;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getKnifelnventoryNumber() {
		return knifelnventoryNumber;
	}

	public void setKnifelnventoryNumber(String knifelnventoryNumber) {
		this.knifelnventoryNumber = knifelnventoryNumber;
	}

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
}

