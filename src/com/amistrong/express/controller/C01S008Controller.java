package com.amistrong.express.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amistrong.express.beans.response.Authorization;
import com.amistrong.express.beans.response.C01S008Respons;
import com.amistrong.express.beans.response.Onoff;
import com.amistrong.express.beans.response.Redemptionapplied;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Scrap;
import com.amistrong.express.beans.response.SynthesisEntity;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Tubedetailinfo;
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
 * 刀具拆分
 * 
 * @author
 * @version 2017-6-28 11:40
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Transactional
@Controller
public class C01S008Controller extends BaseController {

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
	@RequestMapping(value = "/getSynthesisToolSplit", method = RequestMethod.POST)
	public String getSynthesisToolSplit(String rfidCode) throws Exception {
		String cJsonStr;
		C01S008Respons respons = new C01S008Respons();
		try {
			String code;
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
				// 一体刀不能拆分
				if ("4".equals(reVal.getCreateType())) {
					cJsonStr = jsonResult(false, "不可拆分一体刀");
					return cJsonStr;
				}
			}

			// 刀具状态为卸下的场合的(0安装1卸下9其他)
			if ("0".equals(reVal.getInstallFlag())) {
				cJsonStr = jsonResult(false, "不可拆分");
				return cJsonStr;
			}

			// 刀具状态为卸下的场合的(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上6:已拆分)
			if ("6".equals(reVal.getLoadState())) {
				cJsonStr = jsonResult(false, "该刀具已拆分，不可重复拆分");
				return cJsonStr;
			}

			// 组装后拆分需授权
			if ("5".equals(reVal.getLoadState())) {
				 //判断拆分组装再拆分授权是否打开
				Onoff onoff = c03S001Service.searchOnoffByBusinessID ( "C01S008_001Activity" );
                // 0为打开，1为关闭
				if("0".equals(onoff.getOnOffState())){
					code = "1";
				}else{
					code = "0";
				}
			} else {
				code = "0";
			}

			// 合成刀具编码(系统唯一)
			respons.setSynthesisParametersCode(reVal
					.getSynthesisParametersCode());
			// RFID载体ID
			respons.setRfidContainerID(rfid);
			respons.setCode(code);
			// 刀具类型
			respons.setCreateType(reVal.getCreateType());
			cJsonStr = jsonResult(respons);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}

