package com.fj.dao.Imp;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.dbutils.handlers.columns.IntegerColumnHandler;

import com.fj.dao.BaseDao;
import com.fj.domain.PageBean;
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
	public PageBean<T> findPageByCondition(T t,PageBean<T> pageBean) throws Exception {
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
		//select t2.* from (select t1.*,rownum rn from (select * from users) t1 where rownum<=����λ��) t2 where rn>=��ʼλ��;
		//�����page�������Ϣ
		//��ѯ�õ��ܼ�¼��
		pageBean.setTotalCount(this.getCountByCondition(intoMess,params));
		//���㿪ʼλ��
		int begin = (pageBean.getCurrentPage()-1)*pageBean.getPageSize()+1;
		pageBean.setBegin(begin);
		//�������ҳ��
		int totalPage=pageBean.getTotalCount()%pageBean.getPageSize()==0?
				pageBean.getTotalCount()/pageBean.getPageSize():
					pageBean.getTotalCount()/pageBean.getPageSize()+1;
		pageBean.setTotalPage(totalPage);
		//���������λ��
		int end = pageBean.getCurrentPage()*pageBean.getPageSize();
		pageBean.setEnd(end);
		
		String sql = "select t2.* from "
				+ "(select t1.*,rownum rn from (select * from "+pclazz.getSimpleName()+" where 1=1"+intoMess+")"
						+ " t1 where rownum<="+pageBean.getEnd()+") t2 where rn>="+pageBean.getBegin();
		System.out.println("fjUtils:  "+sql);
		List<T> newlist = qr.query(sql, new BeanListHandler<T>(pclazz), params);
		//����list
		pageBean.setList(newlist);
		return pageBean;
	}
	
	@Override
	public PageBean<T> findPageAll(PageBean<T> pageBean) throws Exception {
		// TODO Auto-generated method stub
//		����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//�����page�������Ϣ
		//��ѯ�õ��ܼ�¼��
		pageBean.setTotalCount(this.getCount());
		//���㿪ʼλ��
		int begin = (pageBean.getCurrentPage()-1)*pageBean.getPageSize()+1;
		pageBean.setBegin(begin);
		//�������ҳ��
		int totalPage=pageBean.getTotalCount()%pageBean.getPageSize()==0?
				pageBean.getTotalCount()/pageBean.getPageSize():
					pageBean.getTotalCount()/pageBean.getPageSize()+1;
		pageBean.setTotalPage(totalPage);
		//���������λ��
		int end = pageBean.getCurrentPage()*pageBean.getPageSize();
		pageBean.setEnd(end);
		//д��sql���
		//String sql = "select * from "+pclazz.getSimpleName();
		String sql = "select t2.* from "
				+ "(select t1.*,rownum rn from (select * from "+pclazz.getSimpleName()+")"
						+ " t1 where rownum<="+pageBean.getEnd()+") t2 where rn>="+pageBean.getBegin();
		System.out.println("fjUtils:  "+sql);
		List<T> newlist = qr.query(sql, new BeanListHandler<T>(pclazz));
		//����list
		pageBean.setList(newlist);
		return pageBean;
	}
	
	@Override
	public Integer getCount() throws Exception {
		// TODO Auto-generated method stub
//		����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		//д��sql���
		String sql = "select count(*) as count from "+pclazz.getSimpleName();
		System.out.println(sql);
		Number ob =(Number) qr.query(sql, new ScalarHandler());
		
		return ob.intValue();
		
	}
	
	@Override
	public Integer getCountByCondition(String intoMess,Object[] params) throws Exception {
		// TODO Auto-generated method stub
//		����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		
		//д��sql���
		String sql = "select count(*) as count from "+pclazz.getSimpleName()+" where 1=1"+intoMess;
		System.out.println("fjutils:  "+sql);
		Number ob =(Number) qr.query(sql, new ScalarHandler(),params);
		
		return ob.intValue();
	}
	
	@Override
	public Integer getCountByCondition(String intoMess) throws Exception {
		// TODO Auto-generated method stub
//		����TxQueryRunner
		TxQueryRunner qr = new TxQueryRunner();
		
		//д��sql���
		String sql = "select count(*) as count from "+pclazz.getSimpleName()+" where 1=1"+intoMess;
		System.out.println("fjutils:  "+sql);
		Number ob =(Number) qr.query(sql, new ScalarHandler());
		
		return ob.intValue();
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
