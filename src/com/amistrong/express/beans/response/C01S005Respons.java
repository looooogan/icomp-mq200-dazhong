package com.amistrong.express.beans.response;

import java.io.Serializable;

/**
 * C01S005Respons-返回参数
 * @ClassName: C01S005Respons 
 * @author wangran
 * @date 2017-7-7 10：35
 */
public class C01S005Respons implements Serializable{

	private static final long serialVersionUID = 5001175783973560215L;
	
	// 合成刀具编码(系统唯一)
	private String synthesisParametersCode;
	
	// RFID载体ID
	private String rfidContainerID;
	
	private String code;
	
	private String laserCode;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLaserCode() {
		return laserCode;
	}

	public void setLaserCode(String laserCode) {
		this.laserCode = laserCode;
	}
	

}
