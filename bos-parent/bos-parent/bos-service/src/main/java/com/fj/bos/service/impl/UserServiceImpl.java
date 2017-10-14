package com.fj.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IUserDao;
import com.fj.bos.domain.Role;
import com.fj.bos.domain.User;
import com.fj.bos.service.IUserService;
import com.fj.bos.utils.MD5Utils;
import com.fj.bos.utils.PageBean;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	//ע��dao
	@Autowired
	private IUserDao userDao;
	
	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}
	
	@Override
	public void save(User model, String[] roleIds) {
		//��������
		String password = model.getPassword();
		password = MD5Utils.md5(password);
		model.setPassword(password);
		//�ȱ���user
		userDao.save(model);
		//�����������
		for (String id: roleIds) {
			//��������̬���� 
			Role role = new Role();
			role.setId(id);
			//����
			model.getRoles().add(role);
		}
	}
	
	@Override
	public User login(User model) {
		// TODO Auto-generated method stub
		//ʹ��md5���������
		String password = MD5Utils.md5(model.getPassword());
		return userDao.findUserByUsernameAndPassword(model.getUsername(), password);
	}
	
	//�޸�����
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		//md5����
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}
	
}