package com.fj.bos.service;

import java.util.List;

import com.fj.bos.domain.Function;
import com.fj.bos.utils.PageBean;

public interface IFunctionService {
	//得到所有的权限
	public List<Function> findAll();

	public void save(Function model);

	public void pageQuery(PageBean pageBean);
	
}
