package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);

		// 有条件的查询
		// TbItemExample example = new TbItemExample();
		// Criteria criteria = example.createCriteria();
		// criteria.andIdEqualTo(itemId);
		// List<TbItem> list = itemMapper.selectByExample(example);
		// if (list != null && list.size() > 0) {
		// TbItem item = list.get(0);
		// return item;
		// }
		// return null;

	}
	public EasyUIResult getList(int page,int row){
		//分页处理
		PageHelper.startPage(page, row);
		
		List<TbItem> list=itemMapper.selectByExample(new TbItemExample());
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		System.out.println("哈哈list"+list.get(0));
		System.out.println("哈哈pageInfo"+pageInfo.getTotal());
		return new EasyUIResult(pageInfo.getTotal(),list);
		
	}
	

}
