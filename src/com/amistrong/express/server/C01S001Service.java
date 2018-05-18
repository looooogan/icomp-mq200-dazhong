package com.amistrong.express.server;

import java.util.List;

import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Storagerecord;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toolprocured;
import com.amistrong.express.beans.response.Tooltransfer;

/**
 * 新刀入库service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S001Service {

	// 验证RFID标签是否存在
	Rfidcontainer getRfidContainerByRfidCode(String rfidCode);

	// 判断新刀入库表是否有数据
	List<Knifeinventory> getKnifeinventoryInfo(Knifeinventory ki);

	// 判断刀具流转表是否有数据
	List<Tooltransfer> getTooltransferInfo(Tooltransfer tt);

	// 根据刀具id取得刀具类型
	List<Tool> getToolInfo(Tool tool);

	// 获取可用批次
	List<Toolprocured> getProcuredBatchList(Toolprocured toolprocured);

	// 根据刀具码查询刀具信息
	Tool searchBitInputInf(Tool entity);

	// 更新新刀库存表表
	void updateKnifeinventory(Knifeinventory knifeinventory);

	// 更新采购表
	void updateToolprocured(Toolprocured toolprocured);

	// 新建入库履历
	void insertStoragerecord(Storagerecord storagerecord);

	// 删除库位信息
	void deleteKnifeinventory(Knifeinventory k1);

	// 删除RFID载体数据
	void deleteRfidcontainer(Rfidcontainer rf);

}
