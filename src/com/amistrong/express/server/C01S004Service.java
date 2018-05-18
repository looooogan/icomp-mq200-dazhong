package com.amistrong.express.server;

import java.util.List;

import com.amistrong.express.beans.response.Replacement;
import com.amistrong.express.beans.response.Scrap;
import com.amistrong.express.beans.response.Toollibraryhistory;
import com.amistrong.express.beans.response.Tooltransfer;


/**
 * 补领出库service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S004Service {

	// 取得补领出库申请列表
	List<Replacement> getReplacementList();

	// 查询申领详细信息
	List<Replacement> getReplacementApply(Replacement raentity);

	// 查询单号查询申请信息
	List<Replacement> searchReplacement(Replacement reentity);

	// 插入流转表
	void insertTooltransfer(Tooltransfer tt);

	// 插入到报废表
	void insertScrap(Scrap scrap);

	// 更新申请表
	void updateRedempentity(Replacement redempentity);

	// 插入刀具出库履历
	void insertTlentity(Toollibraryhistory tlentity);

}
