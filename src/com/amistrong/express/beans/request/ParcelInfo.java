package com.amistrong.express.beans.request;

import java.io.Serializable;

import org.springframework.beans.AmistrongListElement;

public class ParcelInfo extends AmistrongListElement  implements Serializable{

	private static final long serialVersionUID = -4130767266233526044L;

	private double weight;				//重量
	private String parceType;			//包裹类型
	private String sketch;				//简述
	private String goodsImg;			//图片名
	private String consigneeName;		//收件人姓名
	private String consigneePhone;		//收件人电话
	private String consigneeAddress;	//收货地址
	
	public ParcelInfo() {
		super();
	}
	public ParcelInfo(double weight, String parceType, String sketch,
			String goodsImg, String consigneeName, String consigneePhone,
			String consigneeAddress) {
		super();
		this.weight = weight;
		this.parceType = parceType;
		this.sketch = sketch;
		this.goodsImg = goodsImg;
		this.consigneeName = consigneeName;
		this.consigneePhone = consigneePhone;
		this.consigneeAddress = consigneeAddress;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getParceType() {
		return parceType;
	}
	public void setParceType(String parceType) {
		this.parceType = parceType;
	}
	public String getSketch() {
		return sketch;
	}
	public void setSketch(String sketch) {
		this.sketch = sketch;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
}