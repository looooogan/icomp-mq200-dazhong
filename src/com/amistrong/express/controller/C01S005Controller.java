package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.response.C01S005Respons;
import com.amistrong.express.beans.response.Redemptionapplied;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Scrap;
import com.amistrong.express.beans.response.ScrapState;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Tubedetailinfo;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S003Service;
import com.amistrong.express.server.C01S005Service;
import com.amistrong.express.server.C01S008Service;
import com.amistrong.express.server.C03S001Service;

/**
 * 刀具报废
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Transactional
@Controller
public class C01S005Controller extends BaseController {

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
	private C01S008Service c01S008Service;

	/**
	 * 非单品刀具报废
	 * 
	 * @param toolCodes
	 *            :刀具编号s scrapNumbers：报废数量s customerID：用户ID scrapState:报废状态
	 *            scrapCause:报废原因 scrapCode:报废流程 1:备刀库2:待修磨（厂内）3:待修磨（厂外）4:厂外修磨5:生产线
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveFScrap", method = RequestMethod.POST)
	public String saveScrap(String toolCodes, String scrapNumbers,
			String customerID, String scrapState, String scrapCause,String scrapCode)
			throws Exception {
		String cJsonStr;
		String message = null;
		try {

			Scrap entity = new Scrap();

			if ("".equals(toolCodes) || null == toolCodes
					|| "".equals(scrapNumbers) || null == scrapNumbers
					|| "".equals(customerID) || null == customerID) {
				// 系统错误,999
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			} else {

				// 材料号
				String[] toolCodesArr = toolCodes.split(",");
				// 报废数量
				String[] scrapNumbersArr = scrapNumbers.split(",");
				for (int i = 0; i < toolCodesArr.length; i++) {
					String rfidContainerId = null;
					Tool t = new Tool();
					// 刀具编码(材料号)
					t.setToolCode(toolCodesArr[i]);
					// 根据刀具码查询刀具信息
					Tool tool = c01S001Service.searchBitInputInf(t);
					if (tool.getToolCode() == null) {
						message = "材料号：" + toolCodesArr[i] + "未找到相应的材料号信息";
						throw new Exception();
					} else {
						// RFID取得
						rfidContainerId = tool.getRfidContainerID();
						if (rfidContainerId == null) {
							message = "材料号：" + toolCodesArr[i] + "不是库位标签材料号";
							throw new Exception();
						}
						// 根据rfid材料载体信息
						Rfidcontainer rfidcontainer = c01S005Service
								.getRfidInfoByRfid(rfidContainerId);
						if (rfidcontainer == null) {
							message = "材料号：" + toolCodesArr[i] + "标签未初始化";
							throw new Exception();
						} else if ((!"0".equals(rfidcontainer.getQueryType()))) {
							message = "材料号：" + toolCodesArr[i] + "不是库位标签材料号";
							throw new Exception();
						}

						if ("1".equals(tool.getToolType())) {
							message = "材料号：" + toolCodesArr[i] + "为辅具材料，不可直接报废";
							throw new Exception();
						}

						if ("2".equals(tool.getToolConsumetype())) {
							message = "材料号：" + toolCodesArr[i]
									+ "为一次性材料，不可直接报废";
							throw new Exception();
						}
						
						// 根据材料号查询流转统计表数据
						TooltransferTotal tst = c01S005Service
								.getTooltransferTotalInfoByToolCode(toolCodesArr[i]);
						
						//报废流程 1:备刀库2:待修磨（厂内）3:待修磨（厂外）4:厂外修磨5:生产线
						if("1".equals(scrapCode)){
							if(tst.getSpareKnifeSum() < Integer.valueOf(scrapNumbersArr[i])){
								message = "材料号：" + toolCodesArr[i]
										+ "备刀数量不足，不可报废";
								throw new Exception();
							}
						}else if("2".equals(scrapCode)){
							if(tst.getGrindingFactorySnum() < Integer.valueOf(scrapNumbersArr[i])){
								message = "材料号：" + toolCodesArr[i]
										+ "厂内待刃磨数量不足，不可报废";
								throw new Exception();
							}
						}else if("3".equals(scrapCode)){
							if(tst.getStayExternalGrindingSum() < Integer.valueOf(scrapNumbersArr[i])){
								message = "材料号：" + toolCodesArr[i]
										+ "厂外待刃磨数不足，不可报废";
								throw new Exception();
							}
						}else if("4".equals(scrapCode)){
							if(tst.getExternalGrindingSum() < Integer.valueOf(scrapNumbersArr[i])){
								message = "材料号：" + toolCodesArr[i]
										+ "厂外修磨数量不足，不可报废";
								throw new Exception();
							}
						}else{
							if(tst.getProductionLineSum() < Integer.valueOf(scrapNumbersArr[i])){
								message = "材料号：" + toolCodesArr[i]
										+ "生产线数量不足，不可报废";
								throw new Exception();
							}
						}

					}
				}

				for (int i = 0; i < toolCodesArr.length; i++) {
					Tool t = new Tool();
					// 刀具编码(材料号)
					t.setToolCode(toolCodesArr[i]);
					// 根据刀具码查询刀具信息
					Tool tool = c01S001Service.searchBitInputInf(t);

					// 报废数量
					Integer scrapNumber = Integer.valueOf(scrapNumbersArr[i]);
					// 已刃磨次数
					// entity.setUsageCounter(tt.getUsageCounter());
					// 刀具类型
					// entity.setToolType(request.getToolType());
					// 报废ID
					entity.setScrapID(getId());
					entity.setBusinessID("C01S005");
					// 材料号
					entity.setMaterial(toolCodesArr[i]);
					// 刀具ID
					entity.setToolID(tool.getToolID());
					// 报废数量
					entity.setScrapNumber(BigDecimal.valueOf(scrapNumber));
					// 报废原因
					entity.setScrapCause(scrapCause);
					// 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
					entity.setScrapState(scrapState);
					// 创建者
					entity.setCreateUser(customerID);
					// 插入报废表数据
					c01S005Service.insertScrap(entity);

					// 根据材料号查询流转统计表数据
					TooltransferTotal tst = c01S005Service
							.getTooltransferTotalInfoByToolCode(toolCodesArr[i]);
					if (null != tst) {
						// 更新条件-刀具材料号
						tst.setToolCode(toolCodesArr[i]);
						
						//报废流程 1:备刀库2:待修磨（厂内）3:待修磨（厂外）4:厂外修磨5:生产线
						if("1".equals(scrapCode)){
							// 新备刀数量 = 当前备刀数量-报废数量
							tst.setSpareKnifeSum(tst.getSpareKnifeSum()
									- scrapNumber.intValue());
						}else if("2".equals(scrapCode)){
							// 厂内待刃磨数量
							tst.setGrindingFactorySnum(tst.getGrindingFactorySnum()
									- scrapNumber.intValue());
						}else if("3".equals(scrapCode)){
							// 厂外待刃磨数量
							tst.setStayExternalGrindingSum(tst.getStayExternalGrindingSum()
									- scrapNumber.intValue());
						}else if("4".equals(scrapCode)){
							// 厂外刃磨数量
							tst.setExternalGrindingSum(tst.getExternalGrindingSum()
									- scrapNumber.intValue());
						}else{
							// 生产线
							tst.setProductionLineSum(tst.getProductionLineSum()
									- scrapNumber.intValue());
						}
						// 累积报废数量
						tst.setScrapSum(tst.getScrapSum() + scrapNumber);
						tst.setUpdateUser(customerID);
						// 更新流转统计表数据
						c01S005Service.updateTooltransferTotalInfo(tst);
					}

					// 新建换领申请表数据
					Redemptionapplied r = new Redemptionapplied();
					r.setRedemptionAppliedID(getId());
					r.setToolCode(toolCodesArr[i]);
					r.setAppliedNumber(BigDecimal.valueOf(scrapNumber));
					r.setApplyUser(customerID);
					r.setProcessingStatus("0");
					c01S005Service.insertRedemptionapplied(r);

				}
				cJsonStr = jsonResult(true, "报废成功");
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
	 * 查询扫码查询一体刀信息
	 * 
	 * @param (String)rfidCode：扫描标签的RFID
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getComposeInfo", method = RequestMethod.POST)
	public String getComposeInfo(String rfidCode) throws Exception {
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
			String laserCode = null;
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
					laserCode = rfidcontainer.getLaserIdentificationCode();
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
				// 非一体刀
				if (!"4".equals(reVal.getCreateType())) {
					cJsonStr = jsonResult(false, "该标签非一体刀标签");
					return cJsonStr;
				}
			}

			// 根据合成刀具码查询刀具信息
			Tool tool = c01S005Service.searchToolInfoBySpcode(reVal
					.getSynthesisParametersCode());

			Tooltransfer ttEntity = new Tooltransfer();
			ttEntity.setRfidContainerID(rfid);
			ttEntity.setToolID(tool.getToolID());
			ttEntity.setDelFlag("0");
			List<Tooltransfer> ttList = c01S003Service
					.searchTooltransferList(ttEntity);
			if (ttList.size() == 0) {
				cJsonStr = jsonResult(false, "未找到该刀具的流转信息");
				return cJsonStr;
			}

			// 待出厂不可报废
			if ("7".equals(reVal.getLoadState())) {
				cJsonStr = jsonResult(false, "该刀具待出厂或已出厂修磨,不可报废");
				return cJsonStr;
			}

			// 未卸下 ,未修磨的一体刀不可报废
			if ("1".equals(reVal.getInstallFlag())
					|| "8".equals(ttList.get(0).getToolState())) {

			} else {
				cJsonStr = jsonResult(false, "不可报废");
				return cJsonStr;

			}

			// 合成刀具编码(系统唯一)
			respons.setSynthesisParametersCode(reVal
					.getSynthesisParametersCode());
			// RFID载体ID
			respons.setRfidContainerID(rfid);
			respons.setLaserCode(laserCode);
			cJsonStr = jsonResult(respons);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 合成刀报废刀具报废
	 * 
	 * @param toolCodes
	 *            :刀具编号s customerID：用户ID scrapState:报废状态 scrapCause:报废原因
	 *            rfidContainerIDs:RFID载体IDs
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveComposeScrap", method = RequestMethod.POST)
	public String saveComposeScrap(String toolCodes, String rfidContainerIDs,
			String customerID, String scrapState, String scrapCause)
			throws Exception {
		String cJsonStr;
		String message = null;
		try {

			Scrap entity = new Scrap();

			if ("".equals(toolCodes) || null == toolCodes
					|| "".equals(customerID) || null == customerID) {
				// 系统错误,999
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			} else {

				// 合成刀具材料号
				String[] toolCodesArr = toolCodes.split(",");
				// RFID载体ID
				String[] rfidContainerIDsArr = rfidContainerIDs.split(",");
				for (int i = 0; i < toolCodesArr.length; i++) {
					// 根据合成刀具码查询对应刀具信息
					Tool tool = c01S005Service
							.searchToolInfoBySpcode(toolCodesArr[i]);

					// 已刃磨次数
					// entity.setUsageCounter(tt.getUsageCounter());
					// 刀具类型
					// entity.setToolType(request.getToolType());
					// 报废ID
					entity.setScrapID(getId());
					entity.setBusinessID("C01S005");
					// 材料号
					entity.setMaterial(tool.getToolCode());
					// 刀具ID
					entity.setToolID(tool.getToolID());
					// 报废数量
					entity.setScrapNumber(BigDecimal.ONE);
					// 报废原因
					entity.setScrapCause(scrapCause);
					// 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
					entity.setScrapState(scrapState);
					// 创建者
					entity.setCreateUser(customerID);
					// 插入报废表数据
					c01S005Service.insertScrap(entity);

					// 更新合成刀对应材料的流转
					// 根据材料号查询流转统计表数据
					TooltransferTotal tst2 = c01S005Service
							.getTooltransferTotalInfoByToolCode(tool
									.getToolCode());
					if (null != tst2) {
						// 更新条件-刀具材料号
						tst2.setToolCode(tool.getToolCode());
						// 新组装数量 = 当前组装数量-报废数量
						// tst2.setProductionLineSum(tst2.getProductionLineSum()
						// - 1);
						// 根据载体ID查询合成刀具编码
						Synthesisknife skentity = new Synthesisknife();
						skentity.setrFID(rfidContainerIDsArr[i]);

						Synthesisknife reVal = c03S001Service
								.getSynCodeByRfidConner(skentity);

						// 根据材料号查询刀具参数信息
						Tool toolEntity = new Tool();
						toolEntity.setToolCode(toolCodesArr[i]);
						// 根据刀具码查询刀具信息
						Tool toolInfo = c01S001Service
								.searchBitInputInf(toolEntity);
						// 卸下后报废的场合
						if ("1".equals(reVal.getLoadState())) {
							// 减待修磨
							// 厂外的场合 减厂外待刃磨
							if("1".equals(toolInfo.getToolGrinding())){
								// 新厂外待修磨 = 当前厂外待刃磨数量-修磨数量
								tst2.setStayExternalGrindingSum(tst2
										.getStayExternalGrindingSum() - 1);
								// 厂内涂层或 厂内修磨 减厂内待修磨
							}else{
								// 新厂外待修磨 = 当前厂外待刃磨数量-修磨数量
								tst2.setGrindingFactorySnum(tst2
										.getGrindingFactorySnum() - 1);
							}

							
							// 修磨后报废的场合
						} else if("4".equals(reVal.getLoadState()) || "10".equals(reVal.getLoadState())){
							
							// 刀具修磨类型为厂外涂层- 厂外待刃磨
							if("2".equals(toolInfo.getToolGrinding())){
								// 新厂外待修磨 = 当前厂外待刃磨数量-修磨数量
								tst2.setStayExternalGrindingSum(tst2
										.getStayExternalGrindingSum() - 1);
								// 刀具修磨类型为厂内修磨或厂外修磨 - 备刀
							}else{
								// 新厂备刀数
								tst2.setSpareKnifeSum(tst2
										.getSpareKnifeSum() - 1);
							}

							//回厂后报废的场合
						}else{
							// 新厂备刀数
							tst2.setSpareKnifeSum(tst2
									.getSpareKnifeSum() - 1);
						}
						//增加累积报废量
						tst2.setScrapSum(tst2.getScrapSum() + 1);
						tst2.setUpdateUser(customerID);
						// 更新流转统计表数据
						c01S005Service.updateTooltransferTotalInfo(tst2);
					}

					// 新建换领申请表数据
					Redemptionapplied r = new Redemptionapplied();
					r.setRedemptionAppliedID(getId());
					r.setToolCode(tool.getToolCode());
					r.setAppliedNumber(BigDecimal.ONE);
					r.setApplyUser(customerID);
					r.setProcessingStatus("0");
					c01S005Service.insertRedemptionapplied(r);

					Synthesisknife sf = new Synthesisknife();
					// 更新条件-合成刀具编码
					sf.setSynthesisParametersCode(toolCodesArr[i]);
					// 更新条件-RFID载体ID
					sf.setrFID(rfidContainerIDsArr[i]);
					sf.setUpdateUser(customerID);
					// 删除合成刀库数据
					c01S005Service.updateSynthesisknife(sf);

					Rfidcontainer container = new Rfidcontainer();
					container.setRfidContainerID(rfidContainerIDsArr[i]);
					container.setDelFlag("1");
					c03S001Service.updateRfidcontainer(container);

				}
				cJsonStr = jsonResult(true, "报废成功");
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
	 * 筒刀信息取得
	 * 
	 * @param (String)rfidCode：扫描标签的RFID materialNum:合成刀材料号
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getTubeInfo", method = RequestMethod.POST)
	public String getTubeInfo(String rfidCode) throws Exception {
		String cJsonStr;
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
			// RFID标签有效验证
			rfidcontainer = c01S001Service.getRfidContainerByRfidCode(rfidCode);
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

			Synthesisknife reVal = c03S001Service
					.getSynCodeByRfidConner(skentity);
			if (null == reVal) {
				cJsonStr = jsonResult(false, "未找到筒刀数据");
				return cJsonStr;
			} else {
				// 非筒刀
				if (!"5".equals(reVal.getCreateType())) {
					cJsonStr = jsonResult(false, "该标签非筒刀标签");
					return cJsonStr;
				}
			}
			// // 合成刀具编码(系统唯一)
			// respons.setSynthesisParametersCode(reVal
			// .getSynthesisParametersCode());
			// 查询当前标签筒刀详细
			List<Tubedetailinfo> tubeToolList = c03S001Service
					.getTubedetailinfoListBySPCode(
							reVal.getSynthesisParametersCode(), rfid);
			if (tubeToolList.size() > 0) {
				cJsonStr = jsonResult(tubeToolList);
			} else {
				cJsonStr = jsonResult(false, "未找到筒刀数据");
			}
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 筒刀报废
	 * 
	 * @param toolCodes
	 *            :刀具编号s synthesisParametersCodes:合成刀具码s customerID：用户ID
	 *            scrapState:报废状态 scrapCause:报废原因 rfidContainerIDs:RFID载体IDs
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveTubeScrap", method = RequestMethod.POST)
	public String saveTubeScrap(String toolCodes, String rfidContainerIDs,
			String toolCounts, String synthesisParametersCodes,
			String customerID, String scrapState, String scrapCause)
			throws Exception {
		String cJsonStr;
		String message = null;
		try {

			Scrap entity = new Scrap();

			if ("".equals(toolCodes) || null == toolCodes
					|| "".equals(customerID) || null == customerID) {
				// 系统错误,999
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			} else {

				// 刀具材料号
				String[] toolCodesArr = toolCodes.split(",");
				// RFID载体IDs
				// String[] rfidContainerIDsArr = rfidContainerIDs.split(",");
				// 报废材料数量
				String[] toolCountsArr = toolCounts.split(",");
				for (int i = 0; i < toolCodesArr.length; i++) {

					// // 根据合成刀具码查询刀具信息
					Tool tool = new Tool();
					tool.setToolCode(toolCodesArr[i]);
					Tool toolInfo = c01S001Service.searchBitInputInf(tool);
					// if (toolInfo == null
					// || toolInfo.getRfidContainerID() == null) {
					// cJsonStr = jsonResult(false, "刀具信息不存在");
					// return cJsonStr;
					// }
					// 刀具ID
					// String toolId = toolInfo.getToolID();

					// 已刃磨次数
					// entity.setUsageCounter(tt.getUsageCounter());
					// 刀具类型
					// entity.setToolType(request.getToolType());
					// 报废ID
					entity.setScrapID(getId());
					entity.setBusinessID("C01S005");
					// 材料号
					entity.setMaterial(toolCodesArr[i]);
					// 刀具ID
					entity.setToolID(toolInfo.getToolID());
					// 报废数量
					entity.setScrapNumber(BigDecimal.valueOf(Double
							.valueOf(toolCountsArr[i])));
					// 报废原因
					entity.setScrapCause(scrapCause);
					// 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
					entity.setScrapState(scrapState);
					// 创建者
					entity.setCreateUser(customerID);
					// 插入报废表数据
					c01S005Service.insertScrap(entity);

					// 根据材料号查询流转统计表数据
					TooltransferTotal tst = c01S005Service
							.getTooltransferTotalInfoByToolCode(toolCodesArr[i]);
					if (null != tst) {
						// 更新条件-刀具材料号
						tst.setToolCode(toolCodesArr[i]);
						// 新备刀数量 = 当前备刀数量-报废数量
						tst.setSpareKnifeSum(tst.getSpareKnifeSum()
								- Integer.valueOf(toolCountsArr[i]));
						tst.setUpdateUser(customerID);
						// 更新流转统计表数据
						c01S005Service.updateTooltransferTotalInfo(tst);
					}

					// 新建换领申请表数据
					Redemptionapplied r = new Redemptionapplied();
					r.setRedemptionAppliedID(getId());
					r.setToolCode(toolCodesArr[i]);
					r.setAppliedNumber(BigDecimal.valueOf(Double
							.valueOf(toolCountsArr[i])));
					r.setApplyUser(customerID);
					r.setProcessingStatus("0");
					c01S005Service.insertRedemptionapplied(r);

					// Tubedetailinfo bean = new Tubedetailinfo();
					// // 更新条件-RFID
					// bean.setrFID(rfidContainerIDsArr[i]);
					// // 更新条件-刀具编号
					// bean.setToolCode(toolCodesArr[i]);
					// // 使用状态(0装入1卸下2修磨3修磨完成4报废)
					// bean.setLoadState("4");
					// // 更新者
					// bean.setUpdateUser(customerID);
					// // 更新筒刀表信息
					// c01S005Service.updateTubedetailinfo(bean);

				}
				cJsonStr = jsonResult(true, "报废成功");
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
	 * 查询刀具报废状态list
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getScrapStateList", method = RequestMethod.POST)
	public String getScrapStateList() throws Exception {
		String cJsonStr;
		try {
			// getMerchantsList
			// 查询刀具报废状态list
			List<ScrapState> scrapStateList = c01S005Service
					.getScrapStateList();

			cJsonStr = jsonResult(scrapStateList);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

}
