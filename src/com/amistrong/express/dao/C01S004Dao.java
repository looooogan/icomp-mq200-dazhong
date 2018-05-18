package com.amistrong.express.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amistrong.express.beans.response.Replacement;
import com.amistrong.express.beans.response.Scrap;
import com.amistrong.express.beans.response.Toollibraryhistory;
import com.amistrong.express.beans.response.Tooltransfer;
/**
 * 换领出库Dao
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S004Dao {

	// 取得补领出库申请列表
	List<Replacement> getReplacementList();

	// 查询申领详细信息
	List<Replacement> getReplacementApply(@Param("raentity")Replacement raentity);

	// 查询单号查询申请信息
	List<Replacement> searchReplacement(@Param("reentity")Replacement reentity);

	// 插入流转表
	void insertTooltransfer(@Param("tt")Tooltransfer tt);

	// 插入到报废表
	void insertScrap(@Param("scrap")Scrap scrap);

	// 更新申请表
	void updateRedempentity(@Param("redempentity")Replacement redempentity);

	// 插入刀具出库履历
	void insertTlentity(@Param("tlentity")Toollibraryhistory tlentity);

}
