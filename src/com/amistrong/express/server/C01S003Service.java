package com.amistrong.express.server;

import java.util.List;

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
 * 换领出库service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S003Service {

	// 根据RFID查询库存信息
	Knifeinventory getKnifeinventoryByRfid(String rfid);

	// 取得要换领出库的刀具信息
	Tool getRedemptionapplyInfo(Tool tool);

	// 查询刀具申请数量
	Integer getRequestNumByToolCode(String toolCode);

	// 取得换领申请的信息
	List<Redemptionapplied> getRedemptionappliedList(String toolCode);

	// 更新换领申请表
	void updateRedemptionapplied(Redemptionapplied ra);

	// 查询装备用刀容器的载体id
	List<Containercarrier> getContainercarrierList(Containercarrier cc);

	// 先查询原有的周转量
	List<Tooltransfer> searchTooltransferList(Tooltransfer tt);

	// 更新流转表
	void updateTooltransfer(Tooltransfer tt);

	// 查询载体id
	List<Rfidcontainer> getRfidcontainer(Rfidcontainer r);

	// 获取刀具入库编码
	List<Knifeinventory> getKnifeinventory(Knifeinventory k);

	// 插入到流转表
	void insertTooltransfer(Tooltransfer tt);

	// 更新库存表
	void updateKnifeinventory(Knifeinventory k);

	// 插入生命周期表
	void insertBatchs(List<Toolwholelifecycle> twlList);

	// 插入出库履历表
	void insertToollibraryhistory(Toollibraryhistory tlentity);

	// 插入sap履历信息
	void insetSapHisInfo(SapUploadhistory sap);

	// 查询sap自动上传开关是否开启
	String getSapOnOff();

}
