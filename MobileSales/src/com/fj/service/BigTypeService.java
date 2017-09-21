package com.fj.service;

import java.util.List;

import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.domain.SmallType;

public interface BigTypeService {
	//查询所有的大类别
	public List<BigType> findAllBigType() throws Exception;
	//查询所有的小类别
	public List<SmallType> findAllSmallType() throws Exception;
	//分页查询所有的大类别
	public PageBean<BigType> findAllBigType(PageBean<BigType> pageBean) throws Exception;
	//分页查询所有的小类别
	public PageBean<SmallType> findAllSmallType(PageBean<SmallType> pageBean) throws Exception;
	//添加大类别
	public void addBigType(BigType bigType) throws Exception;
	//添加小类别
	public void addSmallType(SmallType smallType) throws Exception;
	//删除大类别
	public void deleteBigType(BigType bigType) throws Exception;
	//删除小类别
	public void deleteSmallType(SmallType smallType) throws Exception;
}
