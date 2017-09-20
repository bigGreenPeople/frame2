package com.fj.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.ManagerDao;
import com.fj.domain.Manager;
import com.fj.service.ManagerService;
@Transactional
public class ManagerServiceImp implements ManagerService {
	private ManagerDao managerDao;
	
	@Override
	public Manager login(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		return managerDao.findOneByCondition(manager);
	}
	
	
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	

}
