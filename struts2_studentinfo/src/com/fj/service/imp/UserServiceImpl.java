package com.fj.service.imp;

import java.util.List;

import com.fj.dao.UserDao;
import com.fj.dao.imp.UserDaoImpl;
import com.fj.domain.Student;
import com.fj.domain.User;
import com.fj.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	//��¼
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		//�������ǵ�dao����
		userDao = new UserDaoImpl();
		return userDao.findUser(user);
	}

	//��ѯ����ѧ��
	@Override
	public List<Student> findAllStu() {
		// TODO Auto-generated method stub
		return userDao.findList();
	}
}
