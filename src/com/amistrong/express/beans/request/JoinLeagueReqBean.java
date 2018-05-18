package com.amistrong.express.beans.request;

/**
 * 加入联赛bean
 * @author wangw
 * @since 2016-08-11
 */
public class JoinLeagueReqBean {

	private String userId;
	//联赛Id
	private String leagueMatchId;
	//球队Id
	private String leagueTeamId;
	//状态 2审核
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getLeagueTeamId() {
		return leagueTeamId;
	}

	public void setLeagueTeamId(String leagueTeamId) {
		this.leagueTeamId = leagueTeamId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLeagueMatchId() {
		return leagueMatchId;
	}

	public void setLeagueMatchId(String leagueMatchId) {
		this.leagueMatchId = leagueMatchId;
	}
	
	
}
