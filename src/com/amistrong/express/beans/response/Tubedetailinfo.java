package com.amistrong.express.beans.response;

import java.io.Serializable;
import java.util.Date;

/**
 * 筒刀详细表实体类 创建时间：2017/6/30 15:52 创建者 ：王冉
 * 
 */
public class Tubedetailinfo implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	// 主键
	private String ID;

	// 合成刀具编码(筒刀)
	private String synthesisParametersCode;

	// 位置号编号
	private Integer synthesisCutterNumber;
	// 刀具编号
	private String toolCode;
	// 使用状态(0装入1卸下2修磨3修磨完成4报废)
	private String loadState;
	// 刀具数量
	private Integer toolCount;
	// 修磨次数
	private Integer grindingsum;
	// 删除区分(0有效1删除)
	private String delFlag;
	// 更新者
	private String updateUser;
	// 创建者
	private String createUser;
	// 版本号
	private Integer version;
	// rFID
	private String rFID;
	// 拆分人
	private String splitUser;
	// 组装人
	private String installUser;
	private Date splitTime;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	public Integer getSynthesisCutterNumber() {
		return synthesisCutterNumber;
	}

	public void setSynthesisCutterNumber(Integer synthesisCutterNumber) {
		this.synthesisCutterNumber = synthesisCutterNumber;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getLoadState() {
		return loadState;
	}

	public void setLoadState(String loadState) {
		this.loadState = loadState;
	}

	public Integer getToolCount() {
		return toolCount;
	}

	public void setToolCount(Integer toolCount) {
		this.toolCount = toolCount;
	}

	public Integer getGrindingsum() {
		return grindingsum;
	}

	public void setGrindingsum(Integer grindingsum) {
		this.grindingsum = grindingsum;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getrFID() {
		return rFID;
	}

	public void setrFID(String rFID) {
		this.rFID = rFID;
	}

	public String getSplitUser() {
		return splitUser;
	}

	public void setSplitUser(String splitUser) {
		this.splitUser = splitUser;
	}

	public String getInstallUser() {
		return installUser;
	}

	public void setInstallUser(String installUser) {
		this.installUser = installUser;
	}

	public Date getSplitTime() {
		return splitTime;
	}

	public void setSplitTime(Date splitTime) {
		this.splitTime = splitTime;
	}

}
