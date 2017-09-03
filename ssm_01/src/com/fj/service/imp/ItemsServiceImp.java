package com.fj.service.imp;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fj.mapper.ItemsMapper;
import com.fj.mapper.ItemsMapperCustom;
import com.fj.po.Items;
import com.fj.po.ItemsCustom;
import com.fj.po.ItemsQueryVo;
import com.fj.service.ItemsService;

/**
 * @author Administrator
 *
 */
public class ItemsServiceImp implements ItemsService {
	//注入
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;

	//查询所有的商品信息 
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	//查询id的商品信息
	@Override
	public ItemsCustom findItemById(Integer id) {
		// TODO Auto-generated method stub
		//调用mapper的方法得到items
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		//将items的属性拷贝到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
	}
	//更新商品信息
	@Override
	public void saveItem(Integer id, ItemsCustom itemsCustom) throws Exception {
		// TODO Auto-generated method stub
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKey(itemsCustom);
	}
	//批量删除
	@Override
	public void deleteAllItems(Integer[] item_id) {
		// TODO Auto-generated method stub
		for (Integer id : item_id) {
			itemsMapper.deleteByPrimaryKey(id);
		}
	}
}
