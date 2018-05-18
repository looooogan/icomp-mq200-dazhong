package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.amistrong.express.beans.response.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.request.ToolChangehistory;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S003Service;
import com.amistrong.express.server.C01S005Service;
import com.amistrong.express.server.C01S008Service;
import com.amistrong.express.server.C01S010Service;
import com.amistrong.express.server.C01S019Service;
import com.amistrong.express.server.C03S001Service;

/**
 * 刀具换装
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Transactional
@Controller
public class C01S010Controller extends BaseController {

	@Autowired
	private C01S001Service c01S001Service;

	@Autowired
	private C01S003Service c01S003Service;

	@Autowired
	private C01S005Service c01S005Service;

	@Autowired
	private C03S001Service c03S001Service;

	@Autowired
	private C01S010Service c01S010Service;

	@Autowired
	private C01S008Service c01S008Service;

	@Autowired
	private C01S019Service c01S019Service;

	/**
	 * 扫码查询合成刀信息
	 * 
	 * @param (String)rfidCode：扫描标签的RFID
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getSynthesisToolOneKnifeInfo", method = RequestMethod.POST)
	public String getSynthesisToolOneKnifeInfo(String rfidCode)
			throws Exception {
		String cJsonStr;
		C01S005Respons respons = new C01S005Respons();
		try {

			// 参数验证
			if (null == rfidCode || "".equals(rfidCode)) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}
			Rfidcontainer rfidcontainer = new Rfidcontainer();
			// 根据载体ID查询合成刀具编码
			Synthesisknife skentity = new Synthesisknife();
			String rfid = null;
			String code = null;
			// 扫描库位码的场合
			if (null != rfidCode && !"".equals(rfidCode)) {
				// RFID标签有效验证
				rfidcontainer = c01S001Service
						.getRfidContainerByRfidCode(rfidCode);
				if (rfidcontainer == null) {
					cJsonStr = jsonResult(false, "当前标签未初始化");
					return cJsonStr;
				} else if ((!"2".equals(rfidcontainer.getQueryType()))) {
					cJsonStr = jsonResult(false, "标签非合成刀具标签");
					return cJsonStr;
				} else {
					// RFID取得
					rfid = rfidcontainer.getRfidContainerID();
					// 载体ID
					skentity.setrFID(rfid);
				}
			}

			Synthesisknife reVal = c03S001Service
					.getSynCodeByRfidConner(skentity);
			if (null == reVal) {
				cJsonStr = jsonResult(false, "未找到合成刀数据");
				return cJsonStr;
			} else {
				// 非钻头或热套类标签
				if ((!"0".equals(reVal.getCreateType()))
						&& (!"1".equals(reVal.getCreateType()))
						&& (!"2".equals(reVal.getCreateType()))
						&& (!"3".equals(reVal.getCreateType()))) {
					cJsonStr = jsonResult(false, "该标签不能进行换装操作");
					return cJsonStr;
				}

				// 未卸下 不可换装
				if ("0".equals(reVal.getLoadState())) {
					cJsonStr = jsonResult(false, "该设备未卸下,不可换装");
					return cJsonStr;
				}

				// 已拆分不可换装
				if ("6".equals(reVal.getLoadState())) {
					cJsonStr = jsonResult(false, "该刀具已拆分，不可换装");
					return cJsonStr;
				}

				// 重复换装的场合 需授权
				if ("9".equals(reVal.getLoadState())) {
					code = "0";
				} else {
					code = "1";
				}
			}

			// // 根据合成刀具码查询刀具信息
			// Tool tool = c01S005Service.searchToolInfoBySpcode(reVal
			// .getSynthesisParametersCode());

			// 合成刀具编码(系统唯一)
			respons.setSynthesisParametersCode(reVal
					.getSynthesisParametersCode());
			// RFID载体ID
			respons.setRfidContainerID(rfid);
			respons.setCode(code);
			cJsonStr = jsonResult(respons);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 根据合成刀编号s查询合成刀详细
	 * 
	 * @param (String)rfidCode：扫描标签的RFID
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getSynthesisTool", method = RequestMethod.POST)
	public String getSynthesisTool(String spCodes) throws Exception {
		String cJsonStr;
		try {

			// 参数验证
			if (null == spCodes || "".equals(spCodes)) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}
			String[] spCodesArr = spCodes.split(",");

			List<Synthesiscutterlocation> synthesiscutterlocationList = new ArrayList<Synthesiscutterlocation>();
			for (int i = 0; i < spCodesArr.length; i++) {
				List<Synthesiscutterlocation> list = c01S010Service.getSynthesisToolList(spCodesArr[i]);
				for (int j = 0; j < list.size(); j++) {
					synthesiscutterlocationList.add(list.get(j));
				}
			}

			List<Synthesiscutterlocation> newList = new ArrayList<Synthesiscutterlocation>();
			for (int i = 0; i < synthesiscutterlocationList.size(); i++) {
				if (newList.size() == 0) {
					newList.add(synthesiscutterlocationList.get(i));
				} else {
					boolean flg = false;
					for (int j = 0; j < newList.size(); j++) {
						if (newList
								.get(j)
								.getToolCode()
								.equals(synthesiscutterlocationList.get(i)
										.getToolCode())) {
							newList.get(j).setToolCount(
									newList.get(j).getToolCount()
											+ synthesiscutterlocationList
													.get(i).getToolCount());
							flg = true;
							break;
						}
					}
					if (!flg) {
						newList.add(synthesiscutterlocationList.get(i));
					}

				}
			}
			// R&D
			for (Synthesiscutterlocation synthesiscutterlocation : newList) {
				synthesiscutterlocation.setTempToolCode(c01S010Service.queryReplaceTool(synthesiscutterlocation.getSynthesisParametersID(),				synthesiscutterlocation.getToolCode()));
			}
			cJsonStr = jsonResult(newList);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 提交换装刀具信息
	 * 
	 * @param toolCodes
	 *            :刀具编号s changeNumbers： 换装数量s lostNumbers:丢刀数量 customerID：用户ID
	 *            scrapCause:报废原因
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveHToolInfo", method = RequestMethod.POST)
	public String saveHToolInfo(String toolCodes, String changeNumbers,String replaceCode,
			String lostNumbers, String customerID, String rfidContainerIDs,
			String authorizationFlgs, String synthesisParametersCodes,String authorizationUserID )
			throws Exception {
		String cJsonStr;
		String message = null;
		try {
			c01S010Service.deleteSynthesisExchange(rfidContainerIDs);
			if ("".equals(toolCodes) || null == toolCodes
					|| "".equals(changeNumbers) || "".equals(lostNumbers)
					|| null == lostNumbers || null == changeNumbers
					|| "".equals(customerID) || null == customerID) {
				// 参数异常,999
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			} else {

				// 材料号
				String[] toolCodesArr = toolCodes.split(",");
				// 换装数量
				String[] changeNumbersArr = changeNumbers.split(",");
				// 丢刀数量
				String[] lostNumbersArr = lostNumbers.split(",");
				// 载体ID
				String[] rfidContainerIDsArr = rfidContainerIDs.split(",");
				// 是否需要授权
				String[] authorizationFlgsArr = authorizationFlgs.split(",");
				// 合成刀具编码
				String[] synthesisParametersCodesArr = synthesisParametersCodes
						.split(",");
				for (int i = 0; i < toolCodesArr.length; i++) {
					String rfidContainerId = null;
					Tool t = new Tool();
					// 刀具编码(材料号)
					t.setToolCode(toolCodesArr[i]);
					// 根据刀具码查询刀具信息
					Tool tool = c01S001Service.searchBitInputInf(t);
					// RFID取得
					rfidContainerId = tool.getRfidContainerID();
					// 根据rfid材料载体信息
					// Rfidcontainer rfidcontainer = c01S005Service
					// .getRfidInfoByRfid(rfidContainerId);
					if (rfidContainerId == null) {
						message = "材料号" + toolCodesArr[i] + "未进行库位标签初始化，无法换装";
					}
				}

				// 更新合成刀具状态为9换装中
				for (int i = 0; i < rfidContainerIDsArr.length; i++) {

					Tooltransfer tf = new Tooltransfer();
					// 更新条件-RFID载体ID
					tf.setRfidContainerID(rfidContainerIDsArr[i]);
					// 更新条件-刀具ID
					// tf.setToolID(toolList.get(j).getToolID());
					tf.setBusinessFlowLnkID("C01S010");
					// 刀具状态
					tf.setToolState("9");
					// 更新者
					tf.setUpdateUser(customerID);
					// 更新刀具流转表 刀具状态
					c01S008Service.updateTooltransfer(tf);

					Synthesisknife sk = new Synthesisknife();
					// 更新条件 - RFID
					sk.setrFID(rfidContainerIDsArr[i]);
					// 使用状态 - 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上6:已拆分7:已出厂修磨)
					sk.setLoadState("9");
					// 更新者
					sk.setUpdateUser(customerID);
					sk.setBusinessFlowLnkID("C01S010");
					// 更新合成刀库表是否安装为0设备装入
					c01S008Service.updateSynthesisknife(sk);
					// 需要授权的场合
					if ("1".equals(authorizationFlgsArr[i])) {
						Authorization authorization = new Authorization();
						// 授权ID
						authorization.setAuthorizationID(getId());
						// 授权人ID
						authorization.setAuthorizationUserID(authorizationUserID );
						// 授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
						authorization.setAuthorizedReason("5");
						// 授权时间
						authorization.setAuthorizedTime(new Date());
						// 创建人
						authorization.setCreateUserID(customerID );
						// 修改人
						// authorization.setUpdateUser(customerID);
						// 修改时间
						// authorization.setUpdateTime(new Date());k
						// 创建时间
						// authorization.setCreateTime(new Date());
						// 刀具ID
						authorization.setToolID(synthesisParametersCodesArr[i]);
						// 材料号
						authorization
								.setToolCode(synthesisParametersCodesArr[i]);
						// 流程ID
						authorization.setBusinessCode("C01S010");
						authorization.setNote("重复换装");
						// 插入授权表
						c01S019Service.insertAuthorizationDao(authorization);
					}
				}
				for (int i = 0; i < toolCodesArr.length; i++) {

					Tool t = new Tool();
					// 刀具编码(材料号)
					t.setToolCode(toolCodesArr[i]);
					// 根据刀具码查询刀具信息
					Tool tool = c01S001Service.searchBitInputInf(t);
					// 根据材料号查询流转统计表数据
					TooltransferTotal tst = c01S005Service
							.getTooltransferTotalInfoByToolCode(toolCodesArr[i]);
					// 换装数量
					Integer number = Integer.valueOf(changeNumbersArr[i]);
					// 丢刀数量
					Integer lostNumber = Integer.valueOf(lostNumbersArr[i]);

					if (null != tst) {
						if (number > 0 || lostNumber > 0) {

							Integer scrapSum = 0;
							// 更新条件-刀具材料号
							tst.setToolCode(toolCodesArr[i]);

							// 根据材料号查询刀具参数信息
							Tool toolEntity = new Tool();
							toolEntity.setToolCode(toolCodesArr[i]);
							// 根据刀具码查询刀具信息
							Tool toolInfo = c01S001Service
									.searchBitInputInf(toolEntity);
							// 新备刀数量 = 当前备刀数量-换装数量-丢刀数量
							tst.setSpareKnifeSum(tst.getSpareKnifeSum()
									- number - lostNumber);

							// 换刀 并且换下的刀具为一次性时 报废
							if ("2".equals(toolInfo.getToolConsumetype())
									&& number > 0) {
								scrapSum += number;
								
								Scrap entity = new Scrap();
								entity.setScrapID(getId());
								entity.setBusinessID("C01S010");
								// 材料号
								entity.setMaterial(toolCodesArr[i]);
								// 刀具ID
								entity.setToolID(tool.getToolID());
								// 报废数量
								entity.setScrapNumber(BigDecimal
										.valueOf(number));
								// 报废原因
								entity.setScrapCause("一次性换下报废");
								// 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
								entity.setScrapState("2");
								// 创建者
								entity.setCreateUser(customerID);
								// 插入报废表数据
								c01S005Service.insertScrap(entity);

								// Tooltransfer ttEntity = new Tooltransfer();
								// ttEntity.setRfidContainerID(tool
								// .getRfidContainerID());
								// ttEntity.setToolID(tool.getToolID());
								// ttEntity.setDelFlag("0");
								// List<Tooltransfer> ttList = c01S003Service
								// .searchTooltransferList(ttEntity);
								Tooltransferhistory tth = new Tooltransferhistory();
								tth.setToolTransferHistoryID(getId());
								tth.setRfidContainerID(tool
										.getRfidContainerID()); // RFID载体ID
								tth.setKnifeInventoryCode("");// 刀具入库编码
								tth.setToolID(tool.getToolID());// 刀具ID
								tth.setToolProcuredID("");// 采购ID
								tth.setBusinessFlowLnkID("C01S010");// 最后执行业务流程
								tth.setToolDurable(Integer
										.valueOf(lostNumbersArr[i]));// 数量
								tth.setToolSharpennum(BigDecimal.ZERO);// 可使用(刃磨)次数
								tth.setToolSharpenCriterion(BigDecimal.ZERO);// 复磨标准
								tth.setToolLength(BigDecimal.ZERO);// 刀具长度
								tth.setToolSharpenLength(BigDecimal.ZERO);// 可刃磨长度
								tth.setUsageCounter(0);// 已使用(刃磨)次数
								tth.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
								tth.setInstallationState("1");// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
								tth.setToolState("9");// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
								tth.setinUser(customerID);// 接收人
								tth.setoutUser(customerID);
								tth.setStockState("1");// 报废
								tth.setUpdateUser(customerID);// 更新者
								tth.setCreateUser(customerID);// 创建者
								// 新增刀具流转履历
								c01S010Service.insertTooltransferhistory(tth);

								// 新建换领申请表数据
								Redemptionapplied r = new Redemptionapplied();
								r.setRedemptionAppliedID(getId());
								r.setToolCode(toolCodesArr[i]);
								r.setAppliedNumber(BigDecimal.valueOf(number));
								r.setApplyUser(customerID);
								r.setProcessingStatus("0");
								c01S005Service.insertRedemptionapplied(r);
							} else {
								// 当刀具材料的修磨类型为厂外修磨时
								if ("1".equals(toolInfo.getToolGrinding())) {

									// 待厂外修磨数量 = 当前待厂外修磨数量+换装数量
									tst.setStayExternalGrindingSum(tst
											.getStayExternalGrindingSum()
											+ number);

									// 当刀具材料的修磨类型未厂内修磨或厂外涂层时 注:厂外涂层先厂内修磨再厂外涂层
								} else {

									// 待修磨数量 = 当前修磨+换装数量
									tst.setGrindingFactorySnum(tst
											.getGrindingFactorySnum() + number);
								}
							}

							if (lostNumber > 0) {
								scrapSum += lostNumber;
								Scrap entity = new Scrap();
								entity.setScrapID(getId());
								entity.setBusinessID("C01S010");
								// 材料号
								entity.setMaterial(toolCodesArr[i]);
								// 刀具ID
								entity.setToolID(tool.getToolID());
								// 报废数量
								entity.setScrapNumber(BigDecimal
										.valueOf(lostNumber));
								// 报废原因
								entity.setScrapCause("丢刀");
								// 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
								entity.setScrapState("1");
								// 创建者
								entity.setCreateUser(customerID);
								// 插入报废表数据
								c01S005Service.insertScrap(entity);

								// Tooltransfer ttEntity = new Tooltransfer();
								// ttEntity.setRfidContainerID(tool
								// .getRfidContainerID());
								// ttEntity.setToolID(tool.getToolID());
								// ttEntity.setDelFlag("0");
								// List<Tooltransfer> ttList = c01S003Service
								// .searchTooltransferList(ttEntity);
								Tooltransferhistory tth = new Tooltransferhistory();
								tth.setToolTransferHistoryID(getId());
								tth.setRfidContainerID(tool
										.getRfidContainerID()); // RFID载体ID
								tth.setKnifeInventoryCode("");// 刀具入库编码
								tth.setToolID(tool.getToolID());// 刀具ID
								tth.setToolProcuredID("");// 采购ID
								tth.setBusinessFlowLnkID("C01S010");// 最后执行业务流程
								tth.setToolDurable(Integer
										.valueOf(lostNumbersArr[i]));// 数量
								tth.setToolSharpennum(BigDecimal.ZERO);// 可使用(刃磨)次数
								tth.setToolSharpenCriterion(BigDecimal.ZERO);// 复磨标准
								tth.setToolLength(BigDecimal.ZERO);// 刀具长度
								tth.setToolSharpenLength(BigDecimal.ZERO);// 可刃磨长度
								tth.setUsageCounter(0);// 已使用(刃磨)次数
								tth.setToolGrindingLength(BigDecimal.ZERO);// 刀具已刃磨长度
								tth.setInstallationState("1");// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
								tth.setToolState("1");// 刀具状态(0断刀1丢失2不合格3借入4申领9其他)
								tth.setinUser(customerID);// 接收人
								tth.setoutUser(customerID);
								tth.setStockState("1");// 报废
								tth.setUpdateUser(customerID);// 更新者
								tth.setCreateUser(customerID);// 创建者
								// 新增刀具流转履历
								c01S010Service.insertTooltransferhistory(tth);

								// 新建换领申请表数据
								Redemptionapplied r = new Redemptionapplied();
								r.setRedemptionAppliedID(getId());
								r.setToolCode(toolCodesArr[i]);
								r.setAppliedNumber(BigDecimal
										.valueOf(lostNumber));
								r.setApplyUser(customerID);
								r.setProcessingStatus("0");
								c01S005Service.insertRedemptionapplied(r);
							}
							tst.setUpdateUser(customerID);
							// 累积报废数量
							tst.setScrapSum(tst.getScrapSum() + scrapSum);
							// 更新流转统计表数据
							c01S005Service.updateTooltransferTotalInfo(tst);
							// tth.setUpdateTime ( new Date () );// 更新时间
							// tth.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
							// tth.setCreateTime ( new Date () );// 创建时间
							// tth.setVersion ( BigDecimal.ZERO );// 版本号
						}

						// 换装数量大于0时 新增刀具换装履历
						if(number > 0){
							
							ToolChangehistory tch = new ToolChangehistory();
							tch.setChangeID(getId());
							tch.setSynthesisParametersCode(synthesisParametersCodesArr[0]);
							//根据合成刀具编码查询刀具最后一次加工信息
							Synthesistoolsmachining stm = c01S010Service
									.getSynthesistoolsmachiningInfoBySpCode(synthesisParametersCodesArr[0]);
							if(stm == null){
								stm = new Synthesistoolsmachining();
								stm.setAssemblyLineID("");
								stm.setProcessID("");
								stm.setEquipmentID("");
								stm.setPartsID("");
								stm.setAxleID("");
							}
							tch.setAssemblyLineID(stm.getAssemblyLineID());
							tch.setProcessID(stm.getProcessID());
							tch.setEquipmentID(stm.getEquipmentID());
							tch.setPartsID(stm.getPartsID());
							tch.setAxleID(stm.getAxleID());
							tch.setChangeUser(customerID);
							tch.setToolCode(toolCodesArr[i]);
							tch.setChangeNum(String.valueOf(number));
							// 新增调刀记录信息
							c01S010Service.insetToolChangehistory(tch);

							SynthesisExchange synthesisExchange = new SynthesisExchange();
							synthesisExchange.setRfid(rfidContainerIDs);
							synthesisExchange.setToolID(tool.getToolID());
							synthesisExchange.setToolCode(tool.getToolCode());
							synthesisExchange.setSynthesisParametersID(synthesisParametersCodes);
							c01S010Service.insertSynthesisExchange(synthesisExchange);
						}

					}

				}
				cJsonStr = jsonResult(true, "换装成功");
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
}
