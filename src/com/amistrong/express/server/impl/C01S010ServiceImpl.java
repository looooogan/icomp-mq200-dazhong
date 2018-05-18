package com.amistrong.express.server.impl;

import java.util.List;

import com.amistrong.express.beans.response.*;
import com.amistrong.express.dao.C03S001Dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amistrong.express.beans.request.ToolChangehistory;
import com.amistrong.express.dao.C01S010Dao;
import com.amistrong.express.server.C01S010Service;

/**
 * 刀具换装ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
public class C01S010ServiceImpl implements C01S010Service {

	@Autowired
	private C01S010Dao c01S010Dao;
	@Autowired
	private C03S001Dao c03S001Dao;


	/**
	 * 根据合成刀编号查询刀具详细信息
	 */
	public List<Synthesiscutterlocation> getSynthesisToolList(
			String spCodesArr) {
		List<Synthesiscutterlocation> list = c01S010Dao.getSynthesisToolList(spCodesArr);
		return list;
	}

	/**
	 * 新增刀具流转履历
	 */
	public void insertTooltransferhistory(Tooltransferhistory tth) {
		c01S010Dao.insertTooltransferhistory(tth);
		
	}

	/**
	 * 新增刀具流转
	 */
	public void insertTooltransfer(Tooltransfer tt) {
		c01S010Dao.insertTooltransfer(tt);

	}

	/**
	 * 根据合成刀具编码查询刀具最后一次加工信息
	 */
	public Synthesistoolsmachining getSynthesistoolsmachiningInfoBySpCode(
			String spCode) {
		Synthesistoolsmachining stm = c01S010Dao.getSynthesistoolsmachiningInfoBySpCode(spCode);
		return stm;
	}

	/**
	 * 新增调刀记录信息
	 */
	public void insetToolChangehistory(ToolChangehistory tch) {
		c01S010Dao.insetToolChangehistory(tch);
	}

	//查询替换刀具信息 R&D
	public String queryReplaceTool(String synthesisParametersID,String toolCode){
		return c01S010Dao.queryReplaceTool(synthesisParametersID,toolCode);
	}

	public void insertSynthesisExchange(@Param("synthesisExchange") SynthesisExchange synthesisExchange){
		c01S010Dao.insertSynthesisExchange(synthesisExchange);
	}

	public void deleteSynthesisExchange(@Param("rfid") String rfid){
		c01S010Dao.deleteSynthesisExchange(rfid);
	}


}
