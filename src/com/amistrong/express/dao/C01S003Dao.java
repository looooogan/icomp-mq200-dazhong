package com.amistrong.express.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amistrong.express.beans.response.Containercarrier;
import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.Redemptionapplied;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.SapUploadhistory;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toollibraryhistory;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.Toolwholelifecycle;

/**
 * 换领出库Dao
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S003Dao {

	// 根据RFID查询库存信息
	List<Knifeinventory> getKnifeinventoryByRfid(@Param("rfid") String rfid);

	// 取得要换领出库的刀具信息
	Tool getRedemptionapplyInfo(@Param("tool") Tool tool);

	// 查询刀具申请数量
	Integer getRequestNumByToolCode(@Param("toolCode") String toolCode);

	// 取得换领申请的信息
	List<Redemptionapplied> getRedemptionappliedList(
			@Param("toolCode") String toolCode);

	// 更新换领申请表
	void updateRedemptionapplied(@Param("ra") Redemptionapplied ra);

	// 查询装备用刀容器的载体id 
	List<Containercarrier> getContainercarrierList(
			@Param("cc") Containercarrier cc);

	// 先查询原有的周转量
	List<Tooltransfer> searchTooltransferList(@Param("tt")Tooltransfer tt);

	// 更新流转表
	void updateTooltransfer(@Param("tt")Tooltransfer tt);

	// 查询载体id
	List<Rfidcontainer> getRfidcontainer(@Param("r")Rfidcontainer r);

	// 获取刀具入库编码
	List<Knifeinventory> getKnifeinventory(@Param("k")Knifeinventory k);

	// 插入到流转表
	void insertTooltransfer(@Param("tt")Tooltransfer tt);

	// 更新库存表
	void updateKnifeinventory(@Param("k")Knifeinventory k);

	// 插入生命周期表
	void insertBatchs(@Param("twf")Toolwholelifecycle toolwholelifecycle);

	// 插入出库履历表
	void insertToollibraryhistory(@Param("tlh")Toollibraryhistory tlentity);
	
	// 插入sap履历信息
	void insetSapHisInfo(@Param("sap") SapUploadhistory sap);
	
	// 查询sap自动上传开关是否开启
	String getSapOnOff();

}
