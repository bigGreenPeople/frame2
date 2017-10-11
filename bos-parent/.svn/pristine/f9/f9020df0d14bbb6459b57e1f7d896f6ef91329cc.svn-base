package com.fj.bos.dao;

import com.fj.bos.dao.base.IBaseDao;
import com.fj.bos.domain.User;

public interface IUserDao extends IBaseDao<User>{
	//依靠账号密码登录
	public User findUserByUsernameAndPassword(String username,String password);
	//根据账号查询到用户
	public User findUserByUserName(String username);
}
