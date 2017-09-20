package com.fj.service.imp;

import com.fj.dao.BigTypeDao;
import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.service.BigTypeService;

public class BigTypeServiceImp implements BigTypeService {
	private BigTypeDao bigTypeDao;
	
	@Override
	public PageBean<BigType> findAllBigType(PageBean<BigType> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return bigTypeDao.findPageBeanAll(pageBean);
	}

	public void setBigTypeDao(BigTypeDao bigTypeDao) {
		this.bigTypeDao = bigTypeDao;
	}
	
	
	
}
