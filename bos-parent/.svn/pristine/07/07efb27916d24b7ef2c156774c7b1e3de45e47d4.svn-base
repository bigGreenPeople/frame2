package com.fj.bos.service;

import java.util.List;

import com.fj.bos.domain.Subarea;
import com.fj.bos.utils.PageBean;

public interface ISubareaService {
	//保存
	public void save(Subarea model);

	public void pageQuery(PageBean pageBean);
	//查询所有的分区
	public List<Subarea> findAll();
	//查询到还没有关联的分区
	public List<Subarea> findListNotAssociation();
	//依靠分区id查询所关联的所有定区
	public List<Subarea> findListByDecidedzoneId(String decidedzoneId);
}
