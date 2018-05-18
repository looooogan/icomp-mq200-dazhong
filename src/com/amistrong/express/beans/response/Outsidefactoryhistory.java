/*
 * 工具自动生成：厂外修复表实体类
 * 生成时间    : 2016/02/25 19:22:51
 */
package com.amistrong.express.beans.response;

import java.io.Serializable;


/**
 * 厂外修复履历表实体类
 * @author 工具自动生成
 * 创建时间：2017/08/24
 * 创建者  ：wr
 * 
 */
public class Outsidefactoryhistory implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	
	private String ID;// 厂外修复履历ID
	private String orderNum;//通知单号
	private String outDoorNum;//出门单号
	private String merchantsID;//商家ID
	private String toolID;//刀具ID
	private String materialNum;//材料号
	private Integer backFactoryNumber;//回厂数量
	private String createUser;//创建人
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getOutDoorNum() {
		return outDoorNum;
	}
	public void setOutDoorNum(String outDoorNum) {
		this.outDoorNum = outDoorNum;
	}
	public String getMerchantsID() {
		return merchantsID;
	}
	public void setMerchantsID(String merchantsID) {
		this.merchantsID = merchantsID;
	}
	public String getToolID() {
		return toolID;
	}
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	public String getMaterialNum() {
		return materialNum;
	}
	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}
	public Integer getBackFactoryNumber() {
		return backFactoryNumber;
	}
	public void setBackFactoryNumber(Integer backFactoryNumber) {
		this.backFactoryNumber = backFactoryNumber;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
	
}

