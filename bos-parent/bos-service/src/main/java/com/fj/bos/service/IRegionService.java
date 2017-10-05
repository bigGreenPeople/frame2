package com.fj.bos.service;

import java.util.List;

import com.fj.bos.domain.Region;
import com.fj.bos.utils.PageBean;

public interface IRegionService {
//批量保存 
	public void saveBatch(List<Region> regionList);
	//分页查询
	public void pageQuery(PageBean pageBean);
	//查询所有区域
	public List<Region> findAll();
	//根据页面输入进行模糊查询
	public List<Region> findListByQ(String q);
}
