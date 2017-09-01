package com.icode.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icode.mapper.TbItemMapper;
import com.icode.pojo.TbItem;
import com.icode.pojo.TbItemExample;

public class TestPageHelper {

	private ApplicationContext applicationContext;

	@Test
	public void testPageHelper() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*");
		// 从spring容器中获得mapper的代理对象
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		// 执行查询
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(1, 10); // 分页设置
		// 获取商品列表
		List<TbItem> list = mapper.selectByExample(example);
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		// 获取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有" + total + "条商品");
	}
}
