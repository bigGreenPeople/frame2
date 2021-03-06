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

	//注入dao
	@Autowired
	private IUserDao userDao;
	
	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}
	
	@Override
	public void save(User model, String[] roleIds) {
		//加密密码
		String password = model.getPassword();
		password = MD5Utils.md5(password);
		model.setPassword(password);
		//先保存user
		userDao.save(model);
		//关联保存对象
		for (String id: roleIds) {
			//创建游离态对象 
			Role role = new Role();
			role.setId(id);
			//关联
			model.getRoles().add(role);
		}
	}
	
	@Override
	public User login(User model) {
		// TODO Auto-generated method stub
		//使用md5给密码加密
		String password = MD5Utils.md5(model.getPassword());
		return userDao.findUserByUsernameAndPassword(model.getUsername(), password);
	}
	
	//修改密码
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		//md5加密
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}
	
}
