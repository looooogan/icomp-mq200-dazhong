package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.util.List;


public class C01S001Respons implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3141031861267681716L;
	
	/* 刀具ID*/
	private String toolID;
	
	/* 材料号*/
	private String materialNum;
	
	/* 库位码*/
	private String libraryCodeID;
	
	/* 库存数量*/
	private String unitnumber;
	
	private String code;
	
	/* 采购批次数量列表 */
	private List<ProcuredBatchCount> procuredBatchCount;
	
	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}

	public String getUnitnumber() {
		return unitnumber;
	}

	public void setUnitnumber(String unitnumber) {
		this.unitnumber = unitnumber;
	}

/*	private String storageNum;

	public String getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(String storageNum) {
		this.storageNum = storageNum;
	}*/
	
	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public List<ProcuredBatchCount> getProcuredBatchCount() {
		return procuredBatchCount;
	}

	public void setProcuredBatchCount(List<ProcuredBatchCount> procuredBatchCount) {
		this.procuredBatchCount = procuredBatchCount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
