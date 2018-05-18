package com.amistrong.express.server.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Storagerecord;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toolprocured;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.dao.C01S001Dao;
import com.amistrong.express.server.C01S001Service;

/**
 * 新刀入库ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
public class C01S001ServiceImpl implements C01S001Service {

	@Autowired
	private C01S001Dao c01S001Dao;

	/**
	 * 验证RFID标签是否存在
	 */
	public Rfidcontainer getRfidContainerByRfidCode(String rfidCode) {
		List<Rfidcontainer> reList = c01S001Dao
				.getRfidContainerByRfidCode(rfidCode);
		if (reList.size() < 1) {
			// 没有RIFD载体
			return null;
		} else {
			return reList.get(0);
		}
	}

	/**
	 * 判断新刀入库表是否有数据
	 */
	public List<Knifeinventory> getKnifeinventoryInfo(Knifeinventory ki) {
		List<Knifeinventory> kiList = c01S001Dao.getKnifeinventoryInfo(ki);
		return kiList;
	}

	/**
	 * 判断刀具流转表是否有数据
	 */
	public List<Tooltransfer> getTooltransferInfo(Tooltransfer tt) {
		List<Tooltransfer> ttList = c01S001Dao.getTooltransferInfo(tt);
		return ttList;
	}

	/**
	 * 根据刀具id取得刀具类型
	 */
	public List<Tool> getToolInfo(Tool tool) {
		List<Tool> toolList = c01S001Dao.getToolInfo(tool);
		return toolList;
	}

	/**
	 * 获取可用批次
	 */
	public List<Toolprocured> getProcuredBatchList(Toolprocured toolprocured) {
		List<Toolprocured> list = c01S001Dao.getProcuredBatchList(toolprocured);
		return list;
	}

	/**
	 * 根据刀具码查询刀具信息
	 */
	public Tool searchBitInputInf(Tool entity) {
		List<Tool> list = c01S001Dao.searchBitInputInf(entity);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new Tool();
		}

	}

	/**
	 * 更新新刀库存表表
	 */
	public void updateKnifeinventory(Knifeinventory knifeinventory) {
		c01S001Dao.updateKnifeinventory(knifeinventory);

	}

	/**
	 * 更新采购表
	 */
	public void updateToolprocured(Toolprocured toolprocured) {
		c01S001Dao.updateToolprocured(toolprocured);

	}

	/**
	 * 新建入库履历
	 */
	public void insertStoragerecord(Storagerecord storagerecord) {
		c01S001Dao.insertStoragerecord(storagerecord);

	}

	/**
	 * 删除库位信息
	 */
	public void deleteKnifeinventory(Knifeinventory k1) {
		c01S001Dao.deleteKnifeinventory(k1);

	}

	/**
	 * 删除RFID载体数据
	 */
	public void deleteRfidcontainer(Rfidcontainer rf) {
		c01S001Dao.deleteRfidcontainer(rf);

	}

}
