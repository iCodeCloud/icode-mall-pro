package com.icode.service;

import java.util.List;

import com.icode.common.pojo.EUTreeNode;

public interface ItemCatService {

	List<EUTreeNode> getItemCatList(long parentId);

}
