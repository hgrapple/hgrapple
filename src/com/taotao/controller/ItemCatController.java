package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyTreeResult;
import com.taotao.service.ItemCatService;

/**
 * 商品分类
 * @author chenyongbin
 *
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 商品类目选择,根据parentid查询子类目
	 * @param id
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	//如果id为null是使用默认值，也就是parentid为0的分类列表
	public List<EasyTreeResult>  catList(@RequestParam(value="id",defaultValue="0")Long parentId){
		return itemCatService.getCatList(parentId);
	}

}
