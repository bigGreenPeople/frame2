package com.fj.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IWorkordermanageDao;
import com.fj.bos.domain.Workordermanage;
import com.fj.bos.service.IWorkordermanageService;

@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService{
	@Autowired
	private IWorkordermanageDao workordermanageDao;

	@Override
	public void save(Workordermanage model) {
		// TODO Auto-generated method stub
		workordermanageDao.save(model);
	}
	
	
}
