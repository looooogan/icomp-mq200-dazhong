package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.response.C01S009Respons;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.SynthesisEntity;
import com.amistrong.express.beans.response.Synthesiscutterlocation;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Synthesisparameters;
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
import com.amistrong.express.server.C01S009Service;
import com.amistrong.express.server.C01S010Service;
import com.amistrong.express.server.C03S001Service;

/**
 * 刀具组装
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Transactional
@Controller
public class C01S009Controller extends BaseController {

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
	private C01S009Service c01S009Service;

	/**
	 * 刀具组装扫码查询合成刀信息
	 * 
	 * @param (String)rfidCode：扫描标签的RFID
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getSynthesisToolInstall", method = RequestMethod.POST)
	public String getSynthesisToolInstall(String rfidCode, String flg)
			throws Exception {
		String cJsonStr;
		C01S009Respons respons = new C01S009Respons();
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
				// 一体刀不能组装
				if ("4".equals(reVal.getCreateType())) {
					cJsonStr = jsonResult(false, "不可组装一体刀");
					return cJsonStr;
				}
			}

			// 刀具状态为卸下的场合的(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上6:已拆分)
			if (!"6".equals(reVal.getLoadState())) {
				cJsonStr = jsonResult(false, "该刀具未拆分，不可组装");
				return cJsonStr;
			}

			// // 判断刀具是否修磨完成
			// Tooltransfer tt = new Tooltransfer();
			// tt.setRfidContainerID(rfid);
			// tt.setDelFlag("0");
			// List<Tooltransfer> ttList = c01S009Service
			// .searchTooltransferList(tt);
			//
			// if (ttList.size() < 1) {
			// cJsonStr = jsonResult(false, "未找到刀具信息");
			// return cJsonStr;
			// }
			//
			// // 刀具未修磨完毕
			// if (!"8".equals(ttList.get(0).getToolState())) {
			// cJsonStr = jsonResult(false, "刀具修模后才可组装");
			// return cJsonStr;
			// }

			// 合成刀具编码(系统唯一)
			respons.setSynthesisParametersCode(reVal
					.getSynthesisParametersCode());
			// RFID载体ID
			respons.setRfidContainerID(rfid);
			// 刀具类型
			respons.setCreateType(reVal.getCreateType());
			List<SynthesisEntity> toolList;

			// 合成刀
			if ("0".equals(flg)) {
				// 合成刀组装入口只能组装合成
				if (!"0".equals(reVal.getCreateType())
						&& !"1".equals(reVal.getCreateType())
						&& !"2".equals(reVal.getCreateType())
						&& !"3".equals(reVal.getCreateType())) {
					cJsonStr = jsonResult(false, "只可组装合成刀");
					return cJsonStr;
				}

				// 查询合成刀组成刀具list
				toolList = c03S001Service.getSynthesisToolListBySPCode(reVal
						.getSynthesisParametersCode());

				// 筒刀
			} else {
				// 筒刀组装入口只能组装筒刀
				if (!"5".equals(reVal.getCreateType())) {
					cJsonStr = jsonResult(false, "只可组装筒刀");
					return cJsonStr;
				}

				Tubedetailinfo entity = new Tubedetailinfo();
				// 合成刀具码
				entity.setSynthesisParametersCode(reVal
						.getSynthesisParametersCode());
				// RFID
				entity.setrFID(rfid);
				// 查询筒刀组成刀具list
				toolList = c03S001Service.getTubedetailinfoList(entity);
			}

			respons.setToolList(toolList);
			cJsonStr = jsonResult(respons);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 刀具组装
	 * 
	 * @param synthesisParametersCodes
	 *            :合成刀具码(以","分割) rfidContainerIDs:RFID载体ID(以","分割)
	 *            toolConsumetypes:刀具类型(以","分割) customerID：用户ID
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/saveSynthesisToolInstall", method = RequestMethod.POST)
	public String saveSynthesisToolInstall(String synthesisParametersCodes,
			String rfidContainerIDs, String toolConsumetypes,
			String customerID, String installparams) throws Exception {
		String cJsonStr;
		try {

			// 参数验证
			if (null == synthesisParametersCodes
					|| "".equals(synthesisParametersCodes)
					|| null == rfidContainerIDs || "".equals(rfidContainerIDs)
					|| null == toolConsumetypes || "".equals(toolConsumetypes)
					|| null == customerID || "".equals(customerID)) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}

			// 合成刀具编码
			String[] synthesisParametersCodesArr = synthesisParametersCodes
					.split(",");
			// RFID载体ID
			String[] rfidContainerIDsArr = rfidContainerIDs.split(",");
			// 刀具类型
			String[] toolConsumetypesArr = toolConsumetypes.split(",");

			for (int i = 0; i < synthesisParametersCodesArr.length; i++) {
				Synthesisknife sk = new Synthesisknife();
				// 更新条件 - RFID
				sk.setrFID(rfidContainerIDsArr[i]);
				// 使用状态 - 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)
				sk.setLoadState("5");
				// 更新者
				sk.setUpdateUser(customerID);
				sk.setBusinessFlowLnkID("C01S009");
				// 更新合成刀库表是否安装为0设备装入
				c01S008Service.updateSynthesisknife(sk);

				// 拆分合成刀的场合
				// 查询合成刀刀具信息
				// 合成刀组成刀具list
				List<SynthesisEntity> toolList = c03S001Service
						.getSynthesisToolListBySPCode(synthesisParametersCodesArr[i]);
				for (int j = 0; j < toolList.size(); j++) {
					Tooltransfer tf = new Tooltransfer();
					// 更新条件-RFID载体ID
					tf.setRfidContainerID(rfidContainerIDsArr[i]);
					// 更新条件-刀具ID
					tf.setToolID(toolList.get(j).getToolID());
					// 13 组装完毕
					tf.setToolState("13");
					tf.setBusinessFlowLnkID("C01S009");
					// 更新者
					tf.setUpdateUser(customerID);
					// 更新刀具流转表 刀具状态
					c01S008Service.updateTooltransfer(tf);

					if ("1".equals(toolList.get(j).getToolType())) {
						continue;
					}
					// 根据材料号查询刀具流转统计表数据
					TooltransferTotal ttInfo = c01S005Service
							.getTooltransferTotalInfoByToolCode(toolList.get(j)
									.getToolCode());
					TooltransferTotal tt = new TooltransferTotal();
					// 更新条件-材料号
					tt.setToolCode(toolList.get(j).getToolCode());
					// 已组装数量
					tt.setProductionLineSum(ttInfo.getProductionLineSum()
							+ toolList.get(j).getToolCount());
					// 备刀数量
					tt.setSpareKnifeSum(ttInfo.getSpareKnifeSum()
							- toolList.get(j).getToolCount());
					// 更新者
					tt.setUpdateUser(customerID);
					// 根据材料号 更新流转统计表数据
					c01S008Service.updateTooltransferTotal(tt);

					// 组装筒刀的场合
					if ("5".equals(toolConsumetypesArr[i])) {
						// 合成刀具码&载体ID&材料号&修磨次数
						String[] installparamsArr = installparams.split(",");
						Tubedetailinfo tbf = new Tubedetailinfo();
						// 更新条件-合成刀具编码
						tbf.setSynthesisParametersCode(synthesisParametersCodesArr[i]);
						// 更新条件-rFID
						tbf.setrFID(rfidContainerIDsArr[i]);
						// 更新条件-刀具编号
						tbf.setToolCode(toolList.get(j).getToolCode());
						for (int k = 0; k < installparamsArr.length; k++) {
							if (installparamsArr[k].split("&")[0]
									.equals(synthesisParametersCodesArr[i])
									&& installparamsArr[k].split("&")[1]
											.equals(rfidContainerIDsArr[i])
									&& installparamsArr[k].split("&")[2]
											.equals(toolList.get(j)
													.getToolCode())) {
								tbf.setGrindingsum(Integer
										.valueOf(installparamsArr[k].split("&")[3]));
								break;
							}
						}
						// 装配人
						tbf.setInstallUser(customerID);
						// 更新者
						tbf.setUpdateUser(customerID);
						String id = c01S008Service.getTubeId(tbf);
						tbf.setID(id);
						// 更新筒刀拆分记录组装信息
						c01S008Service.updateTubedetailinfo(tbf);

					}

				}

			}

			cJsonStr = jsonResult(true);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 刀具组装扫码查询合成刀信息
	 * 
	 * @param (String)rfidCode：扫描标签的RFID
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/saveSynthesisToolInstallNewTool", method = RequestMethod.POST)
	public String saveSynthesisToolInstallNewTool(String rfidCode,
			String toolCode, String customerId) throws Exception {
		String cJsonStr;
		C01S009Respons respons = new C01S009Respons();
		try {

			// 参数验证
			if (null == rfidCode || "".equals(rfidCode)) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}

			// 取得当前合成刀具组成
			Synthesisparameters synthesisparameters = new Synthesisparameters();
			synthesisparameters.setSynthesisParametersCode(toolCode);
			List<Synthesisparameters> synthesisparametersList = (List<Synthesisparameters>) c03S001Service
					.searchSynthesisparameters(synthesisparameters);
			if (synthesisparametersList.size() == 0) {
				cJsonStr = jsonResult(false, "未找到合成刀数据");
				return cJsonStr;
			} else if ("4".equals(synthesisparametersList.get(0)
					.getCreateType())) {
				cJsonStr = jsonResult(false, "不可初始化一体刀");
				return cJsonStr;
			} else if ("5".equals(synthesisparametersList.get(0)
					.getCreateType())) {
				cJsonStr = jsonResult(false, "不可组装筒刀");
				return cJsonStr;
			} else if ("6".equals(synthesisparametersList.get(0)
					.getCreateType())) {
				cJsonStr = jsonResult(false, "不可组装专机");
				return cJsonStr;
			}

			// 扫码的场合
			Rfidcontainer rfidcontainer = c01S001Service
					.getRfidContainerByRfidCode(rfidCode);
			// RFID取得
			String rfid = rfidcontainer.getRfidContainerID();
			// 删除原有标签
			Rfidcontainer entity = new Rfidcontainer();
			entity.setRfidContainerID(rfid);
			entity.setDelFlag("1");
			c03S001Service.updateRfidcontainer(entity);
			// 删除原有合成刀具信息
			Synthesisknife deleteSynEntity = new Synthesisknife();
			deleteSynEntity.setrFID(rfid);
			c01S009Service.deleteSynthesisknife(deleteSynEntity);

			// 新建新的标签
			Rfidcontainer insertRfEntity = new Rfidcontainer();
			insertRfEntity.setRfidCode(rfidCode);
			// 新建载体数据
			insertRfEntity.setBandType("0");
			insertRfEntity.setQueryType("2");
			insertRfEntity.setUpdateUser(customerId);
			insertRfEntity.setSystemLogUser(customerId);
			insertRfEntity.setRfidReCount(1.0);
			String newRfid = getId();
			insertRfEntity.setRfidContainerID(newRfid);
			c03S001Service.insertRfidcontainer(insertRfEntity);

			String synthesisparametersID = synthesisparametersList.get(0)
					.getSynthesisParametersID();
			Synthesiscutterlocation synthesiscutterlocation = new Synthesiscutterlocation();
			synthesiscutterlocation
					.setSynthesisParametersID(synthesisparametersID);
			List<Synthesiscutterlocation> synthesiscutterlocationList = (List<Synthesiscutterlocation>) c03S001Service
					.searchSynthesiscutterlocation(synthesiscutterlocation);
			List<Tooltransfer> inputList = new ArrayList<Tooltransfer>();

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
				tooltransfer.setToolSharpennum(toolInfo.getToolSharpennum());// 可使用(刃磨)次数
				tooltransfer.setToolSharpenCriterion(toolInfo
						.getToolSharpenCriterion());// 复磨标准
				tooltransfer.setBusinessFlowLnkID("C01S009");// 最后业务流程
				tooltransfer.setToolDurable(synthesiscutterlocation2
						.getToolCount());// 数量
				tooltransfer.setProcuredBatch("20170701");
				tooltransfer.setToolLength(toolInfo.getToolLength());// 刀具长度
				tooltransfer.setToolSharpenLength(toolInfo
						.getToolSharpenLength());// 可刃磨长度
				tooltransfer.setStockState("4");// 库存状态
				tooltransfer.setToolGrindingLength(BigDecimal.ZERO);
				tooltransfer.setUsageCounter(0);
				tooltransfer.setInstallationState("0");// 未安装
				tooltransfer.setToolState("13");// 组装完毕
				tooltransfer.setCreateUser(customerId);
				tooltransfer.setUpdateUser(customerId);
				// tooltransfer.setVersion("0");
				tooltransfer.setRfidContainerID(newRfid);
				Thread.sleep(1);
				tooltransfer.setKnifeInventoryCode(String.valueOf(getTimes()));
				tooltransfer.setSynthesisCutterNumber(synthesiscutterlocation2
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
					// 备刀数量
					tst.setSpareKnifeSum(tst.getSpareKnifeSum()
							- synthesiscutterlocation2.getToolCount());
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
					// 备刀数量
					tst.setSpareKnifeSum(-synthesiscutterlocation2
							.getToolCount());
					// 组装数量
					tst.setProductionLineSum(synthesiscutterlocation2
							.getToolCount());
					// 新增流转统计表数据
					c03S001Service.insertTooltransferTotalInfo(tst);
				}
			}

			// 取得合成刀具序号
			Synthesisknife synEntity = new Synthesisknife();
			synEntity.setSynthesisParametersCode(toolCode);// 合成刀具编码
			Synthesisknife sk1 = c03S001Service
					.searchBySynthesisknife(synEntity);
			String synthesisParametersNumber = "001";
			if (sk1 != null) {
				int temp = Integer.parseInt(sk1.getSynthesisParametersNumber());
				if (temp < 9) {
					synthesisParametersNumber = "00" + (temp + 1);
				} else if (temp < 99) {
					synthesisParametersNumber = "0" + (temp + 1);
				} else {
					synthesisParametersNumber = (temp + 1) + "";
				}
			}

			List<Synthesisknife> synthesisknifes = new ArrayList<Synthesisknife>();
			// Toolwholelifecycle toolwholelifecycle = null;
			for (Tooltransfer tooltransfer : inputList) {
				// 合成刀库数据建立
				Synthesisknife synthesisknife = new Synthesisknife();
				synthesisknife.setSynthesisParametersCode(toolCode);// 合成刀具编码
				synthesisknife
						.setSynthesisParametersNumber(synthesisParametersNumber);
				synthesisknife.setSynthesisCutterNumber(tooltransfer
						.getSynthesisCutterNumber());// 位置号
				synthesisknife.setBusinessFlowLnkID("C01S009");// 最后流程ID
				synthesisknife.setKnifeInventoryCode(tooltransfer
						.getKnifeInventoryCode());// 刀具入库编码
				// RFID
				synthesisknife.setrFID(newRfid);
				// 是否安装
				synthesisknife.setInstallFlag("9");
				synthesisknife.setLoadState("5");
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
				// 记录刀具生命周期
				// Tool tool = new Tool();
				// tool.setToolID(tooltransfer.getToolID());
				// tool = c03S001Service.searchTool(tool);
				// if (tool == null) {
				// // 当前刀具编码未记录!
				// cJsonStr = jsonResult(false, "当前刀具编码未记录");
				// return cJsonStr;
				// }
			}

			if (synthesisknifes.size() > 0) {
				c03S001Service.insertSynthesisknife(synthesisknifes);
			}

			if (inputList.size() > 0) {
				c03S001Service.insertTooltransfer(inputList);
			}

			cJsonStr = jsonResult(respons);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}
}
