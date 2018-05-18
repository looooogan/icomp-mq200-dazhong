package com.amistrong.express.beans.request;

/**
 * 我的球队请求Bean
 * 
 * @author wang_jc
 * @version 2016-06-21
 * 
 */
public class UserTeam {

	private Integer userId;// 用户ID
	private String pageNo;// 当前页数
	private Integer pageSize;// 每页条数
	private Integer startNo;// 开始的数
	private Integer endNo;// 结束的数

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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

}
