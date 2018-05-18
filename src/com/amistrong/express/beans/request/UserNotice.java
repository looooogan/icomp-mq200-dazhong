package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 查询我的消息参数Bean
 * 
 * @author 周文斌
 * @version 2016-5-13
 */
public class UserNotice implements Serializable {

	private static final long serialVersionUID = -5441693344168119653L;

	private Integer noticeId;// 消息ID
	private String  userId;// 用户ID
	private Integer noticeType;//消息类型

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public Integer getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
