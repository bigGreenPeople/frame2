package com.fj.dao;

import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.PageBean;

public interface GoodsDao extends BaseDao<Goods>{
	//������ҳ��ѯ��Ʒ
	public PageBean<Goods> findGoodsByCondition(int currentPage,
			GoodsCondition goodsCondition) throws Exception;
}
