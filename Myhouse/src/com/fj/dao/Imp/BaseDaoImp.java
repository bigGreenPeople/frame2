package com.fj.dao.Imp;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fj.dao.BaseDao;
import com.fj.domain.Users;
import com.fj.utils.TxQueryRunner;

public class BaseDaoImp<T> implements BaseDao<T>{
	//���͵�ʵ������
	private Class pclazz;
	
	@Override
	public List<T> findAll() throws SQLException {
		// TODO Auto-generated method stub
//		����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//д��sql���
		String sql = "select * from "+pclazz.getSimpleName();
		System.out.println("fjUtils:  "+sql);
		List<T> newlist = qr.query(sql, new BeanListHandler<T>(pclazz));
		return newlist;
	}
	
	@Override
	public int updateById(T t,Integer id) throws Exception {
		// TODO Auto-generated method stub
//		����TxQueryRunner
			TxQueryRunner qr = new TxQueryRunner();
			
			//Ҫ���õ�����ֵ
			List<Object> list = new ArrayList<Object>();
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
	              if(val!=null && !"0".equals(val.toString()) && !"id".equals(f.getName())){
	            	  //���뵽������
	            	  intoMess+=","+f.getName()+"=?";
	            	//���뵽list
	            	list.add(val);
	              }
	           }else{  
	        	   if(val!=null){
	             	  //���뵽������
	        		  intoMess+=","+f.getName()+"=?";
	        		 //���뵽list
	            	  list.add(val);
	               }
	        	   
	           }
			}
			
			//����Ҫע��Ĳ���
			Object[] params = new Object[list.size()];
			for (int i=0;i<list.size();i++) {
				params[i] = list.get(i);
			}
			//д��sql���
			//update users set password=?,telephone=? where id=1;
			String sql = "update "+pclazz.getSimpleName()+" set id="+id+intoMess+" where id="+id;
			System.out.println("fjUtils:  "+sql);
			int num = qr.update(sql, params);
			return num;
	}
	
	@Override
	public int deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
//		����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//д��sql���
		String sql = "delete from "+pclazz.getSimpleName()+" where id=?";
		System.out.println("fjUtils:  "+sql);
		//����Ҫע��Ĳ���
		int num = qr.update(sql, id);
		return num;
	}
	
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

	@Override
	public T findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
//		����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//д��sql���
		String sql = "select * from "+pclazz.getSimpleName()+" where id=?";
		//����Ҫע��Ĳ���
		System.out.println("fjUtils:  "+sql);
		System.out.println("����:" + id);
		T t = qr.query(sql, new BeanHandler<T>(pclazz), id);
		return t;
	}

	@Override
	public List<T> findByCondition(T t) throws Exception {
//	����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		
		//Ҫ���õ�����ֵ
		List<Object> list = new ArrayList<Object>();
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
            	  //���뵽������
            	  intoMess+=" and "+f.getName()+"=?";
            	//���뵽list
            	list.add(val);
              }
           }else{  
        	   if(val!=null){
             	  //���뵽������
        		  intoMess+=" and "+f.getName()+"=?";
        		 //���뵽list
            	  list.add(val);
               }
        	   
           }
		}
		
		//����Ҫע��Ĳ���
		Object[] params = new Object[list.size()];
		for (int i=0;i<list.size();i++) {
			params[i] = list.get(i);
		}
		//д��sql���
		String sql = "select * from "+pclazz.getSimpleName()+" where 1=1"+intoMess;
		System.out.println("fjUtils:  "+sql);
		List<T> newlist = qr.query(sql, new BeanListHandler<T>(pclazz), params);
		return newlist;
	}

	@Override
	public int addOne(T t) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
//		����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//�������Ҫ���õ�ֵ
		String intoField = "";
		//������ǵ�sqlֵ
		String intoMess = "";
		//Ҫ���õ�����ֵ
		List<Object> list = new ArrayList<Object>();
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
            	  //���뵽������
            	  if(!"id".equals(f.getName())){
            		  intoMess+=",?";
    	    		  intoField+=","+f.getName();
                	//���뵽list
                	list.add(val);
            	  }
	    		  
              }
           }else{  
        	   if(val!=null){
             	  //���뵽������
        		  intoMess+=",?";
        		  intoField+=(","+f.getName());
        		 //���뵽list
            	  list.add(val);
               }
           }
		}
		//sql������
		intoField+=")";
		intoMess+=")";
		Object[] params = new Object[list.size()];
		for (int i=0;i<list.size();i++) {
			params[i] = list.get(i);
		}
		//����Ҫע��Ĳ���
//		Object[] params = {user.getId(),user.getName(),user.getPassword(),
//				user.getTelePhone(),user.getUsername(),user.getIsAdmin()};
		//д��sql���
		//insert into users(id,name,password) values(mh_user.nextval,'fff','dsad');
		String sql = "insert into "+pclazz.getSimpleName()+" (id"+intoField+" values(mh_"+pclazz.getSimpleName()+".nextval"+intoMess;
		System.out.println("fjUtils:  "+sql);
		return qr.update(sql, params);
	}

}
