package com.amistrong.express.beans;

/**
 * 系统设置码Bean
 * @author 于鑫
 * @version 2015-5-18 11:44:25
 */
public class SystemSettingBean{
	
	private int code;			//ID
	private String codeName;	//名称
	private int parent;			//父类
	private String value;		//系统值
	private int firstWeight;		//首重
	private int firstWeightPrice;		//首重价格
	private int additionalWeightPrice;		//续重价格
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getFirstWeight() {
		return firstWeight;
	}
	public void setFirstWeight(int firstWeight) {
		this.firstWeight = firstWeight;
	}
	public int getFirstWeightPrice() {
		return firstWeightPrice;
	}
	public void setFirstWeightPrice(int firstWeightPrice) {
		this.firstWeightPrice = firstWeightPrice;
	}
	public int getAdditionalWeightPrice() {
		return additionalWeightPrice;
	}
	public void setAdditionalWeightPrice(int additionalWeightPrice) {
		this.additionalWeightPrice = additionalWeightPrice;
	}
}
