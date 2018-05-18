package com.amistrong.express.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.amistrong.express.beans.request.Login;
import com.amistrong.express.beans.request.UserInfo;
import com.amistrong.express.common.Constants;
import com.amistrong.express.common.DesUtil;
import com.amistrong.express.common.JsonResult;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.common.SystemSet;
import com.amistrong.express.dao.LoginDao;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 验证过滤器 当前请求是否合法
 * 
 * @author Administrator
 */
public class UrlValidateFilter extends OncePerRequestFilter {

	private static ObjectMapper mapper = new ObjectMapper();
	public static HashMap<String, String> userInfo = new HashMap<String, String>();

	/**
	 * jsonResult
	 * 
	 * 1:boolean 是否成功 2:消息代码 3:返回数据
	 */

	private final String jsonResult(boolean success, String message, Object data) {
		return jsonToString(new JsonResult(success, message, data));
	}

	// 转换json
	private String jsonToString(Object json) {
		try {
			String result = mapper.writeValueAsString(json);
			result = result.replaceAll("null", "\"\"");
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 将JSON写入response
	 * 
	 * @param response
	 * @param jsonString
	 *            写入客户端的JSON字符串
	 */
	private void writeJson(HttpServletResponse response, String jsonString) {
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			out = response.getWriter();
			out.write(jsonString);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter)
			throws ServletException, IOException {
		String strPhone;
		String strPassword;
		String strServletPath;
		String validateCode = request.getParameter("validateCode");
		
		try {
			// 请求URL不存在，返回错误信息
			strServletPath = request.getServletPath().replace("/", "");
			if(strServletPath.endsWith("js") || strServletPath.endsWith("css"))
			{
				filter.doFilter(request, response);
				return;
			}
			if (!SystemSet.urlValidateSet.containsKey(strServletPath)) {
				writeJson(response, jsonResult(false, MessageList.SYS_NO_USE, null));
				return;
			}

			// 请求url不需要验证
			if ("0".equals(SystemSet.urlValidateSet.get((strServletPath)))) {
				filter.doFilter(request, response);
				return;
			}
			// 验证码空，返回错误消息
			if (validateCode == null || "".equals(validateCode)) {
				writeJson(response, jsonResult(false, MessageList.SYS_NO_USE, null));
				return;
			}
			// 解密
			validateCode = DesUtil.decrypt(validateCode, Constants.DES_KEY);
			// 格式不对报错
			if (validateCode.indexOf("&") == -1) {
				writeJson(response, jsonResult(false, MessageList.SYS_NO_USE, null));
				return;
			}
			String[] arr = validateCode.split("&");
			strPhone = arr[0];
			strPassword = arr[1];
			// 是否在缓存里
			if (userInfo.containsKey(strPhone)) {
				//密码一致，继续
				if(userInfo.get(strPhone).toString().equals(strPassword))
				{
					filter.doFilter(request, response);
					return;
				}
				//密码不一致，报错
				else
				{
					writeJson(response, jsonResult(false, MessageList.SYS_NO_USE, null));
					return;
				}
			} else {
				Login login = new Login();
				login.setPhoneNo(strPhone);

		    	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());  
		    	LoginDao lDao = (LoginDao)wac.getBean("loginDao");  
				UserInfo user = lDao.queryUser(login);
				//电话号码不存在
				if(user == null)
				{
					writeJson(response, jsonResult(false, MessageList.SYS_NO_USE, null));
					return;
				}
				else if(user.getPassword().equals(strPassword))
				{
					userInfo.put(strPhone, user.getPassword());
					filter.doFilter(request, response);
					return;
				}
				else
				{
					writeJson(response, jsonResult(false, MessageList.SYS_NO_USE, null));
					return;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			writeJson(response, jsonResult(false, MessageList.SYS_NO_USE, null));
		}
	}
}
