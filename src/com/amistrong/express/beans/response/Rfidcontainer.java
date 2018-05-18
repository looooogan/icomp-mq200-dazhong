package com.amistrong.express.beans.response;

import java.io.Serializable;

/**
 *  RFID载体Bean
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class Rfidcontainer implements Serializable{
	
	private static final long serialVersionUID = -6353153389651280124L;
	
	 /* RFID载体ID	*/
    private String rfidContainerID;

    /**
     * RFID载体ID取得
     *
     * @return rfidContainerID
     */
    public String getRfidContainerID() {
        return rfidContainerID;
    }

    /**
     * RFID载体ID设定
     *
     * @param rfidContainerID
     */
    public void setRfidContainerID(String rfidContainerID) {
        this.rfidContainerID = rfidContainerID;
    }

    /* 工具盘ID	*/
    private String toolShelfID;

    /**
     * 工具盘ID取得
     *
     * @return toolShelfID
     */
    public String getToolShelfID() {
        return toolShelfID;
    }

    /**
     * 工具盘ID设定
     *
     * @param toolShelfID
     */
    public void setToolShelfID(String toolShelfID) {
        this.toolShelfID = toolShelfID;
    }

    /* RFID标签ID	*/
    private String rfidCode;

    /**
     * RFID标签ID取得
     *
     * @return rfidCode
     */
    public String getRfidCode() {
        return rfidCode;
    }

    /**
     * RFID标签ID设定
     *
     * @param rfidCode
     */
    public void setRfidCode(String rfidCode) {
        this.rfidCode = rfidCode;
    }

    /* RFID重用次数	*/
    private Double rfidReCount;

    /**
     * RFID重用次数取得
     *
     * @return rfidReCount
     */
    public Double getRfidReCount() {
        return rfidReCount;
    }

    /**
     * RFID重用次数设定
     *
     * @param rfidReCount
     */
    public void setRfidReCount(Double rfidReCount) {
        this.rfidReCount = rfidReCount;
    }

    /* 激光识别码	*/
    private String laserIdentificationCode;

    /**
     * 激光识别码取得
     *
     * @return laserIdentificationCode
     */
    public String getLaserIdentificationCode() {
        return laserIdentificationCode;
    }

    /**
     * 激光识别码设定
     *
     * @param laserIdentificationCode
     */
    public void setLaserIdentificationCode(String laserIdentificationCode) {
        this.laserIdentificationCode = laserIdentificationCode;
    }

    /* 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)	*/
    private String bandType;

    /**
     * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)取得
     *
     * @return bandType
     */
    public String getBandType() {
        return bandType;
    }

    /**
     * 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)设定
     *
     * @param bandType
     */
    public void setBandType(String bandType) {
        this.bandType = bandType;
    }

    /* 查询方式(0库存1流转)	*/
    private String queryType;

    /**
     * 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）取得
     *
     * @return queryType
     */
    public String getQueryType() {
        return queryType;
    }

    /**
     * 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）设定
     *
     * @param queryType
     */
    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    /* 操作人	*/
    private String systemLogUser;

    /**
     * 操作人取得
     *
     * @return systemLogUser
     */
    public String getSystemLogUser() {
        return systemLogUser;
    }

    /**
     * 操作人设定
     *
     * @param systemLogUser
     */
    public void setSystemLogUser(String systemLogUser) {
        this.systemLogUser = systemLogUser;
    }
    
    private String updateUser;

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	private String delFlag;

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	
}