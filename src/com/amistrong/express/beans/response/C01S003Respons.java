package com.amistrong.express.beans.response;


import java.io.Serializable;

/**
 * C01S003Respons-返回参数
 * @ClassName: C01S003Respons 
 * @author wangran
 * @date 2017-6-30 14：49
 */
public class C01S003Respons implements Serializable{

	private static final long serialVersionUID = 5001175783973560215L;
	
//	// 取得换领申请人申请列表
//	private List<AppliedInfo> appliedInfoList;
//	
//	public List<AppliedInfo> getAppliedInfoList() {
//		return appliedInfoList;
//	}
//
//	public void setAppliedInfoList(List<AppliedInfo> appliedInfoList) {
//		this.appliedInfoList = appliedInfoList;
//	}
	
	
	
	// 刀具ID
	private String toolID;
	
	// 材料号
	private String materialNum;
	
	// 申请数量
	private Integer requestNum;
		
	// 库存量
	private String inventory;
	
	// 库位码
	private String libraryCodeID;
	
	// 刀具类型
	private String toolType;
	
	// 刀具码
	private String rfidCode;

	public Integer getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(Integer requestNum) {
		this.requestNum = requestNum;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
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

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}
	
	
}
