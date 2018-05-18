package com.amistrong.express.common;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * jsonResult
	 * 
	 * 1:boolean 是否成功 2:消息代码 3:返回数据
	 */

	/* 返回常用JSON数据格式辅助方法 */
	protected final String jsonResult() {
		return jsonToString(new JsonResult(true, "", null));
	}

	protected final String jsonResult(boolean success) {
		return jsonToString(new JsonResult(success, "", null));
	}

	protected final String jsonResult(Object data) {
		return jsonToString(new JsonResult(true, "", data));
	}

	protected final String jsonResult(boolean success, String message) {
		return jsonToString(new JsonResult(success, message, null));
	}

	protected final String jsonResult(boolean success, String message,
			Object data) {
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

	protected void printRequestInfo(String strPath, Object obj) {

	}
	
	/**
	 * 翻页开始条数计算
	 * 
	 * @param currentPage
	 *            当前页数
	 * @param pageSize
	 *           每页条数
	 * @return 开始条数
	 */
	public Integer getStartNo(String pageNo, Integer pageSize) {
		Integer startNo = (Integer.parseInt(pageNo) - 1) * pageSize;
		return startNo;
	}

	/**
	 * 翻页结束条数计算
	 * 
	 * @param currentPage
	 *            当前页数
	 * @param pageSize
	 *            每页条数
	 * @return 结束条数
	 */
	public Integer getEndNo(String pageNo, Integer pageSize) {     
		Integer endNo = pageSize * Integer.parseInt(pageNo);
		return endNo;
	}
	
	public static String getId() {
        return UUID.randomUUID ().toString ().replace ( "-", "" );
    }
	
    public static String getTimes() {
        return new Date ().getTime () + "";
    }

}
