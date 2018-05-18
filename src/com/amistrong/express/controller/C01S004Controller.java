package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.amistrong.express.beans.response.Replacement;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.SapUploadhistory;
import com.amistrong.express.beans.response.Scrap;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toollibraryhistory;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S003Service;
import com.amistrong.express.server.C01S004Service;
import com.amistrong.express.server.C01S005Service;
import com.amistrong.express.server.C01S008Service;

/**
 * 补领出库
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Controller
public class C01S004Controller extends BaseController {

	@Autowired
	private C01S004Service c01S004Service;

	@Autowired
	private C01S001Service c01S001Service;

	@Autowired
	private C01S003Service c01S003Service;

	@Autowired
	private C01S005Service c01S005Service;

	@Autowired
	private C01S008Service c01S008Service;

	/**
	 * 取得补领出库申请列表
	 * 
	 * @param
	 * @return
	 * @throws SQLException
	 */
	@ResponseBody
	@RequestMapping(value = "/getFReplacementList", method = RequestMethod.POST)
	public String getFReplacementList() throws Exception {
		String cJsonStr;
		try {
			List<Replacement> list = c01S004Service.getReplacementList();
			if (list == null || list.size() <= 0) {
				// 查无补领申请
				cJsonStr = jsonResult(false, "无补领申请");
				return cJsonStr;
			} else {
				cJsonStr = jsonResult(list);
				return cJsonStr;
			}
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 取得补领出库申请单信息
	 * 
	 * @param
	 * @return
	 * @throws SQLException
	 */
	@ResponseBody
	@RequestMapping(value = "/getFReplacementApply", method = RequestMethod.POST)
	public String getFReplacementApply(String applyID, String applyTime,
			String replacementFlag) throws Exception {
		String cJsonStr;
		// 时间格式化

		try {
			// 补领原因为补充周转量或特殊领用
			// 申请时间
			String applyTimeStr = applyTime.substring(0, 8);
			// 查询补领申请表
			Replacement raentity = new Replacement();
			// 申请人ID
			raentity.setApplyID(applyID);
			// 申请时间
			raentity.setApplyTime(applyTimeStr);
			// 删除区分(0有效1删除)
			// raentity.setDelFlag("0");
			// 申领区分 (0补领周转1借用2特殊领用)
			raentity.setReplacementFlag(replacementFlag);
			// 查询申领详细信息
			List<Replacement> list = c01S004Service
					.getReplacementApply(raentity);
			cJsonStr = jsonResult(list);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 提交补领出库的刀具信息
	 * 
	 * @param
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
	@RequestMapping(value = "/saveFReplacementapplyInfo", method = RequestMethod.POST)
	public String saveFReplacementapplyInfo(String replaceJsonList,String costCenter)
			throws Exception {
		String cJsonStr;
		try {
			// Map<String, Object> result = new HashMap<String, Object>();
			JSONArray objData = new JSONArray(replaceJsonList); // 获取data字段
			List<Map> replaceList = new ArrayList<Map>();
			for (int i = 0; i < objData.length(); i++) {
				Map map = new HashMap<String, Object>();
				// 刀具ID
				String toolID = objData.getJSONObject(i).get("toolID")
						.toString();
				map.put("toolID", toolID);
				// 材料号
				String toolCode = objData.getJSONObject(i).get("toolCode")
						.toString();
				map.put("toolCode", toolCode);
				// 可领数量
				String appliedNumber = objData.getJSONObject(i)
						.get("appliedNumber").toString();
				map.put("appliedNumber", appliedNumber);
				// 出库数量
				String receiveCount = objData.getJSONObject(i)
						.get("receiveCount").toString();
				map.put("receiveCount", receiveCount);
				// 用户ID
				String customerID = objData.getJSONObject(i).get("customerID")
						.toString();
				map.put("customerID", customerID);
				// 授权人id
				String gruantUserID = objData.getJSONObject(i)
						.get("gruantUserID").toString();
				map.put("gruantUserID", gruantUserID);
				// RFID标签ID
				String rfidCode = objData.getJSONObject(i).get("rfidCode")
						.toString();
				map.put("rfidCode", rfidCode);
				// 申请单号
				String replacementID = objData.getJSONObject(i)
						.get("replacementID").toString();
				map.put("replacementID", replacementID);
				replaceList.add(map);
			}

			// Toolwholelifecycle twl = null;
			// List<Toolwholelifecycle> twlList = new
			// ArrayList<Toolwholelifecycle>();
			List<Replacement> redempList = new ArrayList<Replacement>();
			int count = 0;
			int ccount = 0;
			String userID = null;
			String gruantUserID = null;
			String signID = null;
			String toolID = null;
			// String rfidContainerID = null;
			String rfidCode = null;
			String replacementNumber = null;
			String toolCode = null;
			// 根据材料号查找对应的刀具消耗类别
			String toolConsumetype = null;
			Date recederTime = new Date();

			Map<String, Integer> checkMap = new HashMap<String, Integer>();
			for (Map<String, Object> map : replaceList) {
				if (checkMap.get(map.get("rfidCode").toString()) == null) {
					checkMap.put(map.get("rfidCode").toString(),
							Integer.valueOf(map.get("receiveCount").toString()));
				} else {
					checkMap.put(
							map.get("rfidCode").toString(),
							Integer.valueOf(map.get("receiveCount").toString())
									+ Integer.valueOf(checkMap.get(map.get(
											"rfidCode").toString())));
				}
			}

			List<String> mapKeyList = new ArrayList<String>(checkMap.keySet());
			List<Integer> mapValuesList = new ArrayList<Integer>(
					checkMap.values());

			for (int i = 0; i < mapKeyList.size(); i++) {

				// 刀片
				Rfidcontainer r = new Rfidcontainer();
				r.setRfidCode(mapKeyList.get(i).toString());
				r.setDelFlag("0");
				// 载体id
				String rfidcontainerID = c01S003Service.getRfidcontainer(r)
						.get(0).getRfidContainerID();
				// 在新刀库存表中查询当前库位标签的库存量
				Knifeinventory k = new Knifeinventory();
				k.setRfidContainerID(rfidcontainerID);
				k.setDelFlag("0");
				List<Knifeinventory> kiList = c01S003Service
						.getKnifeinventory(k);
				if (kiList.size() > 0) {
					String number = kiList.get(0).getKnifelnventoryNumber();

					if (Integer.valueOf(number) < mapValuesList.get(i)) {
						cJsonStr = jsonResult(false, "库存数量不足");
						return cJsonStr;
					}
				}

			}

			for (Map<String, Object> map : replaceList) {
				if ("0".equals(map.get("receiveCount"))) {
					continue;
				}
				// 刀具入库编码
				String knifeCode = null;
				count = Integer.parseInt(map.get("appliedNumber").toString());
				ccount = 0;
				// if (!"0".equals(toolConsumetype)) {
				// 刀片
				ccount = Integer.parseInt(String.valueOf(map
						.get("receiveCount")));
				userID = map.get("customerID").toString();
				gruantUserID = map.get("gruantUserID").toString();
				signID = map.get("gruantUserID").toString();
				toolID = map.get("toolID").toString();
				// rfidContainerID = map.get("RfidContainerID").toString();
				rfidCode = map.get("rfidCode").toString();
				replacementNumber = map.get("replacementID").toString();
				// 材料号
				toolCode = map.get("toolCode").toString();

				// 减少库存量
				// if (!"0".equals(toolConsumetype)) {
				// 刀片
				Rfidcontainer r = new Rfidcontainer();
				r.setRfidCode(map.get("rfidCode").toString());
				r.setDelFlag("0");
				// 载体id
				String rfidcontainerID = c01S003Service.getRfidcontainer(r)
						.get(0).getRfidContainerID();
				// 在新刀库存表中查询当前库位标签的库存量
				Knifeinventory k = new Knifeinventory();
				k.setRfidContainerID(rfidcontainerID);
				k.setDelFlag("0");
				List<Knifeinventory> kiList = c01S003Service
						.getKnifeinventory(k);
				if (kiList.size() > 0) {
					String number = kiList.get(0).getKnifelnventoryNumber();

					// 剩余库存量
					k.setKnifelnventoryNumber((Integer.parseInt(number) - ccount)
							+ "");
					k.setUpdateUser(userID);
					// 更新库存表
					c01S003Service.updateKnifeinventory(k);

					// 刀具入库编码
					knifeCode = kiList.get(0).getKnifeInventoryCode();
				}

				Tool entity = new Tool();
				entity.setToolCode(toolCode);
				Tool tool = c01S001Service.searchBitInputInf(entity);
				if (tool != null) {
					toolConsumetype = tool.getToolConsumetype();
				}
				// 取得补领申请的信息
				Replacement reentity = new Replacement();
				// 补领单号
				reentity.setReplacementID(replacementNumber);
				// 刀具编码
				reentity.setToolCode(toolCode);
				redempList = (List<Replacement>) c01S004Service
						.searchReplacement(reentity);
				
				// }

				// 如果补领原因是补充周转量
				if ("0".equals(redempList.get(0).getReplacementFlag())) {
					Tooltransfer tt = new Tooltransfer();
					// 根据材料号查询刀具流转统计表数据
					TooltransferTotal ttInfo = c01S005Service
							.getTooltransferTotalInfoByToolCode(toolCode);
					if (ttInfo != null) {
						// 更新流转表
						TooltransferTotal ttft = new TooltransferTotal();
						// 更新条件-材料号
						ttft.setToolCode(toolCode);
						// 备刀数量
						ttft.setSpareKnifeSum(ttInfo.getSpareKnifeSum()
								+ ccount);
						// 更新者
						ttft.setUpdateUser(userID);
						// 根据材料号 更新流转统计表数据
						c01S008Service.updateTooltransferTotal(ttft);
					}
					// else {
					// // 插入流转表
					// // 刀具入库编码
					// tt.setKnifeInventoryCode(getId());
					// // 最后流程
					// tt.setBusinessFlowLnkID("C01S004");
					// // 数量
					// tt.setToolDurable(ccount);
					// // 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
					// tt.setInstallationState("0");
					// // 刀具部门(0库存,1对刀室,2刃磨室,3,车间4,初始化
					// tt.setToolThisState("1");
					// // 库存状态(0正常1报废2返厂3封存4.流转9其他)
					// tt.setStockState("4");
					// tt.setCreateUser(userID);
					// tt.setUpdateUser(userID);
					// tt.setDelFlag("0");
					// c01S004Service.insertTooltransfer(tt);
					// }
				} else {
					// 插入到报废表中
					Scrap scrap = new Scrap();
					// 报废ID
					scrap.setScrapID(getId());
					// 刀具类型
					scrap.setToolType(toolConsumetype);
					// 流程id
					scrap.setBusinessID("C01S004");
					// 材料号
					scrap.setMaterial(toolCode);
					// 刀具id
					scrap.setToolID(toolID);
					// 报废数量
					// if (!"0".equals(toolConsumetype)) {
					// 刀片
					scrap.setScrapNumber(new BigDecimal(ccount));
					// }
					// 报废状态：出库报废
					scrap.setScrapState("3");
					// 授权人id
					scrap.setAuthorizationID(gruantUserID);
					// 创建者
					scrap.setCreateUser(userID);
					// 更新者
					scrap.setUpdateUser(userID);
					c01S004Service.insertScrap(scrap);

					// 根据材料号查询刀具流转统计表数据
					TooltransferTotal ttInfo = c01S005Service
							.getTooltransferTotalInfoByToolCode(toolCode);
					if (ttInfo != null) {
						// 更新流转表
						TooltransferTotal ttft = new TooltransferTotal();
						// 更新条件-材料号
						ttft.setToolCode(toolCode);
						// 累积报废
						ttft.setScrapSum(ttInfo.getScrapSum() + ccount);
						// 更新者
						ttft.setUpdateUser(userID);
						// 根据材料号 更新流转统计表数据
						c01S008Service.updateTooltransferTotal(ttft);
					}
				}

				// }
				// else {
				// // 钻头
				// Rfidcontainer r = new Rfidcontainer();
				// r.setRfidCode(rfidCode);
				// r.setDelFlag(IConstant.STRING_0);
				// // 载体id
				// String rfidcontainerID = ((List<Rfidcontainer>)
				// rfidcontainerDao
				// .searchByList(r)).get(0).getRfidContainerID();
				// // 在新刀库存表中更新当前单品刀标签的库存状态（删除区分置为1）
				// Knifeinventory k = new Knifeinventory();
				// k.setRfidContainerID(rfidcontainerID);
				// k.setDelFlag(IConstant.STRING_0);
				// List<Knifeinventory> kiList = (List<Knifeinventory>)
				// knifeinventoryDao
				// .searchByList(k);
				// if (kiList.size() > 0) {
				// // 更新库存表
				// k.setRfidContainerIDWhere(rfidcontainerID);
				// k.setDelFlagWhere(IConstant.STRING_0);
				// k.setDelFlag(IConstant.STRING_1);
				// knifeinventoryDao.updateNonQuery(k);
				//
				// // 刀具入库编码
				// knifeCode = kiList.get(0).getKnifeInventoryCode();
				// }
				//
				// // 建立刀具生命周期
				// twl = new Toolwholelifecycle();
				// // 刀具全生命周期id
				// twl.setToolWholeLifecycleID(UUIDgen.getId());
				// // 刀具入库编码
				// twl.setKnifeInventoryCode(knifeCode);
				// // 流程id
				// twl.setBusinessFlowLnkID(IConstant.C01S004);
				// // 手持机id
				// twl.setHandSetID(map.get("HandSetID").toString());
				// // 刀具id
				// twl.setToolID(toolID);
				// // 零部件id
				// twl.setPartsID("");
				// // 加工数量
				// twl.setProcessAmount("0");
				// // 删除区分(0有效1删除)
				// twl.setDelFlag(IConstant.DEL_FLAG_0);
				// // 更新时间
				// twl.setUpdateTime(new Date());
				// // 更新者
				// twl.setUpdateUser(userID);
				// // 创建时间
				// twl.setCreateTime(new Date());
				// // 创建者
				// twl.setCreateUser(userID);
				// // 刃磨次数
				// twl.setVersion(BigDecimal.ZERO);
				// twlList.add(twl);
				// }

				// 更改补领单刀片的数量
				if (redempList.size() > 0) {
					Replacement redempentity = new Replacement();
					redempentity.setReplacementID(redempList.get(0)
							.getReplacementID());
					redempentity.setToolCode(toolCode);
					// 申请数量
					redempentity
							.setAppliedNumber(new BigDecimal(count - ccount));
					// 领取人
					redempentity.setReceiveUser(signID);
					redempentity.setReceiveTime(recederTime);
					if (count - ccount == 0) {
						// 全部补领完毕
						redempentity.setDelFlag("1");
					}
					redempentity.setUpdateUser(userID);
					// 更新申请表
					c01S004Service.updateRedempentity(redempentity);
				}
				// // 更改补领单中钻头的数量
				// else if (redempList.size() > 0
				// && IConstant.STRING_0.equals(toolConsumetype)) {
				// Replacement redempentity = new Replacement();
				// redempentity.setReplacementIDWhere(redempList.get(0)
				// .getReplacementID());
				// redempentity.setToolCodeWhere(toolCode);
				// // 申请数量
				// redempentity.setAppliedNumber(new BigDecimal(count - 1));
				// // 领取人
				// redempentity.setReceiveUser(signID);
				// redempentity.setReceiveTime(recederTime);
				// if (count - 1 == 0) {
				// // 全部补领完毕
				// redempentity.setDelFlag(IConstant.STRING_1);
				// }
				// redempentity.setUpdateTime(new Date());
				// redempentity.setUpdateUser(userID);
				// replacementDao.updateNonQuery(redempentity);
				//
				// // 修改从前台传过来的list，for循环处理完一个钻头，则将其申请数量减1
				// for (Map<String, Object> mapList : toolList) {
				// if (toolCode.equals(mapList.get("MaterialNum"))) {
				// mapList.put(
				// "AppliedNumber",
				// (Integer.parseInt((String) mapList
				// .get("AppliedNumber")) - 1) + "");
				// }
				// }
				// }

				// 建立刀具出库履历
				Toollibraryhistory tlentity = new Toollibraryhistory();
				// 出库履历id
				tlentity.setToolLiberyID(getId());
				// 刀具入库编码
				tlentity.setKnifeInventoryCode(knifeCode);
				// 刀具id
				tlentity.setToolID(map.get("toolID").toString());
				// 领取人
				tlentity.setReceiveUser(gruantUserID);
				// 领取数量
				// if (!"0".equals(toolConsumetype)) {
				// 刀片
				tlentity.setReceiveCount(new BigDecimal(ccount));
				// }
				// else {
				// tlentity.setReceiveCount(BigDecimal.ONE);
				// }
				// 出库原因(0申领1换领2外借)
				tlentity.setLibraryCause("0");
				tlentity.setCreateUser(userID);
				tlentity.setUpdateUser(userID);
				tlentity.setState(Integer.valueOf(redempList.get(0)
						.getReplacementReason()));
				c01S004Service.insertTlentity(tlentity);
				
				//查询sap自动上传开关是否开启
				String flg = c01S003Service.getSapOnOff();
					SapUploadhistory sap = new SapUploadhistory();
					sap.setSapID(getId());
					//TODP 过账日期
					sap.setPstngDate(new Date());
					//TODP 过账日期
					sap.setDocDate(new Date());
					//物料号
					sap.setMaterial(toolCode);
					// 移动类型（库存管理）101入库 201出库
					sap.setMoveType("201");
					// 出/入库数量
					sap.setEntryQnt(String.valueOf(ccount));
					// 收货/发货物料
					sap.setMoveMat(toolCode);
					// 成本中心
					sap.setCostCenter(costCenter);
					// 出入库时间
					sap.setOutInDate(new Date());
					// 库管员
					sap.setOutInUser(gruantUserID);
					//开关为开启的状态
					if("0".equals(flg)){
						// 上传状态（0 未上传 1 已上传 2 上传失败）
						sap.setState("0");
					}else{
						// 上传状态（0 未上传 1 已上传 2 上传失败）
						sap.setState("1");
					}
					// 上传时间
					sap.setUpdateTime(new Date());
					// 创建者
					sap.setCreateUser(userID);
					// 订单号
					sap.setOrderID(replacementNumber);
					
					// 插入sap履历信息
					c01S003Service.insetSapHisInfo(sap);
			}

			// if (twlList.size() > 0) {
			// c01S004Service.insertToolwholelifecycle(twlList);
			// }
			cJsonStr = jsonResult(true);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}
}
