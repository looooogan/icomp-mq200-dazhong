package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 授权开关实体类
 * 创建时间：2017/11/20
 * 创建者  ：wr
 * 更新者  ：wr
 * 
 */
public class Onoff implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 授权开关id	*/ 
	private String onOffID;

	/**
	 * 授权开关id取得
	 * @return onOffID
	 */
	public String getOnOffID() {
		return onOffID;
	}

	/**
	 * 授权开关id设定
	 * @param onOffID
	 */
	public void setOnOffID(String onOffID) {
		this.onOffID = onOffID;
	}

	/* 授权开关名称	*/ 
	private String onOffName;

	/**
	 * 授权开关名称取得
	 * @return onOffName
	 */
	public String getOnOffName() {
		return onOffName;
	}

	/**
	 * 授权开关名称设定
	 * @param onOffName
	 */
	public void setOnOffName(String onOffName) {
		this.onOffName = onOffName;
	}

	/* 授权开关编码	*/ 
	private String onOffCode;

	/**
	 * 授权开关编码取得
	 * @return onOffCode
	 */
	public String getOnOffCode() {
		return onOffCode;
	}

	/**
	 * 授权开关编码设定
	 * @param onOffCode
	 */
	public void setOnOffCode(String onOffCode) {
		this.onOffCode = onOffCode;
	}

	/* 授权开关备注	*/ 
	private String onOffNoed;

	/**
	 * 授权开关备注取得
	 * @return onOffNoed
	 */
	public String getOnOffNoed() {
		return onOffNoed;
	}

	/**
	 * 授权开关备注设定
	 * @param onOffNoed
	 */
	public void setOnOffNoed(String onOffNoed) {
		this.onOffNoed = onOffNoed;
	}

	/* 授权开关状态	*/ 
	private String onOffState;

	/**
	 * 授权开关状态取得
	 * @return onOffState
	 */
	public String getOnOffState() {
		return onOffState;
	}

	/**
	 * 授权开关状态设定
	 * @param onOffState
	 */
	public void setOnOffState(String onOffState) {
		this.onOffState = onOffState;
	}
}

