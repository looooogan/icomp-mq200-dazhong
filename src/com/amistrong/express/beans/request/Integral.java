package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，更新积分Bean
 * @author 于鑫
 * @version 2015-6-2 10:10:47
 */
public class Integral implements Serializable{

	private static final long serialVersionUID = 1732025317085388613L;
	
	private Integer userId;				//用户ID
	private double money;					//发生金额
	private Integer code;					//消费分类code
	private Integer privaterefereeCode;	//推荐人分类code
	private Integer integralType;			//积分增长类型(0:固定积分 1:乘积积分)
	
	public Integral() {
		super();
	}
	public Integral(Integer userId, double money, Integer code,
			Integer privaterefereeCode, Integer integralType) {
		super();
		this.userId = userId;
		this.money = money;
		this.code = code;
		this.privaterefereeCode = privaterefereeCode;
		this.integralType = integralType;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getPrivaterefereeCode() {
		return privaterefereeCode;
	}
	public void setPrivaterefereeCode(Integer privaterefereeCode) {
		this.privaterefereeCode = privaterefereeCode;
	}
	public Integer getIntegralType() {
		return integralType;
	}
	public void setIntegralType(Integer integralType) {
		this.integralType = integralType;
	}
}