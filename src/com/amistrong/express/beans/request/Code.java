package com.amistrong.express.beans.request;

import java.io.Serializable;

public class Code implements Serializable {

	private static final long serialVersionUID = -3647538042993367919L;

	private String codeName;	//分类名称
	private String value;		//值
	private int deleteFlag;	//删除状态
	
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}
