package com.amistrong.express.server;

import java.util.List;

import com.amistrong.express.beans.request.ToolChangehistory;
import com.amistrong.express.beans.response.*;
import org.apache.ibatis.annotations.Param;

/**
 * 刀具换装service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S010Service {

	// 根据合成刀编号查询刀具详细信息
	List<Synthesiscutterlocation> getSynthesisToolList(String spCode);

	// 新增刀具流转履历
	void insertTooltransferhistory(Tooltransferhistory tth);

	void insertTooltransfer(Tooltransfer tt);

	// 根据合成刀具编码查询刀具最后一次加工信息
	Synthesistoolsmachining getSynthesistoolsmachiningInfoBySpCode(String string);

	// 新增调刀记录信息
	void insetToolChangehistory(ToolChangehistory tch);
	//查询替换刀具信息 R&D
	public String queryReplaceTool(String synthesisParametersID,String toolCode);
	public void insertSynthesisExchange(SynthesisExchange synthesisExchange);
	public void deleteSynthesisExchange(String rfid);

}
