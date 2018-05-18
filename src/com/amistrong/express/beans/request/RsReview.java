package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * 评论的评论Bean
 * 
 * @author 王冉
 * @version 2016-5-17
 */
public class RsReview implements Serializable{
	
	private static final long serialVersionUID = -5441693344168119653L;
	
	private Integer rId;//评论ID
	private Integer nvId;//新闻视频ID
	private Integer rUserId;//评论会员ID
	private Integer userId;//用户ID
	private String  pageNo;//当前条数
	private int pageSize1;//每页条数
	private Integer startNo;//开始的数
	private Integer endNo;//结束的数
	
	
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
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
	public Integer getNvId() {
		return nvId;
	}
	public void setNvId(Integer nvId) {
		this.nvId = nvId;
	}
	
	public Integer getrUserId() {
		return rUserId;
	}
	public void setrUserId(Integer rUserId) {
		this.rUserId = rUserId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
}
