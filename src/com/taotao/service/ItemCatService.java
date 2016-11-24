package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyTreeResult;

public interface ItemCatService {
	public List<EasyTreeResult> getCatList(long parentId);

}
