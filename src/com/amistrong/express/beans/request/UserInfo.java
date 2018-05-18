package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，用户Bean的子类 多用户id
 * 
 * @author 于鑫
 * @version 2015-5-18 09:17:46
 */
public class UserInfo extends User implements Serializable {

	private static final long serialVersionUID = -5441693344168119653L;

	private int userId; // 用户ID
	private String userType; // 用户类型
	private String nickName;// 昵称
	private String headImgUrl; // 头像url
	private String birthDay; // 生日
	private String sex;// 性别
	private String locatTion;// 地区
	private String sigh;// 个性签名
	private String realName;// 姓名

	private String height;

	private String weight;

	private String memberType;// 位置

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLocatTion() {
		return locatTion;
	}

	public void setLocatTion(String locatTion) {
		this.locatTion = locatTion;
	}

	public String getSigh() {
		return sigh;
	}

	public void setSigh(String sigh) {
		this.sigh = sigh;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}
