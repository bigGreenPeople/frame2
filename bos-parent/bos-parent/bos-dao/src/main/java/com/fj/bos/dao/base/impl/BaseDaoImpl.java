package com.fj.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.bos.dao.base.IBaseDao;
import com.fj.bos.utils.PageBean;

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
	
	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	
	//条件查询
	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	//分页
	@Override
	public void pageQuery(PageBean pageBean) {
		//得到当前页和每页显示的记录数
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		
		//查询到总数据量(给detachedCriteria设置查询的返回)
		detachedCriteria.setProjection(Projections.rowCount());
		//执行得到总记录
		List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = countList.get(0);
		
		pageBean.setTotal(count.intValue());
		
		//查询得到的集合(先把刚才设置的条件置为空)
		detachedCriteria.setProjection(null);
		//这里要设置hibernate的回来的数据封装到一个对象中而不是两个object
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
		//得到其实位置
		int firstResult = (currentPage-1)*pageSize;
		int maxResults = pageSize;
		
		//发生语句
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
		
	}
	
	//执行写好的sql语句
	public void executeUpdate(String queryName, Object... objects) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		
		Query query = session.getNamedQuery(queryName);
		//?赋值 
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
		
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
