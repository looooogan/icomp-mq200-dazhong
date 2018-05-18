package com.amistrong.express.beans;

/**
 * 微信统一接口，请求参数
 * @author PB
 *
 */
public class WeixinPayBean {
	
	//公众账号ID/String(32)/微信分配的公众账号ID
	private String appid;
	//商户号/String(32)/微信支付分配的商户号
	private String mch_id;
	//随机字符串/String(32)/随机字符串，不长于32位。推荐随机数生成算法
	private String nonce_str;
	//签名/String(32)/签名，详见签名生成算法
	private String sign;
	//商品描述/String(32)/商品或支付单简要描述(Ipad mini  16G  白色)
	private String body;
	//商户订单号/String(32)/商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
	//商户支付的订单号由商户自定义生成，微信支付要求商户订单号保持唯一性（建议根据当前系统时间加随机序列来生成订单号）。重新发起一笔支付要使用原订单号，避免重复支付；已支付过或已调用关单、撤销（请见后文的API列表）的订单号不能重新发起支付。
	private String out_trade_no;
	//总金额/Int/订单总金额，只能为整数，详见支付金额
	//交易金额默认为人民币交易，接口中参数支付金额单位为【分】，参数值不能带小数。对账单中的交易金额单位为【元】。
	//外币交易的支付金额精确到币种的最小单位，参数值不能带小数点。
	private Integer total_fee;
	//终端IP/String(16)/APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	private String spbill_create_ip;
	//通知地址/String(256)/接收微信支付异步通知回调地址
	private String notify_url;
	//交易类型/String(16)/JSAPI/取值如下：JSAPI，NATIVE，APP，WAP,详细说明见参数规定
	private String trade_type;

	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	
}
