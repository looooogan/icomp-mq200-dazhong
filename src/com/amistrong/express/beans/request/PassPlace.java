package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * 请求，途经地Bean
 * @author 于鑫
 * @version 2015-5-27 15:26:07
 */
public class PassPlace implements Serializable{

	private static final long serialVersionUID = -5746896743339947122L;
	
	private String passPlaceName;	//途径地名称
	private double cost;			//收取费用
	
	public PassPlace() {
		super();
	}
	public PassPlace(String passPlaceName, double cost) {
		super();
		this.passPlaceName = passPlaceName;
		this.cost = cost;
	}

	public String getPassPlaceName() {
		return passPlaceName;
	}
	public void setPassPlaceName(String passPlaceName) {
		this.passPlaceName = passPlaceName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}