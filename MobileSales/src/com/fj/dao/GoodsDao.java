package com.fj.dao;

import java.util.List;

import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.PageBean;

public interface GoodsDao extends BaseDao<Goods>{
	//条件分页查询商品
/*	public PageBean<Goods> findGoodsByCondition(int currentPage,
			GoodsCondition goodsCondition) throws Exception;*/
	public PageBean<Goods> findGoodsByCondition(int currentPage,
			GoodsCondition goodsCondition,int pageSize) throws Exception;
	//查询得到手机销售前十的商品
	public PageBean<Goods> findGoodsTheFirst(PageBean<Goods> pageBean) throws Exception;
	//查询最近几天创建的商品
	public PageBean<Goods> findGoodsByCreaTime(int day,
			PageBean<Goods> pageBean) throws Exception;
}
