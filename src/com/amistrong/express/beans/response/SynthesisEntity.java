package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.util.List;

public class SynthesisEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	private String toolCode;// 材料号
	private String toolConsumetype;// 刀具类型
	private Integer toolCount;// 刀具数量
	private String toolID;//刀具编号
	private String toolConsumetypeID;//消耗类型
	private String toolGrinding;//修磨类别
	private String toolType;//
	private String grindingsum;//修磨次数
	private List<SynthesisEntity> replaceTools;

	public List<SynthesisEntity> getReplaceTools() {
		return replaceTools;
	}

	public void setReplaceTools(List<SynthesisEntity> replaceTools) {
		this.replaceTools = replaceTools;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getToolConsumetype() {
		return toolConsumetype;
	}

	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}

	public Integer getToolCount() {
		return toolCount;
	}

	public void setToolCount(Integer toolCount) {
		this.toolCount = toolCount;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public String getToolConsumetypeID() {
		return toolConsumetypeID;
	}

	public void setToolConsumetypeID(String toolConsumetypeID) {
		this.toolConsumetypeID = toolConsumetypeID;
	}

	public String getToolGrinding() {
		return toolGrinding;
	}

	public void setToolGrinding(String toolGrinding) {
		this.toolGrinding = toolGrinding;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getGrindingsum() {
		return grindingsum;
	}

	public void setGrindingsum(String grindingsum) {
		this.grindingsum = grindingsum;
	}
	

}
