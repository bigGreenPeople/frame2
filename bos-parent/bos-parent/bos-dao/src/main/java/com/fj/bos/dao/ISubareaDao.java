package com.fj.bos.dao;

import java.util.List;

import com.fj.bos.dao.base.IBaseDao;
import com.fj.bos.domain.Subarea;

public interface ISubareaDao extends IBaseDao<Subarea>{

	public List<Object> findSubareasGroupByProvince();
	
}
