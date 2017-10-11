package com.fj.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fj.bos.dao.IRegionDao;
import com.fj.bos.dao.base.impl.BaseDaoImpl;
import com.fj.bos.domain.Region;
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements IRegionDao{
	public List<Region> findListByQ(String q) {
		//Æ´½Ó³öhql
		String hql = "FROM Region r WHERE r.shortcode LIKE ? "
				+ "	OR r.citycode LIKE ? OR r.province LIKE ? "
				+ "OR r.city LIKE ? OR r.district LIKE ?";
		@SuppressWarnings("unchecked")
		List<Region> list = (List<Region>) this.getHibernateTemplate().find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
		return list;
	}
}
