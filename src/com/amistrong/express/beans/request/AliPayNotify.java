package com.amistrong.express.beans.request;

import java.io.Serializable;
 
public class AliPayNotify implements Serializable {

	private static final long serialVersionUID = -3647538042993367919L;
	private String out_trade_no;	//userId
	private String subject;		//商品名
	private String body;			//商品详细
	private double total_fee;		//金额

	private String trade_status;//WAIT_BUYER_PAY 	//TRADE_SUCCESS
	
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public double getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}
}
