package com.fj.service;

import com.fj.domain.Users;

public interface UserSevice {
	//��¼
	public Users login(Users user) throws Exception;
//	ע��
	public int register(Users user) throws Exception;
}
