package com.fj.service;

import java.util.List;

import com.fj.po.Items;
import com.fj.po.ItemsCustom;
import com.fj.po.ItemsQueryVo;

public interface ItemsService {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

}
