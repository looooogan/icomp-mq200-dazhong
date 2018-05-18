package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * 新闻查询参数Bean
 * 
 * @author 周文斌
 * @version 2016-5-9
 */
public class NewsVideo implements Serializable{
	
	private static final long serialVersionUID = -5441693344168119653L;
	
	private Integer nvcId;//视频分类ID
	private Integer userId;//用户ID
	private String nvType;//类型
	private String  title;//新闻标题
	private String  pageNo;//当前页数
	private int     pageSize1;//每页条数
	private Integer startNo;//开始的数
	private Integer endNo;//结束的数
	
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
	public Integer getNvcId() {
		return nvcId;
	}
	public void setNvcId(Integer nvcId) {
		this.nvcId = nvcId;
	}
	public String getNvType() {
		return nvType;
	}
	public void setNvType(String nvType) {
		this.nvType = nvType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
