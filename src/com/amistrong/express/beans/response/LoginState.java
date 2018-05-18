package com.amistrong.express.beans.response;

import java.io.Serializable;

/**
 * 响应，登录状态Bean
 * 
 * @author 于鑫
 * @version 2015-5-18 20:35:34
 */
public class LoginState implements Serializable {

	private static final long serialVersionUID = -6133994990653815464L;

	private int userId; // 用户ID
	private int code; // 返回错误码(作为跳转传值)
	private String headImgUrl;// 头像url
	private String nickName;// 昵称
	
	private String isLeader;//是否是领队
	private String leagueTeamId;//球队id

	public String getIsLeader() {
		return isLeader;
	}

	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}

	public String getLeagueTeamId() {
		return leagueTeamId;
	}

	public void setLeagueTeamId(String leagueTeamId) {
		this.leagueTeamId = leagueTeamId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
