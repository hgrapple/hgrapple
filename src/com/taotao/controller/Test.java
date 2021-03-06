package com.taotao.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建spring容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:resource/spring/applicationContext-*.xml");
		// 从spring容器中获得Mapper的代理对象
		TbItemMapper mapper = ctx.getBean(TbItemMapper.class);
		// 执行查询，并分页
		TbItemExample example = new TbItemExample();
		// 分页处理
		
		PageHelper.startPage(1, 10);
		List<TbItem> list = mapper.selectByExample(example);
		// 取商品列表
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		// 取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品：" + total);

	}
}
