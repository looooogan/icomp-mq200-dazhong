package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 联赛图片查询Bean
 * 
 * @author 王冉
 * @version 2016-9-12
 */
public class LeaguePictureReqBean implements Serializable {

	private static final long serialVersionUID = -5441693344168119653L;

	private Integer leagueMatchId;// 联赛ID
	private Integer leagueMatchGroupId;// 小组ID
	private String lpicDate;// 图片日期

	public Integer getLeagueMatchId() {
		return leagueMatchId;
	}

	public void setLeagueMatchId(Integer leagueMatchId) {
		this.leagueMatchId = leagueMatchId;
	}

	public Integer getLeagueMatchGroupId() {
		return leagueMatchGroupId;
	}

	public void setLeagueMatchGroupId(Integer leagueMatchGroupId) {
		this.leagueMatchGroupId = leagueMatchGroupId;
	}

	public String getLpicDate() {
		return lpicDate;
	}

	public void setLpicDate(String lpicDate) {
		this.lpicDate = lpicDate;
	}
	

}
