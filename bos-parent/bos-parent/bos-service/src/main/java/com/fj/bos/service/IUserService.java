package com.fj.bos.service;

import com.fj.bos.domain.User;

public interface IUserService {
	public User login(User model);
	//�޸�����
	public void editPassword(String id, String password);
}
