package com.amistrong.express.beans.request;

public class ScheduleInfo {
	private Integer scheduleId;// 赛程ID
	private Integer leagueMatchId;// 联赛ID
	private Integer seasonId;// 赛季
	private Integer cupId;// 杯赛ID
	private Integer leagueMatchGroupId;//小组ID
	private Integer leagueTeamIdM;// 联赛球队ID-主队
	private Integer leagueTeamIdG;// 联赛球队ID-客队
	private Integer leagueRound;// 比赛轮数
	private String matchTime;// 比赛时间
	private String matchMonth;// 比赛月
	private Integer state;// 状态
	private String remarks;// 备注

	public String getMatchMonth() {
		return matchMonth;
	}

	public void setMatchMonth(String matchMonth) {
		this.matchMonth = matchMonth;
	}

	public Integer getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getLeagueMatchId() {
		return leagueMatchId;
	}

	public void setLeagueMatchId(Integer leagueMatchId) {
		this.leagueMatchId = leagueMatchId;
	}

	public Integer getLeagueTeamIdM() {
		return leagueTeamIdM;
	}

	public void setLeagueTeamIdM(Integer leagueTeamIdM) {
		this.leagueTeamIdM = leagueTeamIdM;
	}

	public Integer getLeagueTeamIdG() {
		return leagueTeamIdG;
	}

	public void setLeagueTeamIdG(Integer leagueTeamIdG) {
		this.leagueTeamIdG = leagueTeamIdG;
	}

	public Integer getLeagueRound() {
		return leagueRound;
	}

	public void setLeagueRound(Integer leagueRound) {
		this.leagueRound = leagueRound;
	}

	public String getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getLeagueMatchGroupId() {
		return leagueMatchGroupId;
	}

	public void setLeagueMatchGroupId(Integer leagueMatchGroupId) {
		this.leagueMatchGroupId = leagueMatchGroupId;
	}

	public Integer getCupId() {
		return cupId;
	}

	public void setCupId(Integer cupId) {
		this.cupId = cupId;
	}
	
}
