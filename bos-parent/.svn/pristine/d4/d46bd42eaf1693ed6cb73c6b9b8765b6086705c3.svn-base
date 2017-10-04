package com.fj.bos.service.impl;

import org.apache.commons.lang3.StringUtils;
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
	//×¢Èëdao
	@Autowired
	private IStaffDao staffDao;
	
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
