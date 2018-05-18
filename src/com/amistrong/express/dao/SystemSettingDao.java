package com.amistrong.express.dao;

import java.util.List;

import com.amistrong.express.beans.LogisticsCompanyBean;
import com.amistrong.express.beans.SystemSettingBean;
import com.amistrong.express.beans.ValidateSetBean;

public interface SystemSettingDao {

	//初始化参数
	List<SystemSettingBean> systemInit();
	
	List<ValidateSetBean> getUrlValidateSet();

	List<SystemSettingBean> getCompany();

	List<LogisticsCompanyBean> getLogisticsCompany();
}
