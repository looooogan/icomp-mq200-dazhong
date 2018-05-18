package com.amistrong.express.common;
/**
 * 消费与积分 DB_CODE 类
 * @author 于鑫
 * @version 2015-9-1 09:44:26
 */
public class DBCodeList {
	
	public static final int INCOME = 0;			// 收入
	public static final int EXPENDITURE = 1;		// 支出
	
	
	public static final int EXCHANGE_GOODS = 70;					//兑换物品
	public static final int THE_REAL_GOODS = 71;					// 兑换现实物品
	public static final int VIRTUAL_GOOD = 72;					// 兑换虚拟物品

	public static final int REGISTRATION_INTEGRAL = 10001;		//注册积分
	public static final int CLIENT_INTRODUCE = 10002;				//介绍一位客户
	public static final int CUSTOMER_CONSUMPTION = 10003;			//用户消费
	public static final int REFEREE_CONSUMPTION = 10004;			//推荐人消费
	public static final int SIGN_INTEGRAL = 10005;				// 签到积分
	public static final int INTRODUCE_USER = 10006;				// 填写推荐人
	
	public static final int TOP_UP = 20001;						//充值
	public static final int SENT = 20003;							//帮送
	
	public static final int COMMISSION_PAYMENT_PLATFORM = 30001;	//支付平台佣金
	public static final int PASS = 30003;							// 审核通过
	public static final int WITHDRAW_DEPOSIT = 30005;				// 提现

}