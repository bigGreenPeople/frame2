package com.fj.bos.dao;

import java.util.List;

import com.fj.bos.dao.base.IBaseDao;
import com.fj.bos.domain.Region;

public interface IRegionDao extends IBaseDao<Region>{
	public List<Region> findListByQ(String q);
}
