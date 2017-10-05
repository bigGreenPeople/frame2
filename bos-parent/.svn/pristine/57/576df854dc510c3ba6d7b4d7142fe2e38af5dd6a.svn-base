package com.fj.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IRegionDao;
import com.fj.bos.domain.Region;
import com.fj.bos.service.IRegionService;
import com.fj.bos.utils.PageBean;
@Service
@Transactional
public class RegionServiceImpl implements IRegionService {
	@Autowired
	private IRegionDao regionDao;
	
	@Override
	public void saveBatch(List<Region> regionList) {
		// TODO Auto-generated method stub
		for (Region region : regionList) {
			regionDao.saveOrUpdate(region);
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		regionDao.pageQuery(pageBean);
	}

	@Override
	public List<Region> findAll() {
		// TODO Auto-generated method stub
		return regionDao.findAll();
	}

	@Override
	public List<Region> findListByQ(String q) {
		// TODO Auto-generated method stub
		return regionDao.findListByQ(q);
	}

}
