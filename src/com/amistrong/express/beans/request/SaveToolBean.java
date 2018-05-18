package com.amistrong.express.beans.request;

import java.io.Serializable;

public class SaveToolBean implements Serializable {

	private static final long serialVersionUID = -5441693344168119653L;

	private String customerID;// 用户ID
	private String materialNum;// 材料号
	private String toolsOrdeNO;// 订单号
	private String storageNum;// 入库数量
	private String toolID;// 刀具ID
	private String costCenter;//成本中心
	private String valType;//评估类型
	private String poItem;//订单序号

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	public String getToolsOrdeNO() {
		return toolsOrdeNO;
	}

	public void setToolsOrdeNO(String toolsOrdeNO) {
		this.toolsOrdeNO = toolsOrdeNO;
	}

	public String getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(String storageNum) {
		this.storageNum = storageNum;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getValType() {
		return valType;
	}

	public void setValType(String valType) {
		this.valType = valType;
	}

	public String getPoItem() {
		return poItem;
	}

	public void setPoItem(String poItem) {
		this.poItem = poItem;
	}
	
	

}
