package com.amistrong.express.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.MessageIOS;
import com.tencent.xinge.Style;
import com.tencent.xinge.TagTokenPair;
import com.tencent.xinge.TimeInterval;
import com.tencent.xinge.XingeApp;

/**
 * 信鸽推送消息
 * 
 * @author 于鑫
 * @version 2015-6-26 14:31:27
 */
public class XGPush_END implements Serializable {

	private static final long serialVersionUID = -58256379333382082L;

	public static void main(String []a)
	{
		expressPushTokenAndroid(2100137752, "23ee40a27e949be363cb14bda3b0da54", 
				"cf6c54ec0d73d22e4c94b5a933e125be0b3cde7b",
				"测试-标题", "测试-内容", "com.amistrong.express.amactivity.xgSkipActivity.SendTrackSendGoodsStaActivity");
	}
	
	// 单个Android设备下发通知消息
	public static JSONObject expressPushTokenAndroid(long IOS_ACCESS_ID,
			String IOS_SECRET_KEY, String token, String title, String content,
			String activity) {
		Message message = new Message(); // 消息定义
		message.setType(Message.TYPE_NOTIFICATION);
		TimeInterval android_acceptTime = new TimeInterval(0, 0, 23, 59); // 推送消息的时间区间
		ClickAction android_action = new ClickAction(); // 通知消息被点击时触发的事件
		android_action.setActionType(ClickAction.TYPE_ACTIVITY); // 打开activity或app本身
		android_action.setActivity(activity);
		Style style = new Style(1, 1, 1, 1, 0, 1, 0, 0); // 设置样式

		/**
		 * Style 依次对应参数
		 * 
		 * [是否响铃，0否，1是] [是否振动，0否，1是] [通知栏是否可清除，0否，1是]
		 * [若大于0，则会覆盖先前弹出的相同id通知；若为0，展示本条通知且不影响其他通知；若为-1，将清除先前弹出的所有通知，仅展示本条通知。]
		 * [是否呼吸灯，0否，1是] [指定通知栏图标是使用应用内图标还是使用自己上传的图标。0是应用内图标，1是上传图标]
		 * [Web端设置是否覆盖编号的通知样式，0否，1是]
		 * **/

		message.addAcceptTime(android_acceptTime);
		message.setStyle(style);
		message.setAction(android_action);
		message.setTitle(title); // 消息标题
		message.setContent(content); // 消息文本

		XingeApp xinge = new XingeApp(IOS_ACCESS_ID, IOS_SECRET_KEY);
		JSONObject ret = xinge.pushSingleDevice(token, message);
		return (ret);
	}

	// 单个IOS设备下发通知消息
	public static JSONObject expressPushSingleDeviceIOS(long IOS_ACCESS_ID,
			String IOS_SECRET_KEY, String token, String content, String page) {
		MessageIOS message = new MessageIOS();
		message.setExpireTime(86400);
		message.setAlert(content);
		message.setBadge(1); // 设置APP消息角标数
//		message.setSound("beep.wav"); // 提示消息声
		message.setSound("newMessage.mp3"); // 提示消息声
		TimeInterval acceptTime = new TimeInterval(0, 0, 23, 59);
		message.addAcceptTime(acceptTime);
		Map<String, Object> custom = new HashMap<String, Object>();
		custom.put("page", page);
		message.setCustom(custom);

		XingeApp xinge = new XingeApp(IOS_ACCESS_ID, IOS_SECRET_KEY);
		JSONObject ret = xinge.pushSingleDevice(token, message,
				XingeApp.IOSENV_PROD); // IOSENV_PROD表示推送生产环境；IOSENV_DEV表示推送开发环境
		return (ret);
	}

	/**
	 * 为token设置标签 ,同时删除其他标签
	 * 
	 * @param (String)tag:标签。长度最多50字节，不可包含空格 ,
	 *        (String)token:设备token。Android是40或64字节
	 * @return String 状态码
	 */
	public static String greatTagToken(String tag, String token) {
		// 信鸽后台交互基类 安卓
		XingeApp android = new XingeApp(Long.parseLong(SysConfig
				.Value(SysConfig.Android_ACCESS_ID)),
				SysConfig.Value(SysConfig.Android_SECRET_KEY));
		// 删除全部标签
		List<TagTokenPair> lisTo = new ArrayList<TagTokenPair>();
		lisTo.add(new TagTokenPair("1", token));
		lisTo.add(new TagTokenPair("2", token));
		lisTo.add(new TagTokenPair("3", token));
		android.BatchDelTag(lisTo);
		// 设置标签
		TagTokenPair pair = new TagTokenPair(tag, token);
		// 标签列表
		List<TagTokenPair> lis = new ArrayList<TagTokenPair>();
		lis.add(pair);
		// 为基类添加列表
		JSONObject retAndroid = android.BatchSetTag(lis);

		return retAndroid.get("ret_code").toString();
	}

	/**
	 * 为token设置标签 ,同时删除其他标签
	 * 
	 * @param (String)tag:标签。长度最多50字节，不可包含空格 ,
	 *        (String)token:设备token。Android是40或64字节
	 * @return String 状态码
	 */
	public static String greatTagTokenIOS(String tag, String token) {
		// 信鸽后台交互基类 IOS
		XingeApp ios = new XingeApp(Long.parseLong(SysConfig
				.Value(SysConfig.IOS_ACCESS_ID)),
				SysConfig.Value(SysConfig.IOS_SECRET_KEY));
		// 删除全部标签
		List<TagTokenPair> lisTo = new ArrayList<TagTokenPair>();
		lisTo.add(new TagTokenPair("1", token));
		lisTo.add(new TagTokenPair("2", token));
		lisTo.add(new TagTokenPair("3", token));
		ios.BatchDelTag(lisTo);
		// 设置标签
		TagTokenPair pair = new TagTokenPair(tag, token);
		// 标签列表
		List<TagTokenPair> lis = new ArrayList<TagTokenPair>();
		lis.add(pair);
		// 为基类添加列表
		JSONObject retIos = ios.BatchSetTag(lis);

		return retIos.get("ret_code").toString();
	}
}
