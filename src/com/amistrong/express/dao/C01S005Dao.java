package com.amistrong.express.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
 * 刀具报废Dao
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S005Dao {

	// 插入报废表数据
	void insertScrap(@Param("scrap") Scrap entity);

	// 更新流转统计表数据
	void updateTooltransferTotalInfo(@Param("tst") TooltransferTotal tst);

	// 根据材料号查询流转统计表数据
	TooltransferTotal getTooltransferTotalInfoByToolCode(
			@Param("toolCode") String toolCode);

	// 新建换领申请表数据
	void insertRedemptionapplied(@Param("r") Redemptionapplied r);

	// 根据rfid材料载体信息
	Rfidcontainer getRfidInfoByRfid(@Param("rfid") String rfid);

	// 根据合成刀具码查询刀具信息
	Tool searchToolInfoBySpcode(@Param("spCode") String spCode);

	// 删除刀具生命周期表数据
	void updateToolwholelifecycle(@Param("tf") Toolwholelifecycle tf);

	// 删除合成刀库数据
	void updateSynthesisknife(@Param("sf") Synthesisknife sf);

	// 更新筒刀表信息
	void updateTubedetailinfo(@Param("tb") Tubedetailinfo bean);

	// 查询刀具报废状态list
	List<ScrapState> getScrapStateList();

	void insertError();

	// 新增刀具修复履历
	void insertToolnoticehistory(@Param("tnh")Toolnoticehistory tnh);

}
