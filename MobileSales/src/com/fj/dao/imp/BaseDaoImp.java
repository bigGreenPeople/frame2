package com.fj.dao.imp;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.dao.BaseDao;
@SuppressWarnings("all")
public class BaseDaoImp<T> extends HibernateDaoSupport implements BaseDao<T> {
	//���͵�ʵ������
	private Class pclazz;
	
	//ʹ�ù��췽��	�õ�����ķ�����Ϣ
	public BaseDaoImp() {
		// TODO Auto-generated constructor stub
		//�ȵõ����ǵ�����Ϣ
		Class clazz = this.getClass();
		//�õ�����������BaseDaoImp<Customer>
		Type type = clazz.getGenericSuperclass();
		//ת��Ϊ�ӽӿ�
		ParameterizedType ptype = (ParameterizedType) type;
		//�õ�<Customer>
		Type[] types = ptype.getActualTypeArguments();
		//��Typeת��ΪClass(Type��Class�Ľӿ�)
		//�����͵õ������Ƿ��ʹ��ݹ�����ʵ������
		pclazz = (Class) types[0];
		//System.out.println(pclazz);
		
	}
	
	//����
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
	}
	//�޸�
	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}
	//ɾ��
	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}
	
	//������������Ҫʹ�õ����͵���������ͬһ�ڹ��췽������õ����͵���Ϣ
	//����id��ѯ
	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(pclazz, id);
	}
	//��ѯ����
	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().find("from "+pclazz.getSimpleName());
	}
	//������ѯһ��
	@Override
	public T findOneByCondition(T t) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("all")
		
		//Ҫ���õ�����ֵ
		List<Object> list = new ArrayList<Object>();
		//Ҫ���õ�������
		List<String> listField = new ArrayList<String>();
		String intoMess = "";
		//�õ����е�����
		Field[] fs = pclazz.getDeclaredFields();
		for(int i = 0 ; i < fs.length; i++){
			Field f = fs[i];  
			
            f.setAccessible(true); //����Щ�����ǿ��Է��ʵ�  
            Object val = f.get(t);//�õ������Ե�ֵ    
            String type = f.getType().toString();//�õ������Ե�����  
            //�����Ϊnull
            if (type.endsWith("int") || type.endsWith("Integer")) { 
              if(val!=null && !"0".equals(val.toString())){
            	  //���뵽����������
            	  listField.add(f.getName());
            	//���뵽list
            	list.add(val);
              }
           }else if(type.endsWith("List") || type.endsWith("Set")  || type.endsWith("Map")){
        	   
           }
            else{  
        	   if(val!=null){
        		   //���뵽����������
             	  listField.add(f.getName());
        		 //���뵽list
            	  list.add(val);
               }
        	   
           }
		}
		
		//���߲�ѯ
		DetachedCriteria criteria = DetachedCriteria.forClass(pclazz);
		
		//��������
		for(int i=0;i<list.size();i++){
			criteria.add(Restrictions.eq(listField.get(i), list.get(i)));
		}
		
		List<T> listQuery = (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
		//�ж�list����û��ֵ
		if(listQuery!=null && listQuery.size()!=0){
			//�������ǵĵ�¼�û�
			return listQuery.get(0);
		}
		return null;
	}
}