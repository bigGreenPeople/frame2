package com.fj.bos.dao;

import com.fj.bos.dao.base.IBaseDao;
import com.fj.bos.domain.User;

public interface IUserDao extends IBaseDao<User>{
	//�����˺������¼
	public User findUserByUsernameAndPassword(String username,String password);
}
