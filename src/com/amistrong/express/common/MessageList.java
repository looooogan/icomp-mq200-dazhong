package com.amistrong.express.common;
/**
 * 消息类
 * @author 于鑫
 * @version 2015-5-28 13:41:44
 */
public class MessageList {
	
	/** 错误消息 **/
	public static final String ERR_REGISTRATION_FAILURE = "注册失败。";			//注册失败		
	public static final String ERR_USER_EXIST = "用户已存在。";						//用户已存在		
	public static final String ERR_USER_NOT_EXIST = "用户不存在。";					//用户不存在		
	public static final String ERR_INVALID_AUTHENTICATION_CODE = "验证码无效。"; //验证码无效		
	public static final String ERR_VERIFICATION = "验证码无效。";					//验证码错误		
	public static final String ERR_VERIFICATION_CODE_ACQUISITION = "验证码获取失败。";	//验证码获取失败	
	public static final String ERR_VERIFICATION_CODE_TIMEOUT = "验证码超时(无效)。";		//验证码超时(无效)	
	public static final String ERR_USER_NAME_PASSWORD = "用户名或密码错误。";				//用户名或密码错误	
	public static final String ERR_NO_USER_AROUND = "周围无用户使用。";					//周围无用户使用	
	public static final String ERR_UPLOAD_FILE_FAILED = "上传文件失败。";				//上传文件失败		
	public static final String ERR_POINTS_TRANSACTIONS_FAILED = "更新积分与交易失败。";		//更新积分与交易失败	
	public static final String ERR_LINKMAN_INFO_NULL = "常用联系人信息为空。";				//常用联系人信息为空	
	public static final String ERR_DELIVER_GOODS = "发件失败。";					//发件失败		
	public static final String ERR_MESSAGE_SENDING_FAILURE = "消息发送失败。";		//消息发送失败		
	public static final String ERR_COURIER_AUTHENTICATION_STATUS = "快递员认证状态获取失败。";	//快递员认证状态获取失败
	public static final String ERR_COURIER_INFO_FAILED = "快递员信息获取失败。";			//快递员信息获取失败	
	public static final String ERR_COURIER_REGISTER = "快递员注册失败。";				//快递员注册失败	
	public static final String ERR_UPDATE_COURIER_INFO = "更新快递员信息失败。";			//更新快递员信息失败	
	public static final String ERR_JOURNEY_FAILURE = "行程发布失败。";				//行程发布失败
	public static final String ERR_DATA_NOT_EXIST = "数据不存在。";					//数据不存在
	public static final String ERR_DEL = "删除失败。";							//删除失败
	public static final String ERR_AUDITTHROUGH = "快递员已认证。";					//快递员已认证
	public static final String ERR_BALANCE = "余额不足。";						//余额不足
	public static final String ERR_MONEY = "快递员余额不足。";						//快递员余额不足
	public static final String ERR_CODE = "收获码错误。";							//收获码错误
	public static final String ERR_GET_GOODS = "获取订单失败。";					//获取发货详细失败
	public static final String ERR_SET_GOODS = "获取送货详细失败。";					//获取送货详细失败
	public static final String ERR_SET_SIGN = "签到失败，已签过。";						//签到失败，已签过
	public static final String ERR_GRAB_ORDER_CANCLE = "抢单失败，订单已被取消。";					//抢单失败，订单已被取消
	public static final String ERR_GRAB_ORDER = "订单已经被抢。";					//抢单失败，订单已被取消
	public static final String ERR_ENDTIME = "时间原因，订单失效。";						//时间原因，订单失效
	public static final String ERR_LACK_INTEGRAL = "积分不足。";				//积分不足
	public static final String ERR_GOODS_TIMEOUT = "兑换的商品已超时。";				//兑换的商品已超时
	public static final String ERR_SENDRED_PACK = "兑换红包失败。";					//兑换红包失败
	public static final String ERR_NO_SEND = "您没有发过快件。";						//您没有发过快件
	public static final String ERR_USER_PHONE = "推荐人无效。";					//推荐人无效
	public static final String ERR_WITHDRAW_DEPOSIT = "提现失败。";				//提现失败
	public static final String ERR_NOT_SUFFICIENT_FUNDS = "最大提现额度不正确。";			//最大提现额度不正确
	public static final String ERR_A_RMB = "提现金额必须大于1元。";						//提现金额必须大于1元
	public static final String ERR_GRAB_ECHO = "已经抢单成功，请勿重复抢单。。";					//已经抢单成功，请勿重复抢单。
	public static final String ERR_BACK_ORDER = "不可退单。";					//不可退单
	public static final String ERR_FAIL_INFORM = "短信发送失败。";                  //短信发送失败
	public static final String ERR_SMS_VALIDATE = "暂时只对快递员开放此功能。";                  //短信发送失败
	public static final String ERR_CALC_PRICE = "价格计算失败。";                  //短信发送失败
	public static final String ERR_ENVELOPE_OVERDUE = "红包已过期.";                  //红包过期
	public static final String ERR_ENVELOPE_USED = "红包已使用.";                  //红包已使用
	public static final String ERR_GUESS_OUT_OF_DATE = "题目已过期,正在刷新...";					//题目已过期
	public static final String ERR_TODAY_SIGNED = "当日已签到";					//当日已签到
	public static final String ERR_EMPTY_REQUEST = "参数异常";					//参数异常
	
