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
	
	@Override
	public List<Function> findAllMenu() {
		String hql = "from Function f where f.generatemenu = '1' ORDER BY f.zindex DESC";
		return (List<Function>) this.getHibernateTemplate().find(hql);
	}
	
	@Override
	public List<Function> findMenuByUserId(String id) {
		String hql = "SELECT DISTINCT f from Function f  LIFT OUTER JOIN f.roles r  LIFT OUTER JOIN r.users u where u.id=? and f.generatemenu = '1' ORDER BY f.zindex DESC";
		return (List<Function>) this.getHibernateTemplate().find(hql,id);
	}
	
	@Override
	public List<Function> findFunctionListByUserId(String id) {
		String hql = "select DISTINCT f from Function f LIFT OUTER JOIN f.roles r LIFT OUTER JOIN r.users u where u.id=?";
		return (List<Function>) this.getHibernateTemplate().find(hql,id);
	}
}
