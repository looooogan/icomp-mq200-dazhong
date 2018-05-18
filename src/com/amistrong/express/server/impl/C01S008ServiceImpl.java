package com.amistrong.express.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.TooltransferTotal;
import com.amistrong.express.beans.response.Tubedetailinfo;
import com.amistrong.express.dao.C01S008Dao;
import com.amistrong.express.server.C01S008Service;

/**
 * 刀具拆分ServiceImpl
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
// Server作为业务层
@Service
public class C01S008ServiceImpl implements C01S008Service {

	@Autowired
	private C01S008Dao c01S008Dao;

	/**
	 * 更新合成刀库表
	 */
	public void updateSynthesisknife(Synthesisknife sk) {
		c01S008Dao.updateSynthesisknife(sk);

	}

	/**
	 * 根据材料号 更新流转统计表数据
	 */
	public void updateTooltransferTotal(TooltransferTotal tt) {
		c01S008Dao.updateTooltransferTotal(tt);

	}

	/**
	 * 更新刀具流转表 刀具状态
	 */
	public void updateTooltransfer(Tooltransfer tf) {
		c01S008Dao.updateTooltransfer(tf);

	}

	/**
	 * 更新筒刀详细使用状态
	 */
	public void updateTubedetailinfo(Tubedetailinfo tbf) {
		c01S008Dao.updateTubedetailinfo(tbf);

	}

	/**
	 * 新建筒刀拆分记录
	 */
	public void insertTubedetailinfo(List<Tubedetailinfo> list) {
		for (int i = 0; i < list.size(); i++) {
			c01S008Dao.insertTubedetailinfo(list.get(i));
		}

	}

	/**
	 * 查询最后一次修磨次数
	 */
	public Integer getGrindingsum(Tubedetailinfo bean) {
		Integer sum = c01S008Dao.getGrindingsum(bean);
		return sum;
	}

	@Override
	public String getTubeId(Tubedetailinfo tbf) {
		String id = c01S008Dao.getTubeId(tbf);
		return id;
	}

}
