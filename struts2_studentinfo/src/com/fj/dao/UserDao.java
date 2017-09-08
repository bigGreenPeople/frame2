package com.fj.dao;

import java.util.List;

import com.fj.domain.Student;
import com.fj.domain.User;

public interface UserDao {
	//查找用户
	public User findUser(User user);
	//查询所有用户
	public List<Student> findList();
}
