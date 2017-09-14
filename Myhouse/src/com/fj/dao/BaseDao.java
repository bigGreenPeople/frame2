package com.fj.dao;

import java.util.List;

import com.fj.domain.PageBean;

public interface BaseDao<T> {
	//依靠id去查询一个
	public T findById(Integer id) throws Exception;
	//依靠user的内容去查询单个对象
	public List<T> findByCondition(T t) throws Exception;
	//条件的分页查询
	public PageBean<T> findPageByCondition(T t,PageBean<T> pageBean) throws Exception;
	//得到表的所有记录数
	public Integer getCount() throws Exception;
	//依靠条件得到表的所有记录数
	public Integer getCountByCondition(String intoMess,Object[] params) throws Exception;
	public Integer getCountByCondition(String intoMess) throws Exception;
	//查询所有
	public List<T> findAll() throws Exception;
	//分页查询所有
	public PageBean<T> findPageAll(PageBean<T> pageBean) throws Exception;
	//添加一个
	public int addOne(T t) throws Exception;
	//依靠ID修改一个
	public int updateById(T t,Integer id) throws Exception;
	//依靠ID删除一个
	public int deleteById(Integer id) throws Exception;
	
}
