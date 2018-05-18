package com.amistrong.express.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amistrong.express.beans.response.Redemptionapplied;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Scrap;
import com.amistrong.express.beans.response.ScrapState;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toolnoticehistory;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Toolwholelifecycle;
import com.amistrong.express.beans.response.Tubedetailinfo;
import com.amistrong.express.dao.C01S005Dao;
import com.amistrong.express.server.C01S005Service;

/**
 * 刀具报废ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
@Transactional
public class C01S005ServiceImpl implements C01S005Service {

	@Autowired
	private C01S005Dao c01S005Dao;

	/**
	 * 插入报废表数据
	 */
	public void insertScrap(Scrap entity) {
		c01S005Dao.insertScrap(entity);

	}

	/**
	 * 更新流转统计表数据
	 */
	public void updateTooltransferTotalInfo(TooltransferTotal tst) {
		c01S005Dao.updateTooltransferTotalInfo(tst);

	}

	/**
	 * 根据材料号查询流转统计表数据
	 */
	public TooltransferTotal getTooltransferTotalInfoByToolCode(String toolCode) {
		TooltransferTotal bean = c01S005Dao
				.getTooltransferTotalInfoByToolCode(toolCode);
		return bean;
	}

	/**
	 * 新建换领申请表数据
	 */
	public void insertRedemptionapplied(Redemptionapplied r) {
		c01S005Dao.insertRedemptionapplied(r);

	}

	/**
	 * 根据rfid材料载体信息
	 */
	public Rfidcontainer getRfidInfoByRfid(String rfid) {
		Rfidcontainer rfidInfo = c01S005Dao.getRfidInfoByRfid(rfid);
		return rfidInfo;

	}

	/**
	 * 根据合成刀具码查询刀具信息
	 */
	public Tool searchToolInfoBySpcode(String spCode) {
		Tool tool = c01S005Dao.searchToolInfoBySpcode(spCode);
		return tool;
	}

	/**
	 * 删除刀具生命周期表数据
	 */
	public void updateToolwholelifecycle(Toolwholelifecycle tf) {
		c01S005Dao.updateToolwholelifecycle(tf);

	}

	// 删除合成刀库数据
	public void updateSynthesisknife(Synthesisknife sf) {
		c01S005Dao.updateSynthesisknife(sf);

	}

	/**
	 * 更新筒刀表信息
	 */
	public void updateTubedetailinfo(Tubedetailinfo bean) {
		c01S005Dao.updateTubedetailinfo(bean);

	}

	/**
	 * 查询刀具报废状态list
	 */
	public List<ScrapState> getScrapStateList() {
		List<ScrapState> list = c01S005Dao.getScrapStateList();
		return list;
	}

	@Override
	public void insertError() {
		try {
			c01S005Dao.insertError();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		

	}

	/**
	 * 新增刀具修复履历
	 */
	public void insertToolnoticehistory(Toolnoticehistory tnh) {
		c01S005Dao.insertToolnoticehistory(tnh);
		
	}
}
