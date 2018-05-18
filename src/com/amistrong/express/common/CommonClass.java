package com.amistrong.express.common;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.amistrong.express.beans.TokenBean;

import sun.misc.BASE64Decoder;

public final class CommonClass {
	

	public static int currentMinute;
	public static int orderID = 0;
	
	public static synchronized String createOrderNo() {
		// 表单流水号开头
		String orderNo = new SimpleDateFormat("yyyyMMdd").format(new Date(
				System.currentTimeMillis()));

		int dayTime = 24 * 60 * 60;
		int _8hour = 8 * 60 * 60;

		int current = (int) ((System.currentTimeMillis() / 1000L + _8hour) % dayTime);
		if (current != currentMinute) {
			currentMinute = current;
			orderID = 1;
		} else {
			orderID++;
		}

		orderNo += strPadLeft(String.valueOf(currentMinute), 5, "0");
		orderNo += strPadLeft(String.valueOf(orderID), 3, "0");

		return orderNo;
	}

	
	public final static void main(String [] arga) throws Exception
	{
		List<TokenBean> tokens = new ArrayList<TokenBean>();
		TokenBean t = new TokenBean();
		/*t.setDeviceType("1");
		t.setPhoneNo("15842472621");
		t.setToken("b5f007376c05a63c418a98f60ffd6e355025121b");
		tokens.add(t);*/
		t = new TokenBean();
		t.setDeviceType("2");
		t.setPhoneNo("13050595602");
		t.setToken("9d608a0a134b41e1eb7a3c5974a4810f36d946823185fd24326174d83b234777");
		tokens.add(t);
		pushMessage1(tokens,"测试",SysConfig.Value(SysConfig.ACTIVITY_NEWSORDERS),"1");
	}

	/**
	 * 特殊 发送消息
	 */
	public static void pushMessage1(List<TokenBean> tokens, String title, String activity, String page) {
		// 1.遍历 userIds 获取 TokenBean
		for (TokenBean token : tokens) {
			// 2.推送消息给用户
			if (token.getDeviceType().equals("1")) { // Android 设备
				XGPush_END.expressPushTokenAndroid(Long.parseLong("2100137752"), "23ee40a27e949be363cb14bda3b0da54", token.getToken(),
						title, "", activity);
			} else if (token.getDeviceType().equals("2")) { // IOS设备
				XGPush_END.expressPushSingleDeviceIOS(Long.parseLong("2200126931"), "c3c48e427b8d2eb0e545776afb3706f1", token.getToken(), title,
						page);
			}
		}
	}
	
	/**
	 * 特殊 发送消息
	 */
	public static void pushMessage(List<TokenBean> tokens, String title, String activity, String page) {
		// 1.遍历 userIds 获取 TokenBean
		for (TokenBean token : tokens) {
			// 2.推送消息给用户
			if (token.getDeviceType().equals("1")) { // Android 设备
				XGPush_END.expressPushTokenAndroid(Long.parseLong(SysConfig.Value(SysConfig.Android_ACCESS_ID)), SysConfig.Value(SysConfig.Android_SECRET_KEY), token.getToken(),
						title, "", activity);
			} else if (token.getDeviceType().equals("2")) { // IOS设备
				XGPush_END.expressPushSingleDeviceIOS(Long.parseLong(SysConfig.Value(SysConfig.IOS_ACCESS_ID)), SysConfig.Value(SysConfig.IOS_SECRET_KEY), token.getToken(), title,
						page);
			}
		}
	}
	
	public final static boolean strIsEmpty(Object obj)
	{
		if(obj == null)
			return true;
		
		return ((String)obj).isEmpty();
	}
	
	public final static void clearCookie(HttpServletRequest request,HttpServletResponse response) {  
      Cookie[] cookies = request.getCookies();  
      try  
      {  
           for(int i=0;i<cookies.length;i++)    
           {  
            //System.out.println(cookies[i].getName() + ":" + cookies[i].getValue());  
            Cookie cookie = new Cookie(cookies[i].getName(), null);  
            cookie.setMaxAge(0);  
            cookie.setPath("/");
            response.addCookie(cookie);  
           }  
      }catch(Exception ex)  
      {  
           System.out.println("清空Cookies发生异常！");  
      }   
    }  
	
	public static void setCookie(HttpServletResponse response, String name,  
		            String value,int time) {  
		try
		{
			Cookie cookie = new Cookie(name,value);  
			cookie.setSecure(false);  
			cookie.setPath("/");  
			cookie.setMaxAge(time);  
			response.setHeader("Charset","utf-8");
			response.addCookie(cookie);  
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static String encoder(String value)
	{
		if(value.isEmpty())
			return "";
		byte [] temp = value.getBytes();
		String strVal = "";
		for(byte b : temp)
		{
			strVal += b + ":";
		}
		strVal = strVal.substring(0, strVal.length() - 1);
		return strVal;
	}

	public static String decode(String value)
	{
		if(value.isEmpty())
			return "";
		String strVal = "";
		String [] temp = value.split(":");
		byte [] bytes = new byte[temp.length];
		int i = 0;
		for(String s : temp)
		{
			bytes[i++] = Byte.valueOf(s);
		}
		strVal = new String(bytes);
		return strVal;
	}
	
	public static Document getXmlDocument(String strXml) throws Exception 
	{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder=factory.newDocumentBuilder(); 
		
		StringReader read = new StringReader(strXml);
		
		InputSource is = new InputSource(read);
		
		Document doc = builder.parse(is);
		return doc;
	}
	
	public static ByteArrayOutputStream GenerateImage(String imgStr) throws Exception {
		if (strIsEmpty(imgStr)) { // 图像数据为空
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		imgStr = imgStr.substring(imgStr.indexOf(",") + 1);
		
		// Base64解码
		byte[] bytes = decoder.decodeBuffer(imgStr);
		/*for (int i = 0; i < bytes.length; ++i) {
			if (bytes[i] < 0) {// 调整异常数据
				bytes[i] += 256;
			}
		}*/
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// 生成图片
		out.write(bytes);
		out.flush();
		
		//out.flush();
		return out;

	}
	public static int i = 1;
	public static ByteArrayOutputStream putZipFile(ByteArrayOutputStream[] arrOut,String fileNames)
			throws Exception {
		
		int i = 0;
		ByteArrayOutputStream fos = new ByteArrayOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ZipOutputStream zos = new ZipOutputStream(bos);// 压缩包
		
		for (ByteArrayOutputStream imgData : arrOut) {
			i++ ;
			if (imgData == null)
				continue;

			//writeTest(imgData,"C:\\temp\\" + i + ".jpg");
			
//			byte[] buf = new byte[1024];
//			int len;

			ZipEntry ze = new ZipEntry(fileNames + "-" + i + ".jpg");// 这是压缩包名里的文件名
			zos.putNextEntry(ze);// 写入新的 ZIP 文件条目并将流定位到条目数据的开始处
			imgData.writeTo(zos);
		}
		
		zos.close();
		bos.close();
		return fos;
	}
	
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 } 

	public static String getFileName()
	{
		Date dt = new Date(System.currentTimeMillis());
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    return  sdf.format(dt);
	}
	
	public static void writeFile(byte [] bytes,String fileName) throws Exception
	{
		if(bytes == null)return;
		File f = new File(fileName);
		FileOutputStream out = new FileOutputStream(f);
		out.write(bytes);
		out.flush();
		out.close();
	}

	public final static String strPadLeft(String str,int len,String addStr)
	{
		String strRtn = str;
		for(int i = str.length(); i < len; i++)
		{
			strRtn = addStr + strRtn;
		}
		return strRtn;
	}
	
}
