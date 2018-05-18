package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * 竞猜排名积分(总榜)查询参数Bean
 * 
 * @author 周文斌
 * @version 2016-5-9
 */
public class GuessRankAll implements Serializable{
	
	private static final long serialVersionUID = -5441693344168119653L;
	
	private String userId;// 当前页数
	private String pageNo;// 当前页数
	private int pageSize1;// 每页条数
	private Integer startNo;// 开始的数
	private Integer endNo;// 结束的数

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

