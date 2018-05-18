package com.amistrong.express.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SysInitListener implements ServletContextListener {
	/*
	 * 项目初始化，实际初始化分为3个店， 1:ServletContextListener 2:spring
	 * WebApplicationContextUtils初始化完成 3:springmvc 初始化完成
	 * 
	 * 这里初始化是在2之后(在web.xml里配置的），目前不需要在3之后初始化
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		String webPath = arg0.getServletContext().getRealPath("");

		// 读config
		SysConfig.CONFIG_PATH = webPath + "/config.properties";
		try {
			SysConfig.Load();
		} catch (Exception e) {
			throw new RuntimeException("config load failed");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

}
