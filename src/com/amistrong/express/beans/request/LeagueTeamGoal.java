package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 射手榜查询Bean
 * 
 * @author 王冉
 * @version 2016-9-12
 */
public class LeagueTeamGoal implements Serializable {

	private static final long serialVersionUID = -5441693344168119653L;

	private String leagueMatchId;// 联赛ID
	private String cupId;//杯赛ID
	private String leagueMatchGroupId;//小组ID
	private String pageNo;// 当前页数
	private int pageSize1;// 每页条数
	private Integer startNo;// 开始的数
	private Integer endNo;// 结束的数

	public String getLeagueMatchId() {
		return leagueMatchId;
	}

	public void setLeagueMatchId(String leagueMatchId) {
		this.leagueMatchId = leagueMatchId;
	}
	
	public String getCupId() {
		return cupId;
	}

	public void setCupId(String cupId) {
		this.cupId = cupId;
	}

	public String getLeagueMatchGroupId() {
		return leagueMatchGroupId;
	}

	public void setLeagueMatchGroupId(String leagueMatchGroupId) {
		this.leagueMatchGroupId = leagueMatchGroupId;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize1() {
		return pageSize1;
	}

	public void setPageSize1(int pageSize1) {
		this.pageSize1 = pageSize1;
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

}
