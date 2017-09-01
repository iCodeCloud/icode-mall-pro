package com.icode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icode.common.pojo.EUDataGridResult;
import com.icode.pojo.TbItem;
import com.icode.service.ItemService;

/**
 * 商品管理
 * 
 * @author Administrator
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 根据商品id，查询商品信息
	 * 
	 * @param itemId
	 *            商品id
	 * @return
	 */
	@RequestMapping("item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		return itemService.getItemById(itemId);
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		return itemService.getItemList(page, rows);
	}

}
