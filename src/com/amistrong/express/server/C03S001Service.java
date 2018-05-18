package com.amistrong.express.server;

import java.util.List;

import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.Onoff;
import com.amistrong.express.beans.response.Oplink;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.SynthesisEntity;
import com.amistrong.express.beans.response.Synthesiscutterlocation;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Synthesisparameters;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Toolwholelifecycle;
import com.amistrong.express.beans.response.Tubedetailinfo;
import com.amistrong.express.beans.response.Vknifeinventoryinfo;

/**
 * 合成刀初始化service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C03S001Service {

	// 查询已经有的合成刀具信息
	List<Synthesisknife> findskListByRfidList(String rfidCode);

	// 删除流转中的数据
	void updateBatchDeFlagByRfid(Rfidcontainer rfBean);

	// 删除合成刀库中的数据
	void updateSynthesisknifeDeFlag(Synthesisknife sk1);

	// 取得当前合成刀具组成
	List<Synthesisparameters> searchSynthesisparameters(
			Synthesisparameters synthesisparameters);

	// 为刀具生命周期查询零部件id
	List<Oplink> searchOplink(Oplink oplink);

	// 查询刀具位置信息
	List<Synthesiscutterlocation> searchSynthesiscutterlocation(
			Synthesiscutterlocation synthesiscutterlocation);

	// 新建载体数据
	void insertRfidcontainer(Rfidcontainer rfidcontainer);

	// 更新载体数据
	void updateRfidcontainer(Rfidcontainer entity);

	// 新增刀具流转数据
	void insertTooltransfer(List<Tooltransfer> inputList);

	// 取得合成刀具序号
	Synthesisknife searchBySynthesisknife(Synthesisknife entity);

	// 新增合成刀库数据
	void insertSynthesisknife(List<Synthesisknife> synthesisknifes);

	// 查询刀具信息
	Tool searchTool(Tool tool);

	// 新增刀具全生命周期表
	void insertToolwholelifecycle(List<Toolwholelifecycle> toolwholelifecycles);

	// 根据载体ID查询合成刀具编码
	Synthesisknife getSynCodeByRfidConner(Synthesisknife skentity);

	// 查询合成刀组成刀具list
	List<SynthesisEntity> getSynthesisToolListBySPCode(
			String synthesisParametersCode);
	List<SynthesisEntity> getSynthesisToolListBySPCodeAndConfCode(
			String synthesisParametersCode,String configurationCode);

	// 查询刀具组成信息
	List<Synthesiscutterlocation> getSynthesiscutterlocation(
			String synthesisparametersID);

	// 新增筒刀数据
	void insertTubedetailinfo(List<Tubedetailinfo> tubedetailinfoList);

	// 根据材料号查询库存信息
	Vknifeinventoryinfo getknifeinventoryinfos(Vknifeinventoryinfo v);

	// 新增库存信息
	void insertKnifeinventory(Knifeinventory knifeinventory);

	// 查询当前刀具标准是否初始化
	Vknifeinventoryinfo getIsHasToolInit(Vknifeinventoryinfo v);

	// 根据rfid清除原RFID标签信息
	void deleteTubedetailinfoByRFID(String rfidID);

	// 查询当前标签筒刀详细
	List<Tubedetailinfo> getTubedetailinfoListBySPCode(
			String synthesisParametersCode, String rfid);

	// 新增流转统计表数据
	void insertTooltransferTotalInfo(TooltransferTotal tst);

	// 清除原筒刀的RFID
	void updateTubedetailinfoRfidEmpty(String rfidID);

	// 查询刀具参数
	List<Synthesiscutterlocation> searchSynthesiscutterlocationByRfid(
			String rfidID);

	// 查询筒刀组成刀具list
	List<SynthesisEntity> getTubedetailinfoList(Tubedetailinfo entity);

	// 查询授权开关信息
	Onoff searchOnoffByBusinessID(String string);

}
