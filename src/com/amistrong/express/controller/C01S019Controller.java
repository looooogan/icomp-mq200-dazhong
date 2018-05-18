package com.amistrong.express.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.response.Authorization;
import com.amistrong.express.beans.response.GetOutFactoryToolInfoRespons;
import com.amistrong.express.beans.response.Merchants;
import com.amistrong.express.beans.response.Outsidefactory;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S003Service;
import com.amistrong.express.server.C01S005Service;
import com.amistrong.express.server.C01S008Service;
import com.amistrong.express.server.C01S017Service;
import com.amistrong.express.server.C01S019Service;
import com.amistrong.express.server.C03S001Service;

/**
 * 厂外修磨
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Transactional
@Controller
public class C01S019Controller extends BaseController {

	// @Autowired
	// private C01S004Service c01S004Service;

	@Autowired
	private C01S001Service c01S001Service;

	@Autowired
	private C01S003Service c01S003Service;

	@Autowired
	private C01S005Service c01S005Service;

	@Autowired
	private C03S001Service c03S001Service;

	@Autowired
	private C01S019Service c01S019Service;

	@Autowired
	private C01S017Service c01S017Service;

	@Autowired
	private C01S008Service c01S008Service;

	/**
	 * 查询查询一体刀、非单品信息
	 * 
	 * @param (String)rfidCode：扫描标签的RFID materialNum:材料号
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getOutFactoryToolInfo", method = RequestMethod.POST)
	public String getOutFactoryToolInfo(String rfidCode, String materialNum)
			throws Exception {
		String cJsonStr;
		GetOutFactoryToolInfoRespons respons = new GetOutFactoryToolInfoRespons();
		try {

			// 参数验证
			if ((null == rfidCode || "".equals(rfidCode))
					&& (null == materialNum || "".equals(materialNum))) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}
			Rfidcontainer rfidcontainer = new Rfidcontainer();

			String rfid = null;
			if (null != rfidCode && !"".equals(rfidCode)) {
				// RFID标签有效验证
				rfidcontainer = c01S001Service
						.getRfidContainerByRfidCode(rfidCode);
				if (rfidcontainer == null) {
					cJsonStr = jsonResult(false, "当前标签未初始化");
					return cJsonStr;
				} else if (!"2".equals(rfidcontainer.getQueryType())) {
					cJsonStr = jsonResult(false, "请扫描合成刀具标签");
					return cJsonStr;
				} else {
					// RFID取得
					rfid = rfidcontainer.getRfidContainerID();
				}
			} else {
				// 材料号
				Tool entity = new Tool();
				entity.setToolCode(materialNum);
				Tool tool = c01S001Service.searchBitInputInf(entity);
				rfid = tool.getRfidContainerID();

				// String rfidContainerId = null;
				// Tool t = new Tool();
				// 刀具编码(材料号)
				// t.setToolCode(materialNum);
				// Tool tool2 = c01S001Service.searchBitInputInf(t);
				if (tool.getToolCode() == null) {
					cJsonStr = jsonResult(false, "未找到相应的材料号信息");
					return cJsonStr;
				} else {

					// 根据rfid材料载体信息
					rfidcontainer = c01S005Service.getRfidInfoByRfid(rfid);
					if (rfidcontainer == null) {
						cJsonStr = jsonResult(false, "材料号：" + materialNum
								+ "标签未初始化");
						return cJsonStr;
					} else if (!"0".equals(rfidcontainer.getQueryType())) {
						cJsonStr = jsonResult(false, "不是库位标签材料号");
						return cJsonStr;
					}

				}
			}

			// RFID载体ID
			respons.setRfidContainerID(rfid);
			String code = null;
			String toolId = null;
			String toolCode = null;
			String toolType = null;
			// 输入库位码的场合
			if (null != materialNum && !"".equals(materialNum)) {
				// 根据扫描的库位码查询刀具信息
				// 根据RFID取得刀具信息
				Tool tool = new Tool();
				tool.setRfidContainerID(rfid);
				List<Tool> toolList = c01S001Service.getToolInfo(tool);
				if (toolList.size() < 1) {
					cJsonStr = jsonResult(false, "刀具信息不存在");
					return cJsonStr;
				}
				// 刀具类型
				toolType = "0";
				// 刀具id
				toolId = toolList.get(0).getToolID();
				// 材料号(刀具编码)
				toolCode = toolList.get(0).getToolCode();
				// 刀具修磨类别为厂内修磨时，不可出厂修磨
				if ("0".equals(toolList.get(0).getToolGrinding())) {
					cJsonStr = jsonResult(false, "该刀具修磨类别为厂内修磨，不可出厂修磨");
					return cJsonStr;
				}
				// 材料号为辅具不可厂外修磨
				if ("1".equals(toolList.get(0).getToolType())) {
					cJsonStr = jsonResult(false, "该刀具为辅具，不可出厂修磨");
					return cJsonStr;
				}
				code = "1";

				// 扫描合成刀的场合
			} else {
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

					// 未卸下不可修磨
					if (!"1".equals(reVal.getInstallFlag())) {
						cJsonStr = jsonResult(false, "该刀具未卸下，不可厂外修磨");
						return cJsonStr;
					}

					// 已出厂
					if ("7".equals(reVal.getLoadState())) {
						cJsonStr = jsonResult(false, "该刀具已出厂");
						return cJsonStr;
					}

					// 厂外修磨回厂后，再出厂修磨的场合 需授权
					if ("8".equals(reVal.getLoadState())) {
						code = "0";
					} else {
						code = "1";
					}
				}
				// 材料号(刀具编码)
				toolCode = reVal.getSynthesisParametersCode();

				// 根据合成刀具码查询刀具信息
				Tool tool = c01S005Service.searchToolInfoBySpcode(toolCode);
				// 刀具类型
				toolType = "2";
				// 刀具id
				toolId = tool.getToolID();
				// 刀具修磨类别为厂内修磨时，不可出厂修磨
				if ("0".equals(tool.getToolGrinding())) {
					cJsonStr = jsonResult(false, "该刀具修磨类别为厂内修磨，不可出厂");
					return cJsonStr;
				}

				// 刀具类型为厂外涂层时 先厂内修磨后才可出厂
				if ("2".equals(tool.getToolGrinding())) {
					if (!"4".equals(reVal.getLoadState())
							&& !"10".equals(reVal.getLoadState())) {
						cJsonStr = jsonResult(false, "请先进行厂内修磨");
						return cJsonStr;
					}

				}
			}
			respons.setCode(code);
			respons.setToolCode(toolCode);
			respons.setToolType(toolType);
			respons.setToolID(toolId);
			cJsonStr = jsonResult(respons);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 提交厂外修磨信息
	 * 
	 * @param toolCodes
	 *            toolIDs:刀具IDs toolTypes:刀具类型s rfidContainerIDs：RFIDS :刀具编号s
	 *            numbers：修磨数量s customerID：用户ID merchantsID:商家ID
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveOutFactoryToolInfo", method = RequestMethod.POST)
	public String saveOutFactoryToolInfo(String toolCodes, String toolIDs,
			String toolTypes, String rfidContainerIDs, String numbers,
			String customerID, String merchantsID, String authorizationFlgs)
			throws Exception {
		String cJsonStr;
		String message = null;
		try {

			if ("".equals(toolCodes) || null == toolCodes || "".equals(numbers)
					|| null == numbers || "".equals(customerID)
					|| null == customerID) {
				// 系统错误,999
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			} else {

				// 材料号
				String[] toolCodesArr = toolCodes.split(",");
				// 修磨数量
				String[] numbersArr = numbers.split(",");
				// 刀具类型
				String[] toolTypesArr = toolTypes.split(",");
				// RFID载体ID
				String[] rfidContainerIDsArr = rfidContainerIDs.split(",");
				// 刀具ID
				String[] toolIDsArr = toolIDs.split(",");
				// 修磨类别
				String toolGrinding = null;
				//
				String toolCode = "";
				// 是否需要授权
				String[] authorizationFlgsArr = authorizationFlgs.split(",");
				for (int i = 0; i < toolCodesArr.length; i++) {
					// 修磨数量
					Integer number = Integer.valueOf(numbersArr[i]);
					// 非单品
					if ("0".equals(toolTypesArr[i])) {
						toolCode = toolCodesArr[i];
						// String rfidContainerId = null;
						Tool t = new Tool();
						// 刀具编码(材料号)
						t.setToolCode(toolCodesArr[i]);
						// 根据刀具码查询刀具信息
						Tool tool = c01S001Service.searchBitInputInf(t);
						toolGrinding = tool.getToolGrinding();

						// 根据材料号查询流转统计表数据
						TooltransferTotal tst = c01S005Service
								.getTooltransferTotalInfoByToolCode(toolCodesArr[i]);
						if (null != tst) {
							// 待厂外修磨数量小于出厂数量时
							if (tst.getStayExternalGrindingSum() < number) {
								cJsonStr = jsonResult(false, "材料号："
										+ toolCodesArr[i] + "修磨数量大于当前待修磨数量");
								return cJsonStr;
							}
							// 更新条件-刀具材料号
							tst.setToolCode(toolCodesArr[i]);
							// 新备刀数量 = 当前备刀数量-修磨数量
							// tst.setSpareKnifeSum(tst.getSpareKnifeSum()
							// - number);
							// 新厂外修磨 = 当前厂外修磨数量+修磨数量
							tst.setExternalGrindingSum(tst
									.getExternalGrindingSum()
									+ number.intValue());
							// 待厂外修磨数量 = 当前待厂外修磨数量-修磨数量
							tst.setStayExternalGrindingSum(tst
									.getStayExternalGrindingSum() - number);
							tst.setUpdateUser(customerID);
							// 更新流转统计表数据
							c01S005Service.updateTooltransferTotalInfo(tst);
						} else {
							cJsonStr = jsonResult(false, "未找到材料号："
									+ toolCodesArr[i] + "的流转信息");
							return cJsonStr;
						}

						// 一体刀
					} else {

						Synthesisknife sk = new Synthesisknife();
						// 更新条件 - RFID
						sk.setrFID(rfidContainerIDsArr[i]);
						// 使用状态 -
						// 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上6:已拆分7:已出厂修磨)
						sk.setLoadState("7");
						// 更新者
						sk.setUpdateUser(customerID);
						sk.setBusinessFlowLnkID("C01S019");
						// 更新合成刀库表是否安装为0设备装入
						c01S008Service.updateSynthesisknife(sk);

						// 根据合成刀具码查询刀具信息
						Tool entity = new Tool();
						// 刀具ID
						entity.setToolID(toolIDsArr[i]);
						// 查询刀具信息
						Tool tool = c01S017Service.searchTool(entity);
						toolGrinding = tool.getToolGrinding();
						toolCode = toolCodesArr[i];
						// 需要授权的场合
						if ("1".equals(authorizationFlgsArr[i])) {
							Authorization authorization = new Authorization();
							// 授权ID
							authorization.setAuthorizationID(getId());
							// 授权人ID
							authorization.setAuthorizationUserID(customerID);
							// 授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
							authorization.setAuthorizedReason("6");
							// 授权时间
							authorization.setAuthorizedTime(new Date());
							// 创建人
							authorization.setCreateUserID(customerID);
							// 修改人
							// authorization.setUpdateUser(customerID);
							// 修改时间
							// authorization.setUpdateTime(new Date());k
							// 创建时间
							// authorization.setCreateTime(new Date());
							// 刀具ID
							authorization.setToolID(tool.getToolID());
							// 材料号
							authorization.setToolCode(toolCodesArr[i]);
							// 流程ID
							authorization.setBusinessCode("C01S018");
							authorization.setNote("重复修磨");
							// 插入授权表
							c01S019Service
									.insertAuthorizationDao(authorization);
						}

						// // 更新一体刀编号对应流转信息
						// // 根据一体刀编号查询流转统计表数据
						// TooltransferTotal tst = c01S005Service
						// .getTooltransferTotalInfoByToolCode(toolCodesArr[i]);
						// if (null != tst) {
						// //备刀数量小于出厂数量时
						// if(tst.getSpareKnifeSum() < number){
						// cJsonStr = jsonResult(false, "当前备刀数量不足");
						// return cJsonStr;
						// }
						// // 更新条件-刀具材料号
						// tst.setToolCode(toolCodesArr[i]);
						// // 新备刀数量 = 当前备刀数量-修磨数量
						// tst.setSpareKnifeSum(tst.getSpareKnifeSum()
						// - number);
						// // 新厂外修磨数量 = 当前厂外修磨数量-修磨数量
						// tst.setExternalGrindingSum(tst
						// .getExternalGrindingSum() + number);
						// // 需要授权的场合
						// if (!"1".equals(authorizationFlgsArr[i])) {
						// // 待厂外修磨数量 = 当前待厂外修磨数量-修磨数量
						// tst.setStayExternalGrindingSum(
						// tst.getStayExternalGrindingSum() - number);
						// }
						// tst.setUpdateUser(customerID);
						// // 更新流转统计表数据
						// c01S005Service.updateTooltransferTotalInfo(tst);
						// }

						Tooltransfer ttEntity = new Tooltransfer();
						ttEntity.setRfidContainerID(rfidContainerIDsArr[i]);
						ttEntity.setToolID(toolIDsArr[i]);
						ttEntity.setDelFlag("0");
						List<Tooltransfer> ttList = c01S003Service
								.searchTooltransferList(ttEntity);
						if (ttList.size() > 0) {

							Tooltransfer tt = new Tooltransfer();
							// 更新者
							tt.setUpdateUser(customerID);
							// 最后执行业务流程
							tt.setBusinessFlowLnkID("C01S019");
							// tt.setStockState("4");
							tt.setToolState("10");
							// tt.setInstallationState("1");
							// 更新条件
							tt.setRfidContainerID(rfidContainerIDsArr[i]);
							tt.setDelFlag("0");
							tt.setToolID(tool.getToolID());

							// 更新流转表数量
							c01S003Service.updateTooltransfer(tt);
						}

						// 更新一体刀编号对应流转信息
						// 根据一体刀编号查询流转统计表数据
						TooltransferTotal tst2 = c01S005Service
								.getTooltransferTotalInfoByToolCode(tool
										.getToolCode());
						if (null != tst2) {
							// 更新条件-刀具材料号
							tst2.setToolCode(tool.getToolCode());
							// 新厂外修磨数量 = 当前厂外修磨数量-修磨数量
							tst2.setExternalGrindingSum(tst2
									.getExternalGrindingSum() + number);
							// 厂外修磨回厂后再出厂的场合
							if (!"1".equals(authorizationFlgsArr[i])) {
								// 待厂外修磨数量 = 当前待厂外修磨数量-修磨数量
								tst2.setStayExternalGrindingSum(tst2
										.getStayExternalGrindingSum() - number);
								// 新备刀数量 = 当前备刀数量-修磨数量
								tst2.setSpareKnifeSum(tst2.getSpareKnifeSum()
										- number);

							}
							tst2.setUpdateUser(customerID);
							// 更新流转统计表数据
							c01S005Service.updateTooltransferTotalInfo(tst2);
						}

					}

					Outsidefactory uf = new Outsidefactory();
					// 厂外修复ID
					uf.setOutsideFactoryID(getId());
					// 商家ID
					uf.setMerchantsID(merchantsID);
					// 单号生成 每个厂家每天生成的单号相同 -- 厂家ID+年月日
					Date dt = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					String orderNumber = merchantsID + sdf.format(dt);
					uf.setOrderNum(orderNumber);
					uf.setToolID(toolIDsArr[i]);
					// 材料号
					uf.setMaterialNum(toolCode);
					// 修磨数量
					uf.setNumberGrinding(numbersArr[i]);
					// 修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层取得
					if ("1".equals(toolGrinding)) {
						uf.setGrindingType("1");
					} else {
						uf.setGrindingType("0");
					}
					uf.setExpandSpace4(rfidContainerIDsArr[i]);
					if ("0".equals(toolTypesArr[i])) {
						// 刀具类型（0.非单品1.一体刀)
						uf.setToolType("0");
					} else {
						uf.setToolType("1");
					}
					// 修复状态(0.待出厂1.已出厂2.已送回）
					uf.setRepairState("0");
					uf.setDelFlag("0");
					// uf.setCreateTime(new Date());
					// uf.setUpdateTime(new Date());
					uf.setCreateUser(customerID);
					uf.setUpdateUser(customerID);
					c01S019Service.insertOutsidefactory(uf);

				}
				cJsonStr = jsonResult(true, "厂外修磨成功");
			}
		} catch (Exception e) {
			if (message == null || "".equals(message)) {
				message = MessageList.SYS_ERROR;
			}
			// 系统错误,999
			cJsonStr = jsonResult(false, message);

		}
		return cJsonStr;
	}

	/**
	 * 查询厂外修复商家list
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getMerchantsList", method = RequestMethod.POST)
	public String getMerchantsList() throws Exception {
		String cJsonStr;
		try {

			// 查询厂外修复商家list
			List<Merchants> merchantsList = c01S019Service.getMerchantsList();

			cJsonStr = jsonResult(merchantsList);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

}
