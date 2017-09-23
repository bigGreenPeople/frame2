package com.fj.service;

import java.util.List;

import com.fj.domain.BigType;
import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.PageBean;

public interface GoodsService {
	//��ҳ��ѯ���е���Ʒ
	public PageBean<Goods> findAllGoods(PageBean<Goods> pageBean) throws Exception;
	//�����Ʒ
	public void addGoods(Goods goods) throws Exception;
	//ɾ����Ʒ
	public void deleteGoods(Goods goods) throws Exception;
	//�޸���Ʒ
	public void updateGoods(Goods goods) throws Exception;
	//�޸���Ʒ ���ؼ���Ϣ
	public void updateFreePrice(Goods goods) throws Exception;
	//ɾ���ؼ�
	public void deleteFreePrice(Goods goods) throws Exception;
	//����idȥ��ѯ��Ʒ
	public Goods findGoodsById(int id) throws Exception;
	
	//��ҳ������ѯ���е���Ʒ(��ʼλ�� ����������)
	public PageBean<Goods> findAllGoods(int currentPage,GoodsCondition goodsCondition) throws Exception;
}
