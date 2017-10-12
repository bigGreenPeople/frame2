package com.fj.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IFunctionDao;
import com.fj.bos.domain.Function;
import com.fj.bos.service.IFunctionService;
import com.fj.bos.utils.PageBean;
@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService {
	//×¢Èëdao
	@Autowired
	private IFunctionDao functionDao;
	
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
