package com.amistrong.express.server;

import java.util.List;

import com.amistrong.express.beans.response.Outsidefactory;
import com.amistrong.express.beans.response.Outsidefactoryhistory;
import com.amistrong.express.beans.response.Tool;




/**
 * 回厂确认service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S017Service {

	//根据材料号查询非单品回厂修复信息
	Outsidefactory getFOutsidefactory(Outsidefactory bean);

	// 查询刀具信息
	Tool searchTool(Tool entity);

	// 根据RFID码查询单品回厂修复信息
	Outsidefactory getOutsidefactory(Outsidefactory bean);

	// 根據出门单号取得回厂信息
	List<Outsidefactory> getOutsidefactoryList(Outsidefactory entity);

	// 更新换厂外修复表
	void updateOutsidefactory(Outsidefactory ra);

	// 根据激光码查询回厂信息
	List<Outsidefactory> getOutsidefactoryListByLaserCode(String laserCode);

	// 插入厂外修复履历数据
	void insertOutsidefactoryHistory(Outsidefactoryhistory outHis);

	// 查询所有未回厂单号list
	List<Outsidefactory> getOutFactoryOutDoorNomList();

	// 根据单号查厂外修复信息
	List<Outsidefactory> getOutFactoryDescByOutDoorNom(String outDoorNom);


}
