package com.amistrong.express.beans.response;

import java.io.Serializable;


/**
 * 报废状态Bean
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class ScrapState implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	
	// 报废状态
	private String scrapState;
	
	private String scrapStateName;

	public String getScrapState() {
		return scrapState;
	}

	public void setScrapState(String scrapState) {
		this.scrapState = scrapState;
	}

	public String getScrapStateName() {
		return scrapStateName;
	}

	public void setScrapStateName(String scrapStateName) {
		this.scrapStateName = scrapStateName;
	}
	

}
