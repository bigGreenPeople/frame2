package com.fj.dao;

import java.util.List;

import com.fj.domain.Student;
import com.fj.domain.User;

public interface UserDao {
	
	public User findUser(User user);
	//���
	public void add(User user);
	//���������û�
	public User findList(User user);
}
