package com.amistrong.express.server;

import java.util.List;

import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Tubedetailinfo;

/**
 * 刀具拆分service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S008Service {

	// 更新合成刀库表
	void updateSynthesisknife(Synthesisknife sk);

	// 根据材料号 更新流转统计表数据
	void updateTooltransferTotal(TooltransferTotal tt);

	// 更新刀具流转表 刀具状态
	void updateTooltransfer(Tooltransfer tf);

	// 更新筒刀详细使用状态
	void updateTubedetailinfo(Tubedetailinfo tbf);

	// 新建筒刀拆分记录
	void insertTubedetailinfo(List<Tubedetailinfo> list);

	// 查询最后一次修磨次数
	Integer getGrindingsum(Tubedetailinfo bean);

	String getTubeId(Tubedetailinfo tbf);

}
