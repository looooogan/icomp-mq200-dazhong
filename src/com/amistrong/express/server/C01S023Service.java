package com.amistrong.express.server;

import java.util.List;

import com.amistrong.express.beans.response.Synthesisparameters;
import com.amistrong.express.beans.response.Synthesistoolsmachining;
import com.amistrong.express.beans.response.ToolDurable;
import com.amistrong.express.beans.response.Toolsmachining;


/**
 * 单品绑定service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S023Service {

	// 更新载体激光识别码
	void updateRfidcontainerLaserCode(String rfid, String laserCode,
			String customerID);

	// 验证激光码是否重复
	Integer getLaserCodeCountByLaserCode(String laserCode);

	// 以材料号、厂家 查询激光码总数
	Integer getLaserCodeCountByMaterialNumAndManufactor(
			String materialNumAndManufactorStr);

	// 验证材料号为一体刀材料号
	Synthesisparameters getSynthesisparametersByToolCode(String materialNum);

	// 查询生产关联关系平均加工量list
	List<ToolDurable> getToolDurableList(String materialNum);

	// 插入加工信息
	void insertSynthesistoolsmachining(Synthesistoolsmachining syn);

	// 插入刀具加工信息
	void insertToolsmachining(Toolsmachining syn);

}
