package com.fj.service.Imp;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.List;

import oracle.net.aso.b;

import org.junit.Before;
import org.junit.Test;

import com.fj.dao.HouseDao;
import com.fj.dao.UserDao;
import com.fj.dao.Imp.HouseDaoImp;
import com.fj.dao.Imp.UserDaoImp;
import com.fj.domain.House;
import com.fj.domain.Users;

public class UserServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		//����һ���û�
		Users user = new Users();
		user.setId(5);
		user.setName("�����");
		user.setPassword("123");
		user.setTelePhone("1564564");
		user.setIsAdmin("N");
		user.setUsername("xxx");
		try {
			userServiceImpl.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void tt(){
		UserDao userDao = new UserDaoImp();
		HouseDao houseDao = new HouseDaoImp();
		Users bean = new Users(1, "��ffs��", "3221", "1223123", "������1", null);
		House house = new House();
		house.setId(2);
		house.setPrice(200);
		
		try {
			List<Users> num = userDao.findAll();
			//int num = houseDao.updateById(house,house.getId());
			System.out.println(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void ss() throws Exception{
		Users bean = new Users(1, "fujjie", "123", null, null, null);
		Class userCla = bean.getClass();
		Field[] fs = userCla.getDeclaredFields();  
		
	       for(int i = 0 ; i < fs.length; i++){
	           Field f = fs[i];  
	           f.setAccessible(true); //����Щ�����ǿ��Է��ʵ�  
	           Object val = f.get(bean);//�õ������Ե�ֵ     
	        
	           System.out.println("name:"+f.getName()+"\t value = "+val);  
	            
	           String type = f.getType().toString();//�õ������Ե�����  
	           if (type.endsWith("String")) {  
	              System.out.println(f.getType()+"\t��String");  
	              f.set(bean,"12") ;        //��������ֵ  
	           }else if(type.endsWith("int") || type.endsWith("Integer")){  
	              System.out.println(f.getType()+"\t��int");  
	              f.set(bean,12) ;       //��������ֵ  
	           }else{  
	              System.out.println(f.getType()+"\t");  
	           }  
       }  
	}
	
	@Test
	public void aa() throws Exception{
		Users bean = new Users(1, "fujjie", "123", null, null, null);
		Class userCla = bean.getClass();
		Field[] fs = userCla.getDeclaredFields();  
		
	       for(int i = 0 ; i < fs.length; i++){
	           Field f = fs[i];  
	           f.setAccessible(true); //����Щ�����ǿ��Է��ʵ�  
	           Object val = f.get(bean);//�õ������Ե�ֵ     
	        
	           System.out.println("name:"+f.getName()+"\t value = "+val);  
	            
	           String type = f.getType().toString();//�õ������Ե�����  
	           if (type.endsWith("String")) {  
	              System.out.println(f.getType()+"\t��String");  
	           }else if(type.endsWith("int") || type.endsWith("Integer")){  
	              System.out.println(f.getType()+"\t��int");  
	           }else{  
	              System.out.println(f.getType()+"\t");  
	           }  
       }  
	}
}
