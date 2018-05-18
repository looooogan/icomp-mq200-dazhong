package com.amistrong.express.beans.request;

/**
 * 联赛信息
 * 
 * @author wang_jc
 * @version 2016-06-22
 * 
 */
public class LeagueMatchInfo {
	private Integer leagueMatchId;// 联赛iD
	private String leagueMatchName;// 联赛名称
	private String leagueMatchLogo;// 联赛logo
	private String leagueMatchSDesc;// 联赛短描述
	private String leagueMatchDesc;// 联赛描述
	private String leagueOrganization;// 联赛组织单位
	private String leagueHead;// 联赛负责人
	private String telephone;// 电话
	private String leagueOffice;// 办公地点
	private Integer state;// 状态
	private Integer sort;// 排序

	public Integer getLeagueMatchId() {
		return leagueMatchId;
	}

	public void setLeagueMatchId(Integer leagueMatchId) {
		this.leagueMatchId = leagueMatchId;
	}

	public String getLeagueMatchName() {
		return leagueMatchName;
	}

	public void setLeagueMatchName(String leagueMatchName) {
		this.leagueMatchName = leagueMatchName;
	}

	public String getLeagueMatchLogo() {
		return leagueMatchLogo;
	}

	public void setLeagueMatchLogo(String leagueMatchLogo) {
		this.leagueMatchLogo = leagueMatchLogo;
	}

	public String getLeagueMatchSDesc() {
		return leagueMatchSDesc;
	}

	public void setLeagueMatchSDesc(String leagueMatchSDesc) {
		this.leagueMatchSDesc = leagueMatchSDesc;
	}

	public String getLeagueMatchDesc() {
		return leagueMatchDesc;
	}

	public void setLeagueMatchDesc(String leagueMatchDesc) {
		this.leagueMatchDesc = leagueMatchDesc;
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

}
