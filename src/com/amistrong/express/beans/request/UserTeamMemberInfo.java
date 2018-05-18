package com.amistrong.express.beans.request;

public class UserTeamMemberInfo {

	private Integer updUserId;// 登录用户的会员ID
	private String phoneNo;// 电话号码 (注册添加球队成员用)
	private Integer no;// 编号
	private Integer upno;// 登录用户编号
	private Integer leagueMatchId;// 联赛ID
	private Integer leagueTeamId;// 联赛球队ID
	private Integer userId;// 球员的会员ID
	private String teamDuty;// 球员职责
								// 0:教练,1:领队,2:队长,3:副队长,4:普通队员,5:替补,6:啦啦队队长,7:啦啦队副队长,8:啦啦队队员
	private String memberType;// 球员类型0:管理,1:门将,2:后卫,3:中场,4:前锋,5:啦啦队
	private Integer number; // 球员号码
	private Integer state;// 状态 1：申请 2：通过 3：拒绝 0：删除
	private String reasonToRefuse;// 拒绝原因
	private String isChangeLeader;// 是否更改队长

	public String getIsChangeLeader() {
		return isChangeLeader;
	}

	public void setIsChangeLeader(String isChangeLeader) {
		this.isChangeLeader = isChangeLeader;
	}

	public Integer getUpno() {
		return upno;
	}

	public void setUpno(Integer upno) {
		this.upno = upno;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getLeagueMatchId() {
		return leagueMatchId;
	}

	public void setLeagueMatchId(Integer leagueMatchId) {
		this.leagueMatchId = leagueMatchId;
	}

	public Integer getLeagueTeamId() {
		return leagueTeamId;
	}

	public void setLeagueTeamId(Integer leagueTeamId) {
		this.leagueTeamId = leagueTeamId;
	}

	public String getReasonToRefuse() {
		return reasonToRefuse;
	}

	public void setReasonToRefuse(String reasonToRefuse) {
		this.reasonToRefuse = reasonToRefuse;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getUpdUserId() {
		return updUserId;
	}

	public void setUpdUserId(Integer updUserId) {
		this.updUserId = updUserId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTeamDuty() {
		return teamDuty;
	}

	public void setTeamDuty(String teamDuty) {
		this.teamDuty = teamDuty;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
