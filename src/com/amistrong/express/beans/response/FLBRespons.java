package com.amistrong.express.beans.response;

import java.io.Serializable;

public class FLBRespons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3141031861267681716L;

	private String toolCode;// 材料号
	
	private String toolID;// 刀具编号
	
	private String toolConsumeType;// 刀具类型
	
	private String libraryCodeID;// 库位码
	
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getToolID() {
		return toolID;
	}
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	public String getToolConsumeType() {
		return toolConsumeType;
	}
	public void setToolConsumeType(String toolConsumeType) {
		this.toolConsumeType = toolConsumeType;
	}
	public String getLibraryCodeID() {
		return libraryCodeID;
	}
	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}
	
	

}
