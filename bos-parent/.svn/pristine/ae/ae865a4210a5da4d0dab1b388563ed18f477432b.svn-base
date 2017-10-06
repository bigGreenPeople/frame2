package com.fj.bos.service;

import java.util.List;

import com.fj.bos.domain.Staff;
import com.fj.bos.utils.PageBean;

public interface IStaffService {
	public void save(Staff model);
	//分页显示快递员信息
	public void pageQuery(PageBean pageBean);
	
	public void deleteBatch(String ids);
	
	public Staff findById(String id);
	public void update(Staff staff);
	//没有作废的所有快递员
	public List<Staff> findListNotDelete();
}
