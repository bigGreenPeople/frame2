package com.fj.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fj.bos.dao.IFunctionDao;
import com.fj.bos.dao.base.impl.BaseDaoImpl;
import com.fj.bos.domain.Function;
@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao{
	
	public List<Function> findTopAll() {
		//查询所有的顶级节点
		String hql = "from Function where parentFunction is null";
		return (List<Function>) this.getHibernateTemplate().find(hql);
	}
}
