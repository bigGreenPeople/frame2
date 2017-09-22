package com.fj.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.BigTypeDao;
import com.fj.dao.SmallTypeDao;
import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.domain.SmallType;
import com.fj.service.BigTypeService;
@Transactional
public class BigTypeServiceImp implements BigTypeService {
	//∂®“ÂDAO
	private BigTypeDao bigTypeDao;
	private SmallTypeDao smallTypeDao;
	
	@Override
	public PageBean<BigType> findAllBigType(PageBean<BigType> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return bigTypeDao.findPageBeanAll(pageBean);
	}
	
	@Override
	public PageBean<SmallType> findAllSmallType(PageBean<SmallType> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return smallTypeDao.findPageBeanAll(pageBean);
	}
	
	@Override
	public void deleteBigType(BigType bigType) throws Exception {
		// TODO Auto-generated method stub
		//BigType findById = bigTypeDao.findById(id);
		bigTypeDao.delete(bigType);
	}
	
	@Override
	public void deleteSmallType(SmallType smallType) throws Exception {
		// TODO Auto-generated method stub
		smallTypeDao.delete(smallType);
	}
	
	@Override
	public void addBigType(BigType bigType) throws Exception {
		// TODO Auto-generated method stub
		bigTypeDao.add(bigType);
	}
	
	@Override
	public List<BigType> findAllBigType() throws Exception {
		// TODO Auto-generated method stub
		return bigTypeDao.findAll();
	}
	
	@Override
	public List<SmallType> findAllSmallType() throws Exception {
		// TODO Auto-generated method stub
		return smallTypeDao.findAll();
	}
	
	@Override
	public void addSmallType(SmallType smallType) throws Exception {
		// TODO Auto-generated method stub
		smallTypeDao.add(smallType);
	}
	
	public void setBigTypeDao(BigTypeDao bigTypeDao) {
		this.bigTypeDao = bigTypeDao;
	}

	public void setSmallTypeDao(SmallTypeDao smallTypeDao) {
		this.smallTypeDao = smallTypeDao;
	}
	
	@Override
	public List<SmallType> findSmallTypesByCondition(SmallType smallType)
			throws Exception {
		// TODO Auto-generated method stub
		return smallTypeDao.findListByCondition(smallType);
	}
	
	@Override
	public BigType findBigTypeById(int id) throws Exception {
		// TODO Auto-generated method stub
		return bigTypeDao.findById(id);
	}
	
}
