package com.fj.dao;

import java.util.List;

import com.fj.domain.Student;
import com.fj.domain.User;

public interface UserDao {
	
	public User findUser(User user);
	//添加
	public void add(User user);
	//查找所有用户
	public User findList(User user);
}
