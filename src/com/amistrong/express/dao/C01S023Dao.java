package com.amistrong.express.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amistrong.express.beans.response.Synthesisparameters;
import com.amistrong.express.beans.response.Synthesistoolsmachining;
import com.amistrong.express.beans.response.ToolDurable;
import com.amistrong.express.beans.response.Toolsmachining;

/**
 * 单品绑定Dao
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S023Dao {

	// 更新载体激光识别码
	void updateRfidcontainerLaserCode(@Param("rfid") String rfid,
			@Param("laserCode") String laserCode,
			@Param("customerID") String customerID);

	// 验证激光码是否重复
	Integer getLaserCodeCountByLaserCode(@Param("laserCode") String laserCode);

	// 以材料号、厂家 查询激光码总数
	Integer getLaserCodeCountByMaterialNumAndManufactor(
			@Param("materialNumAndManufactorStr") String materialNumAndManufactorStr);

	// 验证材料号为一体刀材料号
	Synthesisparameters getSynthesisparametersByToolCode(
			@Param("toolCode") String materialNum);

	// 查询生产关联关系平均加工量list
	List<ToolDurable> getToolDurableList(@Param("toolCode") String materialNum);

	// 插入加工信息
	void insertSynthesistoolsmachining(@Param("syn")Synthesistoolsmachining syn);

	// 插入刀具加工信息
	void insertToolsmachining(@Param("ts")Toolsmachining ts);

}
