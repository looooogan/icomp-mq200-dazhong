package com.amistrong.express.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.Tubedetailinfo;
import com.amistrong.express.dao.C01S009Dao;
import com.amistrong.express.server.C01S009Service;

/**
 * 刀具组装ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
public class C01S009ServiceImpl implements C01S009Service {

	@Autowired
	private C01S009Dao c01S009Dao;

	/**
	 * 查询刀具信息
	 */
	public List<Tooltransfer> searchTooltransferList(Tooltransfer tt) {
		List<Tooltransfer> list = c01S009Dao.searchTooltransferList(tt);
		return list;
	}

	/**
	 * 插入筒刀表数据
	 */
	public void insertTubedetailinfo(Tubedetailinfo t) {
		c01S009Dao.insertTubedetailinfo(t);

	}

	/**
	 * 查询筒刀信息
	 */
	public Tubedetailinfo getTubeInfo(String rFID, String toolCode) {
		Tubedetailinfo tubedetailinfo = c01S009Dao.getTubeInfo(rFID, toolCode);
		return tubedetailinfo;
	}

	@Override
	public Tubedetailinfo searchByTubedetailinfo(Tubedetailinfo entity) {
		Tubedetailinfo tbInfo = c01S009Dao.searchByTubedetailinfo(entity);
		return tbInfo;
	}

	// 删除原有合成刀具信息
	public void deleteSynthesisknife(Synthesisknife deleteSynEntity) {
		c01S009Dao.deleteSynthesisknife(deleteSynEntity);
		
	}

}
