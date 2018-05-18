package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.response.C03S001Respons;
import com.amistrong.express.beans.response.FLBRespons;
import com.amistrong.express.beans.response.Knifeinventory;
import com.amistrong.express.beans.response.Oplink;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.SynthesisEntity;
import com.amistrong.express.beans.response.Synthesiscutterlocation;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Synthesisparameters;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Tubedetailinfo;
import com.amistrong.express.beans.response.Vknifeinventoryinfo;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S005Service;
import com.amistrong.express.server.C01S008Service;
import com.amistrong.express.server.C01S023Service;
import com.amistrong.express.server.C03S001Service;

/**
 * 合成刀具初始化
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Controller
public class C03S001Controller extends BaseController {

	// 注入(Spring提供的) 默认按类型装配
	@Autowired
	private C03S001Service c03S001Service;

	@Autowired
	private C01S001Service c01S001Service;

	@Autowired
	private C01S005Service c01S005Service;

	@Autowired
	private C01S008Service c01S008Service;
	
	@Autowired
	private C01S023Service c01S023Service;

	/**
	 * 查询合成刀具初始化信息
	 * 
	 * @param (String)rfidCode：扫描标签的RFID materialNum:合成刀材料号
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/seachFInitSynthesisByRfid", method = RequestMethod.POST)
	public String seachFInitSynthesisByRfid(String rfidCode,
			String materialNum, String flg, String laserCode) throws Exception {
		String cJsonStr;
		String responsconfigCode;
		C03S001Respons respons = new C03S001Respons();
		try {

			// 参数验证
			if ((null == rfidCode || "".equals(rfidCode))
					&& (null == materialNum || "".equals(materialNum))) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}
			Rfidcontainer rfidcontainer = new Rfidcontainer();
			// 根据载体ID查询合成刀具编码
			Synthesisknife skentity = new Synthesisknife();
			String rfid = null;
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
					Synthesisknife reVal = c03S001Service
							.getSynCodeByRfidConner(skentity);
					if (null == reVal) {
						cJsonStr = jsonResult(false, "未找到合成刀数据");
						return cJsonStr;
					}

					if ("6".equals(reVal.getLoadState())) {
						cJsonStr = jsonResult(false, "当前刀具已拆分，不可初始化");
						return cJsonStr;
					}
					materialNum = reVal.getSynthesisParametersCode();
				}
				// 输入材料号的场合
			} else {
				// 材料号
				skentity.setSynthesisParametersCode(materialNum);
			}

			// 取得当前合成刀具组成
			Synthesisparameters synthesisparameters = new Synthesisparameters();
			synthesisparameters.setSynthesisParametersCode(materialNum);
			List<Synthesisparameters> synthesisparametersList = (List<Synthesisparameters>) c03S001Service
					.searchSynthesisparameters(synthesisparameters);
			if (synthesisparametersList.size() == 0) {
				cJsonStr = jsonResult(false, "未找到合成刀数据");
				return cJsonStr;
			} else if ("4".equals(synthesisparametersList.get(0)
					.getCreateType())) {
				cJsonStr = jsonResult(false, "不可初始化一体刀");
				return cJsonStr;
			}
			// 合成刀初始化不可初始化筒刀
			if ("0".equals(flg)) {
				if ("5".equals(synthesisparametersList.get(0).getCreateType())) {
					cJsonStr = jsonResult(false, "不可初始化筒刀");
					return cJsonStr;
				}
				
				if ("6".equals(synthesisparametersList.get(0).getCreateType())) {
					cJsonStr = jsonResult(false, "不可初始化专机");
					return cJsonStr;
				}

				// 筒刀初始化只可初始化筒刀
			} else if ("1".equals(flg)) {
				if (!"5".equals(synthesisparametersList.get(0).getCreateType())) {
					cJsonStr = jsonResult(false, "只可初始化筒刀");
					return cJsonStr;
				}
				// 验证激光码是否重复
				Integer count = c01S023Service
						.getLaserCodeCountByLaserCode(materialNum + laserCode);

				if (count > 0) {
					cJsonStr = jsonResult(false, "单品编码重复");
					return cJsonStr;
				}
				
			}
			// 合成刀具编码(系统唯一)
			respons.setSynthesisParametersCode(materialNum);
			// 组成类型
			respons.setCreateType(synthesisparametersList.get(0)
					.getCreateType());
			// 合成刀组成刀具list
//			Synthesisparameters synthesisparametersTmp = null;
//			for (int i =0;i<synthesisparametersList.size();i++){
//				synthesisparametersTmp = synthesisparametersList.get(i);
//				synthesisparametersTmp.setSynthesisEntities(c03S001Service
//						.getSynthesisToolListBySPCode(materialNum));
//			}
			List<SynthesisEntity> toolList = c03S001Service
					.getSynthesisToolListBySPCode(materialNum);
			respons.setToolList(toolList);
			respons.setSynthesisparametersList(synthesisparametersList);
			cJsonStr = jsonResult(respons);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 提交初始化合成刀具信息
	 * 
	 * @param (String)rfidCode：扫描标签的RFID spCode:合成刀具码
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/submitFInitSynthesis", method = RequestMethod.POST)
	public String submitFInitSynthesis(String rfidCode, String spCode,
			String customerId, String handSetId, String createType, String flg,String synthesisflg,String laserCode,String confCode) {
		String cJsonStr;
		try {
			String[] rfidCodeArr = rfidCode.split(",");

			for (int k = 0; k < rfidCodeArr.length; k++) {
				
				Rfidcontainer rfBean = new Rfidcontainer();
				rfBean.setUpdateUser(customerId);
				rfBean.setRfidCode(rfidCodeArr[k]);
				// try {
				// 查询已经有的合成刀具信息
				List<Synthesisknife> skList = c03S001Service
						.findskListByRfidList(rfidCodeArr[k]);
				if (skList.size() > 0) {
					// 删除流转中的数据
					c03S001Service.updateBatchDeFlagByRfid(rfBean);
					Synthesisknife sk1 = null;
					// 删除合成刀库中的数据
					for (Synthesisknife sk : skList) {
						// 合成刀库
						sk1 = new Synthesisknife();
						sk1.setUpdateUser(customerId);
						sk1.setSynthesisParametersCode(sk
								.getSynthesisParametersCode());
						sk1.setSynthesisParametersNumber(sk
								.getSynthesisParametersNumber());
						c03S001Service.updateSynthesisknifeDeFlag(sk1);
					}
				}

				// 取得当前合成刀具组成
				Synthesisparameters synthesisparameters = new Synthesisparameters();
				synthesisparameters.setSynthesisParametersCode(spCode);
				synthesisparameters.setConfigurationCode(confCode);
				List<Synthesisparameters> synthesisparametersList = (List<Synthesisparameters>) c03S001Service
						.searchSynthesisparameters(synthesisparameters);
				String synthesisparametersID = synthesisparametersList.get(0)
						.getSynthesisParametersID();
				// 为刀具生命周期查询零部件id
				//Oplink oplink = new Oplink();
				//oplink.setSynthesisParametersID(synthesisparametersID);
				// List<Oplink> oplinklist = (List<Oplink>) c03S001Service
				// .searchOplink(oplink);
				// String partsID = oplinklist.get(0).getPartsID();
				Synthesiscutterlocation synthesiscutterlocation = new Synthesiscutterlocation();
				synthesiscutterlocation
						.setSynthesisParametersID(synthesisparametersID);
				List<Synthesiscutterlocation> synthesiscutterlocationList = (List<Synthesiscutterlocation>) c03S001Service
						.searchSynthesiscutterlocation(synthesiscutterlocation);
				List<Tooltransfer> inputList = new ArrayList<Tooltransfer>();
				// List<TooltransferTotal> tooltransferTotalList = new
				// ArrayList<TooltransferTotal>();
				String rfidID = null;
				// 获取RFID载体ID 如果不存在则新建数据
				Rfidcontainer rfidcontainer = new Rfidcontainer();
				rfidcontainer.setRfidCode(rfidCodeArr[k]);
				Rfidcontainer rfidcontainerList = c01S001Service
						.getRfidContainerByRfidCode(rfidCodeArr[k]);
				if (rfidcontainerList == null) {
					// 新建载体数据
					rfidcontainer.setBandType("0");
					rfidcontainer.setQueryType("2");
					// rfidcontainer.setDelFlag("0");
					// rfidcontainer.setVersion("0");
					// rfidcontainer.setUpdateTime(new Date());
					rfidcontainer.setUpdateUser(customerId);
					rfidcontainer.setSystemLogUser(customerId);
					rfidcontainer.setRfidReCount(1.0);
					rfidID = getId();
					rfidcontainer.setRfidContainerID(rfidID);
					if("1".equals(synthesisflg)){
						rfidcontainer.setLaserIdentificationCode(spCode + laserCode);
					}
					c03S001Service.insertRfidcontainer(rfidcontainer);
				} else {
					// 如果删除区分为无效
					rfidcontainer = rfidcontainerList;
					if ("1".equals(rfidcontainer.getDelFlag())) {
						rfidID = rfidcontainer.getRfidContainerID();
						Rfidcontainer entity = new Rfidcontainer();
						if (rfidcontainer.getRfidReCount() == null) {
							entity.setRfidReCount(1.0);
						} else {
							entity.setRfidReCount(rfidcontainer
									.getRfidReCount() + 1);
						}
						entity.setRfidContainerID(rfidcontainer
								.getRfidContainerID());
						entity.setDelFlag("0");
						if("1".equals(synthesisflg)){
							entity.setLaserIdentificationCode(spCode + laserCode);
						}
						c03S001Service.updateRfidcontainer(entity);
					} else {
						rfidID = rfidcontainer.getRfidContainerID();
						Rfidcontainer entity = new Rfidcontainer();
						entity.setRfidReCount(rfidcontainer.getRfidReCount() + 1);
						entity.setRfidContainerID(rfidcontainer
								.getRfidContainerID());
						entity.setDelFlag("0");
						if("1".equals(synthesisflg)){
							entity.setLaserIdentificationCode(spCode + laserCode);
						}
						c03S001Service.updateRfidcontainer(entity);
					}
				}
				// 建立组成该合成刀具的流转刀具数据
				for (Synthesiscutterlocation synthesiscutterlocation2 : synthesiscutterlocationList) {
					// 取得刀具参数ID
					Tool tool = new Tool();
					tool.setToolCode(synthesiscutterlocation2.getToolCode());
					Tool toolInfo = c01S001Service.searchBitInputInf(tool);
					if (toolInfo == null) {
						// 当前刀具编码未记录!
						cJsonStr = jsonResult(false, "当前刀具编码未记录");
						return cJsonStr;
					}

					Tooltransfer tooltransfer = new Tooltransfer();
					tooltransfer.setToolID(toolInfo.getToolID());// 刀具编码
					tooltransfer
							.setToolSharpennum(toolInfo.getToolSharpennum());// 可使用(刃磨)次数
					tooltransfer.setToolSharpenCriterion(toolInfo
							.getToolSharpenCriterion());// 复磨标准
					tooltransfer.setBusinessFlowLnkID("C03S001");// 最后业务流程
					tooltransfer.setToolDurable(synthesiscutterlocation2
							.getToolCount());// 数量
					// TODO
					tooltransfer.setProcuredBatch("20170701");
					tooltransfer.setToolLength(toolInfo.getToolLength());// 刀具长度
					tooltransfer.setToolSharpenLength(toolInfo
							.getToolSharpenLength());// 可刃磨长度
					tooltransfer.setStockState("4");// 库存状态
					tooltransfer.setToolGrindingLength(BigDecimal.ZERO);
					tooltransfer.setUsageCounter(0);
					tooltransfer.setInstallationState("0");// 未安装
					tooltransfer.setToolState("3");// 待分拣(在生产线上)
					// tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
					// tooltransfer.setCreateTime(new Date());
					// tooltransfer.setUpdateTime(new Date());
					tooltransfer.setCreateUser(customerId);
					tooltransfer.setUpdateUser(customerId);
					// tooltransfer.setVersion("0");
					tooltransfer.setRfidContainerID(rfidID);
					Thread.sleep(1);
					tooltransfer.setKnifeInventoryCode(String
							.valueOf(getTimes()));
					tooltransfer
							.setSynthesisCutterNumber(synthesiscutterlocation2
									.getSynthesisCutterNumber());
					// 车间
					tooltransfer.setToolThisState("4");
					inputList.add(tooltransfer);

					// 根据材料号查询流转统计表数据
					TooltransferTotal tst = c01S005Service
							.getTooltransferTotalInfoByToolCode(synthesiscutterlocation2
									.getToolCode());
					if (null != tst) {
						// 更新条件-刀具材料号
						tst.setToolCode(synthesiscutterlocation2.getToolCode());
						tst.setUpdateUser(customerId);
						// 组装数量
						tst.setProductionLineSum(tst.getProductionLineSum()
								+ synthesiscutterlocation2.getToolCount());

						// 更新流转统计表数据
						c01S005Service.updateTooltransferTotalInfo(tst);
					} else {
						tst = new TooltransferTotal();
						// 更新条件-刀具材料号
						tst.setToolCode(synthesiscutterlocation2.getToolCode());
						tst.setUpdateUser(customerId);
						tst.setCreateUser(customerId);
						// 组装数量
						tst.setProductionLineSum(synthesiscutterlocation2
								.getToolCount());
						// 新增流转统计表数据
						c03S001Service.insertTooltransferTotalInfo(tst);
					}

					// TooltransferTotal tooltransferTotal = new
					// TooltransferTotal();
					// tooltransferTotal.setToolCode(synthesiscutterlocation2
					// .getToolCode());
				}
				int j = 0;// 遍历位置信息使用
				// 取得合成刀具序号
				Synthesisknife entity = new Synthesisknife();
				entity.setSynthesisParametersCode(spCode);// 合成刀具编码
				// entity.setOrderString("ABS(SynthesisParametersNumber) desc");
				// entity.setRowCount(1);
				Synthesisknife sk1 = c03S001Service
						.searchBySynthesisknife(entity);
				String synthesisParametersNumber = "001";
				if (sk1 != null) {
					int temp = Integer.parseInt(sk1
							.getSynthesisParametersNumber());
					if (temp < 9) {
						synthesisParametersNumber = "00" + (temp + 1);
					} else if (temp < 99) {
						synthesisParametersNumber = "0" + (temp + 1);
					} else {
						synthesisParametersNumber = (temp + 1) + "";
					}

					// synthesisParametersNumber =
					// synthesisParametersNumber.substring(synthesisParametersNumber.length()
					// - 3);
				}
				// List<Toolwholelifecycle> toolwholelifecycles = new
				// ArrayList<Toolwholelifecycle>();
				List<Synthesisknife> synthesisknifes = new ArrayList<Synthesisknife>();
				// Toolwholelifecycle toolwholelifecycle = null;
				for (Tooltransfer tooltransfer : inputList) {
					// 合成刀库数据建立
					Synthesisknife synthesisknife = new Synthesisknife();
					synthesisknife.setSynthesisParametersCode(spCode);// 合成刀具编码
					synthesisknife
							.setSynthesisParametersNumber(synthesisParametersNumber);
					synthesisknife.setSynthesisCutterNumber(tooltransfer
							.getSynthesisCutterNumber());// 位置号
					synthesisknife.setBusinessFlowLnkID("C03S001");// 最后流程ID
					synthesisknife.setKnifeInventoryCode(tooltransfer
							.getKnifeInventoryCode());// 刀具入库编码
					// RFID
					synthesisknife.setrFID(rfidID);
					// 是否安装
					synthesisknife.setInstallFlag("9");
					synthesisknife.setLoadState("3");
					synthesisknife.setOffloadType(BigDecimal.ZERO.toString());
					synthesisknife.setxPoint(BigDecimal.ZERO);
					synthesisknife.setyPoint(BigDecimal.ZERO);
					// synthesisknife.setDelFlag("0");
					// synthesisknife.setCreateTime(new Date());
					// synthesisknife.setUpdateTime(new Date());
					// synthesisknife.setCreateUser(customerId);
					synthesisknife.setUpdateUser(customerId);
					// synthesisknife.setVersion(BigDecimal.ZERO);
					synthesisknifes.add(synthesisknife);
					j++;
					// 记录刀具生命周期
					Tool tool = new Tool();
					tool.setToolID(tooltransfer.getToolID());
					tool = c03S001Service.searchTool(tool);
					if (tool == null) {
						// 当前刀具编码未记录!
						cJsonStr = jsonResult(false, "当前刀具编码未记录");
						return cJsonStr;
					}
					// toolwholelifecycle = new Toolwholelifecycle();
					// toolwholelifecycle.setBusinessFlowLnkID("C03S001");
					// toolwholelifecycle.setToolID(tool.getToolID());
					// toolwholelifecycle.setHandSetID(handSetId);
					// toolwholelifecycle.setPartsID(partsID);
					// toolwholelifecycle.setKnifeInventoryCode(tooltransfer
					// .getKnifeInventoryCode());
					// toolwholelifecycle.setProcessAmount("0");
					// // toolwholelifecycle.setDelFlag("0");
					// // toolwholelifecycle.setCreateTime(new Date());
					// // toolwholelifecycle.setUpdateTime(new Date());
					// toolwholelifecycle.setCreateUser(customerId);
					// toolwholelifecycle.setUpdateUser(customerId);
					// // toolwholelifecycle.setVersion(BigDecimal.ZERO);
					// toolwholelifecycle.setToolWholeLifecycleID(getId());
					// toolwholelifecycles.add(toolwholelifecycle);
				}

//				List<Tubedetailinfo> tubedetailinfoList = new ArrayList<Tubedetailinfo>();
//				// 如果刀具类型为筒刀
//				if ("5".equals(createType)) {
//					// 合成刀组成刀具list
//					List<SynthesisEntity> toolList = c03S001Service
//							.getSynthesisToolListBySPCode(spCode);
//					// 清除原筒刀的RFID
//					c03S001Service.updateTubedetailinfoRfidEmpty(rfidID);
//					// 建立组成该合成刀具的筒刀数据
//					for (int i = 0; i < toolList.size(); i++) {
//						Tubedetailinfo bean = new Tubedetailinfo();
//						bean.setID(getId());
//						bean.setSynthesisParametersCode(spCode);
//						bean.setrFID(rfidID);
//						bean.setSynthesisCutterNumber(i);
//						bean.setToolCode(toolList.get(i).getToolCode());
//						bean.setLoadState("0");
//						bean.setToolCount(toolList.get(i).getToolCount());
//						bean.setGrindingsum(0);
//						bean.setCreateUser(customerId);
//						bean.setUpdateUser(customerId);
//						tubedetailinfoList.add(bean);
//					}
//				}

				// 重新初始化的场合 减掉原刀具对应材料的组装中的刀具
				if ("1".equals(flg)) {
					// 查询刀具参数
					List<Synthesiscutterlocation> syList = (List<Synthesiscutterlocation>) c03S001Service
							.searchSynthesiscutterlocationByRfid(rfidID);
					for (int i = 0; i < syList.size(); i++) {
						// 根据材料号查询流转统计表数据
						TooltransferTotal tst = c01S005Service
								.getTooltransferTotalInfoByToolCode(syList.get(
										i).getToolCode());
						if (null != tst) {
							// 更新条件-刀具材料号
							tst.setToolCode(syList.get(i).getToolCode());
							tst.setUpdateUser(customerId);
							// 组装数量
							tst.setProductionLineSum(tst.getProductionLineSum()
									- syList.get(i).getToolCount());

							// 更新流转统计表数据
							c01S005Service.updateTooltransferTotalInfo(tst);
						}
					}

				}

				// if (toolwholelifecycles.size() > 0) {
				// c03S001Service
				// .insertToolwholelifecycle(toolwholelifecycles);
				// }
				if (inputList.size() > 0) {
					c03S001Service.insertTooltransfer(inputList);
				}
				if (synthesisknifes.size() > 0) {
					c03S001Service.insertSynthesisknife(synthesisknifes);
				}
//				if (tubedetailinfoList.size() > 0) {
//					c03S001Service.insertTubedetailinfo(tubedetailinfoList);
//				}
			}
			cJsonStr = jsonResult(true);

		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 判断初始化标签是否可用
	 * 
	 * @param (String)rfidCode：扫描标签的RFID spCode:合成刀具码
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/checkInitSynthesis", method = RequestMethod.POST)
	public String checkInitSynthesis(String rfidCode, String spCode) {
		String cJsonStr;
		try {
			Rfidcontainer rfidcontainer = new Rfidcontainer();

			// RFID标签有效验证
			rfidcontainer = c01S001Service.getRfidContainerByRfidCode(rfidCode);
			if (rfidcontainer == null) {
				cJsonStr = jsonResult(true, "");
				return cJsonStr;
			} else if ((!"2".equals(rfidcontainer.getQueryType()))) {
				cJsonStr = jsonResult(false, "请扫描合成刀具标签或空标签");
				return cJsonStr;
			} else {
				// 根据载体ID查询合成刀具编码
				Synthesisknife skentity = new Synthesisknife();
				// 载体ID
				skentity.setrFID(rfidcontainer.getRfidContainerID());
				Synthesisknife reVal = c03S001Service
						.getSynCodeByRfidConner(skentity);
				if (null == reVal) {
					cJsonStr = jsonResult(false, "标签非合成刀具");
					return cJsonStr;
				}

				if ("6".equals(reVal.getLoadState())) {
					cJsonStr = jsonResult(false, "当前刀具已拆分，不可初始化");
					return cJsonStr;
				}

				// 1已初始化
				cJsonStr = jsonResult(true,
						"合成刀具编码" + reVal.getSynthesisParametersCode()
								+ "已经初始化，是否重新初始化？");

			}

		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 按材料号查询库存标签信息
	 * 
	 * @param (String)toolCode：材料号
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/findLibraryCodeMsg", method = RequestMethod.POST)
	public String findLibraryCodeMsg(String toolCode) throws Exception {
		FLBRespons respons = new FLBRespons();
		String cJsonStr;
		try {
			// 参数验证
			if (null == toolCode || "".equals(toolCode)) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}
			Vknifeinventoryinfo v = new Vknifeinventoryinfo();
			v.setToolCode(toolCode);
			// 根据材料号查询库存信息
			Vknifeinventoryinfo reVal = c03S001Service
					.getknifeinventoryinfos(v);
			if (reVal == null) {
				cJsonStr = jsonResult(false, "未找到当前材料号对应的库存信息");
				return cJsonStr;
			}
			respons.setToolCode(reVal.getToolCode());
			respons.setToolID(reVal.getToolID());
			if ("0".equals(reVal.getToolConsumetype())) {
				respons.setToolConsumeType("可刃磨钻头");
			} else if ("1".equals(reVal.getToolConsumetype())) {
				respons.setToolConsumeType("可刃磨刀片");
			} else if ("2".equals(reVal.getToolConsumetype())) {
				respons.setToolConsumeType("一次性刀片");
			} else if ("9".equals(reVal.getToolConsumetype())) {
				respons.setToolConsumeType("其他");
			}
			respons.setLibraryCodeID(reVal.getLibraryCodeID());
			cJsonStr = jsonResult(respons);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 查询当前标签是否已初始化(库位标签)
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/findLibraryInitializeMsg", method = RequestMethod.POST)
	public String findLibraryInitializeMsg(String rfidCode, String toolCode)
			throws Exception {
		String cJsonStr;
		try {
			// 参数验证
			if ((null == rfidCode || "".equals(rfidCode))
					&& (null == toolCode || "".equals(toolCode))) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}
			// 未初始化
			// 验证RFID标签是否存在
			Rfidcontainer reRfid = c01S001Service
					.getRfidContainerByRfidCode(rfidCode);
			if (reRfid != null) {
				cJsonStr = jsonResult(false, "请扫描空标签");
				return cJsonStr;
				// rfidContainer = reRfid.getRfidContainerID();
			}

			Vknifeinventoryinfo reVal = null;
			if (toolCode != null) {
				Vknifeinventoryinfo v = new Vknifeinventoryinfo();
				v.setToolCode(toolCode);
				// 查询当前刀具标准是否初始化
				reVal = c03S001Service.getIsHasToolInit(v);
			}
			if (reVal == null) {
				cJsonStr = jsonResult(false, "未找到当前材料号库存信息");
				return cJsonStr;
			} else if (reVal.getRfidContainerID() == null) {
				// 未初始化库位标签
				cJsonStr = jsonResult(true, "");
				return cJsonStr;
			} else {
				// 已初始化库位标签并且是当前标签
				cJsonStr = jsonResult(true, "是否要重新初始化");
				return cJsonStr;
			}

		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 提交库位标签初始化数据
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/submitLibraryCodeMsg", method = RequestMethod.POST)
	public String submitLibraryCodeMsg(String userID, String rfidCode,
			String toolCode, String knifelnventoryNumber) throws Exception {
		String cJsonStr;
		try {

			// Rfidcontainer entity = new Rfidcontainer();
			// // RFID标签
			// entity.setRfidCode(rfidCode);
			// // 删除区分
			// entity.setDelFlag("0");
			// 查询刀具信息
			Tool t = new Tool();
			t.setToolCode(toolCode);
			// t.setDelFlag("0");
			Tool re = c01S001Service.searchBitInputInf(t);
			if (null == re) {
				// 已初始化库位标签并且是当前标签
				cJsonStr = jsonResult(false, "未查到当前材料号信息");
				return cJsonStr;
			}
			Knifeinventory k1 = new Knifeinventory();
			k1.setToolID(re.getToolID());
			List<Knifeinventory> list = c01S001Service
					.getKnifeinventoryInfo(k1);

			if (list != null && list.size() > 0) {
				k1 = new Knifeinventory();
				k1.setToolID(re.getToolID());
				c01S001Service.deleteKnifeinventory(k1);
				Rfidcontainer rf = new Rfidcontainer();
				rf.setRfidContainerID(list.get(0).getRfidContainerID());
				c01S001Service.deleteRfidcontainer(rf);
			}
			// 验证RFID标签是否存在
			Rfidcontainer rfidcontainer = c01S001Service
					.getRfidContainerByRfidCode(rfidCode);
			String rifdConnerID = null;
			if (rfidcontainer != null
					&& ("0".equals(rfidcontainer.getQueryType()))) {
				// 已初始化过标签
				rifdConnerID = rfidcontainer.getRfidContainerID();
			} else {
				rfidcontainer = new Rfidcontainer();
				rifdConnerID = getId();
				// RFID载体ID
				rfidcontainer.setRfidContainerID(rifdConnerID);
				// RFID标签ID
				rfidcontainer.setRfidCode(rfidCode);
				// RFID重用次数
				rfidcontainer.setRfidReCount(1.0);
				// 绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
				rfidcontainer.setBandType("0");
				// 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
				rfidcontainer.setQueryType("0");
				// 删除区分(0有效1删除)
				rfidcontainer.setDelFlag("0");
				// rfidcontainer.setCreateTime(new Date());
				// rfidcontainer.setUpdateTime(new Date());
				// rfidcontainer.setCreateUser(userID);
				rfidcontainer.setUpdateUser(userID);
				// rfidcontainer.setVersion(1);
				rfidcontainer.setSystemLogUser(userID);
				// 加入载体表
				c03S001Service.insertRfidcontainer(rfidcontainer);
			}

			// 查询是否已有初始化库位标签
			Knifeinventory knifeinventory = new Knifeinventory();
			knifeinventory.setToolID(re.getToolID());
			knifeinventory.setRfidContainerID(rifdConnerID);
			knifeinventory.setDelFlag("0");
			List<Knifeinventory> knifeinventories = (List<Knifeinventory>) c01S001Service
					.getKnifeinventoryInfo(knifeinventory);
			if (knifeinventories != null && knifeinventories.size() > 0) {

				knifeinventory = new Knifeinventory();
				// TODO
				knifeinventory.setProcuredBatch("20170701");
				knifeinventory.setKnifelnventoryNumber(knifelnventoryNumber);
				knifeinventory.setUpdateUser(userID);
				c01S001Service.updateKnifeinventory(knifeinventory);
			} else {
				knifeinventory = new Knifeinventory();
				knifeinventory.setRfidContainerID(rifdConnerID);
				knifeinventory.setToolID(re.getToolID());
				knifeinventory
						.setKnifeInventoryCode(String.valueOf(getTimes()));
				knifeinventory.setProcuredBatch("20170701");
				knifeinventory.setKnifelnventoryNumber(knifelnventoryNumber);
				knifeinventory.setKnifeInventoryType("0");
				knifeinventory.setToolDurable(re.getToolNumber());
				knifeinventory.setToolSharpennum(new BigDecimal(0));
				knifeinventory.setToolSharpenCriterion(re
						.getToolSharpenCriterion());
				if (re.getToolLength() == null) {
					re.setToolLength(new BigDecimal(20));
				}
				knifeinventory.setToolLength(re.getToolLength());
				if (re.getToolSharpenLength() == null) {
					re.setToolSharpenLength(new BigDecimal(5));
				}
				knifeinventory.setToolSharpenLength(re.getToolSharpenLength());
				if (re.getToolSharpenCriterion() == null) {
					re.setToolSharpenCriterion(new BigDecimal(5));
				}
				knifeinventory.setToolSharpenCriterion(re
						.getToolSharpenCriterion());
				knifeinventory.setDelFlag("0");
				knifeinventory.setUpdateUser(userID);
				// knifeinventory.setUpdateTime(new Date());
				// knifeinventory.setCreateUser(userID);
				// knifeinventory.setCreateTime(new Date());
				// knifeinventory.setVersion("0");

				// 新增库存信息
				c03S001Service.insertKnifeinventory(knifeinventory);
			}

			cJsonStr = jsonResult(true);
		} catch (Exception e) {
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

}