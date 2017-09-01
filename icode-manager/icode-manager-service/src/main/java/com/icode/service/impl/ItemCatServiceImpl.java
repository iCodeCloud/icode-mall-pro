package com.icode.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icode.service.ItemCatService;
import com.icode.common.pojo.EUTreeNode;
import com.icode.mapper.TbItemCatMapper;
import com.icode.pojo.TbItemCat;
import com.icode.pojo.TbItemCatExample;
import com.icode.pojo.TbItemCatExample.Criteria;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	/**
	 * 通过父id，查询分类列表
	 */
	@Override
	public List<EUTreeNode> getItemCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> result = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent() ? "closed" : "open");
			result.add(node);
		}
		return result;
	}

}
