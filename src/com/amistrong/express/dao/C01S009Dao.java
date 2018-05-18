package com.amistrong.express.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.Tubedetailinfo;

/**
 * 刀具换装Dao
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S009Dao {

	// 查询刀具信息
	List<Tooltransfer> searchTooltransferList(@Param("tt") Tooltransfer tt);

	// 插入筒刀表数据
	void insertTubedetailinfo(@Param("t") Tubedetailinfo t);

	// 查询筒刀信息
	Tubedetailinfo getTubeInfo(@Param("rFID")String rFID, @Param("toolCode")String toolCode);

	Tubedetailinfo searchByTubedetailinfo(@Param("tb")Tubedetailinfo entity);

	// 删除原有合成刀具信息
	void deleteSynthesisknife(@Param("deleteSynEntity")Synthesisknife deleteSynEntity);

}
