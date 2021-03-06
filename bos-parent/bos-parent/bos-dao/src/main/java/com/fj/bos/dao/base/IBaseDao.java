package com.fj.bos.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.fj.bos.utils.PageBean;

public interface IBaseDao<T> {
	public void save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	
	//去执行配置文件里的hql
	public void executeUpdate(String queryName, Object... objects);
	//分页
	public void pageQuery(PageBean pageBean);
	//更新或者查询
	public void saveOrUpdate(T entity);
	//条件查询方法
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);
}
