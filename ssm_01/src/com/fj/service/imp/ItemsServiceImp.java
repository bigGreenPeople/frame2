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
	//ע��
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;

	//��ѯ���е���Ʒ��Ϣ 
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	//��ѯid����Ʒ��Ϣ
	@Override
	public ItemsCustom findItemById(Integer id) {
		// TODO Auto-generated method stub
		//����mapper�ķ����õ�items
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		//��items�����Կ�����itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
	}
	//������Ʒ��Ϣ
	@Override
	public void saveItem(Integer id, ItemsCustom itemsCustom) throws Exception {
		// TODO Auto-generated method stub
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKey(itemsCustom);
	}
	//����ɾ��
	@Override
	public void deleteAllItems(Integer[] item_id) {
		// TODO Auto-generated method stub
		for (Integer id : item_id) {
			itemsMapper.deleteByPrimaryKey(id);
		}
	}
}
