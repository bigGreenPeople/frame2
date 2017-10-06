package com.fj.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IStaffDao;
import com.fj.bos.domain.Staff;
import com.fj.bos.service.IStaffService;
import com.fj.bos.utils.PageBean;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	//注入dao
	@Autowired
	private IStaffDao staffDao;
	
	@Override
	public List<Staff> findListNotDelete() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		//设置查询的条件(查询到没有作废的快递员)
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		return staffDao.findByCriteria(detachedCriteria);
	}
	
	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.update(staff);
	}

	@Override
	public Staff findById(String id) {
		// TODO Auto-generated method stub
		return staffDao.findById(id);
	}
	
	@Override
	public void deleteBatch(String ids) {
		if(StringUtils.isNoneBlank(ids)){
			String[] staffIds = ids.split(",");
			for (String id : staffIds) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}
	
	@Override
	public void save(Staff model) {
		// TODO Auto-generated method stub
		staffDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		staffDao.pageQuery(pageBean);
	}
}
