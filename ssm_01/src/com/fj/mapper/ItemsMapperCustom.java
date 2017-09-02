package com.fj.mapper;

import java.util.List;

import com.fj.po.ItemsCustom;
import com.fj.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo);
}
