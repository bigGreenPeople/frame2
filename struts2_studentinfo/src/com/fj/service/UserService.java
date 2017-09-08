package com.fj.service;

import java.util.List;

import com.fj.domain.Student;
import com.fj.domain.User;

public interface UserService {
	//登录
	public User login(User user);
	//查询所有用户
	public List<Student> findAllStu();
	
}
