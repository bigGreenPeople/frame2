package com.fj.dao;

import java.util.List;

import com.fj.domain.Student;
import com.fj.domain.User;

public interface UserDao {
	//�����û�
	public User findUser(User user);
	//��ѯ�����û�
	public List<Student> findList();
}
