package com.amistrong.express.server;

import java.util.List;

import com.amistrong.express.beans.response.Redemptionapplied;
import com.amistrong.express.beans.response.Rfidcontainer;
import com.amistrong.express.beans.response.Scrap;
import com.amistrong.express.beans.response.ScrapState;
import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tool;
import com.amistrong.express.beans.response.Toolnoticehistory;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Toolwholelifecycle;
import com.amistrong.express.beans.response.Tubedetailinfo;

/**
 * 刀具报废service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S005Service {

	// 插入报废表数据
	void insertScrap(Scrap entity);

	// 更新流转统计表数据
	void updateTooltransferTotalInfo(TooltransferTotal tst);

	// 根据材料号查询流转统计表数据
	TooltransferTotal getTooltransferTotalInfoByToolCode(String toolCode);

	// 新建换领申请表数据
	void insertRedemptionapplied(Redemptionapplied r);

	// 根据rfid材料载体信息
	Rfidcontainer getRfidInfoByRfid(String rfid);

	// 根据合成刀具码查询刀具信息
	Tool searchToolInfoBySpcode(String spCode);

	// 删除刀具生命周期表数据
	void updateToolwholelifecycle(Toolwholelifecycle tf);

	// 删除合成刀库数据
	void updateSynthesisknife(Synthesisknife sf);

	// 更新筒刀表信息
	void updateTubedetailinfo(Tubedetailinfo bean);

	// 查询刀具报废状态list
	List<ScrapState> getScrapStateList();

	void insertError();

	// 新增刀具修复履历
	void insertToolnoticehistory(Toolnoticehistory tnh);

}
