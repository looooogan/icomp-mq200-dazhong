package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 红黄牌榜请求Bean
 * 
 * @author 王冉
 * @version 2017-4-19 16:25
 */
public class PenaltyCardRank implements Serializable {

	private static final long serialVersionUID = -5746896743339947122L;

	private Integer leagueMatchId;// 联赛ID
	private Integer cupId;// 杯赛ID
	private Integer leagueMatchGroupId;// 小组ID(联赛下没有小组时 小组id传空)
	private Integer type;// 1：黄牌 2：红牌
	private String pageNo;// 当前页数
	private int pageSize1;// 每页条数
	private Integer startNo;// 开始的数
	private Integer endNo;// 结束的数

	public Integer getLeagueMatchId() {
		return leagueMatchId;
	}

	public void setLeagueMatchId(Integer leagueMatchId) {
		this.leagueMatchId = leagueMatchId;
	}
	
	public Integer getCupId() {
		return cupId;
	}

	public void setCupId(Integer cupId) {
		this.cupId = cupId;
	}

	public Integer getLeagueMatchGroupId() {
		return leagueMatchGroupId;
	}

	public void setLeagueMatchGroupId(Integer leagueMatchGroupId) {
		this.leagueMatchGroupId = leagueMatchGroupId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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