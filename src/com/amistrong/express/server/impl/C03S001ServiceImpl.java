package com.amistrong.express.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.amistrong.express.dao.C01S003Dao;
import com.amistrong.express.dao.C03S001Dao;
import com.amistrong.express.server.C03S001Service;

/**
 * 合成刀初始化ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
public class C03S001ServiceImpl implements C03S001Service {

	@Autowired
	private C03S001Dao c03S001Dao;
	@Autowired
	private C01S003Dao c01S003Dao;

	/**
	 * 查询已经有的合成刀具信息
	 */
	public List<Synthesisknife> findskListByRfidList(String rfidCode) {
		List<Synthesisknife> list = c03S001Dao.findskListByRfidList(rfidCode);
		return list;
	}

	/**
	 * 删除流转中的数据
	 */
	public void updateBatchDeFlagByRfid(Rfidcontainer rfBean) {
		c03S001Dao.updateBatchDeFlagByRfid(rfBean);

	}

	/**
	 * 删除合成刀库中的数据
	 */
	public void updateSynthesisknifeDeFlag(Synthesisknife sk1) {
		c03S001Dao.updateSynthesisknifeDeFlag(sk1);

	}

	/**
	 * 取得当前合成刀具组成
	 */
	public List<Synthesisparameters> searchSynthesisparameters(
			Synthesisparameters synthesisparameters) {
		List<Synthesisparameters> list = c03S001Dao
				.searchSynthesisparameters(synthesisparameters);
		return list;
	}

	/**
	 * 为刀具生命周期查询零部件id
	 */
	public List<Oplink> searchOplink(Oplink oplink) {
		List<Oplink> list = c03S001Dao.searchOplink(oplink);
		return list;
	}

	/**
	 * 查询刀具位置信息
	 */
	public List<Synthesiscutterlocation> searchSynthesiscutterlocation(
			Synthesiscutterlocation synthesiscutterlocation) {
		List<Synthesiscutterlocation> list = c03S001Dao
				.searchSynthesiscutterlocation(synthesiscutterlocation);
		return list;
	}

	/**
	 * 新建载体数据
	 */
	public void insertRfidcontainer(Rfidcontainer rfidcontainer) {
		c03S001Dao.insertRfidcontainer(rfidcontainer);

	}

	/**
	 * 更新载体数据
	 */
	public void updateRfidcontainer(Rfidcontainer entity) {
		c03S001Dao.updateRfidcontainer(entity);

	}

	@Override
	public void insertTooltransfer(List<Tooltransfer> inputList) {
		for (int i = 0; i < inputList.size(); i++) {
			c01S003Dao.insertTooltransfer(inputList.get(i));
		}

	}

	/**
	 * 取得合成刀具序号
	 */
	public Synthesisknife searchBySynthesisknife(Synthesisknife entity) {
		Synthesisknife bean = c03S001Dao.searchBySynthesisknife(entity);
		return bean;
	}

	/**
	 * 新增合成刀库数据
	 */
	public void insertSynthesisknife(List<Synthesisknife> synthesisknifes) {
		for (int i = 0; i < synthesisknifes.size(); i++) {
			c03S001Dao.insertSynthesisknife(synthesisknifes.get(i));
		}

	}

	/**
	 * 查询刀具信息
	 */
	public Tool searchTool(Tool tool) {
		Tool bean = c03S001Dao.searchTool(tool);
		return bean;
	}

	/**
	 * 新增刀具全生命周期表
	 */
	public void insertToolwholelifecycle(
			List<Toolwholelifecycle> toolwholelifecycles) {
		for (int i = 0; i < toolwholelifecycles.size(); i++) {
			c03S001Dao.insertToolwholelifecycle(toolwholelifecycles.get(i));
		}

	}

	/**
	 * 根据载体ID查询合成刀具编码
	 */
	public Synthesisknife getSynCodeByRfidConner(Synthesisknife skentity) {
		Synthesisknife bean = c03S001Dao.getSynCodeByRfidConner(skentity);
		return bean;
	}

	/**
	 * 查询合成刀组成刀具list
	 */
	public List<SynthesisEntity> getSynthesisToolListBySPCode(String synthesisParametersCode) {
		List<SynthesisEntity> list = c03S001Dao.getSynthesisToolListBySPCode(synthesisParametersCode);
		for (SynthesisEntity entity : list) {

		}
		return list;
	}

	@Override
	public List<SynthesisEntity> getSynthesisToolListBySPCodeAndConfCode(String synthesisParametersCode, String configurationCode) {
		return c03S001Dao.getSynthesisToolListBySPCodeAndConfCode(synthesisParametersCode,configurationCode);
	}

	/**
	 * 查询刀具组成信息
	 */
	public List<Synthesiscutterlocation> getSynthesiscutterlocation(
			String synthesisparametersID) {
		List<Synthesiscutterlocation> list = c03S001Dao
				.getSynthesiscutterlocation(synthesisparametersID);
		return list;
	}

	/**
	 * 新增筒刀数据
	 */
	public void insertTubedetailinfo(List<Tubedetailinfo> tubedetailinfoList) {
		for (int i = 0; i < tubedetailinfoList.size(); i++) {
			c03S001Dao.insertTubedetailinfo(tubedetailinfoList.get(i));
		}

	}

	/**
	 * 根据材料号查询库存信息
	 */
	public Vknifeinventoryinfo getknifeinventoryinfos(Vknifeinventoryinfo v) {
		Vknifeinventoryinfo bean = c03S001Dao.getknifeinventoryinfos(v);
		return bean;
	}

	/**
	 * 新增库存信息
	 */
	public void insertKnifeinventory(Knifeinventory knifeinventory) {
		c03S001Dao.insertKnifeinventory(knifeinventory);

	}

	/**
	 * 查询当前刀具标准是否初始化
	 */
	public Vknifeinventoryinfo getIsHasToolInit(Vknifeinventoryinfo v) {
		Vknifeinventoryinfo bean = c03S001Dao.getIsHasToolInit(v);
		return bean;
	}

	/**
	 * 根据rfid清除原RFID标签信息
	 */
	public void deleteTubedetailinfoByRFID(String rfidID) {
		c03S001Dao.deleteTubedetailinfoByRFID(rfidID);

	}

	/**
	 * 查询当前标签筒刀详细
	 */
	public List<Tubedetailinfo> getTubedetailinfoListBySPCode(String spCode,
			String rfid) {
		List<Tubedetailinfo> list = c03S001Dao.getTubedetailinfoListBySPCode(
				spCode, rfid);
		return list;
	}

	/**
	 * 新增流转统计表数据
	 */
	public void insertTooltransferTotalInfo(TooltransferTotal tst) {
		c03S001Dao.insertTooltransferTotalInfo(tst);

	}

	/**
	 * 清除原筒刀的RFID
	 */
	public void updateTubedetailinfoRfidEmpty(String rfidID) {
		c03S001Dao.updateTubedetailinfoRfidEmpty(rfidID);

	}

	/**
	 * 查询刀具参数
	 */
	public List<Synthesiscutterlocation> searchSynthesiscutterlocationByRfid(
			String rfidID) {
		List<Synthesiscutterlocation> list = c03S001Dao
				.searchSynthesiscutterlocationByRfid(rfidID);
		return list;
	}

	/**
	 * 查询筒刀组成刀具list
	 */
	public List<SynthesisEntity> getTubedetailinfoList(Tubedetailinfo entity) {
		List<SynthesisEntity> list = c03S001Dao.getTubedetailinfoList(entity);
		return list;
	}

	/**
	 * 查询授权开关信息
	 */
	public Onoff searchOnoffByBusinessID(String string) {
		Onoff of = c03S001Dao.searchOnoffByBusinessID(string);
		return of;
	}
}
