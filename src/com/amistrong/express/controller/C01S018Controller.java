package com.amistrong.express.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.response.Authorization;
import com.amistrong.express.beans.response.C01S005Respons;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toolnoticehistory;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S003Service;
import com.amistrong.express.server.C01S005Service;
import com.amistrong.express.server.C01S008Service;
import com.amistrong.express.server.C01S019Service;
import com.amistrong.express.server.C03S001Service;

/**
 * 厂内修磨
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Transactional
@Controller
public class C01S018Controller extends BaseController {

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
	private C01S008Service c01S008Service;

	/**
	 * 非单品刀具修磨信息提交
	 * 
	 * @param toolCodes
	 *            :刀具编号s numbers：修磨数量s customerID：用户ID scrapCause:报废原因
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveGrindingToolInfo", method = RequestMethod.POST)
	public String saveGrindingToolInfo(String toolCodes, String numbers,
			String customerID) throws Exception {
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
				for (int i = 0; i < toolCodesArr.length; i++) {
					String rfidContainerId = null;
					Tool t = new Tool();
					// 刀具编码(材料号)
					t.setToolCode(toolCodesArr[i]);
					// 根据刀具码查询刀具信息
					Tool tool = c01S001Service.searchBitInputInf(t);
					if (tool.getToolCode() == null) {
						message = "材料号：" + toolCodesArr[i] + "的刀具信息不存在，请确认";
						throw new RuntimeException();
					} else {
						// 厂内修磨非单品输入一体刀材料时
						if("1".equals(tool.getToolParametersType())){
							message = "材料号：" + toolCodesArr[i] + "为一体刀材料号，请使用厂内修磨-一体刀功能进行操作";
							throw new RuntimeException();
						}
						// RFID取得
						rfidContainerId = tool.getRfidContainerID();
						if (rfidContainerId == null) {
							message = "材料号：" + toolCodesArr[i] + "不是库位标签材料号";
							throw new RuntimeException();
						}
						// 根据rfid材料载体信息
						Rfidcontainer rfidcontainer = c01S005Service
								.getRfidInfoByRfid(rfidContainerId);
						if (rfidcontainer == null) {
							message = "材料号：" + toolCodesArr[i] + "标签未初始化";
							throw new RuntimeException();
						} else if ((!"0".equals(rfidcontainer.getQueryType()))) {	
							message = "材料号：" + toolCodesArr[i] + "不是库位标签材料号";
							throw new RuntimeException();
						}
					}
					
					if ("1".equals(tool.getToolGrinding())) {
						message = "材料号：" + toolCodesArr[i] + "修磨类别为厂外修磨，不可厂内修磨";
						throw new RuntimeException();
					}
					
					if ("1".equals(tool.getToolType())) {
						message = "材料号：" + toolCodesArr[i] + "为辅具，不可厂内修磨";
						throw new RuntimeException();
					}

					// 修磨数量
					Integer number = Integer.valueOf(numbersArr[i]);

					// 根据材料号查询流转统计表数据
					TooltransferTotal tst = c01S005Service
							.getTooltransferTotalInfoByToolCode(toolCodesArr[i]);
					
					if(tst == null){
						message = "未找到材料号：" + toolCodesArr[i] + "的流转信息，请确认";
						throw new RuntimeException();
					}

					if (tst.getGrindingFactorySnum() < number) {
						message = "材料号：" + toolCodesArr[i]
								+ "当前修磨数量大于待修磨数量，请确认!";
						throw new RuntimeException();
					}


				}
				for (int i = 0; i < toolCodesArr.length; i++) {
					// 根据材料号查询流转统计表数据
					TooltransferTotal tst = c01S005Service
							.getTooltransferTotalInfoByToolCode(toolCodesArr[i]);
					// 根据材料号查询刀具参数信息
					Tool toolEntity = new Tool();
					toolEntity.setToolCode(toolCodesArr[i]);
					// 根据刀具码查询刀具信息
					Tool toolInfo = c01S001Service
							.searchBitInputInf(toolEntity);
					// 修磨数量
					Integer number = Integer.valueOf(numbersArr[i]);
					if (null != tst) {
						// 更新条件-刀具材料号
						tst.setToolCode(toolCodesArr[i]);
						// 新厂内修磨 = 当前备刀数量-修磨数量
						tst.setGrindingFactorySnum(tst.getGrindingFactorySnum()
								- number);
						// 刀具修磨类型为厂外涂层时 加厂外待修磨数
						if ("2".equals(toolInfo.getToolGrinding())) {
							// 新厂外待修磨 = 当前厂外待刃磨数量-修磨数量
							tst.setStayExternalGrindingSum(tst
									.getStayExternalGrindingSum() + number);
						} else {
							// 新备刀数量 = 当前备刀数量+修磨数量
							tst.setSpareKnifeSum(tst.getSpareKnifeSum()
									+ number.intValue());
						}
						tst.setUpdateUser(customerID);
						// 更新流转统计表数据
						c01S005Service.updateTooltransferTotalInfo(tst);
					}

					Toolnoticehistory tnh = new Toolnoticehistory();
					tnh.setKnifeInventoryCode(toolInfo.getKnifeInventoryCode());// 刀具入库编码
					tnh.setToolCode(toolCodesArr[i]);// 材料号
					tnh.setNoticeCount(number);// 修磨数量
					Date date = new Date();
					Calendar c = Calendar.getInstance();
					c.setTime(date);
					c.add(Calendar.SECOND, +i);
					date = c.getTime();
					SimpleDateFormat dateformat = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					tnh.setNoticeTime(dateformat.format(date)); // 刃磨时间
					// tnh.setDelFlag("0");// 删除区分(0有效1删除)
					tnh.setToolRepairNoticeUser(customerID);
					tnh.setCreateUser(customerID);// 创建人
					tnh.setReceiveUser(customerID);// 领取人
					// tnh.setReceiveTime(receiveTime);//领取时间
					tnh.setRepairWay("0"); // 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)
					tnh.setRepairedBecause("0"); // 修复原因(1断刀0正常刃磨)
					// tnh.setCreateTime(new Date());//创建时间
					// tnh.setUpdateTime(new Date());// 更新时间
					tnh.setUpdateUser(customerID);// 更新者
					// tnh.setVersion(BigDecimal.ZERO);//版本号
					// 新增刀具修复履历
					c01S005Service.insertToolnoticehistory(tnh);

				}
				cJsonStr = jsonResult(true, "修磨成功");
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
	@RequestMapping(value = "/getOneKnifeInfo", method = RequestMethod.POST)
	public String getOneKnifeInfo(String rfidCode) throws Exception {
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

				// 未卸下不可修磨
				if (!"1".equals(reVal.getInstallFlag())) {
					cJsonStr = jsonResult(false, "该刀具未卸下，不可修磨");
					return cJsonStr;
				}

			}

			// 根据合成刀具码查询刀具信息
			Tool tool = c01S005Service.searchToolInfoBySpcode(reVal
					.getSynthesisParametersCode());
			
			if ("1".equals(tool.getToolGrinding())) {
				cJsonStr = jsonResult(false, "该刀具修磨类别为厂外修磨");
				return cJsonStr;
			}

			String code = null;
			Tooltransfer ttEntity = new Tooltransfer();
			ttEntity.setRfidContainerID(rfid);
			ttEntity.setToolID(tool.getToolID());
			ttEntity.setDelFlag("0");
			List<Tooltransfer> ttList = c01S003Service
					.searchTooltransferList(ttEntity);
			if (ttList.size() > 0) {
				// 已修磨 重复修磨
				if ("8".equals(ttList.get(0).getToolState())) {
					code = "0";
				} else if ("10".equals(ttList.get(0).getToolState())) {
					cJsonStr = jsonResult(false, "该刀具已出厂修磨");
					return cJsonStr;
				} else {
					code = "1";
				}
			} else {
				cJsonStr = jsonResult(false, "未找到该刀具的流转信息");
				return cJsonStr;
			}

			// 合成刀具编码(系统唯一)
			respons.setSynthesisParametersCode(reVal
					.getSynthesisParametersCode());
			// RFID载体ID
			respons.setRfidContainerID(rfid);
			respons.setCode(code);
			respons.setLaserCode(laserCode);
			cJsonStr = jsonResult(respons);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 一体刀修磨
	 * 
	 * @param toolCodes
	 *            :刀具编号s authorizationFlgs:是否需要授权 customerID：用户ID
	 *            rfidContainerIDs:RFID载体IDs
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveGrindingOneKnifeInfo", method = RequestMethod.POST)
	public String saveGrindingOneKnifeInfo(String toolCodes,
			String authorizationFlgs, String rfidContainerIDs, String customerID,String gruantUserID)
			throws Exception {
		String cJsonStr;
		String message = null;
		try {

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
				// 是否需要授权
				String[] authorizationFlgsArr = authorizationFlgs.split(",");
				for (int i = 0; i < toolCodesArr.length; i++) {

					// 根据合成刀具码查询刀具信息
					Tool tool = c01S005Service
							.searchToolInfoBySpcode(toolCodesArr[i]);
					
					Tool toolEntity2 = new Tool();
					toolEntity2.setToolCode(tool.getToolCode());
					// 根据刀具码查询刀具信息
					Tool toolInfo2 = c01S001Service
							.searchBitInputInf(toolEntity2);
					if(null == toolInfo2.getKnifeInventoryCode() || "".equals(toolInfo2.getKnifeInventoryCode())){
						cJsonStr = jsonResult(false, "未找到" + toolCodesArr[i] + "对应材料的库位信息，请先进行一体刀对应材料的库位标签初始化");
						return cJsonStr;
					}

					Tooltransfer ttEntity = new Tooltransfer();
					ttEntity.setRfidContainerID(rfidContainerIDsArr[i]);
					ttEntity.setToolID(tool.getToolID());
					ttEntity.setDelFlag("0");
					List<Tooltransfer> ttList = c01S003Service
							.searchTooltransferList(ttEntity);
					if (ttList.size() > 0) {

						Tooltransfer tt = new Tooltransfer();
						// 更新者
						tt.setUpdateUser(customerID);
						// 修磨次数+1
						tt.setUsageCounter(ttList.get(0).getUsageCounter() + 1);
						// 最后执行业务流程
						tt.setBusinessFlowLnkID("C01S018");
						tt.setStockState("4");
						tt.setToolState("8");
						// tt.setInstallationState("1");
						// 更新条件
						tt.setRfidContainerID(rfidContainerIDsArr[i]);
						tt.setDelFlag("0");
						tt.setToolID(tool.getToolID());

						// 更新流转表数量
						c01S003Service.updateTooltransfer(tt);
					}
					String loadState = "";
					// 根据材料号查询刀具参数信息
					Tool toolEntity = new Tool();
					toolEntity.setToolCode(tool.getToolCode());
					// 根据刀具码查询刀具信息
					Tool toolInfo = c01S001Service
							.searchBitInputInf(toolEntity);
					// 刀具修磨类型为厂外涂层时 加厂外待修磨数
					if ("2".equals(toolInfo.getToolGrinding())) {
						// 刀具状态-厂外待修磨
						loadState = "10";
					} else {
						// 刀具状态-厂内修磨
						loadState = "4";
					}
					// 需要授权的场合
					if ("1".equals(authorizationFlgsArr[i])) {
						Authorization authorization = new Authorization();
						// 授权ID
						authorization.setAuthorizationID(getId());
						// 授权人ID
						authorization.setAuthorizationUserID(gruantUserID);
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
						c01S019Service.insertAuthorizationDao(authorization);
					} else {

						// 根据一体刀材料号查询流转统计表数据
						TooltransferTotal tst = c01S005Service
								.getTooltransferTotalInfoByToolCode(tool
										.getToolCode());
						if (null != tst) {
							// 更新条件-刀具材料号
							tst.setToolCode(tool.getToolCode());
							// 新厂内修磨数量 = 当前修磨数量-修磨数量
							tst.setGrindingFactorySnum(tst
									.getGrindingFactorySnum() - 1);

							// 刀具修磨类型为厂外涂层时 加厂外待修磨数
							if ("2".equals(toolInfo.getToolGrinding())) {
								// 新厂外待修磨 = 当前厂外待刃磨数量-修磨数量
								tst.setStayExternalGrindingSum(tst
										.getStayExternalGrindingSum() + 1);
							}
							tst.setUpdateUser(customerID);
							// 更新流转统计表数据
							c01S005Service.updateTooltransferTotalInfo(tst);
						}

						// 更新材料号对应流转数据
						// 根据材料号材料号查询流转统计表数据
						// TooltransferTotal tst2 = c01S005Service
						// .getTooltransferTotalInfoByToolCode(toolCodesArr[i]);
						// if (null != tst2) {
						// // 更新条件-刀具材料号
						// tst2.setToolCode(toolCodesArr[i]);
						// // 新备刀数量 = 当前备刀数量+修磨数量
						// tst2.setSpareKnifeSum(tst2.getSpareKnifeSum() + 1);
						// // 新厂内修磨数量 = 当前修磨数量-修磨数量
						// tst2.setGrindingFactorySnum(tst2
						// .getGrindingFactorySnum() - 1);
						// // 刀具修磨类型为厂外涂层时 加厂外待修磨数
						// if ("2".equals(toolInfo.getToolGrinding())) {
						// // 新厂外待修磨 = 当前厂外待刃磨数量-修磨数量
						// tst2.setStayExternalGrindingSum(tst2
						// .getStayExternalGrindingSum() + 1);
						// }
						// tst2.setUpdateUser(customerID);
						// // 更新流转统计表数据
						// c01S005Service.updateTooltransferTotalInfo(tst2);
						// }
					}

					Synthesisknife sk = new Synthesisknife();
					// 更新条件 - RFID
					sk.setrFID(rfidContainerIDsArr[i]);
					// 使用状态 -
					sk.setLoadState(loadState);
					// 更新者
					sk.setUpdateUser(customerID);
					sk.setBusinessFlowLnkID("C01S018");
					// 更新合成刀库表使用状态
					c01S008Service.updateSynthesisknife(sk);

					
					Toolnoticehistory tnh = new Toolnoticehistory();
					tnh.setKnifeInventoryCode(toolInfo2.getKnifeInventoryCode());// 刀具入库编码
					tnh.setToolCode(tool.getToolCode());// 材料号
					tnh.setNoticeCount(1);// 修磨数量
					Date date = new Date();
					Calendar c = Calendar.getInstance();
					c.setTime(date);
					c.add(Calendar.SECOND, +i);
					date = c.getTime();
					SimpleDateFormat dateformat = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");

					tnh.setNoticeTime(dateformat.format(date)); // 刃磨时间
					// tnh.setDelFlag("0");// 删除区分(0有效1删除)
					tnh.setToolRepairNoticeUser(customerID);
					tnh.setCreateUser(customerID);// 创建人
					tnh.setReceiveUser(customerID);// 领取人
					// tnh.setReceiveTime(receiveTime);//领取时间
					tnh.setRepairWay("0"); // 修复方式(0厂内复磨1厂内维修2厂内图层3出厂图层4出厂维修)
					tnh.setRepairedBecause("0"); // 修复原因(1断刀0正常刃磨)
					// tnh.setCreateTime(new Date());//创建时间
					// tnh.setUpdateTime(new Date());// 更新时间
					tnh.setUpdateUser(customerID);// 更新者
					// tnh.setVersion(BigDecimal.ZERO);//版本号
					// 新增刀具修复履历
					c01S005Service.insertToolnoticehistory(tnh);

				}
				cJsonStr = jsonResult(true, "修磨成功");
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
