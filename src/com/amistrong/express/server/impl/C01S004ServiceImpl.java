package com.amistrong.express.server.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amistrong.express.beans.response.Replacement;
import com.amistrong.express.beans.response.Scrap;
import com.amistrong.express.beans.response.Toollibraryhistory;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.dao.C01S004Dao;
import com.amistrong.express.server.C01S004Service;

/**
 * 补领申请ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
public class C01S004ServiceImpl implements C01S004Service {

	@Autowired
	private C01S004Dao c01S004Dao;

	/**
	 * 取得补领出库申请列表
	 */
	public List<Replacement> getReplacementList() {
		List<Replacement> list = c01S004Dao.getReplacementList();
		return list;
	}

	/**
	 * 查询申领详细信息
	 */
	public List<Replacement> getReplacementApply(Replacement raentity) {
		List<Replacement> list = c01S004Dao.getReplacementApply(raentity);
		return list;
	}

	/**
	 * 查询单号查询申请信息
	 */
	public List<Replacement> searchReplacement(Replacement reentity) {
		List<Replacement> list = c01S004Dao.searchReplacement(reentity);
		return list;
	}

	/**
	 * 插入流转表
	 */
	public void insertTooltransfer(Tooltransfer tt) {
		 c01S004Dao.insertTooltransfer(tt);
		
	}

	/**
	 * 插入到报废表
	 */
	public void insertScrap(Scrap scrap) {
		 c01S004Dao.insertScrap(scrap);
		
	}

	/**
	 * 更新申请表
	 */
	public void updateRedempentity(Replacement redempentity) {
		c01S004Dao.updateRedempentity(redempentity);
		
	}

	/**
	 * 刀具出库履历
	 */
	public void insertTlentity(Toollibraryhistory tlentity) {
		c01S004Dao.insertTlentity(tlentity);
		
	}

}
