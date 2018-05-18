package com.amistrong.express.dao;

import java.util.List;

import com.amistrong.express.beans.response.*;
import org.apache.ibatis.annotations.Param;

import com.amistrong.express.beans.request.ToolChangehistory;

/**
 * 刀具换装Dao
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S010Dao {

	// 根据合成刀编号查询刀具详细信息
	List<Synthesiscutterlocation> getSynthesisToolList(
			@Param("spCode") String spCodesArr);

	// 新增刀具流转履历
	void insertTooltransferhistory(@Param("tth") Tooltransferhistory tth);

	void insertTooltransfer(@Param("tt") Tooltransfer tt);

	// 根据合成刀具编码查询刀具最后一次加工信息
	Synthesistoolsmachining getSynthesistoolsmachiningInfoBySpCode(@Param("spCode")String spCode);

	// 新增调刀记录信息
	void insetToolChangehistory(@Param("tch")ToolChangehistory tch);

	//查询替换刀具信息 R&D
	String queryReplaceTool(@Param("synthesisParametersID")String synthesisParametersID,@Param("toolCode")String toolCode);

	void insertSynthesisExchange(@Param("synthesisExchange") SynthesisExchange synthesisExchange);
	void deleteSynthesisExchange(@Param("rfid") String rfid);


}
