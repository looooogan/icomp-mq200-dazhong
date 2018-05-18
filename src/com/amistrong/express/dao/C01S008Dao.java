package com.amistrong.express.dao;

import org.apache.ibatis.annotations.Param;

import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Tubedetailinfo;

/**
 * 刀具拆分Dao
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S008Dao {

	// 更新合成刀库表
	void updateSynthesisknife(@Param("sk") Synthesisknife sk);

	// 根据材料号查询刀具流转统计表数据
	TooltransferTotal getTooltransferTotalInfoByToolCode(@Param("toolCode")String toolCode);

	// 根据材料号 更新流转统计表数据
	void updateTooltransferTotal(@Param("tt")TooltransferTotal tt);

	// 更新刀具流转表 刀具状态
	void updateTooltransfer(@Param("tf")Tooltransfer tf);

	// 更新筒刀详细使用状态
	void updateTubedetailinfo(@Param("tbf")Tubedetailinfo tbf);

	// 新建筒刀拆分记录
	void insertTubedetailinfo(@Param("t")Tubedetailinfo tbf);

	// 查询最后一次修磨次数
	Integer getGrindingsum(@Param("t")Tubedetailinfo bean);

	String getTubeId(@Param("tbf")Tubedetailinfo tbf);



}
