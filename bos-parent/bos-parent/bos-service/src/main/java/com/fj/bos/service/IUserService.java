package com.fj.bos.service;

import com.fj.bos.domain.User;
import com.fj.bos.utils.PageBean;

public interface IUserService {
	public User login(User model);
	//�޸�����
	public void editPassword(String id, String password);
	//����
	public void save(User model, String[] roleIds);
	public void pageQuery(PageBean pageBean);
}
