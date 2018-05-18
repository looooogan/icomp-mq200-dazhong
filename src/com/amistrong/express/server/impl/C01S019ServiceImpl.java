package com.amistrong.express.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amistrong.express.beans.response.Authorization;
import com.amistrong.express.beans.response.Merchants;
import com.amistrong.express.beans.response.Outsidefactory;
import com.amistrong.express.dao.C01S019Dao;
import com.amistrong.express.server.C01S019Service;

/**
 * 厂外修磨ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
public class C01S019ServiceImpl implements C01S019Service {
	
	@Autowired
	private C01S019Dao c01S019Dao;

	/**
	 * 新增 厂外修复表数据
	 */
	public void insertOutsidefactory(Outsidefactory uf) {
		c01S019Dao.insertOutsidefactory(uf);
		
	}

	/**
	 * 查询厂外修复商家list
	 */
	public List<Merchants> getMerchantsList() {
		List<Merchants> list = c01S019Dao.getMerchantsList();
		return list;
	}

	/**
	 * 插入授权表
	 */
	public void insertAuthorizationDao(Authorization authorization) {
		c01S019Dao.insertAuthorizationDao(authorization);
		
	}

}
