package com.amistrong.express.beans.request;

import com.amistrong.express.beans.BaseRequestBean;

/**
 * 投票请求 Bean
 * @author ww
 *
 */
public class VoteReqBean extends BaseRequestBean{

	private String voteNo;//投票编号
	
	private String vsNo;//投票项目编号
	
	private String userId;//用户id
	
	private String veNo;//验证码
	
	private String phoneNo;
	
	private String reqCode;//验证码请求标识
	
	public String getReqCode() {
		return reqCode;
	}

	public void setReqCode(String reqCode) {
		this.reqCode = reqCode;
	}

	public String getVeNo() {
		return veNo;
	}

	public void setVeNo(String veNo) {
		this.veNo = veNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVsNo() {
		return vsNo;
	}

	public void setVsNo(String vsNo) {
		this.vsNo = vsNo;
	}

	public String getVoteNo() {
		return voteNo;
	}

	public void setVoteNo(String voteNo) {
		this.voteNo = voteNo;
	}

}
