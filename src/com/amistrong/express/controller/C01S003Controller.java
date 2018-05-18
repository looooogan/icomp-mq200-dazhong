package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.response.ApplyBean;
import com.amistrong.express.beans.response.C01S003Respons;
import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.Redemptionapplied;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.SapUploadhistory;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toollibraryhistory;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S003Service;
import com.amistrong.express.server.C01S005Service;
import com.amistrong.express.server.C01S008Service;

/**
 * 换领出库
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Controller
public class C01S003Controller extends BaseController {

	@Autowired
	private C01S001Service c01S001Service;

	@Autowired
	private C01S003Service c01S003Service;

	@Autowired
	private C01S005Service c01S005Service;

	@Autowired
	private C01S008Service c01S008Service;

	/**
	 * 取得要换领出库的刀具信息
	 * 
	 * @param request
	 *            (通过RFIDCode)
	 * @return
	 * @throws
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getFRedemptionapplyInfo", method = RequestMethod.POST)
	public String getFRedemptionapplyInfo(String materialNum, String rfidCode)
			throws Exception {
		String cJsonStr;
		try {
			C01S003Respons respons = new C01S003Respons();
			// Rfidcontainer entity = new Rfidcontainer();
			// 参数验证
			if ((null == rfidCode || "".equals(rfidCode))
					&& (null == materialNum || "".equals(materialNum))) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}
			Rfidcontainer rfidcontainer = new Rfidcontainer();

			String rfid = null;
			String toolType = null;
			// 扫描库位码的场合
			if (null != rfidCode && !"".equals(rfidCode)) {
				// entity.setRfidCode(rfidCode);
				// RFID标签有效验证
				rfidcontainer = c01S001Service
						.getRfidContainerByRfidCode(rfidCode);
				if (rfidcontainer == null) {
					cJsonStr = jsonResult(false, "当前标签未初始化");
					return cJsonStr;
				} else if ((!"0".equals(rfidcontainer.getQueryType()))) {
					cJsonStr = jsonResult(false, "该标签不是库位标签");
					return cJsonStr;
				} else {
					// RFID取得
					rfid = rfidcontainer.getRfidContainerID();
				}
				toolType = "0";
				// 输入材料号的场合
			} else {
				Tool entity = new Tool();
				// 刀具编码(材料号)
				entity.setToolCode(materialNum);
				// 根据刀具码查询刀具信息
				Tool tool = c01S001Service.searchBitInputInf(entity);
				if (tool.getToolCode() == null) {
					// if (materialNum.indexOf("/") != -1) {
					// String tCode = materialNum.split("/")[0];
					// entity.setToolCode(tCode);
					// Tool tool2 = c01S001Service.searchBitInputInf(entity);
					// if (tool2.getToolCode() == null) {
					// cJsonStr = jsonResult(false, "未找到相应的材料号信息", respons);
					// return cJsonStr;
					// } else {
					// rfid = tool2.getRfidContainerID();
					// toolType = tool2.getToolType();
					// }
					// } else {

					cJsonStr = jsonResult(false, "未找到相应的材料号信息", respons);
					return cJsonStr;
					// }

				} else {
					// RFID取得
					rfid = tool.getRfidContainerID();
					toolType = tool.getToolType();
				}
			}

			// 根据RFID查询库存信息
			Knifeinventory knifeinventory = c01S003Service
					.getKnifeinventoryByRfid(rfid);
			if (knifeinventory == null) {
				cJsonStr = jsonResult(false, "未找到库存信息");
				return cJsonStr;
			} else {
				// 取得要换领出库的刀具信息
				Tool tool = new Tool();
				tool.setToolID(knifeinventory.getToolID());
				tool = c01S003Service.getRedemptionapplyInfo(tool);
				if (tool == null) {
					cJsonStr = jsonResult(false, "未找到要换领出库的刀具信息");
					return cJsonStr;
				} else {
					if (null != rfidCode && !"".equals(rfidCode)) {
						if ("1".equals(tool.getToolType())) {
							respons.setRequestNum(0);
						} else {
							// 查询申请数量
							Integer requestNum = c01S003Service
									.getRequestNumByToolCode(tool.getToolCode());
							if (requestNum == null || requestNum == 0) {
								cJsonStr = jsonResult(false, "未找到刀具申请信息");
								return cJsonStr;
							}
							// 申请数量
							respons.setRequestNum(requestNum);
						}

					} else {
						if ("1".equals(tool.getToolType())) {
							respons.setRequestNum(0);
						} else {
							// 查询申请数量
							Integer requestNum = c01S003Service
									.getRequestNumByToolCode(tool.getToolCode());
							if (requestNum == null || requestNum == 0) {
								cJsonStr = jsonResult(false, "未找到刀具申请信息");
								return cJsonStr;
							}
							// 申请数量
							respons.setRequestNum(requestNum);
						}
					}

					// 新刀库存表
					Knifeinventory ki = new Knifeinventory();
					ki.setToolID(knifeinventory.getToolID());
					List<Knifeinventory> kiList = c01S001Service
							.getKnifeinventoryInfo(ki);
					if (kiList.size() == 0) {
						cJsonStr = jsonResult(false, "库存中找不到相应的刀具信息");
						return cJsonStr;
					} else {
						// 库存量
						int sum = 0;
						// if ("0".equals(tool.getToolConsumetype())) {
						// // 钻头
						// sum = kiList.size();
						// } else {
						// // 刀片
						// for (Knifeinventory ki2 : kiList) {
						// sum = sum
						// + Integer.parseInt(ki2
						// .getKnifelnventoryNumber());
						// }
						// }
						sum = Integer.valueOf(knifeinventory
								.getKnifelnventoryNumber());

						// respons.setToolType(toolType);
						respons.setRfidCode(tool.getRfidCode());
						// 刀具ID
						respons.setToolID(tool.getToolID());
						// 材料号
						respons.setMaterialNum(tool.getToolCode());
						// 库存量
						respons.setInventory(sum + "");
						// 刀具类型
						respons.setToolType(tool.getToolType());
						// 库位码
						respons.setLibraryCodeID(tool.getLibraryCodeID());
					}
				}
			}
			cJsonStr = jsonResult(respons);
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 提交换领出库的刀具信息
	 * 
	 * @param
	 * @return
	 * @throws SQLException
	 */
	@ResponseBody
	@RequestMapping(value = "/saveFRedemptionapplyInfo", method = RequestMethod.POST)
	public String saveFRedemptionapplyInfo(String redemptionApplyList,
			String costCenter) throws Exception {
		JSONArray objData = new JSONArray(redemptionApplyList); // 获取data字段
		List<ApplyBean> applyList = new ArrayList<ApplyBean>();
		for (int i = 0; i < objData.length(); i++) {
			ApplyBean bean = new ApplyBean();
			// 刀具ID
			String toolID = objData.getJSONObject(i).get("toolID").toString();
			bean.setToolID(toolID);
			// 材料号
			String materialNum = objData.getJSONObject(i).get("materialNum")
					.toString();
			bean.setMaterialNum(materialNum);
			// 申请数量
			String requestNum = objData.getJSONObject(i).get("requestNum")
					.toString();
			bean.setRequestNum(requestNum);
			// 库位码
			String libraryCodeID = objData.getJSONObject(i)
					.get("libraryCodeID").toString();
			bean.setLibraryCodeID(libraryCodeID);
			// 库存数量
			String inventory = objData.getJSONObject(i).get("inventory")
					.toString();
			bean.setInventory(inventory);
			// 刀具类型
			String toolType = objData.getJSONObject(i).get("toolType")
					.toString();
			bean.setToolType(toolType);
			// 用户ID
			String customerID = objData.getJSONObject(i).get("customerID")
					.toString();
			bean.setCustomerID(customerID);
			// 领取人
			String receiveUser = objData.getJSONObject(i).get("receiveUser")
					.toString();
			bean.setReceiveUser(receiveUser);
			// // 手持机id
			// String handSetID = objData.getJSONObject(i).get("handSetID")
			// .toString();
			// bean.setHandSetID(handSetID);
			// RFID
			String rfidCode = objData.getJSONObject(i).get("rfidCode")
					.toString();
			bean.setRfidCode(rfidCode);
			// 出库数量
			String receiveCount = objData.getJSONObject(i).get("receiveCount")
					.toString();
			bean.setReceiveCount(receiveCount);
			applyList.add(bean);
		}

		// List<ApplyBean>
		// applyList=(List<ApplyBean>)objData.toCollection(objData,
		// ApplyBean.class);
		String cJsonStr;
		try {

			// 出库总数量
			int countA = 0;
			// 优先处理的换领申请单的领取数量
			int countB = 0;
			// 优先处理的换领申请单的申请数量
			int countC = 0;
			// 保存出库总数量
			int countD = 0;

			// List<Toolwholelifecycle> twlList = new
			// ArrayList<Toolwholelifecycle>();
			for (ApplyBean bean : applyList) {
				String userID = bean.getCustomerID();
				String receiveUser = bean.getReceiveUser();

				// String signID = map.get("SignID").toString();
				// 手持机id
				// String handSetID = bean.getHandSetID();
				// 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀具9其他
				// String toolConsumetype = bean.getToolType();
				// 刀具id
				// String toolID = bean.getToolID();
				// rfidCode
				// String rfidCode = bean.getRfidCode();
				// 出库总数量
				countA = Integer.parseInt(bean.getReceiveCount() == null ? "0"
						: bean.getReceiveCount().toString());
				countD = countA;
				if (!"1".equals(bean.getToolType())) {
					while (countA > 0) {
						// 根據刀具编码(材料号)取得换领申请的信息
						List<Redemptionapplied> redempList = c01S003Service
								.getRedemptionappliedList(bean.getMaterialNum());
						// 优先处理的换领申请单的领取数量
						countB = Integer.parseInt(redempList.get(0)
								.getReceiveNumber() == null ? "0" : redempList
								.get(0).getReceiveNumber().toString());
						// 优先处理的换领申请单的申请数量
						countC = Integer.parseInt(redempList.get(0)
								.getAppliedNumber() == null ? "0" : redempList
								.get(0).getAppliedNumber().toString());

						if (redempList.size() > 0) {
							if (countA + countB <= countC) {
								// 只处理一张换领申请单就足够了
								Redemptionapplied ra = new Redemptionapplied();
								// 更新条件：换领申请流水号
								ra.setRedemptionAppliedID(redempList.get(0)
										.getRedemptionAppliedID());
								// 领取数量
								ra.setReceiveNumber(new BigDecimal(countA
										+ countB));
								// 领取人
								ra.setReceiveUser(receiveUser);
								// 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
								ra.setProcessingStatus("0");
								if (countA + countB == countC) {
									// 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
									ra.setProcessingStatus("4");
									ra.setDelFlag("1");
								}
								// 更新换领申请表
								c01S003Service.updateRedemptionapplied(ra);
								// 出库数量变为0
								countA = 0;
							} else {
								// 一张换领申请单的(申请数量-领取数量)小于出库总数量
								Redemptionapplied ra2 = new Redemptionapplied();
								// 更新条件：换领申请流水号
								ra2.setRedemptionAppliedID(redempList.get(0)
										.getRedemptionAppliedID());
								// 领取数量
								ra2.setReceiveNumber(new BigDecimal(countC));
								// 领取人
								ra2.setReceiveUser(receiveUser);
								// 处理状态((0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
								ra2.setProcessingStatus("4");
								ra2.setDelFlag("1");
								c01S003Service.updateRedemptionapplied(ra2);

								// 剩余出库总数量=出库总数量-(一张换领单的申请数量-一张换领单的领取数量)
								countA = countA - (countC - countB);
							}
						} else {
							cJsonStr = jsonResult(false, "刀具换领出库失败");
							return cJsonStr;
						}
					}
				} else {
					// 新建换领申请表数据
					Redemptionapplied r = new Redemptionapplied();
					r.setRedemptionAppliedID(getId());
					r.setToolCode(bean.getMaterialNum());
					r.setAppliedNumber(BigDecimal.valueOf(countD));
					r.setReceiveNumber(BigDecimal.valueOf(countD));
					r.setApplyUser(bean.getReceiveUser());
					r.setReceiveUser(bean.getReceiveUser());
					r.setProcessingStatus("4");
					r.setDelFlag("1");
					c01S005Service.insertRedemptionapplied(r);
				}

				// 材料号
				Tool entity = new Tool();
				entity.setToolCode(bean.getMaterialNum());
				// Tool tool = c01S001Service.searchBitInputInf(entity);

				// 增加备刀库周转量
				// 刀片（更新操作）
				// 查询装备用刀容器的载体id
				// Containercarrier cc = new Containercarrier();
				// // 备用刀
				// cc.setContainerCarrierType("0");
				// List<Containercarrier> ccList = (List<Containercarrier>)
				// c01S003Service
				// .getContainercarrierList(cc);
				// if (ccList.size() > 0) {
				// 更新流转表
				// 先查询原有的周转量
				// 根据材料号查询刀具流转统计表数据
				TooltransferTotal ttInfo = c01S005Service
						.getTooltransferTotalInfoByToolCode(bean
								.getMaterialNum());
				TooltransferTotal ttft = new TooltransferTotal();
				if (null != ttInfo) {
					// 更新条件-材料号
					ttft.setToolCode(bean.getMaterialNum());
					// 备刀数量
					ttft.setSpareKnifeSum(ttInfo.getSpareKnifeSum() + countD);
					// 更新者
					ttft.setUpdateUser(userID);
					// 根据材料号 更新流转统计表数据
					c01S008Service.updateTooltransferTotal(ttft);
				}

				// }

				// 刀具入库编码
				String knifeCode = null;
				// 刀片
				Rfidcontainer r = new Rfidcontainer();
				r.setRfidCode(bean.getRfidCode());
				// 载体id
				String rfidcontainerID = (c01S003Service.getRfidcontainer(r))
						.get(0).getRfidContainerID();
				// 在新刀库存表中查询当前库位标签的库存量
				Knifeinventory k = new Knifeinventory();
				k.setRfidContainerID(rfidcontainerID);
				List<Knifeinventory> kiList = (List<Knifeinventory>) c01S003Service
						.getKnifeinventory(k);
				if (kiList.size() > 0) {
					String number = kiList.get(0).getKnifelnventoryNumber();
					// 更新库存表
					k.setRfidContainerID(rfidcontainerID);
					// 剩余库存量
					k.setKnifelnventoryNumber((Integer.parseInt(number) - countD)
							+ "");
					k.setUpdateUser(userID);
					c01S003Service.updateKnifeinventory(k);
				}

				// 刀具入库编码
				knifeCode = kiList.get(0).getKnifeInventoryCode();

				// 建立刀具出库履历
				Toollibraryhistory tlentity = new Toollibraryhistory();
				// 出库履历id
				tlentity.setToolLiberyID(getId());
				// 刀具入库编码
				tlentity.setKnifeInventoryCode(knifeCode);
				// 刀具id
				tlentity.setToolID(bean.getToolID().toString());
				// 领取人
				tlentity.setReceiveUser(receiveUser);
				// 领取数量
				// if (!"0".equals(toolConsumetype)) {
				// 刀片
				tlentity.setReceiveCount(new BigDecimal(countD));
				// }
				/*
				 * else { tlentity.setReceiveCount(BigDecimal.ONE); }
				 */
				// 出库原因(0申领1换领2外借)
				tlentity.setLibraryCause("1");
				tlentity.setCreateUser(userID);
				tlentity.setUpdateUser(userID);
				// 插入出库履历表
				c01S003Service.insertToollibraryhistory(tlentity);

				// 查询sap自动上传开关是否开启
				String flg = c01S003Service.getSapOnOff();

				SapUploadhistory sap = new SapUploadhistory();
				sap.setSapID(getId());
				// TODP 过账日期
				sap.setPstngDate(new Date());
				// TODP 过账日期
				sap.setDocDate(new Date());
				// 物料号
				sap.setMaterial(bean.getMaterialNum());
				// 移动类型（库存管理）101入库
				sap.setMoveType("201");
				// 出/入库数量
				sap.setEntryQnt(bean.getReceiveCount());
				// 收货/发货物料
				sap.setMoveMat(bean.getMaterialNum());
				// 成本中心
				sap.setCostCenter(costCenter);
				// 出入库时间
				sap.setOutInDate(new Date());
				// 库管员
				sap.setOutInUser(receiveUser);
				// 开关为开启的状态
				if ("0".equals(flg)) {
					// 上传状态（0 未上传 1 已上传 2 上传失败）
					sap.setState("0");
				} else {
					// 上传状态（0 未上传 1 已上传 2 上传失败）
					sap.setState("1");
				}
				// 上传时间
				sap.setUpdateTime(new Date());
				// 创建者
				sap.setCreateUser(userID);

				// 插入sap履历信息
				c01S003Service.insetSapHisInfo(sap);

			}
			/*
			 * if (twlList.size() > 0) { // 插入生命周期表
			 * c01S003Service.insertBatchs(twlList); }
			 */
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
			return cJsonStr;
		}

		cJsonStr = jsonResult(true);
		return cJsonStr;
	}

}
