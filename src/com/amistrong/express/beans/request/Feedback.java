package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，反馈建议Bean
 * @author 于鑫
 * @version 2015-5-25 14:00:29
 */
public class Feedback implements Serializable{

	private static final long serialVersionUID = 7717144292081220813L;
	
	private String content;	//留言内容
	private int userId;		//用户ID
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
