package com.amistrong.express.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.amistrong.express.beans.BaseRequestBean;
import com.amistrong.express.beans.SystemSettingBean;
import com.amistrong.express.beans.ValidateSetBean;
import com.amistrong.express.dao.SystemSettingDao;

/**
 * 系统初始化server
 * 
 * @author 于鑫
 * @version 2015-5-15 15:30:32
 */
public class SystemInitSet extends HttpServlet {

	private static final long serialVersionUID = 3363129526488753176L;

	public void init() throws ServletException {
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		SystemSettingDao dao = (SystemSettingDao) wac.getBean("systemSettingDao");
		List<ValidateSetBean> valiBean = dao.getUrlValidateSet();
		SystemSet.urlValidateSet = new HashMap<String, String>();

//		//常用快递公司
//		SystemSet.courierCompanyMap = new HashMap<String, String>();
		
//		//全部快递公司
//		SystemSet.logisticsCompany = new HashMap<String, Object>();
		
//		SystemSet.companyList = dao.getCompany();
		
//		List<LogisticsCompanyBean> logisticsCompanyBeans=new ArrayList<LogisticsCompanyBean>();
//		logisticsCompanyBeans = dao.getLogisticsCompany();
		
		
		
//		for (SystemSettingBean sys : SystemSet.companyList) {
//			SystemSet.courierCompanyMap.put(String.valueOf(sys.getCode()), String.valueOf(sys.getValue()));
//		}
		
//		for (LogisticsCompanyBean los : logisticsCompanyBeans) {
//			SystemSet.logisticsCompany.put(los.getCompanyId(), los);
//		}
		
		for (ValidateSetBean bean : valiBean) {
			SystemSet.urlValidateSet.put(bean.getUrlPath(), bean.getIsValidate());
		}

		List<SystemSettingBean> bean = new ArrayList<SystemSettingBean>();
		
		bean = dao.systemInit();
		
		for (SystemSettingBean systemSettingBean : bean) {
			switch (systemSettingBean.getCode()) {
			case 99001:// 验证码有效时间
				SystemSet.CODE_ACTIVE_TIME = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 10:// 积分设置
				SystemSet.INTEGRAL_SET = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 10001:// 注册获得原始积分
				SystemSet.REGISTER_BASE_INTEGRAL = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 10002:// 介绍一位客户
				SystemSet.INTRODUCE_A_GUEST = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 10003:// 每消费1元
				SystemSet.EACH_CONSUMER = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 10004:// 被推荐人每消费1元
				SystemSet.PASSIVE_CONSUM = Double.parseDouble(systemSettingBean.getValue());
				break;
			case 20:// 交易类型
				SystemSet.OPERATION_TYPE = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 20001:// 充值
				SystemSet.RECHARGE = Double.parseDouble(systemSettingBean.getValue());
				break;
			case 20002:// 消费
				SystemSet.CONSUME = Double.parseDouble(systemSettingBean.getValue());
				break;
			case 99002:// 每页显示信息数
				BaseRequestBean.pageSize = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 99003:// 显示位置范围
				SystemSet.INDICATION_RANGE = Double.parseDouble(systemSettingBean.getValue());
				break;
			case 99004:// 快递员短信推送
				SystemSet.IS_SEND_MESSAGE =systemSettingBean.getValue();
				break;
			case 30:// 金钱设置
				SystemSet.MONRY_SET = Double.parseDouble(systemSettingBean.getValue());
				break;
			case 30001:// 支付平台佣金
				SystemSet.COURIER_FEE = Double.parseDouble(systemSettingBean.getValue());
				break;
			case 30002:// 最低额度
				SystemSet.MIN_ACCOUNT_BALANCE = Double.parseDouble(systemSettingBean.getValue());
				break;
			case 30003:// 审核通过送现金
				SystemSet.SEND_CASH = Double.parseDouble(systemSettingBean.getValue());
				break;
			case 30006:// 返现最低金额
				SystemSet.FANXIAN_MIN = Integer.parseInt(systemSettingBean.getValue());
				break;	
			case 30007:// 返现最高金额
				SystemSet.FANXIAN_MAX = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 30008:// 短信价格
				SystemSet.MESSAGE_JIAGE = Double.parseDouble(systemSettingBean.getValue());
				break;	
			case 40001:// 签到,起始积分
				SystemSet.START_SIGN = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 40002:// 签到,连签积分
				SystemSet.CONTINUOUS_SIGN = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 40003:// 连签最高积分
				SystemSet.MAX_SIGN = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 10006:// 填写推荐人
				SystemSet.INTRODUCE_USER = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 72001:// 微信红包所含金额
				SystemSet.WEIXIN_RED_PACKET = Integer.parseInt(systemSettingBean.getValue());
				break;
			case 30004:// 最低佣金
				SystemSet.MIN_BROKERAGE = Double.parseDouble(systemSettingBean.getValue());
				break;
			default:
				break;
			}
		}
	}

}