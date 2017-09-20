package com.fj.service;

import com.fj.domain.BigType;
import com.fj.domain.PageBean;

public interface BigTypeService {
	//分页查询所有的大类别
	public PageBean<BigType> findAllBigType(PageBean<BigType> pageBean) throws Exception;
}
