package com.amistrong.express.beans.response;

import java.io.Serializable;

/**
 * C03S001Respons-返回参数
 * 
 * @ClassName: C03S001Respons
 * @author wangran
 * @date 2017-7-7 10：35
 */
public class GetOutFactoryToolInfoRespons implements Serializable {

	private static final long serialVersionUID = 5001175783973560215L;

	// RFID载体ID
	private String rfidContainerID;

	// 刀具材料号
	private String toolCode;

	// 组成类型
	private String toolType;

	// 刀具ID
	private String toolID;

	// 是否需要授权
	private String code;

	public String getRfidContainerID() {
		return rfidContainerID;
	}

	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
