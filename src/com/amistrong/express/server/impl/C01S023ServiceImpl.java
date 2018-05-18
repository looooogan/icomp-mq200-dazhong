package com.amistrong.express.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amistrong.express.beans.response.Synthesisparameters;
import com.amistrong.express.beans.response.Synthesistoolsmachining;
import com.amistrong.express.beans.response.ToolDurable;
import com.amistrong.express.beans.response.Toolsmachining;
import com.amistrong.express.dao.C01S023Dao;
import com.amistrong.express.server.C01S023Service;

/**
 * 单品绑定ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
public class C01S023ServiceImpl implements C01S023Service {

	@Autowired
	private C01S023Dao c01S023Dao;

	/**
	 * 更新载体激光识别码
	 */
	public void updateRfidcontainerLaserCode(String rfid, String laserCode,
			String customerID) {
		c01S023Dao.updateRfidcontainerLaserCode(rfid, laserCode, customerID);

	}

	/**
	 * 验证激光码是否重复
	 */
	public Integer getLaserCodeCountByLaserCode(String laserCode) {
		Integer count = c01S023Dao.getLaserCodeCountByLaserCode(laserCode);
		return count;
	}

	/**
	 * 以材料号、厂家 查询激光码总数
	 */
	public Integer getLaserCodeCountByMaterialNumAndManufactor(
			String materialNumAndManufactorStr) {
		Integer count = c01S023Dao
				.getLaserCodeCountByMaterialNumAndManufactor(materialNumAndManufactorStr);
		return count;
	}

	/**
	 * 验证材料号为一体刀材料号
	 */
	public Synthesisparameters getSynthesisparametersByToolCode(
			String materialNum) {
		Synthesisparameters synthesisparameters = c01S023Dao
				.getSynthesisparametersByToolCode(materialNum);
		return synthesisparameters;
	}

	/**
	 * 查询生产关联关系平均加工量list
	 */
	public List<ToolDurable> getToolDurableList(String materialNum) {
		List<ToolDurable> list = c01S023Dao.getToolDurableList(materialNum);
		return list;
	}

	/**
	 * 插入加工信息
	 */
	public void insertSynthesistoolsmachining(Synthesistoolsmachining syn) {
		c01S023Dao.insertSynthesistoolsmachining(syn);
		
	}

	/**
	 * 插入刀具加工信息
	 */
	public void insertToolsmachining(Toolsmachining ts) {
		c01S023Dao.insertToolsmachining(ts);
		
	}

}
