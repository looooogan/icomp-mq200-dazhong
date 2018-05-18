package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.util.List;

/**
 * C03S001Respons-返回参数
 * @ClassName: C03S001Respons 
 * @author wangran
 * @date 2017-7-7 10：35
 */
public class C03S001Respons implements Serializable{

	private static final long serialVersionUID = 5001175783973560215L;
	
	// 合成刀具编码(系统唯一)
	private String synthesisParametersCode;
	
	// 组成类型
	private String createType;
	
	// 合成刀组成刀具list
	private List<SynthesisEntity> toolList;

	private List<Synthesisparameters> synthesisparametersList;

	public List<Synthesisparameters> getSynthesisparametersList() {
		return synthesisparametersList;
	}

	public void setSynthesisparametersList(List<Synthesisparameters> synthesisparametersList) {
		this.synthesisparametersList = synthesisparametersList;
	}

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
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
