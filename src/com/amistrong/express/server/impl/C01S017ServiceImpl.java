package com.amistrong.express.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amistrong.express.beans.response.Outsidefactory;
import com.amistrong.express.beans.response.Outsidefactoryhistory;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.dao.C01S017Dao;
import com.amistrong.express.server.C01S017Service;

@Service
public class C01S017ServiceImpl implements C01S017Service {

	@Autowired
	private C01S017Dao c01S017Dao;

	/**
	 * 根据材料号查询非单品回厂修复信息
	 */
	public Outsidefactory getFOutsidefactory(Outsidefactory bean) {
		Outsidefactory outsidefactory = c01S017Dao.getFOutsidefactory(bean);
		return outsidefactory;
	}

	/**
	 * 查询刀具信息
	 */
	public Tool searchTool(Tool entity) {
		Tool bean = c01S017Dao.searchTool(entity);
		return bean;
	}

	/**
	 * 根据RFID码查询单品回厂修复信息
	 */
	public Outsidefactory getOutsidefactory(Outsidefactory bean) {
		Outsidefactory outsidefactory = c01S017Dao.getOutsidefactory(bean);
		return outsidefactory;
	}

	/**
	 * 根據出门单号取得回厂信息
	 */
	public List<Outsidefactory> getOutsidefactoryList(Outsidefactory entity) {
		List<Outsidefactory> list = c01S017Dao.getOutsidefactoryList(entity);
		return list;
	}

	/**
	 * 更新换厂外修复表
	 */
	public void updateOutsidefactory(Outsidefactory ra) {
		c01S017Dao.updateOutsidefactory(ra);
	}

	/**
	 * 根据激光码查询回厂信息
	 */
	public List<Outsidefactory> getOutsidefactoryListByLaserCode(
			String laserCode) {
		List<Outsidefactory> list = c01S017Dao
				.getOutsidefactoryListByLaserCode(laserCode);
		return list;
	}

	/**
	 * 插入厂外修复履历数据
	 */
	public void insertOutsidefactoryHistory(Outsidefactoryhistory outHis) {
		c01S017Dao.insertOutsidefactoryHistory(outHis);

	}

	/**
	 * 查询所有未回厂单号list
	 */
	public List<Outsidefactory> getOutFactoryOutDoorNomList() {
		List<Outsidefactory> list = c01S017Dao.getOutFactoryOutDoorNomList();
		return list;
	}

	/**
	 * 根据单号查厂外修复信息
	 */
	public List<Outsidefactory> getOutFactoryDescByOutDoorNom(String outDoorNom) {
		List<Outsidefactory> list = c01S017Dao
				.getOutFactoryDescByOutDoorNom(outDoorNom);
		return list;
	}

}
