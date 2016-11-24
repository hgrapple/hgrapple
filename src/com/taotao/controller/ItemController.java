package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		return itemService.getItemById(itemId);
	}
	/**
	 * 商品列表分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIResult  itemList(Integer page,Integer rows){
		System.out.println("哈哈");
		return itemService.getList(page, rows);
	}
	
	


}
