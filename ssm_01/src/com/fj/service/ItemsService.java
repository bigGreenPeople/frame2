package com.fj.service;

import java.util.List;

import com.fj.po.Items;
import com.fj.po.ItemsCustom;
import com.fj.po.ItemsQueryVo;

public interface ItemsService {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	//根据id查询商品信息
	public ItemsCustom findItemById(Integer id)throws Exception;
	//修改商品信息
	public void saveItem(Integer id,ItemsCustom itemsCustom)throws Exception;
	//批量删除商品
	public void deleteAllItems(Integer[] item_id);
	
}
