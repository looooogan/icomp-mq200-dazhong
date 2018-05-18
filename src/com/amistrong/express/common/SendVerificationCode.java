package com.amistrong.express.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SendVerificationCode {
	
	/**
	 * 发送验证码
	 * @param code 
	 * @param reqCode 
	 * @param Uid用户名	,KeyMD5短信秘钥	,smsMob送达手机号	,smsText送达内容,code验证码 reqCode:0：注册 1：修改密码
	 * @return INT
	 */
	public static int VerificationCode(String smsMob,String smsText, int code, Integer reqCode) {
			TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23362282", "ce63344918ab05faf8d038a8ca38b7e7");
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			req.setExtend( "extend" );
			req.setSmsType( "normal" );
			
			//req.setSmsParamString( "{code:'"+ code+"',product:'来战'}" );
			req.setRecNum( smsMob);
			if(reqCode == 0){
				req.setSmsParamString( "{code:'"+ code+"',product:'来战'}" );
				req.setSmsFreeSignName( "注册验证" );
				req.setSmsTemplateCode( "SMS_8740023" );
			}else if(reqCode == 1){
				req.setSmsParamString( "{code:'"+ code+"',product:'来战'}" );
				req.setSmsFreeSignName( "变更验证" );
				req.setSmsTemplateCode( "SMS_8740021" );
			}else{
				req.setSmsParamString( "{code:'"+ code+"',product:'来战',item:'投票'}" );
				req.setSmsFreeSignName( "活动验证" );
				req.setSmsTemplateCode( "SMS_8740022" );
			}
//			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
//			System.out.println(rsp.getBody());
			
			try {
			    AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			    System.out.println(rsp.getBody());
			    return 1;
			} catch (Exception e) {
			    return -1;
			}

	}

}
