package com.fj.dao.imp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fj.dao.UserDao;
import com.fj.domain.Student;
import com.fj.domain.User;
import com.fj.utils.SQLHelper;

public class UserDaoImpl implements UserDao{

	//查找用户
	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USER WHERE uname=? AND upass=?";
		String[] parameters = {user.getUname(),user.getUpass()};

		ArrayList<Object[]> list = SQLHelper.executeQuery2(sql, parameters );
		//进行二次封装list里面是Object数组
		if(list!=null && list.size()>0){
			User loginUser = new User();
			
			Object[] ob = list.get(0);
			loginUser.setUid(ob[0].toString());
			loginUser.setUname(ob[1].toString());
			loginUser.setUpass(ob[2].toString());
			
			return loginUser;
		}
		
		return null;
	}

	//查询所有用户
	@Override
	public List<Student> findList() {
		// TODO Auto-generated method stub
		//定义好list
		ArrayList<Student> stuList = new ArrayList<Student>();
		String sql = "SELECT * FROM student";
		
		ArrayList<Object[]> list = SQLHelper.executeQuery2(sql, null);
		if(list!=null && list.size()>0){
			//二次封装
			for (Object[] ob : list) {
				Student student = new Student();
				
				student.setSid(ob[0].toString());
				student.setSname(ob[1].toString());
				student.setSsex(ob[2].toString());
				//转换Date
				Date date = (Date)ob[3];
				java.util.Date newDate = new java.util.Date(date.getTime());
				student.setSbirthday(newDate);
				student.setSmajor(ob[4]+"");
				student.setSscore(Integer.parseInt(ob[5].toString()));
				student.setStel(ob[6].toString());
				//添加到list
				stuList.add(student);
			}
			
		}
		return stuList;
	}
}
