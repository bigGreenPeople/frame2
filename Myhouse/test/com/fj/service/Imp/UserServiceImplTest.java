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
		
		//创建一个用户
		Users user = new Users();
		user.setId(5);
		user.setName("付大杰");
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
		Users bean = new Users(1, "付ffs杰", "3221", "1223123", "鲨鱼辣1", null);
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
	           f.setAccessible(true); //设置些属性是可以访问的  
	           Object val = f.get(bean);//得到此属性的值     
	        
	           System.out.println("name:"+f.getName()+"\t value = "+val);  
	            
	           String type = f.getType().toString();//得到此属性的类型  
	           if (type.endsWith("String")) {  
	              System.out.println(f.getType()+"\t是String");  
	              f.set(bean,"12") ;        //给属性设值  
	           }else if(type.endsWith("int") || type.endsWith("Integer")){  
	              System.out.println(f.getType()+"\t是int");  
	              f.set(bean,12) ;       //给属性设值  
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
	           f.setAccessible(true); //设置些属性是可以访问的  
	           Object val = f.get(bean);//得到此属性的值     
	        
	           System.out.println("name:"+f.getName()+"\t value = "+val);  
	            
	           String type = f.getType().toString();//得到此属性的类型  
	           if (type.endsWith("String")) {  
	              System.out.println(f.getType()+"\t是String");  
	           }else if(type.endsWith("int") || type.endsWith("Integer")){  
	              System.out.println(f.getType()+"\t是int");  
	           }else{  
	              System.out.println(f.getType()+"\t");  
	           }  
       }  
	}
}
