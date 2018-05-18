package com.amistrong.express.beans.response;

import java.io.Serializable;

/**
 * 厂外修复商家Bean
 * 
 * @author 王冉
 * @version 2017-7-4 10:30
 */
public class Merchants implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 商家ID */
	private String merchantsID;

	/**
	 * 商家ID取得
	 * 
	 * @return merchantsID
	 */
	public String getMerchantsID() {
		return merchantsID;
	}

	/**
	 * 商家ID设定
	 * 
	 * @param merchantsID
	 */
	public void setMerchantsID(String merchantsID) {
		this.merchantsID = merchantsID;
	}

	/* 商家名称 */
	private String merchantsName;

	/**
	 * 商家名称取得
	 * 
	 * @return merchantsName
	 */
	public String getMerchantsName() {
		return merchantsName;
	}

	/**
	 * 商家名称设定
	 * 
	 * @param merchantsName
	 */
	public void setMerchantsName(String merchantsName) {
		this.merchantsName = merchantsName;
	}
}
