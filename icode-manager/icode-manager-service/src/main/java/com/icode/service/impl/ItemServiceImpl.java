package com.icode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icode.service.ItemService;
import com.icode.common.pojo.EUDataGridResult;
import com.icode.mapper.TbItemMapper;
import com.icode.pojo.TbItem;
import com.icode.pojo.TbItemExample;
import com.icode.pojo.TbItemExample.Criteria;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		TbItem result = null;
		// 方法一：根据主键查询
		// return itemMapper.selectByPrimaryKey(itemId);
		// 方法二：根据条件查询
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			result = item;
		}
		return result;
	}

	/**
	 * 商品列表查询
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		// 查询商品列表
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows); // 分页
		List<TbItem> list = itemMapper.selectByExample(example);
		// 创建返回值对象
		EUDataGridResult result = new EUDataGridResult();
		// 1.数据结合
		result.setRows(list);
		// 2.通过pageinfo，查询总条数。
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
