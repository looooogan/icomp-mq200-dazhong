package com.amistrong.express.beans.request;

/**
 * 联赛球队信息
 * 
 * @author Administrator
 * 
 */
public class LeagueTeamInfo {
	private Integer userId;//会员Id
	private Integer leagueMatchGroupId;//小组ID
	private Integer leagueCupId;//杯赛ID
	private Integer leagueTeamId;// 联赛球队ID
	private Integer leagueTeamIdM;// 联赛球队ID
	private Integer leagueTeamIdG;// 联赛球队ID
	private Integer leagueMatchId;// 联赛ID
	private String leagueTeamName;// 联赛球队名称
	private String leagueTeamLogo;// 联赛球队logo
	private String leagueTeamDesc;// 联赛球队描述
	private String leagueOrganization;// 联赛球队组织单位
	private String leagueHead;// 联赛球队负责人
	private String telephone;// 电话
	private String leagueOffice;// 办公地点
	private Integer state;// 状态
	private Integer sort;// 排序
	private Integer seasonId;//赛季ID
	private String pageNo;// 当前页数
	private Integer pageSize;// 每页条数
	private Integer start;// 开始的数
	private Integer startNo;// 开始的数
	private Integer endNo;// 结束的数
	
	private String league_team_id;//创建球队返回主键

	
	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public String getLeague_team_id() {
		return league_team_id;
	}

	public void setLeague_team_id(String league_team_id) {
		this.league_team_id = league_team_id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	public Integer getLeagueTeamId() {
		return leagueTeamId;
	}

	public void setLeagueTeamId(Integer leagueTeamId) {
		this.leagueTeamId = leagueTeamId;
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

	public Integer getLeagueMatchId() {
		return leagueMatchId;
	}

	public void setLeagueMatchId(Integer leagueMatchId) {
		this.leagueMatchId = leagueMatchId;
	}

	public String getLeagueTeamName() {
		return leagueTeamName;
	}

	public void setLeagueTeamName(String leagueTeamName) {
		this.leagueTeamName = leagueTeamName;
	}

	public String getLeagueTeamLogo() {
		return leagueTeamLogo;
	}

	public void setLeagueTeamLogo(String leagueTeamLogo) {
		this.leagueTeamLogo = leagueTeamLogo;
	}

	public String getLeagueTeamDesc() {
		return leagueTeamDesc;
	}

	public void setLeagueTeamDesc(String leagueTeamDesc) {
		this.leagueTeamDesc = leagueTeamDesc;
	}

	public String getLeagueOrganization() {
		return leagueOrganization;
	}

	public void setLeagueOrganization(String leagueOrganization) {
		this.leagueOrganization = leagueOrganization;
	}

	public String getLeagueHead() {
		return leagueHead;
	}

	public void setLeagueHead(String leagueHead) {
		this.leagueHead = leagueHead;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLeagueOffice() {
		return leagueOffice;
	}

	public void setLeagueOffice(String leagueOffice) {
		this.leagueOffice = leagueOffice;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}

	public Integer getLeagueMatchGroupId() {
		return leagueMatchGroupId;
	}

	public void setLeagueMatchGroupId(Integer leagueMatchGroupId) {
		this.leagueMatchGroupId = leagueMatchGroupId;
	}

	public Integer getLeagueCupId() {
		return leagueCupId;
	}

	public void setLeagueCupId(Integer leagueCupId) {
		this.leagueCupId = leagueCupId;
	}

	
	
}
