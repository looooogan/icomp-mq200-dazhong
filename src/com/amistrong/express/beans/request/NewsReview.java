package com.amistrong.express.beans.request;

import java.io.Serializable;
/**
 * 新闻评论Bean
 * 
 * @author 王冉
 * @version 2016-5-17
 */
public class NewsReview implements Serializable{
	
	private static final long serialVersionUID = -5441693344168119653L;
	
	private Integer prId;//父评论ID
	private Integer nvId;//新闻视频ID
	private Integer userId;//会员ID
	private Integer rUserId;//回复会员ID
	private Integer rrUserId;//回复回复会员ID
	private String rReviewc;//评论内容
	
	public Integer getPrId() {
		return prId;
	}
	public void setPrId(Integer prId) {
		this.prId = prId;
	}
	public Integer getNvId() {
		return nvId;
	}
	public void setNvId(Integer nvId) {
		this.nvId = nvId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getrUserId() {
		return rUserId;
	}
	public void setrUserId(Integer rUserId) {
		this.rUserId = rUserId;
	}
	public Integer getRrUserId() {
		return rrUserId;
	}
	public void setRrUserId(Integer rrUserId) {
		this.rrUserId = rrUserId;
	}
	public String getrReviewc() {
		return rReviewc;
	}
	public void setrReviewc(String rReviewc) {
		this.rReviewc = rReviewc;
	}
	
	
}
