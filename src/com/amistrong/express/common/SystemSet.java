package com.amistrong.express.common;

import java.util.List;
import java.util.Map;

import com.amistrong.express.beans.SystemSettingBean;

/**
 * 系统初始化bean
 * @author 于鑫
 * @version 2015-5-18 13:27:51
 */
public class SystemSet {
	
	//99001.
	//验证码有效时间 ， 单位秒
	public static int CODE_ACTIVE_TIME;
	//10.
	//积分设置 ， 设置客户取得的积分
	public static int INTEGRAL_SET ;
	//10001.
	//注册获得原始积分
	public static int REGISTER_BASE_INTEGRAL;
	//10002.
	//介绍一位客户 ， 获得的积分
	public static int INTRODUCE_A_GUEST;
	//10003.
	//每消费1元
	public static int EACH_CONSUMER;
	//10004.
	//被推荐人每消费1元
	public static double PASSIVE_CONSUM;
	//10006
	//填写推荐人
	public static int INTRODUCE_USER;
	//20.
	//交易类型
	public static int OPERATION_TYPE;
	//20001.
	//充值
	public static double RECHARGE ;
	//20002.
	//消费
	public static double CONSUME ;
	//99003.
	//显示位置范围
	public static double INDICATION_RANGE;
	//99004
	//快递员短信推送
	public static String IS_SEND_MESSAGE;
	//30.
	//金钱设置
	public static double MONRY_SET;
	//30001.
	//快递员送件抽取佣金比例
	public static double COURIER_FEE;
	//30002.
	//快递员提现最低余额
	public static double MIN_ACCOUNT_BALANCE;
	//30003.
	//快递员审核通过送现
	public static double SEND_CASH;
	//40001.
	//签到,起始积分
	public static int START_SIGN ;
	//40002.
	//签到,连签增加积分
	public static int CONTINUOUS_SIGN;
	//99003.
	//连签最高积分
	public static int MAX_SIGN;
	//72001
	//微信红包所含金额
	public static int WEIXIN_RED_PACKET;
	//30004
	//最低佣金
	public static double MIN_BROKERAGE;
	
	public static Map<String, String> urlValidateSet;
	
	//圆通快递规则
	public static String YUANTONG_VALUE = "1268dv";
	//英文
	public static String STRING_VALUE = "QWERTYUIOPLKJHGFDSAZXCVBNM";
	//短信价格
	public static double MESSAGE_JIAGE;
	//返现最低金额
	public static int FANXIAN_MIN;
	//返现最高金额
	public static int FANXIAN_MAX;
	
	//快递公司代码
	public static Map<String, String> courierCompanyMap;
	
	public static List<SystemSettingBean> companyList;
	
	//全部快递公司
	public static Map<String,Object> logisticsCompany; 
	
	//获取codeName
	public static double codeValue(int code){
		switch (code) {
		case 99001://验证码有效时间
			return SystemSet.CODE_ACTIVE_TIME;
		case 10://积分设置
			return SystemSet.INTEGRAL_SET;
		case 10001://注册获得原始积分
			return SystemSet.REGISTER_BASE_INTEGRAL;
		case 10002://介绍一位客户
			return SystemSet.INTRODUCE_A_GUEST;
		case 10003://每消费1元
			return SystemSet.EACH_CONSUMER;
		case 10004://被推荐人每消费1元
			return SystemSet.PASSIVE_CONSUM;
		case 20://交易类型
			return SystemSet.OPERATION_TYPE;
		case 20001://充值
			return SystemSet.RECHARGE;	
		case 20002://消费
			return SystemSet.CONSUME;
		case 99003://显示位置范围
			return SystemSet.INDICATION_RANGE;
		case 30://金钱设置
			return SystemSet.MONRY_SET;
		case 30001://支付平台佣金
			return SystemSet.COURIER_FEE;
		case 30002://最低额度
			return SystemSet.MIN_ACCOUNT_BALANCE;
		case 30003://审核通过送现金
			return SystemSet.SEND_CASH;
		case 40001://签到,起始积分
			return SystemSet.START_SIGN;
		case 40002://签到,连签积分
			return SystemSet.CONTINUOUS_SIGN;
		case 40003://连签最高积分
			return SystemSet.MAX_SIGN;
		case 10006://填写推荐人
			return SystemSet.INTRODUCE_USER;
		default:
			return 0;
		}
	}
}