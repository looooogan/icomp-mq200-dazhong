package com.amistrong.express.common;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
/**
 * 发送验证码
 * @author 于鑫
 * @version 2015-4-9 20:59:09
 */
public class ToVerificationCode {
	/**
	 * 发送验证码
	 * @param Uid用户名	,KeyMD5短信秘钥	,smsMob送达手机号	,smsText送达内容
	 * @return INT
	 */
	public static int toVerificationCode(String Uid, String KeyMD5 ,String smsMob,String smsText) {
		int mss=-100;
		try {
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
			post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");
			NameValuePair[] data = {
					new NameValuePair("Uid", Uid),
					new NameValuePair("KeyMD5",KeyMD5),
					new NameValuePair("smsMob", smsMob),
					new NameValuePair("smsText", smsText) };
			post.setRequestBody(data);
			client.executeMethod(post);
			String result = new String(post.getResponseBodyAsString().getBytes(
					"utf8"));
			mss = Integer.parseInt(result);
			return mss;
		} catch (Exception e) {
			return mss;
		}

	}

}
