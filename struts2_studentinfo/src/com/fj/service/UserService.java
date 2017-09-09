package com.fj.service;

import java.util.List;

import com.fj.domain.Student;
import com.fj.domain.User;

public interface UserService {
	//µÇÂ¼
	public User login(User user);
//	×¢²á
	public void register(User user);
	//ÕÒ»ØÃÜÂë
	public User reback(User user);

	
}
