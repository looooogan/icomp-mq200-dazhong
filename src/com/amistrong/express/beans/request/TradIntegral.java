package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 请求，更新积分、交易Bean
 * @author 于鑫
 * @version 2015-5-25 14:34:15
 */
public class TradIntegral implements Serializable{

	private static final long serialVersionUID = 1732025317085388613L;
	
	private Integer userId;				//用户ID
	private double money;					//发生金额
	private Integer code;					//消费分类code
	private int expense_receipt;			//收、支(0:收入 1:支出)
	private Integer integralId;			//积分ID
	
	public Integer getIntegralId() {
		return integralId;
	}
	public void setIntegralId(Integer integralId) {
		this.integralId = integralId;
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
	public int getExpense_receipt() {
		return expense_receipt;
	}
	public void setExpense_receipt(int expense_receipt) {
		this.expense_receipt = expense_receipt;
	}
	public TradIntegral() {
		super();
	}
	public TradIntegral(Integer userId, double money, Integer code,
			int expense_receipt, Integer integralId) {
		super();
		this.userId = userId;
		this.money = money;
		this.code = code;
		this.expense_receipt = expense_receipt;
		this.integralId = integralId;
	}
	
}