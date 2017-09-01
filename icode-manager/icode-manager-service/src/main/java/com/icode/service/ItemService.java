package com.icode.service;

import com.icode.common.pojo.EUDataGridResult;
import com.icode.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	
	EUDataGridResult getItemList(int page, int rows);
	
}
