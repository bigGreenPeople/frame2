package com.fj.service.Imp;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import com.fj.dao.UserDao;
import com.fj.dao.Imp.UserDaoImp;
import com.fj.domain.Users;
import com.fj.service.UserSevice;

public class UserServiceImpl implements UserSevice{
	
	private UserDao userDao;

	@Override
	public Users login(Users user) throws Exception {
		// TODO Auto-generated method stub
		userDao = new UserDaoImp();
		List<Users> list = userDao.findByCondition(user);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public int register(Users user) throws Exception {
		// TODO Auto-generated method stub
		userDao = new UserDaoImp();
		return userDao.addOne(user);
	}

}	
