package com.fj.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IUserDao;
import com.fj.bos.domain.User;
import com.fj.bos.service.IUserService;
import com.fj.bos.utils.MD5Utils;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	//注入dao
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User login(User model) {
		// TODO Auto-generated method stub
		//使用md5给密码加密
		String password = MD5Utils.md5(model.getPassword());
		return userDao.findUserByUsernameAndPassword(model.getUsername(), password);
	}
	
	//修改密码
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		//md5加密
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}
	
}
