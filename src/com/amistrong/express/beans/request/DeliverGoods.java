package com.amistrong.express.beans.request;

import java.io.Serializable;
import java.util.List;

/**
 * 请求，发货bean
 * @author 于鑫
 * @version 2015-5-26 13:05:53
 */
public class DeliverGoods  implements Serializable{

	private static final long serialVersionUID = 1330895298137327797L;
	
	private Integer userId;		//用户ID
	private String deliverTime;	//发货时间
	private String endTime;		//终到时间
	private String deliverName;	//发货人姓名
	private String deliverPhone;	//发货人电话
	private String deliverAddress;	//发货地址
	private double longitude;		//经度
	private double latitude;		//纬度
	private String isFlag;     //是否同城快递
	private List<ParcelInfo> parcelInfoList;	//快件信息列表
	private String ziti;
	
	public DeliverGoods() {
		super();
	}
	public DeliverGoods(Integer userId, String deliverTime, String endTime,
			String deliverName, String deliverPhone, String deliverAddress,
			double longitude, double latitude, List<ParcelInfo> parcelInfoList,String isFlag,String ziti) {
		super();
		this.userId = userId;
		this.deliverTime = deliverTime;
		this.endTime = endTime;
		this.deliverName = deliverName;
		this.deliverPhone = deliverPhone;
		this.deliverAddress = deliverAddress;
		this.longitude = longitude;
		this.latitude = latitude;
		this.parcelInfoList = parcelInfoList;
		this.isFlag = isFlag;
		this.ziti = ziti;
	}
	public List<ParcelInfo> getParcelInfoList() {
		return parcelInfoList;
	}
	public void setParcelInfoList(List<ParcelInfo> parcelInfoList) {
		this.parcelInfoList = parcelInfoList;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDeliverName() {
		return deliverName;
	}
	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}
	public String getDeliverPhone() {
		return deliverPhone;
	}
	public void setDeliverPhone(String deliverPhone) {
		this.deliverPhone = deliverPhone;
	}
	public String getDeliverAddress() {
		return deliverAddress;
	}
	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getDeliverTime() {
		return deliverTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getIsFlag() {
		return isFlag;
	}
	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}
	public String getZiti() {
		return ziti;
	}
	public void setZiti(String ziti) {
		this.ziti = ziti;
	}
	
}