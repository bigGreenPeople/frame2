package com.fj.dao;

import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.PageBean;

public interface GoodsDao extends BaseDao<Goods>{
	//条件分页查询商品
	public PageBean<Goods> findGoodsByCondition(int currentPage,
			GoodsCondition goodsCondition) throws Exception;
}
