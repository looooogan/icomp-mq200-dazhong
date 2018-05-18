package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.amistrong.express.beans.BaseEntity;

/**
 *  RFID载体条件Bean
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class RfidcontainerWhere extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -6353153389651280124L;
	
	/* RFID载体ID	*/ 
	private String rfidContainerIDWhere;

	/**
	 * RFID载体ID取得
	 * @return rfidContainerIDWhere
	 */
	public String getRfidContainerIDWhere () {
		return rfidContainerIDWhere;
	}

	/**
	 * RFID载体ID设定
	 * @param rfidContainerIDWhere
	 */
	public void setRfidContainerIDWhere (String rfidContainerIDWhere) {
		this.rfidContainerIDWhere = rfidContainerIDWhere;
	}

	/* 工具盘ID	*/ 
	private String toolShelfIDWhere;

	/**
	 * 工具盘ID取得
	 * @return toolShelfIDWhere
	 */
	public String getToolShelfIDWhere () {
		return toolShelfIDWhere;
	}

	/**
	 * 工具盘ID设定
	 * @param toolShelfIDWhere
	 */
	public void setToolShelfIDWhere (String toolShelfIDWhere) {
		this.toolShelfIDWhere = toolShelfIDWhere;
	}

	/* RFID标签ID	*/ 
	private String rfidCodeWhere;

	/**
	 * RFID标签ID取得
	 * @return rfidCodeWhere
	 */
	public String getRfidCodeWhere () {
		return rfidCodeWhere;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCodeWhere
	 */
	public void setRfidCodeWhere (String rfidCodeWhere) {
		this.rfidCodeWhere = rfidCodeWhere;
	}

	/* RFID重用次数	*/ 
	private BigDecimal rfidReCountWhere;

	/**
	 * RFID重用次数取得
	 * @return rfidReCountWhere
	 */
	public BigDecimal getRfidReCountWhere () {
		return rfidReCountWhere;
	}

	/**
	 * RFID重用次数设定
	 * @param rfidReCountWhere
	 */
	public void setRfidReCountWhere (BigDecimal rfidReCountWhere) {
		this.rfidReCountWhere = rfidReCountWhere;
	}

	/* 激光识别码	*/ 
	private String laserIdentificationCodeWhere;

	/**
	 * 激光识别码取得
	 * @return laserIdentificationCodeWhere
	 */
	public String getLaserIdentificationCodeWhere () {
		return laserIdentificationCodeWhere;
	}

	/**
	 * 激光识别码设定
	 * @param laserIdentificationCodeWhere
	 */
	public void setLaserIdentificationCodeWhere (String laserIdentificationCodeWhere) {
		this.laserIdentificationCodeWhere = laserIdentificationCodeWhere;
	}

	/* 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)	*/ 
	private String bandTypeWhere;

	/**
	 * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)取得
	 * @return bandTypeWhere
	 */
	public String getBandTypeWhere () {
		return bandTypeWhere;
	}

	/**
	 * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)设定
	 * @param bandTypeWhere
	 */
	public void setBandTypeWhere (String bandTypeWhere) {
		this.bandTypeWhere = bandTypeWhere;
	}

	/* 查询方式(0库存1流转)	*/ 
	private String queryTypeWhere;

	/**
	 * 查询方式(0库存1流转)取得
	 * @return queryTypeWhere
	 */
	public String getQueryTypeWhere () {
		return queryTypeWhere;
	}

	/**
	 * 查询方式(0库存1流转)设定
	 * @param queryTypeWhere
	 */
	public void setQueryTypeWhere (String queryTypeWhere) {
		this.queryTypeWhere = queryTypeWhere;
	}

	/* 操作人	*/ 
	private String systemLogUserWhere;

	/**
	 * 操作人取得
	 * @return systemLogUserWhere
	 */
	public String getSystemLogUserWhere () {
		return systemLogUserWhere;
	}

	/**
	 * 操作人设定
	 * @param systemLogUserWhere
	 */
	public void setSystemLogUserWhere (String systemLogUserWhere) {
		this.systemLogUserWhere = systemLogUserWhere;
	}

}
