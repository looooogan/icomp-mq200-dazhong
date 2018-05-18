package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.util.Date;

/**
 *  sap上传履历表Bean
 * @author 王冉
 * @version 2017-11-29
 */
public class SapUploadhistory implements Serializable{
	
	private static final long serialVersionUID = -6353153389651280124L;
	
	private String sapID;//sapID
	private Date pstngDate;//过账日期
	private Date docDate;//凭证日期
	private String material;//物料号 
	private String moveType;//移动类型
	private String entryQnt;//数量
	private String moveMat;//收货/发货工厂物料
	private String costCenter;//成本中心
	private String orderID;//订单号
	private Date outInDate;//出/入库日期
	private Date uploadDate;//sap上传时间
	private String state;//上传状态 0:未上传1:已上传2:上传失败3:手动处理
	private Date updateTime;//更新时间
	private String UpdateUser;//更新者
	private Date createTime;//创建时间
	private String createUser;//创建者
	private String delFlag;//删除标识
	private String outInUser;//操作者
	private String message;//上传消息
	private String valType;//评估类型
	private String poItem;//订单序号
	
	public String getSapID() {
		return sapID;
	}
	public void setSapID(String sapID) {
		this.sapID = sapID;
	}
	public Date getPstngDate() {
		return pstngDate;
	}
	public void setPstngDate(Date pstngDate) {
		this.pstngDate = pstngDate;
	}
	public Date getDocDate() {
		return docDate;
	}
	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getMoveType() {
		return moveType;
	}
	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}
	public String getEntryQnt() {
		return entryQnt;
	}
	public void setEntryQnt(String entryQnt) {
		this.entryQnt = entryQnt;
	}
	public String getMoveMat() {
		return moveMat;
	}
	public void setMoveMat(String moveMat) {
		this.moveMat = moveMat;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Date getOutInDate() {
		return outInDate;
	}
	public void setOutInDate(Date outInDate) {
		this.outInDate = outInDate;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUser() {
		return UpdateUser;
	}
	public void setUpdateUser(String updateUser) {
		UpdateUser = updateUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getOutInUser() {
		return outInUser;
	}
	public void setOutInUser(String outInUser) {
		this.outInUser = outInUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
