package com.icode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icode.common.pojo.EUTreeNode;
import com.icode.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	/**
	 * 根据父id，查询分类列表
	 * 
	 * @param parentId
	 *            父id
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		return itemCatService.getItemCatList(parentId);
	}

}
