package com.fj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fj.mapper.ItemsMapperCustom;
import com.fj.po.Items;
import com.fj.po.ItemsCustom;
import com.fj.po.ItemsQueryVo;
import com.fj.service.ItemsService;

public class ItemsServiceImp implements ItemsService {
	//×¢Èë
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	


}
