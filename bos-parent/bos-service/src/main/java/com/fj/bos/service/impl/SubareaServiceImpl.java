package com.fj.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.ISubareaDao;
import com.fj.bos.domain.Subarea;
import com.fj.bos.service.ISubareaService;
import com.fj.bos.utils.PageBean;

@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {
	@Autowired
	private ISubareaDao subareaDao;
	
	@Override
	public List<Subarea> findAll() {
		// TODO Auto-generated method stub
		return subareaDao.findAll();
	}
	
	@Override
	public List<Subarea> findListNotAssociation() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		//设置条件
		detachedCriteria.add(Restrictions.isNull("decidedzone"));
		
		return subareaDao.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<Subarea> findListByDecidedzoneId(String decidedzoneId) {
		//创建离线查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		//设置条件
		detachedCriteria.add(Restrictions.eq("decidedzone.id", decidedzoneId));
		return subareaDao.findByCriteria(detachedCriteria);
	}
	
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		subareaDao.pageQuery(pageBean);
	}
	
	@Override	
	public void save(Subarea model) {
		// TODO Auto-generated method stub
		subareaDao.save(model);
	}

}
