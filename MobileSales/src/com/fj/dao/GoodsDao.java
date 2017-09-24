package com.fj.dao;

import java.util.List;

import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.PageBean;

public interface GoodsDao extends BaseDao<Goods>{
	//������ҳ��ѯ��Ʒ
/*	public PageBean<Goods> findGoodsByCondition(int currentPage,
			GoodsCondition goodsCondition) throws Exception;*/
	public PageBean<Goods> findGoodsByCondition(int currentPage,
			GoodsCondition goodsCondition,int pageSize) throws Exception;
	//��ѯ�õ��ֻ�����ǰʮ����Ʒ
	public PageBean<Goods> findGoodsTheFirst(PageBean<Goods> pageBean) throws Exception;
	//��ѯ������촴������Ʒ
	public PageBean<Goods> findGoodsByCreaTime(int day,
			PageBean<Goods> pageBean) throws Exception;
}
