package com.amistrong.express.beans;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -6353153389651280124L;
	// 版本号
	private Double version;
	// 删除区分
	private String delFlag;
	// 创建者
	private String createUser;
	// 更新者
	private String updateUser;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 版本号
	private Double versionWhere;
	// 删除区分
	private String delFlagWhere;
	// 创建者
	private String createUserWhere;
	// 更新者
	private String updateUserWhere;
	// 创建时间
	private Date createTimeWhere;
	// 更新时间
	private Date updateTimeWhere;
	// 排序字段 包含排序规则
	private String orderString;
	// 分组字段 包含分组规则
	private String groupString;
	// 当前用户选择的语言
	private String systemLanguage;
	// 起始行
	private int staIndex = -1;
	// 结束行
	private int rowCount;
	// 起始时间
	private Date dateStar;
	// 结束时间
	private Date dateEnd;
	// 起始值
	private String stringStar;
	// 结束值
	private String stringEnd;
	// Msg 编码
	private String messageCode;
	private String exceMessage;
	// 总金额
	private String totalAmount;
	// 残值
	private String residualValue;
	// 天数
	private String dayCount;
	// 总数量
	private String totalCount;
	// zTree树形节点id
	private String zTreeId;
	// zTree树形节点pid
	private String zTreeParentId;
	// 常用状态
	private String states;
	// 拓展字段1
	private String expandSpace1;
	// 拓展字段2
	private String expandSpace2;
	// 拓展字段3(刀片数量)
	private String expandSpace3;
	// 拓展字段4
	private String expandSpace4;

	public String getExpandSpace1() {
		return expandSpace1;
	}

	public void setExpandSpace1(String expandSpace1) {
		this.expandSpace1 = expandSpace1;
	}

	public String getExpandSpace2() {
		return expandSpace2;
	}

	public void setExpandSpace2(String expandSpace2) {
		this.expandSpace2 = expandSpace2;
	}

	public String getExpandSpace3() {
		return expandSpace3;
	}

	public void setExpandSpace3(String expandSpace3) {
		this.expandSpace3 = expandSpace3;
	}

	public String getExpandSpace4() {
		return expandSpace4;
	}

	public void setExpandSpace4(String expandSpace4) {
		this.expandSpace4 = expandSpace4;
	}

	public String getExceMessage() {
		return exceMessage;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public void setExceMessage(String exceMessage) {
		this.exceMessage = exceMessage;
	}

	// 处理区分(true:成功 false:失败)
	private boolean retErrFlag;

	public boolean isRetErrFlag() {
		return retErrFlag;
	}

	public void setRetErrFlag(boolean retErrFlag) {
		this.retErrFlag = retErrFlag;
	}

	public boolean getRetErrFlag() {

		return retErrFlag;
	}

	public String getStringStar() {
		return stringStar;
	}

	public void setStringStar(String stringStar) {
		this.stringStar = stringStar;
	}

	public String getStringEnd() {
		return stringEnd;
	}

	public void setStringEnd(String stringEnd) {
		this.stringEnd = stringEnd;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public String getzTreeId() {
		return zTreeId;
	}

	public void setzTreeId(String zTreeId) {
		this.zTreeId = zTreeId;
	}

	public String getzTreeParentId() {
		return zTreeParentId;
	}

	public void setzTreeParentId(String zTreeParentId) {
		this.zTreeParentId = zTreeParentId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Double getVersionWhere() {
		return versionWhere;
	}

	public void setVersionWhere(Double versionWhere) {
		this.versionWhere = versionWhere;
	}

	public String getDelFlagWhere() {
		return delFlagWhere;
	}

	public void setDelFlagWhere(String delFlagWhere) {
		this.delFlagWhere = delFlagWhere;
	}

	public String getCreateUserWhere() {
		return createUserWhere;
	}

	public void setCreateUserWhere(String createUserWhere) {
		this.createUserWhere = createUserWhere;
	}

	public String getUpdateUserWhere() {
		return updateUserWhere;
	}

	public void setUpdateUserWhere(String updateUserWhere) {
		this.updateUserWhere = updateUserWhere;
	}

	public Date getCreateTimeWhere() {
		return createTimeWhere;
	}

	public void setCreateTimeWhere(Date createTimeWhere) {
		this.createTimeWhere = createTimeWhere;
	}

	public Date getUpdateTimeWhere() {
		return updateTimeWhere;
	}

	public void setUpdateTimeWhere(Date updateTimeWhere) {
		this.updateTimeWhere = updateTimeWhere;
	}

	public String getOrderString() {
		return orderString;
	}

	public void setOrderString(String orderString) {
		this.orderString = orderString;
	}

	public String getSystemLanguage() {
		return systemLanguage;
	}

	public void setSystemLanguage(String systemLanguage) {
		this.systemLanguage = systemLanguage;
	}

	public int getStaIndex() {
		return staIndex;
	}

	public void setStaIndex(int staIndex) {
		this.staIndex = staIndex;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDateStar() {
		return dateStar;
	}

	public void setDateStar(Date dateStar) {
		this.dateStar = dateStar;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * 总金额
	 * 
	 * @title getTotalAmount
	 * @return String
	 */
	public String getTotalAmount() {
		return totalAmount;
	}

	/**
	 * 总金额
	 * 
	 * @title setTotalAmount
	 * @param totalAmount
	 *            void
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 残值
	 * 
	 * @title getResidualValue
	 * @return String
	 */
	public String getResidualValue() {
		return residualValue;
	}

	/**
	 * 残值
	 * 
	 * @title setResidualValue
	 * @param residualValue
	 *            void
	 */
	public void setResidualValue(String residualValue) {
		this.residualValue = residualValue;
	}

	/**
	 * 天数
	 * 
	 * @title getDayCount
	 * @return String
	 */
	public String getDayCount() {
		return dayCount;
	}

	/**
	 * 天数
	 * 
	 * @title setDayCount
	 * @param dayCount
	 *            void
	 */
	public void setDayCount(String dayCount) {
		this.dayCount = dayCount;
	}

	/**
	 * 总数量
	 * 
	 * @title getTotalCount
	 * @return String
	 */
	public String getTotalCount() {
		return totalCount;
	}

	/**
	 * 总数量
	 * 
	 * @title setTotalCount
	 * @param totalCount
	 *            void
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getGroupString() {
		return groupString;
	}

	public void setGroupString(String groupString) {
		this.groupString = groupString;
	}

}
