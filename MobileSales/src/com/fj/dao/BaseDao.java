package com.fj.dao;

import java.util.List;

import com.fj.domain.PageBean;

public interface BaseDao<T> {
	//添加
	public void add(T t);
	//修改
	public void update(T t);
	//删除
	public void delete(T t);
	//查询(根据id)
	public T findById(int id);
	//查询所有
	public List<T> findAll();
	//分页查询所有
	public PageBean<T> findPageBeanAll(PageBean<T> pageBean) throws Exception;
	//查询表的所有数量
	public Integer getCount();
	//条件查询	返回一个结果
	public T findOneByCondition(T t) throws Exception;
}
