package com.fj.dao.imp;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.dao.BaseDao;
import com.fj.domain.PageBean;
@SuppressWarnings("all")
public class BaseDaoImp<T> extends HibernateDaoSupport implements BaseDao<T> {
	//泛型的实际类型
	private Class pclazz;
	
	//使用构造方法	得到父类的泛型信息
	public BaseDaoImp() {
		// TODO Auto-generated constructor stub
		//先得到我们的类信息
		Class clazz = this.getClass();
		//得到参数化类型BaseDaoImp<Customer>
		Type type = clazz.getGenericSuperclass();
		//转换为子接口
		ParameterizedType ptype = (ParameterizedType) type;
		//得到<Customer>
		Type[] types = ptype.getActualTypeArguments();
		//把Type转换为Class(Type是Class的接口)
		//这样就得到了我们泛型传递过来的实际类了
		pclazz = (Class) types[0];
		//System.out.println(pclazz);
		
	}
	
	//增加
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
	}
	//修改
	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}
	//删除
	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}
	
	//下面两个方法要使用到泛型的名字我们同一在构造方法里面得到泛型的信息
	//根据id查询
	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(pclazz, id);
	}
	//查询所有
	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().find("from "+pclazz.getSimpleName());
	}
	//分页查询所有
	@Override
	public PageBean<T> findPageBeanAll(PageBean<T> pageBean) throws Exception {
		// TODO Auto-generated method stub
		//离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(pclazz);
		
		//查询得到总记录数
		pageBean.setTotalCount(this.getCount());
		//计算开始位置
		int begin = (pageBean.getCurrentPage()-1)*pageBean.getPageSize()+1;
		pageBean.setBegin(begin);
		//计算出总页数
		int totalPage=pageBean.getTotalCount()%pageBean.getPageSize()==0?
				pageBean.getTotalCount()/pageBean.getPageSize():
					pageBean.getTotalCount()/pageBean.getPageSize()+1;
		pageBean.setTotalPage(totalPage);
		//计算出结束位置
		int end = pageBean.getCurrentPage()*pageBean.getPageSize();
		pageBean.setEnd(end);
		//得到分页后的
		List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(criteria, pageBean.getBegin()-1, pageBean.getPageSize());
		//封装pageBean
		pageBean.setList(list);
		return pageBean;
	}
	
	//查询表记录的所有数量
	public Integer getCount() {
		//离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(pclazz);
		criteria.setProjection(Projections.count("id"));
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
		//如果不为空
		if(list.size()!=0 && list!=null){
			//返回我们的记录数
			return list.get(0).intValue();
		}
		return 0;		
	}
	//条件查询一个
	@Override
	public T findOneByCondition(T t) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("all")
		
		//要设置的属性值
		List<Object> list = new ArrayList<Object>();
		//要设置的属性名
		List<String> listField = new ArrayList<String>();
		String intoMess = "";
		//得到所有的属性
		Field[] fs = pclazz.getDeclaredFields();
		for(int i = 0 ; i < fs.length; i++){
			Field f = fs[i];  
			
            f.setAccessible(true); //设置些属性是可以访问的  
            Object val = f.get(t);//得到此属性的值    
            String type = f.getType().toString();//得到此属性的类型  
            //如果不为null
            if (type.endsWith("int") || type.endsWith("Integer")) { 
              if(val!=null && !"0".equals(val.toString())){
            	  //加入到属性名里面
            	  listField.add(f.getName());
            	//加入到list
            	list.add(val);
              }
           }else if(type.endsWith("List") || type.endsWith("Set")  || type.endsWith("Map")){
        	   
           }
            else{  
        	   if(val!=null){
        		   //加入到属性名里面
             	  listField.add(f.getName());
        		 //加入到list
            	  list.add(val);
               }
        	   
           }
		}
		
		//离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(pclazz);
		
		//设置条件
		for(int i=0;i<list.size();i++){
			criteria.add(Restrictions.eq(listField.get(i), list.get(i)));
		}
		
		List<T> listQuery = (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
		//判断list中有没有值
		if(listQuery!=null && listQuery.size()!=0){
			//返回我们的登录用户
			return listQuery.get(0);
		}
		return null;
	}
	
	@Override
	public List<T> findListByCondition(T t) throws Exception {
		// TODO Auto-generated method stub
@SuppressWarnings("all")
		
		//要设置的属性值
		List<Object> list = new ArrayList<Object>();
		//要设置的属性名
		List<String> listField = new ArrayList<String>();
		String intoMess = "";
		//得到所有的属性
		Field[] fs = pclazz.getDeclaredFields();
		for(int i = 0 ; i < fs.length; i++){
			Field f = fs[i];  
			
            f.setAccessible(true); //设置些属性是可以访问的  
            Object val = f.get(t);//得到此属性的值    
            String type = f.getType().toString();//得到此属性的类型  
            //如果不为null
            if (type.endsWith("int") || type.endsWith("Integer")) { 
              if(val!=null && !"0".equals(val.toString())){
            	  //加入到属性名里面
            	  listField.add(f.getName());
            	//加入到list
            	list.add(val);
              }
           }else if(type.endsWith("List") || type.endsWith("Set")  || type.endsWith("Map")){
        	   
           }
            else{  
        	   if(val!=null){
        		   //加入到属性名里面
             	  listField.add(f.getName());
        		 //加入到list
            	  list.add(val);
               }
        	   
           }
		}
		
		//离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(pclazz);
		
		//设置条件
		for(int i=0;i<list.size();i++){
			criteria.add(Restrictions.eq(listField.get(i), list.get(i)));
		}
		
		List<T> listQuery = (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
		return listQuery;
	}
}
