package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.Outsidefactory;
import com.amistrong.express.beans.response.Outsidefactoryhistory;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.ToolDurable;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S003Service;
import com.amistrong.express.server.C01S005Service;
import com.amistrong.express.server.C01S008Service;
import com.amistrong.express.server.C01S017Service;
import com.amistrong.express.server.C03S001Service;

/**
 * 回厂确认
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Controller
public class C01S017Controller extends BaseController {

	@Autowired
	private C01S017Service c01S017Service;

	// 注入(Spring提供的) 默认按类型装配
	@Autowired
	private C01S001Service c01S001Service;

	@Autowired
	private C01S003Service c01S003Service;

	@Autowired
	private C01S005Service c01S005Service;

	@Autowired
	private C03S001Service c03S001Service;

	@Autowired
	private C01S008Service c01S008Service;

	/**
	 * 输入材料号取得非单品回厂刀具信息
	 * 
	 * @param
	 * @return
	 * @throws SQLException
	 */
	@ResponseBody
	@RequestMapping(value = "/getFBackFactoryToolInfo", method = RequestMethod.POST)
	public String getFBackFactoryToolInfo(String materialNum) throws Exception {
		String cJsonStr;
		try {
			// 参数验证
			if (null == materialNum || "".equals(materialNum)) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}

			Tool entity = new Tool();
			// 刀具编码(材料号)
			entity.setToolCode(materialNum);
			// 验证是否为非单品
			Tool tool = c01S001Service.searchBitInputInf(entity);
			if (null == tool.getToolID()) {
				cJsonStr = jsonResult(false, "未找到该材料信息");
				return cJsonStr;
			}

			Outsidefactory bean = new Outsidefactory();
			// 材料号
			bean.setMaterialNum(materialNum);
			// 修复状态(0.待出厂1.已出厂2.已送回）
			bean.setRepairState("1");
			// 根据材料号查询非单品回厂修复信息
			Outsidefactory outsidefactoryInfo = c01S017Service
					.getFOutsidefactory(bean);
			if (outsidefactoryInfo == null) {
				// 查无补领申请
				cJsonStr = jsonResult(false, "无厂外修复信息");
				return cJsonStr;
			} else {
				cJsonStr = jsonResult(outsidefactoryInfo);
				return cJsonStr;
			}
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 扫码取得单品回厂刀具信息
	 * 
	 * @param
	 * @return
	 * @throws SQLException
	 */
	@ResponseBody
	@RequestMapping(value = "/getBackFactoryToolInfo", method = RequestMethod.POST)
	public String getBackFactoryToolInfo(String rfidCode) throws Exception {
		String cJsonStr;
		try {
			// 参数验证
			if (null == rfidCode || "".equals(rfidCode)) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}

			// Tool entity = new Tool();
			// // 刀具编码(材料号)
			// entity.setRfidCode(rfidCode);
			// // 验证是否为单品
			// Tool tool = c01S001Service.searchBitInputInf(entity);
			// if (!"0".equals(tool.getToolType())) {
			// cJsonStr = jsonResult(false, "请输入单品的材料号");
			// return cJsonStr;
			// }
			Rfidcontainer rfidcontainer = new Rfidcontainer();
			String rfid = null;
			// RFID标签有效验证
			rfidcontainer = c01S001Service.getRfidContainerByRfidCode(rfidCode);
			if (rfidcontainer == null) {
				cJsonStr = jsonResult(false, "当前标签未初始化");
				return cJsonStr;
			} else if ((!"2".equals(rfidcontainer.getQueryType()))) {

			} else {
				// RFID取得
				rfid = rfidcontainer.getRfidContainerID();
			}

			// 根据载体ID查询合成刀具编码
			Synthesisknife skentity = new Synthesisknife();
			// 载体ID
			skentity.setrFID(rfid);
			Synthesisknife reVal = c03S001Service
					.getSynCodeByRfidConner(skentity);
			if (null == reVal) {
				cJsonStr = jsonResult(false, "未找到合成刀数据");
				return cJsonStr;
			} else {
				// 非一体刀
				if (!"4".equals(reVal.getCreateType())) {
					cJsonStr = jsonResult(false, "该标签非一体刀标签");
					return cJsonStr;
				}
			}

			// Outsidefactory bean = new Outsidefactory();
			// // 材料号
			// bean.setMaterialNum(toolCode);
			// // 修复状态(0.待出厂1.已出厂2.已送回）
			// bean.setRepairState("1");
			// 根据材料号查询单品回厂修复信息
			List<Outsidefactory> outsidefactoryInfoList = c01S017Service
					.getOutsidefactoryListByLaserCode(rfidcontainer
							.getLaserIdentificationCode());
			if (outsidefactoryInfoList.size() == 0) {
				// 查无补领申请
				cJsonStr = jsonResult(false, "无厂外修复信息");
				return cJsonStr;
			} else {
				outsidefactoryInfoList.get(0).setRfidContainerID(rfid);
				outsidefactoryInfoList.get(0).setLaserCode(
						rfidcontainer.getLaserIdentificationCode());
				cJsonStr = jsonResult(outsidefactoryInfoList.get(0));
			}
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 提交回厂刀具信息
	 * 
	 * @param
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
	@RequestMapping(value = "/saveFBackFactoryToolInfo", method = RequestMethod.POST)
	public String saveFBackFactoryToolInfo(String backFactoryJsonList)
			throws Exception {
		String cJsonStr;
		try {
			// Map<String, Object> result = new HashMap<String, Object>();
			JSONArray objData = new JSONArray(backFactoryJsonList); // 获取data字段
			List<Map> backFactoryList = new ArrayList<Map>();
			for (int i = 0; i < objData.length(); i++) {
				Map map = new HashMap<String, Object>();
				// 刀具ID
				String toolID = objData.getJSONObject(i).get("toolID")
						.toString();
				map.put("toolID", toolID);
				// 刀具类型（0.非单品1.合成刀)
				String toolType = objData.getJSONObject(i).get("toolType")
						.toString();
				map.put("toolType", toolType);
				// 回厂数量
				String backCount = objData.getJSONObject(i).get("backCount")
						.toString();
				map.put("backCount", backCount);
				// 用户ID
				String customerID = objData.getJSONObject(i).get("customerID")
						.toString();
				map.put("customerID", customerID);
				// 授权人id
				// String gruantUserID = objData.getJSONObject(i)
				// .get("gruantUserID").toString();
				// map.put("gruantUserID", gruantUserID);
				// RFID标签ID
				String rfidContainerID = objData.getJSONObject(i)
						.get("rfidContainerID").toString();
				map.put("rfidContainerID", rfidContainerID);
				// 材料号
				String materialNum = objData.getJSONObject(i)
						.get("materialNum").toString();
				map.put("materialNum", materialNum);
				// 激光码
				String laserCode = objData.getJSONObject(i).get("laserCode")
						.toString();
				map.put("laserCode", laserCode);
				// 出门单号
				String outDoorNom = objData.getJSONObject(i).get("outDoorNom")
						.toString();
				map.put("outDoorNom", outDoorNom);
				backFactoryList.add(map);
			}

			// 出库总数量
			int countA = 0;
			// 优先处理的换领申请单的领取数量
			int countB = 0;
			// 优先处理的换领申请单的申请数量
			int countC = 0;
			// 保存出库总数量
			int countD = 0;
			List<Outsidefactory> outsidefactoryList = new ArrayList<Outsidefactory>();
			for (Map map : backFactoryList) {
				String userID = map.get("customerID").toString();
				// 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀具9其他
				// String toolConsumetype = map.getToolType();
				// 刀具id
				// String toolID = map.get("toolID").toString();
				// rfidCode
				// String rfidCode = bean.getRfidCode();
				// 回厂数量
				countA = Integer
						.parseInt(map.get("backCount").toString() == null ? "0"
								: map.get("backCount").toString());
				countD = countA;
				if (countA > 0) {
					Outsidefactory entity = new Outsidefactory();
					entity.setOutDoorNom(map.get("outDoorNom").toString());

					// 回厂一体刀的场合
					if ("1".equals(map.get("toolType"))) {
						Synthesisknife sk = new Synthesisknife();
						// todo 更新条件 - RFID
						sk.setrFID(map.get("rfidContainerID").toString());
						// 使用状态 - 使用状态8:已回厂
						sk.setLoadState("8");
						sk.setBusinessFlowLnkID("C01S017");
						// 更新者
						sk.setUpdateUser(map.get("customerID").toString());
						// 更新合成刀库表使用状态
						c01S008Service.updateSynthesisknife(sk);
						// // 根据激光码查询回厂信息
						// outsidefactoryList = c01S017Service
						// .getOutsidefactoryListByLaserCode(map);
						entity.setLaserCode(map.get("laserCode").toString());
						// 回厂材料的场合
					} else {
						entity.setMaterialNum(map.get("materialNum").toString());
					}

					// 根據出门单号取得回厂信息
					outsidefactoryList = c01S017Service
							.getOutsidefactoryList(entity);

					// 优先处理的厂外修复的领取数量
					countB = Integer.parseInt(outsidefactoryList.get(0)
							.getReceiveNumber() == null ? "0"
							: outsidefactoryList.get(0).getReceiveNumber()
									.toString());
					// 优先处理的换厂外修复的出厂数量
					countC = Integer.parseInt(outsidefactoryList.get(0)
							.getNumberGrinding() == null ? "0"
							: outsidefactoryList.get(0).getNumberGrinding()
									.toString());

					if (outsidefactoryList.size() > 0) {
						// 只处理一张换领申请单就足够了
						Outsidefactory ra = new Outsidefactory();
						// 更新条件：厂外修复ID
						ra.setOutsideFactoryID(outsidefactoryList.get(0)
								.getOutsideFactoryID());
						// 领取数量
						ra.setReceiveNumber(new BigDecimal(countA + countB));
						// 操作人
						ra.setUpdateUser(userID);
						// 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
						// ra.setProcessingStatus("0");
						if (countA + countB == countC) {
							// 修复状态(0.待出厂1.已出厂2.已送回）
							ra.setRepairState("2");
							// ra.setDelFlag("1");
						}
						// 更新换厂外修复表
						c01S017Service.updateOutsidefactory(ra);
						Outsidefactoryhistory outHis = new Outsidefactoryhistory();
						// 厂外修复履历ID
						outHis.setID(getId());
						// 通知单号
						outHis.setOrderNum(outsidefactoryList.get(0)
								.getOrderNum());
						// 出门单号
						outHis.setOutDoorNum(outsidefactoryList.get(0)
								.getOutDoorNom());
						// 商家ID
						outHis.setMerchantsID(outsidefactoryList.get(0)
								.getMerchantsID());
						// 刀具ID
						outHis.setToolID(outsidefactoryList.get(0).getToolID());
						if ("1".equals(map.get("toolType"))) {
							// 材料号
							outHis.setMaterialNum(map.get("laserCode")
									.toString());
						} else {
							// 材料号
							outHis.setMaterialNum(outsidefactoryList.get(0)
									.getMaterialNum());
						}

						// 回厂数量
						outHis.setBackFactoryNumber(countA);
						// 操作者
						outHis.setCreateUser(userID);
						// 插入厂外修复履历数据
						c01S017Service.insertOutsidefactoryHistory(outHis);
						// 出库数量变为0
						countA = 0;
					} else {
						cJsonStr = jsonResult(false, "刀具回厂失败");
						return cJsonStr;
					}
				}

				// 根据一体刀对应的材料号查询流转统计表数据
				TooltransferTotal tst2 = c01S005Service
						.getTooltransferTotalInfoByToolCode(map.get(
								"materialNum").toString());
				if (null != tst2) {
					// 更新条件-刀具材料号
					tst2.setToolCode(map.get("materialNum").toString());
					// 新备刀数量 = 当前备刀数量+回厂数量
					tst2.setSpareKnifeSum(tst2.getSpareKnifeSum() + countD);
					// 新厂外修磨 = 当前厂外修磨数-回厂数量
					tst2.setExternalGrindingSum(tst2.getExternalGrindingSum()
							- countD);
					tst2.setUpdateUser(userID);
					// 更新流转统计表数据
					c01S005Service.updateTooltransferTotalInfo(tst2);
				}

				// 刀具为一体刀的场合
				if ("1".equals(map.get("toolType"))) {
					Tooltransfer ttEntity = new Tooltransfer();
					ttEntity.setRfidContainerID(map.get("rfidContainerID")
							.toString());
					ttEntity.setToolID(map.get("toolID").toString());
					ttEntity.setDelFlag("0");
					List<Tooltransfer> ttList = c01S003Service
							.searchTooltransferList(ttEntity);
					if (ttList.size() > 0) {

						Tooltransfer tt = new Tooltransfer();
						// 更新者
						tt.setUpdateUser(map.get("customerID").toString());
						// 最后执行业务流程
						tt.setBusinessFlowLnkID("C01S017");
						// tt.setStockState("4");
						tt.setToolState("8");
						// tt.setInstallationState("1");
						// 更新条件
						tt.setRfidContainerID(map.get("rfidContainerID")
								.toString());
						tt.setDelFlag("0");
						tt.setToolID(map.get("toolID").toString());

						// 更新流转表数量
						c01S003Service.updateTooltransfer(tt);
					}

				}

			}
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
			return cJsonStr;
		}

		cJsonStr = jsonResult(true);
		return cJsonStr;
	}

	/**
	 * 查询所有未回厂单号list
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getOutFactoryOutDoorNomList", method = RequestMethod.POST)
	public String getOutFactoryOutDoorNomList() throws Exception {
		String cJsonStr;
		try {

			// 查询所有未回厂单号list
			List<Outsidefactory> outDoorNomList = c01S017Service
					.getOutFactoryOutDoorNomList();
			if (outDoorNomList.size() == 0) {
				cJsonStr = jsonResult(false, "没有找到厂外修复信息");
				return cJsonStr;
			}
			cJsonStr = jsonResult(outDoorNomList);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 根据单号查厂外修复信息
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getOutFactoryDescByOutDoorNom", method = RequestMethod.POST)
	public String getOutFactoryDescByOutDoorNom(String outDoorNom)
			throws Exception {
		String cJsonStr;
		try {

			// 查询所有未回厂单号list
			List<Outsidefactory> outFactoryDescList = c01S017Service
					.getOutFactoryDescByOutDoorNom(outDoorNom);
			if (outFactoryDescList.size() == 0) {
				cJsonStr = jsonResult(false, "没有找到厂外修复信息");
				return cJsonStr;
			}
			cJsonStr = jsonResult(outFactoryDescList);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

}