	/**
	 * 刀具拆分
	 * 
	 * @param synthesisParametersCodes
	 *            :合成刀具码(以","分割) rfidContainerIDs:RFID载体ID(以","分割)
	 *            toolConsumetypes:刀具类型(以","分割) customerID：用户ID
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/saveSynthesisToolSplit", method = RequestMethod.POST)
	public String saveSynthesisToolSplit(String synthesisParametersCodes,
			String rfidContainerIDs, String toolConsumetypes,
			String customerID, String codes,String authorizationUserID ) throws Exception {
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

			List<Tubedetailinfo> tubeList = new ArrayList<Tubedetailinfo>();
			// 合成刀具编码
			String[] synthesisParametersCodesArr = synthesisParametersCodes
					.split(",");
			// RFID载体ID
			String[] rfidContainerIDsArr = rfidContainerIDs.split(",");
			// 刀具类型
			String[] toolConsumetypesArr = toolConsumetypes.split(",");
			// 授权flg
			String[] codesArr = codes.split(",");

			for (int i = 0; i < synthesisParametersCodesArr.length; i++) {
				Synthesisknife sk = new Synthesisknife();
				// 更新条件 - RFID
				sk.setrFID(rfidContainerIDsArr[i]);
				// 使用状态 - 6:已拆分
				sk.setLoadState("6");
				// 更新者
				sk.setUpdateUser(customerID);
				sk.setBusinessFlowLnkID("C01S008");
				// 更新合成刀库表是否安装为1 卸下
				c01S008Service.updateSynthesisknife(sk);

				// 拆分合成刀的场合
				// 查询合成刀刀具信息
				// 合成刀组成刀具list
				List<SynthesisEntity> toolList = c03S001Service
						.getSynthesisToolListBySPCode(synthesisParametersCodesArr[i]);
				Date date = new Date();
				for (int j = 0; j < toolList.size(); j++) {
					
					if ("1".equals(toolList.get(j).getToolType())) {
						Tooltransfer tf = new Tooltransfer();
						// 更新条件-RFID载体ID
						tf.setRfidContainerID(rfidContainerIDsArr[i]);
						// 更新条件-刀具ID
						tf.setToolID(toolList.get(j).getToolID());
						tf.setBusinessFlowLnkID("C01S008");
						// 更新者
						tf.setUpdateUser(customerID);
						// 更新刀具流转表 刀具状态
						c01S008Service.updateTooltransfer(tf);
						continue;
					}
					
					
					// 根据材料号查询刀具流转统计表数据
					TooltransferTotal ttInfo = c01S005Service
							.getTooltransferTotalInfoByToolCode(toolList.get(j)
									.getToolCode());
					TooltransferTotal tt = new TooltransferTotal();
					String toolState = null;
					// 合成刀上刀具消耗类型为一次性时 拆下即报废
					if ("2".equals(toolList.get(j).getToolConsumetypeID())) {
						// 更新刀具流转表状态为待换装
						toolState = "4";

						// 新增报废表信息
						Scrap scrap = new Scrap();
						scrap.setScrapID(getId());
						scrap.setBusinessID("C01S005");
						// 材料号
						scrap.setMaterial(toolList.get(j).getToolCode());
						// 刀具ID
						scrap.setToolID(toolList.get(j).getToolID());
						// 报废数量
						scrap.setScrapNumber(BigDecimal.valueOf(toolList.get(j)
								.getToolCount()));
						// 报废原因
						scrap.setScrapCause("拆装报废");
						// 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
						scrap.setScrapState("2");
						// 创建者
						scrap.setCreateUser(customerID);
						// 插入报废表数据
						c01S005Service.insertScrap(scrap);

						// 新建换领申请表数据
						Redemptionapplied r = new Redemptionapplied();
						r.setRedemptionAppliedID(getId());
						r.setToolCode(toolList.get(j).getToolCode());
						r.setAppliedNumber(BigDecimal.valueOf(toolList.get(j)
								.getToolCount()));
						r.setApplyUser(customerID);
						r.setProcessingStatus("0");
						c01S005Service.insertRedemptionapplied(r);

						// 增加累积报废数量
						tt.setScrapSum(ttInfo.getScrapSum()
								+ toolList.get(j).getToolCount());

						// 类型为可刃磨时
					} else {

						// 判断刀具修磨类型

						// 修磨类别为厂外修磨时 增加统计表厂外待修磨数量
						if ("1".equals(toolList.get(j).getToolGrinding())) {
							// 更新刀具流转表状态为厂外待修磨
							toolState = "7";

							tt.setStayExternalGrindingSum(ttInfo
									.getStayExternalGrindingSum()
									+ toolList.get(j).getToolCount());

							// 修磨类别为厂内修磨或厂外涂层时 增加统计表厂内修磨数量 厂外涂层先厂内修磨在厂外涂层
						} else {
							// 更新刀具流转表状态为厂内待修磨
							toolState = "6";

							tt.setGrindingFactorySnum(ttInfo
									.getGrindingFactorySnum()
									+ toolList.get(j).getToolCount());
						}

					}

					// 更新条件-材料号
					tt.setToolCode(toolList.get(j).getToolCode());
					// 已组装数量
					tt.setProductionLineSum(ttInfo.getProductionLineSum()
							- toolList.get(j).getToolCount());

					// 更新者
					tt.setUpdateUser(customerID);
					// 根据材料号 更新流转统计表数据
					c01S005Service.updateTooltransferTotalInfo(tt);
					
					Tooltransfer tf = new Tooltransfer();
					// 更新条件-RFID载体ID
					tf.setRfidContainerID(rfidContainerIDsArr[i]);
					// 更新条件-刀具ID
					tf.setToolID(toolList.get(j).getToolID());
					tf.setToolState(toolState);
					tf.setBusinessFlowLnkID("C01S008");
					// 更新者
					tf.setUpdateUser(customerID);
					// 更新刀具流转表 刀具状态
					c01S008Service.updateTooltransfer(tf);



					// 拆分筒刀的场合
					if ("5".equals(toolConsumetypesArr[i])) {
						Tubedetailinfo bean = new Tubedetailinfo();
						bean.setID(getId());
						bean.setSynthesisParametersCode(synthesisParametersCodesArr[i]);
						bean.setrFID(rfidContainerIDsArr[i]);
						bean.setSynthesisCutterNumber(j);
						bean.setToolCode(toolList.get(j).getToolCode());
						bean.setLoadState("0");
						bean.setToolCount(toolList.get(j).getToolCount());
						Integer grindingsum = c01S008Service
								.getGrindingsum(bean);
						bean.setGrindingsum(grindingsum);
						bean.setCreateUser(customerID);
						bean.setUpdateUser(customerID);
						bean.setSplitUser(customerID);
						bean.setSplitTime(date);
						tubeList.add(bean);

					}

				}

				// 需要授权的场合
				if ("1".equals(codesArr[i])) {
					Authorization authorization = new Authorization();
					// 授权ID
					authorization.setAuthorizationID(getId());
					// 授权人ID
					authorization.setAuthorizationUserID(authorizationUserID);
					// 授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它13重复拆分）
					authorization.setAuthorizedReason("13");
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
					authorization.setToolID("");
					// 材料号
					authorization.setToolCode(synthesisParametersCodesArr[i]);
					// 流程ID
					authorization.setBusinessCode("C01S008");
					authorization.setNote("重复组装拆分");
					// 插入授权表
					c01S019Service.insertAuthorizationDao(authorization);
				}

			}

			if (tubeList.size() > 0) {
				// 新建筒刀拆分记录
				c01S008Service.insertTubedetailinfo(tubeList);
			}

			cJsonStr = jsonResult(true);
		} catch (Exception e) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}

		return cJsonStr;
	}
}
