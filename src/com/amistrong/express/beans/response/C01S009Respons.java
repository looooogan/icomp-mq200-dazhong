package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.util.List;

/**
 * C01S009Respons-返回参数
 * 
 * @ClassName: C01S009Respons
 * @author wangran
 * @date 2017-7-7 10：35
 */
public class C01S009Respons implements Serializable {

	private static final long serialVersionUID = 5001175783973560215L;

	private String synthesisParametersCode;// 合成刀具编码

	private String rfidContainerID;// RFID载体ID、

	private String createType;// 刀具组成类型
	
	// 合成刀组成刀具list
	private List<SynthesisEntity> toolList;

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

	public List<SynthesisEntity> getToolList() {
		return toolList;
	}

	public void setToolList(List<SynthesisEntity> toolList) {
		this.toolList = toolList;
	}
	
	

}
