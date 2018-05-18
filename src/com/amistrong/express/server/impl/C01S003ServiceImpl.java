package com.amistrong.express.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amistrong.express.beans.response.Containercarrier;
import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.Redemptionapplied;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.SapUploadhistory;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toollibraryhistory;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.Toolwholelifecycle;
import com.amistrong.express.dao.C01S003Dao;
import com.amistrong.express.server.C01S003Service;

/**
 * 换领出库ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
public class C01S003ServiceImpl implements C01S003Service {

	@Autowired
	private C01S003Dao c01S003Dao;

	/**
	 * 根据RFID查询库存信息
	 */
	public Knifeinventory getKnifeinventoryByRfid(String rfid) {
		List<Knifeinventory> reList = c01S003Dao.getKnifeinventoryByRfid(rfid);
		Knifeinventory reEntity = new Knifeinventory();
		if (reList.size() < 1) {
			reEntity = null;
		} else {
			reEntity = reList.get(0);
		}
		return reEntity;
	}

	/**
	 * 取得要换领出库的刀具信息
	 */
	public Tool getRedemptionapplyInfo(Tool tool) {
		Tool bean = c01S003Dao.getRedemptionapplyInfo(tool);
		return bean;
	}

	/**
	 * 查询刀具申请数量
	 */
	public Integer getRequestNumByToolCode(String toolCode) {
		Integer sum = c01S003Dao.getRequestNumByToolCode(toolCode);
		return sum;
	}

	/**
	 * 取得换领申请的信息
	 */
	public List<Redemptionapplied> getRedemptionappliedList(String toolCode) {
		List<Redemptionapplied> list = c01S003Dao
				.getRedemptionappliedList(toolCode);
		return list;
	}

	/**
	 * 更新换领申请表
	 */
	public void updateRedemptionapplied(Redemptionapplied ra) {
		c01S003Dao.updateRedemptionapplied(ra);

	}

	/**
	 * 查询装备用刀容器的载体id
	 */
	public List<Containercarrier> getContainercarrierList(Containercarrier cc) {
		List<Containercarrier> list = c01S003Dao.getContainercarrierList(cc);
		return list;
	}

	/**
	 * 先查询原有的周转量
	 */
	public List<Tooltransfer> searchTooltransferList(Tooltransfer tt) {
		List<Tooltransfer> list = c01S003Dao.searchTooltransferList(tt);
		return list;
	}

	/**
	 * 更新流转表
	 */
	public void updateTooltransfer(Tooltransfer tt) {
		c01S003Dao.updateTooltransfer(tt);

	}

	/**
	 * 查询载体id
	 */
	public List<Rfidcontainer> getRfidcontainer(Rfidcontainer r) {
		List<Rfidcontainer> list = c01S003Dao.getRfidcontainer(r);
		return list;
	}

	/**
	 * 获取刀具入库编码
	 */
	public List<Knifeinventory> getKnifeinventory(Knifeinventory k) {
		List<Knifeinventory> list = c01S003Dao.getKnifeinventory(k);
		return list;
	}

	/**
	 * 插入到流转表
	 */
	public void insertTooltransfer(Tooltransfer tt) {
		c01S003Dao.insertTooltransfer(tt);

	}

	/**
	 * 更新库存表
	 */
	public void updateKnifeinventory(Knifeinventory k) {
		c01S003Dao.updateKnifeinventory(k);

	}

	/**
	 * 插入生命周期表
	 */
	public void insertBatchs(List<Toolwholelifecycle> twlList) {
		for (int i = 0; i < twlList.size(); i++) {
			c01S003Dao.insertBatchs(twlList.get(i));
		}

	}

	/**
	 * 插入出库履历表
	 */
	public void insertToollibraryhistory(Toollibraryhistory tlentity) {
		// 插入出库履历表
		c01S003Dao.insertToollibraryhistory(tlentity);
		
	}

	/**
	 * 插入sap履历信息
	 */
	public void insetSapHisInfo(SapUploadhistory sap) {
		c01S003Dao.insetSapHisInfo(sap);
		
	}

	/**
	 * 查询sap自动上传开关是否开启
	 */
	public String getSapOnOff() {
		String flg = c01S003Dao.getSapOnOff();
		return flg;
	}

}
