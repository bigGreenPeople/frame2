package com.fj.service;

import java.util.List;

import com.fj.domain.Student;
import com.fj.domain.User;

public interface UserService {
	//��¼
	public User login(User user);
//	ע��
	public void register(User user);
	//�һ�����
	public User reback(User user);

	
}
