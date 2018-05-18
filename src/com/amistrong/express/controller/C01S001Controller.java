package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.request.SaveToolBean;
import com.amistrong.express.beans.response.C01S001Respons;
import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.ProcuredBatchCount;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.SapUploadhistory;
import com.amistrong.express.beans.response.Storagerecord;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toolprocured;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.sap.HanaJDBCCon;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S003Service;

/**
 * 新刀入库
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Controller
public class C01S001Controller extends BaseController {
	// 注入(Spring提供的) 默认按类型装配
	@Autowired
	private C01S001Service c01S001Service;

	@Autowired
	private C01S003Service c01S003Service;

	HanaJDBCCon hana = new HanaJDBCCon();

	/**
	 * 扫描库位标签取得入库的刀具信息
	 * 
	 * @param (String)rfidCode：RFID
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/getToolInfoByRfid", method = RequestMethod.POST)
	public String getToolInfoByRfid(String rfidCode) {
		String cJsonStr;
		try {

			C01S001Respons respons = new C01S001Respons();
			try {
				// 参数验证
				if (null == rfidCode || "".equals(rfidCode)) {
					cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
					return cJsonStr;
				}
				// 验证RFID标签是否存在
				Rfidcontainer rfidcontainer = c01S001Service
						.getRfidContainerByRfidCode(rfidCode);
				if (rfidcontainer == null) {
					respons.setCode("0");
					cJsonStr = jsonResult(false, "当前标签未初始化", respons);
					return cJsonStr;
				} else if ((!"0".equals(rfidcontainer.getQueryType()))) {
					respons.setCode("0");
					cJsonStr = jsonResult(false, "该标签不是库位标签", respons);
					return cJsonStr;
				} else {
					/*
					 * // 标签类型
					 * respons.setQueryType(rfidcontainer.getQueryType());
					 */
					// 刀具id
					// String toolId = null;
					// 刀具类型
					String toolType = null;
					// 材料号(刀具编码)
					String toolCode = null;
					// 库位码
					String libraryCodeID = null;
					// 判断新刀入库表是否有数据
					/*
					 * Knifeinventory ki = new Knifeinventory();
					 * ki.setRfidContainerID
					 * (rfidcontainer.getRfidContainerID()); ki.setDelFlag("0");
					 * List<Knifeinventory> kiList = c01S001Service
					 * .getKnifeinventoryInfo(ki); if (kiList.size() < 1) { //
					 * 判断刀具流转表是否有数据 Tooltransfer tt = new Tooltransfer();
					 * tt.setRfidContainerID(rfidcontainer
					 * .getRfidContainerID()); tt.setDelFlag("0");
					 * List<Tooltransfer> ttList = c01S001Service
					 * .getTooltransferInfo(tt); if (ttList.size() < 0) { //
					 * 新刀库存表和刀具流转表都没有数据 cJsonStr = jsonResult(false,
					 * "该标签没有对应的刀具信息"); return cJsonStr; } else { //
					 * 刀具流转表中有数据，取得刀具id toolId = ttList.get(0).getToolID(); } }
					 * else { // 新刀入库表中有数据 // 刀具id toolId =
					 * kiList.get(0).getToolID(); }
					 */

					/*
					 * if (toolId == null) { cJsonStr = jsonResult(false,
					 * "未找到对应的刀具id"); return cJsonStr; }
					 */
					// 根据RFID取得刀具信息
					Tool tool = new Tool();
					// tool.setToolID(toolId);
					tool.setRfidContainerID(rfidcontainer.getRfidContainerID());
					List<Tool> toolList = c01S001Service.getToolInfo(tool);
					if (toolList.size() < 1) {
						respons.setCode("0");
						cJsonStr = jsonResult(false, "刀具信息不存在", respons);
						return cJsonStr;
					}
					tool = toolList.get(0);
					// 刀具类型
					toolType = tool.getToolConsumetype();
					// 刀具id
					respons.setToolID(tool.getToolID());
					// 材料号(刀具编码)
					toolCode = tool.getToolCode();
					respons.setMaterialNum(toolCode);
					// 库位码
					libraryCodeID = tool.getLibraryCodeID();
					respons.setLibraryCodeID(libraryCodeID);

					// 在新刀库存表中统计库存量
					Knifeinventory ki2 = new Knifeinventory();
					ki2.setToolID(tool.getToolID());
					List<Knifeinventory> kiList2 = c01S001Service
							.getKnifeinventoryInfo(ki2);
					if (kiList2.size() < 1) {
						// 库存量为0
						respons.setUnitnumber("0");
					} else {
						// if ("0".equals(toolType)) {
						// // 钻头的库存量
						// respons.setUnitnumber(kiList2.size() + "");
						// } else {
						// // 刀片的库存量
						// int sum = 0;
						// for (Knifeinventory knifeinventory : kiList2) {
						// sum = sum
						// + Integer.parseInt(knifeinventory
						// .getKnifelnventoryNumber());
						// }
						// respons.setUnitnumber(sum + "");
						// }
						respons.setUnitnumber(kiList2.get(0)
								.getKnifelnventoryNumber());
					}

					// Toolprocured toolprocured = new Toolprocured();
					// // 材料号
					// toolprocured.setToolCode(toolCode);
					//
					// // 获取可用批次
					// List<Toolprocured> toolprocureds = c01S001Service
					// .getProcuredBatchList(toolprocured);
					//
					// if (toolprocureds == null || toolprocureds.size() <= 0) {
					// respons.setCode("1");
					// respons.setProcuredBatchCount(new
					// ArrayList<ProcuredBatchCount>());
					// cJsonStr = jsonResult(false, "系统无可用入库批次",respons);
					// return cJsonStr;
					// }

					List<ProcuredBatchCount> pbcList = new ArrayList<ProcuredBatchCount>();
					// if (pbcList.size() == 0) {
					// respons.setCode("1");
					// respons.setProcuredBatchCount(new
					// ArrayList<ProcuredBatchCount>());
					// cJsonStr = jsonResult(false, "系统无可用入库批次", respons);
					// return cJsonStr;
					// }
					String selSapsql = "select * from IS_HBN24829.V_Z_DHGZ where MATNR = "
							+ toolCode + " and MENGE_EK > MENGE_EZ";

					List list = hana.getData(selSapsql);

					if (list.size() == 0) {
						respons.setCode("1");
						respons.setProcuredBatchCount(new ArrayList<ProcuredBatchCount>());
						cJsonStr = jsonResult(false, "系统无可用入库批次", respons);
						return cJsonStr;
					}
					for (int i = 0; i < list.size(); i++) {
						ProcuredBatchCount pbc = new ProcuredBatchCount();
						Map map = (Map) list.get(i);
						pbc.setToolsOrdeNO(map.get("EBELN").toString());// 采购订单号
						pbc.setProcuredCount(map.get("MENGE_EK").toString());//
						// 采购数量
						pbcList.add(pbc);
					}
					respons.setProcuredBatchCount(pbcList);
				}
			} catch (Exception e) {
				// 系统错误,999
				cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
				return cJsonStr;
			}
			cJsonStr = jsonResult(respons);
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 根据输入的材料号取得要入库的刀具信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getToolInfoByToolCode", method = RequestMethod.POST)
	public String getToolInfoByToolCode(String materialNum) throws Exception {
		String cJsonStr;
		C01S001Respons respons = new C01S001Respons();
		Tool entity = new Tool();
		try {
			// 参数验证
			if (null == materialNum || "".equals(materialNum)) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}
			// 刀具编码
			entity.setToolCode(materialNum);
			String toolId = "";
			String toolCode = "";
			// 根据刀具码查询刀具信息
			Tool tool = c01S001Service.searchBitInputInf(entity);
			if (tool.getToolCode() == null) {
				if (materialNum.indexOf("/") != -1) {
					String tCode = materialNum.split("/")[0];
					entity.setToolCode(tCode);
					Tool tool2 = c01S001Service.searchBitInputInf(entity);
					if (tool2.getToolCode() == null) {
						respons.setCode("0");
						cJsonStr = jsonResult(false, "未找到相应的材料号信息", respons);
						return cJsonStr;
					} else {
						toolId = tool2.getToolID();
						toolCode = tool2.getToolCode();
					}
				} else {

					respons.setCode("0");
					cJsonStr = jsonResult(false, "未找到相应的材料号信息", respons);
					return cJsonStr;
				}
			} else {
				toolId = tool.getToolID();
				toolCode = tool.getToolCode();
			}
			// 刀具消耗类别(0:钻头,非0:刀片)
			// String toolConsumetype = tool.getToolConsumetype();

			// 材料号
			respons.setMaterialNum(toolCode);
			// 库位码
			respons.setLibraryCodeID(tool.getLibraryCodeID());
			// 在新刀库存表中统计库存量
			Knifeinventory ki2 = new Knifeinventory();
			ki2.setToolID(toolId);
			List<Knifeinventory> kiList2 = c01S001Service
					.getKnifeinventoryInfo(ki2);
			if (kiList2.size() < 1) {
				// 库存量为0
				respons.setUnitnumber("0");
			} else {
				// if ("0".equals(toolConsumetype)) {
				// // 钻头的库存量
				// respons.setUnitnumber(kiList2.size() + "");
				// } else {
				// // 刀片的库存量
				// int sum = 0;
				// for (Knifeinventory knifeinventory : kiList2) {
				// sum = sum
				// + Integer.parseInt(knifeinventory
				// .getKnifelnventoryNumber());
				// }
				respons.setUnitnumber(kiList2.get(0).getKnifelnventoryNumber());
				// }
			}

			// 刀具ID
			respons.setToolID(toolId);

			// Toolprocured toolprocured = new Toolprocured();
			// toolprocured.setToolCode(tool.getToolCode());
			// // 获取可用批次
			// List<Toolprocured> toolprocureds = c01S001Service
			// .getProcuredBatchList(toolprocured);
			// if (toolprocureds.size() <= 0) {
			// respons.setCode("1");
			// respons.setProcuredBatchCount(new
			// ArrayList<ProcuredBatchCount>());
			// cJsonStr = jsonResult(false, "系统无可用入库批次",respons);
			// return cJsonStr;
			// }
			List<ProcuredBatchCount> pbcList = new ArrayList<ProcuredBatchCount>();
			if (pbcList.size() == 0) {
				respons.setCode("1");
				respons.setProcuredBatchCount(new ArrayList<ProcuredBatchCount>());
				cJsonStr = jsonResult(false, "系统无可用入库批次", respons);
				return cJsonStr;
			}
			// String selSapsql =
			// "select * from IS_HBN24829.V_Z_DHGZ where MATNR = "
			// + materialNum + " and MENGE_EK > MENGE_EZ";
			//
			// List list = hana.getData(selSapsql);
			// if(list.size() == 0){
			// respons.setCode("1");
			// respons.setProcuredBatchCount(new
			// ArrayList<ProcuredBatchCount>());
			// cJsonStr = jsonResult(false, "系统无可用入库批次",respons);
			// return cJsonStr;
			// }
			//
			// for(int i = 0 ;i < list.size();i++){
			// ProcuredBatchCount pbc = new ProcuredBatchCount();
			// Map map = (Map)list.get(i);
			// pbc.setToolsOrdeNO(map.get("EBELN").toString());// 采购订单号
			// pbc.setProcuredCount(map.get("MENGE_EK").toString());// 采购数量
			// pbcList.add(pbc);
			// }
			respons.setProcuredBatchCount(pbcList);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
			return cJsonStr;
		}
		cJsonStr = jsonResult(respons);
		return cJsonStr;
	}

	/**
	 * 提交刀片入库信息
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveToolInputInfo", method = RequestMethod.POST)
	public String saveToolInputInfo(SaveToolBean bean) throws Exception {
		String cJsonStr;
		Knifeinventory knifeinventory = new Knifeinventory();
		String userID = bean.getCustomerID();
		// 订单号
		String toolsOrdeNO = bean.getToolsOrdeNO();
		try {
			// 判断入库的刀片是否有对应的库位标签
			// 刀具ID
			knifeinventory.setToolID(bean.getToolID());
			List<Knifeinventory> kList = c01S001Service
					.getKnifeinventoryInfo(knifeinventory);
			if (kList.size() <= 0) {
				// 没有找到对应的库位标签，不能入库
				cJsonStr = jsonResult(false, "入库的刀具没有对应的标签，请先进行库位标签初始化");
				return cJsonStr;
			}
			// 获取该刀具原有的在库数量
			String number = kList.get(0).getKnifelnventoryNumber();
			// 获取载体id作为更新条件
			String rfidcontainerId = kList.get(0).getRfidContainerID();
			knifeinventory.setRfidContainerID(rfidcontainerId);
			// 库存数量
			knifeinventory.setKnifelnventoryNumber((Integer.parseInt(bean
					.getStorageNum()) + Integer.parseInt(number)) + "");
			// 更新者
			knifeinventory.setUpdateUser(userID);

			// 更新新刀库存表表
			c01S001Service.updateKnifeinventory(knifeinventory);

			if (null != toolsOrdeNO && !"".equals(toolsOrdeNO)) {
				// 更新采购数量
				Toolprocured toolprocured = new Toolprocured();
				toolprocured.setToolCode(bean.getMaterialNum());// 材料号
				toolprocured.setToolsOrdeNO(toolsOrdeNO);// 订单号
				List<Toolprocured> tpList = c01S001Service
						.getProcuredBatchList(toolprocured);
				if (tpList.size() > 0) {
					// 获取采购但未入库的剩余刀具数量
					BigDecimal count = tpList.get(0).getProcuredCount();

					// 数量相减
					toolprocured.setProcuredCount(count
							.subtract(new BigDecimal(bean.getStorageNum())));
					// 是否入库的状态变为是
					toolprocured.setProcuredInto("0");
					// 如果采购数量为0，将该采购单逻辑删除
					if (count.subtract(new BigDecimal(bean.getStorageNum()))
							.intValue() == 0) {
						toolprocured.setDelFlag("1");
					}
					// 更新者
					toolprocured.setUpdateUser(userID);
					// 更新采购表
					c01S001Service.updateToolprocured(toolprocured);
				}
			}

			// 新建入库履历
			Storagerecord storagerecord = new Storagerecord();
			// 入库履历id
			storagerecord.setStorageID(getId());
			// 刀具id
			storagerecord.setToolID(bean.getToolID());
			// 材料号
			storagerecord.setToolCode(bean.getMaterialNum());
			// 刀具类型
			storagerecord.setStorageType(String.valueOf(bean.getMaterialNum()
					.charAt(0)));
			// 订单号
			storagerecord.setToolsOrdeNO(toolsOrdeNO);
			// 库存状态(新刀)
			storagerecord.setStorageState("0");
			// 刀具入库编码
			storagerecord.setKnifeInventoryCode(kList.get(0)
					.getKnifeInventoryCode());
			// 入库数量
			storagerecord.setStorageNum(new BigDecimal(bean.getStorageNum()));
			storagerecord.setDelFlag("0");
			// storagerecord.setCreateTime(new Date());
			storagerecord.setCreateUser(userID);
			// storagerecord.setUpdateTime(new Date());
			storagerecord.setUpdateUser(userID);
			c01S001Service.insertStoragerecord(storagerecord);

			// 查询sap自动上传开关是否开启
			String flg = c01S003Service.getSapOnOff();

			SapUploadhistory sap = new SapUploadhistory();
			sap.setSapID(getId());
			// 过账日期
			sap.setPstngDate(new Date());
			// 凭证日期
			sap.setDocDate(new Date());
			// 物料号
			sap.setMaterial(bean.getMaterialNum());
			// 移动类型（库存管理）101有订单入库 201出库 501 无订单入库
			if ("".equals(bean.getToolsOrdeNO())
					|| null == bean.getToolsOrdeNO()) {
				sap.setMoveType("501");
			} else {
				sap.setMoveType("101");
			}

			// 出/入库数量
			sap.setEntryQnt(bean.getStorageNum());
			// 收货/发货物料
			sap.setMoveMat(bean.getMaterialNum());
			// 成本中心
			sap.setCostCenter(bean.getCostCenter());
			// 出入库时间
			sap.setOutInDate(new Date());
			// 库管员
			sap.setOutInUser(bean.getCustomerID());
			// 开关为开启的状态
			if ("0".equals(flg)) {
				// 上传状态（0 未上传 1 已上传 2 上传失败）
				sap.setState("0");
			} else {
				sap.setState("1");
			}
			// 上传时间
			sap.setUpdateTime(new Date());
			// 创建者
			sap.setCreateUser(userID);
			// 订单号
			sap.setOrderID(bean.getToolsOrdeNO());
			// 评估类型
			sap.setValType(bean.getValType());
			// 订单序号
			sap.setPoItem(bean.getPoItem());

			// 插入sap履历信息
			c01S003Service.insetSapHisInfo(sap);

			// 入库成功！
			cJsonStr = jsonResult(true, "入库成功!");
			return cJsonStr;
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
			return cJsonStr;
		}
	}

}