package com.fj.service;

import java.util.List;

import com.fj.po.Items;
import com.fj.po.ItemsCustom;
import com.fj.po.ItemsQueryVo;

public interface ItemsService {
	//��Ʒ��ѯ�б�
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	//����id��ѯ��Ʒ��Ϣ
	public ItemsCustom findItemById(Integer id)throws Exception;
	//�޸���Ʒ��Ϣ
	public void saveItem(Integer id,ItemsCustom itemsCustom)throws Exception;
	//����ɾ����Ʒ
	public void deleteAllItems(Integer[] item_id);
	
}
