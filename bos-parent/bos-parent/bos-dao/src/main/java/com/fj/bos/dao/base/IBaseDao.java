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
	
	//ȥִ�������ļ����hql
	public void executeUpdate(String queryName, Object... objects);
	//��ҳ
	public void pageQuery(PageBean pageBean);
	//���»��߲�ѯ
	public void saveOrUpdate(T entity);
	//������ѯ����
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);
}