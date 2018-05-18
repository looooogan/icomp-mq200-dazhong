package com.amistrong.express.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.Onoff;
import com.amistrong.express.beans.response.Oplink;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.SynthesisEntity;
import com.amistrong.express.beans.response.Synthesiscutterlocation;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Synthesisparameters;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Toolwholelifecycle;
import com.amistrong.express.beans.response.Tubedetailinfo;
import com.amistrong.express.beans.response.Vknifeinventoryinfo;

/**
 * 合成刀初始化Dao
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C03S001Dao {

	// 查询已经有的合成刀具信息
	List<Synthesisknife> findskListByRfidList(@Param("rfidCode") String rfidCode);

	// 删除流转中的数据
	void updateBatchDeFlagByRfid(@Param("rfBean") Rfidcontainer rfBean);

	// 删除合成刀库中的数据
	void updateSynthesisknifeDeFlag(@Param("sk1") Synthesisknife sk1);

	// 取得当前合成刀具组成
	List<Synthesisparameters> searchSynthesisparameters(
			@Param("syn") Synthesisparameters synthesisparameters);

	// 为刀具生命周期查询零部件id
	List<Oplink> searchOplink(@Param("oplink") Oplink oplink);

	// 查询刀具位置信息
	List<Synthesiscutterlocation> searchSynthesiscutterlocation(
			@Param("synthesiscutterlocation") Synthesiscutterlocation synthesiscutterlocation);
	
	// 新建载体数据
	void insertRfidcontainer(@Param("rfidcontainer")Rfidcontainer rfidcontainer);

	// 更新载体数据
	void updateRfidcontainer(@Param("entity")Rfidcontainer entity);

	// 取得合成刀具序号
	Synthesisknife searchBySynthesisknife(@Param("entity")Synthesisknife entity);
	
	// 新增合成刀库数据
	void insertSynthesisknife(@Param("synthesisknife")Synthesisknife synthesisknife);

	// 查询刀具信息
	Tool searchTool(@Param("tool")Tool tool);

	// 新增刀具全生命周期表
	void insertToolwholelifecycle(@Param("toolwholelifecycle")Toolwholelifecycle toolwholelifecycle);

	// 根据载体ID查询合成刀具编码
	Synthesisknife getSynCodeByRfidConner(@Param("skentity")Synthesisknife skentity);

	// 查询合成刀组成刀具list
	List<SynthesisEntity> getSynthesisToolListBySPCode(@Param("spCode")String synthesisParametersCode);
	List<SynthesisEntity> getSynthesisToolListBySPCodeAndConfCode(@Param("spCode")String synthesisParametersCode,@Param("spConfCode")String configurationCode);

	// 查询刀具组成信息
	List<Synthesiscutterlocation> getSynthesiscutterlocation(
			@Param("spCode")String synthesisparametersID);

	// 新增筒刀数据
	void insertTubedetailinfo(@Param("tubedetailinfo")Tubedetailinfo tubedetailinfo);

	// 根据材料号查询库存信息
	Vknifeinventoryinfo getknifeinventoryinfos(@Param("vk")Vknifeinventoryinfo v);

	// 新增库存信息
	void insertKnifeinventory(@Param("kn")Knifeinventory knifeinventory);

	// 查询当前刀具标准是否初始化
	Vknifeinventoryinfo getIsHasToolInit(@Param("v")Vknifeinventoryinfo v);

	// 删除筒刀表
	void deleteTubedetailinfo(@Param("tu")Tubedetailinfo tubedetailinfo);

	// 根据rfid清除原RFID标签信息
	void deleteTubedetailinfoByRFID(@Param("rfidID")String rfidID);

	// 查询当前标签筒刀详细
	List<Tubedetailinfo> getTubedetailinfoListBySPCode(@Param("spCode")String spCode,
			@Param("rfid")String rfid);

	// 新增流转统计表数据
	void insertTooltransferTotalInfo(@Param("tst")TooltransferTotal tst);

	// 清除原筒刀的RFID
	void updateTubedetailinfoRfidEmpty(@Param("rfidID")String rfidID);

	// 查询刀具参数
	List<Synthesiscutterlocation> searchSynthesiscutterlocationByRfid(@Param("rfidID")
			String rfidID);

	// 查询筒刀组成刀具list
	List<SynthesisEntity> getTubedetailinfoList(@Param("tubeInfo")Tubedetailinfo entity);

	// 查询授权开关信息
	Onoff searchOnoffByBusinessID(@Param("businessID")String string);

	List<SynthesisEntity> searchReplaceTool(@Param("toolCode")String toolCode,@Param("synthesisParametersCode")String synthesisParametersCode);

}
