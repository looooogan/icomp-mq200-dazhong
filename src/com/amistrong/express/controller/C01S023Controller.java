package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.response.C01S023Respons;
import com.amistrong.express.beans.response.Merchants;
import com.amistrong.express.beans.response.Oplink;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Synthesiscutterlocation;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Synthesisparameters;
import com.amistrong.express.beans.response.Synthesistoolsmachining;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.ToolDurable;
import com.amistrong.express.beans.response.Toolnoticehistory;
import com.amistrong.express.beans.response.Toolsmachining;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.server.C01S001Service;
import com.amistrong.express.server.C01S005Service;
import com.amistrong.express.server.C01S023Service;
import com.amistrong.express.server.C03S001Service;

/**
 * 单品绑定
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Controller
public class C01S023Controller extends BaseController {

	@Autowired
	private C01S001Service c01S001Service;

	@Autowired
	private C01S023Service c01S023Service;

	@Autowired
	private C03S001Service c03S001Service;

	@Autowired
	private C01S005Service c01S005Service;

	/**
	 * 查询激光码信息
	 * 
	 * @param laserCode
	 *            :激光码 rfidCode：RFID码
	 * @return
	 * @throws
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getOneKnifeBinding", method = RequestMethod.POST)
	public String getOneKnifeBinding(String materialNum, String manufactor)
			throws Exception {
		String cJsonStr;
		C01S023Respons respons = new C01S023Respons();
		try {
			// 参数验证
			if (null == materialNum || "".equals(materialNum)
					|| null == manufactor || "".equals(manufactor)) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}

			// 验证材料号为一体刀材料号
			Synthesisparameters synthesisparameters = c01S023Service
					.getSynthesisparametersByToolCode(materialNum);

			// 未找到刀具信息
			if (synthesisparameters == null) {
				cJsonStr = jsonResult(false, "未找到" + materialNum + "的刀具信息");
				return cJsonStr;
			} else if (!"4".equals(synthesisparameters.getCreateType())) {
				cJsonStr = jsonResult(false, materialNum + "非一体刀材料号，请确认");
				return cJsonStr;
			}

			// 以材料号、厂家 查询激光码总数
			Integer count = c01S023Service
					.getLaserCodeCountByMaterialNumAndManufactor(materialNum
							+ manufactor);

			String synthesisParametersNumber = "001";

			int temp = count;
			if (temp < 9) {
				synthesisParametersNumber = "00" + (temp + 1);
			} else if (temp < 99) {
				synthesisParametersNumber = "0" + (temp + 1);
			} else {
				synthesisParametersNumber = (temp + 1) + "";
			}
			respons.setCount(synthesisParametersNumber);

			cJsonStr = jsonResult(respons);
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 提交单品绑定信息
	 * 
	 * @param laserCode
	 *            :激光码 rfidCode：RFID码 toolDurable:平均加工量 grindingCount:修磨次数
	 * @return
	 * @throws
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/saveOneKnifeBinding", method = RequestMethod.POST)
	public String saveOneKnifeBinding(String materialNum, String laserCode,
			String rfidCode, String customerID, Integer toolDurable,
			Integer grindingCount) throws Exception {
		String cJsonStr;
		try {
			// 参数验证
			if ((null == rfidCode || "".equals(rfidCode))
					&& (null == laserCode || "".equals(laserCode))) {
				cJsonStr = jsonResult(false, MessageList.ERR_EMPTY_REQUEST);
				return cJsonStr;
			}
			Rfidcontainer rfidcontainer = new Rfidcontainer();

			// 扫描库位码的场合
			// RFID标签有效验证
			rfidcontainer = c01S001Service.getRfidContainerByRfidCode(rfidCode);
			if (rfidcontainer != null) {
				cJsonStr = jsonResult(false, "请扫描空标签");
				return cJsonStr;
			}

			// 验证激光码是否重复
			Integer count = c01S023Service
					.getLaserCodeCountByLaserCode(laserCode);

			if (count > 0) {
				cJsonStr = jsonResult(false, "重复的激光码");
				return cJsonStr;
			}
			// 创建载体
			Rfidcontainer r = new Rfidcontainer();
			r.setRfidCode(rfidCode);
			r.setBandType("1");
			r.setQueryType("2");
			r.setUpdateUser(customerID);
			r.setSystemLogUser(customerID);
			r.setRfidReCount(1.0);
			r.setLaserIdentificationCode(laserCode);
			String rfidID = getId();
			r.setRfidContainerID(rfidID);
			// 新建载体数据
			c03S001Service.insertRfidcontainer(r);

			// 取得当前合成刀具组成
			Synthesisparameters synthesisparameters = new Synthesisparameters();
			synthesisparameters.setSynthesisParametersCode(materialNum);
			List<Synthesisparameters> synthesisparametersList = (List<Synthesisparameters>) c03S001Service
					.searchSynthesisparameters(synthesisparameters);
			if (synthesisparametersList.size() == 0) {
				// 当前刀具编码错误
				cJsonStr = jsonResult(false, "未找到该刀具合成参数信息");
				return cJsonStr;
			}
			Synthesiscutterlocation synthesiscutterlocation = new Synthesiscutterlocation();
			synthesiscutterlocation
					.setSynthesisParametersID(synthesisparametersList.get(0)
							.getSynthesisParametersID());
			List<Synthesiscutterlocation> synthesiscutterlocationList = (List<Synthesiscutterlocation>) c03S001Service
					.searchSynthesiscutterlocation(synthesiscutterlocation);
			List<Tooltransfer> inputList = new ArrayList<Tooltransfer>();
			// 建立组成该合成刀具的流转刀具数据
			String knifeInventoryCode = getTimes();
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
				tooltransfer.setBusinessFlowLnkID("C01S023");// 最后业务流程
				tooltransfer.setToolDurable(synthesiscutterlocation2
						.getToolCount());// 数量
				tooltransfer.setProcuredBatch("20170701");
				tooltransfer.setToolLength(toolInfo.getToolLength());// 刀具长度
				tooltransfer.setToolSharpenLength(toolInfo
						.getToolSharpenLength());// 可刃磨长度
				tooltransfer.setStockState("4");// 库存状态
				tooltransfer.setToolGrindingLength(BigDecimal.ZERO);
				tooltransfer.setUsageCounter(grindingCount);
				tooltransfer.setInstallationState("0");// 已安装
				tooltransfer.setToolState("3");// 待分拣(在生产线上)
				// tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
				// tooltransfer.setCreateTime(new Date());
				// tooltransfer.setUpdateTime(new Date());
				tooltransfer.setCreateUser(customerID);
				tooltransfer.setUpdateUser(customerID);
				// tooltransfer.setVersion("0");
				tooltransfer.setRfidContainerID(rfidID);
				Thread.sleep(1);
				tooltransfer.setKnifeInventoryCode(knifeInventoryCode);
				tooltransfer.setSynthesisCutterNumber(synthesiscutterlocation2
						.getSynthesisCutterNumber());
				// 车间
				tooltransfer.setToolThisState("4");
				// 累积加工数量
				if (grindingCount > 0) {
					tooltransfer.setProcessAmount(BigDecimal
							.valueOf(grindingCount * toolDurable));
				}
				inputList.add(tooltransfer);

				// 根据材料号查询流转统计表数据
				TooltransferTotal tst2 = c01S005Service
						.getTooltransferTotalInfoByToolCode(synthesiscutterlocation2
								.getToolCode());
				if (null != tst2) {
					// 更新条件-刀具材料号
					tst2.setToolCode(synthesiscutterlocation2.getToolCode());
					tst2.setUpdateUser(customerID);
					// 备刀数量
					tst2.setSpareKnifeSum(tst2.getSpareKnifeSum()
							- synthesiscutterlocation2.getToolCount());
					// 组装数量
					tst2.setProductionLineSum(tst2.getProductionLineSum()
							+ synthesiscutterlocation2.getToolCount());

					// 更新流转统计表数据
					c01S005Service.updateTooltransferTotalInfo(tst2);
				} else {
					tst2 = new TooltransferTotal();
					// 更新条件-刀具材料号
					tst2.setToolCode(synthesiscutterlocation2.getToolCode());
					tst2.setUpdateUser(customerID);
					tst2.setCreateUser(customerID);
					// 备刀数量
					tst2.setProductionLineSum(-synthesiscutterlocation2
							.getToolCount());
					// 组装数量
					tst2.setProductionLineSum(synthesiscutterlocation2
							.getToolCount());
					// 新增流转统计表数据
					c03S001Service.insertTooltransferTotalInfo(tst2);
				}

			}
			// 取得合成刀具序号
			Synthesisknife entity = new Synthesisknife();
			entity.setSynthesisParametersCode(materialNum);// 合成刀具编码
			// entity.setOrderString("ABS(SynthesisParametersNumber) desc");
			// entity.setRowCount(1);
			Synthesisknife sk1 = c03S001Service.searchBySynthesisknife(entity);
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
			for (Tooltransfer tooltransfer2 : inputList) {
				// 合成刀库数据建立
				Synthesisknife synthesisknife = new Synthesisknife();
				synthesisknife.setSynthesisParametersCode(materialNum);// 合成刀具编码
				synthesisknife
						.setSynthesisParametersNumber(synthesisParametersNumber);
				synthesisknife.setSynthesisCutterNumber(tooltransfer2
						.getSynthesisCutterNumber());// 位置号
				synthesisknife.setBusinessFlowLnkID("C01S023");// 最后流程ID
				synthesisknife.setKnifeInventoryCode(knifeInventoryCode);// 刀具入库编码
				// RFID
				synthesisknife.setrFID(rfidID);
				// 是否安装
				synthesisknife.setInstallFlag("9");
				synthesisknife.setLoadState("12");
				synthesisknife.setOffloadType(BigDecimal.ZERO.toString());
				synthesisknife.setxPoint(BigDecimal.ZERO);
				synthesisknife.setyPoint(BigDecimal.ZERO);
				synthesisknife.setUpdateUser(customerID);
				synthesisknifes.add(synthesisknife);
			}

			// 修磨次数大于0时
			if (grindingCount > 0) {
				Date date3 = new Date();
				Calendar c3 = Calendar.getInstance();
				c3.setTime(date3);
				c3.add(Calendar.YEAR, -100);
				date3 = c3.getTime();
				SimpleDateFormat dateformat3 = new SimpleDateFormat(
						"yyyyMMddHHmmss");
				String dateformat3Str =dateformat3.format(date3);
				for (int i = 0; i < grindingCount; i++) {
					// 插入修磨数据
					Toolnoticehistory tnh = new Toolnoticehistory();
					tnh.setKnifeInventoryCode(knifeInventoryCode);// 刀具入库编码
					tnh.setToolCode(materialNum);// 材料号
					tnh.setNoticeCount(1);// 修磨数量
					Date date = new Date();
					Calendar c = Calendar.getInstance();
					// TODO
					c.setTime(date);
					c.add(Calendar.YEAR, -100);
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
					tnh.setRfidContainerID(rfidID);
					// tnh.setVersion(BigDecimal.ZERO);//版本号
					// 新增刀具修复履历
					c01S005Service.insertToolnoticehistory(tnh);

					// // 插入合成刀加工数据
					// Synthesistoolsmachining stm = new
					// Synthesistoolsmachining();
					// // 加工编号(年月日时分秒 14位字符串)
					// stm.setSynthesisNumber(dateformat.format(date).trim());
					// // 合成刀具号码
					// stm.setSynthesisParametersNumber(synthesisParametersNumber);
					// // 合成刀具编号
					// stm.setSynthesisParametersCode(materialNum);
					// // 加工数量
					// stm.setProcessAmount(BigDecimal.valueOf(toolDurable));
					// stm.setCreateUser(customerID);
					// c01S005Service.insertSynthesistoolsmachining(stm);
					Synthesistoolsmachining syn = new Synthesistoolsmachining();
					// 时间格式化
					// SimpleDateFormat sdf = new SimpleDateFormat (
					// "yyyyMMddHHmmss" );

					Date date2 = new Date();
					Calendar c2 = Calendar.getInstance();
					c2.setTime(date2);
					c2.add(Calendar.YEAR, -100);
					date2 = c2.getTime();
					SimpleDateFormat dateformat2 = new SimpleDateFormat(
							"yyyyMMddHHmmssSSS");
					String date2Str = dateformat2.format(date2).substring(2, 16);
					// 加工编号(年月日时分秒 14位字符串)
					syn.setSynthesisNumber(date2Str); // 刃磨时间
					// todo 合成刀具号码
					syn.setSynthesisParametersNumber("001");
					// 合成刀具编号
					syn.setSynthesisParametersCode(materialNum);
					// // 流水线ID
					// syn.setAssemblyLineID(sm.getAssemblyLineID());
					// // 设备ID
					// syn.setEquipmentID(sm.getEquipmentID());
					// // 轴ID
					// syn.setAxleID(sm.getAxleID());
					// // 工序ID
					// syn.setProcessID(sm.getProcessID());
					// syn.setPartsID(sm.getPartsID());
					// 加工数量
					syn.setProcessAmount(BigDecimal.valueOf(toolDurable));
					syn.setOuterTime(dateformat3Str);
					syn.setOuterUser(customerID);
					// 删除区分
					// syn.setDelFlag(IConstant.STRING_0);
					// 创建时间
					// syn.setCreateTime(new Date());
					// 创建者
					// syn.setCreateUser(sm.getCreateUser());
					// 更新时间
					// syn.setUpdateTime(new Date());
					// 更新者
					syn.setUpdateUser(customerID);
					// 版本号
					// syn.setVersion(BigDecimal.ONE);
					syn.setRfidContainerID(rfidID);
					// 查询合成刀具生产关联关系
					Oplink oplink = new Oplink();
					oplink.setSynthesisParametersID(synthesisparametersList
							.get(0).getSynthesisParametersID());
					List<Oplink> oplinkList = c03S001Service
							.searchOplink(oplink);
					syn.setPartsID(oplinkList.get(0).getPartsID());
					syn.setProcessID(oplinkList.get(0).getProcessID());
					syn.setEquipmentID(oplinkList.get(0).getEquipmentID());
					syn.setAssemblyLineID(oplinkList.get(0).getAssemblyLineID());
					syn.setAxleID(oplinkList.get(0).getAxleID());
					// 插入合成刀加工信息(车间工作量汇总用)
					c01S023Service.insertSynthesistoolsmachining(syn);
					
					// 取得刀具参数ID
					Tool tool = new Tool();
					tool.setToolCode(materialNum);
					Tool toolInfo = c01S001Service.searchBitInputInf(tool);
					Toolsmachining ts = new Toolsmachining();
	                //加工编号(年月日时分秒 14位字符串)
	                ts.setSynthesisNumber(dateformat2.format(date2).substring(0, 14));
	                //刀具入库编码
	                ts.setKnifeInventoryCode(getId());
	                //刀具ID
	                ts.setToolID(toolInfo.getToolID());
	                //流水线ID
	                ts.setAssemblyLineID(oplinkList.get(0).getAssemblyLineID());
	                //设备ID
	                ts.setEquipmentID(oplinkList.get(0).getEquipmentID());
	                //工序ID
	                ts.setProcessID(oplinkList.get(0).getProcessID());
	                //零部件ID
	                ts.setPartsID(oplinkList.get(0).getPartsID());
	                //轴ID
	                ts.setAxleID(oplinkList.get(0).getAxleID());
	                //卸下时间
	                ts.setOuterTime(dateformat3Str);
	                //操作人
	                ts.setOuterUser(customerID);
	                //卸下原因(0正常卸下1打刀2不合格9其他)(可维护)
	                ts.setRemoveReason("0");
	                //sm.setRemoveReason(IConstant.DEL_FLAG_0);
	                //加工数量
	                ts.setProcessAmount(BigDecimal.valueOf(toolDurable));
	                //卸下确认人(不合格卸下时需要进行确认)
	                ts.setRemoveUser(customerID);
	                ts.setRfidContainerID(rfidID);
	                //ts.setDelFlag(IConstant.DEL_FLAG_0);
	                //ts.setUpdateTime(new Date());
	                //ts.setUpdateUser(customerID);
	                //ts.setCreateTime(new Date());
	                //ts.setCreateUser(customerID);
					// 插入刀具加工信息(刀具消耗查询用)
					c01S023Service.insertToolsmachining(ts);
				}

			}

			if (inputList.size() > 0) {
				c03S001Service.insertTooltransfer(inputList);
			}
			if (synthesisknifes.size() > 0) {
				c03S001Service.insertSynthesisknife(synthesisknifes);
			}

			cJsonStr = jsonResult(true, "激光码绑定成功");
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	/**
	 * 查询生产关联关系平均加工量list
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/getToolDurableList", method = RequestMethod.POST)
	public String getToolDurableList(String materialNum) throws Exception {
		String cJsonStr;
		try {

			// 查询生产关联关系平均加工量list
			List<ToolDurable> toolDurableList = c01S023Service
					.getToolDurableList(materialNum);
			if (toolDurableList.size() == 0) {
				cJsonStr = jsonResult(false, "没有找到加工量信息，请先配置生产关系关联配置和合成刀具参数配置");
				return cJsonStr;
			}
			cJsonStr = jsonResult(toolDurableList);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

}
