package com.amistrong.express.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//互斥应该是即时读
/*
 * 现在构造第三个参数每每用了，可以考虑改成标记是否需要重新启动
 * 
 * 因为默认enum不能继承，所以手机冗余该类
 */
public enum SysConfig implements EnumDescription {
	
	MESSAGE_TEMPLATE("MESSAGE_TEMPLATE","短信模板"),
	ADDRESSEE_MESSAGE_TEMPLATE("ADDRESSEE_MESSAGE_TEMPLATE","短信模板"),
	
	MOBAN_FIRST("MOBAN_FIRST","模板1"),
	MOBAN_SECOND("MOBAN_SECOND","模板2"),
	MOBAN_THIRD("MOBAN_THIRD","模板3"),
	MOBAN_FOURTH("MOBAN_FOURTH","模板4"),
	
	UPLOAD_FILE_PATH("uploadfile.path", "上传目录"),
	Android_ACCESS_ID("Android_ACCESS_ID", "安卓推送消息ACCESS_ID"),
	Android_ACCESS_KEY("Android_ACCESS_KEY", "安卓推送消息ACCESS_ID"),
	Android_SECRET_KEY("Android_SECRET_KEY", "安卓推送消息SECRET_KEY"),
	IOS_ACCESS_ID("IOS_ACCESS_ID", "IOS推送消息ACCESS_ID"),
	IOS_ACCESS_KEY("IOS_ACCESS_KEY", "IOS推送消息ACCESS_KEY"),
	IOS_SECRET_KEY("IOS_SECRET_KEY", "IOS推送消息SECRET_KEY"),
	Uid("Uid", "中国网建_账号"),
	KeyMD5("KeyMD5", "中国网建_秘钥"),
	SMS_TEXT("SMS_TEXT", "中国网建_消息内容"),
	
	ACTIVITY_NEWSORDERS("ACTIVITY_NEWSORDERS", "您的附近有新订单！"),
	ACTIVITY_SENDSKIPACTIVITY("ACTIVITY_SENDSKIPACTIVITY", "抢单成功！请注意及时派送。"),
	ACTIVITY_GETPARCELSKIPACTIVITY("ACTIVITY_GETPARCELSKIPACTIVITY", "您有新快件！请注意及时查收。"),
	ACTIVITY_SENDTRACKSKIPACTIVITY("ACTIVITY_SENDTRACKSKIPACTIVITY", "您的发件包裹已被签收。"),
	ACTIVITY_SENDFINISHSKIPACTIVITY("ACTIVITY_SENDFINISHSKIPACTIVITY", "您的发件包裹已被签收。"),
	ACTIVITY_LOGINACTIVITY("ACTIVITY_LOGINACTIVITY", "快递员审核通过"),
	ACTIVITY_SENDTRACKSENDGOODSSTAACTIVITY("ACTIVITY_SENDTRACKSENDGOODSSTAACTIVITY", "已经有快递员收到了您的订单，请到：快件->指派快递员画面查看或指定快递员。。"),
	ACTIVITY_ADDRESSEEBACKORDER("ACTIVITY_ADDRESSEEBACKORDER", "由于您未及时取件发件人已退单"),
	ACTIVITY_ADDRESSEEBACKMONEY("ACTIVITY_ADDRESSEEBACKMONEY", "发件返现"),

	WEIXIN_APPID("weixin.appid", "微信appid"),
	WEIXIN_MCH_ID("weixin.mch_id", "微信商家ID"),
	WEIXIN_API_KEY("weixin.api_key", "微信API密钥"),
	WEIXIN_NOTIFY_URL("weixin.notify_url", "微信通知URL"),
	WEIXIN_BODY("weixin.body", "随身帮手充值"),
	WEIXIN_MCH_NAME("send.name", "微信商户名称"),
	APICLIENT_CERT("apiclient.cert", "D:/zhengshu/apiclient_cert.p12"),
	WEIXINWITHDRAWDEPOSIT_DESC("weixinwithdrawdeposit.desc", "提现到微信时企业付款描述信息"),
	ANDROID_VERSION("ANDROID_VERSION", "版本信息"),
	ANDROID_UPURL("ANDROID_UPURL", "下载地址");

	// 路径配置
	public static String CONFIG_PATH = "/config.properties";
	private static String comment;
	private final static Properties _properties = new Properties();
	private final static Log logger = LogFactory.getLog(SysConfig.class);

	public static void Load() throws Exception {
		InputStream in = null;
		try {
			in = new FileInputStream(CONFIG_PATH);
			_properties.load(in);
			comment = "";
			for (SysConfig sysConfig : SysConfig.values()) {
				comment += "#" + sysConfig.getKey() + ":"
						+ sysConfig.getDescription() + "\n";
			}
		} catch (Exception e) {
			logger.error("load config failed", e);
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
	}

	public static boolean Save() {
		if (_properties.size() == 0) {
			// 表示没有LOAD成功，或者无需SAVE
			return true;
		}
		OutputStream out = null;
		try {
			out = new FileOutputStream(CONFIG_PATH);
			comment = "";// jdk内置不能保存中文
			_properties.store(out, comment);
			return true;
		} catch (Exception e) {
			logger.error("Save config failed", e);
			return false;
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
	}

	public static String Value(SysConfig sysConfig) {
		return _properties.getProperty(sysConfig.getKey(),
				sysConfig.getDefalut());
	}

	public static void Value(SysConfig sysConfig, String value) {
		_properties.setProperty(sysConfig.getKey(), value);
		;
	}

	private String key;
	private String description;
	private String defalut;

	SysConfig(String key, String defalut) {
		this(key, null, defalut);
	}

	SysConfig(String key, String description, String defalut) {
		this.key = key;
		this.description = description;
		this.defalut = defalut;
	}

	public String getDescription() {
		return description;
	}

	public String getKey() {
		return key;
	}

	public String getDefalut() {
		return defalut;
	}
}
