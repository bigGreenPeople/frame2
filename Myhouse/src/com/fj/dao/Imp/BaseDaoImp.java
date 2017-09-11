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
	//泛型的实际类型
	private Class pclazz;
	
	@Override
	public List<T> findAll() throws SQLException {
		// TODO Auto-generated method stub
//		创建TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//写出sql语句
		String sql = "select * from "+pclazz.getSimpleName();
		System.out.println("fjUtils:  "+sql);
		List<T> newlist = qr.query(sql, new BeanListHandler<T>(pclazz));
		return newlist;
	}
	
	@Override
	public int updateById(T t,Integer id) throws Exception {
		// TODO Auto-generated method stub
//		创建TxQueryRunner
			TxQueryRunner qr = new TxQueryRunner();
			
			//要设置的属性值
			List<Object> list = new ArrayList<Object>();
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
	              if(val!=null && !"0".equals(val.toString()) && !"id".equals(f.getName())){
	            	  //加入到？里面
	            	  intoMess+=","+f.getName()+"=?";
	            	//加入到list
	            	list.add(val);
	              }
	           }else{  
	        	   if(val!=null){
	             	  //加入到？里面
	        		  intoMess+=","+f.getName()+"=?";
	        		 //加入到list
	            	  list.add(val);
	               }
	        	   
	           }
			}
			
			//设置要注入的参数
			Object[] params = new Object[list.size()];
			for (int i=0;i<list.size();i++) {
				params[i] = list.get(i);
			}
			//写出sql语句
			//update users set password=?,telephone=? where id=1;
			String sql = "update "+pclazz.getSimpleName()+" set id="+id+intoMess+" where id="+id;
			System.out.println("fjUtils:  "+sql);
			int num = qr.update(sql, params);
			return num;
	}
	
	@Override
	public int deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
//		创建TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//写出sql语句
		String sql = "delete from "+pclazz.getSimpleName()+" where id=?";
		System.out.println("fjUtils:  "+sql);
		//设置要注入的参数
		int num = qr.update(sql, id);
		return num;
	}
	
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

	@Override
	public T findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
//		创建TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//写出sql语句
		String sql = "select * from "+pclazz.getSimpleName()+" where id=?";
		//设置要注入的参数
		System.out.println("fjUtils:  "+sql);
		System.out.println("参数:" + id);
		T t = qr.query(sql, new BeanHandler<T>(pclazz), id);
		return t;
	}

	@Override
	public List<T> findByCondition(T t) throws Exception {
//	创建TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		
		//要设置的属性值
		List<Object> list = new ArrayList<Object>();
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
            	  //加入到？里面
            	  intoMess+=" and "+f.getName()+"=?";
            	//加入到list
            	list.add(val);
              }
           }else{  
        	   if(val!=null){
             	  //加入到？里面
        		  intoMess+=" and "+f.getName()+"=?";
        		 //加入到list
            	  list.add(val);
               }
        	   
           }
		}
		
		//设置要注入的参数
		Object[] params = new Object[list.size()];
		for (int i=0;i<list.size();i++) {
			params[i] = list.get(i);
		}
		//写出sql语句
		String sql = "select * from "+pclazz.getSimpleName()+" where 1=1"+intoMess;
		System.out.println("fjUtils:  "+sql);
		List<T> newlist = qr.query(sql, new BeanListHandler<T>(pclazz), params);
		return newlist;
	}

	@Override
	public int addOne(T t) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
//		创建TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//存放我们要设置的值
		String intoField = "";
		//存放我们的sql值
		String intoMess = "";
		//要设置的属性值
		List<Object> list = new ArrayList<Object>();
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
            	  //加入到？里面
            	  if(!"id".equals(f.getName())){
            		  intoMess+=",?";
    	    		  intoField+=","+f.getName();
                	//加入到list
                	list.add(val);
            	  }
	    		  
              }
           }else{  
        	   if(val!=null){
             	  //加入到？里面
        		  intoMess+=",?";
        		  intoField+=(","+f.getName());
        		 //加入到list
            	  list.add(val);
               }
           }
		}
		//sql语句完成
		intoField+=")";
		intoMess+=")";
		Object[] params = new Object[list.size()];
		for (int i=0;i<list.size();i++) {
			params[i] = list.get(i);
		}
		//设置要注入的参数
//		Object[] params = {user.getId(),user.getName(),user.getPassword(),
//				user.getTelePhone(),user.getUsername(),user.getIsAdmin()};
		//写出sql语句
		//insert into users(id,name,password) values(mh_user.nextval,'fff','dsad');
		String sql = "insert into "+pclazz.getSimpleName()+" (id"+intoField+" values(mh_"+pclazz.getSimpleName()+".nextval"+intoMess;
		System.out.println("fjUtils:  "+sql);
		return qr.update(sql, params);
	}

}
