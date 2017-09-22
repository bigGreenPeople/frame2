package com.fj.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.ManagerDao;
import com.fj.domain.Manager;
import com.fj.domain.PageBean;
import com.fj.service.ManagerService;
@Transactional
public class ManagerServiceImp implements ManagerService {
	private ManagerDao managerDao;
	
	@Override
	public void addManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		managerDao.add(manager);
	}
	
	@Override
	public void deleteManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		Manager findById = managerDao.findById(manager.getId());
		managerDao.delete(findById);
	}
	
	@Override
	public PageBean<Manager> findAllManager(PageBean<Manager> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return managerDao.findPageBeanAll(pageBean);
	}
	
	@Override
	public Manager login(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		return managerDao.findOneByCondition(manager);
	}
	
	@Override
	public void updatePass(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		managerDao.update(manager);
	}
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	

}
