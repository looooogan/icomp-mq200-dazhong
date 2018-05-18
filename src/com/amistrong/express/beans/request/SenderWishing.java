package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 57 红包祝福语
 * @author Demon
 * @version 2015-9-1 20:24:45
 */
public class SenderWishing implements Serializable{

	private static final long serialVersionUID = 133089597L;
	
	private String wishing;		// 红包祝福语 
	private String act_name;		// 活动名称
	private String remark;			// 备注
	
	public String getWishing() {
		return wishing;
	}
	public void setWishing(String wishing) {
		this.wishing = wishing;
	}
	public String getAct_name() {
		return act_name;
	}
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}