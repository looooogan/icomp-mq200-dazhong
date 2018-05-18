package com.amistrong.express.beans.response;

import java.io.Serializable;


/**
 * 容器表实体类
 * @author 工具自动生成
 * 创建时间：2017/06/30 16:39
 * 创建者  ：王冉
 * 
 */
public class Containercarrier implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 容器ID	*/ 
	private String containerCarrierID;

	/**
	 * 容器ID取得
	 * @return containerCarrierID
	 */
	public String getContainerCarrierID() {
		return containerCarrierID;
	}

	/**
	 * 容器ID设定
	 * @param containerCarrierID
	 */
	public void setContainerCarrierID(String containerCarrierID) {
		this.containerCarrierID = containerCarrierID;
	}

	/* 容器编码	*/ 
	private String containerCarrierCode;

	/**
	 * 容器编码取得
	 * @return containerCarrierCode
	 */
	public String getContainerCarrierCode() {
		return containerCarrierCode;
	}

	/**
	 * 容器编码设定
	 * @param containerCarrierCode
	 */
	public void setContainerCarrierCode(String containerCarrierCode) {
		this.containerCarrierCode = containerCarrierCode;
	}

	/* 容器名称	*/ 
	private String containerCarrierName;

	/**
	 * 容器名称取得
	 * @return containerCarrierName
	 */
	public String getContainerCarrierName() {
		return containerCarrierName;
	}

	/**
	 * 容器名称设定
	 * @param containerCarrierName
	 */
	public void setContainerCarrierName(String containerCarrierName) {
		this.containerCarrierName = containerCarrierName;
	}

	/* 容器类别（0.一次性报废 2.待分拣容器 3.厂内待刃磨 4.厂外待刃磨 5.刃磨完毕 6.刃磨报废 7.待涂层 8.库房报废 9.其他）	*/ 
	private String containerCarrierType;

	/**
	 * 容器类别（0.一次性报废 2.待分拣容器 3.厂内待刃磨 4.厂外待刃磨 5.刃磨完毕 6.刃磨报废 7.待涂层 8.库房报废 9.其他）取得
	 * @return containerCarrierType
	 */
	public String getContainerCarrierType() {
		return containerCarrierType;
	}

	/**
	 * 容器类别（0.一次性报废 2.待分拣容器 3.厂内待刃磨 4.厂外待刃磨 5.刃磨完毕 6.刃磨报废 7.待涂层 8.库房报废 9.其他）设定
	 * @param containerCarrierType
	 */
	public void setContainerCarrierType(String containerCarrierType) {
		this.containerCarrierType = containerCarrierType;
	}

	/* rfid载体ID	*/ 
	private String rfidContainerID;

	/**
	 * rfid载体ID取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * rfid载体ID设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}

	/* 负责人	*/ 
	private String person;

	/**
	 * 负责人取得
	 * @return person
	 */
	public String getPerson() {
		return person;
	}

	/**
	 * 负责人设定
	 * @param person
	 */
	public void setPerson(String person) {
		this.person = person;
	}

	/* 备注	*/ 
	private String note;

	/**
	 * 备注取得
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 备注设定
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}
}

