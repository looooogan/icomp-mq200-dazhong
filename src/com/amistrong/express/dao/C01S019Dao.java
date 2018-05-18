package com.amistrong.express.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amistrong.express.beans.response.Authorization;
import com.amistrong.express.beans.response.Merchants;
import com.amistrong.express.beans.response.Outsidefactory;

/**
 * 厂外修磨Dao
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S019Dao {

	// 新增 厂外修复表数据
	void insertOutsidefactory(@Param("uf") Outsidefactory uf);

	// 查询厂外修复商家list
	List<Merchants> getMerchantsList();

	// 插入授权表
	void insertAuthorizationDao(@Param("authorization")Authorization authorization);

}
