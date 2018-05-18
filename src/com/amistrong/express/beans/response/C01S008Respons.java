package com.amistrong.express.beans.response;

import java.io.Serializable;

/**
 * C01S008Respons-返回参数
 * 
 * @ClassName: C01S008Respons
 * @author wangran
 * @date 2017-7-7 10：35
 */
public class C01S008Respons implements Serializable {

	private static final long serialVersionUID = 5001175783973560215L;

	private String synthesisParametersCode;// 合成刀具编码

	private String rfidContainerID;// RFID载体ID、

	private String createType;// 刀具组成类型
	
	private String code;

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	public String getRfidContainerID() {
		return rfidContainerID;
	}

	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}

	public String getCreateType() {
		return createType;
	}

	public void setCreateType(String createType) {
		this.createType = createType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
