package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * 抢红包Bean
 * 
 * @author 王冉
 * @version 2016-5-19
 */
public class GrabEnvelope implements Serializable {
	
	private static final long serialVersionUID = -5441693344168119653L;
	
	private Integer userId;//用户ID
	private Integer redId;//红包ID
	private String pageNo;//当前页数
	private int    pageSize1;//每页条数
	private Integer startNo;//开始的数
	private Integer endNo;//结束的数
	
	
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize1() {
		return pageSize1;
	}
	public void setPageSize1(int pageSize1) {
		this.pageSize1 = pageSize1;
	}
	public Integer getStartNo() {
		return startNo;
	}
	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}
	public Integer getEndNo() {
		return endNo;
	}
	public void setEndNo(Integer endNo) {
		this.endNo = endNo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRedId() {
		return redId;
	}
	public void setRedId(Integer redId) {
		this.redId = redId;
	}
	
	
		
}

