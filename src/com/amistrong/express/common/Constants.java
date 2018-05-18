package com.amistrong.express.common;

public class Constants {

	public static final int COOKIE_INVALID_TIME = 365 * 24 * 60 * 60; // cookie过期时间

	public static final int COOKIE_INVALID_TIME_TEMP = 60 * 60; // cookie过期时间

	public static final String LOGIN_NULL = "1"; // 需要登陆
	public static final String LOGIN_OK = "2"; // 验证通过
	public static final String LOGIN_PSSS_NG = "3"; // 密码过期
	public static final String LOGIN_SYS_ERR = "4"; // 系统异常

	public static final String USER_NAME_KEY = "username"; // 用户名在SESSION和request里的KEY
	public static final String PASSWORD_KEY = "password"; // 密码在SESSION和request里的KEY

	public static final String SESSION_USER_INFO = "SESSION_USER_INFO"; // SESSION用户信息
	public static final String SESSION_DEVICE_ID = "SESSION_DEVICE_ID"; // SESSION用户信息

	public static final String SESSION_DEAL_ID = "SESSION_DEAL_ID"; // 处理方式

	public static final String PAGE_THEME = "e";

	public static final String IMG_UPLOAD_W = "272px";
	public static final String IMG_UPLOAD_H = "480px";

	public static final String IMG_DISPLAY_W = "40px";
	public static final String IMG_DISPLAY_H = "48px";

	public static final String ERROR_KEY = "error";

	public static final String DES_KEY = "C914413FC3DA44969389FC80C34CE51D";

	public static final String LOGISTICS_API_URL="http://www.aikuaidi.cn/rest/"; //获得物流信息的URL 
	
	public static final String LOGISTICS_API_KEY="ca7720bfa8354fc0bdfad3b5bb3f1be1"; //爱物流网站调用API授权KEY
	
	public static final Integer ORDER_LENGTH_NO1= 10;  
	
	public static final Integer ORDER_LENGTH_NO2= 12;  
	
	public static final Integer ORDER_LENGTH_NO3= 13;  
	
	public static final Integer ORDER_LENGTH_NO4= 14;
	
	public static final Integer ORDER_LENGTH_NO5= 18;  
	
	public static final String SHENTONG_REG="88,36,58,26";
	
	public static final String ZHONGTONG_REG="2,6,7";
	
	public static final String YUNDA_REG="10,12,19";
	
	public static final String COM_REG="qwertyuioplkjhgfdsazxcvbnm";
	
	public static final String QINAMING="【来战足彩】";
	
	public static final String BENJI_OR_HELPER_FLAG="1";
	
}
