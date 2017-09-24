package com.fj.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.GoodsDao;
import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.PageBean;
import com.fj.service.GoodsService;
@Transactional
public class GoodsServiceImp implements GoodsService{

	//定义好dao类
	private GoodsDao goodsDao;
	
	@Override
	public PageBean<Goods> findGoodsByTheFirstTen(PageBean<Goods> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.findGoodsTheFirst(pageBean);
	}
	
	@Override
	public PageBean<Goods> findAllGoods(int currentPage,
			GoodsCondition goodsCondition) throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.findGoodsByCondition(currentPage, goodsCondition,5);
	}
	
	@Override
	public PageBean<Goods> findAllGoods(int currentPage,
			GoodsCondition goodsCondition, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.findGoodsByCondition(currentPage, goodsCondition, pageSize);
	}
	
	@Override
	public PageBean<Goods> findGoodsByCreaTime(int day, PageBean<Goods> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.findGoodsByCreaTime(day, pageBean);
	}
	
	@Override
	public void deleteFreePrice(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		Goods findGoods = goodsDao.findById(goods.getId());
		findGoods.setMark(0);
		//更新
		goodsDao.update(findGoods);
	}
	@Override
	public void updateFreePrice(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		//先获得对象
		Goods findGoods = goodsDao.findById(goods.getId());
		//设置改变的值
		findGoods.setNowPrice(goods.getNowPrice());
		findGoods.setFreePrice(goods.getFreePrice());
		findGoods.setMark(1);
		//更新
		goodsDao.update(findGoods);
	}
	
	@Override
	public Goods findGoodsById(int id) throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.findById(id);
	}
	
	@Override
	public PageBean<Goods> findAllGoods(PageBean<Goods> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return goodsDao.findPageBeanAll(pageBean);
	}

	@Override
	public void addGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		goodsDao.add(goods);
	}

	@Override
	public void deleteGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		goodsDao.delete(goods);
	}

	@Override
	public void updateGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		goodsDao.update(goods);
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	
	
}
