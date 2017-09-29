package com.fj.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.bos.dao.base.IBaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T>{

	//代表的是某个实体的类型
	private Class<T> entityClass;
	
	//使用构造方法得到真正的entityClass
	public BaseDaoImpl() {
		ParameterizedType  genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//得到泛型数组
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments(); 
		entityClass = (Class<T>) actualTypeArguments[0];
	}

	//由于使用的是注解所有我们这里要使用自己注入sessionFactory
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		String hql = "from "+entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

}
