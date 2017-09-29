package com.fj.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fj.bos.domain.User;
import com.fj.bos.dao.IUserDao;
import com.fj.bos.dao.base.impl.BaseDaoImpl;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
	@Override
	public User findUserByUsernameAndPassword(String username,
			String password) {
		String hql = "from User u where u.username = ? and u.password = ?";
		 List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		 
		 if(list != null && list.size()>0){
			 return list.get(0);
		 }
		 
		return null;
	}
}
