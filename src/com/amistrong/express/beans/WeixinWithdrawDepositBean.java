package com.amistrong.express.beans;

/**
 * 微信提现
 */
public class WeixinWithdrawDepositBean {
	
	//公众账号ID/String(32)/微信分配的公众账号ID
	private String mch_appid;
	//商户号/String(32)/微信支付分配的商户号
	private String mchid;
	//设备号/String(32)/微信支付分配的终端设备号
	private String device_info;
	//随机字符串/String(32)/随机字符串，不长于32位。推荐随机数生成算法
	private String nonce_str;
	//签名/String(32)/签名，详见签名生成算法
	private String sign;
	//商户订单号/String/商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
	//商户支付的订单号由商户自定义生成，微信支付要求商户订单号保持唯一性（建议根据当前系统时间加随机序列来生成订单号）。重新发起一笔支付要使用原订单号，避免重复支付；已支付过或已调用关单、撤销（请见后文的API列表）的订单号不能重新发起支付。
	private String partner_trade_no;
	//用户openid/String/商户appid下，某用户的openid
	private String openid;
	//校验用户姓名选项/String
	//NO_CHECK：不校验真实姓名
	//FORCE_CHECK：强校验真实姓名（未实名认证的用户会校验失败，无法转账）
	//OPTION_CHECK：针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
	private String check_name;
	//收款用户姓名/String/收款用户真实姓名。如果check_name设置为FORCE_CHECK或OPTION_CHECK，则必填用户真实姓名
	private String re_user_name;
	//金额/int/企业付款金额，单位为分
	private Integer amount;
	//企业付款描述信息/String/企业付款操作说明信息。必填。
	private String desc;
	//IP地址/String(32)/调用接口的机器Ip地址
	private String spbill_create_ip;
	
	
	public String getMch_appid() {
		return mch_appid;
	}
	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}
	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	public String getRe_user_name() {
		return re_user_name;
	}
	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

}