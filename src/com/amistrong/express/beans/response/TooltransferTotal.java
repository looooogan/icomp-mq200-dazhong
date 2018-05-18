package com.amistrong.express.beans.response;

import java.io.Serializable;

/**
 * 刀具流转统计表Bean
 * 
 * @author 王冉
 * @version 2017-6-28 13：31
 */
public class TooltransferTotal implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	private String toolCode;//刀具材料号
	private Integer spareKnifeSum;//备刀数量
	private Integer grindingFactorySnum;//厂内修磨数量
	private Integer stayExternalGrindingSum;//厂外待修磨数量
	private Integer externalGrindingSum;//厂外修磨数量
	private Integer productionLineSum;//生成中刀具数量
	private Integer scrapSum;//累积报废数量
	private String updateUser;//更新者
	private String createUser;//创建者
	private Integer version;//版本号
	
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public Integer getSpareKnifeSum() {
		return spareKnifeSum;
	}
	public void setSpareKnifeSum(Integer spareKnifeSum) {
		this.spareKnifeSum = spareKnifeSum;
	}
	public Integer getGrindingFactorySnum() {
		return grindingFactorySnum;
	}
	public void setGrindingFactorySnum(Integer grindingFactorySnum) {
		this.grindingFactorySnum = grindingFactorySnum;
	}
	public Integer getStayExternalGrindingSum() {
		return stayExternalGrindingSum;
	}
	public void setStayExternalGrindingSum(Integer stayExternalGrindingSum) {
		this.stayExternalGrindingSum = stayExternalGrindingSum;
	}
	public Integer getExternalGrindingSum() {
		return externalGrindingSum;
	}
	public void setExternalGrindingSum(Integer externalGrindingSum) {
		this.externalGrindingSum = externalGrindingSum;
	}
	public Integer getProductionLineSum() {
		return productionLineSum;
	}
	public void setProductionLineSum(Integer productionLineSum) {
		this.productionLineSum = productionLineSum;
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
	public Integer getScrapSum() {
		return scrapSum;
	}
	public void setScrapSum(Integer scrapSum) {
		this.scrapSum = scrapSum;
	}
	
	

}
