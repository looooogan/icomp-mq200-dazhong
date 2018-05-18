package com.amistrong.express.beans.request;

import java.io.Serializable;

/**
 * 调刀记录表Bean
 * @author wr
 * @version 2017-11-30
 */
public class ToolChangehistory implements Serializable{
	
	private static final long serialVersionUID = 5259170567770671790L;
	
	private String changeID;
	private String synthesisParametersCode;
	private String assemblyLineID;
	private String processID;
	private String equipmentID;
	private String partsID;
	private String axleID;
	private String changeDate;
	private String changeUser;
	private String toolCode;
	private String changeNum;
	private String updateUser;
	private String createUser;
	public String getChangeID() {
		return changeID;
	}
	public void setChangeID(String changeID) {
		this.changeID = changeID;
	}
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}
	public String getAssemblyLineID() {
		return assemblyLineID;
	}
	public void setAssemblyLineID(String assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}
	public String getProcessID() {
		return processID;
	}
	public void setProcessID(String processID) {
		this.processID = processID;
	}
	public String getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}
	public String getPartsID() {
		return partsID;
	}
	public void setPartsID(String partsID) {
		this.partsID = partsID;
	}
	public String getAxleID() {
		return axleID;
	}
	public void setAxleID(String axleID) {
		this.axleID = axleID;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public String getChangeUser() {
		return changeUser;
	}
	public void setChangeUser(String changeUser) {
		this.changeUser = changeUser;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getChangeNum() {
		return changeNum;
	}
	public void setChangeNum(String changeNum) {
		this.changeNum = changeNum;
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
	
	


}
