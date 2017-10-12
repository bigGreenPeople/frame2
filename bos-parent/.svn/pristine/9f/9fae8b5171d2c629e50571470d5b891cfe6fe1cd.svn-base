package com.fj.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IRoleDao;
import com.fj.bos.domain.Function;
import com.fj.bos.domain.Role;
import com.fj.bos.service.IRoleService;
import com.fj.bos.utils.PageBean;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	//注入dao
	@Autowired
	private IRoleDao roleDao;
	
	@Override
	public List<Role> finAll() {
		return roleDao.findAll();
	}
	
	@Override
	public void pageQuery(PageBean pageBean) {
		roleDao.pageQuery(pageBean);
	}
	
	@Override
	public void save(Role role, String functionIds) {
		//先保存RoleO(这个时候save将成为持久态)
		roleDao.save(role);
		//再保存关联关系
		if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			for (String id : fIds) {
				//先创建出来	使这个对象成为游离态
				Function function = new Function(id);
				//关联	事务一提交将会级联保存
				role.getFunctions().add(function);
			}
		}
	}

}
