package com.amistrong.express.beans.response;

import java.io.Serializable;

/**
 * 响应，选择快递员信息Bean
 * @author 于鑫
 * @version 2015-6-10 11:08:06
 */
public class SelectCourier implements Serializable{
	
	private static final long serialVersionUID = -6353153389651280124L;
	
	private Integer courierId;			//快递员id
	private String courierName;		//快递员姓名
	private String company;			//快递员所属公司
	private double offer;				//快递费用
	private double evaluationScores;	//评价分数
	private String headImage;			//头像
	
	public Integer getCourierId() {
		return courierId;
	}
	public void setCourierId(Integer courierId) {
		this.courierId = courierId;
	}
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public double getEvaluationScores() {
		return evaluationScores;
	}
	public void setEvaluationScores(double evaluationScores) {
		this.evaluationScores = evaluationScores;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	
}