package com.fj.service.imp;

import java.util.List;

import com.fj.dao.UserDao;
import com.fj.dao.imp.UserDaoImpl;
import com.fj.domain.Student;
import com.fj.domain.User;
import com.fj.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	//登录
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		//创建我们的dao对象
		userDao = new UserDaoImpl();
		return userDao.findList(user);
	}
	
	//注册
	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		userDao = new UserDaoImpl();
		userDao.add(user);
	}
	
	//找回密码
	@Override
	public User reback(User user) {
		// TODO Auto-generated method stub
		userDao = new UserDaoImpl();
		return userDao.findUser(user);
	}

}
