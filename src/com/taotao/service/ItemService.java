package com.taotao.service;

import com.taotao.common.pojo.EasyUIResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	public TbItem getItemById(long itemId);
	public EasyUIResult getList(int page,int row);
}
