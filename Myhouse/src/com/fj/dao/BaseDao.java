package com.fj.dao;

import java.util.List;

public interface BaseDao<T> {
	//依靠id去查询一个
	public T findById(Integer id) throws Exception;
	//依靠user的内容去查询单个对象
	public List<T> findByCondition(T t) throws Exception;
	//查询所有
	public List<T> findAll() throws Exception;
	//添加一个
	public int addOne(T t) throws Exception;
	//依靠ID修改一个
	public int updateById(T t,Integer id) throws Exception;
	//依靠ID删除一个
	public int deleteById(Integer id) throws Exception;
	
}
