package com.fj.service;

import java.util.List;

import com.fj.domain.BigType;
import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.PageBean;

public interface GoodsService {
	//分页查询所有的商品
	public PageBean<Goods> findAllGoods(PageBean<Goods> pageBean) throws Exception;
	//添加商品
	public void addGoods(Goods goods) throws Exception;
	//删除商品
	public void deleteGoods(Goods goods) throws Exception;
	//修改商品
	public void updateGoods(Goods goods) throws Exception;
	//修改商品 的特价信息
	public void updateFreePrice(Goods goods) throws Exception;
	//删除特价
	public void deleteFreePrice(Goods goods) throws Exception;
	//依靠id去查询商品
	public Goods findGoodsById(int id) throws Exception;
	
	//分页条件查询所有的商品(开始位置 和条件对象)
	public PageBean<Goods> findAllGoods(int currentPage,GoodsCondition goodsCondition) throws Exception;
}
