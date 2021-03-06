package com.fj.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fj.bos.dao.ISubareaDao;
import com.fj.bos.dao.base.impl.BaseDaoImpl;
import com.fj.bos.domain.Subarea;
@Repository
public class SubareaDaoImpl extends BaseDaoImpl<Subarea> implements ISubareaDao{
	public List<Object> findSubareasGroupByProvince() {
		String hql = "select r.province,count(*) from Subarea s left outer join s.region r group by r.province";
		return (List<Object>) this.getHibernateTemplate().find(hql);
	}
}
