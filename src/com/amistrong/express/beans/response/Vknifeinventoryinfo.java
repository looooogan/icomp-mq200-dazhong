package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/04/05 14:42:16
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vknifeinventoryinfo implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* RFID载体ID	*/ 
	private String rfidContainerID;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}

	/* 刀具ID	*/ 
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 库位码	*/ 
	private String libraryCodeID;

	/**
	 * 库位码取得
	 * @return libraryCodeID
	 */
	public String getLibraryCodeID() {
		return libraryCodeID;
	}

	/**
	 * 库位码设定
	 * @param libraryCodeID
	 */
	public void setLibraryCodeID(String libraryCodeID) {
		this.libraryCodeID = libraryCodeID;
	}

	/* 库存数量(钻头数量为1，刀片为当前数量)	*/ 
	private BigDecimal knifelnventoryNumber;

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)取得
	 * @return knifelnventoryNumber
	 */
	public BigDecimal getKnifelnventoryNumber() {
		return knifelnventoryNumber;
	}

	/**
	 * 库存数量(钻头数量为1，刀片为当前数量)设定
	 * @param knifelnventoryNumber
	 */
	public void setKnifelnventoryNumber(BigDecimal knifelnventoryNumber) {
		this.knifelnventoryNumber = knifelnventoryNumber;
	}

	/* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/ 
	private String toolConsumetype;

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
	 * @return toolConsumetype
	 */
	public String getToolConsumetype() {
		return toolConsumetype;
	}

	/**
	 * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
	 * @param toolConsumetype
	 */
	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}
}

