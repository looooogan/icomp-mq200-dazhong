package com.amistrong.express.server;

import java.util.List;

import com.amistrong.express.beans.response.Synthesisknife;
import com.amistrong.express.beans.response.Tooltransfer;
import com.amistrong.express.beans.response.Tubedetailinfo;

/**
 * 刀具组装service
 * 
 * @author 王冉
 * @version 2017-6-28 14:43
 */
public interface C01S009Service {

	// 查询刀具信息
	List<Tooltransfer> searchTooltransferList(Tooltransfer tt);

	// 插入筒刀表数据
	void insertTubedetailinfo(Tubedetailinfo t);

	// 查询筒刀信息
	Tubedetailinfo getTubeInfo(String rFID, String toolCode);

	Tubedetailinfo searchByTubedetailinfo(Tubedetailinfo entity);

	// 删除原有合成刀具信息
	void deleteSynthesisknife(Synthesisknife deleteSynEntity);

}
