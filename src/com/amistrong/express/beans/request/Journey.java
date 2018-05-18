package com.amistrong.express.beans.request;

import java.io.Serializable;
import java.util.List;
/**
 * 请求，发布行程Bean
 * @author 于鑫
 * @version 2015-5-27 15:23:18
 */
public class Journey implements Serializable{

	private static final long serialVersionUID = -5746896742239947122L;
	
	private Integer courierId;		//快递员ID
	private String departurePlace;	//出发地
	private String destination;	//目的地
	private String startTime;		//预计出发时间
	private String endTime;		//预计到达时间
	private String vehicle;		//交通工具
	private String explain;		//说明
	private List<PassPlace> passPlace;	//途经地列表
	
	public List<PassPlace> getPassPlace() {
		return passPlace;
	}
	public void setPassPlace(List<PassPlace> passPlace) {
		this.passPlace = passPlace;
	}
	public Integer getCourierId() {
		return courierId;
	}
	public void setCourierId(Integer courierId) {
		this.courierId = courierId;
	}
	public String getDeparturePlace() {
		return departurePlace;
	}
	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}