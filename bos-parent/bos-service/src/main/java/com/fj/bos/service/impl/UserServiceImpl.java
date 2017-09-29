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
	
}
