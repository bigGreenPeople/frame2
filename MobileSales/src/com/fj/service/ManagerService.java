package com.fj.service;

import com.fj.domain.Manager;
import com.fj.domain.PageBean;

public interface ManagerService {
	//管理员登录
	public Manager login(Manager manager) throws Exception;
	//修改密码
	public void updatePass(Manager manager) throws Exception;
	//分页查询所有
	public PageBean<Manager> findAllManager(PageBean<Manager> pageBean) throws Exception;
	//添加管理员
	public void addManager(Manager manager) throws Exception;
	//删除管理员
	public void deleteManager(Manager manager) throws Exception;
}
