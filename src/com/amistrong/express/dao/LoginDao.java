package com.amistrong.express.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.amistrong.express.beans.request.Login;
import com.amistrong.express.beans.request.UserInfo;
import com.amistrong.express.beans.response.LoginState;
/**
 * 请求，登录DAO
 * @author 于鑫
 * @version 2015-5-18 19:21:53
 */
public interface LoginDao {
	
	/**
	 * 1.查询用户是否存在
	 * @param (Login) login
	 */
	public UserInfo queryUser(@Param("login") Login login);
	
	/**
	 * 2.查询快递员信息
	 * @param (Login) login
	 */
	public LoginState queryLoginState(@Param("userInfo") UserInfo userInfo);
	
	/**
	 * 3.更新用户设备码
	 * @param (Login) login
	 */
	public void upLoginToken(@Param("login") Login login);
	
	/**
	 * 4.更新地理信息
	 * @param (Login) login
	 */
	public void upPosition(@Param("login") Login login , @Param("userInfo") UserInfo userInfo);

	/**
	 * 查询是否是领队
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map queryLeader(int userId);

}