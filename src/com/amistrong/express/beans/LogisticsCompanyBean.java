package com.amistrong.express.beans;

import java.io.Serializable;

public class LogisticsCompanyBean implements Serializable{

	private static final long serialVersionUID = -8210265884826803225L;
	
	//公司id
	private String companyId;
	
	//公司名称
	private String name;
	
	//公司简称
	private String abbreviation;
	
	//公司规则
	private String regular;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getRegular() {
		return regular;
	}

	public void setRegular(String regular) {
		this.regular = regular;
	}
	

}
