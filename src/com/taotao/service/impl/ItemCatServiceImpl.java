package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyTreeResult;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;
/**
 * 商品分类
 * @author chenyongbin
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyTreeResult> getCatList(long parentId) {
		//创建查询条件
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//查询
		List<TbItemCat> list=itemCatMapper.selectByExample(example);
		
		//转换成EasyTreeResult
		List<EasyTreeResult> result=new ArrayList<EasyTreeResult>();
		for(TbItemCat cat:list){
			EasyTreeResult tree=new EasyTreeResult();
			tree.setId(cat.getId());
			tree.setText(cat.getName());
			//如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
			tree.setState(cat.getIsParent()?"closed":"open");
			result.add(tree);
		}
		return result;
	}
}
