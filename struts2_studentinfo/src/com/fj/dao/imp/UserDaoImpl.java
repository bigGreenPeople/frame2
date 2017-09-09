package com.fj.dao.imp;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fj.dao.UserDao;
import com.fj.domain.Student;
import com.fj.domain.User;
import com.fj.utils.SQLHelper;

public class UserDaoImpl implements UserDao{

	//查找用户
	@Override
	public User findList(User user) {
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

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO user VALUES(?,?,?)";
		
		String[] parameters = {
				user.getUid(),user.getUname(),user.getUpass()
		};
		SQLHelper.executeUpdate(sql, parameters);
	}

	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USER WHERE uid=? AND uname=?";
		
		String[] parameters = {
				user.getUid(),user.getUname()
		};
		ArrayList<Object[]> list = SQLHelper.executeQuery2(sql, parameters);
		if(list!=null && list.size()>0){
			User findUser = new User();
			Object[] ob = list.get(0);
			
			findUser.setUid(ob[0].toString());
			findUser.setUname(ob[1].toString());
			findUser.setUpass(ob[2].toString());
			return findUser;
		}
		return null;
	}
}
