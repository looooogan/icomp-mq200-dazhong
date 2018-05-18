package com.amistrong.express.beans.response;

import java.io.Serializable;

public class ToolDurable implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	
	private Integer toolDurable;

	public Integer getToolDurable() {
		return toolDurable;
	}

	public void setToolDurable(Integer toolDurable) {
		this.toolDurable = toolDurable;
	}
	
	

}
