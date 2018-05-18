package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 合成刀位置Bean
 * 
 * @author 王冉
 * @version 2017-6-29 16：55
 */
public class Synthesiscutterlocation implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具参数ID */
	private String synthesisParametersID;

	/**
	 * 合成刀具参数ID取得
	 * 
	 * @return synthesisParametersID
	 */
	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}

	/**
	 * 合成刀具参数ID设定
	 * 
	 * @param synthesisParametersID
	 */
	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}

	/* 位置类型(0刀具1辅具2配套9其他) */
	private String cutterType;

	/**
	 * 位置类型(0刀具1辅具2配套9其他)取得
	 * 
	 * @return cutterType
	 */
	public String getCutterType() {
		return cutterType;
	}

	/**
	 * 位置类型(0刀具1辅具2配套9其他)设定
	 * 
	 * @param cutterType
	 */
	public void setCutterType(String cutterType) {
		this.cutterType = cutterType;
	}

	/* 位置号 */
	private String synthesisCutterNumber;

	/**
	 * 位置号取得
	 * 
	 * @return synthesisCutterNumber
	 */
	public String getSynthesisCutterNumber() {
		return synthesisCutterNumber;
	}

	/**
	 * 位置号设定
	 * 
	 * @param synthesisCutterNumber
	 */
	public void setSynthesisCutterNumber(String synthesisCutterNumber) {
		this.synthesisCutterNumber = synthesisCutterNumber;
	}

	/* 刀具编码(应该装入合成刀的编码) */
	private String toolCode;

	/**
	 * 刀具编码(应该装入合成刀的编码)取得
	 * 
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码(应该装入合成刀的编码)设定
	 * 
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 替换刀具编码（刀具编码以逗号分隔） */
	private String tempToolCode;

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）取得
	 * 
	 * @return tempToolCode
	 */
	public String getTempToolCode() {
		return tempToolCode;
	}

	/**
	 * 替换刀具编码（刀具编码以逗号分隔）设定
	 * 
	 * @param tempToolCode
	 */
	public void setTempToolCode(String tempToolCode) {
		this.tempToolCode = tempToolCode;
	}

	private Integer toolCount;

	public Integer getToolCount() {
		return toolCount;
	}

	public void setToolCount(Integer toolCount) {
		this.toolCount = toolCount;
	}

	private String toolConsumetype;

	public String getToolConsumetype() {
		return toolConsumetype;
	}

	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}

	// 刀具分类(0刀具1辅具2配套9其他）
	private String toolType;

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

}