	/** 确认消息 **/
	public static final String INFO_SUCCESS_REGISTRATION = "注册成功。";					//注册成功		
	public static final String INFO_SUCCESS_VERIFICATION_CODE_ACQUISITION = "验证码获取成功。";	//验证码获取成功	
	public static final String INFO_SUCCESS_UPLOAD_FILE_FAILED = "上传文件成功。";			//上传文件成功		
	public static final String INFO_SUCCESS_POINTS_TRANSACTIONS = "更新积分与交易成功。";			//更新积分与交易成功
	public static final String INFO_SUCCESS_USER_INFO = "更新个人信息成功。";			//更新个人信息成功
	public static final String INFO_SUCCESS_DELIVER_GOODS = "发件成功。";					//发件成功		
	public static final String INFO_SUCCESS_MESSAGE_SENDING = "消息发送成功。";				//消息发送成功		
	public static final String INFO_SUCCESS_COURIER_AUTHENTICATION = "快递员认证状态获取成功。";		//快递员认证状态获取成功
	public static final String INFO_SUCCESS_COURIER_INFO = "快递员信息获取成功。";					//快递员信息获取成功	
	public static final String INFO_SUCCESS_COURIER_REGISTER = "快递员注册成功。";				//快递员注册成功	
	public static final String INFO_SUCCESS_UPDATE_COURIER_INFO = "更新快递员信息成功。";			//更新快递员信息成功	
	public static final String INFO_SUCCESS_JOURNEY = "行程发布成功。";						//行程发布成功		
	public static final String INFO_SUCCESS_ADD = "添加成功。";							//添加成功		
	public static final String INFO_SUCCESS_DEL = "删除成功。";							//删除成功	
	public static final String INFO_SUCCESS_GET = "确认收货。";							//确认收货
	public static final String INFO_SUCCESS_OBTAIN = "抢单成功。";						//抢单成功
	public static final String INFO_SUCCESS_CHANGE_PASSWORD = "密码变更成功。";				//密码变更成功
	public static final String INFO_SUCCESS_UPLOAD = "上传个人地理位置成功。";						//上传个人地理位置成功
	public static final String INFO_SUCCESS_FEEDBACK = "反馈成功。";						//反馈成功
	public static final String INFO_SUCCESS_DETERMINE = "指派成功。";						//指派成功
	public static final String INFO_SUCCESS_SIGN = "签到成功。";							//签到成功
	public static final String INFO_SUCCESS_BACK_ORDER = "退单成功。";							//退单成功
	public static final String INFO_BACK_ORDER_FAIL = "您必须在{0}后才能退单.。";
	public static final String INFO_SUCCESS_INFORM = "短信发送成功。";                           //短信发送成功
	public static final String INFO_SUCCESS_INFORMADD = "短信模板以添加。";                           //短信模板以添加
	public static final String INFO_FAIL_INFORMDELETE = "短信模板以删除。";                          //短信模板以删除
	public static final String INFO_FAIL_INFORMEDIT = "短信模板以编辑。";                          //短信模板以编辑
	public static final String INFO_SUCCESS_ENVELOPE = "扫码成功。";					//注册成功		
	
	
	/** 提示消息 **/
	public static final String POPINFO_REGISTRATION = "注册失败,是否重新注册?。";					//注册失败,是否重新注册?
	public static final String POPINFO_VERIFICATION_CODE_ACQUISITION = "验证码获取失败,是否重新获取?。";	//验证码获取失败,是否重新获取?
	public static final String POPINFO_UPLOAD_FILE_FAILED = "上传文件失败,是否重新上传?。";				//上传文件失败,是否重新上传?
	public static final String POPINFO_POStringS_TRANSACTIONS = "更新积分与交易失败,是否重新更新积分与交易?。";			//更新积分与交易失败,是否重新更新积分与交易?
	public static final String POPINFO_DELIVER_GOODS = "发件失败,是否重新发件?。";					//发件失败,是否重新发件?
	public static final String POPINFO_MESSAGE_SENDING = "消息发送失败,是否重新发送消息?。";				//消息发送失败,是否重新发送消息?
	public static final String POPINFO_COURIER_AUTHENTICATION = "快递员认证状态获取失败,是否重新获取?。";			//快递员认证状态获取失败,是否重新获取?
	public static final String POPINFO_COURIER_INFO = "快递员信息获取失败,是否重新获取?。";					//快递员信息获取失败,是否重新获取?
	public static final String POPINFO_COURIER_REGISTER = "快递员注册失败,是否重新注册快递员?。";				//快递员注册失败,是否重新注册快递员?
	public static final String POPINFO_UPDATE_COURIER_INFO = "更新快递员信息失败,是否重新更新?。";			//更新快递员信息失败,是否重新更新?
	public static final String POPINFO_JOURNEY = "行程发布失败,是否重新发布行程?。";						//行程发布失败,是否重新发布行程?
	
	/** 系统异常消息 **/
	public static final String SYS_ERROR = "系统错误。"; 				// 系统错误
	public static final String SYS_OUT_TIME = "登录超时。"; 			// 登录超时
	public static final String SYS_NET_EXCEPTION = "网络异常。"; 		// 网络异常
	public static final String SYS_NO_USE = "无效操作。"; 			// 无效操作

}
