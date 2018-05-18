package com.amistrong.express.beans;

/**
 * 分页Bean
 * @author PB , 于鑫
 * @version 2015-4-15 15:36:24
 */
public class BaseRequestBean {
	
	private int pageNo;			//当前页
	public static int pageSize ;	//每页显示条数
	private int startNo;
	private int endNo;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 翻页起始条数 计算
	 * 
	 */
	public Integer getStartNo() {
		this.startNo = ((this.pageNo) - 1) * this.pageSize;
		return startNo;
	}

	/**
	 * 翻页结束条数 计算
	 */
	public Integer getEndNo() {     
		this.endNo = this.pageSize ;
		return endNo;
	}
	
	public Integer getTotalPage(int a,int b) {
		 return(((double)a/(double)b)>(a/b)?a/b+1:a/b);
	}
}
