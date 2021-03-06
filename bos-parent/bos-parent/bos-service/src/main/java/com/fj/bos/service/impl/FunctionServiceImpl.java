package com.fj.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IFunctionDao;
import com.fj.bos.domain.Function;
import com.fj.bos.domain.User;
import com.fj.bos.service.IFunctionService;
import com.fj.bos.utils.BOSUtils;
import com.fj.bos.utils.PageBean;
@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService {
	//注入dao
	@Autowired
	private IFunctionDao functionDao;
	
	@Override
	public List<Function> findMenu() {
		List<Function> list = null;
		//得到登录的用户
		User user = BOSUtils.getLoginUser();
		//判断是否是付杰(拥有所有权限)
		if("fujie".equals(user.getUsername())){
			list = functionDao.findAllMenu();
		}else{
			list = functionDao.findMenuByUserId(user.getId());
		}
		return list;
	}
	
	public List<Function> findAll() {
		// TODO Auto-generated method stub
		return functionDao.findTopAll();
	}

	@Override
	public void save(Function model) {
		// TODO Auto-generated method stub
		String pid = model.getParentFunction().getId();
		if(pid!=null && pid.equals("")){
			model.setParentFunction(null);
		}
		functionDao.save(model);
	}
	
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		functionDao.pageQuery(pageBean);
	}
}
